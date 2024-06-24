package com.kdg.api.mapper.board;


import com.kdg.api.model.board.BoardList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardList> selectBoardList(@Param("page") int page);
}
