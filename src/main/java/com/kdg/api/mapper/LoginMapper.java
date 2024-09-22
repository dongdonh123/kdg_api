package com.kdg.api.mapper;

import com.kdg.api.model.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    UserDTO findUserName(String username);

    void updateFailedAttempts(String username);
    Long selectFailedAttempts(String username);
}
