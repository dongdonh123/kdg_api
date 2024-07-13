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

    //기타정보데이터 (리스트데이터)
    public OtherInformation otherInformation(int page_cnt) {
        return communityBoardMapper.selectOtherInformation(page_cnt);
    }

    //게시판 신규
    public void insertBoard(Board board) {
        communityBoardMapper.insertBoard(board);
    }

    //게시판 수정
    public void updateBoard(Long boardId, Board board) {
        // 게시판id가 있는지 봐서 id가 없으면 board아이디가 없다고 해라
        Board existingBoard = communityBoardMapper.findBoardById(boardId);
        if (existingBoard == null) {
            throw new RuntimeException("Board not found with id: " + boardId);
        }
        // 게시판id가 맞지만 수정하려는거가 맞는지 확인해라 (id만 안다고 처리하면 안됨)
        board.setId(boardId);
        boardMapper.updateBoard(board);
    }




}
