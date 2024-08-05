package com.kdg.api.controller.admin;


import com.kdg.api.model.BoardDTO;
import com.kdg.api.model.MenuDTO;
import com.kdg.api.model.MenuTreeDTO;
import com.kdg.api.service.admin.MenuMenegementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin/menuMenegement")
public class MenuMenegementController {

    @Autowired
    private MenuMenegementService menuMenegementService;

    // 게시판 목록 조회 API
    @GetMapping
    public Object getmenuList(){

        try {
            // 상위 메뉴 가져오기
            List<MenuDTO> upMenuList_ = menuMenegementService.getUpmenuList();
            // 하위 메뉴 가져오기
            List<MenuDTO> downMenuList_ = menuMenegementService.getDownmenuList();

            //상위메뉴안에 하위메뉴 넣기
            List<MenuTreeDTO> menuTreeList_ = new ArrayList();

            // 상위 메뉴를 MenuTreeDTO로 변환
            for (MenuDTO upMenu : upMenuList_) {
                // 하위 메뉴를 MenuTreeDTO로 변환하여 상위 메뉴에 추가
                List<Integer> intList = new ArrayList<>();
                List<String> stringList = new ArrayList<>();
                for (MenuDTO downMenu : downMenuList_) {
                    if (downMenu.getOrg_menu_id() == upMenu.getMenu_id()) {
                        intList.add(downMenu.getMenu_id());
                        stringList.add(downMenu.getMenu_name());
                    }
                }
                MenuTreeDTO menuTree = new MenuTreeDTO(upMenu.getMenu_id(), upMenu.getMenu_name(),intList,stringList);
                menuTreeList_.add(menuTree);
            }

            // 응답 데이터 구성
            Object response = new Object() {
                public final List<MenuTreeDTO> menuTreeList = menuTreeList_;
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

    //신규등록
    @PostMapping
    public ResponseEntity<String> insertMenuData(@RequestBody MenuDTO menuDTO){
        try {
            System.out.println("zzz");
            // 메뉴데이터 저장
            menuMenegementService.insertMenuData(menuDTO);
            return new ResponseEntity<>("메뉴관리 저장 성공", HttpStatus.CREATED);
        } catch (Exception e) {
            // 오류 발생 시 응답
            return new ResponseEntity<>("메뉴관리 저장 실패 : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //삭제
    @DeleteMapping("/{menu_id}")
    public ResponseEntity<String> deleteMenuData(@PathVariable("menu_id") Long menu_id) {
        try {
            menuMenegementService.deleteMenuData(menu_id);
            return new ResponseEntity<>("게시글 삭제 성공", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("게시글 삭제 실패 : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
