package com.info.mercedes.benzservices.locator.exceptions;

public class SystemException extends ApplicationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SystemException(String code) {
		super(code);
		setyType(code);
	}
	public SystemException(String code,String msg) {
		super(code,msg);
		setyType(code);
	}
	private void setyType(String code) {
		this.setTypeAsSystem();
	}
	
	
	
}
