package com.skt.opensocial.security;

import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Transaction;
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

	// @Override
	// public void setSession(Map<String, Object> arg0) {
	// // TODO Auto-generated method stub
	//
	// }

	public String execute() throws Exception {
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			String userId = getUserId();
			String password = getPassword();

			tx = hs.beginTransaction();

			User user = (User) hs.get(User.class, userId);
			PasswordEncryptor pe = PasswordEncryptor.getInstance();
			String hashedPassword = pe.encrypt(password);
			
			logger.log(Level.INFO, "hash=" + hashedPassword);
			
			if (user != null) {
				if (hashedPassword.equals(user.getPassword())) {
					session.put(SKTOpenSocialSupportConstants.USER, user);
					return Action.SUCCESS;
				}
			}
			hs.getTransaction().commit();
			return Action.INPUT;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;

		}

	}

	public void validate() {
		if (getPassword() == null || getPassword().length() == 0) {
			addFieldError("password", "Password required");
		}
		if (getUserId() == null || getUserId().length() == 0) {
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
