package com.skt.opensocial.developer;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.opensymphony.xwork2.ActionSupport;
import com.skt.opensocial.common.GadgetRegisterTypeConstants;

/**
 * 가젯 XML 파일의 문법을 검사하기 위한 액션 클래스이다
 * @author Ernest Lee
 *
 */
public class ValidateGadgetXMLAction extends ActionSupport {
	private static Logger logger = Logger.getLogger(ValidateGadgetXMLAction.class);
	private Object jsonModel;
	/**
	 * 가젯 등록 유형 (소스 혹은 URL)
	 */
	private String registerType;
	/**
	 * 가젯 URL 문자열
	 */
	private String gadgetUrl;
	/**
	 * 가젯 소스 텍스트
	 */
	private String gadgetSrc;
	
	/**
	 * 가젯 XML 문법 체크 결과
	 */
	private String resultMessage;
	// private boolean isValid;

	/**
	 * 가젯 XML 체크를 실행하는 액션 메소드
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() {
		ValidationMessage msg = new ValidationMessage();
		// To do
		logger.info("registerType="+registerType + ",gadgetUrl=" + gadgetUrl);
		//
		if(registerType.equals(GadgetRegisterTypeConstants.URL)) {
			msg.setValid(validateGadgetXMLUrl(gadgetUrl));
			msg.setMessage(resultMessage);
		} else if(registerType.equals(GadgetRegisterTypeConstants.SRC)) {
			msg.setValid(validateGadgetXMLSrc(gadgetSrc));
			msg.setMessage(resultMessage);
		}
		
		setJsonModel(msg);
		return SUCCESS;

	}
	// for gadget url
	/**
	 * execute() 안에서 사용되며 URL로 주어진 가젯의 XML 문법을 체크하는 메소드
	 * @param url 가젯 URL
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
		this.resultMessage = resultBuffer.toString();
		return isValid;
	}
	
	/**
	 * execute()안에서 사용되며 가젯 XML 소스의 문법을 체크하기 위한 메소드
	 * @param src 가젯 XML 소스
	 * @return true 또는 false
	 */
	private boolean validateGadgetXMLSrc(String src){
		//String gadgetUrl = null;
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
			//gadgetUrl = url;
			byte[] srcArray = src.getBytes();
			ByteArrayInputStream bais = new ByteArrayInputStream(srcArray);
			Source source = new StreamSource(bais);

			// 5. Check the document

//			validatorForCanonical.validate(source);
//			System.out.println(gadgetUrl
//					+ " is valid, by gadgets-canonical-0.8.xsd");

			validatorForExtended.validate(source);
			logger.info("XML is valid, by gadgets-extended-0.8.xsd");
			resultBuffer.append("The gadget xml is valid, by gadgets-extended-0.8.xsd");


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
		this.resultMessage = resultBuffer.toString();
		return isValid;
	}
	
	// for properties
	public Object getJsonModel() {
		return jsonModel;
	}

	public void setJsonModel(Object jsonModel) {
		this.jsonModel = jsonModel;
	}

	/**
	 * 가젯 등록 유형을 가져온다
	 * @return 가젯 등록 유형 (src 또는 url)
	 */
	public String getRegisterType() {
		return registerType;
	}

	/**
	 * 가젯 등록 유형을 셋팅한다
	 * @param registerType 가젯 등록 유형 (src 또는 url)
	 */
	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}

	/**
	 * 가젯 URL을 가져온다
	 * @return 가젯 URL 문자열
	 */
	public String getGadgetUrl() {
		return gadgetUrl;
	}

	/**
	 * 가젯 URL을 셋팅한다
	 * @param gadgetUrl 가젯 URL 문자열
	 */
	public void setGadgetUrl(String gadgetUrl) {
		this.gadgetUrl = gadgetUrl;
	}

	/**
	 * 가젯 소스 텍스트를 가져온다.
	 * @return 가젯 소스 텍스트 문자열
	 */
	public String getGadgetSrc() {
		return gadgetSrc;
	}

	/**
	 * 가젯 소스 텍스트를 셋팅한다
	 * @param gadgetSrc 가젯 소스 텍스트 문자열
	 */
	public void setGadgetSrc(String gadgetSrc) {
		this.gadgetSrc = gadgetSrc;
	}

}
