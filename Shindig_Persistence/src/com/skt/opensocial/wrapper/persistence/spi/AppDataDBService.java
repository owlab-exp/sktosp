
package com.skt.opensocial.wrapper.persistence.spi;

import org.apache.shindig.auth.SecurityToken;
import org.apache.shindig.common.util.ImmediateFuture;
import org.apache.shindig.protocol.DataCollection;
import org.apache.shindig.protocol.ProtocolException;
import org.apache.shindig.social.opensocial.spi.GroupId;
import org.apache.shindig.social.opensocial.spi.UserId;
import org.apache.shindig.social.opensocial.spi.AppDataService;
import org.apache.shindig.social.opensocial.spi.UserId.Type;
import org.json.JSONException;

import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Maps;
import com.google.inject.internal.Lists;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.skt.opensocial.wrapper.persistence.domain.AppDataDB;
import com.skt.opensocial.wrapper.persistence.util.IBATISSqlMapper;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletResponse;


public class AppDataDBService implements AppDataService {

	private SqlMapClient sqlMap = IBATISSqlMapper.getSqlMapInstance();

	@SuppressWarnings("unchecked")
	public Future<DataCollection> getPersonData(Set<UserId> userIds, GroupId groupId,
      String appId, Set<String> fields, SecurityToken token) throws ProtocolException {
		try {
			Map<String, Map<String, String>> idToAppDataMap = Maps.newHashMap();
			Set<String> idSet = getIdSet(userIds, groupId, token);
			
			List<AppDataDB> appDataDBList = Lists.newArrayList();
			
			for (String userId : idSet) {
				
				appDataDBList = sqlMap.queryForList("getPersonAppData", userId);
				
				for (int i = 0; i < appDataDBList.size(); i++) {
					
					// if there is a value for "appId", then get data with both userId and appId. Otherwise, just use userId.
					if (appId != null) {
						if (appDataDBList.get(i).getAppId() != appId) {
							continue;
						}
					}
					
					Map<String, String> appDataMap = Maps.newHashMap();
					appDataMap.put( appDataDBList.get(i).getField(), appDataDBList.get(i).getData() );
					idToAppDataMap.put(userId, appDataMap);
				}
			}
	      
			return ImmediateFuture.newInstance( new DataCollection(idToAppDataMap) );
			
		} catch(Exception e) {
			e.printStackTrace(); 
			throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}
		 
	@SuppressWarnings("unchecked")
	public Future<Void> deletePersonData(UserId userId, GroupId groupId,
      String appId, Set<String> fields, SecurityToken token) throws ProtocolException {
		try {
			Set<String> idSet = getIdSet(userId, groupId, token);

			for (String user : idSet) {
				
				// if there is a value for "appId", then get data with both userId and appId. Otherwise, just use userId.
				if (appId != null) {
					AppDataDB appDataDB = new AppDataDB();
					appDataDB.setUserId(user);
					appDataDB.setAppId(appId);
		
					sqlMap.delete("deletePersonAppDataWithAppId", appDataDB);
				} else {
					sqlMap.delete("deletePersonAppData", user);
				}
			}
			
			return ImmediateFuture.newInstance(null);
		} catch (Exception e) {
			throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
	}


	@SuppressWarnings("unchecked")
	public Future<Void> updatePersonData(UserId userId, GroupId groupId,
      String appId, Set<String> fields, Map<String, String> values, SecurityToken token)
      throws ProtocolException {
		try {
			Set<String> idSet = getIdSet(userId, groupId, token);
			
			List<AppDataDB> appDataDBList = Lists.newArrayList();
			
			// find Application Data of users and input the new values into the data
			for (String user : idSet) {
				
				appDataDBList = sqlMap.queryForList("getPersonAppData", user);
				
				for (int i = 0; i < appDataDBList.size(); i++) {
					
					// if there is AppData with the same appId and keys of the values, then update the data
					Set<String> keys = values.keySet();
					String currentKey = appDataDBList.get(i).getField();
					
					// if there is a value for "appId", then get data with both userId and appId. Otherwise, just use userId.
					if ( appId != null ) {
						if ( appDataDBList.get(i).getAppId() != appId ) {
							continue;
						}
					}
					
					if ( keys.contains(currentKey) ) {
						appDataDBList.get(i).setData( values.get(currentKey) );
						sqlMap.delete("updatePersonAppData", appDataDBList.get(i));
					}
				}
			}
			
			return ImmediateFuture.newInstance(null);
		} catch (Exception e) {
			throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
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
	    	idSet.add(user);
	    	try {
	    		List<String> allUserIds = sqlMap.queryForList( "getAllUserIds" );
	    		
	    		for (String id : allUserIds ) {
	        		idSet.add( id );
	        	}
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	break;
	    case groupId:
	    case friends:
	    	try {
	    		List<String> friendsIds = sqlMap.queryForList( "getFriendsIds", user );
	    		
	    		for (String id : friendsIds ) {
	        		idSet.add( id );
	        	}
	    	} catch (Exception e) {
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

}
