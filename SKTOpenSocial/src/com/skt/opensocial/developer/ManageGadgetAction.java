package com.skt.opensocial.developer;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.skt.opensocial.common.GadgetRegisterTypeMap;
import com.skt.opensocial.persistence.GadgetCategory;
import com.skt.opensocial.persistence.HibernateUtil;

public class ManageGadgetAction extends DeveloperBaseAction implements
		RequestAware {
	private Logger logger = Logger.getLogger(RegisterGadgetAction.class);
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
	protected String gadgetUrl;
	protected String gadgetIconUrl;
	protected String gadgetStatus;

	protected List<GadgetCategory> categoryList;

	protected Map<String, Object> sessionMap;
	// private GadgetDataList gadgetDataList;

	protected Map<String, Object> requestMap;

	public void prepare() throws Exception {
		if (categoryList == null) {
			Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {
				tx = hs.beginTransaction();

				List<GadgetCategory> categories = hs.createQuery(
						"from GadgetCategory").list();
				logger.log(Level.INFO, "category size = " + categories.size());

				categoryList = categories;
				tx.commit();
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				throw e;
			}

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

	public String getGadgetUrl() {
		return gadgetUrl;
	}

	public void setGadgetUrl(String gadgetUrl) {
		this.gadgetUrl = gadgetUrl;
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
		this.sessionMap = session;
	}

	@Override
	public void setRequest(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		this.requestMap = requestMap;
	}

}
