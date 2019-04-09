package com.fh.shop.api.common;

public enum ResponseEnum {
			USERNAME_USERPWD_imgCode_EMPTY(1000,"用户名或者密码为空或者验证码为空"),
			USERNAME_ERROR(1002,"用户名不存在"),
			USERPWD_ERROR(1001,"密码错误"),
			IMGCODE_ERROR(1003,"验证码错误"),
			ERROE(-1,"ERROR"),
			SUCCESS(200,"ojbk"),
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
