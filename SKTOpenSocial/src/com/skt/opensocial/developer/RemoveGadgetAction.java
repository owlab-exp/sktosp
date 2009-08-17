/**
 * 
 */
package com.skt.opensocial.developer;

import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetIcon;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**
 * 가젯을 시스템에서 제거하기 위한 액션 클래스
 * @author Ernest Lee
 * 
 */
// public class ListGadgetsAction extends ActionSupport implements RequestAware
// {
public class RemoveGadgetAction extends DeveloperBaseAction {
	private Logger logger = Logger.getLogger(RemoveGadgetAction.class);

	/**
	 * 
	 */
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
	 * 가젯을 정말로 제거할 지 확인하는 메소드
	 * @return 가젯 제거 확인을 위한 페이지
	 */
	public String requestConfirm() {

		return "remove_confirm_page";
	}

	/**
	 * 주어진 가젯 ID에 해당하는 가젯을 시스템에서 삭제한다.
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();

			Gadget gadget = (Gadget) hs.get(Gadget.class, gadgetId);

			if (gadget != null) {
				Set<User> favoriteUsers = gadget.getFavoriteUsers();
				for (User user : favoriteUsers) {
					user.removeFavoriteGadget(gadget);
					hs.update(user);
				}

				hs.delete(gadget);

			}
			tx.commit();
			return Action.SUCCESS;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
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
