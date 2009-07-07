package com.skt.opensocial.shindigwrapper;

import java.io.PrintWriter;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.util.ValueStack;

public class ShindigResult implements Result {
	Logger logger = Logger.getLogger(ShindigResult.class);

	@Override
	public void execute(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		logger.info("called");
		ServletActionContext.getResponse().setContentType("text/plain");
		PrintWriter responseStream = ServletActionContext.getResponse().getWriter();
		
		//No need now
		//ValueStack valueStack = invocation.getStack();
		//Object anObject = valueStack.findValue("jsonModel");
		
		
		responseStream.println("ha ha ha");
	}

}
