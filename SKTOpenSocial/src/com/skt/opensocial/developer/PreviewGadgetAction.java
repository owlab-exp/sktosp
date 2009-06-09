/**
 * 
 */
package com.skt.opensocial.developer;

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
public class PreviewGadgetAction extends ActionSupport {
	
	private String gadgetStatus;
	
	public String execute(){
		System.out.println("originPage=" + gadgetStatus);
		return Action.SUCCESS;
	}
	
	public String getGadgetStatus() {
		return this.gadgetStatus;
	}
	
	public void setGadgetStatus(String gadgetStatus){
		this.gadgetStatus = gadgetStatus;
	}
	
}
