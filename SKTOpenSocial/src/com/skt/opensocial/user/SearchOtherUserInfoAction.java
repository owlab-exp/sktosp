/**
 * 
 */
package com.skt.opensocial.user;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.hibernate.classic.Session;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.developer.DeveloperBaseAction;
import com.skt.opensocial.developer.ManageGadgetAction;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetCategory;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**
 * @author Seong yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class SearchOtherUserInfoAction extends DeveloperBaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Map<String, Object> session;
	
	String userId;
	String name;
	Date registeredDate;
	int age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}
	
	public String execute() {
	
		//
		User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		userId = user.getUserId();
		
		user = (User)hs.load(User.class, userId);
				
		name = user.getPerson().getName();
		registeredDate = user.getRegisteredDate();
		System.out.println("--------------------------------------list count " + registeredDate);
		age = user.getPerson().getAge();
		
	

		System.out.println("--------------------------------------list count ");
		session.put(SKTOpenSocialSupportConstants.USER, user);
        //System.out.println("list count = " + categoryStringList);
		
		
		/* 
		 * 

		gadget.setName(getGadgetName());
		
		String categoryIds = getGadgetCategory();
		
		System.out.println("list count = " + gadgetId + gadget.getName() + categoryIds);
		
		categoryIds = categoryIds.replace(" ", "");
		String[] categoryIdArray = categoryIds.split(",");
		if(categoryIdArray.length > 0) {
			HashSet<GadgetCategory> categorySet = new HashSet<GadgetCategory>();
			
			for(int i = 0; i < categoryIdArray.length; i++) {
				GadgetCategory gadgetCategory = (GadgetCategory)hs.load(GadgetCategory.class, categoryIdArray[i]);
				categorySet.add(gadgetCategory);
			}
			
			gadget.setCategories(categorySet);
		}

		gadget.setIconUrl(getGadgetIconUrl());
		gadget.setIntroduction(getGadgetIntro());
		gadget.setSource(getGadgetSource());
		gadget.setRegisterDate(null);
		gadget.setStatus(GadgetStatusConstants.NOT_REGISTERED);
		gadget.setRegisterType(getRegisterType());		
		
		*/
		

		hs.getTransaction().commit();
		
		return Action.SUCCESS;
	}

}
