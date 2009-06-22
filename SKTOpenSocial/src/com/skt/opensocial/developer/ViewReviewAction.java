/**
 * 
 */
package com.skt.opensocial.developer;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Ernest Lee
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class ViewReviewAction extends ActionSupport implements SessionAware{
	
	
	private String gadgetId;
	private String gadgetName;
	private String gadgetStatus;
	
	
	
	private Map<String, Object> session;
	
	public String execute(){
		//System.out.println("originPage=" + gadgetStatus);
		GadgetDataList gdl = (GadgetDataList)session.get("gadgets");
		GadgetData gadget = gdl.getGadget(getGadgetId());
		setGadgetStatus(gadget.getGadgetStatus());
		setGadgetName(gadget.getGadgetName());
		
		
		return Action.SUCCESS;
	}
	
	public String getGadgetStatus() {
		return this.gadgetStatus;
	}
	
	public void setGadgetStatus(String gadgetStatus){
		this.gadgetStatus = gadgetStatus;
	}

	public String getGadgetId() {
		return gadgetId;
	}

	public void setGadgetId(String gadgetId) {
		this.gadgetId = gadgetId;
	}
	
	public String getGadgetName() {
		return gadgetName;
	}

	public void setGadgetName(String gadgetName) {
		this.gadgetName = gadgetName;
	}
	


	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
