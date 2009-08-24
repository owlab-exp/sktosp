/**
 * 
 */
package com.skt.opensocial.developer;

import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.GadgetStatusConstants;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetPublish;
import com.skt.opensocial.persistence.HibernateUtil;

/**
 * 가젯 발행요청을 처리하는 액션 클래스
 * @author Ernest Lee
 * 
 */
// public class ListGadgetsAction extends ActionSupport implements RequestAware
// {
public class PublishRequestAction extends DeveloperBaseAction {
	private Logger logger = Logger.getLogger(PublishRequestAction.class);

	private static final long serialVersionUID = 1L;
	/**
	 * 가젯 ID
	 */
	private Long gadgetId;
	/**
	 * 가젯 이름
	 */
	private String gadgetName;

	private Map<String, Object> session;

	/**
	 * 발행확인을 위한 웹 페이지를 리턴한다.
	 * @return 발행확인을 위한 웹 페이지
	 */
	public String publishConfirm(){
		
		return "publish_confirm_page";
	}
	/** 
	 * 특정 가젯 ID에 대해 가젯 상태를 발행요청으로 바꾼다.
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();
		

		Gadget gadget = (Gadget) hs.get(Gadget.class, gadgetId);
		
		GadgetPublish gp = gadget.getGadgetPublish();
		if(gp == null) {
			gp = new GadgetPublish();
			gp.setGadget(gadget);
		}
		gp.setRequestedDate(new Date());
		gadget.setStatus(GadgetStatusConstants.PUBLISH_REQUESTED);
		
		hs.saveOrUpdate(gadget);
		hs.saveOrUpdate(gp);
		hs.getTransaction().commit();

		return Action.SUCCESS;
		}catch(Exception e){
			if(tx != null) tx.rollback();
			throw e;
		}
	}

	/**
	 * 가젯 ID를 가져온다
	 * @return 가젯 ID
	 */
	public Long getGadgetId() {
		return gadgetId;
	}

	/**
	 * 가젯 ID를 셋팅한다
	 * @param gadgetId 가젯 ID
	 */
	public void setGadgetId(Long gadgetId) {
		this.gadgetId = gadgetId;
	}

	/**
	 * 가젯 이름을 가져온다
	 * @return 가젯 이름
	 */
	public String getGadgetName() {
		return gadgetName;
	}

	/**
	 * 가젯 이름을 셋팅한다
	 * @param gadgetName 가젯 이름
	 */
	public void setGadgetName(String gadgetName) {
		this.gadgetName = gadgetName;
	}

}
