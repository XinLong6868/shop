package com.fh.shop.backend.common;

public enum ResponseEnum {

	USERNAME_USERPWD_EMPTY(1001,"用户名或密码不能为空"),
	USER_EMPTY(1002,"用户名不存在"),
	USERPWD_ERROR(1003,"用户名或密码错误"),
	USER_IMGCODE_EMPTY(1004,"验证码不能为空"),
	USER_IMGCODE_ERROR(1005,"验证码错误"),
	USER_LOGINFLAG(1006,"账号已被锁定"),
	ERROR(-1,"ERROR"),
	SUCCESS(200,"SUCCESS");
	
	private int code;
	private String msg;
	
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	   
	/**    
	 * <pre>无参 ResponseEnum.    
	 *    
	 * @param code
	 * @param msg</pre>    
	 */
	private ResponseEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
}
