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
 * 아이콘을 보기 위한 액션 클래스이다.
 * 데이터베이스에 저장된 아이콘 파일을 읽어들인다. 
 * @author Ernest Lee
 * 
 */
// public class ListGadgetsAction extends ActionSupport implements RequestAware
// {
public class IconViewAction extends ManageGadgetAction {
	private Logger logger = Logger.getLogger(IconViewAction.class);
	private static final long serialVersionUID = 1L;

	/**
	 * 컨텐트 유형
	 */
	private String contentType;
	/**
	 * 컨텐트 크기
	 */
	private Long contentLength;
	/**
	 * 컨텐트를 위한 파일 이름
	 */
	private String contentDisposition;
	/**
	 * InputStream의 이름
	 */
	private String inputName = "inputStream";
	/**
	 * InputStream 오브젝트
	 */
	private InputStream inputStream;
	/**
	 * 버퍼 크기
	 */
	private int bufferSize = 1024;
	/**
	 * 캐시허용 여부
	 */
	private boolean allowCaching;

	/**
	 * 가젯 아이콘을 데이터베이스에서 내려받아 페이지에 표시할 수 있는 형태로 변환하는 액션 메소드
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {

		// Session hs = HibernateUtil.getSessionFactory().openSession();
		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();

			GadgetIcon icon = null;
			// Get a gadget by id;
			Gadget gadget = (Gadget) hs.get(Gadget.class, getGadgetId());
			if (gadget == null) {
				logger.warn("No such gadget");
				icon = new GadgetIcon();
			}
			// logger.info("Gadget ID=" + gadgetId);
			// GadgetIcon icon = (GadgetIcon)hs.load(GadgetIcon.class,
			// gadgetId);
			else {
				icon = gadget.getIcon();
			}
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
			// hs.close();
		}

	}

	/**
	 * 컨텐트 유형을 가져온다
	 * @return 컨텐트 유형
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * 컨텐트 유형을 셋팅한다
	 * @param contentType 컨텐트 유형
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * 컨텐트 크기를 가져온다
	 * @return 컨텐트 크기
	 */
	public Long getContentLength() {
		return contentLength;
	}

	/**
	 * 컨텐트 크기를 셋팅한다
	 * @param contentLength 컨텐트 크기
	 */
	public void setContentLength(Long contentLength) {
		this.contentLength = contentLength;
	}

	/**
	 * 컨텐트를 저장할 파일 이름을 가져온다
	 * @return 컨텐트를 저장할 파일 이름
	 */
	public String getContentDisposition() {
		return contentDisposition;
	}

	/**
	 * 컨텐트를 저장할 이름을 셋팅한다
	 * @param contentDisposition 컨텐트 파일 이름
	 */
	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	/**
	 * InputStream 오브젝트의 변수 명을 가져온다
	 * @return InputStream 오브젝트의 변수 명
	 */
	public String getInputName() {
		return inputName;
	}

	/**
	 * InputStream 오브젝트의 변수 명을 셋팅한다
	 * @param inputName InputStream 오브젝트의 변수 명
	 */
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	/**
	 * InputStream 오브젝트를 가져온다
	 * @return InputStream 오브젝트
	 */
	public InputStream getInputStream() {
		return inputStream;
	}

	/**
	 * InputStream 오브젝트을 셋팅한다
	 * @param inputStream InputStream 오브젝트
	 */
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	/**
	 * 버퍼 크기를 가져온다
	 * @return 버퍼 크기
	 */
	public int getBufferSize() {
		return bufferSize;
	}

	/**
	 * 버퍼 크기를 셋팅한다
	 * @param bufferSize 버퍼 크기
	 */
	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}

	/**
	 * 캐시 허용 여부를 가져온다
	 * @return true 또는 false
	 */
	public boolean isAllowCaching() {
		return allowCaching;
	}

	/**
	 * 캐시 허용 여부를 셋팅한다
	 * @param allowCaching true 또는 false
	 */
	public void setAllowCaching(boolean allowCaching) {
		this.allowCaching = allowCaching;
	}

}
