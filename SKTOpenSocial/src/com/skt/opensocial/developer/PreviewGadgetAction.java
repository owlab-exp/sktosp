/**
 * 
 */
package com.skt.opensocial.developer;

import java.io.File;
import java.io.FileWriter;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.GadgetRegisterTypeConstants;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.HibernateUtil;

/**
 * 가젯 미리보기를 위한 액션 클래스이다.
 * @author Ernest Lee
 * 
 */
// public class ListGadgetsAction extends ActionSupport implements RequestAware
// {
public class PreviewGadgetAction extends ManageGadgetAction {
	private Logger logger = Logger.getLogger(PreviewGadgetAction.class);

	/**
	 * 개발자 ID 프로퍼티
	 */
	private String developerId;
	

	/** 
	 * 특정 가젯 ID에 해당하는 가젯 미리보기 페이지에 출력될 정보를 만들어주는 액션 메소드.
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception{

		logger.info("called");
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = hs.beginTransaction();

			Long gadgetIdTemp = getGadgetId();
			logger.info("Gadget ID from request=" + gadgetIdTemp);
			if (gadgetIdTemp == null) {
				logger.info("Examine sessionMap for gadgetId");
				gadgetIdTemp = (Long) sessionMap.get("GADGET_ID");
				if (gadgetIdTemp == null) {

					logger.warn("Gadget ID not found");
					return Action.ERROR;
				}
			}
			gadgetId = gadgetIdTemp;

			Gadget gadget = (Gadget) hs.get(Gadget.class, gadgetId);

			setDeveloperId(gadget.getDeveloper().getId());

			setGadgetId(gadget.getId());
			setGadgetStatus(gadget.getStatus());
			setGadgetName(gadget.getName());
			setRegisterType(gadget.getRegisterType());
			// setGadgetSource(gadget.getSource());
			if (registerType.equals(GadgetRegisterTypeConstants.URL)) {
				setGadgetUrl(gadget.getGadgetUrl());
			} else if (registerType.equals(GadgetRegisterTypeConstants.SRC)) {
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
				logger.info(gadgetXmlFile.getAbsolutePath());
				
				//Delete the file when JVM exits
				gadgetXmlFile.deleteOnExit();

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
				logger.info(gadgetXmlUrl);

				setGadgetUrl(gadgetXmlUrl);

			}

			tx.commit();
			return Action.SUCCESS;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;

		}

	}

	/**
	 * 개발자 ID를 가져온다
	 * @return 개발자 ID
	 */
	public String getDeveloperId() {
		return developerId;
	}

	/**
	 * 개발자 ID를 셋팅한다
	 * @param developerId 개발자 ID
	 */
	public void setDeveloperId(String developerId) {
		this.developerId = developerId;
	}

}
