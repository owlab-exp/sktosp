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
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class UserRemoveFriendAction extends ActivityBaseManager {
	//private static Logger logger = Logger.getLogger(UserRemoveFriendAction.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//GadgetDataList gadgetDataList;
	//Map<String, GadgetData> gadgetMap;
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	Set<Gadget> gadgets;
	
	int requestedPage = 1;
	String friendId;
	User friend;
	
	
	
	public String getFriendId() {
		return friendId;
	}

	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}

	public User getFriend() {
		return friend;
	}

	public void setFriend(User friend) {
		this.friend = friend;
	}

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
	
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}

	public int getRequestedPage() {
		return requestedPage;
	}

	public void setRequestedPage(int requestedPage) {
		this.requestedPage = requestedPage;
	}

	public Set<Gadget> getGadgets() {
		return gadgets;
	}

	public void setGadgets(Set<Gadget> gadgets) {
		this.gadgets = gadgets;
	}

}
