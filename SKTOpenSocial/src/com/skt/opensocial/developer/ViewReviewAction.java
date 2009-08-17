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
 * 사용자가 남기 가젯 리뷰를 개발자가 조회하기 위한 액션 클래스
 * @author Ernest Lee
 * 
 */
// public class ListGadgetsAction extends ActionSupport implements RequestAware
// {
public class ViewReviewAction extends ManageGadgetAction implements Pagenation {
	Logger logger = Logger.getLogger(ViewReviewAction.class);

	/**
	 * 리뷰의 총 갯수
	 */
	private long totalReviewNumber = 0;
	/**
	 * 사용자가 남긴 점수의 평균
	 */
	private double gradeAverage = 0;
	/**
	 * 리뷰 오브젝트들의 리스트
	 */
	private List<GadgetReview> gadgetReviews = new ArrayList<GadgetReview>();

	// properties for pagenation
	/**
	 * 리뷰 목록의 페이지 당 갯수
	 */
	private int listSize = 10; // the size of gadget list
	/**
	 * 요청된 페이지 숫자
	 */
	private int requestedPage = 1;
	/**
	 * 전체 페이지 갯수
	 */
	private int maxPage = 1;

	/**
	 * 페이지 목록의 첫 페이지
	 */
	private int startPage = 1;
	/**
	 * 페이지 목록에 나타날 페이지의 총 수
	 */
	private int pageListSizeMax = 10;

	/**
	 * 페이지 목록 (숫자들의 목록)
	 */
	private List<Integer> pageList = new ArrayList<Integer>();

	// end for pagenation

	/**
	 * 리뷰 목록을 보여주기 위한 액션 메소드
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
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

	/**
	 * 전체 리뷰 갯수를 가져온다
	 * @return 전체 리뷰 갯수
	 */
	public long getTotalReviewNumber() {
		return totalReviewNumber;
	}

	/**
	 * 전체 리뷰 갯수를 셋팅한다
	 * @param totalReviewNumber 전체 리뷰 갯수
	 */
	public void setTotalReviewNumber(long totalReviewNumber) {
		this.totalReviewNumber = totalReviewNumber;
	}

	/**
	 * 사용자가 매긴 점수들의 평균을 가져온다
	 * @return 평균점수
	 */
	public double getGradeAverage() {
		return gradeAverage;
	}

	/**
	 * 사용자가 매긴 점수들의 평균을 셋팅한다
	 * @param gradeAverage 평균점수
	 */
	public void setGradeAverage(double gradeAverage) {
		this.gradeAverage = gradeAverage;
	}

	/**
	 * 가젯 리뷰 목록을 가져온다
	 * @return 가젯 리뷰 목록
	 */
	public List<GadgetReview> getGadgetReviews() {
		return gadgetReviews;
	}

	/**
	 * 가젯 리뷰 목록을 셋팅한다
	 * @param gadgetReviews 가젯 리뷰 목록
	 */
	public void setGadgetReviews(List<GadgetReview> gadgetReviews) {
		this.gadgetReviews = gadgetReviews;
	}

	/* (non-Javadoc)
	 * @see com.skt.opensocial.developer.Pagenation#getRequestedPage()
	 */
	public int getRequestedPage() {
		return requestedPage;
	}

	/* (non-Javadoc)
	 * @see com.skt.opensocial.developer.Pagenation#setRequestedPage(int)
	 */
	public void setRequestedPage(int requestedPage) {
		this.requestedPage = requestedPage;
	}

	/* (non-Javadoc)
	 * @see com.skt.opensocial.developer.Pagenation#getMaxPage()
	 */
	public int getMaxPage() {
		return maxPage;
	}

	/* (non-Javadoc)
	 * @see com.skt.opensocial.developer.Pagenation#setMaxPage(int)
	 */
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	/* (non-Javadoc)
	 * @see com.skt.opensocial.developer.Pagenation#getPageList()
	 */
	public List<Integer> getPageList() {
		return pageList;
	}

	/* (non-Javadoc)
	 * @see com.skt.opensocial.developer.Pagenation#setPageList(java.util.List)
	 */
	public void setPageList(List<Integer> pageList) {
		this.pageList = pageList;
	}
	// end for pagenation

}
