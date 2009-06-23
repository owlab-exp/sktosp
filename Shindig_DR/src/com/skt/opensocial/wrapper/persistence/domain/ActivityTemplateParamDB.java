
package com.skt.opensocial.wrapper.persistence.domain;


public class ActivityTemplateParamDB {
	private String param_key;
	private String param_value;
	private String activityId;
	private String userId;
	
	public ActivityTemplateParamDB() {
		
	}

	public ActivityTemplateParamDB(String activityId, String userId, String param_key, String param_value) {
		this.activityId = activityId;
		this.userId = userId;
		this.param_key = param_key;
		this.param_value = param_value;
	}
	
	public String getActivityId() {
		return activityId;
	}
	
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getParam_key() {
		return param_key;
	}
	
	public void setParam_key(String param_key) {
		this.param_key = param_key;
	}
	
	public String getParam_value() {
		return param_value;
	}
	
	public void setParam_value(String param_value) {
		this.param_value = param_value;
	}
}