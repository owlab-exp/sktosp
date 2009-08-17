/**
 * 
 */
package com.skt.opensocial.user;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Map;
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

/**	사용자가 가젯 정보를 조회하는 액션 클래스
 * @author 	Seong Yong Lim based on Ernest Lee's
 * @version 
 * @since	1.0
 * 
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class GadgetInfoAction extends ActivityBaseManager{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Map<String, Object> session;
		
	/**	출력되는 가젯 정보
	 *  
	 */	
	public Gadget gadget;
	public String name;
	public String introduction;
	public String categoryStringList;
	public String registerType;
	public String gadgetSource;
	public String gadgetIconUrl;
	public String status;
	
	private String developerId;
	private String ownerId;
	private String viewerId;
	
	private User user;
	/**	로그인 세션에 저장된 해당 사용자 아이디
	 *  
	 */	
	private String userId;
	
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}
	
	public Gadget getGadget() {
		return gadget;
	}

	public void setGadget(Gadget gadget) {
		this.gadget = gadget;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public String getRegisterType() {
		return registerType;
	}

	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}

	public String getGadgetSource() {
		return gadgetSource;
	}

	public void setGadgetSource(String gadgetSource) {
		this.gadgetSource = gadgetSource;
	}

	public String getGadgetIconUrl() {
		return gadgetIconUrl;
	}

	public void setGadgetIconUrl(String gadgetIconUrl) {
		this.gadgetIconUrl = gadgetIconUrl;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(String developerId) {
		this.developerId = developerId;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getViewerId() {
		return viewerId;
	}

	public void setViewerId(String viewerId) {
		this.viewerId = viewerId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setCategoryStringList(String categoryStringList) {
		this.categoryStringList = categoryStringList;
	}
	
	/** execute 메소드 에서는 사용자에게 가젯 정보를 출력한다.
	 * 
	 */
	public String execute() throws Exception{
		prepare();
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx = null;
		
		try
		{
			tx = hs.beginTransaction();
			User user = (User)session.get(SKTOpenSocialSupportConstants.USER);
			
			userId = user.getId();
			//user = (User) hs.load(User.class, userId);
			viewerId = userId;
			
			gadget = (Gadget) hs.load(Gadget.class, gadgetId);
			
			name = gadget.getName();
			introduction = gadget.getIntroduction();
			gadgetSource = gadget.getSource();
			registerType = gadget.getRegisterType();
			gadgetIconUrl = gadget.getIconUrl();
			status = gadget.getStatus();
			
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
			
	        //System.out.println("list count = " + categoryStringList);
			
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

			tx.commit();
			
			super.addActivity(ActivityTypeEnum.executeGadget, userId, "", gadgetId);
			
			return Action.SUCCESS;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

	}
	
	public String getCategoryStringList() {
		return categoryStringList;
	}

	public void setCategoryList(String categoryStringList) {
		this.categoryStringList = categoryStringList;
	}

	public String getModifyGadgetPage() throws Exception{
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
