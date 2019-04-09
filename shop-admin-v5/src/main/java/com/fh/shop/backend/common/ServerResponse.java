package com.fh.shop.backend.common;

import java.io.Serializable;

import org.springframework.web.servlet.ModelAndView;

public class ServerResponse implements Serializable{
	
				private static final long serialVersionUID = 1830682094599780635L;

				private int code;
				
				private String message;
				
				private Object data;

				public int getCode() {
					return code;
				}



				public String getMessage() {
					return message;
				}



				public Object getData() {
					return data;
				}

				public void setCode(int code) {
					this.code = code;
				}

				public void setMessage(String message) {
					this.message = message;
				}

				public void setData(Object data) {
					this.data = data;
				}

				private ServerResponse(int code, String message, Object data) {
					this.code = code;
					this.message = message;
					this.data = data;
				}
				private ServerResponse(){

				}

				public static ServerResponse success(){
					return new ServerResponse(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMessage(),null);
				}

				public static ServerResponse error(){
					return new ServerResponse(ResponseEnum.ERROE.getCode(),ResponseEnum.ERROE.getMessage(), null);
				}

				public static ServerResponse error(int code,String message){
					return new ServerResponse(code,message, null);
				}

				public static ServerResponse error(ResponseEnum responseEnum){
					return new ServerResponse(responseEnum.getCode(),responseEnum.getMessage(),null);
				}

				public static ServerResponse success(Object data){
					return new ServerResponse(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMessage(),data);
				}

}
