/**
 * 
 */
package com.skt.opensocial.user;

import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.skt.opensocial.common.SKTOpenSocialSupportConstants;

import com.skt.opensocial.persistence.Activity;

import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.Person;
import com.skt.opensocial.persistence.User;

/**
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class RemoveActivityAction extends ActivityBaseManager {
	//private static Logger logger = Logger.getLogger(RemoveActivityAction.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//GadgetDataList gadgetDataList;
	//Map<String, GadgetData> gadgetMap;
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	int requestedPage = 1;
	
	int activityId;
	Set<Activity> activities = null;
	String userId;
	Activity targetActivity = null;
	
	public Activity getTargetActivity() {
		return targetActivity;
	}

	public void setTargetActivity(Activity targetActivity) {
		this.targetActivity = targetActivity;
	}

	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String requestConfirm() throws Exception 
	{
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx =null;
		
		try
		{
			tx = hs.beginTransaction();
		
			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
			
			userId = user.getId();
						
			user = (User)hs.load(User.class, userId);
			Person person = user.getPerson();
			
			activities = person.getActivities();
			
			if (activities == null)
			{
				if (tx != null)
					tx.rollback();
				return "fail";
			}
						
			for (Activity a : activities)
			{
				if (a.getId().equals(activityId))
					targetActivity = a;
				
			}
			//System.out.println("review Id : " + reviewId);
			
			if (targetActivity != null)
			{
		
			}
					
			tx.commit();
			
			//super.addActivity(ActivityTypeEnum.removeActivity, userId, "", null);
			
			return "remove_confirm_page";
			
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}

	public String execute() throws Exception {
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx =null;
		
		try
		{
			tx = hs.beginTransaction();
		
			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
			
			userId = user.getId();
						
			user = (User)hs.load(User.class, userId);
			Person person = user.getPerson();
			
			activities = person.getActivities();
			
			if (activities == null)
			{
				if (tx != null)
					tx.rollback();
				return "fail";
			}
			Activity targetActivity = null;
			
			for (Activity a : activities)
			{
				if (a.getId().equals(activityId))
					targetActivity = a;
				
			}
			//System.out.println("review Id : " + reviewId);
			
			if (targetActivity != null)
			{
				activities.remove(targetActivity);
				person.setActivities(activities);
				
				hs.delete(targetActivity);
				hs.saveOrUpdate(person);
			}
					
			tx.commit();
			
			//super.addActivity(ActivityTypeEnum.removeActivity, userId, "", null);
			
			return "success" ;
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
