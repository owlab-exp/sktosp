/** RegistrationAction is the first class when a user tries to register
 *  himself or herself
 * 
 */
package com.skt.opensocial.user;

import java.util.Map;
import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;

import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**	사용자가 메인 페이지에서 회원가입 페이지로 이동할 때, 관련 에러를 전달하는 액션 클래스
 * @author 	Seong Yong Lim based on Ernest Lee's
 * @version 
 * @since	1.0
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
	
	/** 입력된 사용자ID 가 이미 시스템에서 사용되고 있음을
	 * 알리는 에러 표시자
	 * Error indicator when the inserted userId is already used
	*/
	public String userIdDuplicationError = "false";
	
	/**	입력된 사용자ID 가 존재하지 않음을 알리는 에러 표시자
	 * Error indicator when the inserted userId is absent
	 *  
	 */
	public String userIdAbsenceError = "false";
	
	/** 입력된 패스워드에 문제가 있음을 알리는 에러 표시자
	 * Error indicator when the inserted password has fault
	 * 
	 */
	public String passwordError = "false";
	
	/** 입력된 사용자이름이 존재하지 않음을 알리는 에러 표시자
	 * Error indicator when the inserted userName is absent
	 * 
	 */
	public String userNameAbsenceError = "false";
	
	/** 입력된 이메일이 존재하지 않음을 알리는 에러 표시자
	 * Error indicator when the inserted email is absent
	 * 
	 */
	public String emailAbsenceError ="false";
		
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

	/** execute 메소드 에서는 세션에서 이전의 페이지에서 발생한 입력에 에러가 존재하는 지 검사하고
	 * 다음의 회원가입 페이지에서 에러 표시자를 전달한다.
	 * This execute performs basic error checking what kinds of errors were happened
	 *  From the session, this execute receives the error flags which should be
	 *  set by a previous action.
	 *  @param SKTOpenSocialSupportConstants.USERIDABSENCEERROR Indicator of userId absence error
	 */
	
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
