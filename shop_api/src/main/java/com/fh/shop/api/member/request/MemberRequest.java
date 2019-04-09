package com.fh.shop.api.member.request;

import com.fh.shop.api.member.po.Member;

import java.io.Serializable;

/**
 * @author DELL
 * @title: MemberRequest
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/2020:22
 */
public class MemberRequest extends Member implements Serializable {

    private static final long serialVersionUID = -4434884414297837430L;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
