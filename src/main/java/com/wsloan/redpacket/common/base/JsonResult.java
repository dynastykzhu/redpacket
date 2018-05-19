package com.wsloan.redpacket.common.base;

import java.io.Serializable;

public class JsonResult implements Serializable{

	private static final long serialVersionUID = 812376774103405857L;
	private int code;//0:代表成功;1或其他�?�代表处理失�?
	private Object content;//接收返回的数�?
	private String message;//定义提示 信息  
	
	public static final int SUCCESS=0;
	public static final int ERROR=1;
	
	
	public JsonResult(){}
	
	public JsonResult(int code, Throwable e){
		this.code=code;
		content=null;
		message=e.getMessage();
	}

	public JsonResult(ResultEnum resultEnum){
		this.code=resultEnum.getCode();
		content=null;
		message=resultEnum.getMsg();
	}


	public JsonResult(int code, Object content, String message) {
		this.code = code;
		this.content = content;
		this.message = message;
	}
	public JsonResult(Throwable e){
		code=ERROR;
		content=null;
		message=e.getMessage();
	}
	public JsonResult(Object content){
		code=SUCCESS;
		this.content=content;
		message="";
	}

	public int getState() {
		return code;
	}

	public void setState(int code) {
		this.code = code;
	}

	

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "JsonResult [code=" + code + ", content=" + content + ", message=" + message + "]";
	}

	
}







