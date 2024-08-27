package com.kdg.api.service.admin;

import com.kdg.api.mapper.admin.UserMenegementMapper;
import com.kdg.api.model.OtherInformationDTO;
import com.kdg.api.model.RoleDTO;
import com.kdg.api.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserMenegementService {

    private final UserMenegementMapper userMenegementMapper;

    @Autowired
    public UserMenegementService(UserMenegementMapper userMenegementMapper){this.userMenegementMapper =userMenegementMapper; }

    //리스트데이터
    public List<UserDTO> getUserList(int page_no, int page_cnt, String user_name, String user_account_id) {
        return userMenegementMapper.selectUserList(page_no, page_cnt, user_name, user_account_id);
    }

    //기타정보데이터 (리스트데이터)
    public OtherInformationDTO otherInformation(int page_cnt, String user_name, String user_account_id) {
        return userMenegementMapper.selectOtherInformation(page_cnt, user_name, user_account_id);
    }

    //사용자 상세조회
    public UserDTO getUserDetail(Long userId) {
        if (userMenegementMapper.findUserId(userId) == null) {
            throw new IllegalArgumentException("UserId를 찾을 수 없습니다. ID: " + userId);
        }
        return userMenegementMapper.getUserDetail(userId);
    }

    //사용자 신규
    public void insertUser(UserDTO userDTO) {
        userMenegementMapper.insertUser(userDTO);
        for(int i =0; i < userDTO.getRel_user_role().size(); i++) {
            userMenegementMapper.insertRelUserRole(userId,userDTO.getRel_user_role().get(i));
        }
    }

    //사용자 수정
    public void updateUser(Long userId, UserDTO userDTO) {
        if (userMenegementMapper.findUserId(userId) == null) {
            throw new IllegalArgumentException("UserId를 찾을 수 없습니다. ID: " + userId);
        }
        userMenegementMapper.updateUser(userDTO);
        for(int i =0; i < userDTO.getRel_user_role().size(); i++) {
//            userMenegementMapper.deleteRelUserRole(userId,userDTO.getRel_user_role().get(i));
//            userMenegementMapper.insertRelUserRole(userId,userDTO.getRel_user_role().get(i));
        }
    }

    //삭제
    public void deleteUser(Long userId) {
        if (userMenegementMapper.findUserId(userId) == null) {
            throw new IllegalArgumentException("UserId를 찾을 수 없습니다. ID: " + userId);
        }
        userMenegementMapper.deleteUser(userId);
    }

    //사용자 역할 조회
    public List<RoleDTO> getRelUserRoleList(Long userId) {
        if (userMenegementMapper.findUserId(userId) == null) {
            throw new IllegalArgumentException("UserId를 찾을 수 없습니다. ID: " + userId);
        }
        return userMenegementMapper.relUserRoleSelect(userId);

    }



}
