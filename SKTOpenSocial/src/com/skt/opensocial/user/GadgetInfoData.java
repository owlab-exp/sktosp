package com.skt.opensocial.user;
public class GadgetInfoData {
	private int gadgetId;
	private String gadgetName;
	private String registerDate;
	private String publishDate;
	private int numberOfUsers;
	private String gadgetStatus; //GadgetStatusConstants strings
	public int getGadgetId() {
		return gadgetId;
	}
	public void setGadgetId(int gadgetId) {
		this.gadgetId = gadgetId;
	}
	public String getGadgetName() {
		return gadgetName;
	}
	public void setGadgetName(String gadgetName) {
		this.gadgetName = gadgetName;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public int getNumberOfUsers() {
		return numberOfUsers;
	}
	public void setNumberOfUsers(int numberOfUsers) {
		this.numberOfUsers = numberOfUsers;
	}
	public String getGadgetStatus() {
		return gadgetStatus;
	}
	public void setGadgetStatus(String gadgetStatus) {
		this.gadgetStatus = gadgetStatus;
	}

}
