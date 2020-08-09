package com.info.mercedes.benzservices.locator.exceptions.advice;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private String errorMessage;
	private int rawStatusCode;
	private String statusText;
	private HttpStatus statusCode;

	public ErrorResponse(String errorMessage, int rawStatusCode, String statusText, HttpStatus statusCode) {
		super();
		this.errorMessage = errorMessage;
		this.rawStatusCode = rawStatusCode;
		this.statusText = statusText;
		this.statusCode = statusCode;
	}

	public ErrorResponse(String errorMessage, HttpStatus statusCode) {
		super();
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getRawStatusCode() {
		return rawStatusCode;
	}

	public void setRawStatusCode(int rawStatusCode) {
		this.rawStatusCode = rawStatusCode;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

}
