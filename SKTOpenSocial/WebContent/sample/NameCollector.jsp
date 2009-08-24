<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Name Collector</title>
</head>
<body>
	<h4>Enter your name</h4>
	<s:form action="HelloWorld">
		<s:textfield name="name" label="Your name"/>
		<s:submit/>
	</s:form>
</body>
</html>