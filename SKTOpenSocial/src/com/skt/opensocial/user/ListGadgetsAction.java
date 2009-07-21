/**
 * 
 */
package com.skt.opensocial.user;

import java.util.Collection;

import java.util.Map;

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
	
	Collection<Gadget> gadgets;
	
	int requestedPage = 1;
	String userId;
		
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Collection<Gadget> getGadgets() {
		return gadgets;
	}

	public void setGadgets(Collection<Gadget> gadgets) {
		this.gadgets = gadgets;
	}

	public String execute(){
		//
		User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
		
		userId = user.getUserId();
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		user = (User)hs.load(User.class, userId);
		System.out.println(" ---- UserListGadget :A " + user.getId());
		
		this.gadgets = user.getFavoriteGadgets();
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
		
		hs.getTransaction().commit();
		
				
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

}
