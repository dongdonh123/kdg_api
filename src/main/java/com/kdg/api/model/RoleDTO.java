package com.kdg.api.model;

import java.util.Date;

public class RoleDTO {

    private int role_id;
    private String role_code;
    private String role_name;
    private String meta_use_yn;
    private Date create_dt;
    private String create_user;
    private Date modify_dt;
    private String modify_user;

    // 기본 생성자
    public RoleDTO() {
    }

    // 생성자
    public RoleDTO(int role_id, String role_code, String role_name, String meta_use_yn, Date create_dt, String create_user, Date modify_dt, String modify_user) {
        this.role_id = role_id;
        this.role_code = role_code;
        this.role_name = role_name;
        this.meta_use_yn = meta_use_yn;
        this.create_dt = create_dt;
        this.create_user = create_user;
        this.modify_dt = modify_dt;
        this.modify_user = modify_user;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public void setRole_code(String role_code) {
        this.role_code = role_code;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public void setMeta_use_yn(String meta_use_yn) {
        this.meta_use_yn = meta_use_yn;
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

    public String getModify_user() {
        return modify_user;
    }

    public Date getModify_dt() {
        return modify_dt;
    }

    public String getCreate_user() {
        return create_user;
    }

    public Date getCreate_dt() {
        return create_dt;
    }

    public String getMeta_use_yn() {
        return meta_use_yn;
    }

    public String getRole_name() {
        return role_name;
    }

    public String getRole_code() {
        return role_code;
    }

    public int getRole_id() {
        return role_id;
    }
}
