package com.skt.opensocial.developer;

import java.util.Map;

import com.skt.opensocial.common.CommonBaseAction;

/**
 * 개발자관련 액션들이 확장하여야 할 기본 액션 클래스
 * 세션을 참조도록 하는 메소드를 포함한다.
 * @author Ernest Lee
 *
 */
public class DeveloperBaseAction extends CommonBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	/* (non-Javadoc)
	 * @see com.skt.opensocial.common.CommonBaseAction#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}
