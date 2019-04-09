package com.fh.shop.prodal.common;

public enum ResponseEnum {
			USERNAME_USERPWD_imgCode_EMPTY(1000,"用户名或者密码为空或者验证码为空"),
			USERNAME_ERROR(1002,"用户名不存在"),
			USERPWD_ERROR(1001,"密码错误"),
			IMGCODE_ERROR(1003,"验证码错误"),
			ERROE(-1,"ERROR"),
			SUCCESS(200,"ojbk"),

            MEMBER_IS_EMPYT(5001,"注册会员信息不能为空"),
            MEMBER_PHONE_ERROR(5002,"请输入合法手机号"),
            MEMBER_IS_EXIST(5003,"该会员已被注册"),

			PHONE_IS_NULL(5004,"会员手机号不能为空"),
			PHONE_IS_LENGTH(5005,"会员手机号不合法"),
			SMS_SYSTEM_ERROR(5006,"网易云端口异常"),
			USER_ERROR_COUNT(1004,"请联系管理员");



			
			private int code;
	
			private String message;

			public int getCode() {
				return code;
			}

			public String getMessage() {
				return message;
			}

			private ResponseEnum(int code, String message) {
				this.code = code;
				this.message = message;
			}
			
			
}
