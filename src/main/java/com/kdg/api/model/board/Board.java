package com.kdg.api.model.board;

public class Board {

    private int seq;
    private int board_id;

    // 기본 생성자
    public  Board() {
    }

    //생성자
    public Board(int seq, int board_id) {
        this.seq = seq;
        this.board_id = board_id;
    }

    // Getters & Setters
    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getBoard_id() {return board_id;}

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }




}
