<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>This application has malfunctioned.</h4>
<p>  Please read through the following detailed account of the
		problems encounted during the processing of your request.  After determining what mistakes you
		may have made, please resubmit your request.  Better luck next time! </p> 
		
		<h4>Exception Name: </h4><s:property value="exception" /> 
		<h4>What you did wrong:</h4> <s:property value="exceptionStack" /> 
		
		<h5>Also, please confirm that your Internet is working before actually contacting us.</h5>
</body>
</html>