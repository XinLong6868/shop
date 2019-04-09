package com.fh.shop.backend.biz.user;

import com.fh.shop.backend.po.user.UserInfo;

public interface IUserService {

	
	
	public UserInfo findUSerInfoName(String userName);

    public void addUserInfo(UserInfo userInfo);

    void updatelastLoginTime(UserInfo userDB);

    void resetLoginCount(Integer id);

    void increaseLoginCount(Integer id);

    void updateLoginErrorInfo(Integer id);

    void updateLoginErrorCount(Integer id);

    void resetErrorLoginCount(Integer id);
}
