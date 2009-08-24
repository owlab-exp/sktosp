/**
 * 
 */
package com.skt.opensocial.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.skt.opensocial.admin.Paging;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.developer.DeveloperBaseAction;

import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.Info1AttributeEnum;
import com.skt.opensocial.persistence.Person;
import com.skt.opensocial.persistence.PersonAdditionalInfo1;
import com.skt.opensocial.persistence.User;

/**
 * 사용자와 가젯을 검색하는데 사용되는 액션 클래스
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware throws Exception {
public class SearchAction extends DeveloperBaseAction {
	//private static Logger logger = Logger.getLogger(SearchAction.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//GadgetDataList gadgetDataList;
	//Map<String, GadgetData> gadgetMap;
	/**
	 * 세션 오브젝트에 포함된 데이터 오브젝트들의 맵
	 */
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	/**
	 * 가젯 목록
	 */
	List<Gadget> gadgets;
	/**
	 * 사용자 목록
	 */
	List<User> users = new ArrayList<User>();
	/**
	 * 사용자(User)에 대응되는 Person 오브젝트들의 목록
	 */
	List<Person> persons = new ArrayList<Person>();
	/**
	 * Person 오브젝트들에 대응하는 PersonAdditionalInfo1 오브젝트들의 목록
	 */
	List<PersonAdditionalInfo1> personalAdditionalInfo1;
	/**
	 * 검색에 사용될 필드
	 */
	String searchfield;
	/**
	 * 데이터베이스 질의 문
	 */
	String query;

	//User user;
	/**
	 * 사용자 ID
	 */
	String userId;
	
	// paging
	/**
	 * 페이징에 사용되는 오브젝트
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
	 * 한 화면에 출력될 검색결과 목록의 갯수
	 */
	int listscale	= 10;
	/**
	 * 페이지 숫자들의 목록 크기
	 */
	int pagescale	= 10;
	/**
	 * 현재 페이지
	 */
	int currentpage	= 1;
	/**
	 * 전체 검색 결과의 총 행 수
	 */
	int totalcount	= 0;
	
	// sorting
	/**
	 * 검색결과를 정렬할 기준 열
	 */
	String sortfield	= null;
	/**
	 * 정렬 순서 (오름차순/내림차순)
	 */
	String sortsc	= "desc";
	
	/**
	 * 요청된 페이지
	 */
	int requestedPage = 1;
	
	/**
	 * 페이지 숫자들의 목록을 가져온다
	 * @return
	 */
	public List<Integer> getPaging() {
		return paging;
	}

	/**
	 * 페이지 숫자들의 목록을 셋팅한다
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
	 * 이전 페이지 숫자들을 셋팅한다
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
	 * 전체 검색 결과의 갯수를 가져온다
	 * @return
	 */
	public int getTotalcount() {
		return totalcount;
	}

	/**
	 * 전체 검색결과의 갯수를 셋팅한다
	 * @param totalcount
	 */
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}

	/**
	 * 정렬 기준 필드를 가져온다
	 * @return
	 */
	public String getSortfield() {
		return sortfield;
	}

	/**
	 * 정렬 기준 필드를 셋팅한다
	 * @param sortfield
	 */
	public void setSortfield(String sortfield) {
		this.sortfield = sortfield;
	}

	/**
	 * 정렬 방법을 가져온다
	 * @return
	 */
	public String getSortsc() {
		return sortsc;
	}

	/**
	 * 정렬 방법을 셋팅한다
	 * @param sortsc
	 */
	public void setSortsc(String sortsc) {
		this.sortsc = sortsc;
	}

	/* (non-Javadoc)
	 * @see com.skt.opensocial.common.CommonBaseAction#getUserId()
	 */
	public String getUserId() {
		return userId;
	}

	/* (non-Javadoc)
	 * @see com.skt.opensocial.common.CommonBaseAction#setUserId(java.lang.String)
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 검색에 사용될 필드를 가져온다
	 * @return
	 */
	public String getSearchfield() {
		return searchfield;
	}

	/**
	 * 검색에 사용될 필드를 셋팅한다
	 * @param searchfield
	 */
	public void setSearchfield(String searchfield) {
		this.searchfield = searchfield;
	}

	/**
	 * 질의문을 가져온다
	 * @return
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * 질의문을 셋팅한다
	 * @param query
	 */
	public void setQuery(String query) {
		this.query = query;
	}


	/**
	 * 사용자 목록을 가져온다
	 * @return
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * 사용자 목록을 셋팅한다
	 * @param users
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * 가젯 목록을 가져온다
	 * @param gadgets
	 */
	public void setGadgets(List<Gadget> gadgets) {
		this.gadgets = gadgets;
	}

	/**
	 * 가젯 목록을 셋팅한다
	 * @return
	 */
	public List<Gadget> getGadgets() {
		return gadgets;
	}

	/**
	 * Person 오브젝트 목록을 가져온다
	 * @return
	 */
	public List<Person> getPersons() {
		return persons;
	}

	/**
	 * Person 오브젝트 목록을 셋팅한다
	 * @param persons
	 */
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	/**
	 * PersonalAdditionalInfo1 오브젝트의 목록을 가져온다
	 * @return
	 */
	public List<PersonAdditionalInfo1> getPersonalAdditionalInfo1() {
		return personalAdditionalInfo1;
	}

	/**
	 * PersonalAdditionalInfo1 오브젝트의 목록을 셋팅한다
	 * @param personalAdditionalInfo1
	 */
	public void setPersonalAdditionalInfo1(
			List<PersonAdditionalInfo1> personalAdditionalInfo1) {
		this.personalAdditionalInfo1 = personalAdditionalInfo1;
	}

	/**
	 * 사용자와 가젯의 검색을 수행하는 액션 메소드
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception{
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx = null;
		
//		try
//		{
			tx = hs.beginTransaction();
			
			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
			
			userId = user.getUserId();
			
			//session.put(SKTOpenSocialSupportConstants.ANONYMOUS, anony);
			
			//this.gadgets = Anonymous.getGadgets(searchfield);
			
			// logger.log(Level.INFO, "Number of gadgets = " + gadgets.size());
			
			String queryKey = "%" + query + "%";
			
			System.out.println("searchfield, query, queryKey = " + searchfield + query + queryKey);
			
			// paing
			pages	= new Paging(pagescale, listscale);
			pages.setCurrentpage(this.currentpage);
			
			Criteria c, t;
			
			if ( searchfield.equals("gadget"))
			{
				c = hs.createCriteria(Gadget.class)
					.add(Restrictions.like("name", queryKey))
					.add(Restrictions.eq("status", "pg"));
				 t = hs.createCriteria(Gadget.class)
					.add(Restrictions.like("name", queryKey))
					.add(Restrictions.eq("status", "pg"));
							
				c.setFirstResult(pages.getFirstresult());
				c.setMaxResults(pages.getListscale());
				
				if (sortfield == null)
					sortfield = "name";
				if (this.sortsc.equals("desc")) {
					c.addOrder( Order.desc(this.sortfield) );
				}
				else {
					c.addOrder( Order.asc(this.sortfield) );			
				}
				this.gadgets = (List<Gadget>) c.list();
				
			}
			else if ( searchfield.equals("username"))
			{
				c = hs.createCriteria(Person.class)
					.add(Restrictions.like("nameFormatted", queryKey));
				t = hs.createCriteria(Person.class)
					.add(Restrictions.like("nameFormatted", queryKey));
							
				c.setFirstResult(pages.getFirstresult());
				c.setMaxResults(pages.getListscale());
				
				if (sortfield == null)
					sortfield = "nameFormatted";
				if (this.sortsc.equals("desc")) {
					c.addOrder( Order.desc(this.sortfield) );
				}
				else {
					c.addOrder( Order.asc(this.sortfield) );			
				}
				this.persons = (List<Person>) c.list();
			}
			else if ( searchfield.equals("tag"))
			{
				c = hs.createCriteria(PersonAdditionalInfo1.class)
					.add(Restrictions.eq("attribute", Info1AttributeEnum.tags))
					.add(Restrictions.like("value", queryKey));
				t = hs.createCriteria(PersonAdditionalInfo1.class)
					.add(Restrictions.eq("attribute", Info1AttributeEnum.tags))
					.add(Restrictions.like("value", queryKey));
							
				c.setFirstResult(pages.getFirstresult());
				c.setMaxResults(pages.getListscale());
				
				//if (sortfield == null)
					sortfield = "userId";
				
				if (this.sortsc.equals("desc")) {
					c.addOrder( Order.desc(this.sortfield) );
				}
				else {
					c.addOrder( Order.asc(this.sortfield) );			
				}
				
				this.personalAdditionalInfo1 = 
					(List<PersonAdditionalInfo1>) c.list();
				
				for (PersonAdditionalInfo1 p : personalAdditionalInfo1)
				{
					this.persons.add(p.getPerson());
				}
			}
			else 
			{
				c = hs.createCriteria(Person.class)
					.add(Restrictions.like("nameFormatted", queryKey));
				t = hs.createCriteria(Person.class)
					.add(Restrictions.like("nameFormatted", queryKey));
							
				c.setFirstResult(pages.getFirstresult());
				c.setMaxResults(pages.getListscale());
				
				if (sortfield == null)
					sortfield = "registeredDate";
				
				if (this.sortsc.equals("desc")) {
					c.addOrder( Order.desc(this.sortfield) );
				}
				else {
					c.addOrder( Order.asc(this.sortfield) );			
				}
				this.persons = (List<Person>) c.list();
				
			}
			
			t.setProjection( Projections.rowCount() );	
			this.totalcount	=  ((Integer)t.list().get(0)).intValue();
	
			// paging
			pages.setTotalcount(this.totalcount);
			this.paging		= pages.getPaging();
			this.prepage	= pages.getPrepage();
			this.postpage	= pages.getPostpage();
			
			System.out.println("list" + paging.toString());
			System.out.println("prepage" + prepage);
			System.out.println("postpage" + postpage);
			
			if (this.gadgets != null && !this.gadgets.isEmpty())
				System.out.println("searched gadgets.size = " + gadgets.size());
			if (this.persons != null && !this.persons.isEmpty())
			{
				System.out.println("searched persons.size = " + persons.size());
				for (int i = 0; i < persons.size(); i++)
				{
					this.users.add(persons.get(i).getUser());
				}
			}
			
			//List cats = sess.createCriteria(Cat.class)
		    //.add( Restrictions.like("name", "Fritz%") )
		    //.add( Restrictions.between("weight", minWeight, maxWeight) )
		    //.list();
			
			if (tx != null)
				tx.commit();
								
			if ( searchfield.equals("gadget"))
				return "gadget";
			else if ( searchfield.equals("username"))
				return "user";
			else if ( searchfield.equals("tag"))
				return "user";
			else
				return "user";
			
//		}catch(Exception e)
//		{
//			if (tx != null)
//				tx.rollback();
//			
//			throw e;
//
//			
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
