<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="../css/main.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../js/main.js"></script>
<%@ page import="com.skt.opensocial.common.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="img" uri="/struts-images" %>

<title>새 가젯 등록</title>
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
							<li><strong>가젯 수정</strong></li>
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
								<s:form action="RegisterGadget" id="registerGadgetForm" theme="simple">
								<s:hidden name="gadgetId" value="%{gadgetId}"/>
								<s:hidden name="registerType" value="%{registerType}"/>
								<s:hidden name="gadgetStatus" value="nr"/>
								<tr>
									<td>*가젯 이름:</td>
									<td>
									<s:textfield name="gadgetName"></s:textfield>
									</td>
								</tr>
								<tr>
									<td>*가젯 유형:</td>
									<td>
										<s:select name="gadgetCategory" 
											list="categoryList"
											listKey="id"
											listValue="name"
											value="%{gadgetCategoryIdSelected}"
											
											multiple="true"
											>
										</s:select>
									</td>
								</tr>
								<tr>
									<td valign="top">*가젯 소개:</td>
									<td valign="top">
											<s:textarea rows="2" cols="20" name="gadgetIntro"/>
									</td>
								</tr>
								<s:if test="%{registerType.equals('src')}">
								<tr>
									<td valign="top">가젯 소스:</td>
									<td>
										<s:textarea cols="70" rows="10" name="gadgetSource" />
									</td>
								</tr>
								</s:if>
								<s:elseif test="%{registerType.equals('url')}">
								<tr>
									<td valign="top">가젯 URL:</td>
									<td>
										<s:textfield name="gadgetSource" size="50"/>
									</td>
								</tr>
								</s:elseif>
								<tr>
									<td>아이콘:</td>
									<td>
										<s:url id="iconUrl" action="ViewIcon">
											<s:param name="gadgetId" value="%{gadgetId}"></s:param>
										</s:url>
										<img:image src="%{iconUrl}" resize="false" height="23" width="23"/>
										<s:submit type="button" action="GadgetIconUpload">아이콘 변경</s:submit>
									</td>
								</tr>
								<tr>
									<td class="line" colspan="2"></td>
								</tr>
								</s:form>
							</tbody>
						</table>
						</td>
					</tr>
					<tr>
						<td><!-- buttons -->
						<div class="paging">
<!--						<s:url id="modifyGadgetUrl" action="ModifyGadget">-->
<!--							<s:param name="gadgetId"><s:property value="gadgetId"/></s:param>-->
<!--						</s:url>-->
						<s:submit theme="simple" type="button" value="가젯 미리보기" onclick="document.getElementById('registerGadgetForm').submit()"/>
						</div></td>
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