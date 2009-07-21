/**
 * 
 */
package com.skt.opensocial.developer;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetReview;
import com.skt.opensocial.persistence.HibernateUtil;

/**
 * @author Ernest Lee
 * 
 */
// public class ListGadgetsAction extends ActionSupport implements RequestAware
// {
public class ViewReviewAction extends ManageGadgetAction implements Pagenation {
	Logger logger = Logger.getLogger(ViewReviewAction.class);

	private long totalReviewNumber = 0;
	private double gradeAverage = 0;
	private List<GadgetReview> gadgetReviews = new ArrayList<GadgetReview>();

	// properties for pagenation
	private int listSize = 10; // the size of gadget list
	private int requestedPage = 1;
	private int maxPage = 1;

	private int startPage = 1;
	private int pageListSizeMax = 10;

	private List<Integer> pageList = new ArrayList<Integer>();

	// end for pagenation

	@SuppressWarnings("unchecked")
	public String execute() throws Exception{
		logger.info("called");

		Transaction tx = null;
		try {
			Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = hs.beginTransaction();

			if (getGadgetId() == null) {
				tx.rollback();
				return Action.ERROR;
			}

			Query query = hs
					.createQuery("select avg(review.reviewGrade), count(*) from GadgetReview review where review.gadget.id = "
							+ getGadgetId());
			Object[] result = (Object[]) query.uniqueResult();

			if(result[0] != null && result[1] != null) {
				totalReviewNumber = (Long) result[1];
				gradeAverage = (Double) result[0];
			}
			

			Criteria crit = hs.createCriteria(GadgetReview.class);
			crit.add(Restrictions.eq("gadget.id", getGadgetId()));

			// for pagenation properties
			if (listSize > 0)
				maxPage = (int) Math
						.ceil((double) totalReviewNumber / listSize);

			startPage = (requestedPage - (requestedPage % pageListSizeMax)) + 1; // 1,
																					// 11,
																					// 21,
																					// ...
			for (int i = startPage, j = 1; j <= pageListSizeMax; i++, j++) {
				if (i > maxPage)
					break;
				pageList.add(new Integer(i));
			}

			// add order
			crit.addOrder(Order.desc("reviewDate"));

			// determine result set
			if (requestedPage > 0) {
				crit.setFirstResult((requestedPage - 1) * listSize);
			} else if (requestedPage <= 0) {
				crit.setFirstResult(0);
				requestedPage = 1;
			} else if (requestedPage >= maxPage) {
				crit.setFirstResult((maxPage - 1) * listSize);
			}
			crit.setMaxResults(listSize);

			// get review list
			gadgetReviews = (List<GadgetReview>) crit.list();

			// to fill person data in review
			for (GadgetReview review : gadgetReviews) {
				review.getReviewer().getPerson();
			}

			// to set gadget name and id
			Gadget gadget = (Gadget) hs.get(Gadget.class, getGadgetId());

			setGadgetName(gadget.getName());
			setGadgetId(gadget.getId());

			tx.commit();
			return Action.SUCCESS;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

	}

	public long getTotalReviewNumber() {
		return totalReviewNumber;
	}

	public void setTotalReviewNumber(long totalReviewNumber) {
		this.totalReviewNumber = totalReviewNumber;
	}

	public double getGradeAverage() {
		return gradeAverage;
	}

	public void setGradeAverage(double gradeAverage) {
		this.gradeAverage = gradeAverage;
	}

	public List<GadgetReview> getGadgetReviews() {
		return gadgetReviews;
	}

	public void setGadgetReviews(List<GadgetReview> gadgetReviews) {
		this.gadgetReviews = gadgetReviews;
	}

	// for pagenation
	public int getRequestedPage() {
		return requestedPage;
	}

	public void setRequestedPage(int requestedPage) {
		this.requestedPage = requestedPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public List<Integer> getPageList() {
		return pageList;
	}

	public void setPageList(List<Integer> pageList) {
		this.pageList = pageList;
	}
	// end for pagenation

}
