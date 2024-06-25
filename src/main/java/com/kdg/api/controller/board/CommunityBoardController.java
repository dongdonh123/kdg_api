package com.kdg.api.controller.board;

import com.kdg.api.model.board.Board;
import com.kdg.api.service.board.CommunityBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CommunityBoardController {

    @Autowired
    private CommunityBoardService communityBoardService;

    @GetMapping("/boardList")
    public List<Board> getboardList(@RequestParam(defaultValue = "1") int page){

        return communityBoardService.getboardList(page);
    }

}
