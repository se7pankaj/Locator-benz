package com.info.mercedes.benzservices.locator.model.extapi_res;

import org.apache.commons.lang.builder.ToStringBuilder;

public class LocationList {

	private String distance;
	private String title;
	private String averageRating;
	private LoactionCategory category;
	private String icon;
	private String vicinity;
	private String id;
	private OpeningHours openingHours;

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(String averageRating) {
		this.averageRating = averageRating;
	}

	public LoactionCategory getCategory() {
		return category;
	}

	public void setCategory(LoactionCategory category) {
		this.category = category;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getVicinity() {
		return vicinity;
	}

	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public OpeningHours getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(OpeningHours openingHours) {
		this.openingHours = openingHours;
	}

	public LocationList(String distance, String title, String averageRating, LoactionCategory category, String icon,
			String vicinity, String id, OpeningHours openingHours) {
		super();
		this.distance = distance;
		this.title = title;
		this.averageRating = averageRating;
		this.category = category;
		this.icon = icon;
		this.vicinity = vicinity;
		this.id = id;
		this.openingHours = openingHours;
	}

	public LocationList() {
		super();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
