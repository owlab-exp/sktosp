package com.skt.opensocial.developer;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.classic.Session;

import com.skt.opensocial.common.GadgetRegisterTypeConstants;
import com.skt.opensocial.common.GadgetRegisterTypeMap;
import com.skt.opensocial.common.GadgetStatusConstants;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetCategory;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

public class ManageGadgetAction extends DeveloperBaseAction {
	protected Logger logger = Logger.getLogger(RegisterGadgetAction.class);
	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	protected String registerType;
	protected Map<String, String> registerTypeMap;
	protected Long gadgetId;
	protected String gadgetName;
	protected String gadgetCategory;
	protected String[] gadgetCategoryIdSelected;
	protected String gadgetIntro;
	protected String gadgetSource;
	protected String gadgetIconUrl;
	protected String gadgetStatus;

	protected List<GadgetCategory> categoryList;

	protected Map<String, Object> session;
	//private GadgetDataList gadgetDataList;

	public void prepare() {
		if (categoryList == null) {
			Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
			hs.beginTransaction();
			List<GadgetCategory> categories = hs.createQuery(
					"from GadgetCategory").list();
			logger.log(Level.INFO, "category size = " + categories.size());

			categoryList = categories;
			hs.getTransaction().commit();

		}
		registerTypeMap = new GadgetRegisterTypeMap();
	}

	public String getGadgetStatus() {
		return this.gadgetStatus;
	}

	public void setGadgetStatus(String gadgetStatus) {
		this.gadgetStatus = gadgetStatus;
	}

	public String getRegisterType() {
		return registerType;
	}

	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}

	public String getGadgetName() {
		return gadgetName;
	}

	public void setGadgetName(String gadgetName) {
		this.gadgetName = gadgetName;
	}

	public String getGadgetCategory() {
		return gadgetCategory;
	}

	public void setGadgetCategory(String gadgetCategory) {
		this.gadgetCategory = gadgetCategory;
	}

	public String getGadgetIntro() {
		return gadgetIntro;
	}

	public void setGadgetIntro(String gadgetIntro) {
		this.gadgetIntro = gadgetIntro;
	}

	public List<GadgetCategory> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<GadgetCategory> category) {
		this.categoryList = category;
	}

	public String getGadgetSource() {
		return gadgetSource;
	}

	public void setGadgetSource(String gadgetSource) {
		this.gadgetSource = gadgetSource;
	}

	public Map<String, String> getRegisterTypeMap() {
		return registerTypeMap;
	}

	public void setRegisterTypeMap(Map<String, String> registerTypeMap) {
		this.registerTypeMap = registerTypeMap;
	}

	public String getGadgetIconUrl() {
		return gadgetIconUrl;
	}

	public void setGadgetIconUrl(String gadgetIconUrl) {
		this.gadgetIconUrl = gadgetIconUrl;
	}

	public Long getGadgetId() {
		return gadgetId;
	}

	public void setGadgetId(Long gadgetId) {
		this.gadgetId = gadgetId;
	}
	
	public String[] getGadgetCategoryIdSelected() {
		return gadgetCategoryIdSelected;
	}

	public void setGadgetCategoryIdSelected(String[] gadgetCategoryIdSelected) {
		this.gadgetCategoryIdSelected = gadgetCategoryIdSelected;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}
