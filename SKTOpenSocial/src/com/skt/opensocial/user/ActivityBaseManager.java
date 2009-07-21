/**
 * 
 */
package com.skt.opensocial.user;


import java.util.Date;
import java.util.HashSet;

import java.util.Map;
import java.util.Set;

//import org.apache.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.skt.opensocial.developer.ManageGadgetAction;

import com.skt.opensocial.persistence.Activity;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.Person;
import com.skt.opensocial.persistence.User;

/**
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class ActivityBaseManager extends ManageGadgetAction {
	//private static Logger logger = Logger.getLogger(ActivityManager.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Map<String, Object> session;
	
	Activity activityNew = null;
	Set<Activity> setActivity = null;
		
	public ActivityBaseManager() {
		super();
		
		// TODO Auto-generated constructor stub
	}
	
	public boolean addActivity( ActivityTypeEnum activityEnum, String userId, String otherUserId, Long gadgetId) throws Exception
	{
		//System.out.println("add activity - 0" );
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try
		{
			//System.out.println("add activity - 1" );
			
			tx = hs.beginTransaction();
			
			//System.out.println("add activity - 2" );
			
			User user = (User)hs.load(User.class, userId);
			Person person = user.getPerson();
			
			User otherUser = (User)hs.load(User.class, otherUserId);
			
			//System.out.println("add activity - 3" );
			
			if (otherUser != null)
				otherUserId = otherUser.getId();
			
			//System.out.println("add activity - 4" );
			setActivity = person.getActivities();
			
			//System.out.println("add activity - 5" );
			
			if (setActivity == null)
			{
				setActivity = new HashSet<Activity>();
				person.setActivities(setActivity);
			}
			
			//System.out.println("add activity - 6" );
			
			activityNew = new Activity();
			
			activityNew.setPerson(person);
			activityNew.setUpdated(new Date());
			
			//System.out.println("add activity - 7" );
			
			if (activityEnum.equals(ActivityTypeEnum.addFavoriteFriend))
				activityNew.setTitle(userId + " adds " + otherUserId + " to his favorite friends list");
			else if (activityEnum.equals(ActivityTypeEnum.removeFavoriteFriend))
				activityNew.setTitle(userId + " removes " + otherUserId + " from his favorite friends list");
			else if (activityEnum.equals(ActivityTypeEnum.addFavoriteGadget))
				activityNew.setTitle(userId + " adds " + gadgetId + " to his favorite gadgets list");
			else if (activityEnum.equals(ActivityTypeEnum.removeFavoriteGadget))
				activityNew.setTitle(userId + " removes " + gadgetId + " from his favorite gadgets list");
			else if (activityEnum.equals(ActivityTypeEnum.addGadgetReview))
				activityNew.setTitle(userId + " adds a gadget review to " + gadgetId + "'s review list");
			else if (activityEnum.equals(ActivityTypeEnum.removeGadgetReview))
				activityNew.setTitle(userId + " removes a gadget review from " + gadgetId + "'s review list");
			else if (activityEnum.equals(ActivityTypeEnum.executeGadget))
				activityNew.setTitle(userId + " executes " + gadgetId + "");
			else if (activityEnum.equals(ActivityTypeEnum.otherUserInfo))
				activityNew.setTitle(userId + " views " + otherUserId + "'s info");
			else if (activityEnum.equals(ActivityTypeEnum.modifyPersonalProfile))
				activityNew.setTitle(userId + " modifies his personal information" );
						
			//System.out.println("add activity - 8" );
			activityNew.setPostedTime(Double.valueOf(0));
			activityNew.setPriority(Double.valueOf(0));
			
			if (activityNew != null)
				setActivity.add(activityNew);
			person.setActivities(setActivity);
			
			//System.out.println("add activity - 9" );
			
			hs.saveOrUpdate(activityNew);
			hs.saveOrUpdate(person);
			//hs.saveOrUpdate(user);
			tx.commit();
			
			//System.out.println("add activity - 10" );
			return true;
			
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}
	
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}
	/**
	 * 
	 */

}
