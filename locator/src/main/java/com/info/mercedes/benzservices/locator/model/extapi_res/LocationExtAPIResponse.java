package com.info.mercedes.benzservices.locator.model.extapi_res;

import org.apache.commons.lang.builder.ToStringBuilder;

public class LocationExtAPIResponse {

	private LocationsExtRes results;

	public LocationExtAPIResponse(LocationsExtRes results) {
		super();
		this.results = results;
	}

	public LocationsExtRes getResults() {
		return results;
	}

	public void setResults(LocationsExtRes results) {
		this.results = results;
	}

	public LocationExtAPIResponse() {
		super();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
}
