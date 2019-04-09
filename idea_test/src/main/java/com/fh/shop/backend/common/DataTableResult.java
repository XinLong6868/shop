package com.fh.shop.backend.common;

import java.io.Serializable;
import java.util.List;

public class DataTableResult implements Serializable {
    private static final long serialVersionUID = 5710999222800174410L;

    private Integer draw;

    private long recordsTotal;

    private long recordsFiltered;

    private List data;

    private DataTableResult(Integer draw, long recordsTotal, long recordsFiltered, List data) {
        this.draw = draw;
        this.recordsFiltered = recordsFiltered;
        this.recordsTotal = recordsTotal;
        this.data = data;
    }

    public static DataTableResult buid(Integer draw, long recordsTotal, long recordsFiltered, List data) {
        return new DataTableResult(draw, recordsTotal, recordsFiltered, data);
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
