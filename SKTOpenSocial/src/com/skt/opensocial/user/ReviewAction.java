/**
 * 
 */
package com.skt.opensocial.user;


import java.util.Map;
import java.util.Set;

import org.hibernate.Session;

import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.developer.DeveloperBaseAction;

import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetReview;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**	사용자가 가젯의 리뷰를 조회하는 액션 클래스
 * @author 	Seong Yong Lim based on Ernest Lee's
 * @version 
 * @since	1.0
 * 
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class ReviewAction extends DeveloperBaseAction {
	//private static Logger logger = Logger.getLogger(ReviewAction.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//GadgetDataList gadgetDataList;
	//Map<String, GadgetData> gadgetMap;
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	String userId;
	/**	리뷰를 조회하려는 가젯 아이디 정보
	 *  
	 */	
	Long gadgetId;
	Gadget gadget;
	
	/**	출력되는 리뷰들 정보
	 *  
	 */	
	Set<GadgetReview> gadgetReviews;
		
	int requestedPage = 1;
		
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getGadgetId() {
		return gadgetId;
	}

	public void setGadgetId(Long gadgetId) {
		this.gadgetId = gadgetId;
	}

	public Gadget getGadget() {
		return gadget;
	}

	public void setGadget(Gadget gadget) {
		this.gadget = gadget;
	}

	public Set<GadgetReview> getGadgetReviews() {
		return gadgetReviews;
	}

	public void setGadgetReviews(Set<GadgetReview> gadgetReviews) {
		this.gadgetReviews = gadgetReviews;
	}

	/** execute 메소드 에서는 가젯의 아이디를 이용해 리뷰들 정보를 가져온다.
	 * 
	 */
	public String execute() throws Exception{
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx = null;
		
		try
		{
			tx = hs.beginTransaction();
			
			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
			userId = user.getId();
								
			if (gadgetId == null)
			{
				gadgetId = (Long) session.get(SKTOpenSocialSupportConstants.GADGETID);
			}
			
			System.out.println("gadgetId" + gadgetId);
			
			gadget = (Gadget)hs.load(Gadget.class, gadgetId);
			
			gadgetReviews = gadget.getReviews();
			
			if (gadgetReviews !=null)
				System.out.println("number of reviews" + gadgetReviews.size());
			else 
				return "fail";
			
			for (GadgetReview gr:gadgetReviews)
			{
				gr.getReviewer().getPerson().getName();
				gr.getGadget().getIcon();
			}
			
			
			//List cats = sess.createCriteria(Cat.class)
		    //.add( Restrictions.like("name", "Fritz%") )
		    //.add( Restrictions.between("weight", minWeight, maxWeight) )
		    //.list();
					
			tx.commit();
	
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
