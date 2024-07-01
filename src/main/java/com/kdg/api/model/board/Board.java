package com.kdg.api.model.board;

import java.util.Date;

public class Board {

    private int board_id;
    private int class_id;
    private String board_title;
    private String board_contents;
    private Date modify_dt;
    private String modify_user;
    private Date create_dt;
    private String create_user;

    // 기본 생성자
    public Board() {
    }

    // 생성자
    public Board(int board_id, int class_id, String board_title, String board_contents, Date modify_dt, String modify_user, Date create_dt, String create_user) {
        this.board_id = board_id;
        this.class_id = class_id;
        this.board_title = board_title;
        this.board_contents = board_contents;
        this.modify_dt = modify_dt;
        this.modify_user = modify_user;
        this.create_dt = create_dt;
        this.create_user = create_user;
    }

    // Getter & Setter
    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getBoard_title() {
        return board_title;
    }

    public void setBoard_title(String board_title) {
        this.board_title = board_title;
    }

    public String getBoard_contents() {
        return board_contents;
    }

    public void setBoard_contents(String board_contents) {
        this.board_contents = board_contents;
    }

    public Date getModify_dt() {
        return modify_dt;
    }

    public void setModify_dt(Date modify_dt) {
        this.modify_dt = modify_dt;
    }

    public String getModify_user() {
        return modify_user;
    }

    public void setModify_user(String modify_user) {
        this.modify_user = modify_user;
    }

    public Date getCreate_dt() {
        return create_dt;
    }

    public void setCreate_dt(Date create_dt) {
        this.create_dt = create_dt;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }




}
