package com.kdg.api.model;

import java.util.Date;
import java.util.List;

public class UserDTO {

    private Long user_id;
    private String user_name;
    private String user_account_id;
    private String user_passwd;
    private String user_passwd_fail_cnt;
    private String user_use_yn;
    private String user_category;
    private String user_department;
    private String user_phon_no;
    private String user_email;
    private Date create_dt;
    private String create_user;
    private Date modify_dt;
    private String modify_user;

    private List<Long> rel_user_role;

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_account_id(String user_account_id) {
        this.user_account_id = user_account_id;
    }

    public void setUser_passwd(String user_passwd) {
        this.user_passwd = user_passwd;
    }

    public void setUser_passwd_fail_cnt(String user_passwd_fail_cnt) {
        this.user_passwd_fail_cnt = user_passwd_fail_cnt;
    }

    public void setUser_use_yn(String user_use_yn) {
        this.user_use_yn = user_use_yn;
    }

    public void setUser_department(String user_department) {
        this.user_department = user_department;
    }

    public void setUser_phon_no(String user_phon_no) {
        this.user_phon_no = user_phon_no;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
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

    public Long getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_account_id() {
        return user_account_id;
    }

    public String getUser_passwd() {
        return user_passwd;
    }

    public String getUser_passwd_fail_cnt() {
        return user_passwd_fail_cnt;
    }

    public String getUser_use_yn() {
        return user_use_yn;
    }

    public String getUser_department() {
        return user_department;
    }

    public String getUser_phon_no() {
        return user_phon_no;
    }

    public String getUser_email() {
        return user_email;
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

    public String getUser_category() {
        return user_category;
    }

    public void setUser_category(String user_category) {
        this.user_category = user_category;
    }

    public List<Long> getRel_user_role() {
        return rel_user_role;
    }

    public void setRel_user_role(List<Long> rel_user_role) {
        this.rel_user_role = rel_user_role;
    }
}
