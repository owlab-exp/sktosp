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
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class ManageFriendAction extends DeveloperBaseAction {
	private static Logger logger = Logger.getLogger(ManageFriendAction.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//GadgetDataList gadgetDataList;
	//Map<String, GadgetData> gadgetMap;
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	List<User> friends;
	
	int requestedPage = 1;
	
	// paging
	Paging pages;
	List<Integer> paging;
	int prepage	= 0;
	int postpage	= 0;
	int listscale	= 10;
	int pagescale	= 10;
	int currentpage	= 1;
	int totalcount	= 0;
	
	// sorting
	String sortfield	= "registeredDate";
	String sortsc	= "desc";

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public List<Integer> getPaging() {
		return paging;
	}

	public void setPaging(List<Integer> paging) {
		this.paging = paging;
	}

	public int getPrepage() {
		return prepage;
	}

	public void setPrepage(int prepage) {
		this.prepage = prepage;
	}

	public int getPostpage() {
		return postpage;
	}

	public void setPostpage(int postpage) {
		this.postpage = postpage;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public int getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}

	public String getSortfield() {
		return sortfield;
	}

	public void setSortfield(String sortfield) {
		this.sortfield = sortfield;
	}

	public String getSortsc() {
		return sortsc;
	}

	public void setSortsc(String sortsc) {
		this.sortsc = sortsc;
	}

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
				.createAlias("user.friendsByMe", "fm",CriteriaSpecification.LEFT_JOIN)
				.createAlias("user.friendsByOther", "fo",CriteriaSpecification.LEFT_JOIN)
				.add(Restrictions.or(Restrictions.eq("fm.id", userId),Restrictions.eq("fo.id", userId)));
			Criteria crit2 = hs.createCriteria(User.class, "user")
				.createAlias("user.friendsByMe", "fm",CriteriaSpecification.LEFT_JOIN)
				.createAlias("user.friendsByOther", "fo",CriteriaSpecification.LEFT_JOIN)
				.add(Restrictions.or(Restrictions.eq("fm.id", userId),Restrictions.eq("fo.id", userId)));
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
	
	class RegisteredDateDescendingComparator implements Comparator<User> 
	{
		public int compare(User o1, User o2) 
		{
		
			return ((User)o1).getRegisteredDate().before(((User)o2).getRegisteredDate()) ? -1 
		    		: ( ((User)o1).getRegisteredDate().after(((User)o2).getRegisteredDate()) ? 1 : 0); // descending 정렬.....
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
