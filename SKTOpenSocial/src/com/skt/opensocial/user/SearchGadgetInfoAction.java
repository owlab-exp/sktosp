/**
 * 
 */
package com.skt.opensocial.user;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.hibernate.classic.Session;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.GadgetRegisterTypeConstants;
import com.skt.opensocial.common.SKTOpenSocialSupportConstants;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetCategory;
import com.skt.opensocial.persistence.HibernateUtil;
import com.skt.opensocial.persistence.User;

/**
 * 가젯의 상세정보를 조회하기 위한 액션 클래스
 * @author Seong yong Lim based on Ernest Lee's
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class SearchGadgetInfoAction extends ActivityBaseManager{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 가젯 오브젝트
	 */
	public Gadget gadget;
	/**
	 * 가젯 이름
	 */
	public String name;
	/**
	 * 가젯 소개
	 */
	public String introduction;
	/**
	 * 가젯 카테코리 목록
	 */
	public String categoryStringList;
	/**
	 * 가젯 등록 유형
	 */
	public String registerType;
	public String gadgetSource;
	public String gadgetIconUrl;

	/**
	 * 가젯 개발자 ID
	 */
	private String developerId;
	/**
	 * 이 가젯이 포함된 선호가젯 목록을 소유한 사용자 ID
	 */
	private String ownerId;
	/**
	 * 이 가젯을 (특정 사용자의 선호가젯 목록으로부터) 조회한 사용자 ID
	 */
	private String viewerId;
	
	/**
	 * 사용자 오브젝트
	 */
	private User user;
	/**
	 * 사용자 ID
	 */
	private String userId;
	private String status;
	
	/**
	 * 조회하는 사용자의 선호가젯에 포함되어있는지 여부
	 */
	private String flagFavorite = "false";
	
	/**
	 * 조회하는 사용자의 선호가젯에 포함되어있는지 여부를 가져온다
	 * @return
	 */
	public String getFlagFavorite() {
		return flagFavorite;
	}

	/**
	 * 조회하는 사용자의 선호가젯에 포함되어있는지 여부를 셋팅한다
	 * @param flagFavorite
	 */
	public void setFlagFavorite(String flagFavorite) {
		this.flagFavorite = flagFavorite;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 개발자 ID를 가져온다
	 * @return
	 */
	public String getDeveloperId() {
		return developerId;
	}

	/**
	 * 개발자 ID를 셋팅한다
	 * @param developerId
	 */
	public void setDeveloperId(String developerId) {
		this.developerId = developerId;
	}

	/**
	 * 선호가젯 목록의 소유자 ID를 가져온다
	 * @return
	 */
	public String getOwnerId() {
		return ownerId;
	}

	/**
	 * 선호가젯 목록의 소유자 ID를 셋팅한다
	 * @param ownerId
	 */
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * 조회하는 사용자 ID를 가져온다
	 * @return
	 */
	public String getViewerId() {
		return viewerId;
	}

	/**
	 * 조회하는 사용자의 ID를 셋팅한다
	 * @param viewerId
	 */
	public void setViewerId(String viewerId) {
		this.viewerId = viewerId;
	}

	/**
	 * 사용자 오브젝트를 가져온다
	 * @return
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 사용자 오브젝트를 셋팅한다
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see com.skt.opensocial.common.CommonBaseAction#getUserId()
	 */
	public String getUserId() {
		return userId;
	}

	/* (non-Javadoc)
	 * @see com.skt.opensocial.common.CommonBaseAction#setUserId(java.lang.String)
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 가젯 오브젝트를 가져온다
	 * @return
	 */
	public Gadget getGadget() {
		return gadget;
	}

	/**
	 * 가젯 오브젝트를 셋팅한다
	 * @param gadget
	 */
	public void setGadget(Gadget gadget) {
		this.gadget = gadget;
	}

	/**
	 * 가젯 이름을 가져온다
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 가젯 이름을 셋팅한다
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 가젯 소개를 가져온다
	 * @return
	 */
	public String getIntroduction() {
		return introduction;
	}

	/**
	 * 가젯 소개를 셋팅한다
	 * @param introduction
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	/* (non-Javadoc)
	 * @see com.skt.opensocial.developer.ManageGadgetAction#getRegisterType()
	 */
	public String getRegisterType() {
		return registerType;
	}

	/* (non-Javadoc)
	 * @see com.skt.opensocial.developer.ManageGadgetAction#setRegisterType(java.lang.String)
	 */
	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}

	/* (non-Javadoc)
	 * @see com.skt.opensocial.developer.ManageGadgetAction#getGadgetSource()
	 */
	public String getGadgetSource() {
		return gadgetSource;
	}

	/* (non-Javadoc)
	 * @see com.skt.opensocial.developer.ManageGadgetAction#setGadgetSource(java.lang.String)
	 */
	public void setGadgetSource(String gadgetSource) {
		this.gadgetSource = gadgetSource;
	}

	/* (non-Javadoc)
	 * @see com.skt.opensocial.developer.ManageGadgetAction#getGadgetIconUrl()
	 */
	public String getGadgetIconUrl() {
		return gadgetIconUrl;
	}

	/* (non-Javadoc)
	 * @see com.skt.opensocial.developer.ManageGadgetAction#setGadgetIconUrl(java.lang.String)
	 */
	public void setGadgetIconUrl(String gadgetIconUrl) {
		this.gadgetIconUrl = gadgetIconUrl;
	}
	
	

	/**
	 * 가젯의 상세정보를 조회하기 위한 액션 메소드
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception{
		prepare();
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx = null;
		
		try
		{
			tx = hs.beginTransaction();
			System.out.println("Flag of searched gadget = 000" );		
			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
			
			userId = user.getId();
			user = (User) hs.load(User.class, userId);
			viewerId = userId;
						
			gadget = (Gadget) hs.load(Gadget.class, gadgetId);
			
			
			name = gadget.getName();
			introduction = gadget.getIntroduction();
			gadgetSource = gadget.getSource();
			registerType = gadget.getRegisterType();
			gadgetIconUrl = gadget.getIconUrl();
			status = gadget.getStatus();
			
			if (user.getFavoriteGadgets().contains(gadget))
				flagFavorite = "true";
			
			System.out.println("Flag of searched gadget = " + flagFavorite);
			
			Set<GadgetCategory> categorySet = gadget.getCategories();
			
			Iterator<GadgetCategory> it = categorySet.iterator();
			
			categoryStringList = "";
			
			while (it.hasNext()) {
			        // Get element
			        GadgetCategory element = it.next();
			        //System.out.println("list count = " + element.getName() + element.getId());
			        if (!categoryStringList.isEmpty())
			        {
			        	categoryStringList = categoryStringList.concat(",");
			        }
			        categoryStringList = categoryStringList.concat(element.getName()); 
			        //System.out.println("list count = " + categoryStringList);
			}
			
			setDeveloperId(gadget.getDeveloper().getId());

			setGadgetId(gadget.getId());

			// setGadgetSource(gadget.getSource());
			if (registerType.equals(GadgetRegisterTypeConstants.URL)) 
			{
				setGadgetUrl(gadget.getGadgetUrl());
			} 
			else if (registerType.equals(GadgetRegisterTypeConstants.SRC)) 
			{
				// do nothing here, but JSP should have some logic to handle the
				// source
				String developerId = gadget.getDeveloper().getId();
				Long gadgetId = gadget.getId();

				String realDirPath = ServletActionContext.getServletContext()
						.getRealPath("/gadget");
				String gadgetXmlFileName = developerId + "-" + gadgetId
						+ ".xml";

				File gadgetXmlFile = new File(realDirPath + "/"
						+ gadgetXmlFileName);
				//logger.info(gadgetXmlFile.getAbsolutePath());

				FileWriter fw = new FileWriter(gadgetXmlFile);
				fw.write(gadget.getGadgetSource());
				fw.flush();
				fw.close();

				StringBuffer gadgetXmlUrlBuff = new StringBuffer("http://");
				gadgetXmlUrlBuff.append(ServletActionContext.getRequest()
						.getServerName());
				gadgetXmlUrlBuff.append(":");
				gadgetXmlUrlBuff.append(ServletActionContext.getRequest()
						.getServerPort());
				// gadgetXmlUrlBuff.append("/");
				gadgetXmlUrlBuff.append(ServletActionContext.getRequest()
						.getContextPath());
				gadgetXmlUrlBuff.append("/gadget");
				gadgetXmlUrlBuff.append("/" + gadgetXmlFileName);

				String gadgetXmlUrl = gadgetXmlUrlBuff.toString();
				//logger.info(gadgetXmlUrl);

				setGadgetUrl(gadgetXmlUrl);

			}
			hs.saveOrUpdate(gadget);
			
			tx.commit();
			
			return Action.SUCCESS;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}
	
	/**
	 * 가젯 카테고리 목록을 가져온다
	 * @return
	 */
	public String getCategoryStringList() {
		return categoryStringList;
	}

	/**
	 * 가젯 카테고리 목록을 셋팅한다
	 * @param categoryStringList
	 */
	public void setCategoryList(String categoryStringList) {
		this.categoryStringList = categoryStringList;
	}

	public String getModifyGadgetPage()throws Exception{
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
