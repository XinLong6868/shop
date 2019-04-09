/** 
 * <pre>项目名称:shop-admin-maven1 
 * 文件名称:serverResponse.java 
 * 包名:com.fh.shop.backend.common 
 * 创建日期:2019年1月11日下午5:10:33 
 * Copyright (c) 2019, 3222476127@qq.com  All Rights Reserved.</pre> 
 */  
package com.fh.shop.backend.common;

import java.io.Serializable;

/** 
 * <pre>项目名称：shop-admin-maven1    
 * 类名称：serverResponse    
 * 类描述：    
 * 创建人：lihaiyan 3222476127@qq.com     
 * 创建时间：2019年1月11日 下午5:10:33    
 * 修改人：lihaiyan 3222476127@qq.com      
 * 修改时间：2019年1月11日 下午5:10:33    
 * 修改备注：       
 * @version </pre>    
 */
public class ServerResponse implements Serializable{
	
	private static final long serialVersionUID = -6123525952297172155L;

	private Integer code;
	
	private String msg;
	
	private Object data;



	//无参构造
	private ServerResponse(){

	}

	//有参构造
	private ServerResponse(Integer code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;

	}

	public static ServerResponse success(){
		return new ServerResponse(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),null);
	}
	public static ServerResponse success(Object data){
		return new ServerResponse(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),data);
	}

	public static ServerResponse error(){
		return new ServerResponse(ResponseEnum.ERROR.getCode(),ResponseEnum.ERROR.getMsg(),null);
	}
	public static ServerResponse error(ResponseEnum responseEnum){
		return new ServerResponse(responseEnum.getCode(),responseEnum.getMsg(),null);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}




}
