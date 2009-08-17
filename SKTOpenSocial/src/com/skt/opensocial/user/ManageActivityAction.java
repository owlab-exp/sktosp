/**
 * 
 */
package com.skt.opensocial.user;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.admin.Paging;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.developer.DeveloperBaseAction;
import com.skt.opensocial.persistence.Activity;

import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**
 * 사용자의 액티비티를 화면에 출력하기 위한 액션 클래스
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
public class ManageActivityAction extends DeveloperBaseAction {
	private static Logger logger = Logger.getLogger(ManageFriendAction.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//GadgetDataList gadgetDataList;
	//Map<String, GadgetData> gadgetMap;
	/**
	 * 세션에의 데이터 오브젝트들의 맵
	 */
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	/**
	 * 액티비티의 목록
	 */
	List<Activity> activities = null;
	
	/**
	 * 요청된 페이지 수
	 */
	int requestedPage = 1;
	
	// paging
	/**
	 * 페이징을 위한 오브젝트
	 */
	Paging pages;
	/**
	 * 페이지들의 목록
	 */
	List<Integer> paging;
	/**
	 * 이전 페이지
	 */
	int prepage	= 0;
	/**
	 * 다음 페이지
	 */
	int postpage	= 0;
	/**
	 * 액티비티 목록에 나타날 행의 갯수
	 */
	int listscale	= 10;
	/**
	 * 액티비티 목록의 아래에 나타날 페이지 숫자들의 갯수
	 */
	int pagescale	= 10;
	/**
	 * 현재 페이지
	 */
	int currentpage	= 1;
	/**
	 * 전체 액티비티 갯수
	 */
	int totalcount	= 0;
	
	// sorting
	/**
	 * 액티비티 목록을 정렬할 때의 기준 열
	 */
	String sortfield	= "updated";
	/**
	 * 액티비티 목록을 정렬할 사용될 정렬 순서 (내림차순/오름차순)
	 */
	String sortsc	= "desc";

	/**
	 * 액티비티 목록을 정렬할 때의 기준열을 가져온다
	 * @return
	 */
	public String getSortfield() {
		return sortfield;
	}

	/**
	 * 액티비티 목록을 정렬할 때의 기준열을 셋팅한다
	 * @param sortfield
	 */
	public void setSortfield(String sortfield) {
		this.sortfield = sortfield;
	}

	/**
	 * 액티비티 목록을 정렬할 때의 정렬 순서를 가져온다
	 * @return
	 */
	public String getSortsc() {
		return sortsc;
	}

	/**
	 * 액티비티 목록을 정렬할 때의 정렬 순서를 셋팅한다
	 * @param sortsc
	 */
	public void setSortsc(String sortsc) {
		this.sortsc = sortsc;
	}

	/**
	 * 페이지들의 목록을 가져온다
	 * @return
	 */
	public List<Integer> getPaging() {
		return paging;
	}

	
	/**
	 * 페이지들의 목록을 셋팅한다
	 * @param paging
	 */
	public void setPaging(List<Integer> paging) {
		this.paging = paging;
	}

	/**
	 * 이전 페이지 숫자를 가져온다
	 * @return
	 */
	public int getPrepage() {
		return prepage;
	}

	/**
	 * 이전 페이지 숫자를 셋팅한다
	 * @param prepage
	 */
	public void setPrepage(int prepage) {
		this.prepage = prepage;
	}

	/**
	 * 다음 페이지 숫자를 가져온다
	 * @return
	 */
	public int getPostpage() {
		return postpage;
	}

	/**
	 * 다음 페이지 숫자를 셋팅한다
	 * @param postpage
	 */
	public void setPostpage(int postpage) {
		this.postpage = postpage;
	}

	/**
	 * 현재 페이지 숫자를 가져온다
	 * @return
	 */
	public int getCurrentpage() {
		return currentpage;
	}

	/**
	 * 현재 페이지 숫자를 셋팅한다
	 * @param currentpage
	 */
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	/**
	 * 전체 액티비티 갯수를 가져온다
	 * @return
	 */
	public int getTotalcount() {
		return totalcount;
	}

	/**
	 * 전체 액티비티 숫자를 셋팅한다
	 * @param totalcount
	 */
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}

	/**
	 * 액티비티의 목록을 가져온다
	 * @return
	 */
	public List<Activity> getActivities() {
		return activities;
	}

	/**
	 * 액티비티의 목록을 셋팅한다
	 * @param activities
	 */
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	/**
	 * 주어진 사용자 ID에 해당하는 액티비티의 목록을 생성하는 액션 메소드
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception{
		//
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
//		try {
			tx = hs.beginTransaction();
		
			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
			
			String userId = user.getUserId();
						
			user = (User)hs.load(User.class, userId);
			
			// paing
			pages	= new Paging(pagescale, listscale);
			pages.setCurrentpage(this.currentpage);
									
			Criteria c = hs.createCriteria(Activity.class);
			Criteria t = hs.createCriteria(Activity.class);
			
			c.add(Restrictions.eq("userId", userId));
			t.add(Restrictions.eq("userId", userId));
			
			c.setFirstResult(pages.getFirstresult());
			c.setMaxResults(pages.getListscale());
			
			if (this.sortsc.equals("desc")) {
				c.addOrder( Order.desc(this.sortfield) );
			}
			else {
				c.addOrder( Order.asc(this.sortfield) );			
			}
			
			//this.activities = user.getPerson().getActivities();
			this.activities = (List<Activity>) c.list();
			
			t.setProjection( Projections.rowCount() );		
			this.totalcount	=  ((Integer)t.list().get(0)).intValue();
			System.out.println("total count = " + totalcount);
			
			// paging
			pages.setTotalcount(this.totalcount);
			this.paging	= pages.getPaging();
			this.prepage	= pages.getPrepage();
			this.postpage	= pages.getPostpage();
			
			System.out.println("list" + paging.toString());
			System.out.println("prepage" + prepage);
			System.out.println("postpage" + postpage);
			
			if (activities != null)
				logger.log(Level.INFO, "Number of activities = " + activities.size());
			else
				logger.log(Level.INFO, "set of activities = null" );
			
			tx.commit();
			
			return Action.SUCCESS;
//		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
//			throw e;
//		}
	}
	
	/* (non-Javadoc)
	 * @see com.skt.opensocial.developer.DeveloperBaseAction#setSession(java.util.Map)
	 */
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}

	/**
	 * 요청된 페이지 숫자를 가져온다
	 * @return
	 */
	public int getRequestedPage() {
		return requestedPage;
	}

	/**
	 * 요청된 페이지 숫자를 셋팅한다
	 * @param requestedPage
	 */
	public void setRequestedPage(int requestedPage) {
		this.requestedPage = requestedPage;
	}

}
