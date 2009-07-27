
package com.skt.opensocial.wrapper.persistence.domain;

import org.apache.shindig.social.opensocial.model.ListField;

public class PersonListFieldDB {
	private String person_id;
	private Attribute attribute;
	private String type;	
	private String value;
	private Boolean primary;
	
	public static enum Attribute {
		/** the mysql field for emails. */
		emails,
		/** the mysql field for ims. */
		ims,
		/** the mysql field for phoneNumbers. */
		phoneNumbers,
		/** the mysql field for photos. */
		photos,
	}
	
	public PersonListFieldDB(String person_id, Attribute attribute, ListField data) {
		this.person_id = person_id;
		this.attribute = attribute;
		this.type = data.getType();
		this.value = data.getValue();
		this.primary = data.getPrimary();
	}
	
	public PersonListFieldDB(String person_id, Attribute attribute, String type, String value, Boolean primary) {
		this.person_id = person_id;
		this.attribute = attribute;
		this.type = type;
		this.value = value;
		this.primary = primary;
	}
	
	public String getPersonId() {
		return person_id;
	}
	
	public void setPersonId(String person_id) {
		this.person_id = person_id;
	}
	
	public Attribute getAttribute() {
		return attribute;
	}
	
	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public Boolean getPrimary() {
		return primary;
	}
	
	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}
}