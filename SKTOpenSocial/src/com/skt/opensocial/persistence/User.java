package com.skt.opensocial.persistence;

import java.util.Date;
import java.util.Set;

public class User {
	private String userId;
	private String password;
	private boolean isDeveloper;
	private boolean isAdministrator;
	private Date registeredDate;
	private Person person;
	private Set<GadgetReview> reviews; // reviews by this user
	private Set<Gadget> gadgets; //  gadgets developed by this user
	private Set<Gadget> favoriteGadgets;
	private UserVisibility userVisibility;
	private Set<User> friends;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
		
	public boolean isDeveloper(){
		return getIsDeveloper();
	}
	
	private boolean getIsDeveloper() {
		return isDeveloper;
	}

	public void setIsDeveloper(boolean isDeveloper) {
		this.isDeveloper = isDeveloper;
	}

	public boolean isAdministrator(){
		return getIsAdministrator();
	}
	
	private boolean getIsAdministrator() {
		return isAdministrator;
	}

	public void setIsAdministrator(boolean isAdministrator) {
		this.isAdministrator = isAdministrator;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

	public Set<GadgetReview> getReviews() {
		return reviews;
	}

	public void setReviews(Set<GadgetReview> reviews) {
		this.reviews = reviews;
	}

	public Set<Gadget> getGadgets() {
		return gadgets;
	}

	public void setGadgets(Set<Gadget> gadgets) {
		this.gadgets = gadgets;
	}

	public void addGadget(Gadget gadget) {
		this.gadgets.add(gadget);
		setGadgets(this.gadgets);
	}
	
	public void removeGadget(Gadget gadget) {
		this.gadgets.remove(gadget);
		setGadgets(this.gadgets);
	}
	
	public Set<Gadget> getFavoriteGadgets() {
		return favoriteGadgets;
	}

	public void setFavoriteGadgets(Set<Gadget> favoriteGadgets) {
		this.favoriteGadgets = favoriteGadgets;
	}

	public UserVisibility getUserVisibility() {
		return userVisibility;
	}

	public void setUserVisibility(UserVisibility userVisibility) {
		this.userVisibility = userVisibility;
	}

	public Set<User> getFriends() {
		return friends;
	}

	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}
	
	public void addFriend(User user){
		Set<User> friends = getFriends();
		friends.add(user);
		setFriends(friends);
	}
}
