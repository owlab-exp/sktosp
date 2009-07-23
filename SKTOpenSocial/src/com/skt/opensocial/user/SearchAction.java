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
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	List<Gadget> gadgets;
	List<User> users = new ArrayList<User>();
	List<Person> persons = new ArrayList<Person>();
	List<PersonAdditionalInfo1> personalAdditionalInfo1;
	String searchfield;
	String query;

	//User user;
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
	String sortfield	= null;
	String sortsc	= "desc";
	
	int requestedPage = 1;
	
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSearchfield() {
		return searchfield;
	}

	public void setSearchfield(String searchfield) {
		this.searchfield = searchfield;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}


	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void setGadgets(List<Gadget> gadgets) {
		this.gadgets = gadgets;
	}

	public List<Gadget> getGadgets() {
		return gadgets;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public List<PersonAdditionalInfo1> getPersonalAdditionalInfo1() {
		return personalAdditionalInfo1;
	}

	public void setPersonalAdditionalInfo1(
			List<PersonAdditionalInfo1> personalAdditionalInfo1) {
		this.personalAdditionalInfo1 = personalAdditionalInfo1;
	}

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
				
				if (sortfield == null)
					sortfield = "registeredDate";
				
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
