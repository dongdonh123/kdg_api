package com.kdg.api.controller.board;

import com.kdg.api.model.board.BoardList;
import com.kdg.api.service.board.CommunityBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class CommunityBoardController {

    @Autowired
    private CommunityBoardService communityBoardService;

    @GetMapping("/boardlist")
    public List<BoardList> getcodeList(@RequestParam(defaultValue = "1") int page){

        return communityBoardService.getboardList(page);
    }
}
