
package com.skt.opensocial.wrapper.persistence.spi;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletResponse;

import org.apache.shindig.auth.SecurityToken;
import org.apache.shindig.common.util.ImmediateFuture;
import org.apache.shindig.protocol.ProtocolException;
import org.apache.shindig.protocol.RestfulCollection;
import org.apache.shindig.social.core.model.ActivityImpl;
import org.apache.shindig.social.opensocial.model.Activity;
import org.apache.shindig.social.opensocial.model.MediaItem;
import org.apache.shindig.social.opensocial.spi.ActivityService;
import org.apache.shindig.social.opensocial.spi.CollectionOptions;
import org.apache.shindig.social.opensocial.spi.GroupId;
import org.apache.shindig.social.opensocial.spi.UserId;


import com.google.common.collect.Lists;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.skt.opensocial.wrapper.persistence.domain.ActivityMediaItemDB;
import com.skt.opensocial.wrapper.persistence.domain.ActivityTemplateParamDB;
import com.skt.opensocial.wrapper.persistence.util.IBATISSqlMapper;


public class ActivityDBService implements ActivityService {
	

	private SqlMapClient sqlMap = IBATISSqlMapper.getSqlMapInstance();
	
	public ActivityDBService () {
		
	}
	
	
	public Future<RestfulCollection<Activity>> getActivities(Set<UserId> userIds, GroupId groupId,
		      String appId, Set<String> fields, CollectionOptions options, SecurityToken token) throws ProtocolException {
		
		List<Activity> result = Lists.newArrayList();
		try {
			
			return ImmediateFuture.newInstance(new RestfulCollection<Activity>(result));
		} catch (Exception e) {
			throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}

	
	public Future<RestfulCollection<Activity>> getActivities(UserId userId, GroupId groupId,
		      String appId, Set<String> fields, CollectionOptions options, Set<String> activityIds,
		      SecurityToken token) throws ProtocolException {
		
		List<Activity> result = Lists.newArrayList();
		try {
			
			return ImmediateFuture.newInstance(new RestfulCollection<Activity>(result));
		} catch (Exception e) {
			throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}

	
	@SuppressWarnings("unchecked")
	public Future<Activity> getActivity(UserId userId, GroupId groupId, String appId,
		      Set<String> fields, String activityId, SecurityToken token) throws ProtocolException {
		
		try {
			Activity activity = new ActivityImpl();
			List<Activity> result = Lists.newArrayList();
			String user = userId.getUserId(token);
			result = sqlMap.queryForList("getActivity", user);
			
			for (int i=0; i<result.size(); i++) {
				activity = result.get(i); 
				
				if ( activity.getId().equals(activityId) ) {
					// get the mediaItems and templateParams of the activitiy stored separately
					activity.setMediaItems( sqlMap.queryForList("getMediaItems", activity) );
					activity.setTemplateParams( sqlMap.queryForMap("getTemplateParams", activity, "param_key", "param_value") );
					return ImmediateFuture.newInstance(activity);
				}
			}
			
			throw new ProtocolException(HttpServletResponse.SC_BAD_REQUEST, "Activity not found");
			
		} catch (Exception e) {
			throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public Future<Void> deleteActivities(UserId userId, GroupId groupId, String appId,
		      Set<String> activityIds, SecurityToken token) throws ProtocolException {
		
		try {
			Activity activity = new ActivityImpl();
			List<Activity> result = Lists.newArrayList();
			String user = userId.getUserId(token);
			result = sqlMap.queryForList("getActivity", user);
			
			for (int i=0; i<result.size(); i++) {
				activity = result.get(i); 
				
				if ( activityIds.contains(activity.getId() ) ) {
					sqlMap.delete("deleteActivities", activity);
					sqlMap.delete("deleteActivityMediaParams", activity);
					sqlMap.delete("deleteActivityTemplateParams", activity);
				}
			}
			
			return ImmediateFuture.newInstance(null);
		} catch (Exception e) {
			throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}

	
	public Future<Void> createActivity(UserId userId, GroupId groupId, String appId,
		      Set<String> fields, Activity activity, SecurityToken token) throws ProtocolException {
		
		try {
			if ( userId.getUserId(token) == activity.getUserId() ) {
				//**** insert activity with mediaItems and templateParams separately ****//
				sqlMap.insert("insertActivity", activity);
				this.insertMediaItem(activity.getId(), activity.getUserId(), activity.getMediaItems());
				this.insertTemplateParams(activity.getId(), activity.getUserId(), activity.getTemplateParams());
			
				return ImmediateFuture.newInstance(null);
			} else {
				throw new ProtocolException(HttpServletResponse.SC_BAD_REQUEST, "userId unmatched");
			}
		} catch (Exception e) {
			throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}
	
	
	private void insertMediaItem(String activityId, String userId, List<MediaItem> list) {
		try {
		  if (list != null) {
			  for ( MediaItem element : list ) {
				  ActivityMediaItemDB activityMediaItemDB = new ActivityMediaItemDB(activityId, userId, element);
				  sqlMap.insert("insertActivityMediaItem", activityMediaItemDB);
			  }
		  }
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void insertTemplateParams(String activityId, String userId, Map<String, String> templateParams) {
		try {
			if (templateParams != null) {
			Set<String> keySet = templateParams.keySet();
			
			for(String key : keySet) {
				String value = templateParams.get(key);		
				ActivityTemplateParamDB activityTemplateParamDB = new ActivityTemplateParamDB(activityId, userId, key, value);
				sqlMap.insert("insertActivityTemplateParam", activityTemplateParamDB);
			}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}