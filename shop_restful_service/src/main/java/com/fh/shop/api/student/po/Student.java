package com.fh.shop.api.student.po;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author DELL
 * @title: Student
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/2114:20
 */
public class Student implements Serializable {

    private static final long serialVersionUID = -8759660433759654906L;

    private Integer id;

    private String stuName;

    private Integer stuAge;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
