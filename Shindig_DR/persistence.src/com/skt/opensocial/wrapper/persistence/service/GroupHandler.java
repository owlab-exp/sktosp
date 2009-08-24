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

import java.util.List;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletResponse;

import org.apache.shindig.common.util.ImmediateFuture;
import org.apache.shindig.protocol.Operation;
import org.apache.shindig.protocol.ProtocolException;
import org.apache.shindig.protocol.RequestItem;
import org.apache.shindig.protocol.Service;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;

import com.google.inject.Inject;
import com.skt.opensocial.persistence.ActivityMediaItem;
import com.skt.opensocial.persistence.GroupCategory;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.Person;

@Service(name = "group", path = "/{userId}/{groupName}")
public class GroupHandler {

  @Inject
  public GroupHandler() {

  }

  /**
   * We don't distinguish between put and post for these urls.
   */
  @Operation(httpMethods = "DELETE")
  public Future<?> delete(RequestItem request) throws ProtocolException {
	  String groupName = request.getParameter("groupName");
	  String userId = request.getParameter("userId");
	  
	  Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
	  Transaction tran = null;
	  
	  tran = hs.beginTransaction();
	  
	  Query q = hs.createQuery("delete GroupCategory gc where gc.userId = :userId and gc.groupName = :groupName");
	  q.setString("userId", userId)
	  .setString("groupName", groupName);
	  q.executeUpdate();
	  
	  tran.commit();
	  
	  
	  return ImmediateFuture.newInstance(groupName);
  }


  /**
   * Handles /group/
   */
  @Operation(httpMethods = "GET")
  public Future<?> get(RequestItem request) throws ProtocolException {
	  String userId = request.getParameter("userId");
	  String groupName = request.getParameter("groupName");
	    
	  Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
	  Transaction tran = null;

	  try {

		  tran = hs.beginTransaction();

		  // check whether the person exists or not
		  Person person = (Person) hs.get(Person.class, userId);
			
		  if (person == null)
			  throw new ProtocolException(HttpServletResponse.SC_BAD_REQUEST,
				"Person not found");
		  
		  // check if the same name of a group category for the same person already exists 
		  Criteria crit = hs.createCriteria(GroupCategory.class);
		  List<GroupCategory> gCategories = (List<GroupCategory>) crit
		  .add(Restrictions.eq("userId", userId))
		  .add(Restrictions.eq("groupName", groupName))
		  .list();

		  if (gCategories.size() == 0) {
			  
			  // create Group Categry
			  GroupCategory groupCategory = new GroupCategory();
			  groupCategory.setGroupName(groupName);
			  groupCategory.setUserId(userId);
	
			  hs.saveOrUpdate(groupCategory);
		  }

		  tran.commit();

		  return ImmediateFuture.newInstance(null);

	  } catch (Exception e) {
		  if ( tran != null )
			  tran.rollback();

		  throw new ProtocolException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage(), e);
	  }

	  
  }


}
