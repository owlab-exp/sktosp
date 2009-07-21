/**
 * 
 */
package com.skt.opensocial.user;

import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.developer.DeveloperBaseAction;

import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class ManageFriendAction extends DeveloperBaseAction {
	private static Logger logger = Logger.getLogger(ManageFriendAction.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//GadgetDataList gadgetDataList;
	//Map<String, GadgetData> gadgetMap;
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	Set<User> friends;
	
	int requestedPage = 1;
	
	
	
	public Set<User> getFriends() {
		return friends;
	}

	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}

	public String execute(){
		//
		User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
		
		String userId = user.getUserId();
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		user = (User)hs.load(User.class, userId);
		
		
		//session.put(SKTOpenSocialSupportConstants.USER, user);
		
		this.friends = user.getFriendsByMe();
		 logger.log(Level.INFO, "Number of gadgets = " + friends.size());
		
		hs.getTransaction().commit();
		

		
		return Action.SUCCESS;
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

}
