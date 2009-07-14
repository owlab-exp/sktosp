/**
 * 
 */
package com.skt.opensocial.developer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;

import javax.activation.MimetypesFileTypeMap;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.GadgetRegisterTypeConstants;
import com.skt.opensocial.common.GadgetStatusConstants;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetCategory;
import com.skt.opensocial.persistence.GadgetIcon;
import com.skt.opensocial.persistence.GadgetPublish;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**
 * @author Ernest Lee
 * 
 */
// public class ListGadgetsAction extends ActionSupport implements RequestAware
// {
public class RegisterGadgetAction extends ManageGadgetAction {
	private Logger logger = Logger.getLogger(RegisterGadgetAction.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String defaultIconLocation = "http://localhost:8080/SKTOpenSocial/images/gadget_default_icon.jpg";
	public String getGadgetRegisterPage() {
		prepare();

		setGadgetStatus(GadgetStatusConstants.NOT_REGISTERED);
		if (registerType == null) {
			// registerType = GadgetRegisterTypeConstants.SRC;
			registerType = GadgetRegisterTypeConstants.URL;
		}

		if (registerType.equals(GadgetRegisterTypeConstants.URL_MULTI))
			return "input_multiple";
		else
			return "input_one";

	}

	public String finishGadgetRegister() {
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();

		Gadget gadget = (Gadget) hs.get(Gadget.class, gadgetId);
		gadget.setStatus(GadgetStatusConstants.REGISTERED);
		gadget.setRegisterDate(new Date());
		hs.save(gadget);
		hs.getTransaction().commit();

		return "gadget_list";
	}

	public String execute() {
		try {
			logger.info(">>>>>>>>>>>>>>>>>>>> Gadget Registration");
			logger.info(">>>>>>>>>>>>>>>>>>>> registerType="
					+ getRegisterType());
			logger.info(">>>>>>>>>>>>>>>>>>>> gadgetId=" + getGadgetId());
			logger.info(">>>>>>>>>>>>>>>>>>>> gadgetName=" + getGadgetName());
			logger.info(">>>>>>>>>>>>>>>>>>>> gadgetCategory="
					+ getGadgetCategory());
			logger.info(">>>>>>>>>>>>>>>>>>>> gadgetIntro=" + getGadgetIntro());
			// logger.info(">>>>>>>>>>>>>>>>>>>> gadgetSource=" +
			// getGadgetSource());
			logger.info(">>>>>>>>>>>>>>>>>>>> gadgetStatus="
					+ getGadgetStatus());

			prepare();

			Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tran = hs.beginTransaction();

			Gadget newGadget = new Gadget();

			if (getGadgetName() == null || getGadgetName().equals("")) {
				tran.rollback();
				return "input";
			}
			newGadget.setName(getGadgetName());
			
			if (getGadgetIntro() == null || getGadgetIntro().equals("")) {
				tran.rollback();
				return "input";
			}
			newGadget.setIconUrl(getGadgetIconUrl());
			newGadget.setIntroduction(getGadgetIntro());
			newGadget.setStatus(GadgetStatusConstants.NOT_REGISTERED);

			if (getRegisterType() == null || getRegisterType().equals("")) {
				tran.rollback();
				return Action.INPUT;
			}

			
			if (registerType.equals(GadgetRegisterTypeConstants.SRC)) {
				if(getGadgetSource() == null || getGadgetSource().length() == 0) {
					tran.rollback();
					return Action.INPUT;
				}
				newGadget.setGadgetSource(getGadgetSource());
			} else if (registerType.equals(GadgetRegisterTypeConstants.URL)) {
				if(getGadgetUrl() == null || getGadgetUrl().length() == 0) {
					tran.rollback();
					return Action.INPUT;
				}
				newGadget.setGadgetUrl(getGadgetUrl());
			} else {
				tran.rollback();
				return Action.INPUT;
			}
			newGadget.setRegisterType(getRegisterType());
			
			newGadget.setDeveloper((User) sessionMap
					.get(SKTOpenSocialSupportConstants.USER));

			gadgetId = (Long) hs.save(newGadget);
			
			setGadgetId(gadgetId);//?
			sessionMap.put("GADGET_ID", gadgetId);// for preview
			// prepare categories
			String categoryIds = getGadgetCategory();
			if(categoryIds == null || categoryIds.length() == 0) {
				tran.rollback();
				return "input";
			}
			String[] categoryIdArray = categoryIds.replace(" ", "").split(",");

			
			for (int i = 0; i < categoryIdArray.length; i++) {
				GadgetCategory category = (GadgetCategory) hs.load(
						GadgetCategory.class, categoryIdArray[i]);
				newGadget.addCategory(category);
			}

			// for gadget publish
			GadgetPublish publish = new GadgetPublish();
			publish.setGadget(newGadget);

			hs.saveOrUpdate(publish);

			// for gadget icon
			GadgetIcon gadgetIcon = new GadgetIcon();
			gadgetIcon.setGadget(newGadget);
			if (getIconFileName() != null && getIconContentType() != null) {

				gadgetIcon.setName(getIconFileName());
				gadgetIcon.setContentType(getIconContentType());

				try {
					gadgetIcon.setContent(Hibernate
							.createBlob(new FileInputStream(icon)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					logger.error(e.getMessage());
					tran.rollback();
					return Action.INPUT;
				} 
				newGadget.setIconUrl("dummy");
			} else {
				gadgetIcon.setName("default");
				URL defaultIconUrl = new URL(defaultIconLocation);
				gadgetIcon.setContentType("image/jpeg");
				//try {
					gadgetIcon.setContent(Hibernate.createBlob(defaultIconUrl.openStream()));
				//} catch(FileNotFoundException e){
				//	logger.error(e.getMessage());
				//	tran.rollback();
				//	return Action.INPUT;
				//}
			}

			hs.saveOrUpdate(gadgetIcon);

			tran.commit();
			
		} catch (Exception e) {
			
			HibernateUtil.getSessionFactory().getCurrentSession()
					.getTransaction().rollback();
			e.printStackTrace();
			return "input";
		}

		return "preview";
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
