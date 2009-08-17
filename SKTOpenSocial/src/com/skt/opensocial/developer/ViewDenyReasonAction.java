/**
 * 
 */
package com.skt.opensocial.developer;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetPublish;
import com.skt.opensocial.persistence.HibernateUtil;

/**
 * 가젯 발행요청이 거절된 사유를 보기 위한 액션 클래스
 * @author Ernest Lee
 * 
 */
// public class ListGadgetsAction extends ActionSupport implements RequestAware
// {
public class ViewDenyReasonAction extends ManageGadgetAction {
	/**
	 * 거절 사유
	 */
	private String rejectReason = null;

	/**
	 * 가젯이 발행거절된 사유를 보기 위한 액션 메소드
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception{
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			tx = hs.beginTransaction();

			Gadget gadget = (Gadget) hs.load(Gadget.class, getGadgetId());
			// GadgetPublish gp = gadget.get
			GadgetPublish gp = gadget.getGadgetPublish();
			if (gp != null)
				setRejectReason(gp.getRejectReason());
			else
				setRejectReason("사유가 없습니다.");

			tx.commit();
			return Action.SUCCESS;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}

	/**
	 * 거절사유를 가져온다
	 * @return 거절사유
	 */
	public String getRejectReason() {
		return rejectReason;
	}

	/**
	 * 거절사유를 셋팅한다. (페이지에서 볼 수 있도록)
	 * @param rejectReason 거절사유
	 */
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

}
