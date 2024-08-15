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

    //현재 데이터수
    Long getcurrentCNT(String table_id);

    //초기화ID로 테이블명 찾기
    String findInitDataTable(Long init_id);

    //메뉴데이터 삭제
    Long deleteMenuData(String table_Id);

    //초기화ID로 init_SQL 찾기
    String findInitDataInsertSQL(Long init_id);

    //메뉴데이터 초기화(생성)
    Long insertMenuData(String init_sql);
}
