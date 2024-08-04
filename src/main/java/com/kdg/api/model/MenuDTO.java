package com.kdg.api.model;

import java.util.Date;

public class MenuDTO {

    private int menu_id;
    private String menu_code;
    private String menu_name;
    private int menu_seq;
    private int org_menu_id;
    private String use_yn;
    private String menu_url;
    private Date create_dt;
    private String create_user;
    private Date modify_dt;
    private String modify_user;

    // 생성자
    public MenuDTO() {
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public void setMenu_code(String menu_code) {
        this.menu_code = menu_code;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public void setMenu_seq(int menu_seq) {
        this.menu_seq = menu_seq;
    }

    public void setOrg_menu_id(int org_menu_id) {
        this.org_menu_id = org_menu_id;
    }

    public void setUse_yn(String use_yn) {
        this.use_yn = use_yn;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public void setCreate_dt(Date create_dt) {
        this.create_dt = create_dt;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public void setModify_dt(Date modify_dt) {
        this.modify_dt = modify_dt;
    }

    public void setModify_user(String modify_user) {
        this.modify_user = modify_user;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public String getMenu_code() {
        return menu_code;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public int getMenu_seq() {
        return menu_seq;
    }

    public int getOrg_menu_id() {
        return org_menu_id;
    }

    public String getUse_yn() {
        return use_yn;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public Date getCreate_dt() {
        return create_dt;
    }

    public String getCreate_user() {
        return create_user;
    }

    public Date getModify_dt() {
        return modify_dt;
    }

    public String getModify_user() {
        return modify_user;
    }
}
