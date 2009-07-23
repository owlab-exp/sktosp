/**
 * 
 */
package com.skt.opensocial.admin;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
	

	public String execute() throws Exception{
		//prepare();
	    //try {
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();
			
			Gadget gadget = (Gadget) hs.load(Gadget.class, gadgetId);
		    System.out.println("gadgetID--->" + gadgetId);
	
			//gadget.setName(getGadgetName());
			
			gadget.setStatus(GadgetStatusConstants.PUBLISHED);
			gadget.setPublishDate(new Date());
			
			hs.update(gadget);
			hs.getTransaction().commit();
	
			System.out.println("Update successfully!");
		    //}
		    //catch(Exception e){
		    //  System.out.println(e.getMessage());
		    //}
			return "SUCCESS";
		
		
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}

}
