/**
 * 
 */
package com.skt.opensocial.user;

import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.developer.DeveloperBaseAction;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class SetFavoriteGadgetAction extends DeveloperBaseAction {
	private static Logger logger = Logger.getLogger(SetFavoriteGadgetAction.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//GadgetDataList gadgetDataList;
	//Map<String, GadgetData> gadgetMap;
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	Set<Gadget> gadgets;
	Long gadgetId;
	Gadget gadget;
	
	public Gadget getGadget() {
		return gadget;
	}

	public void setGadget(Gadget gadget) {
		this.gadget = gadget;
	}

	int requestedPage = 1;
	
	public Long getGadgetId() {
		return gadgetId;
	}

	public void setGadgetId(Long gadgetId) {
		this.gadgetId = gadgetId;
	}

	public String execute(){
		//
		User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
		
		String userId = user.getUserId();
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		user = (User)hs.load(User.class, userId);
		
		System.out.println("gadgetId = " + gadgetId);
		
		gadget = (Gadget) hs.load(Gadget.class, gadgetId);
		
		
		System.out.println("gadgetName " + gadget.getName());
		
		//this.gadgets = user.getFavoriteGadgets();
		
		// if (gadgets != null && !gadgets.isEmpty())
		//	System.out.println("Original size of gadgets = " + gadgets.size());
		
		user.addFavoriteGadget(gadget);
		
		hs.saveOrUpdate(user);
		
		//this.gadgets = user.getFavoriteGadgets();
		//if (gadgets != null && !gadgets.isEmpty())
		//	System.out.println("Added size of gadgets = " + gadgets.size());
		
		session.put(SKTOpenSocialSupportConstants.USER, user);
		
		
		//this.gadgets = this.gadgets.add(gadgetId);
		//logger.log(Level.INFO, "Number of gadgets = " + gadgets.size());
		
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
		
		return Action.SUCCESS;
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

	public Set<Gadget> getGadgets() {
		return gadgets;
	}

	public void setGadgets(Set<Gadget> gadgets) {
		this.gadgets = gadgets;
	}

	
	
}