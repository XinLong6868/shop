package com.fh.shop.backend.biz.user;

import com.fh.shop.backend.po.user.UserInfo;

public interface IUserService {

	public UserInfo loginUserInfo(String userName, String userPwd);

	public UserInfo findUSerInfoName(String userName);
}
