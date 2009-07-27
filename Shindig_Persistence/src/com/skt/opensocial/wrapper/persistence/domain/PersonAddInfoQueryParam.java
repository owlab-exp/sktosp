

package com.skt.opensocial.wrapper.persistence.domain;


public class PersonAddInfoQueryParam {
	private String userId;
	private String attribute;
	
	public PersonAddInfoQueryParam(String userId, String attribute) {
		this.userId = userId;
		this.attribute = attribute;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getAttribute() {
		return attribute;
	}
	
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
}