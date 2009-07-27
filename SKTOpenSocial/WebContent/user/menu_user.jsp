<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<br>
	<div class="menubox">
	<table width="90%" height="100" border="0" cellspacing="0" cellpadding="0" class="menu">
		<tr height="30">
			<td align="left" style="font-size:13px"><img src="../images/blu_rank_subject.gif"> 사용자 메뉴
			</td>
		</tr>
		<tr><td class="line"></td></tr>
		<tr>
			<td align="left" onclick="javacript:location.href='<%= request.getContextPath() %>/user/Modification.action'" style="cursor:hand">개인정보수정</td>
		</tr>
		<tr><td class="line"></td></tr>
		<tr>
			<td align="left" onclick="javacript:location.href='<%= request.getContextPath() %>/user/ListGadgets.action'" style="cursor:hand">가젯모음</td>
		</tr>
		<tr><td class="line"></td></tr>
		<tr>
			<td align="left" onclick="javacript:location.href='<%= request.getContextPath() %>/user/ManageFriend.action'" style="cursor:hand">친구모음</td>
		</tr>
		<tr><td class="line"></td></tr>
		<tr>
			<td align="left" onclick="javacript:location.href='<%= request.getContextPath() %>/user/ManageActivity.action'" style="cursor:hand">액티비티모음</td>
		</tr>
		<tr><td class="line"></td></tr>
		
		<tr>
			<td align="left" onclick="javacript:location.href='<%= request.getContextPath() %>/user/PrepareSearch.action'" style="cursor:hand">가젯사용자검색</td>
		</tr>
	</table>

	</div>



    
 