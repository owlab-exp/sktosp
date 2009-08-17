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

/**
 * 로긴처리를 위한 액션 클래스
 * @author Ernest Lee
 *
 */
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

	/**
	 * 사용자의 로긴 정보 (ID와 패스워드)를 확인하는 액션 메소드이다
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
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
				} else {
					addFieldError("password", "패스워드 틀림");
				}
			} else {
				addFieldError("userId", "존재하지 않는 사용자 ID");
			}
			hs.getTransaction().commit();
			return Action.INPUT;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;

		}

	}

	/**
	 * 사용자 ID와 패스워드가 입력되어 있는지를 확인하기 위한 메소드이다
	 * @see com.opensymphony.xwork2.ActionSupport#validate()
	 */
	public void validate() {
		if (getPassword() == null || getPassword().length() == 0) {
			addFieldError("password", "패스워드 없음");
		}
		if (getUserId() == null || getUserId().length() == 0) {
			addFieldError("userId", "사용자 ID 없음");
		}
	}

	/**
	 * 패스워드
	 */
	private String password;
	private Map<String, Object> session;

	/**
	 * 패스워드를 가져온다.
	 * @return 패스워드
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 패스워드를 셋팅한다
	 * @param password 패스워드
	 */
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
