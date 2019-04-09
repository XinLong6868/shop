package com.fh.shop.backend.security;

import com.fh.shop.backend.common.ResponseEnum;
import com.fh.shop.backend.common.ServerResponse;
import com.fh.shop.backend.common.WebContext;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;

import javax.servlet.http.HttpServletRequest;

/**
 * @author DELL
 * @title: APISecurity
 * @projectName shop-1808-Xinlong
 * @description: 辛龙
 * @date 2019/3/2814:13
 */
public class APISecurity {

    private Long expire = 2L * 60 * 1000;

    public Object handleSecyrity(ProceedingJoinPoint pjp){
        HttpServletRequest request = WebContext.get();
        //获取头部信息
        String appkey = request.getHeader("appkey");
        String currtime = request.getHeader("currtime");
        String nonce = request.getHeader("nonce");
        String sign = request.getHeader("sign");
        //将头部信息进行判断
        if(StringUtils.isEmpty(appkey) || StringUtils.isEmpty(currtime) ||
                StringUtils.isEmpty(nonce) || StringUtils.isEmpty(sign)){
            return ServerResponse.error(ResponseEnum.API_SECURITY_HEADER_MISS);
        }
        //判断超时
        long serverCurrTime = System.currentTimeMillis();
        long parseLong = Long.parseLong(currtime);
        if (serverCurrTime - parseLong > expire){
            return ServerResponse.error(ResponseEnum.API_SECURITY_TIMEOUT);
        }
        return null;
    }
}
