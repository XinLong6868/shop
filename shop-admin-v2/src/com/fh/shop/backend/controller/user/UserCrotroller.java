package com.fh.shop.backend.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.shop.backend.biz.user.IUserService;
import com.fh.shop.backend.po.user.UserInfo;
@Controller
public class UserCrotroller {
				@Autowired
				@Qualifier("iUserService")
				private IUserService iUserService;
				
				
				@RequestMapping("tologin")
				public String tologin(){
					 return "user/login";
				}
				/**
				 * <pre>login(登录)   
				 * 创建人：辛龙       2427776882@qq.com    
				 * 创建时间：2019年1月7日 下午5:06:52    
				 * 修改人：辛龙       2427776882@qq.com     
				 * 修改时间：2019年1月7日 下午5:06:52    
				 * 修改备注： 
				 * @return</pre>
				 * 
				 */
				@RequestMapping("/user/loginUserInfo")
				public String loginUserInfo(@Param("userName")String userName,@Param("userPwd")String userPwd,Model model,HttpServletRequest request){
					UserInfo userInfo=iUserService.loginUserInfo(userName,userPwd);
					if(userName == null || "".equals(userName)){
						//没有输入姓名
			            model.addAttribute("msg1","请输入姓名");
					}else if(userInfo==null||"".equals(userInfo)){ //输入姓名但是姓名错误
			            model.addAttribute("msg1","账户不存在，请先注册");
			            return "user/login";
			        }else if(userInfo!=null &(userPwd==null||"".equals(userPwd))){ //姓名正确，但没有输入密码
			            model.addAttribute("msg2","请输入密码");
			        }else if(userInfo!=null &!(userInfo.getUserPwd().equals(userPwd))) { //姓名正确，输入密码，但是密码错误
			            model.addAttribute("msg2","密码错误");

			        }else if (userInfo!=null &userInfo.getUserPwd().equals(userPwd)){ //姓名密码均正确
			        	//这是个拦截器
			        	HttpSession session = request.getSession();
			        	session.setAttribute("LOGIN_USER", userInfo);
			            return "index";
			        }
			        return "user/login";
				}
}
