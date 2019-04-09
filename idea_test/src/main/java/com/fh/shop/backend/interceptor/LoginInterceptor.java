package com.fh.shop.backend.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fh.shop.backend.util.SystemContent;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
				String requestURI = request.getRequestURI();
				/*if(requestURI.endsWith(SystemContent.WHITE_LIST)){
					return true;
				}*/
					if (SystemContent.WHITE_LIST.contains(requestURI)){
					return true;
				}
				Object user = request.getSession().getAttribute("userInfo");
				if(null != user){
					//放行
					return true;
				}else{
					//跳转到登陆页面
					response.sendRedirect("/login.jsp");
					//禁止继续访问
					return false;
				}
				
			}
			
}
