package com.kdg.api.service.board;

import com.kdg.api.mapper.board.CommunityBoardMapper;
import com.kdg.api.model.board.Board;
import com.kdg.api.model.otherInformation.OtherInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityBoardService {

    private final CommunityBoardMapper communityBoardMapper;



    @Autowired
    public CommunityBoardService(CommunityBoardMapper communityBoardMapper){this.communityBoardMapper =communityBoardMapper; }

    //리스트데이터
    public List<Board> getboardList(int page_no,int page_cnt) {

        return communityBoardMapper.selectBoardList(page_no, page_cnt);
    }

    //기타정보데이터
    public OtherInformation otherInformation(int page_cnt) {

        return communityBoardMapper.selectOtherInformation(page_cnt);
    }


}
