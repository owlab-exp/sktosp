package com.skt.opensocial.security;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.persistence.User;

/**
 * 액션이 호출될 때에 호출자가 로긴했는지 여부를 판별하기 위한 인터셉터이다
 * @author Ernest Lee
 *
 */
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

	/**
	 * 사용자의 세션으로부터, 사용자 ID 오브젝트가 있는지를 확인함으로써, 로긴 여부를 판단한다.
	 * 로긴이 안되어 있는 경우는, 사용자의 요청을 로긴 화면으로 Redirection하도록 한다.
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> Intercepted to examine if logged in");
		
		
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		User user = (User) session.get(SKTOpenSocialSupportConstants.USER);
		if(user == null) {
			System.out.println("Not logged in");
			return Action.LOGIN;
		} else {
			//Action action = (Action) actionInvocation.getAction();
			System.out.println("Logged in as " + user.getUserId());
			return actionInvocation.invoke();
			
		}

	}
}
