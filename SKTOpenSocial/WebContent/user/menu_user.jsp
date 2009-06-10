<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<br>
	<div class="menubox">
	<table width="90%" height="100" border="0" cellspacing="0" cellpadding="0" class="menu">
		<tr height="30">
			<td align="left" style="font-size:13px"><img src="../images/blu_rank_subject.gif"> 사용자 메뉴
			</td>
		</tr>
		<tr>
			<td align="left" onclick="javacript:location.href='<%= request.getContextPath() %>/user/Modification.action'" style="cursor:hand">내 정보 관리</td>
		</tr>	
		<tr>
			<td align="left" onclick="javacript:location.href='<%= request.getContextPath() %>/user/ManageGadget.action'" style="cursor:hand">가젯 모음</td>
		</tr>
	</table>

	</div>



    
 