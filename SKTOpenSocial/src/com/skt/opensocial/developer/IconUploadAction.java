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
 * 아이콘 파일을 업로드하여 데이터베이스에 저장하기 위한 액션 클래스이다.
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

	/**
	 * 아이콘 파일
	 */
	private File icon;
	/**
	 * 아이콘 파일의 컨텐트 유형
	 */
	private String iconContentType;
	/**
	 * 아이콘 파일의 이름
	 */
	private String iconFileName;

	/**
	 * 아이콘 파일을 가져온다
	 * @return 아이콘 파일 오브젝트
	 */
	public File getIcon() {
		return icon;
	}

	/**
	 * 아이콘 파일을 셋팅한다
	 * @param file 아이콘 파일
	 */
	public void setIcon(File file) {
		this.icon = file;
	}

	/**
	 * 아이콘 파일의 컨텐트 유형을 가져온다
	 * @return 아이콘 파일의 컨텐트 유형
	 */
	public String getIconContentType() {
		return iconContentType;
	}

	/**
	 * 아이콘 파일의 컨텐트 유형을 셋팅한다
	 * @param contentType 컨텐트 유형
	 */
	public void setIconContentType(String contentType) {
		this.iconContentType = contentType;
	}

	/**
	 * 아이콘 파일의 이름을 가져온다
	 * @return 아이콘 파일 이름
	 */
	public String getIconFileName() {
		return iconFileName;
	}

	/**
	 * 아이콘 파일의 이름을 셋팅한다
	 * @param iconFileName 아이콘 파일 이름
	 */
	public void setIconFileName(String iconFileName) {
		this.iconFileName = iconFileName;
	}

	/**
	 * 가젯을 저장하고 저장된 가젯을 위한 아이콘을 업로드하는 액션 메소드
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception{
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
		
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();
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

			if (getGadgetId() != null) {
				hs.saveOrUpdate(newGadget);
			} else {
				gadgetId = (Long) hs.save(newGadget);
				setGadgetId(gadgetId);
			}

			GadgetIcon gadgetIcon = new GadgetIcon();
			gadgetIcon.setGadget(newGadget);
			gadgetIcon.setName(getIconFileName());
			gadgetIcon.setContentType(getIconContentType());
			gadgetIcon.setContent(Hibernate
					.createBlob(new FileInputStream(icon)));

			hs.saveOrUpdate(gadgetIcon);
			tx.commit();
			return Action.SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			if(tx!= null)tx.rollback();
			return Action.INPUT;
		}
		
	}
}
