package com.fh.shop.prodal.member.controller;

import com.fh.shop.prodal.common.ServerResponse;
import com.fh.shop.prodal.member.biz.IMemberService;
import com.fh.shop.prodal.util.HttpClientUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author DELL
 * @title: MemberController
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/2015:45
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource(name = "iMemberService")
    private IMemberService iMemberService;

    @RequestMapping(value = "/sendCode", method = RequestMethod.POST)
    public ServerResponse sendCode(String phone){
        return iMemberService.sendCode(phone);
    }
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public ServerResponse reg(@RequestParam Map member){
        return iMemberService.reg(member);
    }


}
