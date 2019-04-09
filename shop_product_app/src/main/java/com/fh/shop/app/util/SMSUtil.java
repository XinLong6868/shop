package com.fh.shop.app.util;

import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SMSUtil {

    @Value("${sms.url}")
    private String sms_url;

    @Value("${sms.appkey}")
    private String sms_appkey;

    @Value("${sms.AppSecret}")
    private String sms_AppSecret;

    public  String sendSMS(String phone){
        Map<String,String> headMap = new HashMap<String,String>();
        headMap.put("AppKey",sms_appkey);
        //随机数
        String uuid = UUID.randomUUID().toString();
        headMap.put("Nonce",uuid);
        //当前时间 字符串和任何类型拼接都是字符串
        String curTime = "" + new Date().getTime();
        headMap.put("CurTime",curTime);
        String checkSum = CheckSum.getCheckSum(sms_AppSecret, uuid, curTime);
        headMap.put("CheckSum",checkSum);

        Map<String,String> parmMap = new HashMap<String,String>();
        parmMap.put("mobile",phone);
        String result = HttpClientUtil.sendPost(sms_url, headMap, parmMap);
        return result;
    }

}
