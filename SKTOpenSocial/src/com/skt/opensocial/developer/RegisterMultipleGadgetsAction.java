/**
 * 
 */
package com.skt.opensocial.developer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.xml.sax.SAXException;

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
 * 다중 URL을 이용한 가젯 등록을 처리하는 액션 클래스
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

	/**
	 * 기본 아이콘 파일 이름
	 */
	private String defaultIconFile = null;
	
	/**
	 * 첫번째 가젯 이름
	 */
	private String gadgetName1;
	/**
	 * 첫번째 가젯 카테고리
	 */
	private String gadgetCategory1;
	/**
	 * 첫번째 가젯 소개
	 */
	private String gadgetIntro1;
	/**
	 * 첫번째 가젯 URL
	 */
	private String gadgetUrl1;

	/**
	 * 두번째 가젯 이름
	 */
	private String gadgetName2;
	/**
	 * 두번째 가젯 카테고리
	 */
	private String gadgetCategory2;
	/**
	 * 두번째 가젯 소개
	 */
	private String gadgetIntro2;
	/**
	 * 두번째 가젯 URL
	 */
	private String gadgetUrl2;

	/**
	 * 세번째 가젯 이름
	 */
	private String gadgetName3;
	/**
	 * 세번째 가젯 카테고리
	 */
	private String gadgetCategory3;
	/**
	 * 세번째 가젯 소개
	 */
	private String gadgetIntro3;
	/**
	 * 세번째 가젯 URL
	 */
	private String gadgetUrl3;

	/**
	 * 네번째 가젯 이름
	 */
	private String gadgetName4;
	/**
	 * 네번째 가젯 카테고리
	 */
	private String gadgetCategory4;
	/**
	 * 네번째 가젯 소개
	 */
	private String gadgetIntro4;
	/**
	 * 네번째 가젯 URL
	 */
	private String gadgetUrl4;

	/**
	 * 다섯번째 가젯 이름
	 */
	private String gadgetName5;
	/**
	 * 다섯번째 가젯 카테고리
	 */
	private String gadgetCategory5;
	/**
	 * 다섯번째 가젯 소개
	 */
	private String gadgetIntro5;
	/**
	 * 다섯번째 가젯 URL
	 */
	private String gadgetUrl5;

	private StringBuffer messageBuff = new StringBuffer();

	/**
	 * 최대 다섯개의 가젯을 등록하기 위한 다중 가젯 등록 액션 메소드
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
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
					messageBuff.append("1번째 행의 값이 잘못되었습니다.");
					tx.rollback();
					return Action.INPUT;
				}
//			else {
//				message = "1번째 가젯의 이름이 주어지지 않았습니다.";
//				tx.rollback();
//				return Action.INPUT;
//			}
			if (validateName(gadgetName2))
				if (validateRow(gadgetName2, gadgetCategory2, gadgetIntro2,
						gadgetUrl2)) {
					registerGadget(gadgetName2, gadgetCategory2, gadgetIntro2,
							gadgetUrl2, hs);
				} else {
					messageBuff.append("2번째 행의 값이 잘못되었습니다.");
					tx.rollback();
					return Action.INPUT;
				}
//			else {
//				message = "2번째 가젯의 이름이 주어지지 않았습니다.";
//				tx.rollback();
//				return Action.INPUT;
//			}
			if (validateName(gadgetName3))
				if (validateRow(gadgetName3, gadgetCategory3, gadgetIntro3,
						gadgetUrl3)) {
					registerGadget(gadgetName3, gadgetCategory3, gadgetIntro3,
							gadgetUrl3, hs);
				} else {
					messageBuff.append("3번째 행의 값이 잘못되었습니다.");
					tx.rollback();
					return Action.INPUT;
				}
//			else {
//				message = "3번째 가젯의 이름이 주어지지 않았습니다.";
//				tx.rollback();
//				return Action.INPUT;
//			}
			if (validateName(gadgetName4))
				if (validateRow(gadgetName4, gadgetCategory4, gadgetIntro4,
						gadgetUrl4)) {
					registerGadget(gadgetName4, gadgetCategory4, gadgetIntro4,
							gadgetUrl4, hs);
				} else {
					messageBuff.append("4번째 행의 값이 잘못되었습니다.");
					tx.rollback();
					return Action.INPUT;
				}
//			else {
//				message = "4번째 가젯의 이름이 주어지지 않았습니다.";
//				tx.rollback();
//				return Action.INPUT;
//			}
			if (validateName(gadgetName5))
				if (validateRow(gadgetName5, gadgetCategory5, gadgetIntro5,
						gadgetUrl5)) {
					registerGadget(gadgetName5, gadgetCategory5, gadgetIntro5,
							gadgetUrl5, hs);
				} else {
					messageBuff.append("5번째 행의 값이 잘못되었습니다.");
					tx.rollback();
					return Action.INPUT;
				}
//			else {
//				message = "5번째 가젯의 이름이 주어지지 않았습니다.";
//				tx.rollback();
//				return Action.INPUT;
//			}

			tx.commit();
			return Action.SUCCESS;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;

		}

	}

	
	/**
	 * 가젯의 이름이 주어졌는지를 확인하기 위한 메소드
	 * @param name 가젯 이름
	 * @return true 또는 false
	 */
	private boolean validateName(String name) {
		if (name != null && name.length() > 0)
			return true;
		return false;
	}

	/**
	 * 가젯 입력 행의 모든 필드가 채워졌는지를 확인하기 위한 메소드
	 * @param name 가젯 이름
	 * @param category 가젯 카테고리
	 * @param intro 가젯 소개
	 * @param url 가젯 URL
	 * @return true 또는 false
	 */
	private boolean validateRow(String name, String category, String intro,
			String url) {
		if (name != null && name.trim().length() > 0)
			if (category != null && category.length() > 0)
				if (intro != null && intro.length() > 0)
					if (url != null && url.length() > 0 && validateGadgetXMLUrl(url))
						return true;

		return false;
	}

	/**
	 * 가젯 XML 의 문법을 체크하기 위한 메소드
	 * @param url 가젯 XML URL
	 * @return true 또는 false
	 */
	private boolean validateGadgetXMLUrl(String url){
		String gadgetUrl = null;
		StringBuffer resultBuffer = new StringBuffer(); 
		boolean isValid = true;
		try {
			// TODO Auto-generated method stub

			// 1. Lookup a factory for the W3C XML Schema language
			SchemaFactory factory = SchemaFactory
					.newInstance("http://www.w3.org/2001/XMLSchema");

			// 2. Compile the schema.
			// Here the schema is loaded from a java.io.File, but you could use
			// a java.net.URL or a javax.xml.transform.Source instead.
			// File schemaLocation8 = new File("src/gadgets-extended-0.8.xsd");
//			URL schemaLocationForCanonical = new URL(
//					"http://localhost:8080/SKTOpenSocial/gadget/gadgets-canonical-0.8.xsd");

			URL schemaLocationForExtended = new URL(
					"http://localhost:8080/SKTOpenSocial/gadget/gadgets-extended-0.8.xsd");

//			Schema schemaForCanonical = factory.newSchema(schemaLocationForCanonical);

			Schema schemaForExtended = factory.newSchema(schemaLocationForExtended);

			// 3. Get a validator from the schema.
//			Validator validatorForCanonical = schemaForCanonical.newValidator();
			Validator validatorForExtended = schemaForExtended.newValidator();

			// 4. Parse the document you want to check.
			// Source source = new StreamSource(args[0]);
			// String gadgetFileName = "src/ComplianceTest.xml";
			// Source source = new StreamSource(gadgetFileName);
			gadgetUrl = url;
			Source source = new StreamSource(gadgetUrl);

			// 5. Check the document

//			validatorForCanonical.validate(source);
//			System.out.println(gadgetUrl
//					+ " is valid, by gadgets-canonical-0.8.xsd");

			validatorForExtended.validate(source);
			logger.info(gadgetUrl
					+ " is valid, by gadgets-extended-0.8.xsd");
			resultBuffer.append("The gadget xml is valid, by gadgets-extended-0.8.xsd");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			logger.warn("URL problem: " + e.getMessage());
			resultBuffer.append("URL problem: " + e.getMessage());
			isValid = false;
		} catch (SAXException e) {
			logger.warn("The gadget xml has problem: " + e.getMessage());
			resultBuffer.append("The gadget xml has problem: " + e.getMessage());
			isValid = false;
		} catch (FileNotFoundException e) {
			logger.warn("No such file: " + e.getMessage());
			resultBuffer.append("No such file: " + e.getMessage());
			isValid = false;
		} catch (IOException e) {
			logger.warn("IO error: " + e.getMessage());
			resultBuffer.append("IO error: " + e.getMessage());
			isValid = false;
		}
		this.messageBuff.append(resultBuffer.toString() + ": ");
		return isValid;
	}
	/**
	 * 하나의 가젯을 등록하기 위한 메소드
	 * @param name 가젯 이름
	 * @param categoryId 가젯 ID
	 * @param intro 가젯 소개
	 * @param url 가젯 URL
	 * @param hs HTTP Session (개발자의 ID를 가져오기 위한 것)
	 * @throws Exception
	 */
	private void registerGadget(String name, String categoryId, String intro,
			String url, Session hs) throws Exception {
		Gadget gadget = new Gadget();
		gadget.setName(name);
		
		User developer = (User) sessionMap
		.get(SKTOpenSocialSupportConstants.USER);
		
		developer.setIsDeveloper(true);
		hs.update(developer);
		
		gadget.setDeveloper(developer);

		
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
		gadget.setGadgetUrl(url.trim());

		hs.save(gadget);

		GadgetIcon gi = new GadgetIcon();
		gi.setGadget(gadget);
		gi.setName("default");
		URL defaultIconUrl = new URL("http://"
				+ ServletActionContext.getRequest().getServerName()
				+ ":"
				+ ServletActionContext.getRequest().getServerPort()
				+ ServletActionContext.getRequest().getContextPath()
				+ defaultIconFile);
		gi.setContentType("image/jpeg");
		// try {
		gi.setContent(Hibernate.createBlob(defaultIconUrl
				.openStream()));
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
		return messageBuff.toString();
	}

	public void setMessage(String message) {
		this.messageBuff = new StringBuffer();
		this.messageBuff.append(message);
	}

	public String getDefaultIconFile() {
		return defaultIconFile;
	}

	public void setDefaultIconFile(String defaultIconFile) {
		this.defaultIconFile = defaultIconFile;
	}

}
