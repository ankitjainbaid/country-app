package com.country.model;

public class Country {

	private String serialNo;
	private String countryCode;
	private String countryName;

	public Country(String serialNo, String countryCode, String countryName) {
		this.serialNo = serialNo;
		this.countryCode = countryCode;
		this.countryName = countryName;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
