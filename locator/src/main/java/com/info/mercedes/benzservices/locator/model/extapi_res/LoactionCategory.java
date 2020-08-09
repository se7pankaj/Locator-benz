package com.info.mercedes.benzservices.locator.model.extapi_res;

import org.apache.commons.lang.builder.ToStringBuilder;

public class LoactionCategory {

	private String id;
	private String title;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LoactionCategory(String id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public LoactionCategory() {
		super();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
