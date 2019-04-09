package com.fh.shop.prodal.member.biz;

import com.fh.shop.prodal.common.ServerResponse;
import com.fh.shop.prodal.util.HttpClientUtil;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DELL
 * @title: IMemberServiceImpl
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/2019:23
 */
@Service("iMemberService")
public class IMemberServiceImpl implements IMemberService{
    /**
     * 短信验证码
     * @param phone
     * @return
     */
    @Override
    public ServerResponse sendCode(String phone) {
        HashMap params = new HashMap();
        params.put("phone",phone);
        String result = HttpClientUtil.sendPost("http://192.168.1.28:8083/api/sms/sendCode.action", null, params);
        //转换数据格式
        Gson gson = new Gson();
        ServerResponse serverResponse = gson.fromJson(result, ServerResponse.class);
        return serverResponse;
    }

    /**
     * 用户注册
     * @param member
     * @return
     */
    public ServerResponse reg(Map member){
        String result = HttpClientUtil.sendPost("http://localhost:8083/api/member/reg.action", null, member);
        //转换数据格式
        Gson gson = new Gson();
        ServerResponse serverResponse = gson.fromJson(result, ServerResponse.class);
        return serverResponse;
    }

}
