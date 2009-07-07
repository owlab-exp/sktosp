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
	

	public String execute(){
		//prepare();
	    //try {
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		Gadget gadget = (Gadget) hs.load(Gadget.class, gadgetId);
	    System.out.println("gadgetID--->" + gadgetId);

		//gadget.setName(getGadgetName());
		
		gadget.setStatus(GadgetStatusConstants.PUBLISHED);
		
		hs.update(gadget);
		hs.getTransaction().commit();

		System.out.println("Update successfully!");
	    //}
	    //catch(Exception e){
	    //  System.out.println(e.getMessage());
	    //}
		return "SUCCESS";
	}

}