package com.skt.opensocial.developer;

public class GadgetData {
	private String gadgetId; // ID
	private String gadgetName; // Name
	private String gadgetCategory; // Category
	private String gadgetIntro; // Introduction
	private String gadgetIconUrl; // Icon url
	public String getGadgetCategory() {
		return gadgetCategory;
	}
	public void setGadgetCategory(String gadgetCategory) {
		this.gadgetCategory = gadgetCategory;
	}
	public String getGadgetIntro() {
		return gadgetIntro;
	}
	public void setGadgetIntro(String gadgetIntro) {
		this.gadgetIntro = gadgetIntro;
	}
	public String getGadgetIconUrl() {
		return gadgetIconUrl;
	}
	public void setGadgetIconUrl(String gadgetIconUrl) {
		this.gadgetIconUrl = gadgetIconUrl;
	}
	public String getRegisterType() {
		return registerType;
	}
	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}
	public String getGadgetSource() {
		return gadgetSource;
	}
	public void setGadgetSource(String gadgetSource) {
		this.gadgetSource = gadgetSource;
	}
	public String getGadgetURL() {
		return gadgetURL;
	}
	public void setGadgetURL(String gadgetURL) {
		this.gadgetURL = gadgetURL;
	}
	private String registerType; // GadgetRegisterTypeConstants, except for multiple url
	private String gadgetSource; // gadget source text
	private String gadgetURL; // gadget URL text
	private String registerDate; // Registered Date
	private String publishDate; // Published Date
	private int numberOfUsers; // Number of users who includes this gadget in his/her favorite gadget list
	private String gadgetStatus; //GadgetStatusConstants strings
	
	public String getGadgetId() {
		return gadgetId;
	}
	public void setGadgetId(String gadgetId) {
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
