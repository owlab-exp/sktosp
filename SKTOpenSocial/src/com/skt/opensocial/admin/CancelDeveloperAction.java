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
import com.skt.opensocial.developer.DeveloperBaseAction;
import com.skt.opensocial.developer.ManageGadgetAction;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetCategory;
import com.skt.opensocial.persistence.GadgetPublish;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**	관리자가 개발자 리스트에 있는 해당 개발자를 삭제하는 액션 클래스
 * @author 	Sejoon Oh based on Ernest Lee's
 * @version 
 * @since	1.0
 * 
 */
public class CancelDeveloperAction extends DeveloperBaseAction {
	

	/** jsp페이지 로부터 넘겨 받은 삭제 대상 개발자의 ID
	 * 
	 */
	private String developerId;
	private User developer;

	/** 개발자의 ID를 받아 개발자 flag를 false로 변경시킴
	 * 
	 */	
	public String execute() throws Exception{
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();
			
			developer = (User)hs.load(User.class, developerId);
	
		    System.out.println("developerId--->" + developerId);
	
		    developer.setIsDeveloper(false);
	
			hs.saveOrUpdate(developer);
			hs.getTransaction().commit();
	
			System.out.println("Update successfully!");
	
			return "SUCCESS";
			
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}

	public String getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(String developerId) {
		this.developerId = developerId;
	}

}
