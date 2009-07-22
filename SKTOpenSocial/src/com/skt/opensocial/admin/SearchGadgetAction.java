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
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.Action;
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

	String searchfield	= "";
	String query	= "";
	String sortfield	= "registerDate";
	String sortsc	= "desc";
	
	int listscale	= 10;
	int pagescale	= 10;
	int currentpage	= 1;
	int totalcount	= 0;
	
	
	// paging
	Paging pages;
	List<Integer> paging;
	int prepage	= 0;
	int postpage	= 0;

	public String execute() throws Exception{
		
		if (searchfield.length() > 0 && query.length() == 0) {
			return "list";
		}
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();

			
			String queryKey = "%" + query + "%";
			
			// paing
			pages	= new Paging(pagescale, listscale);
			pages.setCurrentpage(this.currentpage);
			
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
			} else {
				//
			}
			
			c.setFirstResult(pages.getFirstresult());
			c.setMaxResults(pages.getListscale());
			if (this.sortsc.equals("desc")) {
				c.addOrder( Order.desc(this.sortfield) );
			}
			else {
				c.addOrder( Order.asc(this.sortfield) );			
			}
			this.gadgets = c.list();
	
			// for total count
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
				return "list";
			}
			
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
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

}
