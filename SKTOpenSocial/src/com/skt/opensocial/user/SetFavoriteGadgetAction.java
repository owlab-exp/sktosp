/**
 * 
 */
package com.skt.opensocial.user;

import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.Person;
import com.skt.opensocial.persistence.User;

/**
 * 선호 가젯 모음에 특정 가젯을 추가하기 위한 액션 클래스
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class SetFavoriteGadgetAction extends ActivityBaseManager {
	//private static Logger logger = Logger.getLogger(SetFavoriteGadgetAction.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//GadgetDataList gadgetDataList;
	//Map<String, GadgetData> gadgetMap;
	/**
	 * 세션에 포함된 데이터 오브젝트들의 맵
	 */
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	/**
	 * 가젯 목록
	 */
	Set<Gadget> gadgets;
	/**
	 * 가젯 ID
	 */
	Long gadgetId;
	/**
	 * 특정 가젯
	 */
	Gadget gadget;
	
	/**
	 * 가젯 오브젝트를 가져온다
	 * @return
	 */
	public Gadget getGadget() {
		return gadget;
	}

	/**
	 * 가젯 오브젝트를 셋팅한다
	 * @param gadget
	 */
	public void setGadget(Gadget gadget) {
		this.gadget = gadget;
	}

	int requestedPage = 1;
	
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
	 * 주어진 가젯을 사용자의 선호가젯 목록에 추가하는 액션 메소드
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception{
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try
		{
			//System.out.println("add activity - 1" );
			
			tx = hs.beginTransaction();
			
			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
			
			String userId = user.getUserId();
							
			user = (User)hs.load(User.class, userId);
			Person person = (Person) hs.load(Person.class, userId);
			
			System.out.println("gadgetId = " + gadgetId);
			
			gadget = (Gadget) hs.load(Gadget.class, gadgetId);
						
			System.out.println("gadgetName " + gadget.getName());
			
			//this.gadgets = user.getFavoriteGadgets();
			
			// if (gadgets != null && !gadgets.isEmpty())
			//	System.out.println("Original size of gadgets = " + gadgets.size());
			
			user.addFavoriteGadget(gadget);
			if (user.getFavoriteGadgets().size() > 0)
				person.setHasapp(true);
			
			hs.saveOrUpdate(person);
			hs.saveOrUpdate(user);
			
			//this.gadgets = user.getFavoriteGadgets();
			//if (gadgets != null && !gadgets.isEmpty())
			//	System.out.println("Added size of gadgets = " + gadgets.size());
			
			//session.put(SKTOpenSocialSupportConstants.USER, user);
						
			tx.commit();
			
			super.addActivity(ActivityTypeEnum.addFavoriteGadget, userId, "", gadgetId);
			
			return Action.SUCCESS;
			
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}

	

	
	
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}

	public int getRequestedPage() {
		return requestedPage;
	}

	public void setRequestedPage(int requestedPage) {
		this.requestedPage = requestedPage;
	}

	/**
	 * 가젯 목록을 가져온다
	 * @return
	 */
	public Set<Gadget> getGadgets() {
		return gadgets;
	}

	/**
	 * 가젯 목록을 셋팅한다
	 * @param gadgets
	 */
	public void setGadgets(Set<Gadget> gadgets) {
		this.gadgets = gadgets;
	}

}
