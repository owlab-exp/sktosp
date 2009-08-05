/**
 * 
 */
package com.skt.opensocial.user;

import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.Person;
import com.skt.opensocial.persistence.User;

/**
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class SetFavoriteGadgetAction extends ActivityBaseManager {
	//private static Logger logger = Logger.getLogger(SetFavoriteGadgetAction.class);
	
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

	public String execute() throws Exception{
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try
		{
			//System.out.println("add activity - 1" );
			
			tx = hs.beginTransaction();
			
			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
			
			String userId = user.getUserId();
							
			user = (User)hs.load(User.class, userId);
			Person person = (Person) hs.load(Person.class, userId);
			
			System.out.println("gadgetId = " + gadgetId);
			
			gadget = (Gadget) hs.load(Gadget.class, gadgetId);
						
			System.out.println("gadgetName " + gadget.getName());
			
			//this.gadgets = user.getFavoriteGadgets();
			
			// if (gadgets != null && !gadgets.isEmpty())
			//	System.out.println("Original size of gadgets = " + gadgets.size());
			
			user.addFavoriteGadget(gadget);
			if (user.getFavoriteGadgets().size() > 0)
				person.setHasapp(true);
			
			hs.saveOrUpdate(person);
			hs.saveOrUpdate(user);
			
			//this.gadgets = user.getFavoriteGadgets();
			//if (gadgets != null && !gadgets.isEmpty())
			//	System.out.println("Added size of gadgets = " + gadgets.size());
			
			//session.put(SKTOpenSocialSupportConstants.USER, user);
						
			tx.commit();
			
			super.addActivity(ActivityTypeEnum.addFavoriteGadget, userId, "", gadgetId);
			
			return Action.SUCCESS;
			
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
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

}
