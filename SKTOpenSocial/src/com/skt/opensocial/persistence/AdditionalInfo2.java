package com.skt.opensocial.persistence;

public class AdditionalInfo2 {
	private int id;
	private String personId;
	private String attribute;
	private String fieldType;
	private String fieldValue;
	private boolean fieldPrimary;
	
	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	public boolean isFieldPrimary() {
		return fieldPrimary;
	}
	public void setFieldPrimary(boolean fieldPrimary) {
		this.fieldPrimary = fieldPrimary;
	}
	
	
}
