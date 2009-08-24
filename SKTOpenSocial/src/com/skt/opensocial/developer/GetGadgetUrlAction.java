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
 * 소스로 등록된 가젯을 실행시키기 위해서는 
 * 먼저 데이터베이스에 저장된 가젯 소스의 XML 텍스트를 
 * 파일시스템에 XML 파일로 저장한 후에 이를 URL로 접근하여야 한다.
 * 이 클래스는 이상의 작업을 수행하고 저장된 파일의 URL을 가져오기 위한 것이다.
 * @author Ernest Lee
 * 
 */
public class GetGadgetUrlAction extends ManageGadgetAction {
	private Logger logger = Logger.getLogger(GetGadgetUrlAction.class);
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
	 * 컨텐트 저장 이름
	 */
	private String contentDisposition;
	/**
	 * InputStream 변수의 이름
	 */
	private String inputName = "inputStream";
	/**
	 * InputStream 변수
	 */
	private InputStream inputStream;
	/**
	 * 버퍼 크기
	 */
	private int bufferSize = 1024;
	/**
	 * 캐시 허용 여부
	 */
	private boolean allowCaching;

	
	/**
	 * 가젯 XML을 생성하고 이를 웹 브라우저에 전달하는 액션 메소드이다.
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception{

		Session hs = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();

			// Get a gadget by id;
			Gadget gadget = (Gadget) hs.get(Gadget.class, getGadgetId());

			logger.info("Gadget ID=" + gadgetId);

			String gadgetSource = gadget.getGadgetSource();
			String registerType = gadget.getRegisterType();

			if (registerType.equals(GadgetRegisterTypeConstants.URL)) {
				// the source of the gadget is already the very url
				//
			}
			if (gadgetSource == null) {
				// gadget source is null
			}
			if (registerType.equals(GadgetRegisterTypeConstants.SRC)) {
				setContentType("text/xml");
				setContentDisposition(gadget.getName() + ".xml");
				byte[] sourceBytes = gadgetSource.getBytes();
				setInputStream(new ByteArrayInputStream(sourceBytes));
				setContentLength(new Long(sourceBytes.length));
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
	 * 컨텐트 유형을 가져온다
	 * @return 컨텐트 유형
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * 컨텐트 유형을 셋팅한다.
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
	 * 컨텐트 파일의 이름을 가져온다
	 * @return 컨텐트 파일 이름
	 */
	public String getContentDisposition() {
		return contentDisposition;
	}

	/**
	 * 컨텐트 파일의 이름을 셋팅한다
	 * @param contentDisposition 컨텐트 파일 이름
	 */
	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	/**
	 * InputStream 변수의 이름을 가져온다
	 * @return InputStream 변수 이름
	 */
	public String getInputName() {
		return inputName;
	}

	/**
	 * InputStream 변수의 이름을 셋팅한다
	 * @param inputName InputStream 변수의 이름
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
	 * InputStream 오브젝트를 셋팅한다
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
	 * 캐시허용 여부를 가져온다
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
