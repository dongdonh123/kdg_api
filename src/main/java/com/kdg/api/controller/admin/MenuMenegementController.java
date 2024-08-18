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

    // 메뉴 목록 조회 API
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
    public Object insertMenuData(@RequestBody MenuDTO menuDTO){
        try {
            // 메뉴데이터 저장
            menuMenegementService.insertMenuData(menuDTO);
            // 응답 데이터 구성
            Object response = new Object() {
                public final String resultmessage = "메뉴를 신규 등록 했습니다";
            };
            return response;
        } catch (Exception e) {
            // 오류 발생 시 응답
            return new Object() {
                public final String resultmessage = "요청을 처리하는 동안 오류가 발생했습니다."+ e.getMessage();
            };
        }
    }

    //메뉴 수정
    @PutMapping("/{menu_id}")
    public Object updateMenu(@PathVariable("menu_id") Long menuId, @RequestBody MenuDTO menuDTO) {
        try {
            // 게시판 정보 수정
            menuDTO.setMenu_id(menuId.intValue());
            menuMenegementService.updateMenuData(menuId, menuDTO);
            // 응답 데이터 구성
            Object response = new Object() {
                public final String resultmessage = "메뉴를 수정 등록 했습니다";
            };
            return response;
        } catch (Exception e) {
            // 오류 발생 시 응답
            return new Object() {
                public final String resultmessage = "요청을 처리하는 동안 오류가 발생했습니다."+ e.getMessage();
            };
        }
    }

    //삭제
    @DeleteMapping("/{menu_id}")
    public Object deleteMenuData(@PathVariable("menu_id") Long menu_id) {
        try {
            menuMenegementService.deleteMenuData(menu_id);
            // 응답 데이터 구성
            Object response = new Object() {
                public final String resultmessage = "메뉴를 삭제 했습니다";
            };
            return response;
        } catch (Exception e) {
            return new Object() {
                public final String resultmessage = "요청을 처리하는 동안 오류가 발생했습니다."+ e.getMessage();
            };
        }
    }

    // 메뉴데이터 상세보기
    @GetMapping("/{menu_id}")
    public Object getMenuDetail(@PathVariable("menu_id") Long boardId){
        try {
            MenuDTO menuDTODetail = menuMenegementService.getMenuDetail(boardId);

            // 응답 데이터 구성
            Object response = new Object() {
                public final MenuDTO menuDetail = menuDTODetail;
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
