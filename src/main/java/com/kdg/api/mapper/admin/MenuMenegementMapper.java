package com.kdg.api.mapper.admin;


import com.kdg.api.model.BoardDTO;
import com.kdg.api.model.MenuDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMenegementMapper {


    List<MenuDTO> selectUpMenuList();

    List<MenuDTO> selectDownMenuList();

    //신규등록
    void insertMenuData(MenuDTO menuDTO);

    void updateMenuData(MenuDTO menuDTO);

    //메뉴데이터id조회
    Long  findMenuId(Long menu_Id);

    //메뉴데이터 삭제
    void deleteMenuData(Long menu_Id);

    //메뉴데이터 상세조회
    MenuDTO getMenuDetail(Long menuId);


}
