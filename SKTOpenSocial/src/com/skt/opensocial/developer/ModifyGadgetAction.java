/**
 * 
 */
package com.skt.opensocial.developer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.GadgetStatusConstants;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetCategory;
import com.skt.opensocial.persistence.GadgetIcon;
import com.skt.opensocial.persistence.HibernateUtil;

/**
 * @author Ernest Lee
 * 
 */
// public class ListGadgetsAction extends ActionSupport implements RequestAware
// {
public class ModifyGadgetAction extends ManageGadgetAction {
	private Logger logger = Logger.getLogger(ModifyGadgetAction.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() {
		prepare();

		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = hs.beginTransaction();

		Gadget gadget = (Gadget) hs.get(Gadget.class, gadgetId);
		
		gadget.setName(getGadgetName());
		
		setGadgetId(gadgetId);//??
		//sessionMap.put("modifiedGadgetId", gadgetId);// temporal
		sessionMap.put("GADGET_ID", gadgetId);

		String categoryIds = getGadgetCategory();
		categoryIds = categoryIds.replace(" ", "");
		String[] categoryIdArray = categoryIds.split(",");
		if (categoryIdArray.length > 0) {
			HashSet<GadgetCategory> categorySet = new HashSet<GadgetCategory>();

			for (int i = 0; i < categoryIdArray.length; i++) {
				GadgetCategory gadgetCategory = (GadgetCategory) hs.load(
						GadgetCategory.class, categoryIdArray[i]);
				categorySet.add(gadgetCategory);
			}

			gadget.setCategories(categorySet);
		}

		gadget.setIconUrl(getGadgetIconUrl());
		gadget.setIntroduction(getGadgetIntro());
		gadget.setSource(getGadgetSource());
		gadget.setGadgetSource(getGadgetSource());
		gadget.setGadgetUrl(getGadgetUrl());
		gadget.setRegisterDate(null);
		gadget.setStatus(GadgetStatusConstants.NOT_REGISTERED);
		gadget.setRegisterType(getRegisterType());

		hs.saveOrUpdate(gadget);

		// for gadget icon

		// GadgetIcon gadgetIcon = new GadgetIcon();
		// gadgetIcon.setGadget(gadget);
		if (getIconFileName() != null) {
			GadgetIcon gadgetIcon = gadget.getIcon();
			gadgetIcon.setName(getIconFileName());
			gadgetIcon.setContentType(getIconContentType());
			try {
				gadgetIcon.setContent(Hibernate.createBlob(new FileInputStream(
						icon)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
				tran.rollback();
				return Action.INPUT;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
				tran.rollback();
				return Action.INPUT;
			}
			gadget.setIconUrl("exist");
			hs.saveOrUpdate(gadgetIcon);
			// end for gadget icon
		}
		tran.commit();

		return "preview";
	}

	public String getModifyGadgetPage() {
		prepare();

		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();

		Gadget gadget = (Gadget) hs.get(Gadget.class, gadgetId);

		setGadgetId(gadget.getId());
		setGadgetName(gadget.getName());
		//
		Set<GadgetCategory> categories = gadget.getCategories();

		// for(Iterator<CadgetCategory> it: )
		GadgetCategory[] categoryArray = new GadgetCategory[categories.size()];
		categories.toArray(categoryArray);
		// StringBuffer categoryBuffer = new StringBuffer();
		String[] categoryIdArray = new String[categoryArray.length];
		for (int i = 0; i < categoryArray.length; i++) {
			// categoryBuffer.append(categoryArray[i].getId());
			// categoryBuffer.append(", ");
			categoryIdArray[i] = categoryArray[i].getId();
		}
		setGadgetCategoryIdSelected(categoryIdArray);
		// categoryBuffer.append(categoryArray[categoryArray.length
		// -1].getId());
		//		
		// setGadgetCategory(categoryBuffer.toString());
		// setGadgetCategory("dating, finance");
		// setGadgetIconUrl(gadget.getIconUrl());
		setGadgetIntro(gadget.getIntroduction());
		setGadgetSource(gadget.getGadgetSource());
		setGadgetUrl(gadget.getGadgetUrl());
		setGadgetStatus(gadget.getStatus());
		setRegisterType(gadget.getRegisterType());
		setGadgetIconUrl(gadget.getIconUrl());

		hs.getTransaction().commit();

		return "input";
	}

	// for icon upload
	private File icon;
	private String iconContentType;
	private String iconFileName;

	public File getIcon() {
		return icon;
	}

	public void setIcon(File file) {
		this.icon = file;
	}

	public String getIconContentType() {
		return iconContentType;
	}

	public void setIconContentType(String contentType) {
		this.iconContentType = contentType;
	}

	public String getIconFileName() {
		return iconFileName;
	}

	public void setIconFileName(String iconFileName) {
		this.iconFileName = iconFileName;
	}
	// end of icon file upload
}
