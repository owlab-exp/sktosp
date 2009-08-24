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

/**	관리자가 가젯의 발행을 허가하는 액션 클래스
 * @author 	Sejoon Oh based on Ernest Lee's
 * @version 
 * @since	1.0
 * 
 */
public class PublishGadgetAction extends ManageGadgetAction {
	
	/** 가젯의 ID를 받아 해당가젯의 상태를 발행요청에서 발행상태로 변경시킴
	 * 
	 */
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
