package com.kdg.api.mapper.admin;


import com.kdg.api.model.MenuDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMenegementMapper {


    List<MenuDTO> selectUpMenuList();

    List<MenuDTO> selectDownMenuList();

}
