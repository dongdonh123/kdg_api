package com.kdg.api.controller.admin;



import com.kdg.api.model.BoardDTO;
import com.kdg.api.model.MenuDTO;
import com.kdg.api.model.OtherInformationDTO;
import com.kdg.api.model.RoleDTO;
import com.kdg.api.service.admin.RoleMenegementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/role")
public class RoleMenegementController {

    @Autowired
    private RoleMenegementService roleMenegementService;

    // 게시판 목록 조회 API
    @GetMapping
    public Object getRoleList(
            @RequestParam(value = "page_no", defaultValue = "1") int page_no,
            @RequestParam(value = "page_cnt", defaultValue = "50") int page_cnt,
            @RequestParam(value = "role_name", required = false) String role_name){

        try {
            // 기타정보처리
            OtherInformationDTO otherInformation_DTO_ = roleMenegementService.otherInformation(page_cnt);
            otherInformation_DTO_.setPage_no(page_no);
            otherInformation_DTO_.setPage_cnt(page_cnt);
            otherInformation_DTO_.setCurrent_page_data_min((page_no-1) * page_cnt +1);
            otherInformation_DTO_.setCurrent_page_data_max(page_no * page_cnt);

            // 페이지된 역할 리스트 가져오기
            page_no = (page_no-1) * page_cnt;
            List<RoleDTO> pagingRoleList = roleMenegementService.getRoleList(page_no, page_cnt, role_name);
            otherInformation_DTO_.setThis_page_row(pagingRoleList.size());

            // 응답 데이터 구성
            Object response = new Object() {
                public final List<RoleDTO> roleList = pagingRoleList;
                public final OtherInformationDTO otherInformation = otherInformation_DTO_;
            };
            return response;
        } catch (Exception e) {
            // 예외 처리: 오류 메시지와 함께 반환
            return new Object() {
                public final String error = "요청을 처리하는 동안 오류가 발생했습니다.";
                public final String details = e.getMessage();
            };
        }
    }

    // 메뉴데이터 상세보기
    @GetMapping("/{role_id}")
    public Object getRoleDetail(@PathVariable("role_id") Long roleId){
        try {
            RoleDTO roleDTODetail = roleMenegementService.getRoleDetail(roleId);

            // 응답 데이터 구성
            Object response = new Object() {
                public final RoleDTO roleDetail = roleDTODetail;
            };
            return response;

        } catch (Exception e) {
            // 예외 처리: 오류 메시지와 함께 반환
            return new Object() {
                public final String error = "요청을 처리하는 동안 오류가 발생했습니다.";
                public final String details = e.getMessage();
            };
        }
    }


}
