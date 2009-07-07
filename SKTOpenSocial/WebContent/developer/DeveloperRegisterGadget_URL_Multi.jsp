<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page import="com.skt.opensocial.common.*" %>
<link href="../css/main.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../js/main.js"></script>


<title>개발자 신규가젯등록</title>
</head>

<body leftmargin="0" topmargin="0"
	style="background-color: rgb(255, 255, 255);" marginheight="0"
	marginwidth="0">
<table border="1" cellpadding="0" cellspacing="0" height="567"
	width="100%">
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
			<%@ include file="/common/west_dev.jsp"%>
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
							<li>개발자 메뉴</li>
							<li><strong>신규 가젯 등록</strong></li>
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
								<col width="10%">
								<col width="30%">
								<col width="50%">
							</colgroup>
							<tbody>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>등록 유형:</td>
									<s:form action="RegisterGadgetPage" id="changeRegisterType" theme="simple">
									<td colspan="4">
										<s:radio name="registerType" list="registerTypeMap" value="%{registerType}" onclick="document.getElementById('changeRegisterType').submit()"/>
									</td>
									</s:form>
								</tr>
								<tr>
									<td class="line" colspan="5"></td>
								</tr>
								<s:form action="RegisterMultipleGadgets" id="registerGadgetForm" theme="simple" method="post">
								<s:hidden name="registerType" value="%{registerType}"/>
								<tr style="background-color: rgb(245, 245, 245);">

									<td>이름</td>
									<td>가젯유형</td>
									<td>소개</td>
									<td>URL</td>
								</tr>
								<tr style="background-color: rgb(300, 300, 300);">
									<td><s:textfield name="gadgetName1" size="5"/></td>
									<td><s:select name="gadgetCategory1" 
											list="categoryList"
											listKey="id"
											listValue="name"
											value="gadgetCategory1"
											multiple="false"
											size="1"
											>
										</s:select>
									</td>
									<td><s:textfield name="gadgetIntro1" size="20"/></td>
									<td><s:textfield name="gadgetUrl1" size="30"/></td>
								</tr>
								<tr style="background-color: rgb(300, 300, 300);">
									<td><s:textfield name="gadgetName2" size="5"/></td>
									<td><s:select name="gadgetCategory2" 
											list="categoryList"
											listKey="id"
											listValue="name"
											value="gadgetCategory2"
											multiple="false"
											size="1"
											>
										</s:select>
									</td>
									<td><s:textfield name="gadgetIntro2" size="20"/></td>
									<td><s:textfield name="gadgetUrl2" size="30"/></td>
								</tr>
								<tr style="background-color: rgb(300, 300, 300);">
									<td><s:textfield name="gadgetName3" size="5"/></td>
									<td><s:select name="gadgetCategory3" 
											list="categoryList"
											listKey="id"
											listValue="name"
											value="gadgetCategory3"
											multiple="false"
											size="1"
											>
										</s:select>
									</td>
									<td><s:textfield name="gadgetIntro3" size="20"/></td>
									<td><s:textfield name="gadgetUrl3" size="30"/></td>
								</tr>
								<tr style="background-color: rgb(300, 300, 300);">
									<td><s:textfield name="gadgetName4" size="5"/></td>
									<td><s:select name="gadgetCategory4" 
											list="categoryList"
											listKey="id"
											listValue="name"
											value="gadgetCategory4"
											multiple="false"
											size="1"
											>
										</s:select>
									</td>
									<td><s:textfield name="gadgetIntro4" size="20"/></td>
									<td><s:textfield name="gadgetUrl4" size="30"/></td>
								</tr>
								<tr style="background-color: rgb(300, 300, 300);">
									<td><s:textfield name="gadgetName5" size="5"/></td>
									<td><s:select name="gadgetCategory5" 
											list="categoryList"
											listKey="id"
											listValue="name"
											value="gadgetCategory5"
											multiple="false"
											size="1"
											>
										</s:select>
									</td>
									<td><s:textfield name="gadgetIntro5" size="20"/></td>
									<td><s:textfield name="gadgetUrl5" size="30"/></td>
								</tr>
								<s:if test="%{message != null}">
								<tr>
									<td colspan="4"><s:property value="message"/></td> 
								</tr>
								</s:if>
								</s:form>
								<tr>
									<td class="line" colspan="5"></td>
								</tr>
							</tbody>
						</table>
						</td>
					</tr>
					<tr>
						<td>
						<div class="paging"><s:submit theme="simple" type="button" value="등록완료" onclick="document.getElementById('registerGadgetForm').submit()"/></div>
						</td>
					</tr>
				</tbody>
			</table>
			</div>
			<!-- east div --></td>
		</tr>
		<!-- south -->
		<tr height="5%">
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