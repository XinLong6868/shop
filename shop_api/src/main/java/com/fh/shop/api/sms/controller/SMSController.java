package com.fh.shop.api.sms.controller;

import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.sms.biz.IMSMService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author DELL
 * @title: SMSController
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/2012:02
 */
@RestController
@RequestMapping("/api/sms")
public class SMSController {
    /**
     * 验证码接口
     */
    @Resource(name = "iMSMService")
    private IMSMService iMSMService;
    @RequestMapping(value = "/sendCode", method = RequestMethod.POST)
    public ServerResponse sendCOde(String phone){
        return iMSMService.sendSMS(phone);
    }
}
