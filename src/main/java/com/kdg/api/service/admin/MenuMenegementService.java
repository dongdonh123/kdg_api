package com.kdg.api.service.admin;

import com.kdg.api.mapper.admin.MenuMenegementMapper;
import com.kdg.api.mapper.board.CommunityBoardMapper;
import com.kdg.api.mapper.common.CommonMapper;
import com.kdg.api.model.BoardDTO;
import com.kdg.api.model.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuMenegementService {

    private final MenuMenegementMapper menuMenegementMapper;
    private final CommonMapper commonMapper;

    @Autowired
    public MenuMenegementService(MenuMenegementMapper menuMenegementMapper, CommonMapper commonMapper){
        this.menuMenegementMapper =menuMenegementMapper;
        this.commonMapper = commonMapper;
    }

    //리스트데이터
    public List<MenuDTO> getUpmenuList() { return menuMenegementMapper.selectUpMenuList();}

    public List<MenuDTO> getDownmenuList() {
        return menuMenegementMapper.selectDownMenuList();
    }

    //신규
    public void insertMenuData(MenuDTO menuDTO) {
        String table_nm = "tb_menu_mgt";
        commonMapper.updateMaxId(table_nm); // maxid 올리기
        Long max_id = commonMapper.findMaxId(table_nm); // maxid 가져오기
        menuDTO.setMenu_id(max_id);
        menuMenegementMapper.insertMenuData(menuDTO);
    }

    //메뉴 수정
    public void updateMenuData(Long menuId, MenuDTO menuDTO) {
        if (menuMenegementMapper.findMenuId(menuId) == null) {
            throw new IllegalArgumentException("메뉴 ID를 찾을 수 없습니다. ID: " + menuId);
        }
        menuMenegementMapper.updateMenuData(menuDTO);
    }

    //삭제
    public void deleteMenuData(Long boardId) {
        if (menuMenegementMapper.findMenuId(boardId) == null) {
            throw new IllegalArgumentException("메뉴ID를 찾을 수 없습니다. ID: " + boardId);
        }
        menuMenegementMapper.deleteMenuData(boardId);
    }

    //메뉴 상세조회
    public MenuDTO getMenuDetail(Long menuId) {
        if (menuMenegementMapper.findMenuId(menuId) == null) {
            throw new IllegalArgumentException("MenuId를 찾을 수 없습니다. ID: " + menuId);
        }
        return menuMenegementMapper.getMenuDetail(menuId);
    }

}
