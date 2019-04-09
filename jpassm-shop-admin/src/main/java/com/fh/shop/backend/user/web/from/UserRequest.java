package com.fh.shop.backend.user.web.from;

import com.fh.shop.backend.common.Page;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class UserRequest extends Page implements Serializable {
    private static final long serialVersionUID = -6587828614393440641L;
    //用户名
    private String userName;
    //条件查询字段
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minBirthday;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxBirthday;

    private Double minSalary;
    private Double maxSalary;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getMinBirthday() {
        return minBirthday;
    }

    public void setMinBirthday(Date minBirthday) {
        this.minBirthday = minBirthday;
    }

    public Date getMaxBirthday() {
        return maxBirthday;
    }

    public void setMaxBirthday(Date maxBirthday) {
        this.maxBirthday = maxBirthday;
    }

    public Double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }

    public Double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Double maxSalary) {
        this.maxSalary = maxSalary;
    }
}
