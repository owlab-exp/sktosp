

package com.skt.opensocial.wrapper.test;

import static org.junit.Assert.assertEquals;

import org.apache.shindig.protocol.RestfulCollection;
import org.apache.shindig.protocol.model.SortOrder;
import org.apache.shindig.social.core.model.ActivityImpl;
import org.apache.shindig.social.opensocial.model.Activity;
import org.apache.shindig.social.opensocial.model.EnumUtil;
import org.apache.shindig.social.opensocial.spi.CollectionOptions;
import org.apache.shindig.social.opensocial.spi.GroupId;
import org.apache.shindig.social.opensocial.spi.UserId;
import org.apache.shindig.social.opensocial.spi.UserId.Type;

import com.skt.opensocial.wrapper.persistence.spi.HActivityDBService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

import org.junit.Test;


/**
 * 
 * Test the PersonServiceDb implementation.
 *
 */
public class HActivityDBServiceTest {

	// TODO ALL_FIELDS should be already in Activity as it is with Person
	  private final static Set<String> ACTIVITY_ALL_FIELDS = EnumUtil.getEnumStrings(Activity.Field.values());
	      
	  private final Activity testActivity = SpiTestUtil.buildTestActivity("1", "john.doe", "yellow", "what a color!");  

	  private HActivityDBService activityDBService = new HActivityDBService();
	

	  
	 @Test
	  public void getJohnDoeActivityWithActivityId2() throws Exception {
		// Set collection options
		    CollectionOptions collectionOptions = new CollectionOptions();
		    collectionOptions.setSortBy("name");
		    collectionOptions.setSortOrder(SortOrder.ascending);
		    collectionOptions.setMax(20);
		    
		    Set<String> activityIds = new HashSet<String>();
		    activityIds.add("1");
		    
	    Future<RestfulCollection<Activity>> result = this.activityDBService.getActivities(new UserId(UserId.Type.userId, "john.doe"), new GroupId(GroupId.Type.friends, "@friends"), null, null, collectionOptions, null, SpiTestUtil.DEFAULT_TEST_SECURITY_TOKEN);
//		    Activity activity = result.get();
//		    SpiTestUtil.assertActivityEquals(activity, testActivity);    
	  }
	
	  @Test
	  public void getJohnDoeActivityWithActivityId1() throws Exception {
		// Set collection options
		    CollectionOptions collectionOptions = new CollectionOptions();
		    collectionOptions.setSortBy("name");
		    collectionOptions.setSortOrder(SortOrder.ascending);
		    collectionOptions.setMax(20);
		    
	    Future<RestfulCollection<Activity>> result = this.activityDBService.getActivities(SpiTestUtil.buildUserIds("john.doe"), new GroupId(GroupId.Type.self, "@self"), null, ACTIVITY_ALL_FIELDS, collectionOptions, SpiTestUtil.DEFAULT_TEST_SECURITY_TOKEN);
//	    Activity activity = result.get();
//	    SpiTestUtil.assertActivityEquals(activity, testActivity);    
	  }
	 



	 @Test
	  public void deleteJohnDoeActivityWithActivityId1() throws Exception {
		 Set<String> activityIds = new HashSet<String>();
		 activityIds.add("2");
		 
	    this.activityDBService.deleteActivities(new UserId(Type.userId, "john.doe"), new GroupId(GroupId.Type.self, "@self"), null, activityIds, SpiTestUtil.DEFAULT_TEST_SECURITY_TOKEN);
	  }
	 
	 
	 @Test
	  public void createJohnDoeActivity() throws Exception {
		// create TemplateParams of the activity
		Map<String, String> templateParams = new HashMap<String, String>();
		templateParams.put("key", "value");
		
		Activity activity = new ActivityImpl();
		activity.setUserId("aaa");
		 
	    this.activityDBService.createActivity(new UserId(Type.userId, "john.doe"), new GroupId(GroupId.Type.self, "@self"), null, null, activity, SpiTestUtil.DEFAULT_TEST_SECURITY_TOKEN);
	  }
}