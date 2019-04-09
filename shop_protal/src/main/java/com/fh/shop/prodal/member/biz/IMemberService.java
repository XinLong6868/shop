package com.fh.shop.prodal.member.biz;

import com.fh.shop.prodal.common.ServerResponse;

import java.util.Map;

/**
 * @author DELL
 * @title: IMemberService
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/2019:23
 */
public interface IMemberService {

    public ServerResponse sendCode(String phone);

    ServerResponse reg(Map member);
}
