
package com.skt.opensocial.wrapper.persistence.domain;

import org.apache.shindig.social.opensocial.model.MediaItem;
import org.apache.shindig.social.opensocial.model.MediaItem.Type;

public class ActivityMediaItemDB {
	
	  private String mimeType;
	  private String type;
	  private String url;
	  private String thumbnailUrl;
	  private String activityId;
	  private String userId;

	  public ActivityMediaItemDB() {
	  }

	  public ActivityMediaItemDB(String activityId, String userId, MediaItem mediaItem) {
		  this.activityId = activityId;
		  this.userId = userId;
	    this.mimeType = mediaItem.getMimeType();
	    this.type = String.valueOf( mediaItem.getType() );
	    this.url = mediaItem.getUrl();
	    this.thumbnailUrl = mediaItem.getThumbnailUrl();
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

	  public String getMimeType() {
	    return mimeType;
	  }

	  public void setMimeType(String mimeType) {
	    this.mimeType = mimeType;
	  }

	  public String getType() {
	    return type;
	  }

	  public void setType(String type) {
	    this.type = type;
	  }

	  public String getUrl() {
	    return url;
	  }

	  public void setUrl(String url) {
	    this.url = url;
	  }
	  public String getThumbnailUrl() { return this.thumbnailUrl;}
	  public void setThumbnailUrl(String url) { this.thumbnailUrl = url;}

}