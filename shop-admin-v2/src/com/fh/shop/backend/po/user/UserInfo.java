package com.fh.shop.backend.po.user;

import java.io.Serializable;

public class UserInfo implements Serializable{
	
				private static final long serialVersionUID = 5279963564104179513L;
				
				//用户id
				private Integer id;
				//用户名称
				private String userName;
				//用户密码
				private String userPwd;
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
				
				
}
