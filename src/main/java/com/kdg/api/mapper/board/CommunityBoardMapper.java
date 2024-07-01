package com.kdg.api.mapper.board;

import com.kdg.api.model.board.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommunityBoardMapper {

    List<Board> selectBoardList(@Param("page_no") int page_no , @Param("page_cnt") int page_cnt);

    List<Board> selectBoardPageInfo(@Param("page_cnt") int page_cnt);

}