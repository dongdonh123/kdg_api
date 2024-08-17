package com.kdg.api.service.admin;

import com.kdg.api.mapper.admin.RoleMenegementMapper;
import com.kdg.api.model.MenuDTO;
import com.kdg.api.model.OtherInformationDTO;
import com.kdg.api.model.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMenegementService {

    private final RoleMenegementMapper roleMenegementMapper;

    @Autowired
    public RoleMenegementService(RoleMenegementMapper roleMenegementMapper){this.roleMenegementMapper =roleMenegementMapper; }

    //리스트데이터
    public List<RoleDTO> getRoleList(int page_no, int page_cnt, String role_name) {
        return roleMenegementMapper.selectRoleList(page_no, page_cnt, role_name);
    }

    //기타정보데이터 (리스트데이터)
    public OtherInformationDTO otherInformation(int page_cnt) {
        return roleMenegementMapper.selectOtherInformation(page_cnt);
    }

    //역할 상세조회
    public RoleDTO getRoleDetail(Long roleId) {
        if (roleMenegementMapper.findRoleId(roleId) == null) {
            throw new IllegalArgumentException("RoleId를 찾을 수 없습니다. ID: " + roleId);
        }
        return roleMenegementMapper.getRoleDetail(roleId);
    }



}
