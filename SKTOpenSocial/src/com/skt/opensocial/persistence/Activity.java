package com.skt.opensocial.persistence;

import java.util.Date;

public class Activity {
	private int id;
	private String appId;
	private String body;
	private String bodyId;
	private String externalId;
	private String activityId;
	private Date updated;
	private Double postedTime;
	private Double priority;
	private String streamFaviconUrl;
	private String streamSourceUrl;
	private String streamTitle;
	private String streamUrl;
	private String title;
	private String titleId;
	private String url;
	private String userId;
	
	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getBodyId() {
		return bodyId;
	}
	public void setBodyId(String bodyId) {
		this.bodyId = bodyId;
	}
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Double getPostedTime() {
		return postedTime;
	}
	public void setPostedTime(Double postedTime) {
		this.postedTime = postedTime;
	}
	public Double getPriority() {
		return priority;
	}
	public void setPriority(Double priority) {
		this.priority = priority;
	}
	public String getStreamFaviconUrl() {
		return streamFaviconUrl;
	}
	public void setStreamFaviconUrl(String streamFaviconUrl) {
		this.streamFaviconUrl = streamFaviconUrl;
	}
	public String getStreamSourceUrl() {
		return streamSourceUrl;
	}
	public void setStreamSourceUrl(String streamSourceUrl) {
		this.streamSourceUrl = streamSourceUrl;
	}
	public String getStreamTitle() {
		return streamTitle;
	}
	public void setStreamTitle(String streamTitle) {
		this.streamTitle = streamTitle;
	}
	public String getStreamUrl() {
		return streamUrl;
	}
	public void setStreamUrl(String streamUrl) {
		this.streamUrl = streamUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleId() {
		return titleId;
	}
	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

}
