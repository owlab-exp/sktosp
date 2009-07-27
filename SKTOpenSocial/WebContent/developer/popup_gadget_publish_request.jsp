<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/main.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body >
<div align="center" >
<s:form action="GadgetIdCheck" theme="simple">
<table height="100" width="100">
		<tr>
		<td colspan="2">발행요청된 가젯은 수정할 수 없습니다</td>
	</tr>
	<tr>
		<s:url id="url" action="ListGadgets">
		</s:url>
		<td><s:submit value="발행요청" onclick="opener.location.href='%{url}';window.close()" ></s:submit>
		</td>
		<td><s:submit value="취소" onclick="window.close()" ></s:submit>
		</td>
	</tr>
</table>
</s:form>
</div>
</body>
</html>