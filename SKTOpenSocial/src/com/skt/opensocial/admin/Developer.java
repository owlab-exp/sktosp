package com.skt.opensocial.admin;

public class Developer {

	private String name;
	private String id;
	private String email;
	private String phone;
	private String regDate;
	private String status;

	public Developer() {
		
	}
	
	public Developer(String name, String id) {
		this.name	= name;
		this.id		= id;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return name + " " + id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
