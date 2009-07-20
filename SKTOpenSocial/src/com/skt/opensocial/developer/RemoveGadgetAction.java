/**
 * 
 */
package com.skt.opensocial.developer;

import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetIcon;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**
 * @author Ernest Lee
 * 
 */
// public class ListGadgetsAction extends ActionSupport implements RequestAware
// {
public class RemoveGadgetAction extends DeveloperBaseAction {
	private Logger logger = Logger.getLogger(RemoveGadgetAction.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long gadgetId;
	private String gadgetName;

	private Map<String, Object> session;

	public String requestConfirm() {

		return "remove_confirm_page";
	}

	@Override
	public String execute() throws Exception {
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();

			Gadget gadget = (Gadget) hs.get(Gadget.class, gadgetId);

			if (gadget != null) {
				Set<User> favoriteUsers = gadget.getFavoriteUsers();
				for (User u : favoriteUsers) {
					u.removeFavoriteGadget(gadget);
					hs.update(u);
				}

				hs.delete(gadget);

			}
			tx.commit();
			return Action.SUCCESS;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

	}

	public Long getGadgetId() {
		return gadgetId;
	}

	public void setGadgetId(Long gadgetId) {
		this.gadgetId = gadgetId;
	}

	public String getGadgetName() {
		return gadgetName;
	}

	public void setGadgetName(String gadgetName) {
		this.gadgetName = gadgetName;
	}

}
