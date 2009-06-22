package com.skt.opensocial.common;

public class UserData {
	private String userId;
	private String userName;
	private boolean isAdministrator = false;
	private boolean isDeveloper = false;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isAdministrator() {
		return isAdministrator;
	}
	public void setAdministrator(boolean isAdministrator) {
		this.isAdministrator = isAdministrator;
	}
	public boolean isDeveloper() {
		return isDeveloper;
	}
	public void setDeveloper(boolean isDeveloper) {
		this.isDeveloper = isDeveloper;
	}
	
}
