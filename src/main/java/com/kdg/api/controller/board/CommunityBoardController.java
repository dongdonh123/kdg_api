package com.kdg.api.controller.board;

import com.kdg.api.model.BoardDTO;
import com.kdg.api.model.OtherInformationDTO;
import com.kdg.api.service.board.CommunityBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/board")
public class CommunityBoardController {

    @Autowired
    private CommunityBoardService communityBoardService;

    // 게시판 목록 조회 API
    @GetMapping
    public Object getboardList(
            @RequestParam(value = "page_no", defaultValue = "1") int page_no,
            @RequestParam(value = "page_cnt", defaultValue = "50") int page_cnt){

        try {


            // 기타정보처리
            OtherInformationDTO otherInformation_DTO_ = communityBoardService.otherInformation(page_cnt);
            otherInformation_DTO_.setPage_no(page_no);
            otherInformation_DTO_.setPage_cnt(page_cnt);
            otherInformation_DTO_.setCurrent_page_data_min((page_no-1) * page_cnt +1);
            otherInformation_DTO_.setCurrent_page_data_max(page_no * page_cnt);

            // 페이지된 게시판 리스트 가져오기
            page_no = (page_no-1) * page_cnt;
            List<BoardDTO> pagingBoardDTOList = communityBoardService.getboardList(page_no, page_cnt);
            otherInformation_DTO_.setThis_page_row(pagingBoardDTOList.size());

            // 응답 데이터 구성
            Object response = new Object() {
                public final List<BoardDTO> boardList = pagingBoardDTOList;
                public final OtherInformationDTO otherInformation = otherInformation_DTO_;
            };

            return response;

        } catch (Exception e) {
            // 예외 처리: 오류 메시지와 함께 반환
            return new Object() {
                public final String error = "요청을 처리하는 동안 오류가 발생했습니다.";
                public final String details = e.getMessage();
            };
        }
    }

    //게시판 신규
    @PostMapping
    public ResponseEntity<String> insertBoard(@RequestBody BoardDTO boardDTO){
        try {
            // 게시판 정보 저장
            communityBoardService.insertBoard(boardDTO);
            return new ResponseEntity<>("게시글 저장 성공", HttpStatus.CREATED);
        } catch (Exception e) {
            // 오류 발생 시 응답
            return new ResponseEntity<>("게시글 저장 실패 : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //게시판 수정
    @PutMapping("/{board_id}")
    public ResponseEntity<String> updateBoard(@PathVariable("board_id") Long boardId, @RequestBody BoardDTO boardDTO) {
        try {
            // 게시판 정보 수정
            communityBoardService.updateBoard(boardId, boardDTO);
            return new ResponseEntity<>("게시글 수정 성공", HttpStatus.OK);
        } catch (Exception e) {
            // 오류 발생 시 응답
            return new ResponseEntity<>("게시글 수정 실패 : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //게시판 삭제
    @DeleteMapping("/{board_id}")
    public ResponseEntity<String> deleteBoard(@PathVariable("board_id") Long boardId) {
        try {
            communityBoardService.deleteBoard(boardId);
            return new ResponseEntity<>("게시글 삭제 성공", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("게시글 삭제 실패 : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 게시판 상세보기
    @GetMapping("/{board_id}")
    public Object getboardDetail(@PathVariable("board_id") Long boardId){
        try {
            BoardDTO boardDTODetail = communityBoardService.getBoardDetail(boardId);

            // 응답 데이터 구성
            Object response = new Object() {
                public final BoardDTO boardList = boardDTODetail;
            };
            return response;

        } catch (Exception e) {
            // 예외 처리: 오류 메시지와 함께 반환
            return new Object() {
                public final String error = "요청을 처리하는 동안 오류가 발생했습니다.";
                public final String details = e.getMessage();
            };
        }
    }





}


