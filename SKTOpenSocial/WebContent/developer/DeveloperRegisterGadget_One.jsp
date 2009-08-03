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
<!--  for Help Balloon -->
<script type="text/javascript" src="../js/wz_tooltip.js"></script>
<script type="text/javascript" src="../js/tip_balloon.js"></script>
<script type="text/javascript" src="../js/skt_tooltip.js"></script>

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
										<s:radio name="registerType" list="registerTypeMap" value="%{registerType}" onclick="document.getElementById('changeRegisterTypeForm').submit()" onmouseover="MyTip('등록할 가젯의 형식을 선택하십시오.<br> 다중 URL 등록은 여러개의 URL타입 가젯을 등록할 때 사용됩니다.')" onmouseout="MyUnTip()"/>
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
								<s:hidden name="registerType" value="%{registerType}" id="registerTypeTxt"/>
								<s:hidden name="gadgetStatus" value="nr"/>
								<tr>
									<td>*가젯 이름:</td>
									<td>
									<s:textfield name="gadgetName" onmouseover="MyTip('가젯의 이름을 입력해주십시오')" onmouseout="MyUnTip()"></s:textfield>
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
											onmouseover="MyTip('하나 이상의 유형을 선택하십시오')"
											onmouseout="MyUnTip()"
											>
										</s:select>
									</td>
								</tr>
								<tr>
									<td valign="top">*가젯 소개:</td>
									<td valign="top">
											<s:textarea rows="2" cols="20" name="gadgetIntro" onmouseover="MyTip('사용자들에게 보여질<br> 가젯 소개 글을 입력해주십시오')" onmouseout="MyUnTip()"
											/>
									</td>
								</tr>
								
								<s:url id="urlForGadgetValidation" action="ValidateGadgetXML" ></s:url>
								<s:if test="%{registerType.equals('src')}">
								<tr>
									<td valign="top">*가젯 소스:</td>
									<td>
										<s:textarea id="gadgetSrcTxt" cols="70" rows="10" name="gadgetSource" onmouseover="MyTip('가젯의 XML 텍스트를 입력해주십시오.')" onmouseout="MyUnTip()"
											/><br>
										<input type="button" onclick="javascript:validateGadgetXML('<s:property value="%{urlForGadgetValidation}" />')" value="가젯 XML 체크" onmouseover="MyTip('가젯 XML 문법을 체크합니다.<br> 문법체크를 통과하여야만 아래의 미리보기 버튼이 활성화됩니다')" onmouseout="MyUnTip()"><br>
										<div id="validationResult"></div>
									</td>
								</tr>
								</s:if>
								<s:elseif test="%{registerType.equals('url')}">
								<tr>
									<td valign="top">*가젯 URL:</td>
									<td>
										<s:textfield id="gadgetUrlTxt" name="gadgetUrl" size="50" onmouseover="MyTip('가젯의 URL을 입력해주십시오.<br> 예)http://lovemygadget.com/hotmail/hotmail.xml')" onmouseout="MyUnTip()"
											/> <input type="button" onclick="javascript:validateGadgetXML('<s:property value="%{urlForGadgetValidation}" />')" value="가젯 XML 체크" onmouseover="MyTip('가젯 XML 문법을 체크합니다.<br> 문법체크를 통과하여야만 아래의 미리보기 버튼이 활성화됩니다')" onmouseout="MyUnTip()"
											><br>
										<div id="validationResult"></div><!-- 예: http://www.google.com/ig/modules/builtin_gmail.xml -->
									</td>
								</tr>
								</s:elseif>
								<tr>
									<td>아이콘 파일:</td>
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
						<s:if test="%{registerType.equals('url')}">
						<s:submit theme="simple" type="button" value="미리보기" onclick="document.getElementById('registerGadgetForm').submit()" disabled="true" id="previewButton"/>
						</s:if>
						<s:else>
						<s:submit theme="simple" type="button" value="미리보기" onclick="document.getElementById('registerGadgetForm').submit()" disabled="true" id="previewButton"/>
						</s:else>
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