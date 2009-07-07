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
public class ViewReviewAction extends ManageGadgetAction{
	
	public String execute(){
		
		
		return Action.SUCCESS;
	}
}
