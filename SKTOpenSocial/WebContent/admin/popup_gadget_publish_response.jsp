<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/main.css" type="text/css" rel="stylesheet">
<title>가젯 발행 페이지</title>
</head>
<body >
<div align="center" >
<s:form action="GadgetRegister" theme="simple">
<table height="100" width="100">
	<tr>
		<td colspan="2">가젯의 발행여부 선택</td>
	</tr>
	<tr>
 	    <s:url var="url" action="GadgetController_changeStatus" namespace="/admin">
 			<s:param name="name" value="%{gadget.name}" />
 			<s:param name="status" value="%{gadget.status}" />
 		</s:url>
		<td><s:submit value="발행허가" onclick="opener.location.href='%{url}';window.close()" ></s:submit>
		</td>
		<td><s:submit value="발행거부" onclick="window.close()" ></s:submit>
		</td>
	</tr>
	<tr>
		<td colspan="2"><s:textfield value="거부사유"/></td>
	</tr>
</table>
</s:form>
</div>
</body>
</html>