package com.kdg.api.service.board;

import com.kdg.api.mapper.board.CommunityBoardMapper;
import com.kdg.api.model.board.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityBoardService {

    private final CommunityBoardMapper communityBoardMapper;

    @Autowired
    public CommunityBoardService(CommunityBoardMapper communityBoardMapper){this.communityBoardMapper =communityBoardMapper; }

    public List<Board> getboardList(int page_no,int page_cnt) {

        return communityBoardMapper.selectBoardList(page_no, page_cnt);
    }

    public List<Board> getboardpageInfoList(int page_cnt) {

        return communityBoardMapper.selectBoardPageInfo(page_cnt);
    }

}
