package com.skt.opensocial.persistence;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Gadget {
	private long id;
	private String name;
	private Date registerDate;
	private Date publishDate;
	private String status;
	private String registerType;
	private String introduction;
	private String source;
	private String iconUrl;
	private String developerId;
	private User developer;
	private Set<GadgetCategory> categories;
	private Set<GadgetReview> reviews;
	private Set<User> favoriteUsers;
	
	public long getId() {
		return id;
	}
	private void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRegisterType() {
		return registerType;
	}
	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	public String getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(String developerId) {
		this.developerId = developerId;
	}
	public Set<GadgetCategory> getCategories() {
		return categories;
	}
	public void setCategories(Set<GadgetCategory> categories) {
		this.categories = categories;
	}
	public void addCategory(GadgetCategory category){
		Set<GadgetCategory> set = getCategories();
		if(set == null)
			set = new HashSet<GadgetCategory>();
		set.add(category);
		setCategories(set);
	}
	public Set<GadgetReview> getReviews() {
		return reviews;
	}
	public void setReviews(Set<GadgetReview> reviews) {
		this.reviews = reviews;
	}
	public User getDeveloper() {
		return developer;
	}
	public void setDeveloper(User developer) {
		this.developer = developer;
	}
	public Set<User> getFavoriteUsers() {
		return favoriteUsers;
	}
	public void setFavoriteUsers(Set<User> favoriteUsers) {
		this.favoriteUsers = favoriteUsers;
	}

	
}
