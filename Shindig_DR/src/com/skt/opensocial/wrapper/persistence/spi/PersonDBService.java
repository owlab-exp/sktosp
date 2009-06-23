
package com.skt.opensocial.wrapper.persistence.spi;

import org.apache.shindig.auth.SecurityToken;
import org.apache.shindig.common.util.ImmediateFuture;
import org.apache.shindig.protocol.ProtocolException;
import org.apache.shindig.protocol.RestfulCollection;
import org.apache.shindig.protocol.model.SortOrder;
import org.apache.shindig.social.core.model.PersonImpl;
import org.apache.shindig.social.opensocial.model.Person;
import org.apache.shindig.social.opensocial.model.ListField;
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
import com.skt.opensocial.wrapper.persistence.domain.PersonListStringDB;
import com.skt.opensocial.wrapper.persistence.domain.PersonListFieldDB;
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
	      Set<UserId> idSet = getIdSet(userIds, groupId, token);
	
	      for (UserId id : idSet) {
	    	  Person person = this.getPersonFromDB(id, fields, token);
	    	  
	    	  result.add(person);
	      }
	      
	      if (result != null) {
	
		      if (GroupId.Type.self == groupId.getType() && result.isEmpty()) {
		        throw new ProtocolException(HttpServletResponse.SC_BAD_REQUEST, "Person not found");
		      }
		
		      // We can pretend that by default the people are in top friends order
	//	      if (options.getSortBy().equals(Person.Field.NAME.toString())) {
	//	        Collections.sort(result, NAME_COMPARATOR);
	//	      }
		
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
		 Person person = this.getPersonFromDB(id, fields, token);
		  
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
private Person getPersonFromDB (UserId id, Set<String> fields, SecurityToken token) {
	  PersonImpl person = new PersonImpl();
	  PersonDB personDB = new PersonDB();
	  
	  try {
		  //*** get the default information of the person ***//
		  personDB = (PersonDB) sqlMap.queryForObject("getPersonDefaultInfo", id.getUserId(token));
		  
		  if (personDB != null) {
		  
			  //*** get the additional information of the person in forms of List<String> ***//
			  personDB.setBooks( sqlMap.queryForList("getListStringOneByOne", (new PersonListStringDB(id.getUserId(token), PersonListStringDB.Attribute.books))) );
			  personDB.setCars( sqlMap.queryForList("getListStringOneByOne", (new PersonListStringDB(id.getUserId(token), PersonListStringDB.Attribute.cars))) );
			  personDB.setFood( sqlMap.queryForList("getListStringOneByOne", (new PersonListStringDB(id.getUserId(token), PersonListStringDB.Attribute.food))) );
			  personDB.setHeroes( sqlMap.queryForList("getListStringOneByOne", (new PersonListStringDB(id.getUserId(token), PersonListStringDB.Attribute.heroes))) );
			  personDB.setInterests( sqlMap.queryForList("getListStringOneByOne", (new PersonListStringDB(id.getUserId(token), PersonListStringDB.Attribute.interests))) );
			  personDB.setLanguagesSpoken( sqlMap.queryForList("getListStringOneByOne", (new PersonListStringDB(id.getUserId(token), PersonListStringDB.Attribute.languagesSpoken))) );
			 
			  List<String> lookingForList = sqlMap.queryForList("getListStringOneByOne", (new PersonListStringDB(id.getUserId(token), PersonListStringDB.Attribute.lookingFor)));
			  //PersonDB.setLookingFor( DBTableMapper.getLookingForFrom(lookingForList) );
			
			  personDB.setMovies( sqlMap.queryForList("getListStringOneByOne", (new PersonListStringDB(id.getUserId(token), PersonListStringDB.Attribute.movies))) );
			  personDB.setMusic( sqlMap.queryForList("getListStringOneByOne", (new PersonListStringDB(id.getUserId(token), PersonListStringDB.Attribute.music))) );
			  personDB.setQuotes( sqlMap.queryForList("getListStringOneByOne", (new PersonListStringDB(id.getUserId(token), PersonListStringDB.Attribute.quotes))) );
			  personDB.setMusic( sqlMap.queryForList("getListStringOneByOne", (new PersonListStringDB(id.getUserId(token), PersonListStringDB.Attribute.music))) );
			  personDB.setSports( sqlMap.queryForList("getListStringOneByOne", (new PersonListStringDB(id.getUserId(token), PersonListStringDB.Attribute.sports))) );
			  personDB.setTags( sqlMap.queryForList("getListStringOneByOne", (new PersonListStringDB(id.getUserId(token), PersonListStringDB.Attribute.tags))) );
			  personDB.setTurnOffs( sqlMap.queryForList("getListStringOneByOne", (new PersonListStringDB(id.getUserId(token), PersonListStringDB.Attribute.turnOffs))) );
			  personDB.setTurnOns( sqlMap.queryForList("getListStringOneByOne", (new PersonListStringDB(id.getUserId(token), PersonListStringDB.Attribute.turnOns))) );
			  personDB.setTvShows( sqlMap.queryForList("getListStringOneByOne", (new PersonListStringDB(id.getUserId(token), PersonListStringDB.Attribute.tvShows))) );
			  
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
  *  test for inserting Person data
  */
  public void insertPerson(Person person) {

	  try {
		  
		  //****insert Default Information ****//
		  PersonDB personDB = DBTableMapper.getPersonDBFromPerson(person);
		  sqlMap.insert("insertPersonDefaultInfo", personDB);

		  //**** insert additional information in forms of List<String> ****//
		  // insert books
		  List<String> books = personDB.getBooks();
		  this.insertListString(personDB.getId(), books, PersonListStringDB.Attribute.books);
		  
		  // insert cars
		  List<String> cars = personDB.getCars();
		  this.insertListString(personDB.getId(), cars, PersonListStringDB.Attribute.cars);
		  
		  // insert food
		  List<String> food = personDB.getFood();
		  this.insertListString(personDB.getId(), food, PersonListStringDB.Attribute.food);
		  
		  // insert heroes
		  List<String> heroes = personDB.getHeroes();
		  this.insertListString(personDB.getId(), heroes, PersonListStringDB.Attribute.heroes);
		  
		  // insert interests
		  List<String> interests = personDB.getInterests();
		  this.insertListString(personDB.getId(), interests, PersonListStringDB.Attribute.interests);
		  
		  // insert languagesSpoken
		  List<String> languagesSpoken = personDB.getLanguagesSpoken();
		  this.insertListString(personDB.getId(), languagesSpoken, PersonListStringDB.Attribute.languagesSpoken);
		  
		  // insert lookingFor
		  //List<String> lookingFor = personDB.getLookingFor();
		  //this.insertListString(personDB.getId(), lookingFor, PersonListStringDB.Attribute.lookingFor);
		  
		  // insert movies
		  List<String> movies = personDB.getMovies();
		  this.insertListString(personDB.getId(), movies, PersonListStringDB.Attribute.movies);
		  
		  // insert music
		  List<String> music = personDB.getMusic();
		  this.insertListString(personDB.getId(), music, PersonListStringDB.Attribute.music);
		  
		  // insert quotes
		  List<String> quotes = personDB.getQuotes();
		  this.insertListString(personDB.getId(), quotes, PersonListStringDB.Attribute.quotes);
		  
		  // insert sports
		  List<String> sports = personDB.getSports();
		  this.insertListString(personDB.getId(), sports, PersonListStringDB.Attribute.sports);
		  
		  // insert tags
		  List<String> tags = personDB.getTags();
		  this.insertListString(personDB.getId(), tags, PersonListStringDB.Attribute.tags);
		  
		  // insert turnOffs
		  List<String> turnOffs = personDB.getTurnOffs();
		  this.insertListString(personDB.getId(), turnOffs, PersonListStringDB.Attribute.turnOffs);
		  
		  // insert turnOns
		  List<String> turnOns = personDB.getTurnOns();
		  this.insertListString(personDB.getId(), turnOns, PersonListStringDB.Attribute.turnOns);
			
		  // insert tvShows
		  List<String> tvShows = personDB.getTvShows();
		  this.insertListString(personDB.getId(), tvShows, PersonListStringDB.Attribute.tvShows);
		  
		  
		  //**** insert additional information in forms of List<String> ****/
		  //insert emails
		  List<ListField> emails = personDB.getEmails();
		  this.insertListField(personDB.getId(), emails, PersonListFieldDB.Attribute.emails);
		  
		  //insert ims
		  List<ListField> ims = personDB.getIms();
		  this.insertListField(personDB.getId(), ims, PersonListFieldDB.Attribute.ims);
		  
		  //insert phoneNumbers
		  List<ListField> phoneNumbers = personDB.getPhoneNumbers();
		  this.insertListField(personDB.getId(), phoneNumbers, PersonListFieldDB.Attribute.phoneNumbers);
		  
		  //insert photos
		  List<ListField> photos = personDB.getPhotos();
		  this.insertListField(personDB.getId(), photos, PersonListFieldDB.Attribute.photos);
	  } 
	  catch(Exception e) {
		  e.printStackTrace();
	  }
  }
  
  private void insertListString(String personId, List<String> list, PersonListStringDB.Attribute attributeType) {
	  try {
		  if (list != null) {
			  for ( String element : list ) {
				  PersonListStringDB personListStringDB = new PersonListStringDB(personId, attributeType, element);
				  sqlMap.insert("insertListStringOneByOne", personListStringDB);
			  }
		  }  
	  } catch(Exception e) {
		  e.printStackTrace();
	  }
	
  }
  
  private void insertListField(String personId, List<ListField> list, PersonListFieldDB.Attribute attributeType) {
	  try {
		  if (list != null) {
			  for ( ListField element : list ) {
				  PersonListFieldDB personListFieldDB = new PersonListFieldDB(personId, attributeType, element);
				  sqlMap.insert("insertListFieldOneByOne", personListFieldDB);
			  }
		  }
	  } catch(Exception e) {
		  e.printStackTrace();
	  }
  }
  
  /**
   * Get the set of user id's from a user and group
   */
  @SuppressWarnings("unchecked")
private Set<UserId> getIdSet(UserId user, GroupId group, SecurityToken token)
      throws JSONException {

    if (group == null) {
      return ImmutableSortedSet.of(user);
    }

    Set<UserId> returnVal = new HashSet<UserId>();
    
    switch (group.getType()) {
    case all:
    	returnVal.add(user);
    	try {
    		List<String> allUserIds = sqlMap.queryForList("getAllUserIds");
    		
    		for (String id : allUserIds ) {
        		this.buildUserIds(id);
        		returnVal.add( new UserId(Type.userId, id) );
        	}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	break;
    case friends:
/*
    case groupId:
      if (db.getJSONObject(FRIEND_LINK_TABLE).has(userId)) {
        JSONArray friends = db.getJSONObject(FRIEND_LINK_TABLE).getJSONArray(userId);
        for (int i = 0; i < friends.length(); i++) {
          returnVal.add(friends.getString(i));
        }
      }
*/
      break;
    case self:
      returnVal.add(user);
      break;
    }
    return returnVal;
  }

  /**
   * Get the set of user id's for a set of users and a group
   */
  private Set<UserId> getIdSet(Set<UserId> users, GroupId group, SecurityToken token)
      throws JSONException {
    Set<UserId> ids = new HashSet<UserId>();
    for (UserId user : users) {
      ids.addAll(getIdSet(user, group, token));
    }
    return ids;
  }

  private Set<UserId> buildUserIds(String... userIds) {
	    // Set user id list
	    Set<UserId> userIdSet = new HashSet<UserId>();
	    for (String userId: userIds) {
	      userIdSet.add(new UserId(Type.userId, userId));
	    }
	    return userIdSet;
	  }

}


