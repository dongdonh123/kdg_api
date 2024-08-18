package com.kdg.api.controller.maintenance;


import com.kdg.api.model.InitDataDTO;
import com.kdg.api.model.MenuDTO;
import com.kdg.api.service.maintenance.ResetDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/maintenance/resetdata")
public class ResetDataController {

    @Autowired
    private ResetDataService resetDataService;

    // 메뉴데이터 상세보기
    @GetMapping("/{menu_id}")
    public Object getInitDataDetail(@PathVariable("menu_id") Long menu_id){
        try {

            InitDataDTO initDataDTODetail = resetDataService.getInitDataDetail(menu_id);
            Long current_cnt_ = resetDataService.getcurrentCNT(initDataDTODetail.getTable_id());

            // 응답 데이터 구성
            Object response = new Object() {
                public final InitDataDTO initDataDetail = initDataDTODetail;
                public final Long current_cnt = current_cnt_;
            };
            return response;

        } catch (Exception e) {
            // 예외 처리: 오류 메시지와 함께 반환
            return new Object() {
                public final String details = "요청을 처리하는 동안 오류가 발생했습니다."+ e.getMessage();
            };
        }
    }

    //메뉴의 데이터 삭제
    @DeleteMapping("/{menu_id}")
    public Object deleteMenuData(@PathVariable("menu_id") Long menu_id) {
        try {
            Long delete_ctn_ = resetDataService.deleteMenuData(menu_id);

            // 응답 데이터 구성
            Object response = new Object() {
                public final String details = "메뉴 데이터 " + delete_ctn_ +"건이 정상적으로 삭제 됐습니다.";
            };
            return response;
        } catch (Exception e) {
            // 예외 처리: 오류 메시지와 함께 반환
            return new Object() {
                public final String details = "요청을 처리하는 동안 오류가 발생했습니다."+ e.getMessage();
            };
        }
    }

    //메뉴의 데이터 삭제
    @PutMapping("/{menu_id}")
    public Object resetMenuData(@PathVariable("menu_id") Long menu_id) {
        try {
            Long delete_ctn_ = resetDataService.deleteMenuData(menu_id);
            Long insert_ctn_ = resetDataService.insertMenuData(menu_id);

            // 응답 데이터 구성
            Object response = new Object() {
                public final String details = "메뉴 데이터 " + delete_ctn_ +"건이 삭제 후 "+insert_ctn_+"건이 정상적으로 insert 됐습니다";
            };
            return response;
        } catch (Exception e) {
            // 예외 처리: 오류 메시지와 함께 반환
            return new Object() {
                public final String details = "요청을 처리하는 동안 오류가 발생했습니다."+ e.getMessage();
            };
        }
    }


}
