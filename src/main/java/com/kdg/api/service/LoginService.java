package com.kdg.api.service;

import com.kdg.api.mapper.LoginMapper;
import com.kdg.api.model.LoginDTO;
import com.kdg.api.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

    private final LoginMapper loginMapper;

    @Autowired
    public LoginService(LoginMapper loginMapper){
        this.loginMapper = loginMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username)  {

        System.out.println("Login STEP2 : 로그인서비스");
        //1. username이 DB에 있는지 확인하기
        UserDTO userDTO = loginMapper.findUserName(username);
//        //2. 있으면 LoginDTO에 넣기
        if(userDTO != null && userDTO.getUser_account_id() != null && !userDTO.getUser_account_id().isEmpty()) {
            return new LoginDTO(userDTO);
        }
        System.out.println("1");
        throw new UsernameNotFoundException("입력한 ID는 존재하지 않습니다.");
        //return new LoginDTO(userDTO);

    }
}
