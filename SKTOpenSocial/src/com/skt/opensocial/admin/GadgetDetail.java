package com.skt.opensocial.admin;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.skt.opensocial.common.GadgetCategoryList;
import com.skt.opensocial.developer.ManageGadgetAction;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetCategory;
import com.skt.opensocial.persistence.HibernateUtil;

//public class GadgetDetail {
public class GadgetDetail extends ManageGadgetAction{
	
	private Gadget gadget;
		
	public String execute() {
		
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		Gadget gadget = (Gadget)hs.load(Gadget.class, gadgetId);

		setGadgetId(gadget.getId());
		setGadgetStatus(gadget.getStatus());
		setGadgetName(gadget.getName());
		setRegisterType(gadget.getRegisterType());
		setGadgetSource(gadget.getSource());
		setGadgetIntro(gadget.getIntroduction());
		setGadgetIconUrl(gadget.getIconUrl());
		
		/*
		return Action.SUCCESS;
		gadget	= new Gadget("가젯3", "오세준");
		gadget.setCreatedDate("2009-03-01");
		gadget.setDesc("오세준 가젯3입니다.");
		gadget.setNumRegUsers("19");
		gadget.setStatus("발행");
		gadget.setImagepath("../images/logo.jpg");

		setGadget(gadget);
		*/	
		return "SUCCESS";
	}

	/*
	public Gadget getGadget() {
		return gadget;
	}

	public void setGadget(Gadget gadget) {
		this.gadget = gadget;
	}
	*/



	

}
