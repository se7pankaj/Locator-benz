package com.info.mercedes.benzservices.locator.model;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Locations {

	volatile private String locationType;
	List<LocationValue> responseValue;
	public String getLocationType() {
		return locationType;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	public List<LocationValue> getResponseValue() {
		return responseValue;
	}
	public void setResponseValue(List<LocationValue> responseValue) {
		this.responseValue = responseValue;
	}
	public Locations(String locationType, List<LocationValue> responseValue) {
		super();
		this.locationType = locationType;
		this.responseValue = responseValue;
	}
	public Locations() {
		super();
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
}
