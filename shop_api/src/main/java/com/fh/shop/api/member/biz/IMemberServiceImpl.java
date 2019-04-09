package com.fh.shop.api.member.biz;

import com.fh.shop.api.common.ResponseEnum;
import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.member.mapper.IMemberMapper;
import com.fh.shop.api.member.po.Member;
import com.fh.shop.api.member.request.MemberRequest;
import com.fh.shop.api.util.CacheManager;
import com.fh.shop.api.util.MD5Util;
import com.fh.shop.api.util.SysConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author DELL
 * @title: IMemberServiceImpl
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/1920:11
 */
@Service("iMemberService")
public class IMemberServiceImpl implements IMemberService{

    @Autowired
    private IMemberMapper iMemberMapper;
    @Override
    public ServerResponse addMember(MemberRequest member) {

        //判断非空
        if(StringUtils.isEmpty(member.getUserName()) || StringUtils.isEmpty(member.getPassword())
                || StringUtils.isEmpty(member.getEmail())
                || StringUtils.isEmpty(member.getCode())
                || StringUtils.isEmpty(member.getPhone())){
            return ServerResponse.error(ResponseEnum.MEMBER_IS_EMPYT);
        }
        //判断手机号
        if(member.getPhone().length() != 11){
            return ServerResponse.error(ResponseEnum.MEMBER_PHONE_ERROR);
        }

        //判断短信验证码,并将短信验证码放入缓存
        String code =(String) CacheManager.getInstance().getObj(SysConstant.SMS_CODE_PREFIX + member.getPhone());
        if(StringUtils.isEmpty(code)){
            return ServerResponse.error(ResponseEnum.SMS_CODE_EXPIRE);
        }

        if (!code.equals(member.getCode())){
            return ServerResponse.error(ResponseEnum.SMS_CODE_ERROR);
        }
        //判断用户名
        Member memberInfo = iMemberMapper.findUserByUserName(member.getUserName());
        if(memberInfo != null){
            return ServerResponse.error(ResponseEnum.MEMBER_IS_EXIST);
        }
        //判断手机号是否已被注册
        member.setRegTime(new Date());
        //1次加密
        member.setPassword(MD5Util.getStringMD5(member.getPassword()));
        //子类会自动隐士转成父类,如MemberRequest是Member的子类，所以它可以自动转化成Member
        iMemberMapper.addMember(member);
        return ServerResponse.success();
    }
}
