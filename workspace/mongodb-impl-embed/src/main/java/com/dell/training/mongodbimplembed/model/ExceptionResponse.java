package com.dell.training.mongodbimplembed.model;

public class ExceptionResponse {

	private String message;
	private Integer code;
	private Long timeStamp;
	
	
	
	public ExceptionResponse(String message, Integer code, Long timeStamp) {
		super();
		this.message = message;
		this.code = code;
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
