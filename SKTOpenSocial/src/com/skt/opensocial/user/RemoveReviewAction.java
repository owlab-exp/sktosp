/**
 * 
 */
package com.skt.opensocial.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.developer.DeveloperBaseAction;

import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetReview;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.Person;
import com.skt.opensocial.persistence.User;

/**
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class RemoveReviewAction extends DeveloperBaseAction {
	private static Logger logger = Logger.getLogger(RemoveReviewAction.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//GadgetDataList gadgetDataList;
	//Map<String, GadgetData> gadgetMap;
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	Long gadgetId;
	
	Gadget gadget;
	Set<GadgetReview> gadgetReviews;
	
	String reviewText;
	String reviewGrade;
	String reviewerId;
	User reviewer;
	
	Long reviewId;
	
	GadgetReview review;
				
	public GadgetReview getReview() {
		return review;
	}

	public void setReview(GadgetReview review) {
		this.review = review;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	int requestedPage = 1;
		
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

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public String getReviewGrade() {
		return reviewGrade;
	}

	public void setReviewGrade(String reviewGrade) {
		this.reviewGrade = reviewGrade;
	}

	public String getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(String reviewerId) {
		this.reviewerId = reviewerId;
	}

	public User getReviewer() {
		return reviewer;
	}

	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}

	public String execute(){
		
		User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
							
		reviewerId = user.getId();
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
						
		gadget = (Gadget)hs.load(Gadget.class, gadgetId);
		reviewer = (User)hs.load(User.class, reviewerId);
		
		if (gadget != null)
			System.out.println("gadget Id : " + gadget.getId());
		else
			return "fail";
		
		if (reviewer != null)
			System.out.println("reviewer Id : " + reviewer.getId());
		else
			return "fail";
		
		gadgetReviews = gadget.getReviews();
					
		if (gadget.getReviews() !=null)
			System.out.println("number of reviews at before" + gadgetReviews.size());
		
		System.out.println("review Id : " + reviewId);
		
		for (GadgetReview gr:gadgetReviews)
		{
			System.out.println("gr Id : " + gr.getId());
			if (gr.getId().equals(reviewId))
				review = gr;
		}
		
		if (review !=null)
			System.out.println("review id for removing " + review.getId());
		
		// gadgetReviews.remove(review);
		
		session.put(SKTOpenSocialSupportConstants.GADGETID, gadgetId);
		
		gadget.setReviews(gadgetReviews);
		
		hs.delete(review);
		hs.saveOrUpdate(gadget);
				
		hs.getTransaction().commit();
		
		//
		/*GadgetDataList gadgetDataListS = (GadgetDataList)session.get("gadgets");
		if(gadgetDataList == null) {
			session.put("gadgets", new GadgetDataList());
			this.gadgetDataList = (GadgetDataList)session.get("gadgets");
		} else {
			this.gadgetDataList = gadgetDataListS;
		}
		gadgetMap = this.gadgetDataList.getGadgetMap();
		gadgetList = gadgetMap.values();
		
		System.out.println("list count = " + gadgetDataList.getGadgetMap().size());
		*/

			return "success" ;
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
