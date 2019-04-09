package com.fh.shop.api.member.po;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author DELL
 * @title: Member
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/1919:54
 */
public class Member implements Serializable {

    private static final long serialVersionUID = -2160290091380648855L;
    //会员id
    private Integer id;
    //会员名称
    private String userName;
    //会员密码
    private String password;
    //会员电话
    private String phone;
    //会员邮箱
    private String email;
    //会员生日
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    //会员登录时间
    private Date regTime;
    //会员错误登录时间
    private Date lastLoginTime;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
