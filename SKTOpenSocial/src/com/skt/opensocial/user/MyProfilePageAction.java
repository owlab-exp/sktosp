/**
 * 
 */
package com.skt.opensocial.user;

import java.util.Date;

import java.util.Map;
import java.util.Set;


import org.hibernate.Session;

import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.developer.DeveloperBaseAction;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.Info2AttributeEnum;
import com.skt.opensocial.persistence.PersonAdditionalInfo2;
import com.skt.opensocial.persistence.User;

/**
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class MyProfilePageAction extends DeveloperBaseAction {
	//private static Logger logger = Logger.getLogger(MyProfilePageAction.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//GadgetDataList gadgetDataList;
	//Map<String, GadgetData> gadgetMap;
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	Set<Gadget> gadgets;
	
	int requestedPage = 1;
	
	String userId;
	String name;
	Date registeredDate;
	int age;
	String phoneNumber;
	
	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String execute() throws Exception{

		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx = null;
		
		try
		{
			tx = hs.beginTransaction();
			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
							
			userId = user.getUserId();
			
			user = (User)hs.load(User.class, userId);
					
			name = user.getPerson().getName();
			registeredDate = user.getRegisteredDate();
			//System.out.println("--------------------------------------list count " + registeredDate);
			age = user.getPerson().getAge();
			
			Set<PersonAdditionalInfo2> set = user.getPerson().getAdditionalInfo2s();
			phoneNumber ="";
			
			for (PersonAdditionalInfo2 p: set)
			{
				if (p.getAttribute().equals(Info2AttributeEnum.phoneNumbers) && p.getPrimary())
				{
					phoneNumber = p.getValue();
					break;
				}
			}
			
	
			//System.out.println("--------------------------------------list count ");
			//session.put(SKTOpenSocialSupportConstants.USER, user);
			
			this.gadgets = user.getFavoriteGadgets();
			// logger.log(Level.INFO, "Number of gadgets = " + gadgets.size());
			
			tx.commit();
			
			return "success";
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.RequestAware#setRequest(java.util.Map)
	 */
	/*@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		//this.request = request;

	}*/

	
	
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}

//	public GadgetDataList getGadgetDataList() {
//		return gadgetDataList;
//	}
//
//	public void setGadgetDataList(GadgetDataList gadgetDataList) {
//		this.gadgetDataList = gadgetDataList;
//	}
//
//	public Map<String, GadgetData> getGadgetMap() {
//		return gadgetMap;
//	}
//
//	public void setGadgetMap(Map<String, GadgetData> gadgetMap) {
//		this.gadgetMap = gadgetMap;
//	}
//
//	public Collection<GadgetData> getGadgetList() {
//		return gadgetList;
//	}
//
//	public void setGadgetList(Collection<GadgetData> gadgetList) {
//		this.gadgetList = gadgetList;
//	}

	public int getRequestedPage() {
		return requestedPage;
	}

	public void setRequestedPage(int requestedPage) {
		this.requestedPage = requestedPage;
	}

	public Set<Gadget> getGadgets() {
		return gadgets;
	}

	public void setGadgets(Set<Gadget> gadgets) {
		this.gadgets = gadgets;
	}

	
	
}
