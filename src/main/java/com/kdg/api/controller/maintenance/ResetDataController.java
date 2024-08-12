package com.kdg.api.controller.maintenance;


import com.kdg.api.model.InitDataDTO;
import com.kdg.api.model.MenuDTO;
import com.kdg.api.service.maintenance.ResetDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                public final String error = "요청을 처리하는 동안 오류가 발생했습니다.";
                public final String details = e.getMessage();
            };
        }
    }


}
