/**
 * 
 */
package com.skt.opensocial.user;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.classic.Session;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.GadgetStatusConstants;
import com.skt.opensocial.developer.ManageGadgetAction;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetCategory;
import com.skt.opensocial.persistence.HibernateUtil;

/**
 * @author Seong yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class GadgetInfoAction extends ManageGadgetAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Gadget gadget;
	
	
	public Gadget getGadget() {
		return gadget;
	}

	public void setGadget(Gadget gadget) {
		this.gadget = gadget;
	}

	public String execute() {
		prepare();
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		gadget = (Gadget) hs.load(Gadget.class, gadgetId);
		
		/* 
		 * 

		gadget.setName(getGadgetName());
		
		String categoryIds = getGadgetCategory();
		
		System.out.println("list count = " + gadgetId + gadget.getName() + categoryIds);
		
		categoryIds = categoryIds.replace(" ", "");
		String[] categoryIdArray = categoryIds.split(",");
		if(categoryIdArray.length > 0) {
			HashSet<GadgetCategory> categorySet = new HashSet<GadgetCategory>();
			
			for(int i = 0; i < categoryIdArray.length; i++) {
				GadgetCategory gadgetCategory = (GadgetCategory)hs.load(GadgetCategory.class, categoryIdArray[i]);
				categorySet.add(gadgetCategory);
			}
			
			gadget.setCategories(categorySet);
		}

		gadget.setIconUrl(getGadgetIconUrl());
		gadget.setIntroduction(getGadgetIntro());
		gadget.setSource(getGadgetSource());
		gadget.setRegisterDate(null);
		gadget.setStatus(GadgetStatusConstants.NOT_REGISTERED);
		gadget.setRegisterType(getRegisterType());		
		
		*/
		
		hs.saveOrUpdate(gadget);
		hs.getTransaction().commit();
		
		return Action.SUCCESS;
	}
	
	public String getModifyGadgetPage(){
		prepare();
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		Gadget gadget = (Gadget) hs.load(Gadget.class, gadgetId);
		
		setGadgetId(gadget.getId());
		setGadgetName(gadget.getName());
		//
		Set<GadgetCategory> categories = gadget.getCategories();
		
		//for(Iterator<CadgetCategory> it: )
		GadgetCategory[] categoryArray = new GadgetCategory[categories.size()];
		categories.toArray(categoryArray);
//		StringBuffer categoryBuffer = new StringBuffer();
		String[] categoryIdArray = new String[categoryArray.length];
		for(int i = 0; i < categoryArray.length; i++){
//			categoryBuffer.append(categoryArray[i].getId());
//			categoryBuffer.append(", ");
			categoryIdArray[i] = categoryArray[i].getId();
		}
		setGadgetCategoryIdSelected(categoryIdArray);
//		categoryBuffer.append(categoryArray[categoryArray.length -1].getId());
//		
//		setGadgetCategory(categoryBuffer.toString());
		//setGadgetCategory("dating, finance");
		//setGadgetIconUrl(gadget.getIconUrl());
		setGadgetIntro(gadget.getIntroduction());
		setGadgetSource(gadget.getSource());
		setGadgetStatus(gadget.getStatus());
		setRegisterType(gadget.getRegisterType());
		setGadgetIconUrl(gadget.getIconUrl());
		
		hs.getTransaction().commit();
		
		return null;
		//return "input";
	}
}
