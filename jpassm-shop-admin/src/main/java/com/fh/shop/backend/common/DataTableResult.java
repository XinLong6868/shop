package com.fh.shop.backend.common;

import java.io.Serializable;
import java.util.List;

public class DataTableResult implements Serializable {
    private static final long serialVersionUID = 5710999222800174410L;

    private Integer draw;

    private Long recordsFiltered;

    private Long recordsTotal;

    private List data;

    //无参构造
    private DataTableResult(){

    }

    //有参构造
    private DataTableResult(List data, Integer draw, Long recordsFiltered, Long recordsTotal) {
        this.data = data;
        this.draw = draw;
        this.recordsFiltered = recordsFiltered;
        this.recordsTotal = recordsTotal;


    }

    public static DataTableResult dataTableResultData(List data,Integer draw, Long recordsFiltered, Long recordsTotal){
        return new DataTableResult(data,draw,recordsFiltered,recordsTotal);
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
