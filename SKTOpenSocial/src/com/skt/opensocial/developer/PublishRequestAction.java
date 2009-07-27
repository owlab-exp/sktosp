/**
 * 
 */
package com.skt.opensocial.developer;

import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.GadgetStatusConstants;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetPublish;
import com.skt.opensocial.persistence.HibernateUtil;

/**
 * @author Ernest Lee
 * 
 */
// public class ListGadgetsAction extends ActionSupport implements RequestAware
// {
public class PublishRequestAction extends DeveloperBaseAction {
	private Logger logger = Logger.getLogger(PublishRequestAction.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long gadgetId;
	private String gadgetName;

	private Map<String, Object> session;

	public String publishConfirm(){
		
		return "publish_confirm_page";
	}
	public String execute() throws Exception {
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();
		

		Gadget gadget = (Gadget) hs.get(Gadget.class, gadgetId);
		
		GadgetPublish gp = gadget.getGadgetPublish();
		if(gp == null) {
			gp = new GadgetPublish();
			gp.setGadget(gadget);
		}
		gp.setRequestedDate(new Date());
		gadget.setStatus(GadgetStatusConstants.PUBLISH_REQUESTED);
		
		hs.saveOrUpdate(gadget);
		hs.saveOrUpdate(gp);
		hs.getTransaction().commit();

		return Action.SUCCESS;
		}catch(Exception e){
			if(tx != null) tx.rollback();
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
