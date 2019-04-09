package com.fh.shop.backend.po.user;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable{
	
				private static final long serialVersionUID = 5279963564104179513L;
				
				//用户id
				private Integer id;
				//用户名称
				private String userName;
				//用户密码
				private String userPwd;
				//加盐
				private String salt;
				//验证码
				private String imgCode;
				//登录日期
				private Date lastLoginTime;
				//登录次数
				private Integer loginCount;
				//错误登录次数
				private Integer errorLoginCount;
				//错误登录时间
				private Date errorLoginTime;
				//错误登录状态
				private Integer status;

				public Integer getStatus() {
					return status;
				}
				public void setStatus(Integer status) {
					this.status = status;
				}
				public Integer getErrorLoginCount() {
								return errorLoginCount;
							}

				public void setErrorLoginCount(Integer errorLoginCount) {
					this.errorLoginCount = errorLoginCount;
				}

				public Date getErrorLoginTime() {
					return errorLoginTime;
				}

				public void setErrorLoginTime(Date errorLoginTime) {
					this.errorLoginTime = errorLoginTime;
				}

				public Integer getLoginCount() {
								return loginCount;
							}

				public void setLoginCount(Integer loginCount) {
					this.loginCount = loginCount;
				}

				public Date getLastLoginTime() {
								return lastLoginTime;
							}

				public void setLastLoginTime(Date lastLoginTime) {
					this.lastLoginTime = lastLoginTime;
				}

				public String getImgCode() {
											return imgCode;
										}

				public void setImgCode(String imgCode) {
					this.imgCode = imgCode;
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
				public String getUserPwd() {
					return userPwd;
				}
				public void setUserPwd(String userPwd) {
					this.userPwd = userPwd;
				}

				public String getSalt() {
					return salt;
				}

				public void setSalt(String salt) {
					this.salt = salt;
				}
}
