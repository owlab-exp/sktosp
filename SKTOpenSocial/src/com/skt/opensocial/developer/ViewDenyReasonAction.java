/**
 * 
 */
package com.skt.opensocial.developer;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetPublish;
import com.skt.opensocial.persistence.HibernateUtil;

/**
 * @author Ernest Lee
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class ViewDenyReasonAction extends ManageGadgetAction{
	private String rejectReason = null;
	
	public String execute(){
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = hs.beginTransaction();
		
		Gadget gadget = (Gadget)hs.load(Gadget.class, getGadgetId());
		//GadgetPublish gp = gadget.get
		GadgetPublish gp = gadget.getGadgetPublish();
		if(gp != null)
			setRejectReason(gp.getRejectReason());
		else
			setRejectReason("사유가 없습니다.");

		tran.commit();
		return Action.SUCCESS;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	
	
}