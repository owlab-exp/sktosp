<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="s" uri="/struts-tags"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/main.css" type="text/css" rel="stylesheet">
<title>가젯 아이콘 업로드</title>
</head>
<body >
<div align="center" >
<s:form action="GadgetIconUpload" method="post" enctype="multipart/form-data">
	<s:hidden name="registerType" value="%{registerType}"/>
	<s:hidden name="gadgetStatus" value="%{gadgetStatus}"/>
	<s:hidden name="gadgetName" value="%{gadgetName}"/>
	<s:hidden name="gadgetCategory" value="%{gadgetCategory}"/>
	<s:hidden name="gadgetIntro" value="%{gadgetIntro}"/>
	<s:hidden name="gadgetSource" value="%{gadgetSource}"/>
	<s:file name="icon" label="파일 위치"/>
	<s:submit value="업로드"/>
</s:form>
</div>
</body>
</html>