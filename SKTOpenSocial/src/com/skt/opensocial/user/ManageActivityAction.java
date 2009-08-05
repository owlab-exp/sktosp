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
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class ManageActivityAction extends DeveloperBaseAction {
	private static Logger logger = Logger.getLogger(ManageFriendAction.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//GadgetDataList gadgetDataList;
	//Map<String, GadgetData> gadgetMap;
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	List<Activity> activities = null;
	
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
	String sortfield	= "updated";
	String sortsc	= "desc";

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

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

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
