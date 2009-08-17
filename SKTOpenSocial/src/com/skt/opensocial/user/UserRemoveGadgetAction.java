/**
 * 
 */
package com.skt.opensocial.user;

import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;

import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.Person;
import com.skt.opensocial.persistence.User;

/**
 * 사용자가 자신의 선호가젯 모음에서 특정 가젯을 삭제하는 경우에 사용되는 액션 클래스
 * @author Seong Yong Lim based on Ernest Lee's
 */
public class UserRemoveGadgetAction extends ActivityBaseManager {
	private static Logger logger = Logger.getLogger(UserRemoveGadgetAction.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Map<String, Object> session;

	/**
	 * 가젯 셋
	 */
	Set<Gadget> gadgets;
	/**
	 * 가젯
	 */
	Gadget gadget = null;
	
	/**
	 * 요청된 페이지
	 */
	int requestedPage = 1;
	/**
	 * 가젯 ID
	 */
	private Long gadgetId;
	
	/* (non-Javadoc)
	 * @see com.skt.opensocial.developer.ManageGadgetAction#getGadgetId()
	 */
	public Long getGadgetId() {
		return gadgetId;
	}

	/* (non-Javadoc)
	 * @see com.skt.opensocial.developer.ManageGadgetAction#setGadgetId(java.lang.Long)
	 */
	public void setGadgetId(Long gadgetId) {
		this.gadgetId = gadgetId;
	}
	/**
	 * 가젯 삭제 요청을 받아 가제 삭제 확인 페이지를 웹 브라우저에 전달한다
	 * @return 가젯 삭제 확인 페이지
	 * @throws Exception
	 */
	public String requestConfirm() throws Exception{
		//
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx = null;
		
		try
		{
			tx = hs.beginTransaction();
			
			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
		
			String userId = user.getUserId();
							
			user = (User)hs.load(User.class, userId);
							
			Gadget gadget = (Gadget)hs.load(Gadget.class,gadgetId);
			gadget.getName();
			tx.commit();
			
			super.addActivity(ActivityTypeEnum.removeFavoriteGadget, userId, "", gadgetId);
						
			return "remove_confirm_page";
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}
	/**
	 * 사용자의 선호 가젯 모음에서 요청된 가젯을 삭제하는 액션 메소드
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception{
		//
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx = null;
		
		try
		{
			tx = hs.beginTransaction();
			
			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
		
			String userId = user.getUserId();
							
			user = (User)hs.load(User.class, userId);
							
			Gadget gadget = (Gadget)hs.load(Gadget.class,gadgetId);
			
			this.gadgets = user.getFavoriteGadgets();
			logger.log(Level.INFO, "Number of gadgets = " + gadgets.size());
			
			user.removeFavoriteGadget(gadget);
			
			this.gadgets = user.getFavoriteGadgets();
			logger.log(Level.INFO, "Number of gadgets = " + gadgets.size());
			
			if (gadgets.size() == 0)
			{
				Person person = (Person) hs.load(Person.class, userId);
				person.setHasapp(false);
				hs.saveOrUpdate(person);
			}
			hs.saveOrUpdate(user);
			
			tx.commit();
			
			super.addActivity(ActivityTypeEnum.removeFavoriteGadget, userId, "", gadgetId);
						
			return Action.SUCCESS;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}
		
	/* (non-Javadoc)
	 * @see com.skt.opensocial.user.ActivityBaseManager#setSession(java.util.Map)
	 */
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}

	/**
	 * 요청된 페이지 숫자를 가져온다
	 * @return 요청된 페이지
	 */
	public int getRequestedPage() {
		return requestedPage;
	}

	/**
	 * 요청된 페이지 숫자를 셋팅한다
	 * @param requestedPage 요청된 페이지
	 */
	public void setRequestedPage(int requestedPage) {
		this.requestedPage = requestedPage;
	}

	/**
	 * 가젯 목록을 가져온다
	 * @return 가젯 목록 셋
	 */
	public Set<Gadget> getGadgets() {
		return gadgets;
	}

	/**
	 * 가젯 목록을 셋팅한다
	 * @param gadgets 가젯 목록
	 */
	public void setGadgets(Set<Gadget> gadgets) {
		this.gadgets = gadgets;
	}

}
