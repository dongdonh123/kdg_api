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



}
