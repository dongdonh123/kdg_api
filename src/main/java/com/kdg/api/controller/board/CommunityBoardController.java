package com.kdg.api.controller.board;

import com.kdg.api.model.board.Board;
import com.kdg.api.model.board.MainBoard;
import com.kdg.api.service.board.CommunityBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CommunityBoardController {

    @Autowired
    private CommunityBoardService communityBoardService;

    @GetMapping("/boardlist")
    public MainBoard getboardList(int page_no, int page_cnt){

        page_no = page_no * page_cnt;
        List<Board> boardList = communityBoardService.getboardList(page_no,page_cnt);

        List<Board> boardpageInfoList = communityBoardService.getboardpageInfoList(page_cnt);
        System.out.println(boardpageInfoList.toString());


        int totalPage = 0;
        int rowcount = 0;

        if (!boardpageInfoList.isEmpty()) {
            Board board = boardpageInfoList.get(0);
            totalPage = board.getTotal_page();
            rowcount = board.getRow_count();
            System.out.println("Total Page of the 0th Board: " + totalPage);
        } else {
            System.out.println("The list is empty.");
        }

        MainBoard response = new MainBoard(boardList,totalPage,rowcount);

        return response;
    }

}
