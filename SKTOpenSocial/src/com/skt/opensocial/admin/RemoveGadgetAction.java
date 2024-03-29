/**
 * 
 */
package com.skt.opensocial.admin;

import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetIcon;
import com.skt.opensocial.persistence.HibernateUtil;

/**	관리자가 가젯을 삭제하는 액션 클래스
 * @author 	Sejoon Oh based on Ernest Lee's
 * @version 
 * @since	1.0
 * 
 */
// public class ListGadgetsAction extends ActionSupport implements RequestAware
// {
public class RemoveGadgetAction extends AdministratorBaseAction {
	private Logger logger = Logger.getLogger(RemoveGadgetAction.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** jsp페이지 로부터 넘겨 받은 삭제 대상 가젯의 ID
	 * 
	 */	
	private Long gadgetId;
	private String gadgetName;
	
	// 삭제후 폼 전송을 위해
	private String searchfield;
	private String query;
	private int currentpage;	

	private Map<String, Object> session;

	public String requestConfirm(){
		
		return "remove_confirm_page";
	}
	
	/** 가젯의 ID를 받아 해당가젯을 삭제함
	 * 
	 */
	public String execute() throws Exception{
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();
			
			Gadget gadget = (Gadget) hs.get(Gadget.class, gadgetId);
	
			if (gadget != null)
				hs.delete(gadget);
	
			GadgetIcon icon = null;
			try {
				icon = (GadgetIcon) hs.get(GadgetIcon.class, gadgetId);
			} catch (HibernateException he) {
				logger.error(he.getMessage());
			}
			if (icon != null)
				hs.delete(icon);
	
			hs.getTransaction().commit();
	
			return Action.SUCCESS;
			
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
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
	public String getSearchfield() {
		return searchfield;
	}
	public void setSearchfield(String searchfield) {
		this.searchfield = searchfield;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

}
