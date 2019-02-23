package com.wzq.labsystem.exception;

@SuppressWarnings("serial")
public class ServiceException extends RuntimeException{
	private Integer code;
	private String message;
	public ServiceException(){
		
	}
	public ServiceException(Integer code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}
	public ServiceException(Integer code, String message, Throwable cause){
		super(message, cause);
		this.code = code;
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}

	
}
