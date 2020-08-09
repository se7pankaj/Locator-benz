package com.info.mercedes.benzservices.locator.exceptions;

import java.io.IOException;

import com.info.mercedes.benzservices.locator.exceptions.advice.ErrorResponse;

public class ClientErrorException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ErrorResponse error;

	
	public ClientErrorException() {
		super();
	}
	public ClientErrorException(String error) {
		super(error);
	}
	public ClientErrorException(Throwable error) {
		super(error);
	}
	public ClientErrorException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	public ErrorResponse getError() {
		return error;
	}
	public void setError(ErrorResponse error) {
		this.error = error;
	}
	
	
	
	
}
