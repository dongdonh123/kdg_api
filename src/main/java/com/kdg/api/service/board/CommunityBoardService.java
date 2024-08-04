package com.kdg.api.service.board;

import com.kdg.api.mapper.board.CommunityBoardMapper;
import com.kdg.api.model.BoardDTO;
import com.kdg.api.model.OtherInformationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityBoardService {

    private final CommunityBoardMapper communityBoardMapper;



    @Autowired
    public CommunityBoardService(CommunityBoardMapper communityBoardMapper){this.communityBoardMapper =communityBoardMapper; }

    //리스트데이터
    public List<BoardDTO> getboardList(int page_no, int page_cnt) {
        return communityBoardMapper.selectBoardList(page_no, page_cnt);
    }

    //기타정보데이터 (리스트데이터)
    public OtherInformationDTO otherInformation(int page_cnt) {
        return communityBoardMapper.selectOtherInformation(page_cnt);
    }

    //게시판 신규
    public void insertBoard(BoardDTO boardDTO) {
        communityBoardMapper.insertBoard(boardDTO);
    }

    //게시판 수정
    public void updateBoard(Long boardId, BoardDTO boardDTO) {
        if (communityBoardMapper.findBoardId(boardId) == null) {
            throw new IllegalArgumentException("게시글을 찾을 수 없습니다. ID: " + boardId);
        }
        communityBoardMapper.updateBoard(boardDTO);
    }

    //게시판 삭제
    public void deleteBoard(Long boardId) {
        if (communityBoardMapper.findBoardId(boardId) == null) {
            throw new IllegalArgumentException("게시글을 찾을 수 없습니다. ID: " + boardId);
        }
        communityBoardMapper.deleteBoard(boardId);
    }

    //게시판 상세조회
    public BoardDTO getBoardDetail(Long boardId) {
        if (communityBoardMapper.findBoardId(boardId) == null) {
            throw new IllegalArgumentException("게시글을 찾을 수 없습니다. ID: " + boardId);
        }
        return communityBoardMapper.getBoardDetail(boardId);
    }






}
