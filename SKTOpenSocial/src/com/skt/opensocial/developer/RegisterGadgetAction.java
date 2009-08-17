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
import org.apache.struts2.ServletActionContext;
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
 * 가젯 등록을 하기 위해 사용되는 액션 클래스
 * @author Ernest Lee
 * 
 */
// public class ListGadgetsAction extends ActionSupport implements RequestAware
// {
public class RegisterGadgetAction extends ManageGadgetAction {
	private static Logger logger = Logger.getLogger(RegisterGadgetAction.class);
	private static final long serialVersionUID = 1L;
	/**
	 * 기본 아이콘 파일의 이름
	 */
	private String defaultIconFile = null; // from action parameter in struts
											// configuration

	/**
	 * 가젯 등록 페이지를 호출하기 위하여 사용되는 액션 메소드
	 * @return 가젯 등록 페이지
	 * @throws Exception
	 */
	public String getGadgetRegisterPage() throws Exception {
		prepare();

		logger.info("RegisterType=" + getRegisterType());
		
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

	/**
	 * 가젯 등록을 완료하는 액션 메소드
	 * @return 가젯 등록 페이지
	 * @throws Exception
	 */
	public String finishGadgetRegister() throws Exception {

		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();

			Gadget gadget = (Gadget) hs.get(Gadget.class, gadgetId);
			gadget.setStatus(GadgetStatusConstants.REGISTERED);
			gadget.setRegisterDate(new Date());
			hs.save(gadget);
			tx.commit();
			return "gadget_list";
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

	}

	/**
	 * 가젯 등록을 하는 액션 메소드
	 * 가젯의 이름, 소개 등의 데이터를 이용하여 가젯을 시스템에 저장한다.
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {

		prepare();

		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			logger.info(">>>>>>>>>>>>>>>>>>>> Gadget Registration");
			logger.info(">>>>>>>>>>>>>>>>>>>> registerType="
					+ getRegisterType());
			logger.info(">>>>>>>>>>>>>>>>>>>> gadgetId=" + getGadgetId());
			logger.info(">>>>>>>>>>>>>>>>>>>> gadgetName=" + getGadgetName());
			logger.info(">>>>>>>>>>>>>>>>>>>> gadgetCategory="
					+ getGadgetCategory());
			logger.info(">>>>>>>>>>>>>>>>>>>> gadgetIntro=" + getGadgetIntro());
			logger.info(">>>>>>>>>>>>>>>>>>>> gadgetUrl=" + getGadgetUrl());
			// getGadgetSource());
			logger.info(">>>>>>>>>>>>>>>>>>>> gadgetStatus="
					+ getGadgetStatus());
			
			
			tx = hs.beginTransaction();

			Gadget newGadget = new Gadget();

			if (getGadgetName() == null || getGadgetName().equals("")) {
				tx.rollback();
				return "input";
			}
			newGadget.setName(getGadgetName());

			if (getGadgetIntro() == null || getGadgetIntro().equals("")) {
				tx.rollback();
				return "input";
			}
			newGadget.setIconUrl(getGadgetIconUrl());
			newGadget.setIntroduction(getGadgetIntro());
			newGadget.setStatus(GadgetStatusConstants.NOT_REGISTERED);

			if (getRegisterType() == null || getRegisterType().equals("")) {
				tx.rollback();
				return Action.INPUT;
			}

			setRegisterType(getRegisterType());
			if (registerType.equals(GadgetRegisterTypeConstants.SRC)) {
				if (getGadgetSource() == null
						|| getGadgetSource().length() == 0) {
					tx.rollback();
					return Action.INPUT;
				}
				newGadget.setGadgetSource(getGadgetSource());
			} else if (registerType.equals(GadgetRegisterTypeConstants.URL)) {
				if (getGadgetUrl() == null
						|| getGadgetUrl().trim().length() == 0) {
					tx.rollback();
					return Action.INPUT;
				}
				newGadget.setGadgetUrl(getGadgetUrl().trim());
			} else {
				tx.rollback();
				return Action.INPUT;
			}
			newGadget.setRegisterType(getRegisterType());

			User developer = (User) sessionMap
					.get(SKTOpenSocialSupportConstants.USER);
//			User developer = (User)hs.load(User.class, developerInSession.getId());
//			//hs.refresh(developer);
//			developer.setIsDeveloper(true); // for developer
			newGadget.setDeveloper(developer);
			

			
			gadgetId = (Long) hs.save(newGadget);
			
			developer = newGadget.getDeveloper();
			developer.setIsDeveloper(true);
			
			hs.saveOrUpdate(developer);
			

			setGadgetId(gadgetId);// ?
			sessionMap.put("GADGET_ID", gadgetId);// for preview
			// prepare categories
			String categoryIds = getGadgetCategory();
			if (categoryIds == null || categoryIds.length() == 0) {
				tx.rollback();
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
					tx.rollback();
					return Action.INPUT;
				}
				newGadget.setIconUrl("dummy");
			} else {
				gadgetIcon.setName("default");
				URL defaultIconUrl = new URL("http://"
						+ ServletActionContext.getRequest().getServerName()
						+ ":"
						+ ServletActionContext.getRequest().getServerPort()
						+ ServletActionContext.getRequest().getContextPath()
						+ defaultIconFile);
				gadgetIcon.setContentType("image/jpeg");
				// try {
				gadgetIcon.setContent(Hibernate.createBlob(defaultIconUrl
						.openStream()));
				// } catch(FileNotFoundException e){
				// logger.error(e.getMessage());
				// tran.rollback();
				// return Action.INPUT;
				// }
			}

			hs.saveOrUpdate(gadgetIcon);

			tx.commit();
			return "preview";
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

	}

	// for icon upload
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
	 * @return 아이콘 파일
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
	 * @param contentType 아이콘 파일의 컨텐트 유형
	 */
	public void setIconContentType(String contentType) {
		this.iconContentType = contentType;
	}

	/**
	 * 아이콘 파일의 이름을 가져온다
	 * @return 아이콘 파일의 이름
	 */
	public String getIconFileName() {
		return iconFileName;
	}

	/**
	 * 아이콘 파일의 이름을 셋팅한다
	 * @param iconFileName 아이콘 파일의 이름
	 */
	public void setIconFileName(String iconFileName) {
		this.iconFileName = iconFileName;
	}

	// end of icon file upload

	// for the static param of default icon location
	/**
	 * 기본 아이콘 파일의 이름을 가져온다
	 * @return 기본 아이콘 파일의 이름
	 */
	public String getDefaultIconFile() {
		return this.defaultIconFile;
	}

	/**
	 * 기본 아이콘 파일의 이름을 셋팅한다
	 * @param defaultIconFile 기본 아이콘 파일의 이름
	 */
	public void setDefaultIconFile(String defaultIconFile) {
		this.defaultIconFile = defaultIconFile;
	}

}
