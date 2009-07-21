/**
 * 
 */
package com.skt.opensocial.user;

import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.developer.DeveloperBaseAction;
import com.skt.opensocial.persistence.Activity;

import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class ManageActivityAction extends DeveloperBaseAction {
	private static Logger logger = Logger.getLogger(ManageFriendAction.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//GadgetDataList gadgetDataList;
	//Map<String, GadgetData> gadgetMap;
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	Set<Activity> activities = null;
	
	int requestedPage = 1;
			
	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	public String execute() throws Exception{
		//
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try {
			tx = hs.beginTransaction();
		
			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
			
			String userId = user.getUserId();
						
			user = (User)hs.load(User.class, userId);
			
			//session.put(SKTOpenSocialSupportConstants.USER, user);
			
			this.activities = user.getPerson().getActivities();
			
			if (activities != null)
				logger.log(Level.INFO, "Number of activities = " + activities.size());
			else
				logger.log(Level.INFO, "set of activities = null" );
			
			tx.commit();
			
			return Action.SUCCESS;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}
	
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}

	public int getRequestedPage() {
		return requestedPage;
	}

	public void setRequestedPage(int requestedPage) {
		this.requestedPage = requestedPage;
	}

}
