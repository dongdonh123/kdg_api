package com.kdg.api.model.otherInformation;



public class OtherInformation {

    // 페이지번호
    private int page_no;
    //한페이지에 몇개씩 할건지 설정
    private int page_cnt;
    //지금 페이지에 데이터 몇개
    private int this_page_row;
    //총 데이터
    private int total_row;
    //맥스 페이지 번호
    private int max_page_no;
    //페이지 데이터 구간 최소
    private int current_page_data_min;
    //페이지 데이터 구간 최대
    private int current_page_data_max;

    // 기본 생성자
    public OtherInformation() {

    }

    // 생성자
    public OtherInformation(int page_no, int page_cnt, int this_page_row, int total_row, int max_page_no,int current_page_data_min,int current_page_data_max) {
        this.page_no = page_no;
        this.page_cnt = page_cnt;
        this.this_page_row = this_page_row;
        this.total_row = total_row;
        this.max_page_no = max_page_no;
        this.current_page_data_min = current_page_data_min;
        this.current_page_data_max = current_page_data_max;

    }

    // Getter & Setter
    public int getPage_no() {
        return page_no;
    }

    public int getPage_cnt() {
        return page_cnt;
    }

    public int getThis_page_row() {
        return this_page_row;
    }

    public int getTotal_row() {
        return total_row;
    }
    public void setPage_no(int page_no) {
        this.page_no = page_no;
    }

    public void setPage_cnt(int page_cnt) {
        this.page_cnt = page_cnt;
    }

    public void setThis_page_row(int this_page_row) {
        this.this_page_row = this_page_row;
    }

    public void setTotal_row(int total_row) {
        this.total_row = total_row;
    }

    public int getMax_page_no() {
        return max_page_no;
    }

    public void setMax_page_no(int max_page_no) {
        this.max_page_no = max_page_no;
    }

    public int getCurrent_page_data_min() {
        return current_page_data_min;
    }

    public int getCurrent_page_data_max() {
        return current_page_data_max;
    }

    public void setCurrent_page_data_min(int current_page_data_min) {
        this.current_page_data_min = current_page_data_min;
    }

    public void setCurrent_page_data_max(int current_page_data_max) {
        this.current_page_data_max = current_page_data_max;
    }
}
