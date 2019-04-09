package com.fh.shop.backend.biz.user;

import com.fh.shop.backend.common.DataTableResult;
import com.fh.shop.backend.po.user.UserInfo;
import com.fh.shop.backend.vo.user.UserInfoVo;

import java.util.List;

public interface IUserService {

	
	
	UserInfo findUSerInfoName(String userName);

    void addUserInfo(UserInfo userInfo);

    void updatelastLoginTime(UserInfo userDB);

    void resetLoginCount(Integer id);

    void increaseLoginCount(Integer id);

    void updateLoginErrorInfo(Integer id);

    void updateLoginErrorCount(Integer id);

    void resetErrorLoginCount(Integer id);


    DataTableResult findUserList(UserInfo userInfo);
}
