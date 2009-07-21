<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@page import="com.skt.opensocial.common.*"%>
<%@page import="com.skt.opensocial.persistence.*"%>
<%@page import="org.hibernate.*"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="img" uri="/struts-images" %>

<link href="../css/main.css" type="text/css" rel="stylesheet">
<link href="../css/table.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../js/main.js"></script>
<script type="text/javascript" src="../js/developer.js"></script>
<title>개발자 가젯 목록</title>
</head>
<body leftmargin="0" topmargin="0"
	style="background-color: rgb(255, 255, 255);" marginheight="0"
	marginwidth="0">
<table border="1" cellpadding="0" cellspacing="0" height="567"
	width="100%">
	<!--  position: height="567" width="100%" -->
	<tbody>
		<tr valign="top" height="15%">
			<!--  position: valign="top" height="15%" -->
			<!-- north -->
			<td colspan="3" align="center" valign="top"><!-- position: valign="top" -->
			<%@ include file="/common/north.jsp"%></td>
		</tr>
		<tr valign="top" height="80%">
			<!--  position: valign="top" height="80%" -->
			<!-- west -->
			<td align="center" valign="top" width="25%"><%@ include
				file="/common/west_dev.jsp"%></td>
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
								<col width="5%">
								<col width="5%">
								<col width="20%">
								<col width="12.5%">
								<col width="12.5%">
								<col width="10%">
								<col width="15%">
								<col width="20%">
							</colgroup>
							<tbody>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>아이콘</td>
									<td align="center">ID</td>
									<td>가젯이름</td>
									<td align="center">등록일자</td>
									<td align="center">발행일자</td>
									<td align="center">사용자수</td>
									<td align="center">가젯상태</td>
									<td align="center">작 업</td>
								</tr>
								<%--<s:iterator value="gadgets">  --%>
								<s:iterator value="gadgetList" status="rowStatus">
									<s:if test="#rowStatus.odd == true">
										<s:set name="trClass" value="%{'odd'}"/>
									</s:if>
									<s:else>
										<s:set name="trClass" value="%{'even'}"/>
									</s:else>
										<tr class="<s:property value='#trClass'/>">
										<s:url id="gadgetPreviewUrl" action="PreviewGadget">
											<s:param name="gadgetId">
												<s:property value="id" />
											</s:param>
										</s:url>
										<td>
											<s:url id="iUrl" action="ViewIcon">
												<s:param name="gadgetId" value="%{id}"></s:param>
											</s:url>
											<s:a href="%{gadgetPreviewUrl}">
											<img:image src="%{iUrl}" resize="false" height="30" width="30"/>
											</s:a>
										</td>
										<td align="center">
											<s:a href="%{gadgetPreviewUrl}">
											<s:property value="id" />
											</s:a>
										</td>
										<td><s:a href="%{gadgetPreviewUrl}">
												<s:property value="name" />
											</s:a>	
										</td>
										<td align="center"><s:date name="registerDate"
											format="yyyy/MM/dd" /></td>
										<td align="center"><s:date name="publishDate"
											format="yyyy/MM/dd" /></td>
										<td align="center"><s:property value="favoriteUsers.size" /></td>

										<td align="center"><s:if test="%{status.equals('rg')}">
										등록완료
									</s:if> <s:elseif test="%{status.equals('pr')}">
										발행요청
									</s:elseif> <s:elseif test="%{status.equals('pg')}">
										발행완료
									</s:elseif> <s:elseif test="%{status.equals('pd')}">
										발행거절
									</s:elseif> <s:elseif test="%{status.equals('nr')}">
										미등록
									</s:elseif></td>
										<s:url id="finishRegisterUrl" action="RegisterGadget"
											method="finishGadgetRegister">
											<s:param name="gadgetId">
												<s:property value="id" />
											</s:param>
										</s:url>
										<s:url id="viewReviewUrl" action="ViewGadgetReview">
											<s:param name="gadgetId">
												<s:property value="id" />
											</s:param>
										</s:url>
										<s:url id="modifyGadgetUrl" action="ModifyGadget"
											method="getModifyGadgetPage">
											<s:param name="gadgetId">
												<s:property value="id" />
											</s:param>
										</s:url>
										<s:url id="publishRequestUrl" action="PublishRequest"
											method="publishConfirm">
											<s:param name="gadgetId">
												<s:property value="id" />
											</s:param>
										</s:url>
										<s:url id="removeGadgetUrl" action="RemoveGadget"
											method="requestConfirm">
											<s:param name="gadgetId">
												<s:property value="id" />
											</s:param>
										</s:url>
										<s:url id="viewDenyReasonUrl" action="ViewDenyReason">
											<s:param name="gadgetId">
												<s:property value="id" />
											</s:param>
										</s:url>
										<td align="center">
										<s:if test="status.equals('nr')">
											<s:a href="%{finishRegisterUrl}">등록완료</s:a>/<s:a
												href="%{modifyGadgetUrl}">수정</s:a>/<s:a href="#"
												onclick="javascript:popup('%{removeGadgetUrl}','RemoveConfirm')">삭제</s:a>
											
										</s:if>
										<s:if test="status.equals('rg')">
											<s:a href="#"
												onclick="javascript:popup('%{publishRequestUrl}','PublishConfirm')">발행요청</s:a>/<s:a
												href="%{modifyGadgetUrl}">수정</s:a>/<s:a href="#"
												onclick="javascript:popup('%{removeGadgetUrl}','RemoveConfirm')">삭제</s:a>
											
										</s:if>
										<s:elseif test="status.equals('pg')">
											<s:a href="%{viewReviewUrl}">사용자 리뷰 보기</s:a>
											
										</s:elseif>
										<s:elseif test="status.equals('pd')">
											<s:a href="#"
												onclick="javascript:popup('%{viewDenyReasonUrl}','PublishDeny')">거절사유</s:a>/<s:a
												href="%{modifyGadgetUrl}">수정</s:a>/<s:a href="#"
												onclick="javascript:popup('%{removeGadgetUrl}','RemoveConfirm')">삭제</s:a>
										</s:elseif>
										<s:else>								
										</s:else>
										</td>
									</tr>
								</s:iterator>
								<tr>
									<td class="line" colspan="8"></td>
								</tr>
							</tbody>
						</table>
						</td>
					</tr>
					<tr>
						<td><!-- pagenation start -->
						<div class="paging">
						<s:if test="%{pageList.size > 0}">
							<s:if test="%{requestedPage > 1}">
								<s:url action="ListGadgets" id="prevPageUrl">
								<s:param name="requestedPage" value="%{requestedPage - 1}" />
								</s:url>
							</s:if>
							<s:else>
								<s:url action="ListGadgets" id="prevPageUrl">
								<s:param name="requestedPage" value="1" />
								</s:url>
							</s:else>
						 <em class="p"><s:a href="%{prevPageUrl}">이 전</s:a></em> 
						 <s:iterator
							value="pageList">
							<s:url action="ListGadgets" id="pageUrl">
								<s:param name="requestedPage">
									<s:property />
								</s:param>
							</s:url>
							<s:a href="%{pageUrl}">
								<s:property />
							</s:a>
						</s:iterator> 
							<s:if test="%{requestedPage < maxPage}">
								<s:url action="ListGadgets" id="nextPageUrl">
								<s:param name="requestedPage" value="%{requestedPage + 1}" />
								</s:url>
							</s:if>
							<s:else>
								<s:url action="ListGadgets" id="nextPageUrl">
								<s:param name="requestedPage" value="%{maxPage}" />
								</s:url>
							</s:else>
						 <em class="n"><s:a href="%{nextPageUrl}">다음</s:a></em>
						 </s:if>
						</div><!-- pagenation end -->
						</td>
					</tr>
				</tbody>
			</table>
			</div>
			<!-- east div --></td>
		</tr>
		<!-- south -->
		<tr height="5%">
			<!--  position: height="5%" -->
			<td colspan="3" align="center" valign="middle">
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