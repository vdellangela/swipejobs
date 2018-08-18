package com.vdellangela.swipejobs.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobSearchAddress {
	private String unit;
	private Integer maxJobDistance;
	private Double longitude;
	private Double latitude;

	public JobSearchAddress() {
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getMaxJobDistance() {
		return maxJobDistance;
	}

	public void setMaxJobDistance(Integer maxJobDistance) {
		this.maxJobDistance = maxJobDistance;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
}
