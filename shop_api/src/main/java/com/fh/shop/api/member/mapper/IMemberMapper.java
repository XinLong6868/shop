package com.fh.shop.api.member.mapper;

import com.fh.shop.api.member.po.Member;

/**
 * @author DELL
 * @title: IMemberMapper
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/1920:13
 */
public interface IMemberMapper {

    public void addMember(Member member);

    Member findUserByUserName(String userName);
}
