package com.kdg.api.model;

import java.util.Date;

public class InitDataDTO {

    private int init_id;
    private int menu_id;
    private String menu_name;
    private String table_id;
    private int data_ctn;
    private String init_sql;
    private Date create_dt;
    private String create_user;
    private Date modify_dt;
    private String modify_user;

    public void setInit_id(int init_id) {
        this.init_id = init_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public void setTable_id(String table_id) {
        this.table_id = table_id;
    }

    public void setData_ctn(int data_ctn) {
        this.data_ctn = data_ctn;
    }

    public void setInit_sql(String init_sql) {
        this.init_sql = init_sql;
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

    public int getInit_id() {
        return init_id;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public String getTable_id() {
        return table_id;
    }

    public int getData_ctn() {
        return data_ctn;
    }

    public String getInit_sql() {
        return init_sql;
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
