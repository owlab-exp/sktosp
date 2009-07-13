/**
 * 
 */
package com.skt.opensocial.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.util.IteratorGenerator.Converter;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.skt.opensocial.admin.AdministratorBaseAction;

import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.Person;
import com.skt.opensocial.persistence.User;

/**
 * @author Sejoon Oh
 *
 */
public class SearchGadgetAction extends AdministratorBaseAction {
	private static Logger logger = Logger.getLogger(SearchGadgetAction.class);

	private static final long serialVersionUID = 1L;

	Map<String, Object> session;
	List<Gadget> gadgets;

	String searchfield;
	String query;

	int pagescale	= 5;
	int currentpage	= 1;
	int totalcount	= 0;
	
	// paging
	Paging pages;
	List<Integer> paging;

	public String execute(){
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		String queryKey = "%" + query + "%";
		
		// paing
		pages	= new Paging(this.pagescale);
		
		System.out.println("searchfield, query, queryKey = " + searchfield + query + queryKey);

		Criteria c = hs.createCriteria(Gadget.class);
		Criteria t = hs.createCriteria(Gadget.class);

		if ( searchfield.equals("gadgetname")) {
			c.add(Restrictions.like("name", queryKey));
			t.add(Restrictions.like("name", queryKey));
		} else if ( searchfield.equals("gadgetstatus")) {
			String statuscode	= "";
			if (query.equals("등록완료")) {
				statuscode	= "rg";
			}
			else if (query.equals("발행요청")) {
				statuscode	= "pr";
			}
			else if (query.equals("발행완료")) {
				statuscode	= "pg";
			}
			else if (query.equals("발행거절")) {
				statuscode	= "pd";
			}
			else if (query.equals("미등록")) {
				statuscode	= "nr";
			}
			c.add(Restrictions.eq("status", statuscode));
			t.add(Restrictions.eq("status", statuscode));
		} else if ( searchfield.equals("developerid")) {
			c.add(Restrictions.like("developer.id", queryKey));
			t.add(Restrictions.like("developer.id", queryKey));
		}
		
		c.setFirstResult(this.currentpage * this.pagescale);
		System.out.println("setFirstResult" + this.currentpage * this.pagescale);

		c.setMaxResults(this.pagescale);
		c.addOrder( Order.desc("registerDate") );
		this.gadgets = c.list();

		// for total count
		t.setProjection( Projections.rowCount() );		
		this.totalcount	=  ((Integer)t.list().get(0)).intValue();
		System.out.println("total count = " + totalcount);

		// paging
		pages.setCurrentpage(this.currentpage);
		pages.setTotalcount(this.totalcount);
		
		this.paging	= pages.getPaging();
		System.out.println("list" + paging.toString());
		
		if (this.gadgets != null && !this.gadgets.isEmpty()) {
			System.out.println("searched gadgets.size = " + gadgets.size());
		}
		hs.getTransaction().commit();
		
		if ( searchfield.equals("gadgetname")) {
			return "gadgetname";
		} else if ( searchfield.equals("gadgetstatus")) {
			return "gadgetstatus";
		} else if ( searchfield.equals("developerid")) {
			return "developerid";
		} else {
			return "fail";
		}
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public List<Integer> getPaging() {
		return paging;
	}

	public void setPaging(List<Integer> paging) {
		this.paging = paging;
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

	public void setGadgets(List<Gadget> gadgets) {
		this.gadgets = gadgets;
	}

	public List<Gadget> getGadgets() {
		return gadgets;
	}

	public void setSession(Map<String, Object> map) {
		this.session = map;
	}

}
