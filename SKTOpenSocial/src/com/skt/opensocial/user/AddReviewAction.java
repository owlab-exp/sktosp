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
public class AddReviewAction extends DeveloperBaseAction {
	private static Logger logger = Logger.getLogger(AddReviewAction.class);
	
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
		
		for (GadgetReview gr:gadgetReviews)
		{
			gr.getReviewer().getId();			
		}
		
		if (Integer.parseInt(reviewGrade) < 1 || Integer.parseInt(reviewGrade) > 10)
			reviewGrade = "5";
		
		if (reviewText == null)
			return "fail";
		
		GadgetReview review = new GadgetReview();
		
		review.setGadget(gadget);
		System.out.println("grade of review" + reviewGrade);
		review.setReviewGrade(Integer.parseInt(reviewGrade));
		review.setReviewText(reviewText);
		review.setReviewDate(new Date());
		review.setReviewer(reviewer);
		
		if (reviewer !=null)
		{
			System.out.println("gadget id of review" + review.getGadget().getId());
			System.out.println("grade of review" + review.getReviewGrade());
			System.out.println("text of review" + review.getReviewText());
			System.out.println("date of review" + review.getReviewDate());
		}
		
		gadget.addReview(review);
		
		if (gadget.getReviews() !=null)
			System.out.println("number of reviews after" + gadget.getReviews().size());
		//List cats = sess.createCriteria(Cat.class)
	    //.add( Restrictions.like("name", "Fritz%") )
	    //.add( Restrictions.between("weight", minWeight, maxWeight) )
	    //.list();
		
		session.put(SKTOpenSocialSupportConstants.GADGETID, gadgetId);
		
		hs.saveOrUpdate(gadget);
		hs.saveOrUpdate(review);
		
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
