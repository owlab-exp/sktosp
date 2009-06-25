package com.skt.opensocial.persistence;

public class TemplateParam {
private int id;
private String paramKey;
private String paramValue;
private int activityId;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getParamKey() {
	return paramKey;
}
public void setParamKey(String paramKey) {
	this.paramKey = paramKey;
}
public String getParamValue() {
	return paramValue;
}
public void setParamValue(String paramValue) {
	this.paramValue = paramValue;
}
public int getActivityId() {
	return activityId;
}
public void setActivityId(int activityId) {
	this.activityId = activityId;
}


}
