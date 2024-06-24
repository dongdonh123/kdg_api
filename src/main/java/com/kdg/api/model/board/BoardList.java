package com.kdg.api.model.board;

public class BoardList {

    private int seq;

    // 기본 생성자
    public BoardList() {
    }


    public BoardList( int seq) {

        this.seq = seq;

    }

    // Getters & Setters
    public int getSeq() {
        return seq;
    }

}
