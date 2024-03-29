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
 * 가젯을 수정할 때 사용되는 액션 클래스
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


	/** 
	 * 가젯을 수정한 후, 미리보기 페이지로 전환하기 위한 액션 메소드
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception{
		prepare();

		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();

			Gadget gadget = (Gadget) hs.get(Gadget.class, gadgetId);

			gadget.setName(getGadgetName());

			setGadgetId(gadgetId);// ??
			// sessionMap.put("modifiedGadgetId", gadgetId);// temporal
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

				gadgetIcon.setContent(Hibernate.createBlob(new FileInputStream(
						icon)));

				gadget.setIconUrl("exist");
				hs.saveOrUpdate(gadgetIcon);
				// end for gadget icon
			}
			tx.commit();
			return "preview";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			if (tx != null)
				tx.rollback();
			return Action.INPUT;
		}

	}

	/**
	 * 가젯 수정을 위한 페이지에 출력될 내용을 생성한다.
	 * @return 가젯 수정 페이지
	 * @throws Exception
	 */
	public String getModifyGadgetPage() throws Exception {
		prepare();

		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();

			Gadget gadget = (Gadget) hs.get(Gadget.class, gadgetId);

			setGadgetId(gadget.getId());
			setGadgetName(gadget.getName());
			//
			Set<GadgetCategory> categories = gadget.getCategories();

			// for(Iterator<CadgetCategory> it: )
			GadgetCategory[] categoryArray = new GadgetCategory[categories
					.size()];
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

			tx.commit();
			return "input";
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
	 * 아이콘 파일 컨텐트 유형
	 */
	private String iconContentType;
	/**
	 * 아이콘 파일 이름
	 */
	private String iconFileName;

	/**
	 * 아이콘 파일 객체를 가져온다.
	 * @return 아이콘 파일
	 */
	public File getIcon() {
		return icon;
	}

	/**
	 * 아이콘 파일을 셋팅한다.
	 * @param file 아이콘 파일
	 */
	public void setIcon(File file) {
		this.icon = file;
	}

	/**
	 * 아이콘 파일의 컨텐트 유형을 가져온다.
	 * @return 아이콘 파일의 컨텐트 유형
	 */
	public String getIconContentType() {
		return iconContentType;
	}

	/**
	 *  아이콘 파일의 컨텐트 유형을 셋팅한다.
	 * @param contentType 아이콘 파일의 컨텐트 유형
	 */
	public void setIconContentType(String contentType) {
		this.iconContentType = contentType;
	}

	/**
	 * 아이콘 파일의 이름을 가져온다.
	 * @return 아이콘 파일의 이름
	 */
	public String getIconFileName() {
		return iconFileName;
	}

	/**
	 * 아이콘 파일의 이름을 셋팅한다.
	 * @param iconFileName 아이콘 파일의 이름
	 */
	public void setIconFileName(String iconFileName) {
		this.iconFileName = iconFileName;
	}
	// end of icon file upload
}
