package com.fh.shop.backend.biz.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.shop.backend.mapper.user.IUserInfoMapper;
import com.fh.shop.backend.po.user.UserInfo;
@Service("iUserService")
public class IUServiceImpl implements IUserService{
	
	@Autowired
	private IUserInfoMapper iUserInfoMapper;

	@Override
	public UserInfo loginUserInfo(String userName, String userPwd) {
		
		return iUserInfoMapper.loginUserInfo(userName);
	}
	

}
