package security;

import java.util.Map;

import user.SKTOpenSocialSupportConstants;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticationInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> Intercepted");
		
		
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		
		String userId = (String) session.get(SKTOpenSocialSupportConstants.USER_ID);
		if(userId == null) {
			System.out.println("Not logged in: " + userId);
			return Action.LOGIN;
		} else {
			//Action action = (Action) actionInvocation.getAction();
			System.out.println("Already logged in: " + userId);
			return actionInvocation.invoke();
			
		}

	}
	
//	private void purgeStaleTokens(Map session) {
//		Object userToken = session.get(SKTOpenSocialSupportConstants.USER_ID);
//		if()
//	}

}
