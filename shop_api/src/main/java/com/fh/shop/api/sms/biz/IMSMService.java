package com.fh.shop.api.sms.biz;

import com.fh.shop.api.common.ServerResponse;

/**
 * @author DELL
 * @title: IMSMService
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/2012:04
 */
public interface IMSMService {

    public ServerResponse sendSMS(String phone);
}
