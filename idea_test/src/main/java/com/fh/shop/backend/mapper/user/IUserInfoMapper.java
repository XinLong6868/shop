package com.fh.shop.backend.mapper.user;

import com.fh.shop.backend.po.user.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface IUserInfoMapper {


	 UserInfo findUSerInfoName(String userName);

     void addUserInfo(UserInfo userInfo);

     void updatelastLoginTime(UserInfo userDB);

     void resetLoginCount(Integer id);

     void increaseLoginCount(Integer id);

     void updateLoginErrorInfo(@Param("id") Integer id,@Param("currDate") Date date);

     void updateLoginErrorCount(@Param("id") Integer id,@Param("currDate") Date date);

     void resetErrorLoginCount(Integer id);
     //获取总条数
     long findUserListCount(UserInfo userInfo);
     //获取分页列表
     List<UserInfo> findUserPageList(UserInfo userInfo);
}
