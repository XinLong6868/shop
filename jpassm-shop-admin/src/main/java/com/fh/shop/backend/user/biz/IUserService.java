package com.fh.shop.backend.user.biz;

import com.fh.shop.backend.common.DataTableResult;
import com.fh.shop.backend.user.po.User;
import com.fh.shop.backend.user.vo.UserVO;
import com.fh.shop.backend.user.web.from.UserRequest;

public interface IUserService {
    //查看用户信息
    DataTableResult findUserList(UserRequest user);
    //注册用户
    void addUser(User user);
    // 修改回显
    UserVO findUser(Integer id);
    //修改用户
    void updateUser(User user);
    //解锁
    void updateUserLoginStatus(Integer id);
//批量删除用户
    void deleteBatchUser(String ids);
}
