package com.info.mercedes.benzservices.locator.model.extapi_res;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class LocationsExtRes {

	List<LocationList> items;

	public List<LocationList> getItems() {
		return items;
	}

	public void setItems(List<LocationList> items) {
		this.items = items;
	}

	public LocationsExtRes(List<LocationList> items) {
		super();
		this.items = items;
	}

	public LocationsExtRes() {
		super();
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
