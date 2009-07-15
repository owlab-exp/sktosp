
package com.skt.opensocial.wrapper.persistence.spi;

import java.util.ArrayList;
import java.util.HashSet;
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
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.json.JSONException;


import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;
import com.skt.opensocial.persistence.ActivityMediaItem;
import com.skt.opensocial.persistence.ActivityTemplateParam;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.ItemTypeEnum;
import com.skt.opensocial.persistence.User;
import com.skt.opensocial.wrapper.persistence.util.HDBTableMapper;

import com.skt.opensocial.persistence.Person;


public class HActivityDBService implements ActivityService {
	

	public HActivityDBService () {
		
	}
	
	@SuppressWarnings("unchecked")
	public Future<RestfulCollection<Activity>> getActivities(Set<UserId> userIds, GroupId groupId,
		      String appId, Set<String> fields, CollectionOptions options, SecurityToken token) throws ProtocolException {
		
		List<Activity> activityList = Lists.newArrayList();
		
		try {
//			List<Activity> result = Lists.newArrayList();
//			
//			Set<String> idSet = getIdSet(userIds, groupId, token);
//			
//			
//			// for all users in the idSet, get activities of each user
//		    for (String userId : idSet) {
//				result = sqlMap.queryForList("getActivities", userId);
//				
//				// get Activities of each user
//				for (int i=0; i<result.size(); i++) {
//					Activity activity = new ActivityImpl();
//					activity = result.get(i); 
//					
//					//*** get the mediaItems and templateParams of the activitiy stored separately ***//
//					activity.setTemplateParams( sqlMap.queryForMap("getTemplateParams", activity, "param_key", "param_value") );
//					//activity.setMediaItems( sqlMap.queryForList("getMediaItems", activity) );
//				
//					activityList.add(activity);
//				}
//		    }
			
			Set<String> idSet = getIdSet(userIds, groupId, options, token);
			
			Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tran = hs.beginTransaction();
			
			for (String userId : idSet) {			
				
				Person person = (Person) hs.get(Person.class, userId);
								
				Set<com.skt.opensocial.persistence.Activity> activityDBSet = person.getActivities();
//				appDataDBList = sqlMap.queryForList("getPersonAppData", userId);
				
				for (com.skt.opensocial.persistence.Activity activityDB : activityDBSet) {
					if(appId != null) {
						if ( activityDB.getAppId() != null && !activityDB.getAppId().equals(appId) ) {
							continue;
						}
					}
					
					Activity activity = new ActivityImpl();
					activity = HDBTableMapper.getActivityFromActivityDB(activityDB);
					
					//*** get MediaItems ***//
					Criteria crit = hs.createCriteria(ActivityMediaItem.class);
					crit.setMaxResults(30);		
					
					// filer by an userId and an activityId
					crit = hs.createCriteria(ActivityMediaItem.class);
					List<ActivityMediaItem> items = crit.add(Restrictions.eq("userId", userId)).list();
//					Query q = hs.createQuery("select * from ActivityMediaItem where userId = userId");
//					List<ActivityMediaItem> items = (List<ActivityMediaItem>) q.list();
//					
					if (items.size() > 0) {
						List<MediaItem> mediaItemList = HDBTableMapper.getMediaItemListFromMediaItemDBList( items );
						activity.setMediaItems(mediaItemList);
					}
					
					
					//*** get TemplateParams ***//
					Criteria crit2 = hs.createCriteria(ActivityMediaItem.class);
					crit2.setMaxResults(30);
					
					// filer by an userId and an activityId
					crit2 = hs.createCriteria(ActivityTemplateParam.class);
					List<ActivityTemplateParam> params = crit2.add(Restrictions.eq("userId", userId)).list();
					if (params.size() > 0) {
						Map<String, String> templateParamMap = HDBTableMapper.getTemplateParamMapFromTemplateParamDBList( params );					
						activity.setTemplateParams(templateParamMap);
					}
					
					activityList.add(activity);
				}
			}
			
			tran.commit();
			
		    return ImmediateFuture.newInstance(new RestfulCollection<Activity>(activityList));
		    
		} catch (Exception e) {
			throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public Future<RestfulCollection<Activity>> getActivities(UserId userId, GroupId groupId,
		      String appId, Set<String> fields, CollectionOptions options, Set<String> activityIds,
		      SecurityToken token) throws ProtocolException {
		
		List<Activity> activityList = Lists.newArrayList();

	
		try {
			
//			List<Activity> result = Lists.newArrayList();
//			Set<String> idSet = getIdSet(userId, groupId, options, token);
//			
//			// for all users in the idSet, get activities of each user
//		    for (String user : idSet) {
//				result = sqlMap.queryForList("getActivities", user);
//				
//				for (int i=0; i<result.size(); i++) {
//					Activity activity = new ActivityImpl();
//					activity = result.get(i); 
//					
//					for (String activityId : activityIds) {
//						if ( activity.getId().equals(activityId) ) {
//							//*** get the mediaItems and templateParams of the activitiy stored separately ***//
//							activity.setTemplateParams( sqlMap.queryForMap("getTemplateParams", activity, "param_key", "param_value") );
//							activity.setMediaItems( sqlMap.queryForList("getMediaItems", activity) );
//							
//							activityList.add(activity);
//						}
//					}
//				}
//		    }
			
			Set<String> idSet = getIdSet(userId, groupId, options, token);
			
			Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tran = hs.beginTransaction();
			
			for (String user : idSet) {			
				
				Person person = (Person) hs.get(Person.class, user);
								
				Set<com.skt.opensocial.persistence.Activity> activityDBSet = person.getActivities();
//				appDataDBList = sqlMap.queryForList("getPersonAppData", userId);
				
				for (com.skt.opensocial.persistence.Activity activityDB : activityDBSet) {
					if(appId != null) {
						if ( activityDB.getAppId() != null && !activityDB.getAppId().equals(appId) ) {
							continue;
						}
					}
					
					Activity activity = new ActivityImpl();
					activity = HDBTableMapper.getActivityFromActivityDB(activityDB);
					
					String activityId = activity.getId();
					
					if(activityIds != null) {
						if( activityId != null && !activityIds.contains(activityId)) {
							continue;
						}
					}
					
					//*** get MediaItems ***//
					Criteria crit = hs.createCriteria(ActivityMediaItem.class);
					crit.setMaxResults(30);
					
					// filer by an userId and an activityId
					crit = hs.createCriteria(ActivityMediaItem.class);
					List<ActivityMediaItem> items = crit.add(Restrictions.eq("userId", user)).add(Restrictions.eq("activityId", activityId)).list();
					if (items.size() > 0) {
						List<MediaItem> mediaItemList = HDBTableMapper.getMediaItemListFromMediaItemDBList( items );
						activity.setMediaItems(mediaItemList);
					}
						
					//*** get TemplateParams ***//
					Criteria crit2 = hs.createCriteria(ActivityMediaItem.class);
					crit2.setMaxResults(30);	
					
					// filer by an userId and an activityId
					crit2 = hs.createCriteria(ActivityTemplateParam.class);
					List<ActivityTemplateParam> params = crit2.add(Restrictions.eq("userId", user)).add(Restrictions.eq("activityId", activityId)).list();
					if (params.size() > 0) {
						Map<String, String> templateParamMap = HDBTableMapper.getTemplateParamMapFromTemplateParamDBList( params );					
						activity.setTemplateParams(templateParamMap);
					}
					
					// add the activity into the list
					activityList.add(activity);
	
				}
			}
			
			tran.commit();
		
			return ImmediateFuture.newInstance(new RestfulCollection<Activity>(activityList));
			
		} catch (Exception e) {
			throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
		
	}

	@SuppressWarnings("unchecked")
	public Future<Activity> getActivity(UserId userId, GroupId groupId, String appId,
		      Set<String> fields, String activityId, SecurityToken token) throws ProtocolException {
		
		try {
//			List<Activity> result = Lists.newArrayList();
//			String user = userId.getUserId(token);
//			result = sqlMap.queryForList("getActivities", user);
//			
//			for (int i=0; i<result.size(); i++) {
//				Activity activity = new ActivityImpl();
//				activity = result.get(i); 
//				
//				if ( activity.getId().equals(activityId) ) {
//					//*** get the mediaItems and templateParams of the activitiy stored separately ***//
//					activity.setTemplateParams( sqlMap.queryForMap("getTemplateParams", activity, "param_key", "param_value") );
//					activity.setMediaItems( sqlMap.queryForList("getMediaItems", activity) );
//				
//					return ImmediateFuture.newInstance(activity);
//				}
//			}
			Set<String> idSet = getIdSet(userId, groupId, token);
			
			Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tran = hs.beginTransaction();
			
			for (String user : idSet) {			
				Person person = (Person) hs.get(Person.class, user);
				
				Set<com.skt.opensocial.persistence.Activity> activityDBSet = person.getActivities();
//				appDataDBList = sqlMap.queryForList("getPersonAppData", userId);
				
				for (com.skt.opensocial.persistence.Activity activityDB : activityDBSet) {
					if(appId != null) {
						if ( activityDB.getAppId() != null && !activityDB.getAppId().equals(appId) ) {
							continue;
						}
					}
					
					Activity activity = new ActivityImpl();
					activity = HDBTableMapper.getActivityFromActivityDB(activityDB);
					
					if( activityId != null ) {
						if ( activity.getId() != null && !activityId.equals(activity.getId()) ) {
							continue;
						}
					}
					
					//*** get MediaItems ***//
					Criteria crit = hs.createCriteria(ActivityMediaItem.class);
					crit.setMaxResults(30);	
					
					// filer by an userId and an activityId
					crit = hs.createCriteria(ActivityMediaItem.class);
					List<ActivityMediaItem> items = crit.add(Restrictions.eq("userId", user)).add(Restrictions.eq("activityId", activityId)).list();
					if (items.size() > 0) {
						List<MediaItem> mediaItemList = HDBTableMapper.getMediaItemListFromMediaItemDBList( items );
						activity.setMediaItems(mediaItemList);
					}
						
					//*** get TemplateParams ***//
					Criteria crit2 = hs.createCriteria(ActivityMediaItem.class);
					crit2.setMaxResults(30);

					// filer by an userId and an activityId
					crit2 = hs.createCriteria(ActivityTemplateParam.class);
					List<ActivityTemplateParam> params = crit2.add(Restrictions.eq("userId", user)).add(Restrictions.eq("activityId", activityId)).list();
					if (params.size() > 0) {
						Map<String, String> templateParamMap = HDBTableMapper.getTemplateParamMapFromTemplateParamDBList( params );					
						activity.setTemplateParams(templateParamMap);
					}

					tran.commit();
					
					return ImmediateFuture.newInstance(activity);
	
				}
			}

			tran.commit();
			
			throw new ProtocolException(HttpServletResponse.SC_BAD_REQUEST, "Activity not found");
			
		} catch (Exception e) {
			throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public Future<Void> deleteActivities(UserId userId, GroupId groupId, String appId,
		      Set<String> activityIds, SecurityToken token) throws ProtocolException {
		
		try {
//			Activity activity = new ActivityImpl();
//			List<Activity> result = Lists.newArrayList();
//			String user = userId.getUserId(token);
//			result = sqlMap.queryForList("getActivities", user);
//			
//			for (int i=0; i<result.size(); i++) {
//				activity = result.get(i); 
//				
//				if ( activityIds.contains(activity.getId() ) ) {
//					sqlMap.delete("deleteActivities", activity);
//					sqlMap.delete("deleteActivityMediaParams", activity);
//					sqlMap.delete("deleteActivityTemplateParams", activity);
//				}
//			}
			
			Set<String> idSet = getIdSet(userId, groupId, token);
			
			Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tran = hs.beginTransaction();
			
			for (String user : idSet) {			
				
				Person person = (Person) hs.get(Person.class, user);
								
				Set<com.skt.opensocial.persistence.Activity> activityDBSet = person.getActivities();
//				appDataDBList = sqlMap.queryForList("getPersonAppData", userId);
				
				for (com.skt.opensocial.persistence.Activity activityDB : activityDBSet) {
					if(appId != null) {
						if ( activityDB.getAppId() != null && !activityDB.getAppId().equals(appId) ) {
							continue;
						}
					}
					
					Activity activity = new ActivityImpl();
					activity = HDBTableMapper.getActivityFromActivityDB(activityDB);
					
					String activityId = activity.getId();
					
					if( activityIds != null ) {
						if( activityId != null && !activityIds.contains(activityId)) {
							continue;
						}
					}
					
					//*** delete MediaItems ***//
					Criteria crit = hs.createCriteria(ActivityMediaItem.class);
					
					// filer by an userId and an activityId
					crit = hs.createCriteria(ActivityMediaItem.class);
					List<ActivityMediaItem> items = crit
					.add(Restrictions.eq("userId", user))
					.add(Restrictions.eq("activityId", activityId))
					.list();
					
					for(ActivityMediaItem item: items) {
						hs.delete(item);
					}
					
					//*** delete TemplateParams ***//
					Criteria crit2 = hs.createCriteria(ActivityTemplateParam.class);
					
					// filer by an userId and an activityId
					crit2 = hs.createCriteria(ActivityTemplateParam.class);
					List<ActivityTemplateParam> params = crit2
					.add(Restrictions.eq("userId", user))
					.add(Restrictions.eq("activityId", activityId))
					.list();
					
					for(ActivityTemplateParam param: params) {
						hs.delete(param);
					}
					
					//*** delete activity ***//
					hs.delete(activity);
	
				}
			}
			
			tran.commit();
			
			return ImmediateFuture.newInstance(null);
		} catch (Exception e) {
			throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}

	
	public Future<Void> createActivity(UserId userId, GroupId groupId, String appId,
		      Set<String> fields, Activity activity, SecurityToken token) throws ProtocolException {
		
		try {
			//**** insert activity with mediaItems and templateParams separately ****//
//			activity.setUserId(userId.getUserId(token));
//			sqlMap.insert("insertActivity", activity);
//			this.insertMediaItem(activity.getId(), activity.getUserId(), activity.getMediaItems());
//			this.insertTemplateParams(activity.getId(), activity.getUserId(), activity.getTemplateParams());

			Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tran = hs.beginTransaction();
			
			// create Activity
			String user = userId.getUserId(token); 
			hs.saveOrUpdate( this.setActivityDBFromActivity(user, appId, activity) );
			
			// create MediaItems of the Activity
			List<MediaItem> items = activity.getMediaItems();
			for(MediaItem item : items) {
				hs.saveOrUpdate( this.setMediaItemDBFromMediaItem(user, activity.getId(), item) );
			}
			
			// create TemplateParams of the activity
			Map<String, String> params = activity.getTemplateParams();
			Set<String> keys = params.keySet();
			for(String key : keys) {
				hs.saveOrUpdate( this.setTemplateParamDBFromTemplateParma(user, activity.getId(), key, params.get(key)) );
			}
			
			tran.commit();
			
			return ImmediateFuture.newInstance(null);
		
		} catch (Exception e) {
			throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}
	
	private com.skt.opensocial.persistence.ActivityTemplateParam setTemplateParamDBFromTemplateParma(String userId, String activityId, String Key, String value) {
		com.skt.opensocial.persistence.ActivityTemplateParam templateParamDB = new com.skt.opensocial.persistence.ActivityTemplateParam();
		
		templateParamDB.setActivityId( activityId );
		templateParamDB.setParamKey( Key );
		templateParamDB.setParamValue( value );
		templateParamDB.setUserId( userId );
		
		return templateParamDB;
	}
	
	
	private com.skt.opensocial.persistence.Activity setActivityDBFromActivity(String userId, String appId, Activity activity) {
		com.skt.opensocial.persistence.Activity activityDB = new com.skt.opensocial.persistence.Activity();
		
		activityDB.setActivityId( activity.getId() );
		
		if( appId != null )
			activityDB.setAppId(appId);
		else
			activityDB.setAppId( activity.getAppId() );
		
		activityDB.setBody( activity.getBody() );
		activityDB.setBodyId( activity.getBodyId() );
		activityDB.setExternalId( activity.getExternalId() );
		activityDB.setPostedTime( new Double(activity.getPostedTime()) );
		activityDB.setPriority( new Double(activity.getPriority()) );
		activityDB.setStreamFaviconUrl( activity.getStreamFaviconUrl() );
		activityDB.setStreamSourceUrl( activity.getStreamSourceUrl() );
		activityDB.setStreamTitle( activity.getStreamTitle() );
		activityDB.setStreamUrl( activity.getStreamUrl() );
		activityDB.setTitle( activity.getTitle() );
		activityDB.setTitleId( activity.getTitleId() );
		activityDB.setUpdated( activity.getUpdated() );
		activityDB.setUrl( activity.getUrl() );
		activityDB.setUserId( userId );
		
		return activityDB;
		
	}
	
	
	private com.skt.opensocial.persistence.ActivityMediaItem setMediaItemDBFromMediaItem(String userId, String activityId, MediaItem mediaItem) {
		com.skt.opensocial.persistence.ActivityMediaItem mediaItemDB = new com.skt.opensocial.persistence.ActivityMediaItem();
		
		mediaItemDB.setActivityId( activityId );
		mediaItemDB.setMimeType( mediaItem.getMimeType() );
		mediaItemDB.setThumbnailUrl( mediaItem.getThumbnailUrl() );
		
		if ( mediaItem.getType().equals(MediaItem.Type.AUDIO ) )
			mediaItemDB.setType( ItemTypeEnum.AUDIO );
		else if ( mediaItem.getType().equals(MediaItem.Type.IMAGE ) )
			mediaItemDB.setType( ItemTypeEnum.IMAGE );
		else if ( mediaItem.getType().equals(MediaItem.Type.VIDEO ) )
			mediaItemDB.setType( ItemTypeEnum.VIDEO );
		
		mediaItemDB.setUrl( mediaItem.getUrl() );
		mediaItemDB.setUserId( userId );
		
		return mediaItemDB;
	}
	
	

	/**
	 * Get the set of user id's for a set of users and a group
	 */
	private Set<String> getIdSet(Set<UserId> users, GroupId group,
			CollectionOptions options, SecurityToken token)
			throws JSONException {
		Set<String> ids = new HashSet<String>();
		for (UserId user : users) {
			ids.addAll(getIdSet(user, group, options, token));

		}
		return ids;
	}

	/**
	 * Get the set of user id's from a user and group
	 */
	@SuppressWarnings("unchecked")
	private Set<String> getIdSet(UserId userId, GroupId groupId,
			CollectionOptions options, SecurityToken token)
			throws JSONException {

		String user = userId.getUserId(token);

		if (groupId == null) {
			return ImmutableSortedSet.of(user);
		}

		Set<String> idSet = new HashSet<String>();

		switch (groupId.getType()) {
		case all:
			// idSet.add(user);
			List<String> allUserIds = null;
			try {
				// List<String> allUserIds = sqlMap.queryForList(
				// "getAllUserIds" );
				Session hs = HibernateUtil.getSessionFactory()
						.getCurrentSession();
				Transaction tran = hs.beginTransaction();

				// Criteria crit = hs.createCriteria(User.class);
				Query q = hs.createQuery("select id from User");
				allUserIds = (List<String>) q.list();

				tran.commit();

			} catch (Exception e) {
				HibernateUtil.getSessionFactory().getCurrentSession()
						.getTransaction().rollback();
				e.printStackTrace();
			}

			for (String id : allUserIds) {
				idSet.add(id);
			}
			break;
		case groupId:
		case friends:
			try {
				/**
				 * <p>
				 * This filter can be any field of the object being filtered or
				 * the special js filters, hasApp or topFriends. Other special
				 * Filters defined in the OpenSocial v.9 specification are
				 * </p>
				 * <dl>
				 * <dt>all</dt>
				 * <dd>Retrieves all friends</dd>
				 * <dt>hasApp</dt>
				 * <dd>Retrieves all friends with any data for this application.
				 * </dd>
				 * <dt>'topFriends</dt>
				 * <dd>Retrieves only the user's top friends.</dd>
				 * <dt>isFriendsWith</dt>
				 * <dd>Only "hasApp filter" is implemented here</dd>
				 * </dl>
				 */

				Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
				Transaction tran = hs.beginTransaction();
				
				//List<String> friendsIds = sqlMap.queryForList("getFriendsIds",user);

				List<String> friendsIds = new ArrayList<String>();
				
				User userObject = (User)hs.get(User.class, user);
				
				Set<User> friends = userObject.getFriendsByMe();
				Set<User> friendsByOthers = userObject.getFriendsByOther();
				
				friends.addAll(friendsByOthers);
				
				if (options.getFilter() != null
						&& options.getFilter().equals("hasApp")) {

					Set<User> tempFriends = new HashSet<User>();
					tempFriends.addAll(friends);
					
					for (User friend : tempFriends) {
						if (!friend.getPerson().getHasapp())
							friends.remove(friend);
					}
				}

				for(User friend: friends) {
					friendsIds.add(friend.getId());
				}
				idSet.addAll(friendsIds);


				tran.commit();
			} catch (Exception e) {
				HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
				e.printStackTrace();
			}

			break;
		case self:
			idSet.add(user);
			break;
		}
		return idSet;
	}
	
	/**
	 * Get the set of user id's for a set of users and a group
	 */
	private Set<String> getIdSet(Set<UserId> users, GroupId group, SecurityToken token)
			throws JSONException {
		Set<String> ids = new HashSet<String>();
		for (UserId user : users) {
			ids.addAll(getIdSet(user, group, token));

		}
		return ids;
	}

	/**
	 * Get the set of user id's from a user and group
	 */
	@SuppressWarnings("unchecked")
	private Set<String> getIdSet(UserId userId, GroupId groupId, SecurityToken token)
			throws JSONException {

		String user = userId.getUserId(token);

		if (groupId == null) {
			return ImmutableSortedSet.of(user);
		}

		Set<String> idSet = new HashSet<String>();

		switch (groupId.getType()) {
		case all:
			// idSet.add(user);
			List<String> allUserIds = null;
			try {
				// List<String> allUserIds = sqlMap.queryForList(
				// "getAllUserIds" );
				Session hs = HibernateUtil.getSessionFactory()
						.getCurrentSession();
				Transaction tran = hs.beginTransaction();

				// Criteria crit = hs.createCriteria(User.class);
				Query q = hs.createQuery("select id from User");
				allUserIds = (List<String>) q.list();

				tran.commit();

			} catch (Exception e) {
				HibernateUtil.getSessionFactory().getCurrentSession()
						.getTransaction().rollback();
				e.printStackTrace();
			}

			for (String id : allUserIds) {
				idSet.add(id);
			}
			break;
		case groupId:
		case friends:
			try {
				/**
				 * <p>
				 * This filter can be any field of the object being filtered or
				 * the special js filters, hasApp or topFriends. Other special
				 * Filters defined in the OpenSocial v.9 specification are
				 * </p>
				 * <dl>
				 * <dt>all</dt>
				 * <dd>Retrieves all friends</dd>
				 * <dt>hasApp</dt>
				 * <dd>Retrieves all friends with any data for this application.
				 * </dd>
				 * <dt>'topFriends</dt>
				 * <dd>Retrieves only the user's top friends.</dd>
				 * <dt>isFriendsWith</dt>
				 * <dd>Only "hasApp filter" is implemented here</dd>
				 * </dl>
				 */

				Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
				Transaction tran = hs.beginTransaction();
				
				//List<String> friendsIds = sqlMap.queryForList("getFriendsIds",user);

				List<String> friendsIds = new ArrayList<String>();
				
				User userObject = (User)hs.get(User.class, user);
				
				Set<User> friends = userObject.getFriendsByMe();
				Set<User> friendsByOthers = userObject.getFriendsByOther();
				
				friends.addAll(friendsByOthers);

				for(User friend: friends) {
					friendsIds.add(friend.getId());
				}
				idSet.addAll(friendsIds);


				tran.commit();
			} catch (Exception e) {
				HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
				e.printStackTrace();
			}

			break;
		case self:
			idSet.add(user);
			break;
		}
		return idSet;
	}
}