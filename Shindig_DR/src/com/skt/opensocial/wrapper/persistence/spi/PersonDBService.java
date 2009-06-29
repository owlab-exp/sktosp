
package com.skt.opensocial.wrapper.persistence.spi;

import org.apache.shindig.auth.SecurityToken;
import org.apache.shindig.common.util.ImmediateFuture;
import org.apache.shindig.protocol.ProtocolException;
import org.apache.shindig.protocol.RestfulCollection;
import org.apache.shindig.protocol.model.SortOrder;
import org.apache.shindig.social.core.model.PersonImpl;
import org.apache.shindig.social.opensocial.model.Person;
import org.apache.shindig.social.opensocial.spi.CollectionOptions;
import org.apache.shindig.social.opensocial.spi.GroupId;
import org.apache.shindig.social.opensocial.spi.PersonService;
import org.apache.shindig.social.opensocial.spi.UserId;
import org.apache.shindig.social.opensocial.spi.UserId.Type;
import org.json.JSONException;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;
 	
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.skt.opensocial.wrapper.persistence.util.IBATISSqlMapper;
import com.skt.opensocial.wrapper.persistence.domain.PersonDB;
import com.skt.opensocial.wrapper.persistence.domain.OrganizationDB;
import com.skt.opensocial.wrapper.persistence.domain.PersonAddInfoQueryParam;
import com.skt.opensocial.wrapper.persistence.util.DBTableMapper;


/**
 * Implementation of supported services backed by a JSON DB.
 */
@Singleton
public class PersonDBService implements PersonService {

	private SqlMapClient sqlMap = IBATISSqlMapper.getSqlMapInstance();
	
  private static final Comparator<Person> NAME_COMPARATOR = new Comparator<Person>() {
    public int compare(Person person, Person person1) {
      String name = person.getName().getFormatted();
      String name1 = person1.getName().getFormatted();
      return name.compareTo(name1);
    }
  };


  @Inject
  public PersonDBService() {
	  
  }
  
	  
  public Future<RestfulCollection<Person>> getPeople(Set<UserId> userIds, GroupId groupId,
      CollectionOptions options, Set<String> fields, SecurityToken token) throws ProtocolException {
	  
	  List<Person> result = Lists.newArrayList();
	  
	  try {
	      Set<String> idSet = getIdSet(userIds, groupId, token);
	
	      for (String id : idSet) {
	    	  Person person = this.getPersonFromDB(id, fields, token);
	    	  
	    	  result.add(person);
	      }
	      
	      if (result.size() > 0) {
	
		      if (GroupId.Type.self == groupId.getType() && result.isEmpty()) {
		        throw new ProtocolException(HttpServletResponse.SC_BAD_REQUEST, "Person not found");
		      }
		
		      // We can pretend that by default the people are in top friends order
		      if (options.getSortBy().equals(Person.Field.NAME.toString())) {
		        Collections.sort(result, NAME_COMPARATOR);
		      }
		
		      if (options.getSortOrder() == SortOrder.descending) {
		        Collections.reverse(result);
		      }
		
		      // TODO: The samplecontainer doesn't really have the concept of HAS_APP so
		      // we can't support any filters yet. We should fix this.
		
		      int totalSize = result.size();
		      int last = options.getFirst() + options.getMax();
		      result = result.subList(options.getFirst(), Math.min(last, totalSize));
		
		      return ImmediateFuture.newInstance(new RestfulCollection<Person>(result, options.getFirst(), totalSize));
	      } else {
	    	  throw new ProtocolException(HttpServletResponse.SC_BAD_REQUEST, "Person not found");
	      }	      
	      
	  } catch(Exception e) {
		  e.printStackTrace();
		  throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
	  }
  }
  

  public Future<Person> getPerson(UserId id, Set<String> fields, SecurityToken token)
      throws ProtocolException { 
	  
	  
	  try {
		  String userId = id.getUserId(token);
		  
		 Person person = this.getPersonFromDB(userId, fields, token);
		  
		  if (person != null) {
			  return ImmediateFuture.newInstance(person);
		  } else {
			  throw new ProtocolException(HttpServletResponse.SC_BAD_REQUEST, "Person not found");
		  }
	  } 
	  catch(Exception e) {
		  e.printStackTrace();
		  throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
	  }
  }
  
  @SuppressWarnings("unchecked")
  private Person getPersonFromDB (String userId, Set<String> fields, SecurityToken token) {
	  PersonImpl person = new PersonImpl();
	  PersonDB personDB = new PersonDB();
	  
	  try {
		  //*** get the default information of the person ***//
		  personDB = (PersonDB) sqlMap.queryForObject("getPersonDefaultInfo", userId);
		  
		  if (personDB != null) {
			  
			  //*** get the additional information of the person in forms of List<String> ***//
			  personDB.setActivities( sqlMap.queryForList("getPersonListStringOneByOne", new PersonAddInfoQueryParam(userId, "activities")) );
			  personDB.setBooks( sqlMap.queryForList("getPersonListStringOneByOne", new PersonAddInfoQueryParam(userId, "books")) );
			  personDB.setCars( sqlMap.queryForList("getPersonListStringOneByOne", new PersonAddInfoQueryParam(userId, "cars")) );
			  personDB.setFood( sqlMap.queryForList("getPersonListStringOneByOne", new PersonAddInfoQueryParam(userId, "food")) );
			  personDB.setHeroes( sqlMap.queryForList("getPersonListStringOneByOne", new PersonAddInfoQueryParam(userId, "heroes")) );
			  personDB.setInterests( sqlMap.queryForList("getPersonListStringOneByOne", new PersonAddInfoQueryParam(userId, "interests")) );
			  personDB.setLanguagesSpoken( sqlMap.queryForList("getPersonListStringOneByOne", new PersonAddInfoQueryParam(userId, "languageSpoken")) );
			  personDB.setLookingFor( sqlMap.queryForList("getPersonListStringOneByOne", new PersonAddInfoQueryParam(userId, "lookingFor")) );
			  personDB.setMovies( sqlMap.queryForList("getPersonListStringOneByOne", new PersonAddInfoQueryParam(userId, "Movies")) );
			  personDB.setMusic( sqlMap.queryForList("getPersonListStringOneByOne", new PersonAddInfoQueryParam(userId, "Music")) );
			  personDB.setQuotes( sqlMap.queryForList("getPersonListStringOneByOne", new PersonAddInfoQueryParam(userId, "Quotes")) );
			  personDB.setSports( sqlMap.queryForList("getPersonListStringOneByOne", new PersonAddInfoQueryParam(userId, "Sports")) );
			  personDB.setTags( sqlMap.queryForList("getPersonListStringOneByOne", new PersonAddInfoQueryParam(userId, "Tags")) );
			  personDB.setTurnOffs( sqlMap.queryForList("getPersonListStringOneByOne", new PersonAddInfoQueryParam(userId, "TurnOffs")) );
			  personDB.setTurnOns( sqlMap.queryForList("getPersonListStringOneByOne", new PersonAddInfoQueryParam(userId, "TurnOns")) );
			  personDB.setTvShows( sqlMap.queryForList("getPersonListStringOneByOne", new PersonAddInfoQueryParam(userId, "TvShows")) );
			  
			  //*** get the additional information of the person in forms of List<ListField> ***//
			  personDB.setEmails( sqlMap.queryForList("getPersonListFieldOneByOne", new PersonAddInfoQueryParam(userId, "emails")) );
			  personDB.setIms( sqlMap.queryForList("getPersonListFieldOneByOne", new PersonAddInfoQueryParam(userId, "ims")) );
			  personDB.setPhoneNumbers( sqlMap.queryForList("getPersonListFieldOneByOne", new PersonAddInfoQueryParam(userId, "phoneNumbers")) );
			  personDB.setPhotos( sqlMap.queryForList("getPersonListFieldOneByOne", new PersonAddInfoQueryParam(userId, "photos")) );
		  
			  //*** get the Accounts of the person ***//
			  personDB.setAccounts( sqlMap.queryForList("getPersonAccounts", userId) );
			  
			  //*** get the Addresses of the person ***//
			  personDB.setAddresses( sqlMap.queryForList("getPersonAddresses", userId) );
			  
			  //*** get the Urls of the person ***//
			  personDB.setUrls( sqlMap.queryForList("getPersonUrls", userId) );
			  
			  //*** get the Organizations of the person ***//
			  List<OrganizationDB> organizationDBList= sqlMap.queryForList("getPersonOrganizations", userId);
			  personDB.setOrganizations( DBTableMapper.getOrganizationsFromOrganizationDBList(organizationDBList) );
			  
			  //*** get the AppData of the person ***//
			  personDB.setAppData( sqlMap.queryForMap("getPersonAppData", userId, "field", "data") );
			  
			  person = (PersonImpl) DBTableMapper.getPersonFromPersonDB(personDB);
		  }
	  } 
	  catch(Exception e) {
		  e.printStackTrace();
		  throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
	  }
	  
	  return person;
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


