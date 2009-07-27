package com.skt.opensocial.common;

import java.io.PrintWriter;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.util.ValueStack;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class JSONResult implements Result {
	private static Logger logger = Logger.getLogger(JSONResult.class);
	public static final String DEFAULT_PARAM = "classAlias";
	private String classAlias;
	
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

	public String getClassAlias() {
		return classAlias;
	}

	public void setClassAlias(String classAlias) {
		this.classAlias = classAlias;
	}

}
