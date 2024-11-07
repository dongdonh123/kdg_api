package com.kdg.api.service.admin;

import com.kdg.api.mapper.admin.UserMenegementMapper;
import com.kdg.api.mapper.common.CommonMapper;
import com.kdg.api.model.OtherInformationDTO;
import com.kdg.api.model.RoleDTO;
import com.kdg.api.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;

@Service
public class UserMenegementService {

    private final UserMenegementMapper userMenegementMapper;
    private final CommonMapper commonMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserMenegementService(UserMenegementMapper userMenegementMapper, CommonMapper commonMapper, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userMenegementMapper =userMenegementMapper;
        this.commonMapper = commonMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

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
        String table_nm = "tb_user_mgt";
        commonMapper.updateMaxId(table_nm); // maxid 올리기
        Long max_id = commonMapper.findMaxId(table_nm); // maxid 가져오기
        userDTO.setUser_id(max_id);
        userMenegementMapper.insertUser(userDTO);
        //사용자-역할 관계 데이터 넣기
        for(int i =0; i < userDTO.getRel_user_roleID().size(); i++) {
            String table_nm2 = "tb_rel_user_role";
            Long user_id = userDTO.getUser_id();
            commonMapper.updateMaxId(table_nm2); // maxid 올리기
            Long rel_user_role_id = commonMapper.findMaxId(table_nm2); // maxid 가져오기
            userMenegementMapper.insertRelUserRole(rel_user_role_id,user_id,userDTO.getRel_user_roleID().get(i));
        }
    }

    //사용자 수정
    public void updateUser(Long userId, UserDTO userDTO) {
        if (userMenegementMapper.findUserId(userId) == null) {
            throw new IllegalArgumentException("UserId를 찾을 수 없습니다. ID: " + userId);
        }
        //사용자 정보 수정
        userMenegementMapper.updateUser(userDTO);
        //사용자 역할 정보 삭제
        userMenegementMapper.deleteRelUserRole(userId);
        //사용자 역할 정보 입력
        for(int i =0; i < userDTO.getRel_user_roleID().size(); i++) {
            String table_nm = "tb_rel_user_role";
            Long user_id = userDTO.getUser_id();
            commonMapper.updateMaxId(table_nm); // maxid 올리기
            Long rel_user_role_id = commonMapper.findMaxId(table_nm); // maxid 가져오기
            userMenegementMapper.insertRelUserRole(rel_user_role_id,user_id,userDTO.getRel_user_roleID().get(i));
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

    // 패스워드 초기화
    public void updateUserPasswdInit(Long userId) {
        if (userMenegementMapper.findUserId(userId) == null) {
            throw new IllegalArgumentException("UserId를 찾을 수 없습니다. ID: " + userId);
        }
        //사용자 정보 수정
        userMenegementMapper.updateUserPasswdInit(userId);
    }

    // 사용자 사용여부 변경
    public void updateUserUseYN(Long userId) {
        if (userMenegementMapper.findUserId(userId) == null) {
            throw new IllegalArgumentException("UserId를 찾을 수 없습니다. ID: " + userId);
        }
        //사용자 기존의 사용여부 가져오기
        String use_yn = userMenegementMapper.getUserUseYN(userId);
        if(use_yn.equals("Y")){userMenegementMapper.updateUserUseN(userId);}
        else if(use_yn.equals("N")){userMenegementMapper.updateUserUseY(userId);}


    }

    //사용자 패스워드 설정
    public void changePassword(Long userId, String password, String user_account_id) {

        // 1. ID와 username이 일치하는지 확인
        if (userMenegementMapper.verificationUserId(userId).equals(user_account_id)) {
            throw new IllegalArgumentException("검증오류로 인해 패스워드재설정을 실패했습니다. user_id와 user_account_id가 다릅니다.");
        }
        // 2. password 암호화해서 업데이트하기
        String encryption_password = bCryptPasswordEncoder.encode(password);
        userMenegementMapper.changePassword(userId,userDTO);
    }









}
