<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
	<br>
	<div class="menubox">
	<table width="90%" height="100" border="0" cellspacing="0" cellpadding="0" class="menu">
		<tr height="30">
			<td align="left" style="font-size:13px"><img src="../images/blu_rank_subject.gif"> 개발자 메뉴
			</td>
		</tr>
		<tr>
			<td align="left" onclick="javacript:location.href='<%= request.getContextPath() %>/developer/ListGadgets.action'" style="cursor:hand">내 가젯 관리</td>
		</tr>	
		<tr>
<!--			<s:url id="registerGadgetUrl" action="RegisterGadget">-->
<!--				<s:param name="registerType">source</s:param>-->
<!--			</s:url>-->
			<td align="left" onclick="location.href='<%= request.getContextPath() %>/developer/RegisterGadget.action?registerType=source'" style="cursor:hand">새 가젯 등록
			</td>
		</tr>	
	</table>

	</div>



    
 