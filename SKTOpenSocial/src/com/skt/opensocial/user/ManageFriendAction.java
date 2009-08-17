/**
 * 
 */
package com.skt.opensocial.user;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.admin.Paging;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.developer.DeveloperBaseAction;

import com.skt.opensocial.persistence.Activity;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.Person;
import com.skt.opensocial.persistence.User;

/**
 * 친구들의 목록을 가져오기 위한 액션 클래스
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
public class ManageFriendAction extends DeveloperBaseAction {
	private static Logger logger = Logger.getLogger(ManageFriendAction.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * 세션에 들어있는 오브젝트들의 맵
	 */
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	/**
	 * 친구들인 사용자의 목록
	 */
	List<User> friends;
	
	/**
	 * 요청된 페이지
	 */
	int requestedPage = 1;
	
	// paging
	/**
	 * 페이징을 위한 오브젝트
	 */
	Paging pages;
	/**
	 * 페이지 숫자들의 목록
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
	 * 목록에 보여질 행의 갯수
	 */
	int listscale	= 10;
	/**
	 * 페이지 목록에 보여질 페이지 숫자들의 갯수
	 */
	int pagescale	= 10;
	/**
	 * 현재 페이지
	 */
	int currentpage	= 1;
	/**
	 * 전체 목록의 갯수
	 */
	int totalcount	= 0;
	
	// sorting
	/**
	 * 순서가 적용될 필드
	 */
	String sortfield	= "registeredDate";
	/**
	 * 순서 (오름차순 혹은 내림차순)
	 */
	String sortsc	= "desc";

	/**
	 * 친구들의 목록을 가져온다
	 * @return 친구 목록
	 */
	public List<User> getFriends() {
		return friends;
	}

	/**
	 * 친구들의 목록을 셋팅한다
	 * @param friends 친구 목록
	 */
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	/**
	 * 화면의 친구 목록 아래에 표시될 페이지 숫자들의 목록을 가져온다
	 * @return 페이지 숫자들의 목록
	 */
	public List<Integer> getPaging() {
		return paging;
	}

	/**
	 * 화면의 친구 목록 아래에 표시될 페이지 숫자들의 목록을 셋팅한다
	 * @param paging 페이지 숫자들의 목록
	 */
	public void setPaging(List<Integer> paging) {
		this.paging = paging;
	}

	/**
	 * 이전 페이지 숫자를 가져온다
	 * @return 이전 페이지 숫자
	 */
	public int getPrepage() {
		return prepage;
	}

	/**
	 * 이전 페이지 숫자를 셋팅한다
	 * @param prepage 이전 페이지 숫자
	 */
	public void setPrepage(int prepage) {
		this.prepage = prepage;
	}

	/**
	 * 다음 페이지 숫자를 가져온다
	 * @return 다음 페이지 숫자
	 */
	public int getPostpage() {
		return postpage;
	}

	/**
	 * 다음 페이지 숫자를 셋팅한다
	 * @param postpage 다음 페이지 숫자
	 */
	public void setPostpage(int postpage) {
		this.postpage = postpage;
	}

	/**
	 * 현재 페이지를 가져온다
	 * @return 현재 페이지 숫자
	 */
	public int getCurrentpage() {
		return currentpage;
	}

	/**
	 * 현재 페이지 숫자를 셋팅한다
	 * @param currentpage 현재 페이지 숫자
	 */
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	/**
	 * 전체 친구들의 명 수를 가져온다
	 * @return 전체 친구들의 수
	 */
	public int getTotalcount() {
		return totalcount;
	}

	/**
	 * 전체 친구들의 명 수를 셋팅한다
	 * @param totalcount 전체 친구들의 수
	 */
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}

	/**
	 * 순서를 적용할 기준 필드를 가져온다
	 * @return 필드 이름
	 */
	public String getSortfield() {
		return sortfield;
	}

	/**
	 * 순서를 적용할 기준 필드를 셋팅한다
	 * @param sortfield 필드 이름
	 */
	public void setSortfield(String sortfield) {
		this.sortfield = sortfield;
	}

	/**
	 * 순서 적용시 내림차순인지 오름차순인지를 가져온다
	 * @return 내림차순 혹은 오름차순을 나타내는 문자열
	 */
	public String getSortsc() {
		return sortsc;
	}

	/**
	 * 순서 적용시 내림차순인지 오름차순인지를 셋팅한다
	 * @param sortsc 내림차순 혹은 오름차순을 나타내는 문자열
	 */
	public void setSortsc(String sortsc) {
		this.sortsc = sortsc;
	}

	/**
	 * 사용자 ID를 가지고 그 사용자의 친구들의 목록을 생성하는 액션 메소드
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception{
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try {
			tx = hs.beginTransaction();
			//
			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
			
			String userId = user.getUserId();
									
			user = (User)hs.load(User.class, userId);
			
			// paging
			pages	= new Paging(pagescale, listscale);
			pages.setCurrentpage(this.currentpage);
			
			//session.put(SKTOpenSocialSupportConstants.USER, user);
			
			Criteria crit = hs.createCriteria(User.class, "user")
				//.createAlias("user.friendsByMe", "fm",CriteriaSpecification.LEFT_JOIN)
				.createAlias("user.friendsByOther", "fo",CriteriaSpecification.LEFT_JOIN)
				//.add(Restrictions.or(Restrictions.eq("fm.id", userId),Restrictions.eq("fo.id", userId)));
				.add(Restrictions.eq("fo.id", userId));
			Criteria crit2 = hs.createCriteria(User.class, "user")
				//.createAlias("user.friendsByMe", "fm",CriteriaSpecification.LEFT_JOIN)
				.createAlias("user.friendsByOther", "fo",CriteriaSpecification.LEFT_JOIN)
				//.add(Restrictions.or(Restrictions.eq("fm.id", userId),Restrictions.eq("fo.id", userId)));
				.add(Restrictions.eq("fo.id", userId));
			// add order
			//crit.addOrder(Order.desc("user.id")); // or just "id" instead of "user.id"

//			Criteria c = hs.createCriteria(User.class);
//			Criteria t = hs.createCriteria(User.class);
//		
			//c.add(Restrictions.or(Restrictions.eq(propertyName, value), rhs))
//			c.add(Restrictions.eq("id", userId));
//			t.add(Restrictions.eq("id", userId));
			
			crit.setFirstResult(pages.getFirstresult());
			crit.setMaxResults(pages.getListscale());
			
			System.out.println("pages.getFirstresult() = " + pages.getFirstresult());
			System.out.println("pages.getListscale() = " + pages.getListscale());
			
			if (this.sortsc.equals("desc")) {
				crit.addOrder( Order.desc(this.sortfield) );
			}
			else {
				crit.addOrder( Order.asc(this.sortfield) );			
			}
			
			//this.friends = (List<User>) user.getFriendsByMe();
			this.friends = (List<User>) crit.list();
//			Collections.sort(this.friends, new RegisteredDateDescendingComparator());
//						
			crit2.setProjection( Projections.rowCount() );	
			this.totalcount	=  ((Integer)crit2.list().get(0)).intValue();
//			this.totalcount	=  this.friends.size();
//			System.out.println("total count = " + totalcount);
			
//			this.friends = this.friends.subList(pages.getFirstresult(), pages.getFirstresult() + pages.getListscale() - 1);
			
			// paging
			pages.setTotalcount(this.totalcount);
			this.paging		= pages.getPaging();
			this.prepage	= pages.getPrepage();
			this.postpage	= pages.getPostpage();
			
			System.out.println("list" + paging.toString());
			System.out.println("prepage" + prepage);
			System.out.println("postpage" + postpage);
			
			//logger.log(Level.INFO, "Number of gadgets = " + friends.size());
			
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		
		return Action.SUCCESS;
	}
	
	/**
	 * 친구들을 등록날짜로 정렬하기 위한 Compartor
	 * @author Seong Yong Lim 
	 *
	 */
	class RegisteredDateDescendingComparator implements Comparator<User> 
	{
		public int compare(User o1, User o2) 
		{
		
			return ((User)o1).getRegisteredDate().before(((User)o2).getRegisteredDate()) ? -1 
		    		: ( ((User)o1).getRegisteredDate().after(((User)o2).getRegisteredDate()) ? 1 : 0); // descending 정렬.....
		 }
	}
	
	/**
	 * HTTP Session 오브젝트를 액션 메소드에서 참조하기 위한 메소드
	 * @see com.skt.opensocial.developer.DeveloperBaseAction#setSession(java.util.Map)
	 */
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}

	/**
	 * 요청된 페이지를 가져온다
	 * @return 요청된 페이지 숫자
	 */
	public int getRequestedPage() {
		return requestedPage;
	}

	/**
	 * 요청된 페이지를 셋팅한다
	 * @param requestedPage 요청된 페이지 숫자
	 */
	public void setRequestedPage(int requestedPage) {
		this.requestedPage = requestedPage;
	}

}
