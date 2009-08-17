/**
 * 
 */
package com.skt.opensocial.admin;

import java.util.HashSet;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.GadgetStatusConstants;
import com.skt.opensocial.developer.ManageGadgetAction;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetCategory;
import com.skt.opensocial.persistence.GadgetPublish;
import com.skt.opensocial.persistence.HibernateUtil;

/**	관리자가 가젯 리스트에 있는 해당 가젯를 발행취소하는 액션 클래스
 * @author 	Sejoon Oh based on Ernest Lee's
 * @version 
 * @since	1.0
 * 
 */
public class CancelGadgetAction extends ManageGadgetAction {
	
	/** jsp페이지 로부터 넘겨 받은 발행 취소 가젯의 취소 사유
	 * 
	 */
	protected String rejectreason;

	/** 가젯의 ID를 받아 가젯을 상태를 발행취소상태로 변경시킴
	 * 
	 */
	public String execute() throws Exception{
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();
			
				
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
		
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}

	public String getRejectreason() {
		return rejectreason;
	}

	public void setRejectreason(String rejectreason) {
		this.rejectreason = rejectreason;
	}

}
