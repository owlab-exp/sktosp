package com.skt.opensocial.common;

import java.io.PrintWriter;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.util.ValueStack;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

/**
 * Struts Result의 확장으로서 JSON 데이터를 처리하기 위한 것이다
 * @author Ernest Lee
 *
 */
public class JSONResult implements Result {
	private static Logger logger = Logger.getLogger(JSONResult.class);
	public static final String DEFAULT_PARAM = "classAlias";
	private String classAlias;
	
	/**
	 * Result를 확장하기 위해 구현해야 하는 메소드
	 * JSON 데이터를 처리한다.
	 * @see com.opensymphony.xwork2.Result#execute(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public void execute(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ServletActionContext.getResponse().setContentType("text/plain");
		PrintWriter responseStream = ServletActionContext.getResponse().getWriter();
		ValueStack valueStack = invocation.getStack();
		Object jsonModel = valueStack.findValue("jsonModel");
		logger.info(jsonModel.getClass().getName());
		
		XStream xtream = new XStream(new JettisonMappedXmlDriver());
		
		if(classAlias == null) {
			classAlias = "object";
		}
		logger.info("classAlias=" + classAlias);
		
		xtream.alias(classAlias, jsonModel.getClass());
		responseStream.println(xtream.toXML(jsonModel));
	}

	/**
	 * JSON 알리아스 클래스 이름을 가져온다 
	 * @return 클래스 알리아스 문자열
	 */
	public String getClassAlias() {
		return classAlias;
	}

	/**
	 * JSON 알리아스 클래스 이름을 셋팅한다
	 * @param classAlias 클래스 알리아스 문자열
	 */
	public void setClassAlias(String classAlias) {
		this.classAlias = classAlias;
	}

}
