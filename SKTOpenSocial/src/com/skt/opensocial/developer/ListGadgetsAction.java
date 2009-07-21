/**
 * 
 */
package com.skt.opensocial.developer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
public class ListGadgetsAction extends DeveloperBaseAction implements Pagenation{
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
	

	// properties for pagenation
	private int listSize = 9; // the size of gadget list
	private int requestedPage = 1;
	private int maxPage = 1;
	
	private int startPage = 1;
	private int pageListSizeMax = 10;

	private List<Integer> pageList = new ArrayList<Integer>();
	// end for pagenation
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			User user = (User) session.get(SKTOpenSocialSupportConstants.USER);

			String userId = user.getUserId();

			
			tx = hs.beginTransaction();

			logger.info("User ID=" + userId);
			user = (User) hs.load(User.class, userId);

			session.put(SKTOpenSocialSupportConstants.USER, user);
			
			Criteria crit = hs.createCriteria(Gadget.class);
			crit.add(Restrictions.eq("developer.id", userId));
			
			// to determine maximum possible pages
			int totalGadgetSize = crit.list().size();
			if(listSize > 0)
				maxPage = (int)Math.ceil((double)totalGadgetSize /listSize);
			

			// to determine the list of pages to be shown below the data table
			startPage = (requestedPage - (requestedPage%pageListSizeMax))+ 1; //1, 11, 21, ...
			for(int i = startPage, j = 1 ; j <= pageListSizeMax; i++, j++){
				if(i > maxPage)
					break;
				pageList.add(new Integer(i));
			}
			
			// make order before selection
			crit.addOrder(Order.desc("id"));
			
			// to determine result set
			if (requestedPage > 0){ 
				crit.setFirstResult((requestedPage - 1)*listSize);
			} else if (requestedPage <= 0){
				crit.setFirstResult(0);
				requestedPage = 1;
			} else if(requestedPage >= maxPage){
				crit.setFirstResult((maxPage -1)*listSize);
			}
			
			// fetch data
			crit.setMaxResults(listSize);
			gadgetList = (List<Gadget>)crit.list();
			
			
//			for(Gadget gadget : gadgetList){
//				//?? to fill data
//				//gadget.getDeveloper().getPerson();
//				logger.info(gadget.getFavoriteUsers());
//			}

			logger.info("Number of gadgets of this page = " + gadgetList.size());

			tx.commit();
			return Action.SUCCESS;
		} catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			throw e;
		}

		
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

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public List<Integer> getPageList() {
		return pageList;
	}

	public void setPageList(List<Integer> pageList) {
		this.pageList = pageList;
	}

}
