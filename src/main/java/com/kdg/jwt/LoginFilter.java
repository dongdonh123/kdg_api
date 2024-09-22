package com.kdg.jwt;

import com.kdg.api.mapper.LoginMapper;
import com.kdg.api.model.LoginDTO;
import com.kdg.config.CustomUsernameNotFoundException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {



    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;
    private final LoginMapper loginMapper;



    public LoginFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil, LoginMapper loginMapper) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.loginMapper = loginMapper;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {


        //클라이언트 요청에서 username, password 추출
        String username = obtainUsername(request);
        String password = obtainPassword(request);

        System.out.println(username + password);

        //스프링 시큐리티에서 username과 password를 검증하기 위해서는 token에 담아야 함
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password, null);

        //token에 담은 검증을 위한 AuthenticationManager로 전달
        return authenticationManager.authenticate(authToken);
    }

    //로그인 성공시 실행하는 메소드 (여기서 JWT를 발급하면 됨)
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException {

        //UserDetailsS
        LoginDTO loginDTO = (LoginDTO) authentication.getPrincipal();

        String username = loginDTO.getUsername();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        GrantedAuthority auth = iterator.next();

        String role = auth.getAuthority();



        String token = jwtUtil.createJwt(username, role, 60*60*1000L); // 60*60*1000L = 1시간

        // 헤더에 JWT 토큰 추가
        response.addHeader("Authorization", "Bearer " + token);

        // JSON 형식의 성공 메시지를 바디에 작성
        response.setContentType("application/json; charset=UTF-8"); // UTF-8 설정
        response.getWriter().write("{\"status\": 200, \"message\": \"로그인 성공\"}");
    }

    //로그인 실패시 실행하는 메소드
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json; charset=UTF-8");

        String message;

        // 사용자 ID 가져오기 (요청에서)
        String username = request.getParameter("username"); // 실제 사용자의 ID가 어떻게 전달되는지에 따라 조정

        // 사용자 정의 예외 체크
        if (failed.getCause() instanceof CustomUsernameNotFoundException) {
            message = "입력한 ID가 존재하지 않습니다."; // 사용자 ID가 없을 때의 메시지
        }else if(failed instanceof BadCredentialsException){

            // 패스워드 틀린 횟수 업데이트 로직
            Long cnt = updateFailedLoginAttempts(username);
            message = "입력한 PASSWD가 맞지 않습니다 패스워드 틀린 횟수 : " + cnt +"회"; // 사용자 PASSWD가 틀릴때의 메세지
        } else {
            message = "로그인 실패"; // 일반적인 로그인 실패 메시지
        }

        response.getWriter().write("{\"status\": " + response.getStatus() + ", \"message\": \"" + message + "\"}");
    }

    private Long updateFailedLoginAttempts(String username) {
        // 여기서 username으로 DB에 접근하여 패스워드 틀린 횟수를 업데이트하는 로직 작성
        loginMapper.updateFailedAttempts(username);
        return loginMapper.selectFailedAttempts(username);
    }


}