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
 * @author Seong Yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class RegistrationAction extends ActivityBaseManager {
	//private static Logger logger = Logger.getLogger(SetFriendAction.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//GadgetDataList gadgetDataList;
	//Map<String, GadgetData> gadgetMap;
	Map<String, Object> session;
	//Collection<GadgetData> gadgetList;
	String userIdDuplicationError = "false";
	String userIdAbsenceError = "false";
	String passwordError = "false";
	String userNameAbsenceError = "false";
	String emailAbsenceError ="false";
		
	String friendId;
	User user;
	User friend;	
	int requestedPage = 1;
	
	public String getPasswordError() {
		return passwordError;
	}

	public void setPasswordError(String passwordError) {
		this.passwordError = passwordError;
	}

	public String getUserNameAbsenceError() {
		return userNameAbsenceError;
	}

	public void setUserNameAbsenceError(String userNameAbsenceError) {
		this.userNameAbsenceError = userNameAbsenceError;
	}

	public String getEmailAbsenceError() {
		return emailAbsenceError;
	}

	public void setEmailAbsenceError(String emailAbsenceError) {
		this.emailAbsenceError = emailAbsenceError;
	}

	public String getUserIdAbsenceError() {
		return userIdAbsenceError;
	}

	public void setUserIdAbsenceError(String userIdAbsenceError) {
		this.userIdAbsenceError = userIdAbsenceError;
	}

	public String getUserIdDuplicationError() {
		return userIdDuplicationError;
	}

	public void setUserIdDuplicationError(String userIdDuplicationError) {
		this.userIdDuplicationError = userIdDuplicationError;
	}

	public String getFriendId() {
		return friendId;
	}

	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getFriend() {
		return friend;
	}

	public void setFriend(User friend) {
		this.friend = friend;
	}

	public String execute() throws Exception{
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx = null;
		
		try
		{
			tx = hs.beginTransaction();
			
			String useridabsenceerror = (String) session.get(SKTOpenSocialSupportConstants.USERIDABSENCEERROR);
			if (useridabsenceerror != null)
			{
				userIdAbsenceError = useridabsenceerror;
				System.out.println("---useridabsenceerror--- " + useridabsenceerror);
			}
			String useridduplicationerror = (String) session.get(SKTOpenSocialSupportConstants.USERIDDUPLICATIONERROR);
			if (useridduplicationerror != null)
			{
				userIdDuplicationError = useridduplicationerror;
				System.out.println("---useridduplicationerror--- " + useridduplicationerror);
			}
			String usernameabsenceerror = (String) session.get(SKTOpenSocialSupportConstants.USERNAMEABSENCEERROR);
			if (usernameabsenceerror != null)
			{
				userNameAbsenceError = usernameabsenceerror;
				System.out.println("---usernameabsenceerror--- " + usernameabsenceerror);
			}
			String passworderror = (String) session.get(SKTOpenSocialSupportConstants.PASSWORDERROR);
			if (passworderror != null)
			{
				passwordError = passworderror;
				System.out.println("---passworderror--- " + passworderror);
			}
			String emailabsenceerror = (String) session.get(SKTOpenSocialSupportConstants.EMAILABSENCEERROR);
			if (emailabsenceerror != null)
			{
				emailAbsenceError = emailabsenceerror;
				System.out.println("---emailabsenceerror--- " + emailabsenceerror);
			}
			session.remove(SKTOpenSocialSupportConstants.USERIDABSENCEERROR);
			session.remove(SKTOpenSocialSupportConstants.USERIDDUPLICATIONERROR);
			session.remove(SKTOpenSocialSupportConstants.USERNAMEABSENCEERROR);
			session.remove(SKTOpenSocialSupportConstants.PASSWORDERROR);
			session.remove(SKTOpenSocialSupportConstants.EMAILABSENCEERROR);
			
//			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
//			
//			String userId = user.getUserId();
//			
//			if (userId.equals(friendId))
//			{
//				tx.commit();
//				return Action.SUCCESS;
//			}
//			user = (User)hs.load(User.class, userId);
//			
//			friend = (User)hs.load(User.class, friendId);
//			
//			user.addFriendsByMe(friend);
//					
//			hs.saveOrUpdate(user);
						
			//session.put(SKTOpenSocialSupportConstants.USER, user);
						
			//this.gadgets = this.gadgets.add(gadgetId);
			//logger.log(Level.INFO, "Number of gadgets = " + gadgets.size());
			
			tx.commit();
			
//			super.addActivity(ActivityTypeEnum.addFavoriteFriend, userId, friendId, null);
			
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
