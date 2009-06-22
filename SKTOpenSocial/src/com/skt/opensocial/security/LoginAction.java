package com.skt.opensocial.security;

import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.classic.Session;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.CommonBaseAction;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

public class LoginAction extends CommonBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(LoginAction.class);
//	@Override
//	public void setSession(Map<String, Object> arg0) {
//		// TODO Auto-generated method stub
//
//	}

	public String execute() {
		//User user = new User();
//		String userId = getUserId();
//		String password = getPassword();
//		
//		if(userId == null || password == null)
//			return Action.INPUT;
//		if(userId.equals("nash") && password.equals("nash")) {
//			UserData userData = new UserData();
//			userData.setUserId(userId);
//			userData.setUserName("NASH Team");
//			userData.setAdministrator(true);
//			session.put(SKTOpenSocialSupportConstants.USER, userData);
//		}
//		else
//			return Action.INPUT;
//		
//		return Action.SUCCESS;
		String userId = getUserId();
		String password = getPassword();
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.getTransaction().begin();
		
		User user = (User) hs.get(User.class, userId);
		PasswordEncryptor pe = PasswordEncryptor.getInstance();
		String hashedPassword = pe.encrypt(password);
		logger.log(Level.INFO, "hash=" + hashedPassword);
//		user.setPassword(hashedPassword);
//		hs.save(user);
//		hs.flush();
		if(user != null){
			if(hashedPassword.equals(user.getPassword())){
				
//				UserData userData = new UserData();
//				userData.setUserId(userId);
//				userData.setUserName(user.getPerson().getName());
//				userData.setAdministrator(user.isAdministrator());
//				userData.setDeveloper(user.isDeveloper());
				
				session.put(SKTOpenSocialSupportConstants.USER, user);
				return Action.SUCCESS;
			}
		}
		hs.getTransaction().commit();
		
		return Action.INPUT;
		
	}
	
	
	public void validate(){
		if(getPassword() == null || getPassword().length() == 0){
			addFieldError("password", "Password required");
		}
		if(getUserId() == null || getUserId().length() == 0) {
			addFieldError("userId", "User ID required");
		}
	}
	
	private String password;
	private Map<String, Object> session;
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
}
