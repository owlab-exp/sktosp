<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<br>
	<div class="menubox">
	<table width="90%" height="100" border="0" cellspacing="0" cellpadding="0" class="menu">
		<tr height="30">
			<td align="left" style="font-size:13px"><img src="../images/blu_rank_subject.gif"> 관리자 메뉴
			</td>
		</tr>
		<tr>
			<td align="left"><s:url var="url" namespace="/admin" action="GadgetList"/><s:a href="%{url}">가젯 관리</s:a>
			</td>
		</tr>		
		<tr>
			<td align="left"><s:url var="url" namespace="/admin" action="DeveloperList"/><s:a href="%{url}">개발자 관리</s:a>
			</td>
		</tr>
	</table>

	</div>