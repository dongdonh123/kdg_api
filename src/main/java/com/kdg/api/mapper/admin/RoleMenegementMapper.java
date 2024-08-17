package com.kdg.api.mapper.admin;

import com.kdg.api.model.MenuDTO;
import com.kdg.api.model.OtherInformationDTO;
import com.kdg.api.model.RoleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMenegementMapper {

    //역할 리스트 조회
    List<RoleDTO> selectRoleList(@Param("page_no") int page_no , @Param("page_cnt") int page_cnt, @Param("role_name") String role_name);

    //역할 기타정보 조회
    OtherInformationDTO selectOtherInformation(@Param("page_cnt") int page_cnt);

    //역할 id조회
    Long  findRoleId(Long role_id);

    //역할 상세조회
    RoleDTO getRoleDetail(Long role_id);
}
