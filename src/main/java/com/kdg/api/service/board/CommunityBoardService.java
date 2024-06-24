package com.kdg.api.service.board;

import com.kdg.api.mapper.board.BoardMapper;
import com.kdg.api.model.board.BoardList;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommunityBoardService {

    private  final BoardMapper boardMapper;

    @Autowired
    public CommunityBoardService(BoardMapper boardMapper) {this.boardMapper = boardMapper;}

    public List<BoardList> getboardList(int page) {
        return boardMapper.selectBoardList(page);
    }
}
