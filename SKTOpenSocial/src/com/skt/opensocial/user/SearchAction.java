/**
 * 
 */
package com.skt.opensocial.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.skt.opensocial.developer.DeveloperBaseAction;

import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.Person;
import com.skt.opensocial.persistence.User;

/**
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class SearchAction extends DeveloperBaseAction {
	private static Logger logger = Logger.getLogger(SearchAction.class);
	
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
	List<Person> persons;
	String searchfield;
	String query;

	
	int requestedPage = 1;
	
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

	public String execute(){
		//
		//Anonymous anony = (Anonymous)session.get(SKTOpenSocialSupportConstants.ANONYMOUS);
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		
		
		//session.put(SKTOpenSocialSupportConstants.ANONYMOUS, anony);
		
		//this.gadgets = Anonymous.getGadgets(searchfield);
		
		// logger.log(Level.INFO, "Number of gadgets = " + gadgets.size());
		
		String queryKey = "%" + query + "%";
		
		System.out.println("searchfield, query, queryKey = " + searchfield + query + queryKey);
		
		if ( searchfield.equals("gadget"))
			this.gadgets = (List<Gadget>) hs.createCriteria(Gadget.class)
				.add(Restrictions.like("name", queryKey))
				.add(Restrictions.isNotNull("publishDate"))
				.add(Restrictions.eq("status", "pb"))
				.list();
		else if ( searchfield.equals("username"))
			this.persons = (List<Person>) hs.createCriteria(Person.class)
				.add(Restrictions.like("nameFormatted", queryKey))
				.list();
		
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
		
		
		hs.getTransaction().commit();
		
		//
		/*GadgetDataList gadgetDataListS = (GadgetDataList)session.get("gadgets");
		if(gadgetDataList == null) {
			session.put("gadgets", new GadgetDataList());
			this.gadgetDataList = (GadgetDataList)session.get("gadgets");
		} else {
			this.gadgetDataList = gadgetDataListS;
		}
		gadgetMap = this.gadgetDataList.getGadgetMap();
		gadgetList = gadgetMap.values();
		
		System.out.println("list count = " + gadgetDataList.getGadgetMap().size());
		*/
		if ( searchfield.equals("gadget"))
			return "gadget";
		else if ( searchfield.equals("username"))
			return "user";
		else
			return "fail";
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.RequestAware#setRequest(java.util.Map)
	 */
	/*@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		//this.request = request;

	}*/

	
	
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}

//	public GadgetDataList getGadgetDataList() {
//		return gadgetDataList;
//	}
//
//	public void setGadgetDataList(GadgetDataList gadgetDataList) {
//		this.gadgetDataList = gadgetDataList;
//	}
//
//	public Map<String, GadgetData> getGadgetMap() {
//		return gadgetMap;
//	}
//
//	public void setGadgetMap(Map<String, GadgetData> gadgetMap) {
//		this.gadgetMap = gadgetMap;
//	}
//
//	public Collection<GadgetData> getGadgetList() {
//		return gadgetList;
//	}
//
//	public void setGadgetList(Collection<GadgetData> gadgetList) {
//		this.gadgetList = gadgetList;
//	}

	public int getRequestedPage() {
		return requestedPage;
	}

	public void setRequestedPage(int requestedPage) {
		this.requestedPage = requestedPage;
	}

	
}
