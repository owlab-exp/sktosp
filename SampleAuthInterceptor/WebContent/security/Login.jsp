<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix = "s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login Page</title>
</head>
<body>
	<h4>사용자 ID/패스워드를 입력 바람</h4>
	<s:form action="UserLogin" namespace="/security">
		<s:textfield name="userId" label="User ID"/>
		<s:password name="password" label ="Password"/>
		<s:submit/>
	</s:form>
</body>
</html>