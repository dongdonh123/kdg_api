package com.kdg.api.mapper.common;

import com.kdg.api.model.BoardDTO;
import com.kdg.api.model.OtherInformationDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommonMapper {


    //테이블의 maxID값 올리기
    void  updateMaxId(String table_nm);

    //테이블의 maxID값 가져오기
    Long  findMaxId(String table_nm);




}
