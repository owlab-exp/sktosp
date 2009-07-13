/**
 * 
 */
package com.skt.opensocial.developer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.GadgetStatusConstants;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetCategory;
import com.skt.opensocial.persistence.GadgetIcon;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**
 * @author Ernest Lee
 * 
 */
// public class ListGadgetsAction extends ActionSupport implements RequestAware
// {
public class IconUploadAction extends ManageGadgetAction {
	private Logger logger = Logger.getLogger(IconUploadAction.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	public String execute() {
		if (getGadgetName() == null) {
			logger.info("No gadget name");
			// return Action.INPUT;
			return "register_gadget";
		}
		if (getIconFileName() == null) {
			logger.info("No gadget icon file name");
			return Action.INPUT;
		}
		logger.info("The Gadget Name of this icon=" + getGadgetName());
		logger.info("Icon File Name=" + getIconFileName());
		logger.info("Icon Content Type=" + getIconContentType());
		logger.info("Icon File Temporal Path=" + icon.getAbsolutePath());

		
		prepare();
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = hs.beginTransaction();
		try {
			Gadget newGadget = null;
			if (getGadgetId() != null) {
				newGadget = (Gadget) hs.get(Gadget.class, getGadgetId());
				
			} 
			if (newGadget == null) {
				newGadget = new Gadget();
			}
			newGadget.setName(getGadgetName());
			newGadget.setIconUrl(getGadgetIconUrl());
			newGadget.setIntroduction(getGadgetIntro());
			newGadget.setSource(getGadgetSource());
			newGadget.setStatus(GadgetStatusConstants.NOT_REGISTERED);
			newGadget.setRegisterType(getRegisterType());
			newGadget.setDeveloper((User) sessionMap
					.get(SKTOpenSocialSupportConstants.USER));

			String categoryIds = getGadgetCategory();
			String[] categoryIdArray = categoryIds.replace(" ", "").split(",");
			for (int i = 0; i < categoryIdArray.length; i++) {
				GadgetCategory category = (GadgetCategory) hs.load(
						GadgetCategory.class, categoryIdArray[i]);
				newGadget.addCategory(category);
			}
			
			
			setGadgetCategoryIdSelected(categoryIdArray);
			

			if(getGadgetId() != null) {
				hs.saveOrUpdate(newGadget);
			} else {
				gadgetId = (Long) hs.save(newGadget);
				setGadgetId(gadgetId);
			}

			// if (newGadget != null) {
			GadgetIcon gadgetIcon = new GadgetIcon();
			gadgetIcon.setGadget(newGadget);
			gadgetIcon.setName(getIconFileName());
			gadgetIcon.setContentType(getIconContentType());
			gadgetIcon.setContent(Hibernate
					.createBlob(new FileInputStream(icon)));

			hs.saveOrUpdate(gadgetIcon);
			tran.commit();
			// } else {
			// logger.error("Requested Gadget does not exist");
			// }
		} catch (FileNotFoundException fnfe) {
			logger.error(fnfe.getMessage());
			tran.rollback();
			return Action.INPUT;
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			logger.error(ioe.getMessage());
			tran.rollback();
			return Action.INPUT;
		}
		return Action.SUCCESS;
	}
}
