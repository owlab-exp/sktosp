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
<table height="100%" width="100%" border="1">
			<colgroup> 
                <col width="50%" /> 
                <col width="50%" /> 
              </colgroup>

	<tr>
		<td colspan="2">가젯 발행 취소 하기</td>
	</tr>

	<tr>
		<td colspan="2" style="background-color:#fefefe" height="5">
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<s:form action="CancelGadgetAction" id="CancelGadgetForm" theme="simple" method="post" target="GadgetList">
			<input type="hidden" name="gadgetId" value="<%= request.getParameter("gadgetId") %>">
			<s:textarea label="취소사유를 입력하세요" name="rejectreason" cols="30" rows="3" />
		</s:form>
		</td>
	</tr>
	<tr>
		<td>
		<s:submit  type="button" onclick="document.getElementById('CancelGadgetForm').submit();window.close()" theme="simple">발행취소</s:submit>
		</td>
	</tr>
	
</table>
</div>
</body>
</html>