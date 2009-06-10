/**
 * 
 */
package com.skt.opensocial.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.skt.opensocial.common.GadgetStatusConstants;

/**
 * @author Ernest Lee
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class ListGadgetsAction extends ActionSupport {
	
	//Map<String, Object> request;
	List<GadgetInfoData> gadgets;
	
	public String execute(){

		return Action.SUCCESS;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.RequestAware#setRequest(java.util.Map)
	 */
	/*@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		//this.request = request;

	}*/

	public List<GadgetInfoData> getGadgets() {
		return gadgets;
	}

	public void setGadgets(List<GadgetInfoData> gadgets) {
		this.gadgets = gadgets;
	}

	
}
