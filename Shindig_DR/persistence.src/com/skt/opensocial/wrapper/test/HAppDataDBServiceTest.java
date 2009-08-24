

package com.skt.opensocial.wrapper.test;

import static org.junit.Assert.assertEquals;

import org.apache.shindig.auth.SecurityToken;
import org.apache.shindig.protocol.DataCollection;
import org.apache.shindig.protocol.RestfulCollection;
import org.apache.shindig.protocol.model.SortOrder;
import org.apache.shindig.social.opensocial.model.Activity;
import org.apache.shindig.social.opensocial.model.EnumUtil;
import org.apache.shindig.social.opensocial.spi.CollectionOptions;
import org.apache.shindig.social.opensocial.spi.GroupId;
import org.apache.shindig.social.opensocial.spi.UserId;
import org.apache.shindig.social.opensocial.spi.UserId.Type;

import com.google.inject.internal.Maps;
import com.google.inject.internal.Sets;
import com.skt.opensocial.wrapper.persistence.spi.HAppDataDBService;

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
public class HAppDataDBServiceTest {

	// TODO ALL_FIELDS should be already in Activity as it is with Person
	  private final static Set<String> ACTIVITY_ALL_FIELDS = EnumUtil.getEnumStrings(Activity.Field.values());
	      
	  private HAppDataDBService appDataDBService = new HAppDataDBService();
	  
	  @Test
	  public void getAppDAta() throws Exception {
		 Set<String> fields = Sets.newHashSet();
		 fields.add("viewerKey_app800");
		 
		 appDataDBService.getPersonData(SpiTestUtil.buildUserIds("nash2"), null, null, 
				 fields, SpiTestUtil.DEFAULT_TEST_SECURITY_TOKEN);
	
	  }
	  
	  @Test
	  public void updataAppData() throws Exception {
		 Map<String, String> values = Maps.newHashMap();
		 values.put("count", "aaa");
		 values.put("tests", "haha");
		 
		 appDataDBService.updatePersonData(new UserId(UserId.Type.userId, "john.doe"), new GroupId(GroupId.Type.friends, "@friends"), null, 
				 null, values, SpiTestUtil.DEFAULT_TEST_SECURITY_TOKEN);
	
	  }
		
}