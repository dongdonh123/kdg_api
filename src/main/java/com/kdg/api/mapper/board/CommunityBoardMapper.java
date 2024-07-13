package com.kdg.api.mapper.board;

import com.kdg.api.model.board.Board;
import com.kdg.api.model.otherInformation.OtherInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommunityBoardMapper {

    //게시판 리스트 조회
    List<Board> selectBoardList(@Param("page_no") int page_no , @Param("page_cnt") int page_cnt);

    //게시판 기타정보 조회
    OtherInformation selectOtherInformation(@Param("page_cnt") int page_cnt);

    //게시판 수정시 검증(board_id가 있는지)
    void insertBoard(Board board);

    //게시판 수정시 검증(board_id에 맞는 정 있는지)
    void insertBoard(Board board);





}
