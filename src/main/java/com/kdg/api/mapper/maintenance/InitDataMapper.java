package com.kdg.api.mapper.maintenance;

import com.kdg.api.model.BoardDTO;
import com.kdg.api.model.InitDataDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InitDataMapper {

    //초기화 데이터 id 조회
    Long findInitDataId(Long menu_id);

    //초기화 데이터 상세조회
    InitDataDTO getInitDataDetail(Long menu_id);

    Long getcurrentCNT(String table_id);
}
