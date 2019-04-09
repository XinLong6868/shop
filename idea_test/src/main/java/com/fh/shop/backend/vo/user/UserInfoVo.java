package com.fh.shop.backend.vo.user;

import java.io.Serializable;

public class UserInfoVo implements Serializable {
    private static final long serialVersionUID = -3088199918402572462L;
    //id
    private Integer id;
    //用户名称
    private String userName;
    //用户真实姓名
    private String userRealName;
    //用户性别
    private Integer sex;
    //用户工资
    private Float salary;
    //用户生日
    private String birthday;
    //用户所在部门
    private String deptName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
