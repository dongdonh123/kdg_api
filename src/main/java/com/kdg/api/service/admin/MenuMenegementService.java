package com.kdg.api.service.admin;

import com.kdg.api.mapper.admin.MenuMenegementMapper;
import com.kdg.api.mapper.board.CommunityBoardMapper;
import com.kdg.api.model.BoardDTO;
import com.kdg.api.model.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuMenegementService {

    private final MenuMenegementMapper menuMenegementMapper;

    @Autowired
    public MenuMenegementService(MenuMenegementMapper menuMenegementMapper){this.menuMenegementMapper =menuMenegementMapper; }

    //리스트데이터
    public List<MenuDTO> getUpmenuList() {
        return menuMenegementMapper.selectUpMenuList();
    }

    public List<MenuDTO> getDownmenuList() {
        return menuMenegementMapper.selectDownMenuList();
    }

}
