package com.kdg.api.mapper.board;

import com.kdg.api.model.board.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommunityBoardMapper {

    List<Board> selectBoardList(@Param("page") int page);

}
