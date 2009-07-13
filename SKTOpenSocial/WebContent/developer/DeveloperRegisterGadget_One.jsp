<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.skt.opensocial.common.GadgetStatusConstants"%><html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="../css/main.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../js/main.js"></script>
<script type="text/javascript" src="../js/developer.js"></script>


<title>개발자 신규가젯등록</title>
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
								<col width="90%">
							</colgroup>
							
							<tbody>
								<s:form action="RegisterGadgetPage" id="changeRegisterTypeForm" theme="simple" >
								<tr style="background-color: rgb(245, 245, 245);">
									<td>등록 유형:</td>
									
									<td>
										<s:radio name="registerType" list="registerTypeMap" value="%{registerType}" onclick="document.getElementById('changeRegisterTypeForm').submit()"/>
									</td>
									
								</tr>
								</s:form>
								<%--
								<tr>
									<td>*가젯 ID:</td>
									<td>
									<s:textfield name="gadgetId"></s:textfield>
									<input type="button" value="중복검사" onClick="javascript:return popup('popup_gadget_id_check.jsp','IDCheck')">
									</td>
								</tr>
								--%>
								<s:form action="RegisterGadget" id="registerGadgetForm" theme="simple" method="post" enctype="multipart/form-data">
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
											value="gadgetCategory"
											multiple="true"
											size="5"
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
										<s:textfield name="gadgetUrl" size="50"/>
									</td>
								</tr>
								</s:elseif>
								<tr>
									<td>아이콘:</td>
									<td>
									<s:file name="icon" label="파일 위치"/>
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
						<td align="center"><!-- buttons -->
						<div class="paging" align="center">
						<%--
						<s:url id="registerGadgetUrl" action="RegisterGadget">
							<s:param name="gadgetStatus">nr</s:param>
						</s:url>
						<em class="n"><s:a href="%{registerGadgetUrl}">미리보기</s:a></em>
						--%>
						<s:submit theme="simple" type="button" value="미리보기" onclick="document.getElementById('registerGadgetForm').submit()"/>
						</div>
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