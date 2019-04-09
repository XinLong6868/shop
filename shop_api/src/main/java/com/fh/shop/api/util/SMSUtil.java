package com.fh.shop.api.util;

import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author DELL
 * @title: SMSUtil
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/200:29
 */
public class SMSUtil {
    @Value("${sms.AppKey}")
    private  String sms_appKey;
    @Value("${sms.url}")
    private  String sms_url;
    @Value("${sms.appSecret}")
    private  String sms_appSecret;

    public  String sendSMS(String phone){
        Map<String,String> headers = new HashMap();
        headers.put("AppKey",sms_appKey);
        String uuid = UUID.randomUUID().toString();
        headers.put("Nonce",uuid);
        String curTime = ""+new Date().getTime();
        headers.put("CurTime",curTime);
        String checkSum = CheckSumBuilder.getCheckSum(sms_appSecret, uuid, curTime);
        headers.put("CheckSum",checkSum);

        Map<String,String> params = new HashMap();
        params.put("mobile",phone);


        String result = HttpClientUtil.sendPost(sms_url, headers, params);
        System.out.println(result);
        return result;
    }
}
