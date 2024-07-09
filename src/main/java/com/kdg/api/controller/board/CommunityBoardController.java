package com.kdg.api.controller.board;

import com.kdg.api.model.board.Board;
import com.kdg.api.model.otherInformation.OtherInformation;
import com.kdg.api.service.board.CommunityBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CommunityBoardController {

    @Autowired
    private CommunityBoardService communityBoardService;

    // 게시판 목록 조회 API
    @GetMapping("/board")
    public Object getboardList(int page_no, int page_cnt){

        //기타정보처리
        OtherInformation otherInformation = communityBoardService.otherInformation(page_cnt);
        otherInformation.setPage_no(page_no);
        otherInformation.setPage_cnt(page_cnt);


        //페이지된 게시판 리스트 가져오기
        page_no = page_no * page_cnt;
        List<Board> pagingBoardList = communityBoardService.getboardList(page_no,page_cnt);
        otherInformation.setThis_page_row(pagingBoardList.size());

        // 응답 데이터 구성
        Object response = new Object() {
            public final List<Board> boardList = pagingBoardList;

            public final OtherInformation otherInformation_ = otherInformation;
        };

        return response;
    }

}
