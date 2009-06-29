package com.skt.opensocial.persistence;

import java.util.Set;

// Generated Jun 25, 2009 4:34:44 PM by Hibernate Tools 3.2.4.GA

/**
 * PersonAccount generated by hbm2java
 */
public class PersonAccount implements java.io.Serializable {

	private Integer id;
	private String domain;
	//private String userId;
	private String userName;
	private Person person;
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public PersonAccount() {
	}

	/*public PersonAccount(String domain, String userId, String userName) {
		this.domain = domain;
		this.userId = userId;
		this.userName = userName;
	}*/

	public Integer getId() {
		return this.id;
	}

	private void setId(Integer id) {
		this.id = id;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	/*public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}*/

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}