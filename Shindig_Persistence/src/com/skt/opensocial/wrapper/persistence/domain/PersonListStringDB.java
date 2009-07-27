
package com.skt.opensocial.wrapper.persistence.domain;

public class PersonListStringDB {
	private String person_id;
	private Attribute attribute;
	private String value;
	
	public static enum Attribute {
		/** the mysql field for activities. */
		activities,
		/** the mysql field for books. */
		books,
		/** the mysql field for cars. */
		cars,
		/** the mysql field for food. */
		food,
		/** the mysql field for heroes. */
		heroes,
		/** the mysql field for interests. */
		interests,
		/** the mysql field for languagesSpoken. */
		languagesSpoken,
		/** the mysql field for lookingFor. */
		lookingFor,
		/** the mysql field for movies. */
		movies,
		/** the mysql field for music. */
		music,
		/** the mysql field for quotes. */
		quotes,
		/** the mysql field for sports. */
		sports,
		/** the mysql field for tags. */
		tags,
		/** the mysql field for turnOffs. */
		turnOffs,
		/** the mysql field for turnOns. */
		turnOns,
		/** the mysql field for tvShows. */
		tvShows,
	}
	
	
	public PersonListStringDB(String person_id, Attribute attribute) {
		this.person_id = person_id;
		this.attribute = attribute;
	}
	
	public PersonListStringDB(String person_id, Attribute attribute, String value) {
		this.person_id = person_id;
		this.attribute = attribute;
		this.value = value;
	}
	
	public String getPersonId() {
		return this.person_id;
	}
	
	public void setPersonId(String person_id) {
		this.person_id = person_id;
	}
	
	public Attribute getAttribute() {
		return this.attribute;
	}
	
	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}