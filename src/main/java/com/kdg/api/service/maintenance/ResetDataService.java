package com.kdg.api.service.maintenance;

import com.kdg.api.mapper.board.CommunityBoardMapper;
import com.kdg.api.mapper.maintenance.InitDataMapper;
import com.kdg.api.model.BoardDTO;
import com.kdg.api.model.InitDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

@Service
public class ResetDataService {

    private static final Logger logger = LoggerFactory.getLogger(ResetDataService.class);
    private final InitDataMapper initDataMapper;

    @Autowired
    public ResetDataService(InitDataMapper initDataMapper){this.initDataMapper =initDataMapper; }

    //상세조회
    public InitDataDTO getInitDataDetail(Long menu_id) {
        if (initDataMapper.findInitDataId(menu_id) == null) {
            String errorMessage = "초기화 ID를 찾을 수 없습니다. ID: " + menu_id;
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        return initDataMapper.getInitDataDetail(menu_id);
    }

    //현재 데이터 개수
    public Long getcurrentCNT(String table_id) {

        return initDataMapper.getcurrentCNT(table_id);
    }

    //삭제
    public Long deleteMenuData(Long menu_id) {
        // 1. 메뉴ID로 초기화ID찾기
        Long init_id = initDataMapper.findInitDataId(menu_id);
        if (init_id == null) {
            String errorMessage = "메뉴ID에 맞는 초기화 ID를 찾을 수 없습니다. init_id : " + init_id;
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        logger.debug("1.초기화 ID 찾기 성공 init_id: " + init_id);

        // 2. Init_ID로 대상테이블 찾기
        String table_id = initDataMapper.findInitDataTable(init_id);
        if (table_id == null) {
            String errorMessage = "초기화ID에 맞는 테이블을 찾을 수 없습니다. 테이블명: " + table_id;
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        logger.debug("2. 테이블명 찾기 성공 table_id: " + table_id);

        //3.
        Long delte_ctn = initDataMapper.deleteMenuData(table_id);
        logger.debug("3. 해당 테이블 delete 완료 ");
        return delte_ctn;
    }

    //insert
    public Long insertMenuData(Long menu_id) {
        // 1. 메뉴ID로 초기화ID찾기
        Long init_id = initDataMapper.findInitDataId(menu_id);
        if (init_id == null) {
            String errorMessage = "메뉴ID에 맞는 초기화 ID를 찾을 수 없습니다. init_id : " + init_id;
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        logger.debug("1.초기화 ID 찾기 성공 init_id: " + init_id);

        // 2. Init_ID로 insert SQL 찾기
        String init_sql = initDataMapper.findInitDataInsertSQL(init_id);
        if (init_sql == null) {
            String errorMessage = "초기화ID의 insert SQL을 찾을 수 없습니다. init_sql: " + init_sql;
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        logger.debug("2. insert SQL 찾기 성공 init_sql: " + init_sql);

        //3.
        Long insert_ctn = initDataMapper.insertMenuData(init_sql);
        logger.debug("3. 해당 테이블 insert 완료 ");
        System.out.println(insert_ctn);
        return insert_ctn;
    }



}
