package com.kdg.api.service;

import com.kdg.api.mapper.LoginMapper;
import com.kdg.api.model.LoginDTO;
import com.kdg.api.model.UserDTO;
import com.kdg.config.CustomUsernameNotFoundException;
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
        //1. username이 DB에 있는지 확인하기
        UserDTO userDTO = loginMapper.findUserName(username);
//        //2. 있으면 LoginDTO에 넣기
        if(userDTO != null && userDTO.getUser_account_id() != null && !userDTO.getUser_account_id().isEmpty()) {
            return new LoginDTO(userDTO);
        }

        // 3. 사용자 ID가 존재하지 않을 경우 예외 던지기
        throw new CustomUsernameNotFoundException("입력한 ID가 존재하지 않습니다.");


    }
}
