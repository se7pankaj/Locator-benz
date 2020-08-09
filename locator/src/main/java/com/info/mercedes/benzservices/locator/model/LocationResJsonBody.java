package com.info.mercedes.benzservices.locator.model;

import org.apache.commons.lang.builder.ToStringBuilder;

public class LocationResJsonBody {

	private LocationResponseValue value ;

	public LocationResponseValue getValue() {
		return value;
	}

	public void setValue(LocationResponseValue value) {
		this.value = value;
	}

	public LocationResJsonBody(LocationResponseValue value) {
		super();
		this.value = value;
	}

	public LocationResJsonBody() {
		super();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
	
}
