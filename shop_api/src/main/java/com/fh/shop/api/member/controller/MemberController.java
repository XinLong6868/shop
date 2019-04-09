package com.fh.shop.api.member.controller;

import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.member.biz.IMemberService;
import com.fh.shop.api.member.po.Member;
import com.fh.shop.api.member.request.MemberRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author DELL
 * @title: MemberController
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/1920:24
 */
@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Resource(name = "iMemberService")
    private IMemberService iMemberService;

    /**
     * 会员用户注册接口
     * @param member
     * @return
     */
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public ServerResponse add(MemberRequest member){
        return iMemberService.addMember(member);
    }
}
