/**
 * 
 */
package com.skt.opensocial.developer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**
 * @author Ernest Lee
 * 
 */
// public class ListGadgetsAction extends ActionSupport implements RequestAware
// {
public class ListGadgetsAction extends DeveloperBaseAction {
	private static Logger logger = Logger.getLogger(ListGadgetsAction.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// GadgetDataList gadgetDataList;
	// Map<String, GadgetData> gadgetMap;
	private Map<String, Object> session;
	// Collection<GadgetData> gadgetList;
	// Set<Gadget> gadgets;
	private List<Gadget> gadgetList;

	private int pageSize = 5;
	private int currentPage = 1;

	int requestedPage = 1;

	public String execute() {
		try {
			User user = (User) session.get(SKTOpenSocialSupportConstants.USER);

			String userId = user.getUserId();

			Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tran = hs.beginTransaction();

			logger.log(Level.INFO, "User ID=" + userId);
			user = (User) hs.load(User.class, userId);

			session.put(SKTOpenSocialSupportConstants.USER, user);

			Set<Gadget> gadgets = user.getGadgets();

			gadgetList = new ArrayList<Gadget>();
			gadgetList.addAll(gadgets);

			// Criteria crit = hs.createCriteria(Gadget.class);
			// crit.add(Restrictions.eq("developer.id", user.getId()));
			// crit.addOrder(Order.desc("id"));
			// //crit.setFirstResult((currentPage-1)*pageSize);
			// crit.setMaxResults(pageSize);
			// gadgetList = crit.list();

			logger.log(Level.INFO, "Number of gadgets = " + gadgetList.size());

			tran.commit();

			
		} catch (Exception e) {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return Action.SUCCESS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts2.interceptor.RequestAware#setRequest(java.util.Map)
	 */
	/*
	 * @Override public void setRequest(Map<String, Object> request) { // TODO
	 * Auto-generated method stub //this.request = request;
	 * 
	 * }
	 */

	public void setSession(Map<String, Object> map) {
		this.session = map;
	}

	// public GadgetDataList getGadgetDataList() {
	// return gadgetDataList;
	// }
	//
	// public void setGadgetDataList(GadgetDataList gadgetDataList) {
	// this.gadgetDataList = gadgetDataList;
	// }
	//
	// public Map<String, GadgetData> getGadgetMap() {
	// return gadgetMap;
	// }
	//
	// public void setGadgetMap(Map<String, GadgetData> gadgetMap) {
	// this.gadgetMap = gadgetMap;
	// }
	//
	// public Collection<GadgetData> getGadgetList() {
	// return gadgetList;
	// }
	//
	// public void setGadgetList(Collection<GadgetData> gadgetList) {
	// this.gadgetList = gadgetList;
	// }

	public int getRequestedPage() {
		return requestedPage;
	}

	public void setRequestedPage(int requestedPage) {
		this.requestedPage = requestedPage;
	}

	// public Set<Gadget> getGadgets() {
	// return gadgets;
	// }
	//
	// public void setGadgets(Set<Gadget> gadgets) {
	// this.gadgets = gadgets;
	// }

	public List<Gadget> getGadgetList() {
		return gadgetList;
	}

	public void setGadgetList(List<Gadget> gadgetList) {
		this.gadgetList = gadgetList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
