/**
 * 
 */
package com.skt.opensocial.developer;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.skt.opensocial.common.GadgetCategoryList;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.HibernateUtil;

/**
 * @author Ernest Lee
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class PreviewGadgetAction extends ManageGadgetAction{
	
	
	public String execute(){
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		Gadget gadget = (Gadget)hs.load(Gadget.class, gadgetId);

		setGadgetId(gadget.getId());
		setGadgetStatus(gadget.getStatus());
		setGadgetName(gadget.getName());
		setRegisterType(gadget.getRegisterType());
		setGadgetSource(gadget.getSource());
		
		return Action.SUCCESS;
	}
}
