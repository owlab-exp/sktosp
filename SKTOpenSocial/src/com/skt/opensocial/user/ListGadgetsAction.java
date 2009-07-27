/**
 * 
 */
package com.skt.opensocial.user;

import java.util.Collection;
import java.util.List;

import java.util.Map;

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
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class ListGadgetsAction extends DeveloperBaseAction {
	//private static Logger logger = Logger.getLogger(ListGadgetsAction.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//GadgetDataList gadgetDataList;
	//Map<String, GadgetData> gadgetMap;
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	
	List<Gadget> gadgets;
	
	int requestedPage = 1;
	String userId;
	
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
	String sortfield	= "name";
	String sortsc	= "desc";
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Gadget> getGadgets() {
		return gadgets;
	}

	public void setGadgets(List<Gadget> gadgets) {
		this.gadgets = gadgets;
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
		//
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try {
			tx = hs.beginTransaction();
		
			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
		
			userId = user.getUserId();
		
			user = (User)hs.load(User.class, userId);
			System.out.println(" ---- UserListGadget :A " + user.getId());
			
			// paing
			pages	= new Paging(pagescale, listscale);
			pages.setCurrentpage(this.currentpage);
									
			Criteria c = hs.createCriteria(Gadget.class)
				.createAlias("favoriteUsers", "user")
				.add(Restrictions.eq("user.id", userId));
			Criteria t = hs.createCriteria(Gadget.class)
				.createAlias("favoriteUsers", "user")
				.add(Restrictions.eq("user.id", userId));
		
			c.setFirstResult(pages.getFirstresult());
			c.setMaxResults(pages.getListscale());
			
			if (this.sortsc.equals("desc")) {
				c.addOrder( Order.desc(this.sortfield) );
			}
			else {
				c.addOrder( Order.asc(this.sortfield) );			
			}
			
			//this.gadgets = user.getFavoriteGadgets();
			this.gadgets = (List<Gadget>) c.list();
			
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
					
			if (gadgets != null)
			{	
				for (Gadget g: gadgets)
				{
					g.getId();
					g.getName();
					g.getDeveloper().getPerson().getName();
					g.getPublishDate();
					g.getFavoriteUsers().size();
					g.getIntroduction();
					
				}
			}
			
			System.out.println(" ---- UserListGadget :B " );
			if (gadgets == null)
				System.out.println("gadgets is null " );
			else
				System.out.println("The size of gadgets is : " + gadgets.size() );	
			//logger.log(Level.INFO, "Number of gadgets = " + gadgets.size());
			
			System.out.println(" ---- UserListGadget :C " );
			
			tx.commit();
								
			return Action.SUCCESS;
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
