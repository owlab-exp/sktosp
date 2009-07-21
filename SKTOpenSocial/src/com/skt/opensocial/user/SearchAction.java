/**
 * 
 */
package com.skt.opensocial.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
	
	int requestedPage = 1;
	
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
			
			if ( searchfield.equals("gadget"))
				this.gadgets = (List<Gadget>) hs.createCriteria(Gadget.class)
					.add(Restrictions.like("name", queryKey))
					.add(Restrictions.eq("status", "pg"))
					.list();
			else if ( searchfield.equals("username"))
				this.persons = (List<Person>) hs.createCriteria(Person.class)
					.add(Restrictions.like("nameFormatted", queryKey))
					.list();
			else if ( searchfield.equals("tag"))
			{
				this.personalAdditionalInfo1 = 
					(List<PersonAdditionalInfo1>)hs.createCriteria(PersonAdditionalInfo1.class)
					.add(Restrictions.eq("attribute", Info1AttributeEnum.tags))
					.add(Restrictions.like("value", queryKey))
					.list();
				
				for (PersonAdditionalInfo1 p : personalAdditionalInfo1)
				{
					this.persons.add(p.getPerson());
				}
			}
			else 
			{
				this.persons = (List<Person>) hs.createCriteria(Person.class)
					.add(Restrictions.like("nameFormatted", queryKey))
					.list();
			}

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
