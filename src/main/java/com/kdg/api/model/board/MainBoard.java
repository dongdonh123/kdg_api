package com.kdg.api.model.board;

import com.kdg.api.model.board.Board;

import java.util.List;
public class MainBoard {

    private List<Board> boardList;
    private int total_page;
    private int row_count;


    public MainBoard(List<Board> boardList, int total_page, int row_count) {
        this.boardList = boardList;
        this.total_page = total_page;
        this.row_count = row_count;
    }

    public List<Board> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<Board> boardList) {
        this.boardList = boardList;
    }

    public int getTotal_page() {
        return total_page;
    }

    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }

    public int getRow_count() {
        return row_count;
    }

    public void setRow_count(int row_count) {
        this.row_count = row_count;
    }

}