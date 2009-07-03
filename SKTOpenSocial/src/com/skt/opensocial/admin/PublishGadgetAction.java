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
import com.skt.opensocial.persistence.HibernateUtil;

/**
 * @author Sejoon Oh
 *
 */
public class PublishGadgetAction extends ManageGadgetAction {
	
	private static final long serialVersionUID = 1L;
	private Long gadgetId;
	
	private Map<String, Object> session;
	
	public String execute(){
		prepare();
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		Gadget gadget = (Gadget) hs.load(Gadget.class, gadgetId);
		gadget.setName(getGadgetName());
		
		gadget.setIconUrl(getGadgetIconUrl());
		gadget.setIntroduction(getGadgetIntro());
		gadget.setSource(getGadgetSource());
		gadget.setRegisterDate(null);
		gadget.setStatus(GadgetStatusConstants.PUBLISHED);
		gadget.setRegisterType(getRegisterType());		
		
		hs.saveOrUpdate(gadget);
		hs.getTransaction().commit();

		
		return "SUCCESS";
	}

}
