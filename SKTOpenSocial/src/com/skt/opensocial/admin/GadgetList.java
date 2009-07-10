/**
 * 
 */
package com.skt.opensocial.admin;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.persistence.ActivityMediaItem;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**
 * @author Sejoon Oh
 *
 */
public class GadgetList extends AdministratorBaseAction {
	private static Logger logger = Logger.getLogger(GadgetList.class);

	private static final long serialVersionUID = 1L;

	Map<String, Object> session;
	Set<Gadget> gadgets;
	
	static int scale	= 10;
	int requestedPage = 1;
	int start	= 0;
	int totalcount	= 0;
	String searchfield	= "";
	String query	= "";
	
	public String execute(){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Criteria c = session.createCriteria(Gadget.class);
		c.addOrder( Order.desc("id") );
		//crit.addOrder( Property.forName("registerDate").desc() );
		if (!this.searchfield.isEmpty() && !this.query.isEmpty()) {
			c.add( Restrictions.like(this.searchfield, this.query) );
			System.out.println("searchfield: "+this.searchfield);
			System.out.println("query: "+this.query);
		}
			
		c.setFirstResult(this.start);
		c.setMaxResults(this.scale);

		c.addOrder( Order.desc("id") );
		
		//System.out.println("START: "+this.start);
		
		
		// all items
		List<Gadget> items	= (List<Gadget>)c.list();
		this.gadgets = new HashSet<Gadget>(items);

		
		// for total count
		c = session.createCriteria(Gadget.class);
		c.setProjection( Projections.projectionList()
				.add( Projections.rowCount(), "GadgetTotalCount" )
		);		
		this.totalcount	=  ((Integer)c.list().get(0)).intValue();
	
		/*		
		
for(Object item: items) {
	System.out.println("[["+item +"]]");
}
		for(Gadget item: items) {
			System.out.println("NAME: "+item.getName());
			System.out.println("INTRODUCTION: "+item.getIntroduction());
		}
*/
		/*
		// filer by an userId and an activityId
		crit = session.createCriteria(ActivityMediaItem.class);
		items = crit
		.add(Restrictions.eq("userId", userId))
		.add(Restrictions.eq("activityId", actId_1))
		.list();
		
		for(ActivityMediaItem item: items) {
			System.out.println("ACTIVITY_ID: "+item.getActivityId());
			System.out.println("USER_ID: "+item.getUserId());
		}
		*/
		tran.commit();
		//items.addAll(this.gadgets);

		/*
		
		
		
		User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
				
		String userId = user.getUserId();
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		user = (User)hs.load(User.class, userId);
		
		session.put(SKTOpenSocialSupportConstants.USER, user);
		
		this.gadgets = user.getAllgadgets();
		logger.log(Level.INFO, "Number of gadgets = " + gadgets.size());
		
		hs.getTransaction().commit();
		
		*/
		return "SUCCESS";
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

	public Set<Gadget> getGadgets() {
		return gadgets;
	}

	public void setGadgets(Set<Gadget> gadgets) {
		this.gadgets = gadgets;
	}
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}
}


/*
package com.skt.opensocial.admin;

import java.util.*;

public class GadgetList {
	
	private List<Gadget> gadgetlist;
	private String gadgetlistStr;
		
	public String execute() {
		List<Gadget> list	= new ArrayList<Gadget>();
		
		Gadget gadget	= new Gadget("가젯1", "이훈재");
		gadget.setCreatedDate("2009-06-03");
		gadget.setDesc("이훈재의 가젯입니다.");
		gadget.setNumRegUsers("10");
		gadget.setStatus("발행요청중");
		gadget.setNextstate("발행");
		list.add(gadget);

		gadget	= new Gadget("가젯2", "임성용");
		gadget.setCreatedDate("2009-05-01");
		gadget.setDesc("임성용의 가젯입니다.");
		gadget.setNumRegUsers("13");
		gadget.setStatus("활성");
		gadget.setNextstate("비활성");
		list.add(gadget);
		
		gadget	= new Gadget("가젯3", "오세준");
		gadget.setCreatedDate("2009-03-01");
		gadget.setDesc("오세준 가젯입니다.");
		gadget.setNumRegUsers("19");
		gadget.setStatus("비활성");
		gadget.setNextstate("활성");
		list.add(gadget);


		gadget	= new Gadget("가젯4", "김두리");
		gadget.setCreatedDate("2009-01-01");
		gadget.setDesc("김두리의 가젯입니다.");
		gadget.setNumRegUsers("29");
		gadget.setStatus("발행요청중");
		gadget.setNextstate("발행");
		list.add(gadget);

		setGadgetlist(list);
		setGadgetlistStr(list.toString());
				
		return "SUCCESS";
	}

	public List<Gadget> getGadgetlist() {
		return gadgetlist;
	}

	public void setGadgetlist(List<Gadget> gadgetlist) {
		this.gadgetlist = gadgetlist;
	}

	public String getGadgetlistStr() {
		return gadgetlistStr;
	}

	public void setGadgetlistStr(String gadgetlistStr) {
		this.gadgetlistStr = gadgetlistStr;
	}


	

}
*/