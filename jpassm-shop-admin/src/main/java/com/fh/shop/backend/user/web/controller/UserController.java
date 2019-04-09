package com.fh.shop.backend.user.web.controller;

import com.fh.shop.backend.common.DataTableResult;
import com.fh.shop.backend.common.ServerResponse;
import com.fh.shop.backend.user.biz.IUserService;
import com.fh.shop.backend.user.po.User;
import com.fh.shop.backend.user.vo.UserVO;
import com.fh.shop.backend.user.web.from.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Resource(name="userService")
    private IUserService userService;

    /**
     * 到查看页面
     * @return
     */
    @RequestMapping("/toUserPageList")
    public String toUserPageList(){
        return "user/userList";
    }

    /**
     * 查看用户信息
     * @param user
     * @return
     */
    @RequestMapping("/findUserList")
    @ResponseBody
    public ServerResponse findUserList(UserRequest user){
        DataTableResult userList = userService.findUserList(user);
        return ServerResponse.success(userList);
    }

    /**
     * 注册用户
     */
    @RequestMapping("addUser")
    @ResponseBody
    public ServerResponse addUser(User user){
        userService.addUser(user);
        return ServerResponse.success();
    }

    /**
     * 修改回显
     */
    @RequestMapping("findUser")
    @ResponseBody
    public ServerResponse findUser(Integer id){
        UserVO user = userService.findUser(id);
        return ServerResponse.success(user);
    }

    /**
     * 修改用户
     * @return
     */
    @RequestMapping("updateUser")
    @ResponseBody
    public ServerResponse updateUser(User user){
        userService.updateUser(user);
        return ServerResponse.success();
    }

    /**
     * 解锁
     * @return
     */
    @RequestMapping("userLockedStatus")
    public String userLockedStatus(Integer id){
        userService.updateUserLoginStatus(id);
        return "redirect:toUserPageList.jhtml";
    }

    /**
     * 批量删除用户
     * @return
     */
    @RequestMapping("deleteBatchUser")
    @ResponseBody
    public ServerResponse deleteBatchUser(String ids){
        userService.deleteBatchUser(ids);
        return ServerResponse.success();
    }


}
