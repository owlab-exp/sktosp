/**
 * 
 */
package com.skt.opensocial.developer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.Action;
import com.skt.opensocial.common.GadgetRegisterTypeConstants;
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.HibernateUtil;

/**
 * @author Ernest Lee
 * 
 */
// public class ListGadgetsAction extends ActionSupport implements RequestAware
// {
public class GetGadgetUrlAction extends ManageGadgetAction {
	private Logger logger = Logger.getLogger(GetGadgetUrlAction.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String contentType;
	private Long contentLength;
	private String contentDisposition;
	private String inputName = "inputStream";
	private InputStream inputStream;
	private int bufferSize = 1024;
	private boolean allowCaching;

	public String execute() {

		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tran = hs.beginTransaction();

		// Get a gadget by id;
		Gadget gadget = (Gadget) hs.get(Gadget.class, getGadgetId());
		
		logger.info("Gadget ID=" + gadgetId);
		
		String gadgetSource = gadget.getGadgetSource(); 
		String registerType = gadget.getRegisterType();
		
		if(registerType.equals(GadgetRegisterTypeConstants.URL)){
			// the source of the gadget is already the very url
			//
		}
		if(gadgetSource == null) {
			// gadget source is null
		}
		if(registerType.equals(GadgetRegisterTypeConstants.SRC)){
			setContentType("text/xml");
			setContentDisposition(gadget.getName() + ".xml");
			byte[] sourceBytes = gadgetSource.getBytes();
			setInputStream(new ByteArrayInputStream(sourceBytes));
			setContentLength(new Long(sourceBytes.length));
		}
		
		tran.commit();
		
		return Action.SUCCESS;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Long getContentLength() {
		return contentLength;
	}

	public void setContentLength(Long contentLength) {
		this.contentLength = contentLength;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public int getBufferSize() {
		return bufferSize;
	}

	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}

	public boolean isAllowCaching() {
		return allowCaching;
	}

	public void setAllowCaching(boolean allowCaching) {
		this.allowCaching = allowCaching;
	}

}
