<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/main.css" type="text/css" rel="stylesheet">
<title>가젯 발행 거절 사유</title>
</head>
<body >
<div align="center" >

<table height="100" width="100">
	<tr>
		<td><s:property  value="rejectReason"></s:property></td>
	</tr>
	<tr>	
		<td><s:submit value="닫기" onclick="window.close()" theme="simple"></s:submit></td>
	</tr>
</table>

</div>
</body>
</html>