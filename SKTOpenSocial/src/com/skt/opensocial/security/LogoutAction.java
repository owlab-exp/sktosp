/**
 * 
 */
package com.skt.opensocial.security;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.Action;

/**
 * 로그아웃을 위한 액션 클래스이다.
 * @author Ernest Lee
 * 
 */
public class LogoutAction implements ServletRequestAware {
	HttpServletRequest request = null;

	public void setServletRequest(final HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * 로그아웃을 수행하고 사용자의 요청을 로긴 페이지로 전환한다.
	 * @return 로긴 페이지
	 * @throws Exception
	 */
	public String execute() throws Exception {
		request.getSession().invalidate();
		return Action.SUCCESS;
	}

}
