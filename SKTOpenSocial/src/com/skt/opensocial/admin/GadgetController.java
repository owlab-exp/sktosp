package com.skt.opensocial.admin;

import java.util.Map;

import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.developer.DeveloperBaseAction;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.HibernateUtil;

public class GadgetController extends AdministratorBaseAction {
	
	private static final long serialVersionUID = 1L;
	private Long gadgetId;
	private String gadgetName;
	private Map<String, Object> session;

    public String delete() {
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		Gadget gadget = (Gadget)hs.load(Gadget.class,gadgetId);
		
		hs.delete(gadget);
		
		hs.getTransaction().commit();
				
        return "SUCCESS";
    }

    public String changeStatus() {
        return "SUCCESS";
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
