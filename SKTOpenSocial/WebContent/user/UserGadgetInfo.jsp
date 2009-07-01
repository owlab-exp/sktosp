<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="../css/main.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../js/main.js"></script>
<%@page import="com.skt.opensocial.common.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<title>사용자 가젯 정보</title>
</head>

<body leftmargin="0" topmargin="0"
	style="background-color: rgb(255, 255, 255);" marginheight="0"
	marginwidth="0">
<table border="1" cellpadding="0" cellspacing="0" height="567" width="100%">
	<tbody>
		<tr valign="top" height="15%">
			<!-- north -->
			<td colspan="3" align="center" height="10%" valign="top">
			<%@ include file="/common/north.jsp"%>
			</td>
		</tr>
		<tr valign="top" height="80%">
			<!-- west -->
			<td align="center" valign="top" width="25%">
			<%@ include file="/user/west_user.jsp"%>
			</td>
			<!-- east -->
			<td align="left" valign="top" width="75%">
			<div id="east">
			<table cellpadding="10" width="100%">
				<!-- navigation -->
				<tbody>
					<tr>
						<td>
						<div class="subject subject_char">
						<ul class="subject_sub">
							<li>홈</li>
							<li>사용자 메뉴</li>
							<li><strong>가젯 정보</strong></li>
						</ul>
						</div>
						</td>
					</tr>
					<tr>
						<td><!-- list of gadgets -->
						<table class="subtit_board" summary="List of Gadgets"
							cellpadding="0" cellspacing="0" width="100%">
							<colgroup>
								<col width="10%">
								<col width="90%">
							</colgroup>
							<tbody>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>가젯 아이디:</td>
									<td><s:property value="gadgetId"/></td>
								</tr>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>가젯 이름:</td>
									
									<td><s:property value="name"/></td>
									
								</tr>
														
								<tr style="background-color: rgb(245, 245, 245);">
									<td>가젯 유형:</td>
									<td><s:property value="categoryStringList"/></td>
								</tr>
								
								<tr style="background-color: rgb(245, 245, 245);">
									<td valign="top">가젯 소개:</td>
									<td valign="top">
											<s:property value="introduction"/>
									</td>
								</tr>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>아이콘:</td>
									<td>
										<s:property value="gadgetIconUrl"/>	
									</td>
								</tr>
								<s:if test="%{registerType.equals('src')}">
								<tr>
									<td valign="top">가젯 소스:</td>
									<td>
										<s:property value="gadgetSource" />
									</td>
								</tr>
								</s:if>
								<s:elseif test="%{registerType.equals('url')}">
								<tr>
									<td valign="top">가젯 URL:</td>
									<td>
										<s:property value="gadgetSource" />
									</td>
								</tr>
								</s:elseif>
								<tr>
									<td class="line" colspan="2"></td>
								</tr>
								<tr>
									<td valign="top">가젯 실행</td>

									<s:if test="%{registerType.equals('url')}">
										
										<td valign="top"><iframe id="gadgetFrame" src="<s:url value="%{'http://localhost:8080/gadgets/ifr?url='+gadgetSource}"/>" width="100%" height="300"></iframe></td>
									</s:if>
									
									<s:else>
										<td valign="top"><img src="ilike.png" height="70%" width="70%"> </td>
									</s:else>

								</tr>
								<tr>
									<td class="line"></td>
									
								</tr>

							</tbody>
						</table>
						</td>
					</tr>

				</tbody>
			</table>
			</div>
			<!-- east div --></td>
		</tr>
		<!-- south -->
		<tr valign="top" height="5%">
			<td colspan="3" align="center" height="10%" valign="middle">
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