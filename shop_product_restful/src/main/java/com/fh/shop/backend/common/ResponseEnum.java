package com.fh.shop.backend.common;


public enum ResponseEnum {
	PASSWORD_ERROR(1002,"密码错误"),
	IMAGECODE_ERROR(1003,"验证码错误"),
	USERNAME_CLOSED_STATUS(1004,"该账号已被锁定,请联系管理员"),
	USERNAME_ERROR(1001,"该用户不存在"),
	USERNAME_PASSWORD_IMAGECODE_EMPTY(1000,"用户名或密码或验证码为空"),
	ERROR(500,"系统错误，请联系管理员"),
	MEMBER_IS_EMPTY(2001,"注册信息不能为空"),
	MEMBER_IS_EXIST(2002,"该会员已存在"),
	PHONE_IS_ERROR(2003,"手机号格式不正确"),
	PHONE_IS_null(2003,"手机号不能为空"),
	SMS_SYSTEM_ERROR(2004,"网易云信服务端接口异常"),
	SMS_CODE_EXPIRE(2005,"验证码过期"),
	SMS_CODE_ERROR(2005,"验证码错误"),
	SMS_PHONE_EXIST(2006,"该手机号已存在"),
	PARAMS_IS_ERROR(999,"参数错误"),
	API_SECURITY_HEADER_MISS(8000,"头部信息异常"),
	API_SECURITY_TIMEOUT(8001,"请求超时"),
	SUCCESS(200,"ok");

	private Integer code;
	
	private String msg;
	
	private ResponseEnum(){
		
	}
	private ResponseEnum(Integer code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
	
}
