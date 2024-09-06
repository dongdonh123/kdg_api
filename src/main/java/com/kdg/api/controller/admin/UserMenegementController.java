package com.kdg.api.controller.admin;



import com.kdg.api.model.OtherInformationDTO;

import com.kdg.api.model.RoleDTO;
import com.kdg.api.model.UserDTO;
import com.kdg.api.service.admin.UserMenegementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/admin/user")
public class UserMenegementController {

    @Autowired
    private UserMenegementService userMenegementService;

    // 사용자 목록 조회 API
    @GetMapping
    public Object getUserList(
            @RequestParam(value = "page_no", defaultValue = "1") int page_no,
            @RequestParam(value = "page_cnt", defaultValue = "50") int page_cnt,
            @RequestParam(value = "user_name", required = false) String user_name,
            @RequestParam(value = "user_account_id", required = false) String user_account_id){

        try {
            // 기타정보처리
            OtherInformationDTO otherInformation_DTO_ = userMenegementService.otherInformation(page_cnt,user_name,user_account_id);
            otherInformation_DTO_.setPage_no(page_no);
            otherInformation_DTO_.setPage_cnt(page_cnt);
            otherInformation_DTO_.setCurrent_page_data_min((page_no-1) * page_cnt +1);
            otherInformation_DTO_.setCurrent_page_data_max(page_no * page_cnt);

            // 페이지된 사용자 리스트 가져오기
            page_no = (page_no-1) * page_cnt;
            List<UserDTO> pagingUserList = userMenegementService.getUserList(page_no, page_cnt, user_name,user_account_id);
            otherInformation_DTO_.setThis_page_row(pagingUserList.size());

            // 응답 데이터 구성
            Object response = new Object() {
                public final List<UserDTO> userList = pagingUserList;
                public final OtherInformationDTO otherInformation = otherInformation_DTO_;
            };
            return response;
        } catch (Exception e) {
            // 예외 처리: 오류 메시지와 함께 반환
            return new Object() {
                public final String resultmessage = "요청을 처리하는 동안 오류가 발생했습니다."+ e.getMessage();
            };
        }
    }

    // 사용자 상세보기
    @GetMapping("/{user_id}")
    public Object getUserDetail(@PathVariable("user_id") Long userId){
        try {
            UserDTO userDTODetail = userMenegementService.getUserDetail(userId);
            List<RoleDTO> relUserRoleList_ = userMenegementService.getRelUserRoleList(userId);


            // 응답 데이터 구성
            Object response = new Object() {
                public final UserDTO userDetail = userDTODetail;
                public final List<RoleDTO> relUserRoleList = relUserRoleList_;
            };
            return response;

        } catch (Exception e) {
            // 예외 처리: 오류 메시지와 함께 반환
            return new Object() {
                public final String resultmessage = "요청을 처리하는 동안 오류가 발생했습니다."+ e.getMessage();
            };
        }
    }

    //신규등록
    @PostMapping
    public Object insertUser(@RequestBody UserDTO userDTO){
        try {
            // 메뉴데이터 저장
            userMenegementService.insertUser(userDTO);
            // 응답 데이터 구성
            Object response = new Object() {
                public final String resultmessage = "사용자을 신규 등록 했습니다";
            };
            return response;
        } catch (Exception e) {
            // 오류 발생 시 응답
            return new Object() {
                public final String resultmessage = "요청을 처리하는 동안 오류가 발생했습니다."+ e.getMessage();
            };
        }
    }

    //수정
    @PutMapping("/{user_id}")
    public Object updateUser(@PathVariable("user_id") Long user_id, @RequestBody UserDTO userDTO) {
        try {
            // 게시판 정보 수정
            userDTO.setUser_id((long) user_id.intValue());
            userMenegementService.updateUser(user_id,userDTO);
            Object response = new Object() {
                public final String resultmessage = "사용자을 수정 등록 했습니다";
            };
            return response;
        } catch (Exception e) {
            return new Object() {
                public final String resultmessage = "요청을 처리하는 동안 오류가 발생했습니다."+ e.getMessage();
            };
        }
    }

    //삭제
    @DeleteMapping("/{user_id}")
    public Object deleteUser(@PathVariable("user_id") Long user_id) {
        try {
            userMenegementService.deleteUser(user_id);
            Object response = new Object() {
                public final String resultmessage = "사용자을 삭제 했습니다";
            };
            return response;
        } catch (Exception e) {
            return new Object() {
                public final String resultmessage = "요청을 처리하는 동안 오류가 발생했습니다."+ e.getMessage();
            };
        }
    }

    //비밀번호 초기화
    @PatchMapping("/passwdinit/{user_id}")
    public Object updateUserPasswd(@PathVariable("user_id") Long user_id) {
        try {
            // 비밀번호 초기화
            userMenegementService.updateUserPasswdInit(user_id);
            Object response = new Object() {
                public final String resultmessage = "사용자 비밀번호 초기화 했습니다";
            };
            return response;
        } catch (Exception e) {
            return new Object() {
                public final String resultmessage = "요청을 처리하는 동안 오류가 발생했습니다."+ e.getMessage();
            };
        }
    }

    //사용 or 사용정지
    @PatchMapping("/useyn/{user_id}")
    public Object updateUserUseYN(@PathVariable("user_id") Long user_id) {
        try {
            userMenegementService.updateUserUseYN(user_id);
            Object response = new Object() {
                public final String resultmessage = "사용자 사용여부를 변경 했습니다";
            };
            return response;
        } catch (Exception e) {
            return new Object() {
                public final String resultmessage = "요청을 처리하는 동안 오류가 발생했습니다."+ e.getMessage();
            };
        }
    }




}
