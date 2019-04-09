package com.fh.shop.backend.po.area;

import java.io.Serializable;

public class AreaInfo implements Serializable {
    private static final long serialVersionUID = 8663009995174537400L;

    private Integer id;
   /* 地区名称*/
    private String areaName;

    private Integer pid;
    /*地区描述*/
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
