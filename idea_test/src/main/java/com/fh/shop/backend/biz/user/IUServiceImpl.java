package com.fh.shop.backend.biz.user;


import com.fh.shop.backend.common.DataTableResult;
import com.fh.shop.backend.util.DateUtil;
import com.fh.shop.backend.vo.user.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.shop.backend.mapper.user.IUserInfoMapper;
import com.fh.shop.backend.po.user.UserInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("iUserService")
public class IUServiceImpl implements IUserService {

    @Autowired
    private IUserInfoMapper iUserInfoMapper;


    @Override
    public UserInfo findUSerInfoName(String userName) {
        UserInfo userInfo = iUserInfoMapper.findUSerInfoName(userName);
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

    /**
     * 重置正确登录次数
     *
     * @param id
     */
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
        iUserInfoMapper.updateLoginErrorInfo(id, new Date());
    }

    /**
     * 修改错误登录次数
     *
     * @param id
     */
    @Override
    public void updateLoginErrorCount(Integer id) {
        iUserInfoMapper.updateLoginErrorCount(id, new Date());
    }

    /**
     * 重置错误登录次数
     *
     * @param id
     */
    @Override
    public void resetErrorLoginCount(Integer id) {
        iUserInfoMapper.resetErrorLoginCount(id);
    }


    /**
     * 查询
     *
     * @param userInfo
     * @return
     */
    @Override
    public DataTableResult findUserList(UserInfo userInfo) {
        //填充排序信息
        //获取总条数
        long totalCount = iUserInfoMapper.findUserListCount(userInfo);
        //获取分页列表
        List<UserInfo> userList = iUserInfoMapper.findUserPageList(userInfo);
        //po转vo
        List<UserInfoVo> userInfoVoList = new ArrayList<>();
        for (UserInfo user : userList) {
            UserInfoVo userInfoVo = new UserInfoVo();
            userInfoVo.setId(user.getId());
            userInfoVo.setUserName(user.getUserName());
            userInfoVo.setUserRealName(user.getUserRealName());
            userInfoVo.setSalary(user.getSalary());
            userInfoVo.setSex(user.getSex());
            userInfoVo.setDeptName(user.getDeptName());
            userInfoVo.setBirthday(DateUtil.date2Str(user.getBirthday(), DateUtil.Y_M_D));
            //将转换后的vo,放入到vo的list集合中
            userInfoVoList.add(userInfoVo);
        }
        //组装result
        DataTableResult dataTableResult = DataTableResult.buid(userInfo.getDraw(), totalCount, totalCount, userInfoVoList);
        return dataTableResult;
    }

}
