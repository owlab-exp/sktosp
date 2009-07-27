/**
 * 
 */
package com.skt.opensocial.user;

import java.util.Date;

import java.util.Map;
import java.util.Set;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.skt.opensocial.common.SKTOpenSocialSupportConstants;


import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetReview;
import com.skt.opensocial.persistence.HibernateUtil;

import com.skt.opensocial.persistence.User;

/**
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class AddReviewAction extends ActivityBaseManager {
	//private static Logger logger = Logger.getLogger(AddReviewAction.class);
	
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

	public String execute() throws Exception{
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try
		{
			
		
			tx = hs.beginTransaction();
							
			
			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
								
			reviewerId = user.getId();
			
			
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
			
			tx.commit();
			
			super.addActivity(ActivityTypeEnum.addGadgetReview, reviewerId, "", gadgetId);
			
			return "success";
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
