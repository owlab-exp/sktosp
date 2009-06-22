/**
 * 
 */
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

/**
 * @author Ernest Lee
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class RegisterGadgetAction extends ManageGadgetAction {
	private Logger logger = Logger.getLogger(RegisterGadgetAction.class); 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public String getGadgetRegisterPage() {
		prepare();
		
		setGadgetStatus(GadgetStatusConstants.NOT_REGISTERED);
		if(registerType == null) {
			registerType = GadgetRegisterTypeConstants.SRC;
		}
		
		if(registerType.equals(GadgetRegisterTypeConstants.URL_MULTI))
			return "input_multiple";
		else
			return "input_one";
		
	}
	public String finishGadgetRegister() {
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		Gadget gadget =(Gadget)hs.load(Gadget.class, gadgetId);
		gadget.setStatus(GadgetStatusConstants.REGISTERED);
		gadget.setRegisterDate(new Date());
		hs.save(gadget);
		hs.getTransaction().commit();
		
		return "gadget_list";
	}
	public String execute(){
		System.out.println(">>>>>>>>>>>>>>>>>>>> Gadget Registration");
		System.out.println(">>>>>>>>>>>>>>>>>>>> registerType=" + getRegisterType());
		//System.out.println(">>>>>>>>>>>>>>>>>>>> gadgetId=" + getGadgetId());
		System.out.println(">>>>>>>>>>>>>>>>>>>> gadgetName=" + getGadgetName());
		System.out.println(">>>>>>>>>>>>>>>>>>>> gadgetCategory=" + getGadgetCategory());
		System.out.println(">>>>>>>>>>>>>>>>>>>> gadgetIntro=" + getGadgetIntro());
		System.out.println(">>>>>>>>>>>>>>>>>>>> gadgetSource=" + getGadgetSource());
		System.out.println(">>>>>>>>>>>>>>>>>>>> gadgetStatus=" + getGadgetStatus());
		
		prepare();
		
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		hs.beginTransaction();
		
		Gadget newGadget = new Gadget();
		
		
		if(getGadgetName() == null || getGadgetName().equals(""))// return to input page
			return "input";
		// prepare saving new gadget
		newGadget.setName(getGadgetName());
		newGadget.setIconUrl(getGadgetIconUrl());
		newGadget.setIntroduction(getGadgetIntro());
		newGadget.setSource(getGadgetSource());
		newGadget.setStatus(GadgetStatusConstants.NOT_REGISTERED);
		newGadget.setRegisterType(getRegisterType());
		newGadget.setDeveloper((User)session.get(SKTOpenSocialSupportConstants.USER));
		
		gadgetId = (Long) hs.save(newGadget);
		
		// prepare categories
		String categoryIds = getGadgetCategory();
		String[] categoryIdArray = categoryIds.replace(" ", "").split(",");
		
		for(int i = 0; i < categoryIdArray.length; i++) {
			GadgetCategory category = (GadgetCategory)hs.load(GadgetCategory.class, categoryIdArray[i]);
			newGadget.addCategory(category);
		}
		
		hs.getTransaction().commit();
		
		// get gadget list from session
		/*GadgetDataList gadgetDataListS = (GadgetDataList)session.get("gadgets");
		if(gadgetDataList == null) {
			session.put("gadgets", new GadgetDataList());
			this.gadgetDataList = (GadgetDataList)session.get("gadgets");
		} else {
			this.gadgetDataList = gadgetDataListS;
		}
		
		// put new gadget into gadget list
		GadgetData aGadget = new GadgetData();
		aGadget.setGadgetId(gadgetId);
		aGadget.setGadgetName(gadgetName);
		aGadget.setGadgetCategory(gadgetCategory);
		aGadget.setGadgetIntro(gadgetIntro);
		aGadget.setGadgetStatus(gadgetStatus);
		aGadget.setGadgetSource(gadgetSource);
		aGadget.setRegisterType(registerType);

		gadgetDataList.addNewGadgetData(gadgetId, aGadget);*/
		
		return "preview";
	}
	
}
