package com.fh.shop.backend.common;

import java.io.Serializable;


public class ServerResponse implements Serializable{

	private static final long serialVersionUID = -4291247662308738898L;
	private int code;
	private String msg;
	private Object data;
	
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	public Object getData() {
		return data;
	}
	   
	/**    
	 * <pre>有参 ServerResponse.    
	 *    
	 * @param code
	 * @param msg
	 * @param data</pre>    
	 */
	private ServerResponse(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	   
	/**    
	 * <pre>无参ServerResponse.    
	 *    </pre>    
	 */
    public ServerResponse() {
		
	}
	//成功
	public static ServerResponse success(int code, String msg ,Object data){
		return new ServerResponse(code,msg,data);
	}
	//失败
	public static ServerResponse error(int code, String msg){
		return new ServerResponse(code,msg,null);
	}
	//用户名或密码不能为空
	public static ServerResponse userNameEmpty(int code, String msg){
		return new ServerResponse(code,msg,null);
	}
	//用户名不存在
	public static ServerResponse userEmpty(int code, String msg){
		return new ServerResponse(code,msg,null);
	}
	//用户名或密码错误
	public static ServerResponse userPwdEmpty(int code, String msg){
		return new ServerResponse(code,msg,null);
	}
	//错误
	public static ServerResponse error(){
		return new ServerResponse(ResponseEnum.ERROR.getCode(),ResponseEnum.ERROR.getMsg(),null);
	}
	//状态
	public static ServerResponse stats(ResponseEnum responseEnum){
		return new ServerResponse(responseEnum.getCode(),responseEnum.getMsg(),null);
	}
	//有参成功
	public static ServerResponse success(Object data){
		return new ServerResponse(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),data);
	}
	//无参成功
	public static ServerResponse success(){
		return new ServerResponse(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),null);
	}
	
}
