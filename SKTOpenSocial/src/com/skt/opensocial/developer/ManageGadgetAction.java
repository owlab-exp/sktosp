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

/**
 * 가젯과 관련된 입출력 데이터들과 이 데이터를 처리하기 위한
 * Getter들과 Setter들이 정의되어있는 액션 클래스.
 * 
 * @author Ernest Lee
 *
 */
public class ManageGadgetAction extends DeveloperBaseAction implements
		RequestAware {
	private Logger logger = Logger.getLogger(RegisterGadgetAction.class);
	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	/**
	 * 가젯 등록 유형
	 */
	protected String registerType;
	/**
	 * 가젯 등록 유형의 맵
	 */
	protected Map<String, String> registerTypeMap;
	/**
	 * 가젯 ID
	 */
	protected Long gadgetId;
	/**
	 * 가젯 이름
	 */
	protected String gadgetName;
	/**
	 * 가젯 카테고리
	 */
	protected String gadgetCategory;
	/**
	 * 다중 선택된 가젯 카테고리
	 */
	protected String[] gadgetCategoryIdSelected;
	/**
	 * 가젯 소개
	 */
	protected String gadgetIntro;
	/**
	 * 가젯 소스
	 */
	protected String gadgetSource;
	/**
	 * 가젯 URL
	 */
	protected String gadgetUrl;
	/**
	 * 가젯 ICON URL
	 */
	protected String gadgetIconUrl;
	/**
	 * 가젯 상태
	 */
	protected String gadgetStatus;

	/**
	 * 가젯 카테고리 오브젝트의 리스트
	 */
	protected List<GadgetCategory> categoryList;

	/**
	 * HTTP Session을 참조하기위한 맵 오브젝트
	 */
	protected Map<String, Object> sessionMap;
	// private GadgetDataList gadgetDataList;

	/**
	 * HTTP Request를 참조하기 위한 맵 오브젝트
	 */
	protected Map<String, Object> requestMap;

	/**
	 * JSP 페이지에 나타날 카테고리 목록을 만든다.
	 * @throws Exception
	 */
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

	/**
	 * 가젯 상태를 가져온다
	 * @return 가젯 상태
	 */
	public String getGadgetStatus() {
		return this.gadgetStatus;
	}

	/**
	 * 가젯 상태를 셋팅한다
	 * @param gadgetStatus 가젯 상태
	 */
	public void setGadgetStatus(String gadgetStatus) {
		this.gadgetStatus = gadgetStatus;
	}

	/**
	 * 가젯 등록 유형을 가져온다
	 * @return 가젯 등록 유형
	 */
	public String getRegisterType() {
		return registerType;
	}

	/**
	 * 가젯 등록 유형을 셋팅한다
	 * @param registerType 가젯 등록 유형
	 */
	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}

	/** 
	 * 가젯 이름을 가져온다
	 * @return 가젯 이름
	 */
	public String getGadgetName() {
		return gadgetName;
	}

	/**
	 * 가젯 이름을 셋팅한다
	 * @param gadgetName 가젯 이름
	 */
	public void setGadgetName(String gadgetName) {
		this.gadgetName = gadgetName;
	}

	/**
	 * 가젯 카테고리를 가져온다
	 * @return 가젯 카테고리
	 */
	public String getGadgetCategory() {
		return gadgetCategory;
	}

	/**
	 * 가젯 카테고리를 셋팅한다
	 * @param gadgetCategory 가젯 카테고리
	 */
	public void setGadgetCategory(String gadgetCategory) {
		this.gadgetCategory = gadgetCategory;
	}

	/**
	 * 가젯 소개를 가져온다
	 * @return 가젯 소개
	 */
	public String getGadgetIntro() {
		return gadgetIntro;
	}

	/**
	 * 가젯 소개를 셋팅한다
	 * @param gadgetIntro 가젯 소개
	 */
	public void setGadgetIntro(String gadgetIntro) {
		this.gadgetIntro = gadgetIntro;
	}

	/**
	 * 가젯 카테고리 목록을 가져온다
	 * @return 가젯 카테고리 목록
	 */
	public List<GadgetCategory> getCategoryList() {
		return categoryList;
	}

	/**
	 * 가젯 카테고리 목록을 셋팅한다
	 * @param category 가젯 카테고리 목록
	 */
	public void setCategoryList(List<GadgetCategory> category) {
		this.categoryList = category;
	}

	/**
	 * 가젯 소스를 가져온다
	 * @return 가젯 소스
	 */
	public String getGadgetSource() {
		return gadgetSource;
	}

	/**
	 * 가젯 소스를 셋팅한다
	 * @param gadgetSource 가젯 소스
	 */
	public void setGadgetSource(String gadgetSource) {
		this.gadgetSource = gadgetSource;
	}

	/**
	 * 가젯 URL을 셋팅한다
	 * @return 가젯 URL
	 */
	public String getGadgetUrl() {
		return gadgetUrl;
	}

	/**
	 * 가젯 URL을 셋팅한다
	 * @param gadgetUrl 가젯 URL
	 */
	public void setGadgetUrl(String gadgetUrl) {
		this.gadgetUrl = gadgetUrl;
	}

	/**
	 * 가젯 등록 유형들을 가져온다
	 * @return 가젯 등록 유형 맵
	 */
	public Map<String, String> getRegisterTypeMap() {
		return registerTypeMap;
	}

	/**
	 * 가젯 등록 유형들을 셋팅한다
	 * @param registerTypeMap 가젯 등록 유형 맵
	 */
	public void setRegisterTypeMap(Map<String, String> registerTypeMap) {
		this.registerTypeMap = registerTypeMap;
	}

	/**
	 * 가젯 아이콘 URL을 가져온다
	 * @return 가젯 아이콘 URL
	 */
	public String getGadgetIconUrl() {
		return gadgetIconUrl;
	}

	/**
	 * 가젯 아이콘 URL을 셋팅한다
	 * @param gadgetIconUrl 가젯 아이콘 URL
	 */
	public void setGadgetIconUrl(String gadgetIconUrl) {
		this.gadgetIconUrl = gadgetIconUrl;
	}

	/**
	 * 가젯 ID를 가져온다
	 * @return 가젯 ID
	 */
	public Long getGadgetId() {
		return gadgetId;
	}

	/**
	 * 가젯 ID를 셋팅한다
	 * @param gadgetId 가젯 ID
	 */
	public void setGadgetId(Long gadgetId) {
		this.gadgetId = gadgetId;
	}

	/**
	 * 선택된 가젯 카테고리 목록을 가져온다
	 * @return 가젯 카테고리 목록
	 */
	public String[] getGadgetCategoryIdSelected() {
		return gadgetCategoryIdSelected;
	}

	/**
	 * 가젯 카테고리 목록을 셋팅한다
	 * @param gadgetCategoryIdSelected 선택된 가젯 카테고리 목록
	 */
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
