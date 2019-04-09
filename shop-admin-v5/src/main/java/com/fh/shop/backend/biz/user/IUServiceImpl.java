package com.fh.shop.backend.biz.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.shop.backend.mapper.user.IUserInfoMapper;
import com.fh.shop.backend.po.user.UserInfo;

import java.util.Date;

@Service("iUserService")
public class IUServiceImpl implements IUserService{
	
	@Autowired
	private IUserInfoMapper iUserInfoMapper;

	
	
	@Override
	public UserInfo findUSerInfoName(String userName) {
		UserInfo userInfo=iUserInfoMapper.findUSerInfoName(userName);
		return userInfo;
	}

	@Override
	public void addUserInfo(UserInfo userInfo) {
		iUserInfoMapper.addUserInfo(userInfo);
	}

    @Override
    public void updatelastLoginTime(UserInfo userDB) {
		iUserInfoMapper.updatelastLoginTime(userDB);

    }

	@Override
	public void resetLoginCount(Integer id) {
		iUserInfoMapper.resetLoginCount(id);
	}

	@Override
	public void increaseLoginCount(Integer id) {
		iUserInfoMapper.increaseLoginCount(id);
	}

	@Override
	public void updateLoginErrorInfo(Integer id) {
		iUserInfoMapper.updateLoginErrorInfo(id,new Date());
	}

	@Override
	public void updateLoginErrorCount(Integer id) {
		iUserInfoMapper.updateLoginErrorCount(id,new Date());
	}

	@Override
	public void resetErrorLoginCount(Integer id) {
		iUserInfoMapper.resetErrorLoginCount(id);
	}

}
