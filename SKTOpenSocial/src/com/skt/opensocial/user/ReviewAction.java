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

/**
 * @author Seong Yong Lim based on Ernest Lee's
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
	Long gadgetId;
	Gadget gadget;
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
