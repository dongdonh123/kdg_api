package com.kdg.api.mapper.board;

import com.kdg.api.model.BoardDTO;
import com.kdg.api.model.OtherInformationDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommunityBoardMapper {

    //게시판 리스트 조회
    List<BoardDTO> selectBoardList(@Param("page_no") int page_no , @Param("page_cnt") int page_cnt);

    //게시판 기타정보 조회
    OtherInformationDTO selectOtherInformation(@Param("page_cnt") int page_cnt);

    //게시판 신규
    void insertBoard(BoardDTO boardDTO);

    //게시판 id 조회
    Long  findBoardId(Long boardId);

    //게시판 수정
    void updateBoard(BoardDTO boardDTO);

    //게시판 삭제
    void deleteBoard(Long boardId);

    //게시판 상세조회
    BoardDTO getBoardDetail(Long boardId);





}
