/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.skt.opensocial.wrapper.persistence.service;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.shindig.common.util.ImmediateFuture;
import org.apache.shindig.protocol.Operation;
import org.apache.shindig.protocol.ProtocolException;
import org.apache.shindig.protocol.RequestItem;
import org.apache.shindig.protocol.Service;
import org.apache.shindig.social.opensocial.model.MediaItem;
import org.apache.shindig.social.sample.spi.JsonDbOpensocialService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.skt.opensocial.persistence.GroupCategory;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.Person;

@Service(name = "group", path = "/{GroupName}")
public class GroupHandler {

  @Inject
  public GroupHandler() {

  }

  /**
   * We don't distinguish between put and post for these urls.
   */
  @Operation(httpMethods = "PUT")
  public Future<?> update(RequestItem request) throws ProtocolException {
	  String field = request.getParameter("field");
	  
	  if (field.equals("groupname")) {
		  return ImmediateFuture.newInstance("GroupName");
	  }
	  
	  return null;
  }

  /**
   * Handles /group/..... TODO(doll): 
   */
  @Operation(httpMethods = "POST")
  public Future<?> create(RequestItem request) throws ProtocolException {
	  
	  String field = request.getParameter("field");
	  
	  if (field.equals("groupname")) {
		  return ImmediateFuture.newInstance("GroupName");
	  }
	  
	  return null;
	  
//    String groupName = request.getParameter("GroupName");
//    
//    Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
//	Transaction tran = null;
//	
//	System.out.println(
//    "-------------------------------------------- Test Succeed : /group/groupName --------------------------------------");
//	
//	try {
//		Long startTime = new Date().getTime();
//		
//		tran = hs.beginTransaction();
//		
//		
//		// create Group Categry
//		GroupCategory groupCategory = new GroupCategory(groupName);
//
//		hs.saveOrUpdate(groupCategory);
//		
//		
//		tran.commit();
//		
//		throw new ProtocolException(HttpServletResponse.SC_NOT_IMPLEMENTED,
//        "-------------------------------------------- Test Succeed : /group/groupName --------------------------------------");
////		return ImmediateFuture.newInstance(null);
//	
//	} catch (Exception e) {
//		if ( tran != null )
//			tran.rollback();
//		
//		throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
//	}
  }

  /**
   * Handles /group/
   */
  @Operation(httpMethods = "GET")
  public Future<?> get(RequestItem request) {
	  String field = request.getParameter("field");
	  
	  if (field.equals("groupname")) {
		  return ImmediateFuture.newInstance("GroupName");
	  }
	  
	  return null;
  }


}
