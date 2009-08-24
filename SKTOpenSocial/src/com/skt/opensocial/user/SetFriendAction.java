/**
 * 
 */
package com.skt.opensocial.user;

import java.util.Map;
import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;

import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**
 * 특정 사용자를 친구로 등록하기 위한 액션 클래스
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class SetFriendAction extends ActivityBaseManager {
	//private static Logger logger = Logger.getLogger(SetFriendAction.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//GadgetDataList gadgetDataList;
	//Map<String, GadgetData> gadgetMap;
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	/**
	 * 친구의 사용자 ID
	 */
	String friendId;
	/**
	 * 사용자 오브젝트
	 */
	User user;
	/**
	 * 친구의 사용자 오브젝트
	 */
	User friend;	
	int requestedPage = 1;
		
	/**
	 * 친구의 사용자 ID를 가져온다
	 * @return
	 */
	public String getFriendId() {
		return friendId;
	}

	/**
	 * 친구의 사용자 오브젝트를 셋팅한다
	 * @param friendId
	 */
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	
	

	/**
	 * 사용자 오브젝트를 가져온다
	 * @return
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 사용자 오브젝트를 셋팅한다
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 친구의 사용자 오브젝트를 가져온다
	 * @return
	 */
	public User getFriend() {
		return friend;
	}

	
	/**
	 * 친구의 사용자 오브젝트를 셋팅한다
	 * @param friend
	 */
	public void setFriend(User friend) {
		this.friend = friend;
	}

	/**
	 * 특정 사용자를 자신의 친구 목록에 추가하는 액션 메소드
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception{
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx = null;
		
		try
		{
			tx = hs.beginTransaction();
			
			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
			
			String userId = user.getUserId();
			
			if (userId.equals(friendId))
			{
				tx.commit();
				return Action.SUCCESS;
			}
			user = (User)hs.load(User.class, userId);
			
			friend = (User)hs.load(User.class, friendId);
			
			user.addFriendsByMe(friend);
					
			hs.saveOrUpdate(user);
						
			//session.put(SKTOpenSocialSupportConstants.USER, user);
						
			//this.gadgets = this.gadgets.add(gadgetId);
			//logger.log(Level.INFO, "Number of gadgets = " + gadgets.size());
			
			tx.commit();
			
			super.addActivity(ActivityTypeEnum.addFavoriteFriend, userId, friendId, null);
			
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

}
