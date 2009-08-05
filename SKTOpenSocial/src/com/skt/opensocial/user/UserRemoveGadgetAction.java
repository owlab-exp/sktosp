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

import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.Person;
import com.skt.opensocial.persistence.User;

/**
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class UserRemoveGadgetAction extends ActivityBaseManager {
	private static Logger logger = Logger.getLogger(UserRemoveGadgetAction.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//GadgetDataList gadgetDataList;
	//Map<String, GadgetData> gadgetMap;
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	Set<Gadget> gadgets;
	Gadget gadget = null;
	
	int requestedPage = 1;
	private Long gadgetId;
	
	public Long getGadgetId() {
		return gadgetId;
	}

	public void setGadgetId(Long gadgetId) {
		this.gadgetId = gadgetId;
	}
	public String requestConfirm() throws Exception{
		//
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx = null;
		
		try
		{
			tx = hs.beginTransaction();
			
			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
		
			String userId = user.getUserId();
							
			user = (User)hs.load(User.class, userId);
							
			Gadget gadget = (Gadget)hs.load(Gadget.class,gadgetId);
			gadget.getName();
//			this.gadgets = user.getFavoriteGadgets();
//			logger.log(Level.INFO, "Number of gadgets = " + gadgets.size());
//			
//			user.removeFavoriteGadget(gadget);
//			
//			this.gadgets = user.getFavoriteGadgets();
//			logger.log(Level.INFO, "Number of gadgets = " + gadgets.size());
//			
//			if (gadgets.size() == 0)
//			{
//				Person person = (Person) hs.load(Person.class, userId);
//				person.setHasapp(false);
//				hs.saveOrUpdate(person);
//			}
//			hs.saveOrUpdate(user);
			
			//this.gadgets = user.getFavoriteGadgets();
			//if (gadgets != null && !gadgets.isEmpty())
			//	System.out.println("Added size of gadgets = " + gadgets.size());
			
			//session.put(SKTOpenSocialSupportConstants.USER, user);
			tx.commit();
			
			super.addActivity(ActivityTypeEnum.removeFavoriteGadget, userId, "", gadgetId);
						
			return "remove_confirm_page";
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}
	public String execute() throws Exception{
		//
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx = null;
		
		try
		{
			tx = hs.beginTransaction();
			
			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
		
			String userId = user.getUserId();
							
			user = (User)hs.load(User.class, userId);
							
			Gadget gadget = (Gadget)hs.load(Gadget.class,gadgetId);
			
			this.gadgets = user.getFavoriteGadgets();
			logger.log(Level.INFO, "Number of gadgets = " + gadgets.size());
			
			user.removeFavoriteGadget(gadget);
			
			this.gadgets = user.getFavoriteGadgets();
			logger.log(Level.INFO, "Number of gadgets = " + gadgets.size());
			
			if (gadgets.size() == 0)
			{
				Person person = (Person) hs.load(Person.class, userId);
				person.setHasapp(false);
				hs.saveOrUpdate(person);
			}
			hs.saveOrUpdate(user);
			
			//this.gadgets = user.getFavoriteGadgets();
			//if (gadgets != null && !gadgets.isEmpty())
			//	System.out.println("Added size of gadgets = " + gadgets.size());
			
			//session.put(SKTOpenSocialSupportConstants.USER, user);
			tx.commit();
			
			super.addActivity(ActivityTypeEnum.removeFavoriteGadget, userId, "", gadgetId);
						
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
