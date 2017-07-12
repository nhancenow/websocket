package com.nhance.websocket.WebSocketApp.dto;

import java.util.Map;


public class LocationDTO {
	private Long locationId;
	private String name;
	private String address;
	private String landMark;
	private String city;
	private String district;
	private String pinCode;
//	private Integer stateId;
//	private Long countryId;
	private Integer locationStatus;
	private String countryName;
	private String stateName;
	private Double latitude;

	public Long getLocationId() {
		return locationId;
	}
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public Integer getLocationStatus() {
		return locationStatus;
	}
	public void setLocationStatus(Integer locationStatus) {
		this.locationStatus = locationStatus;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Map<String, String> getAddnInfo() {
		return addnInfo;
	}
	public void setAddnInfo(Map<String, String> addnInfo) {
		this.addnInfo = addnInfo;
	}
	private Double longitude;
	private Map<String, String> addnInfo;

	
}
