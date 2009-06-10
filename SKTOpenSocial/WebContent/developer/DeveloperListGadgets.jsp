<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@page import="com.skt.opensocial.common.*" %>
<link href="../css/main.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../js/main.js"></script>
<script type="text/javascript" src="../js/developer.js"></script>

<%@ taglib prefix="s" uri="/struts-tags"%>
<title>내 가젯 관리</title>
</head>

<body leftmargin="0" topmargin="0"
	style="background-color: rgb(255, 255, 255);" marginheight="0"
	marginwidth="0">
<table border="1" cellpadding="0" cellspacing="0" height="567"
	width="1000"> <!--  position: height="567" width="100%" -->
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
			<%@ include file="/common/west_dev.jsp"%>
			</td>
			<!-- east -->
			<td align="left" valign="top" width="75%">
			<div id="east">
			<table cellpadding="10" width="100%">
				<!-- navigation -->
				<tbody valign="top">
					<tr v>
						<td valign="top">
						<div class="subject subject_char">
						<ul class="subject_sub">
							<li>홈</li>
							<li>개발자 메뉴</li>
							<li><strong>내 가젯 관리</strong></li>
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
								<col width="10%">
								<col width="10%">
								<col width="10%">
								<col width="20%">
								<col width="30%">
							</colgroup>
							<tbody>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>가젯ID</td>
									<td>가젯이름</td>
									<td align="center">등록일자</td>
									<td align="center">발행일자</td>
									<td align="center">사용자수</td>
									<td align="center">가젯상태</td>
									<td align="center">작 업</td>
								</tr>
								<s:iterator value="gadgets" id="gadget">
								<tr style="background-color: rgb(300, 300, 300);">
									<s:url id="gadgetPreviewUrl" action="PreviewGadget">
										<s:param name="gadgetStatus"><s:property value="gadgetStatus"/></s:param>
									</s:url>
									<td><s:a href="%{gadgetPreviewUrl}"><s:property value="gadgetId"/></s:a></td>
									<td><s:a href="%{gadgetPreviewUrl}"><s:property value="gadgetName"/></s:a></td>
									<td align="center"><s:property value="registerDate"/></td>
									<td align="center"><s:property value="publishDate"/></td>
									<td align="center"><s:property value="numberOfUsers"/></td>
									
									<td align="center">
									<s:if test="%{gadgetStatus.equals('rg')}">
										등록완료
									</s:if>
									<s:elseif test="%{gadgetStatus.equals('pr')}">
										발행요청중
									</s:elseif>
									<s:elseif test="%{gadgetStatus.equals('pg')}">
										발행완료
									</s:elseif>
									<s:elseif test="%{gadgetStatus.equals('pd')}">
										발행거절
									</s:elseif>
									</td>
									
									<s:if test="gadgetStatus.equals('rg')">
									<td align="center">
										<a href="#" onclick="javascript:popup('popup_gadget_publish_request.jsp','IDCheck')">발행요청</a>/<s:a href="ModifyGadget.action">수정</s:a>/<a href="#" onclick="javascript:popup('popup_gadget_remove.jsp','IDCheck')">삭제</a>
									</td>
									</s:if>
									<s:elseif test="gadgetStatus.equals('pg')">
									<td align="center">
										<a href="ViewGadgetReview.action">사용자 리뷰 보기</a>
									</td> 
									</s:elseif>
									<s:elseif test="gadgetStatus.equals('pd')">
										<td align="center">
										<a href="#" onclick="javascript:popup('popup_publish_deny.jsp','PublishDeny')">거절사유</a>/<s:a href="ModifyGadget.action">수정</s:a>/<a href="#" onclick="javascript:popup('popup_gadget_remove.jsp','IDCheck')">삭제</a>
										</td>
									</s:elseif>
									<s:else>
									<td align="center">
									</td> 
									</s:else>
									
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
    		<td colspan="3" align="center" valign="middle" style="background-color:#F5F5F5;" height="30px" >
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