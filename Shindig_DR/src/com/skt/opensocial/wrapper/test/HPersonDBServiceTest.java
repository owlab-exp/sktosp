

package com.skt.opensocial.wrapper.test;

import static org.junit.Assert.assertEquals;

import org.apache.shindig.protocol.RestfulCollection;
import org.apache.shindig.protocol.model.SortOrder;
import org.apache.shindig.social.opensocial.model.Person;
import org.apache.shindig.social.opensocial.spi.CollectionOptions;
import org.apache.shindig.social.opensocial.spi.GroupId;
import org.apache.shindig.social.opensocial.spi.UserId;
import org.apache.shindig.social.opensocial.spi.UserId.Type;

import com.skt.opensocial.wrapper.persistence.spi.HPersonDBService;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;

import org.junit.Test;

import org.apache.shindig.auth.SecurityToken;
import org.apache.shindig.common.testing.FakeGadgetToken;

/**
 * 
 * Test the PersonServiceDb implementation.
 *
 */
public class HPersonDBServiceTest {
 

	private final Person canonical = SpiTestUtil.buildCanonicalPerson();
  
	private HPersonDBService personServiceDb = new HPersonDBService();

  private SecurityToken token = new FakeGadgetToken();

  @Test
  public void getCanonicalPerson() throws Exception {
	  Set<String> fields = new HashSet<String>();
	  fields.add("id");
	  
     Future<Person> person = this.personServiceDb.getPerson(new UserId(Type.userId, "john.doe"), fields, SpiTestUtil.DEFAULT_TEST_SECURITY_TOKEN);
     SpiTestUtil.assertPersonEquals(person.get(), canonical.getId());
     System.out.println(canonical.getId());
  }

  
  @Test
  public void getCanonicalPeople() throws Exception {
	// Set collection options
	    CollectionOptions collectionOptions = new CollectionOptions();
	    collectionOptions.setSortBy("name");
	    collectionOptions.setSortOrder(SortOrder.ascending);
	    collectionOptions.setMax(20);
	    
	//Get first friend of john.doe
	  Future<RestfulCollection<Person>> result = this.personServiceDb.getPeople(SpiTestUtil.buildUserIds("john.doe"), new GroupId(GroupId.Type.friends, "@friends"), collectionOptions, Person.Field.ALL_FIELDS, SpiTestUtil.DEFAULT_TEST_SECURITY_TOKEN);
  }

  /* 
  @Test
  public void getJohnDoeFriendsOrderedByName() throws Exception {
    // Set collection options
    CollectionOptions collectionOptions = new CollectionOptions();
    collectionOptions.setSortBy("name");
    collectionOptions.setSortOrder(SortOrder.ascending);
    collectionOptions.setMax(20);
    
    // Get all friends of john.doe
    Future<RestfulCollection<Person>> result = this.personServiceDb.getPeople(SpiTestUtil.buildUserIds("john.doe"), new GroupId(GroupId.Type.friends, "@friends"), collectionOptions, Person.Field.ALL_FIELDS, SpiTestUtil.DEFAULT_TEST_SECURITY_TOKEN);
    
    RestfulCollection<Person> peopleCollection = result.get();
    assertEquals(3, peopleCollection.getTotalResults());
    assertEquals(0, peopleCollection.getStartIndex());    
    List<Person> people = peopleCollection.getEntry();    
    // The users should be in alphabetical order
    SpiTestUtil.assertPersonEquals(people.get(0), "george.doe", "George Doe");
    SpiTestUtil.assertPersonEquals(people.get(1), "jane.doe", "Jane Doe");     
  }

  
  @Test
  public void getJohnDoeFriendsOrderedByNameWithPagination() throws Exception {    
    // Set collection options
    CollectionOptions collectionOptions = new CollectionOptions();
    collectionOptions.setSortBy("name");
    collectionOptions.setSortOrder(SortOrder.ascending);
    collectionOptions.setFirst(0);
    collectionOptions.setMax(1);
    
    // Get first friend of john.doe
    Future<RestfulCollection<Person>> result = this.personServiceDb.getPeople(SpiTestUtil.buildUserIds("john.doe"), new GroupId(GroupId.Type.friends, "@friends"), collectionOptions, Person.Field.ALL_FIELDS, SpiTestUtil.DEFAULT_TEST_SECURITY_TOKEN);    
    RestfulCollection<Person> peopleCollection = result.get();
    assertEquals(3, peopleCollection.getTotalResults());
    assertEquals(0, peopleCollection.getStartIndex());    
    List<Person> people = peopleCollection.getEntry();    
    SpiTestUtil.assertPersonEquals(people.get(0), "george.doe", "George Doe");
    
    // Get second friend of john.doe
    collectionOptions.setFirst(1);
    result = this.personServiceDb.getPeople(SpiTestUtil.buildUserIds("john.doe"), new GroupId(GroupId.Type.friends, "@friends"), collectionOptions, Person.Field.ALL_FIELDS, SpiTestUtil.DEFAULT_TEST_SECURITY_TOKEN);
    peopleCollection = result.get();
    assertEquals(3, peopleCollection.getTotalResults());
    assertEquals(1, peopleCollection.getStartIndex());    
    people = peopleCollection.getEntry();    
    SpiTestUtil.assertPersonEquals(people.get(0), "jane.doe", "Jane Doe");    
  }
  
  */
  
}
