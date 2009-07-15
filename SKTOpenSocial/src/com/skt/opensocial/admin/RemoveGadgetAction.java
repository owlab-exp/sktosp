/**
 * 
 */
package com.skt.opensocial.admin;

import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetIcon;
import com.skt.opensocial.persistence.HibernateUtil;

/**
 * @author Ernest Lee
 * 
 */
// public class ListGadgetsAction extends ActionSupport implements RequestAware
// {
public class RemoveGadgetAction extends AdministratorBaseAction {
	private Logger logger = Logger.getLogger(RemoveGadgetAction.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long gadgetId;
	private String gadgetName;

	private Map<String, Object> session;

	public String requestConfirm(){
		
		return "remove_confirm_page";
	}
	public String execute() {
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();

		Gadget gadget = (Gadget) hs.get(Gadget.class, gadgetId);

		if (gadget != null)
			hs.delete(gadget);

		GadgetIcon icon = null;
		try {
			icon = (GadgetIcon) hs.get(GadgetIcon.class, gadgetId);
		} catch (HibernateException he) {
			logger.error(he.getMessage());
		}
		if (icon != null)
			hs.delete(icon);

		hs.getTransaction().commit();

		return Action.SUCCESS;
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
