/**
 * 
 */
package com.skt.opensocial.user;

import java.util.Map;
import java.util.Set;

import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;

import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**
 * 친구 목록에서 특정 사용자를 삭제하기 위한 액션 클래스
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
public class UserRemoveFriendAction extends ActivityBaseManager {
	//private static Logger logger = Logger.getLogger(UserRemoveFriendAction.class);
	
	private static final long serialVersionUID = 1L;
	//Map<String, Object> session;
	
	Set<Gadget> gadgets;
	
	/**
	 * 요청된 페이지
	 */
	int requestedPage = 1;
	/**
	 * 친구의 사용자 ID
	 */
	String friendId;
	/**
	 * 친구의 사용자 오브젝트
	 */
	User friend;
	
	
	
	/**
	 * 친구의 사용자 ID를 가져온다
	 * @return 친구의 ID
	 */
	public String getFriendId() {
		return friendId;
	}

	/**
	 * 친구의 사용자 ID를 셋팅한다
	 * @param friendId 친구의 ID
	 */
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}

	/**
	 * 친구의 (User) 오브젝트를 가져온다
	 * @return
	 */
	public User getFriend() {
		return friend;
	}

	/**
	 * 친구의 (User)오브젝트를 셋팅한다
	 * @param friend
	 */
	public void setFriend(User friend) {
		this.friend = friend;
	}

	/**
	 * 사용자 삭제 시 확인을 위한 페이지를 웹 브라우저에 전송하는 액션 메소드
	 * @return
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
			friend = (User)hs.load(User.class, friendId);
			
			tx.commit();
			
			return "remove_confirm_page";
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}
	
	
	/**
	 * 친구 목록에서 특정 사용자를 삭제하는 액션 메소드
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
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
			friend = (User)hs.load(User.class, friendId);
			
			user.removeFriendByMe(friend);
					
			hs.saveOrUpdate(user);
			
			//this.gadgets = user.getFavoriteGadgets();
			//if (gadgets != null && !gadgets.isEmpty())
			//	System.out.println("Added size of gadgets = " + gadgets.size());
			
			//session.put(SKTOpenSocialSupportConstants.USER, user);
			tx.commit();
			
			super.addActivity(ActivityTypeEnum.removeFavoriteFriend, userId, friendId, null);
			
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
	 * @return
	 */
	public int getRequestedPage() {
		return requestedPage;
	}

	/**
	 * 요청된 페이지 숫자를 셋팅한다
	 * @param requestedPage
	 */
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
