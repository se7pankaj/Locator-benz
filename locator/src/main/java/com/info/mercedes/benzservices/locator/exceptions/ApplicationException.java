package com.info.mercedes.benzservices.locator.exceptions;

public class ApplicationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
    private String type;
	public ApplicationException(String code) {
		super();
		this.code = code;
	}
	public ApplicationException() {
		super();
		
	}
	
	
	public ApplicationException(String code, String message) {
		super(message);
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private void setType(ErrorType system) {
		this.type = system.toString();
		
	}
	protected void setTypeAsSystem() {
		setType(ErrorType.SYSTEM);
	}

}
