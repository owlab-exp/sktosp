/**
 * 
 */
package com.skt.opensocial.developer;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
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
public class RegisterMultipleGadgetsAction extends ManageGadgetAction {
	private Logger logger = Logger
			.getLogger(RegisterMultipleGadgetsAction.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gadgetName1;
	private String gadgetCategory1;
	private String gadgetIntro1;
	private String gadgetUrl1;

	private String gadgetName2;
	private String gadgetCategory2;
	private String gadgetIntro2;
	private String gadgetUrl2;

	private String gadgetName3;
	private String gadgetCategory3;
	private String gadgetIntro3;
	private String gadgetUrl3;

	private String gadgetName4;
	private String gadgetCategory4;
	private String gadgetIntro4;
	private String gadgetUrl4;

	private String gadgetName5;
	private String gadgetCategory5;
	private String gadgetIntro5;
	private String gadgetUrl5;

	private String message;

	public String execute() throws Exception{
		prepare();

		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();

			if (validateName(gadgetName1))
				if (validateRow(gadgetName1, gadgetCategory1, gadgetIntro1,
						gadgetUrl1)) {
					registerGadget(gadgetName1, gadgetCategory1, gadgetIntro1,
							gadgetUrl1, hs);
				} else {
					message = "1번째 행에 빈 값이 있습니다";
					return Action.INPUT;
				}
			if (validateName(gadgetName2))
				if (validateRow(gadgetName2, gadgetCategory2, gadgetIntro2,
						gadgetUrl2)) {
					registerGadget(gadgetName2, gadgetCategory2, gadgetIntro2,
							gadgetUrl2, hs);
				} else {
					message = "2번째 행에 빈 값이 있습니다";
					tx.rollback();
					return Action.INPUT;
				}
			if (validateName(gadgetName3))
				if (validateRow(gadgetName3, gadgetCategory3, gadgetIntro3,
						gadgetUrl3)) {
					registerGadget(gadgetName3, gadgetCategory3, gadgetIntro3,
							gadgetUrl3, hs);
				} else {
					message = "3번째 행에 빈 값이 있습니다";
					tx.rollback();
					return Action.INPUT;
				}
			if (validateName(gadgetName4))
				if (validateRow(gadgetName4, gadgetCategory4, gadgetIntro4,
						gadgetUrl4)) {
					registerGadget(gadgetName4, gadgetCategory4, gadgetIntro4,
							gadgetUrl4, hs);
				} else {
					message = "4번째 행에 빈 값이 있습니다";
					tx.rollback();
					return Action.INPUT;
				}
			if (validateName(gadgetName5))
				if (validateRow(gadgetName5, gadgetCategory5, gadgetIntro5,
						gadgetUrl5)) {
					registerGadget(gadgetName5, gadgetCategory5, gadgetIntro5,
							gadgetUrl5, hs);
				} else {
					message = "5번째 행에 빈 값이 있습니다";
					tx.rollback();
					return Action.INPUT;
				}

			tx.commit();
			return Action.SUCCESS;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;

		}

	}

	private boolean validateName(String name) {
		if (name != null && name.length() > 0)
			return true;
		return false;
	}

	private boolean validateRow(String name, String category, String intro,
			String url) {
		if (name != null && name.length() > 0)
			if (category != null && category.length() > 0)
				if (intro != null && intro.length() > 0)
					if (url != null && url.length() > 0)
						return true;

		return false;
	}

	private void registerGadget(String name, String categoryId, String intro,
			String url, Session hs) {
		Gadget gadget = new Gadget();
		gadget.setName(name);
		gadget.setDeveloper((User) sessionMap
				.get(SKTOpenSocialSupportConstants.USER));

		Set<GadgetCategory> categories = new HashSet<GadgetCategory>();
		GadgetCategory category = (GadgetCategory) hs.get(GadgetCategory.class,
				categoryId);
		categories.add(category);

		gadget.setCategories(categories);
		gadget.setIntroduction(intro);
		gadget.setRegisterType(GadgetRegisterTypeConstants.URL);
		gadget.setStatus(GadgetStatusConstants.REGISTERED);
		gadget.setRegisterDate(new Date());
		// gadget.setSource(url);
		gadget.setGadgetUrl(url);

		hs.save(gadget);

		GadgetIcon gi = new GadgetIcon();
		gi.setGadget(gadget);

		hs.saveOrUpdate(gi);

		GadgetPublish gp = new GadgetPublish();
		gp.setGadget(gadget);

		hs.saveOrUpdate(gp);
	}

	public String getGadgetName1() {
		return gadgetName1;
	}

	public void setGadgetName1(String gadgetName1) {
		this.gadgetName1 = gadgetName1;
	}

	public String getGadgetCategory1() {
		return gadgetCategory1;
	}

	public void setGadgetCategory1(String gadgetCategory1) {
		this.gadgetCategory1 = gadgetCategory1;
	}

	public String getGadgetIntro1() {
		return gadgetIntro1;
	}

	public void setGadgetIntro1(String gadgetIntro1) {
		this.gadgetIntro1 = gadgetIntro1;
	}

	public String getGadgetUrl1() {
		return gadgetUrl1;
	}

	public void setGadgetUrl1(String gadgetUrl1) {
		this.gadgetUrl1 = gadgetUrl1;
	}

	public String getGadgetName2() {
		return gadgetName2;
	}

	public void setGadgetName2(String gadgetName2) {
		this.gadgetName2 = gadgetName2;
	}

	public String getGadgetCategory2() {
		return gadgetCategory2;
	}

	public void setGadgetCategory2(String gadgetCategory2) {
		this.gadgetCategory2 = gadgetCategory2;
	}

	public String getGadgetIntro2() {
		return gadgetIntro2;
	}

	public void setGadgetIntro2(String gadgetIntro2) {
		this.gadgetIntro2 = gadgetIntro2;
	}

	public String getGadgetUrl2() {
		return gadgetUrl2;
	}

	public void setGadgetUrl2(String gadgetUrl2) {
		this.gadgetUrl2 = gadgetUrl2;
	}

	public String getGadgetName3() {
		return gadgetName3;
	}

	public void setGadgetName3(String gadgetName3) {
		this.gadgetName3 = gadgetName3;
	}

	public String getGadgetCategory3() {
		return gadgetCategory3;
	}

	public void setGadgetCategory3(String gadgetCategory3) {
		this.gadgetCategory3 = gadgetCategory3;
	}

	public String getGadgetIntro3() {
		return gadgetIntro3;
	}

	public void setGadgetIntro3(String gadgetIntro3) {
		this.gadgetIntro3 = gadgetIntro3;
	}

	public String getGadgetUrl3() {
		return gadgetUrl3;
	}

	public void setGadgetUrl3(String gadgetUrl3) {
		this.gadgetUrl3 = gadgetUrl3;
	}

	public String getGadgetName4() {
		return gadgetName4;
	}

	public void setGadgetName4(String gadgetName4) {
		this.gadgetName4 = gadgetName4;
	}

	public String getGadgetCategory4() {
		return gadgetCategory4;
	}

	public void setGadgetCategory4(String gadgetCategory4) {
		this.gadgetCategory4 = gadgetCategory4;
	}

	public String getGadgetIntro4() {
		return gadgetIntro4;
	}

	public void setGadgetIntro4(String gadgetIntro4) {
		this.gadgetIntro4 = gadgetIntro4;
	}

	public String getGadgetUrl4() {
		return gadgetUrl4;
	}

	public void setGadgetUrl4(String gadgetUrl4) {
		this.gadgetUrl4 = gadgetUrl4;
	}

	public String getGadgetName5() {
		return gadgetName5;
	}

	public void setGadgetName5(String gadgetName5) {
		this.gadgetName5 = gadgetName5;
	}

	public String getGadgetCategory5() {
		return gadgetCategory5;
	}

	public void setGadgetCategory5(String gadgetCategory5) {
		this.gadgetCategory5 = gadgetCategory5;
	}

	public String getGadgetIntro5() {
		return gadgetIntro5;
	}

	public void setGadgetIntro5(String gadgetIntro5) {
		this.gadgetIntro5 = gadgetIntro5;
	}

	public String getGadgetUrl5() {
		return gadgetUrl5;
	}

	public void setGadgetUrl5(String gadgetUrl5) {
		this.gadgetUrl5 = gadgetUrl5;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
