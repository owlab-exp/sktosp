package security;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import user.SKTOpenSocialSupportConstants;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class UserLogin extends ActionSupport implements SessionAware {

	
//	@Override
//	public void setSession(Map<String, Object> arg0) {
//		// TODO Auto-generated method stub
//
//	}

	public String execute() {
		//User user = new User();
		String userId = getUserId();
		String password = getPassword();
		
		if(userId == null || password == null)
			return Action.INPUT;
		if(userId.equals("nash") && password.equals("nash"))
			session.put(SKTOpenSocialSupportConstants.USER_ID, "nash");
		else
			return Action.INPUT;
		
		return Action.SUCCESS;
	}
	
	
	public void validate(){
		if(getPassword().length() == 0){
			addFieldError("password", "Password required");
		}
		if(getUserId().length() == 0) {
			addFieldError("userId", "User ID required");
		}
	}
	
	// Properties to receive login request parameters
	private String userId;
	private String password;
	private Map<String, Object> session;
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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
