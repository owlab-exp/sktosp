package com.skt.opensocial.persistence;

// Generated Jun 25, 2009 4:34:44 PM by Hibernate Tools 3.2.4.GA

/**
 * GadgetCategory generated by hbm2java
 */
public class GadgetCategory implements java.io.Serializable {

	private String id;
	private String name;

	public GadgetCategory() {
	}

	public GadgetCategory(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
