<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Occurred!</title>
</head>
<body>
<h4>작업 수행 중 예외가 발견되었습니다.</h4>
<p>아래의 메시지를 관리자에게 보고하여 주시기 바랍니다.</p> 
		<h4>예외 이름: </h4><s:property value="exception" /> 
		<h4>스택 추적:</h4> <s:property value="exceptionStack" /> 
		
</body>
</html>