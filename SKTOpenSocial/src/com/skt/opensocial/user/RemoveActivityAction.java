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
 * 액티비티 목록으로부터 특정 액티비티를 삭제하기 위한 액션 클래스
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
	/**
	 * HTTP Session 에 들어있는 데이터 오브젝트를 참조하기 위한 프로퍼티
	 */
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	/**
	 * 요청된 페이지
	 */
	int requestedPage = 1;
	
	/**
	 * 액티비티 ID
	 */
	int activityId;
	/**
	 * 액티비티 목록
	 */
	Set<Activity> activities = null;
	/**
	 * 사용자 ID
	 */
	String userId;
	/**
	 * 삭제할 액티비티 오브젝트
	 */
	Activity targetActivity = null;
	
	/**
	 * 삭제할 액티비티 오브젝트를 가져온다
	 * @return
	 */
	public Activity getTargetActivity() {
		return targetActivity;
	}

	/**
	 * 삭제할 액티비티 오브젝트를 셋팅한다
	 * @param targetActivity
	 */
	public void setTargetActivity(Activity targetActivity) {
		this.targetActivity = targetActivity;
	}

	/**
	 * 액티비티 목록을 가져온다
	 * @return
	 */
	public Set<Activity> getActivities() {
		return activities;
	}

	/**
	 * 액티비티 목록을 셋팅한다
	 * @param activities
	 */
	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	/**
	 * 액티비티 ID를 가져온다
	 * @return
	 */
	public int getActivityId() {
		return activityId;
	}

	/**
	 * 액티비티 ID를 셋팅한다
	 * @param activityId
	 */
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	/**
	 * 액티비티 삭제 시 사용자 확인 페이지를 웹 브라우저에 전달한다
	 * @return
	 * @throws Exception
	 */
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

	/**
	 * 특정 액티비티를 사용자의 액티비티 목록에서 삭제하는 액션 메소드
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
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

		
	/* (non-Javadoc)
	 * @see com.skt.opensocial.user.ActivityBaseManager#setSession(java.util.Map)
	 */
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}

	/**
	 * 요청된 페이지를 가져온다
	 * @return
	 */
	public int getRequestedPage() {
		return requestedPage;
	}

	/**
	 * 요청된 페이지를 셋팅한다
	 * @param requestedPage
	 */
	public void setRequestedPage(int requestedPage) {
		this.requestedPage = requestedPage;
	}

	
}
