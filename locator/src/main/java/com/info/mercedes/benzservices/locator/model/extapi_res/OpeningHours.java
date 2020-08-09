package com.info.mercedes.benzservices.locator.model.extapi_res;

import org.apache.commons.lang.builder.ToStringBuilder;

public class OpeningHours {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public OpeningHours(String text) {
		super();
		this.text = text;
	}

	public OpeningHours() {
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
	
}
