/**
 * 
 */
package com.skt.opensocial.user;


import java.util.Map;
import java.util.Set;


import org.hibernate.Session;


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
public class RemoveReviewAction extends ActivityBaseManager {
	//private static Logger logger = Logger.getLogger(RemoveReviewAction.class);
	
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

	public String execute() throws Exception {
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx = null;
		
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
			
			System.out.println("review Id : " + reviewId);
			
			for (GadgetReview gr:gadgetReviews)
			{
				System.out.println("gr Id : " + gr.getId());
				if (gr.getId().equals(reviewId))
					review = gr;
			}
			
			if (review !=null)
				System.out.println("review id for removing " + review.getId());
									
			session.put(SKTOpenSocialSupportConstants.GADGETID, gadgetId);
			
			gadget.setReviews(gadgetReviews);
			
			hs.delete(review);
			hs.saveOrUpdate(gadget);
					
			tx.commit();
			
			super.addActivity(ActivityTypeEnum.removeGadgetReview, reviewerId, "", gadgetId);

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
