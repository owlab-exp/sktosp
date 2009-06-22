/**
 * 
 */
package com.skt.opensocial.developer;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.skt.opensocial.common.GadgetCategoryList;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.HibernateUtil;

/**
 * @author Ernest Lee
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class PreviewGadgetAction extends ActionSupport implements SessionAware{
	
	
	private Long gadgetId;
	private String gadgetName;
	private String gadgetStatus;
	private GadgetCategoryList categoryList;
	private GadgetDataList gadgetDataList;
	
	private Map<String, Object> session;
	
	public String execute(){
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		Gadget gadget = (Gadget)hs.load(Gadget.class, gadgetId);
		/*
		//System.out.println("originPage=" + gadgetStatus);
		
		if(categoryList == null) {
			categoryList = new GadgetCategoryList();
		}
		
		// get gadget list from session
		GadgetDataList gadgetDataListS = (GadgetDataList)session.get("gadgets");
		if(gadgetDataList == null) {
			session.put("gadgets", new GadgetDataList());
			this.gadgetDataList = (GadgetDataList)session.get("gadgets");
		} else {
			this.gadgetDataList = gadgetDataListS;
		}
		
		GadgetDataList gdl = (GadgetDataList)session.get("gadgets");
		GadgetData gadget = gdl.getGadget(getGadgetId());*/
		setGadgetStatus(gadget.getStatus());
		setGadgetName(gadget.getName());
		
		return Action.SUCCESS;
	}
	
	public String getGadgetStatus() {
		return this.gadgetStatus;
	}
	
	public void setGadgetStatus(String gadgetStatus){
		this.gadgetStatus = gadgetStatus;
	}

	public Long getGadgetId() {
		return gadgetId;
	}

	public void setGadgetId(Long gadgetId) {
		this.gadgetId = gadgetId;
	}
	
	public String getGadgetName() {
		return gadgetName;
	}

	public void setGadgetName(String gadgetName) {
		this.gadgetName = gadgetName;
	}

	
	public GadgetCategoryList getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(GadgetCategoryList categoryList) {
		this.categoryList = categoryList;
	}

	public GadgetDataList getGadgetDataList() {
		return gadgetDataList;
	}

	public void setGadgetDataList(GadgetDataList gadgetDataList) {
		this.gadgetDataList = gadgetDataList;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
