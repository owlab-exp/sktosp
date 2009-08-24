package com.skt.opensocial.admin;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.skt.opensocial.developer.ManageGadgetAction;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetCategory;
import com.skt.opensocial.persistence.HibernateUtil;

/**	관리자가 가젯 상세 정보를 확인하는 액션 클래스
 * @author 	Sejoon Oh based on Ernest Lee's
 * @version 
 * @since	1.0
 * 
 */
//public class GadgetDetail {
public class GadgetDetail extends ManageGadgetAction{
	
	private Gadget gadget;
	private String disappovalReason;
	private String categoryListStr;
	private Integer favoriteUserSize;
	
	/** 가젯의 ID를 받아 가젯의 상세 정보를 가져옴
	 * 
	 */
	public String execute() throws Exception{
		
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();
			
			
			Gadget gadget = (Gadget)hs.load(Gadget.class, gadgetId);
	
			setGadgetId(gadget.getId());
			setGadgetStatus(gadget.getStatus());
			setGadgetName(gadget.getName());
			setRegisterType(gadget.getRegisterType());
			setGadgetSource(gadget.getSource());
			setGadgetIntro(gadget.getIntroduction());
			setGadgetIconUrl(gadget.getIconUrl());
			setGadgetStatus(gadget.getStatus());
			setDisappovalReason(gadget.getGadgetPublish().getRejectReason());
			
			
			Set<GadgetCategory> categories = gadget.getCategories();
			GadgetCategory[] categoryArray = new GadgetCategory[categories.size()];
			categories.toArray(categoryArray);
			String[] categoryIdArray = new String[categoryArray.length];
			for (int i = 0; i < categoryArray.length; i++) {
				categoryIdArray[i] = categoryArray[i].getId();
			}
			setGadgetCategoryIdSelected(categoryIdArray);
	
			setFavoriteUserSize(gadget.getFavoriteUsers().size());
	
			hs.getTransaction().commit();
	
			return "SUCCESS";
		
		
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}

	public String getDisappovalReason() {
		return disappovalReason;
	}

	public void setDisappovalReason(String disappovalReason) {
		this.disappovalReason = disappovalReason;
	}

	public String getCategoryListStr() {
		
		String[] tempStr	= getGadgetCategoryIdSelected();
		List<String> tempList	= Arrays.asList(tempStr);
		StringBuffer sb	= new StringBuffer();
		
		for (String e: tempList)
		{
			sb.append(e);
			sb.append("\n");
		}
		categoryListStr	= sb.toString();
		return categoryListStr;
	}

	public void setCategoryListStr(String categoryListStr) {
		this.categoryListStr = categoryListStr;
	}

	public Integer getFavoriteUserSize() {
		return favoriteUserSize;
	}

	public void setFavoriteUserSize(Integer favoriteUserSize) {
		this.favoriteUserSize = favoriteUserSize;
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
