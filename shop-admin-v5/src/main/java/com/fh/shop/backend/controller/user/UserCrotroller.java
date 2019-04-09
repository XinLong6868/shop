package com.fh.shop.backend.controller.user;


import javax.servlet.http.HttpServletRequest;

import com.fh.shop.backend.annnotation.Log;
import com.fh.shop.backend.biz.DateUtils;
import com.fh.shop.backend.util.DateUtil;
import com.fh.shop.backend.util.MD5Util;
import com.fh.shop.backend.util.SystemContent;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fh.shop.backend.biz.user.IUserService;
import com.fh.shop.backend.common.ResponseEnum;
import com.fh.shop.backend.common.ServerResponse;
import com.fh.shop.backend.po.user.UserInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class UserCrotroller {
				@Autowired
				@Qualifier("iUserService")
				private IUserService iUserService;

				@RequestMapping("/user/login")
				@ResponseBody
				@Log(value = "用户登陆")
				public ServerResponse login(UserInfo userInfo,HttpServletRequest request){
					UserInfo userDB=null;
					//本次登录时间
					Date currDate = new Date();
					//当前时间
					Date currDay = DateUtil.str2Date(DateUtil.date2Str(currDate, DateUtil.FULL_DATE), DateUtil.Y_M_D);
					try {
						String userName = userInfo.getUserName();
						String userPwd = userInfo.getUserPwd();
						String imgCode = userInfo.getImgCode();
						if(StringUtils.isEmpty(userName) && StringUtils.isEmpty(userPwd) && StringUtils.isEmpty(imgCode)){
							return ServerResponse.error(ResponseEnum.USERNAME_USERPWD_imgCode_EMPTY);
						}
						//从session中获取验证码
						String sessionImgCode = (String) request.getSession().getAttribute(SystemContent.IMGCODE);
						//验证码对比
						if (!imgCode.equals(sessionImgCode)){
							return ServerResponse.error(ResponseEnum.IMGCODE_ERROR);
						}
						userDB = iUserService.findUSerInfoName(userName);
						//判断userDB（数据库查出的值）是否为空
						if (userDB == null){
							return ServerResponse.error(ResponseEnum.USERNAME_ERROR);
						}
						//判断状态是否锁定
						/*int status = userDB.getStatus();
						if(status == SystemContent.USER_STATUS){
							return ServerResponse.error(ResponseEnum.USER_ERROR_COUNT);
						}*/
						//判断前台拿到的密码与账户是否与数据库匹配
						//md5单重加密
						String md5Password = MD5Util.getStringMD5(userPwd+userDB.getSalt());
						if (!md5Password.equals(userDB.getUserPwd())){
							Date errorLoginTime = userDB.getErrorLoginTime();
							if (errorLoginTime == null){
								//如果错误时间为null,则代表为第一次登录并记录错误时间为当前时间,并将登陆的错误次数+1
								iUserService.updateLoginErrorInfo(userDB.getId());
							}else {
								//如果不为空，那就与当前时间判断时间是否是同一天
								Date errorLoginDay = DateUtil.str2Date(DateUtil.date2Str(errorLoginTime, DateUtil.Y_M_D), DateUtil.Y_M_D);
								if (currDay.after(errorLoginDay)){
									//是同一天的话那就次数+1，并更新错误的登录时间
									iUserService.updateLoginErrorInfo(userDB.getId());
								}else {
									//不是同一天的话，那就将登陆的错误次数重置为1，并且更新错误的登录时间
									iUserService.updateLoginErrorCount(userDB.getId());
								}
							}
							return ServerResponse.error(ResponseEnum.USERPWD_ERROR);
						}
					} catch (Exception e) {
						e.printStackTrace();
						return ServerResponse.error(ResponseEnum.ERROE);
					}
					//判断日期是否是今天
					if(DateUtil.creaseDate(userDB.getLastLoginTime())){
						userDB.setLoginCount(userDB.getLoginCount()+1);
					}else{
						userDB.setLoginCount(1);
					}
					//登陆成功,从后续的session中获取信息
					//userDB代表从数据库查询出的数据
					//userInfo代表在前台取userDB查询出的数据
					request.getSession().setAttribute("userInfo",userDB);
					//登录成功将登录次数重置
					iUserService.resetErrorLoginCount(userDB.getId());
					//记录本次登陆时间
					userInfo.setId(userDB.getId());
					userInfo.setLastLoginTime(currDate);
					iUserService.updatelastLoginTime(userInfo);
					//更新登录次数
					Date lastLoginTime = userDB.getLastLoginTime();
					if (lastLoginTime == null){
						//代表的第一次登陆
						iUserService.resetLoginCount(userDB.getId());
					}else {
						Date lastLoginDay = DateUtil.str2Date(DateUtil.date2Str(lastLoginTime, DateUtil.FULL_DATE), DateUtil.Y_M_D);
						if (currDay.after(lastLoginDay)) {
							//重置为1
							iUserService.resetLoginCount(userDB.getId());
						} else {
							//+1
							iUserService.increaseLoginCount(userDB.getId());
						}
					}
					return ServerResponse.success();
				}
				/***
				 * <pre>toAddUserInfo(跳转到增加页面)
				 * 创建人：辛龙       2427776882@qq.com
				 * 创建时间：2019年1月17日 下午8:11:52
				 * 修改人：辛龙       2427776882@qq.com
				 * 修改时间：2019年1月17日 下午8:11:52
				 * 修改备注：
				 * @return</pre>
				 */
				@RequestMapping("/user/toAddUserInfo")
				public String toAddUserInfo(){
					return "user/addUserInfo";
				}
				/**
				 *
				 * @param userInfo
				 * 普通增加
				 * @return
				 */
				@RequestMapping("/user/addUserInfo")
				@ResponseBody
				public ServerResponse addUserInfo(UserInfo userInfo){
					String s = UUID.randomUUID().toString();
					userInfo.setSalt(s);
					userInfo.setLoginCount(0);
					String stringMD5 = MD5Util.getStringMD5(userInfo.getUserPwd() + s);
					userInfo.setUserPwd(stringMD5);
					iUserService.addUserInfo(userInfo);
					return ServerResponse.success();
				}
}
