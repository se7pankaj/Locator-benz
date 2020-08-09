package com.info.mercedes.benzservices.locator.model;

import org.apache.commons.lang.builder.ToStringBuilder;

public class LocationResponse {

	private Integer status ;
	private LocationResJsonBody jsonBody;
	public LocationResponse() {
		super();
	}
	public LocationResponse(Integer status, LocationResJsonBody jsonBody) {
		super();
		this.status = status;
		this.jsonBody = jsonBody;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocationResJsonBody getJsonBody() {
		return jsonBody;
	}
	public void setJsonBody(LocationResJsonBody jsonBody) {
		this.jsonBody = jsonBody;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
}
