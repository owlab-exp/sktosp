package com.skt.opensocial.common;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;



/**
 * 대부분의 앤션 클래스들이 이 베이스 액션으로부터 상속되어 작성된다.
 * 사용자 ID는 대부분의 액션 클래스들에서 사용될 것이며 또한 HTTP Session에 대한 엑세스도
 * 이 클래스에서 미리 선언된다. 
 * @author Ernest Lee
 *
 */
public class CommonBaseAction extends ActionSupport implements SessionAware {

	/**
	 * 사용자 ID
	 */
	private String userId;

	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * JSP 페이지에서 사용자 ID를 필요로 할 경우에 사용될 것이다. 
	 * @return 사용자 ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * JSP 페이지로부터 사용자 ID를 입력받기 위한 메소드이다.
	 * @param userId 사용자 ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
