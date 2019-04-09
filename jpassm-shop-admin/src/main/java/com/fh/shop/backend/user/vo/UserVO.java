package com.fh.shop.backend.user.vo;

import java.io.Serializable;
import java.util.Date;

public class UserVO implements Serializable {

    private static final long serialVersionUID = 4476329923858530266L;

    private Integer id;
    //用户名
    private String userName;
    //真是姓名
    private String userRealName;
    //用户图像
    private String userImage;
    private String oldUserImage;
    //密码
    private String password;
    //登陆状态
    private Integer loginStatus;
    //生日
    private Date birthday;
    //性别
    private Integer sex;
    //薪资
    private Double salary;
    //部门
    private String deptName;
    //部门id
    private Integer deptId;

    public String getOldUserImage() {
        return oldUserImage;
    }

    public void setOldUserImage(String oldUserImage) {
        this.oldUserImage = oldUserImage;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }
}
