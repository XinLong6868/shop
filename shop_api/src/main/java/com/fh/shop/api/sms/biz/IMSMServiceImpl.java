package com.fh.shop.api.sms.biz;

import com.fh.shop.api.common.ResponseEnum;
import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.sms.response.SMSResponse;
import com.fh.shop.api.util.CacheManager;
import com.fh.shop.api.util.SMSUtil;
import com.fh.shop.api.util.SysConstant;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author DELL
 * @title: IMSMServiceImpl
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/2012:05
 */
@Service("iMSMService")
public class IMSMServiceImpl implements IMSMService {

    @Resource(name = "smsUtil")
    private SMSUtil smsUtil;

    @Override
    public ServerResponse sendSMS(String phone) {
        if (StringUtils.isEmpty(phone)) {
            return ServerResponse.error(ResponseEnum.PHONE_IS_NULL);
        }
        if (phone.length() != 11) {
            return ServerResponse.error(ResponseEnum.PHONE_IS_LENGTH);
        }
        String result = smsUtil.sendSMS(phone);
        System.out.println(result);
        Gson gson = new Gson();
        SMSResponse smsResponse = gson.fromJson(result, SMSResponse.class);
        if (smsResponse.getCode() == 200) {
            //发送成功
            CacheManager.getInstance().putObj(SysConstant.SMS_CODE_PREFIX + phone, smsResponse.getObj(),
                    SysConstant.SMS_CODE_EXPIRE);
            return ServerResponse.success();
        }else {
            return ServerResponse.error(ResponseEnum.SMS_SYSTEM_ERROR);
        }
    }
}
