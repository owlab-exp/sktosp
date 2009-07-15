/**
 * 
 */
package com.skt.opensocial.admin;

import java.util.HashSet;
import java.util.Map;

import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.GadgetStatusConstants;
import com.skt.opensocial.developer.ManageGadgetAction;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetCategory;
import com.skt.opensocial.persistence.GadgetPublish;
import com.skt.opensocial.persistence.HibernateUtil;

/**
 * @author Sejoon Oh
 *
 */
public class CancelGadgetAction extends ManageGadgetAction {
	
	protected String rejectreason;

	public String execute(){
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		Gadget gadget = (Gadget) hs.load(Gadget.class, gadgetId);
	    System.out.println("gadgetID--->" + gadgetId);

		gadget.setStatus(GadgetStatusConstants.PUBLISH_DENIED);

		// input rejectReason
		System.out.println("rejectreason" + rejectreason);
		gadget.getGadgetPublish().setRejectReason(rejectreason);
		gadget.getGadgetPublish().setApprove(false);
		
		hs.saveOrUpdate(gadget);
		hs.getTransaction().commit();

		System.out.println("Update successfully!");

		return "SUCCESS";
	}

	public String getRejectreason() {
		return rejectreason;
	}

	public void setRejectreason(String rejectreason) {
		this.rejectreason = rejectreason;
	}

}
