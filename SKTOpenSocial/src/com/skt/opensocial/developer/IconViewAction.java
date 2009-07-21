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
import com.skt.opensocial.persistence.Gadget;
import com.skt.opensocial.persistence.GadgetIcon;
import com.skt.opensocial.persistence.HibernateUtil;

/**
 * @author Ernest Lee
 * 
 */
// public class ListGadgetsAction extends ActionSupport implements RequestAware
// {
public class IconViewAction extends ManageGadgetAction {
	private Logger logger = Logger.getLogger(IconViewAction.class);
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

	public String execute() throws Exception{

		//Session hs = HibernateUtil.getSessionFactory().openSession();
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();

			// Get a gadget by id;
			Gadget gadget = (Gadget) hs.get(Gadget.class, getGadgetId());
			// if(gadget == null) {
			// logger.error("No such gadget");
			// return Action.ERROR;
			// }
			logger.info("Gadget ID=" + gadgetId);
			// GadgetIcon icon = (GadgetIcon)hs.load(GadgetIcon.class,
			// gadgetId);
			GadgetIcon icon = gadget.getIcon();
			// if(icon == null){
			// logger.error("No icon");
			// return Action.ERROR;
			// }
			// if(icon.getContent() == null){ // meaningless code, icon row
			// should
			// be filled at least for GADGET_ID
			// logger.error("No icon");
			// return Action.ERROR;
			// }
			if (icon.getContentType() != null)
				setContentType(icon.getContentType());
			else
				setContentType("text/plain");
			
			if (icon.getName() != null)
				setContentDisposition(icon.getName());
			else
				setContentDisposition("");

			if (icon.getContent() != null) {
				Blob iconBlob = icon.getContent();
				setInputStream(iconBlob.getBinaryStream());
				setContentLength(iconBlob.length());
			} else {
				String txt = "no icon";
				setInputStream(new ByteArrayInputStream(txt.getBytes()));
			}
			tx.commit();
			return Action.SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			//hs.close();
		}
		
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
