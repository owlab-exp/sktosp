<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
	<br>
	<div class="menubox">
	<table width="90%" height="100" border="0" cellspacing="0" cellpadding="0" class="menu">
		<colgroup>
			<col align="left" width="5">
			<col align="left" width="95">
		</colgroup>
		<tr height="30">
			<td align="left" style="font-size:13px"><img src="../images/blu_rank_subject.gif"> 
			</td>
			<td>
			관리자 메뉴
			</td>
		</tr>
		<tr>
			<td></td>
			<td align="left" onclick="javacript:location.href='<%= request.getContextPath() %>/admin/GadgetList.action'" style="cursor:hand">가젯 관리</td>
		</tr>	
		<tr>
<!--			<s:url id="registerGadgetUrl" action="RegisterGadget">-->
<!--				<s:param name="registerType">source</s:param>-->
<!--			</s:url>-->
			<td></td>
			<td align="left" onclick="location.href='<%= request.getContextPath() %>/admin/SearchDeveloper.action'" style="cursor:hand">개발자 관리
			</td>
		</tr>	
	</table>

	</div>	