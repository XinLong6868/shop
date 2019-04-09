package com.fh.shop.api.member.biz;

import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.member.po.Member;
import com.fh.shop.api.member.request.MemberRequest;

/**
 * @author DELL
 * @title: IMemberService
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/1920:09
 */
public interface IMemberService {

    public ServerResponse addMember(MemberRequest member);
}
