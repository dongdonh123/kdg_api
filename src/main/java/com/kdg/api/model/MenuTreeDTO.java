package com.kdg.api.model;

import java.util.Date;
import java.util.List;

public class MenuTreeDTO {

    private Long top_menu_id;
    private String top_menu_name;
    private List<Long> child_menu_id_list;
    private List<String> child_munu_name_list;

    // 생성자
    public MenuTreeDTO() {
    }

    public MenuTreeDTO(Long menu_id, String menu_name,List<Long> menu_id_list, List<String> menu_name_list) {
        this.top_menu_id=menu_id;
        this.top_menu_name=menu_name;
        this.child_menu_id_list=menu_id_list;
        this.child_munu_name_list=menu_name_list;
    }

    public void setTop_menu_id(Long top_menu_id) {
        this.top_menu_id = top_menu_id;
    }

    public void setTop_menu_name(String top_menu_name) {
        this.top_menu_name = top_menu_name;
    }

    public void setChild_menu_id_list(List<Long> child_menu_id_list) {
        this.child_menu_id_list = child_menu_id_list;
    }

    public void setChild_munu_name_list(List<String> child_munu_name_list) {
        this.child_munu_name_list = child_munu_name_list;
    }

    public Long getTop_menu_id() {
        return top_menu_id;
    }

    public String getTop_menu_name() {
        return top_menu_name;
    }

    public List<Long> getChild_menu_id_list() {
        return child_menu_id_list;
    }

    public List<String> getChild_munu_name_list() {
        return child_munu_name_list;
    }
}
