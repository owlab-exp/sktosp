package com.skt.opensocial.security;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.common.UserData;

public class AuthenticationInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> Intercepted to examine if logged in");
		
		
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		
		UserData userData = (UserData) session.get(SKTOpenSocialSupportConstants.USER);
		if(userData == null) {
			System.out.println("Not logged in");
			return Action.LOGIN;
		} else {
			//Action action = (Action) actionInvocation.getAction();
			System.out.println("Already logged in: " + userData.getUserId());
			return actionInvocation.invoke();
			
		}

	}
}
