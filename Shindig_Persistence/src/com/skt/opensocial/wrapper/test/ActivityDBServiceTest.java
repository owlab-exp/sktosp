

package com.skt.opensocial.wrapper.test;

import static org.junit.Assert.assertEquals;

import org.apache.shindig.social.opensocial.model.Activity;
import org.apache.shindig.social.opensocial.model.EnumUtil;
import org.apache.shindig.social.opensocial.spi.GroupId;
import org.apache.shindig.social.opensocial.spi.UserId;
import org.apache.shindig.social.opensocial.spi.UserId.Type;

import com.skt.opensocial.wrapper.persistence.spi.ActivityDBService;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;

import org.junit.Test;


/**
 * 
 * Test the PersonServiceDb implementation.
 *
 */
public class ActivityDBServiceTest {

	// TODO ALL_FIELDS should be already in Activity as it is with Person
	  private final static Set<String> ACTIVITY_ALL_FIELDS = EnumUtil.getEnumStrings(Activity.Field.values());
	      
	  private final Activity testActivity = SpiTestUtil.buildTestActivity("1", "john.doe", "yellow", "what a color!");  

	  private ActivityDBService activityDBService = new ActivityDBService();
	
	 
	  
	@Test
	  public void createNewActivityForJohnDoe() throws Exception {
	    // Create new activity
	    final String title = "hi mom!";
	    final String body = "and dad.";
	    Activity activity = SpiTestUtil.buildTestActivity("2", "john.doe", title, body);    
	    this.activityDBService.createActivity(new UserId(Type.userId, "john.doe"), new GroupId(GroupId.Type.self, "@self"), "2", ACTIVITY_ALL_FIELDS, activity, SpiTestUtil.DEFAULT_TEST_SECURITY_TOKEN);
/*	    
	    // Check activity was created as expected
	    Future<RestfulCollection<Activity>> result = this.activityDBService.getActivities(SpiTestUtil.buildUserIds("john.doe"), new GroupId(GroupId.Type.self, "@self"), null, ACTIVITY_ALL_FIELDS, new CollectionOptions(), SpiTestUtil.DEFAULT_TEST_SECURITY_TOKEN);
	    RestfulCollection<Activity> activityCollection = result.get();
	    assertEquals(2, activityCollection.getTotalResults());
	    assertEquals(0, activityCollection.getStartIndex());
	    activity = activityCollection.getEntry().get(1);    
	    assertEquals(activity.getTitle(), title);
	    assertEquals(activity.getBody(), body);
*/
	  }
	
	 @Test
	  public void getJohnDoeActivityWithActivityId1() throws Exception {
	    Future<Activity> result = this.activityDBService.getActivity(new UserId(Type.userId, "john.doe"), new GroupId(GroupId.Type.self, "@self"), null, ACTIVITY_ALL_FIELDS, "2", SpiTestUtil.DEFAULT_TEST_SECURITY_TOKEN);
	    Activity activity = result.get();
	    SpiTestUtil.assertActivityEquals(activity, testActivity);    
	  }

	 @Test
	  public void deleteJohnDoeActivityWithActivityId1() throws Exception {
		 Set<String> activityIds = new HashSet<String>();
		 activityIds.add("2");
		 
	    this.activityDBService.deleteActivities(new UserId(Type.userId, "john.doe"), new GroupId(GroupId.Type.self, "@self"), null, activityIds, SpiTestUtil.DEFAULT_TEST_SECURITY_TOKEN);
	  }
}