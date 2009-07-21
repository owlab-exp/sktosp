<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@page import="com.skt.opensocial.common.*" %>
<%@page import="com.skt.opensocial.persistence.*" %>
<%@page import="org.hibernate.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link href="../css/main.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../js/main.js"></script>
<script type="text/javascript" src="../js/developer.js"></script>
<title>사용자 친구 목록</title>
</head>
<body leftmargin="0" topmargin="0"
	style="background-color: rgb(255, 255, 255);" marginheight="0"
	marginwidth="0">
<table border="1" cellpadding="0" cellspacing="0" height="567"
	width="100%"> <!--  position: height="567" width="100%" -->
	<tbody>
		<tr valign="top" height="15%"> <!--  position: valign="top" height="15%" -->
			<!-- north -->
			<td colspan="3" align="center" valign="top"><!-- position: valign="top" -->
			<%@ include file="/common/north.jsp"%>
			</td>
		</tr>
		<tr valign="top" height="80%"><!--  position: valign="top" height="80%" -->
			<!-- west -->
			<td align="center" valign="top" width="25%">
			<%@ include file="/user/west_user.jsp" %>
			</td>
			<!-- east -->
			<td align="left" valign="top" width="75%">
			<div id="east">
			<table cellpadding="10" width="100%">
				<!-- navigation -->
				<tbody valign="top">
					<tr >
						<td valign="top">
						<div class="subject subject_char">
						<ul class="subject_sub">
							<li>홈</li>
							<li>사용자 메뉴</li>
							<li><strong>내 친구 모음</strong></li>
						</ul>
						</div>
						</td>
					</tr>
					<tr>
						<td><!-- list of gadgets -->
						<table class="subtit_board" summary="List of Gadgets"
							cellpadding="0" cellspacing="0" width="100%">
							<colgroup>
								<col width="20%">
								<col width="20%">
								<col width="20%">
								<col width="20%">
								<col width="10%">
								<col width="10%">
							</colgroup>
							<tbody>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>사용자ID</td>
									<td>사용자이름</td>
									<td align="center">사용자가입일</td>
									<td align="center">사용자설명</td>
									<td align="center">나이</td>
									<td align="center">작업</td>
								</tr>
								<s:iterator value="friends">
								<tr style="background-color: rgb(300, 300, 300);">
									<s:url id="userOtherUserInfoUrl" action="SearchOtherUserInfo">
										<s:param name="otherUserId"><s:property value="id"/></s:param>
									</s:url>
									<s:url id="userRemoveFriendUrl" action="UserRemoveFriend">
										<s:param name="friendId"><s:property value="id"/></s:param>
									</s:url>
									<td><s:a href="%{userOtherUserInfoUrl}"><s:property value="id"/></s:a></td>
									<td><s:a href="%{userOtherUserInfoUrl}"><s:property value="person.nameFormatted"/></s:a></td>
									<td align="center"><s:date name="registeredDate" format="yyyy/MM/dd"/></td>
									<td align="center"><s:property value="person.aboutme" /></td>
									<td align="center"><s:property value="person.age" /></td>
									<td align="center"><s:a href="%{userRemoveFriendUrl}">삭제</s:a></td>
								</tr>
								</s:iterator>
								<tr>
									<td class="line" colspan="7"></td>
								</tr>
							</tbody>
						</table>
						</td>
					</tr>
					<tr>
						<td><!-- paging -->
						<div class="paging"><em class="p"><a href="ListGadgets.action">이 전</a></em><a href="ListGadgets.action">1</a> <a href="ListGadgets.action">2</a> <a href="ListGadgets.action">3</a> <em
							class="n"><a href="ListGadgets.action">다음</a></em></div>
						</td>
					</tr>
				</tbody>
			</table>
			</div>
			<!-- east div -->
			</td>
		</tr>
		<!-- south -->
		<tr height="5%"><!--  position: height="5%" -->
			<td colspan="3" align="center"  valign="middle">
			<div id="footer">
			<table border="1" height="100%" width="100%">
				<tbody>
					<tr>
						<td><strong>Copyright &copy; SK Telecom. All rights
						reserved.</strong></td>
					</tr>
				</tbody>
			</table>
			</div>
			</td>
		</tr>
	</tbody>
</table>
</body>
</html>