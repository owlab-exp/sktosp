package com.skt.opensocial.persistence;

// Generated Jun 25, 2009 4:34:44 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import java.util.Set;

/**
 * PersonOrganization generated by hbm2java
 */
public class PersonOrganization implements java.io.Serializable {

	private Integer id;
	//private String userId;
	private String description;
	private Date endDate;
	private String field;
	private String name;
	private String salary;
	private Date startDate;
	private String subField;
	private String title;
	private String webpage;
	private String type;
	private Boolean primary;
	private String addressCountry;
	private Double addressLatitude;
	private Double addressLongitude;
	private String addressLocality;
	private String addressPostalCode;
	private String addressRegion;
	private String addressStreetAddress;
	private String addressType;
	private String addressFormatted;
	private Boolean addressPrimary;
	private Person person;
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public PersonOrganization() {
	}

	/*public PersonOrganization(String userId, String description, Date endDate,
			String field, String name, String salary, Date startDate,
			String subField, String title, String webpage, String type,
			Boolean primary, String addressCountry, Double addressLatitude,
			Double addressLongitude, String addressLocality,
			String addressPostalCode, String addressRegion,
			String addressStreetAddress, String addressType,
			String addressFormatted, Boolean addressPrimary) {
		this.userId = userId;
		this.description = description;
		this.endDate = endDate;
		this.field = field;
		this.name = name;
		this.salary = salary;
		this.startDate = startDate;
		this.subField = subField;
		this.title = title;
		this.webpage = webpage;
		this.type = type;
		this.primary = primary;
		this.addressCountry = addressCountry;
		this.addressLatitude = addressLatitude;
		this.addressLongitude = addressLongitude;
		this.addressLocality = addressLocality;
		this.addressPostalCode = addressPostalCode;
		this.addressRegion = addressRegion;
		this.addressStreetAddress = addressStreetAddress;
		this.addressType = addressType;
		this.addressFormatted = addressFormatted;
		this.addressPrimary = addressPrimary;
	}*/

	public Integer getId() {
		return this.id;
	}

	private void setId(Integer id) {
		this.id = id;
	}

//	public String getUserId() {
//		return this.userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return this.salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getSubField() {
		return this.subField;
	}

	public void setSubField(String subField) {
		this.subField = subField;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWebpage() {
		return this.webpage;
	}

	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getPrimary() {
		return this.primary;
	}

	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}

	public String getAddressCountry() {
		return this.addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	public Double getAddressLatitude() {
		return this.addressLatitude;
	}

	public void setAddressLatitude(Double addressLatitude) {
		this.addressLatitude = addressLatitude;
	}

	public Double getAddressLongitude() {
		return this.addressLongitude;
	}

	public void setAddressLongitude(Double addressLongitude) {
		this.addressLongitude = addressLongitude;
	}

	public String getAddressLocality() {
		return this.addressLocality;
	}

	public void setAddressLocality(String addressLocality) {
		this.addressLocality = addressLocality;
	}

	public String getAddressPostalCode() {
		return this.addressPostalCode;
	}

	public void setAddressPostalCode(String addressPostalCode) {
		this.addressPostalCode = addressPostalCode;
	}

	public String getAddressRegion() {
		return this.addressRegion;
	}

	public void setAddressRegion(String addressRegion) {
		this.addressRegion = addressRegion;
	}

	public String getAddressStreetAddress() {
		return this.addressStreetAddress;
	}

	public void setAddressStreetAddress(String addressStreetAddress) {
		this.addressStreetAddress = addressStreetAddress;
	}

	public String getAddressType() {
		return this.addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddressFormatted() {
		return this.addressFormatted;
	}

	public void setAddressFormatted(String addressFormatted) {
		this.addressFormatted = addressFormatted;
	}

	public Boolean getAddressPrimary() {
		return this.addressPrimary;
	}

	public void setAddressPrimary(Boolean addressPrimary) {
		this.addressPrimary = addressPrimary;
	}

}