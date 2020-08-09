package com.info.mercedes.benzservices.locator.model;

import org.apache.commons.lang.builder.ToStringBuilder;

public class LocationValue {

	private String locationId;
	private Double distance;
	private String name;
	private String rating;
	private String address;
	private String availableItems;
	private String openingHours;
	private String icon;
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAvailableItems() {
		return availableItems;
	}
	public void setAvailableItems(String availableItems) {
		this.availableItems = availableItems;
	}
	public String getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public LocationValue(String locationId, Double distance, String name, String rating, String address,
			String availableItems, String openingHours, String icon) {
		super();
		this.locationId = locationId;
		this.distance = distance;
		this.name = name;
		this.rating = rating;
		this.address = address;
		this.availableItems = availableItems;
		this.openingHours = openingHours;
		this.icon = icon;
	}
	public LocationValue() {
		super();
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
	
	
}
