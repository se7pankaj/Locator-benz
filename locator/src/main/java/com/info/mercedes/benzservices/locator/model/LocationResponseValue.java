package com.info.mercedes.benzservices.locator.model;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class LocationResponseValue {

	List<Locations> locations;

	public List<Locations> getLocations() {
		return locations;
	}

	public void setLocations(List<Locations> locations) {
		this.locations = locations;
	}

	public LocationResponseValue(List<Locations> locations) {
		super();
		this.locations = locations;
	}

	public LocationResponseValue() {
		super();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
