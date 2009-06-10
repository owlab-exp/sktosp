package com.skt.opensocial.admin;

import java.sql.Date;

public class Gadget {

	private String name;
	private String owner;
	private String numRegUsers;
	private String desc;
	private String createdDate;
	private String status;
	private String imagepath;
	private String nextstate;

	public String getNextstate() {
		return nextstate;
	}

	public void setNextstate(String nextstate) {
		this.nextstate = nextstate;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public Gadget() {
		
	}
	
	public Gadget(String name, String ownerId) {
		this.name	= name;
		this.owner	= ownerId;
	}
	public String toString() {
		return name + " " + desc + "thisisgadget";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getNumRegUsers() {
		return numRegUsers;
	}
	public void setNumRegUsers(String numRegUsers) {
		this.numRegUsers = numRegUsers;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
