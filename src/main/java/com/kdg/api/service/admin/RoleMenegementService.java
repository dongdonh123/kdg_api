package com.kdg.api.service.admin;

import com.kdg.api.mapper.admin.RoleMenegementMapper;
import com.kdg.api.mapper.common.CommonMapper;
import com.kdg.api.model.MenuDTO;
import com.kdg.api.model.OtherInformationDTO;
import com.kdg.api.model.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMenegementService {

    private final RoleMenegementMapper roleMenegementMapper;
    private final CommonMapper commonMapper;

    @Autowired
    public RoleMenegementService(RoleMenegementMapper roleMenegementMapper, CommonMapper commonMapper){
        this.roleMenegementMapper =roleMenegementMapper;
        this.commonMapper = commonMapper;
    }

    //리스트데이터
    public List<RoleDTO> getRoleList(int page_no, int page_cnt, String role_name) {
        return roleMenegementMapper.selectRoleList(page_no, page_cnt, role_name);
    }

    //기타정보데이터 (리스트데이터)
    public OtherInformationDTO otherInformation(int page_cnt, String role_name) {
        return roleMenegementMapper.selectOtherInformation(page_cnt, role_name);
    }

    //역할 상세조회
    public RoleDTO getRoleDetail(Long roleId) {
        if (roleMenegementMapper.findRoleId(roleId) == null) {
            throw new IllegalArgumentException("RoleId를 찾을 수 없습니다. ID: " + roleId);
        }
        return roleMenegementMapper.getRoleDetail(roleId);
    }

    //역할 신규
    public void insertRole(RoleDTO roleDTO) {
        String table_nm = "tb_role_mgt";
        commonMapper.updateMaxId(table_nm); // maxid 올리기
        Long max_id = commonMapper.findMaxId(table_nm); // maxid 가져오기
        roleDTO.setRole_id(max_id);
        roleMenegementMapper.insertRole(roleDTO);
    }

    //역할 수정
    public void updateRole(Long roleId, RoleDTO roleDTO) {
        if (roleMenegementMapper.findRoleId(roleId) == null) {
            throw new IllegalArgumentException("RoleId를 찾을 수 없습니다. ID: " + roleId);
        }
        roleMenegementMapper.updateRole(roleDTO);
    }

    //삭제
    public void deleteRole(Long roleId) {
        if (roleMenegementMapper.findRoleId(roleId) == null) {
            throw new IllegalArgumentException("RoleId를 찾을 수 없습니다. ID: " + roleId);
        }
        roleMenegementMapper.deleteRole(roleId);
    }



}
