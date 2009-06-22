package com.skt.opensocial.persistence;

import java.util.Date;

public class GadgetReview {
	private long id;
	private long gadgetId;
	private String userId;
	private User user;
	private String reviewText;
	private int reviewGrade;
	private Date reviewDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getGadgetId() {
		return gadgetId;
	}

	public void setGadgetId(long gadgetId) {
		this.gadgetId = gadgetId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public int getReviewGrade() {
		return reviewGrade;
	}

	public void setReviewGrade(int reviewGrade) {
		this.reviewGrade = reviewGrade;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
