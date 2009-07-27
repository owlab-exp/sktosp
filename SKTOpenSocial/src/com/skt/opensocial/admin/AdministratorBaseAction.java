package com.skt.opensocial.admin;

import java.util.Map;

import com.skt.opensocial.common.CommonBaseAction;

public class AdministratorBaseAction extends CommonBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}
