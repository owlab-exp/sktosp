
package com.skt.opensocial.wrapper.persistence.spi;

import org.apache.shindig.auth.SecurityToken;
import org.apache.shindig.common.util.ImmediateFuture;
import org.apache.shindig.protocol.DataCollection;
import org.apache.shindig.protocol.ProtocolException;
import org.apache.shindig.social.opensocial.spi.GroupId;
import org.apache.shindig.social.opensocial.spi.UserId;
import org.apache.shindig.social.opensocial.spi.AppDataService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONException;

import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Maps;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.Person;
import com.skt.opensocial.persistence.PersonAppData;
import com.skt.opensocial.persistence.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletResponse;


public class HAppDataDBService implements AppDataService {

	public Future<DataCollection> getPersonData(Set<UserId> userIds, GroupId groupId,
      String appId, Set<String> fields, SecurityToken token) throws ProtocolException {
		try {
			Map<String, Map<String, String>> idToAppDataMap = Maps.newHashMap();
			Set<String> idSet = getIdSet(userIds, groupId, token);
			
			Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tran = hs.beginTransaction();
			
			for (String userId : idSet) {			
				
				Person person = (Person) hs.get(Person.class, userId);
								
				Set<PersonAppData> appDataDBSet = person.getAppData();
//				appDataDBList = sqlMap.queryForList("getPersonAppData", userId);
				
				for (PersonAppData appDataDB : appDataDBSet) {
					
					// if there is a value for "appId", then get data with both userId and appId. Otherwise, just use userId.
					if (appId != null) {
						if ( appDataDB.getAppId().equals(appId) ) {
							continue;
						}
					}
					
					Map<String, String> appDataMap = Maps.newHashMap();
					appDataMap.put( appDataDB.getField(), appDataDB.getData() );
					idToAppDataMap.put(userId, appDataMap);
				}
			}
	      
			tran.commit();
			
			return ImmediateFuture.newInstance( new DataCollection(idToAppDataMap) );
			
		} catch(Exception e) {
			e.printStackTrace(); 
			throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}
		 
	public Future<Void> deletePersonData(UserId userId, GroupId groupId,
      String appId, Set<String> fields, SecurityToken token) throws ProtocolException {
		try {
			Set<String> idSet = getIdSet(userId, groupId, token);

			Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tran = hs.beginTransaction();
			
			for (String user : idSet) {
				
				Person person = (Person) hs.load(Person.class, user);
				Set<PersonAppData> appDataDBSet = person.getAppData();
				
				for(PersonAppData appDataDB: appDataDBSet) {
					// if there is a value for "appId", then delete data with both userId and appId. Otherwise, just use userId.
					if (appId != null) {
						if ( appDataDB.getAppId().equals(appId) ) {
							continue;
						}
					}
					
					hs.delete(appDataDB);
				}
					
			}
			
			tran.commit();
			
			return ImmediateFuture.newInstance(null);
		} catch (Exception e) {
			throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}


	public Future<Void> updatePersonData(UserId userId, GroupId groupId,
      String appId, Set<String> fields, Map<String, String> values, SecurityToken token)
      throws ProtocolException {
		try {
			Set<String> idSet = getIdSet(userId, groupId, token);
			
			Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tran = hs.beginTransaction();
			
//			List<AppDataDB> appDataDBList = Lists.newArrayList();
			
			// find Application Data of users and input the new values into the data
			for (String user : idSet) {
				
//				appDataDBList = sqlMap.queryForList("getPersonAppData", user);
				Person person = (Person) hs.load(Person.class, user);
				Set<PersonAppData> appDataDBSet = person.getAppData();
				
				for (PersonAppData appDataDB : appDataDBSet ) {
					
					// if there is AppData with the same appId and keys of the values, then update the data
					Set<String> keys = values.keySet();
					String currentKey = appDataDB.getField();
					
					// if there is a value for "appId", then get data with both userId and appId. Otherwise, just use userId.
					if ( appId != null ) {
						if ( appDataDB.getAppId().equals(appId) ) {
							continue;
						}
					}
					
					if ( keys.contains(currentKey) ) {
						appDataDB.setData( values.get(currentKey) );
//						sqlMap.delete("updatePersonAppData", appDataDBList.get(i));
						hs.update(appDataDB);
					}
				}
				
				tran.commit();
			}
			
			return ImmediateFuture.newInstance(null);
		} catch (Exception e) {
			throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
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
