package com.kdg.api.mapper.admin;

import com.kdg.api.model.OtherInformationDTO;
import com.kdg.api.model.RoleDTO;
import com.kdg.api.model.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMenegementMapper {

    //역할 리스트 조회
    List<UserDTO> selectUserList(@Param("page_no") int page_no , @Param("page_cnt") int page_cnt, @Param("user_name") String user_name, @Param("user_account_id") String user_account_id);

    //역할 기타정보 조회
    OtherInformationDTO selectOtherInformation(@Param("page_cnt") int page_cnt , @Param("user_name") String user_name, @Param("user_account_id") String user_account_id);

    //역할 id조회
    Long  findUserId(Long user_id);

    //역할 상세조회
    UserDTO getUserDetail(Long user_id);


    // 신규 등록
    void insertUser(UserDTO userDTO);
    void insertRelUserRole(Long rel_user_role_id, Long user_id, Long role_id);

    // 수정 등록
    void updateUser(UserDTO userDTO);

    // 삭제
    void deleteUser(Long user_Id);

    //사용자 역할정보
    List<RoleDTO> relUserRoleSelect(Long user_id);

    void deleteRelUserRole(Long role_id);

    //비밀번호초기화
    void updateUserPasswdInit(Long user_id);

    // 사용자 사용여부 변경
    void updateUserUseY(Long user_id);

    // 사용자 사용여부 변경
    void updateUserUseN(Long user_id);

    //사용자 사용여부 가져오기
    String getUserUseYN(Long user_id);
}
