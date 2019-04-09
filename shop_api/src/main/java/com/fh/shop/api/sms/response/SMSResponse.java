package com.fh.shop.api.sms.response;

import java.io.Serializable;

/**
 * @author DELL
 * @title: SMSResponse
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/2012:37
 */
public class SMSResponse implements Serializable {

    private static final long serialVersionUID = -3768535573548264612L;

    private int code;

    private String msg;

    private String obj;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }
}
