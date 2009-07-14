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

<title>개발자 신규가젯등록</title>
</head>

<body leftmargin="0" topmargin="0"
	style="background-color: rgb(255, 255, 255);" marginheight="0"
	marginwidth="0">
<table border="1" cellpadding="0" cellspacing="0" position: height="567"
	width="100%">
	<tbody>
		<tr valign="top" height="15%">
			<!-- north -->
			<td colspan="3" align="center" height="10%" valign="top"><%@ include
				file="/common/north.jsp"%></td>
		</tr>
		<tr valign="top" height="80%">
			<!-- west -->
			<td align="center" valign="top" width="25%"><%@ include
				file="/common/west_dev.jsp"%></td>
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
							<li><strong>가젯 리뷰 보기</strong></li>
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
								<col width="20%">
								<col width="50%">
								<col width="20%">
							</colgroup>
							<tbody>
								<tr style="background-color: rgb(245, 245, 245);">
									<td colspan="2">가젯 이름:</td>
									<td colspan="2" align="left"><s:property value="gadgetName"/></td>
								</tr>
								<tr style="background-color: rgb(245, 245, 245);">
									<td colspan="2">가젯 ID:</td>
									<td colspan="2" align="left"><s:property value="gadgetId"/></td>
								</tr>
								<tr>
									<td class="line" colspan="4"></td>
								</tr>
								<tr style="background-color: rgb(245, 245, 245);">
									<td colspan="2">리뷰 수: <s:property value="totalReviewNumber"/> </td>
									<td colspan="2">평균 점수: <s:property value="gradeAverage"/> </td>

								</tr>
								<tr>
									<td class="line" colspan="4"></td>
								</tr>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr style="background-color: rgb(245, 245, 245);">
									<td valign="middle">사용자ID</td>
									<td valign="middle">사용자 이름</td>
									<td valign="middle" align="center">리뷰</td>
									<td valign="middle">점수</td>
								</tr>
								<tr>
									<td class="line" colspan="4"></td>
								</tr>
								<s:iterator value="gadgetReviews">
								<tr>
									<td valign="middle"><s:property value="reviewer.id"/> </td>
									<td valign="middle"><s:property value="reviewer.person.nameFormatted"/> </td>
									<td valign="middle" align="center"><s:property value="reviewText"/></td>
									<td valign="middle"><s:property value="reviewGrade"/></td>
								</tr>
								</s:iterator>
								<tr>
									<td class="line" colspan="4"></td>
								</tr>
							</tbody>
						</table>
						</td>
					</tr>
					<tr>
						<td><!-- buttons -->
						<div class="paging">
							<s:if test="%{requestedPage > 1}">
								<s:url action="ViewGadgetReview" id="prevPageUrl">
								<s:param name="requestedPage" value="%{requestedPage - 1}" />
								</s:url>
							</s:if>
							<s:else>
								<s:url action="ViewGadgetReview" id="prevPageUrl">
								<s:param name="requestedPage" value="1" />
								</s:url>
							</s:else>
						 <em class="p"><s:a href="%{prevPageUrl}">이 전</s:a></em> <s:iterator
							value="pageList">
							<s:url action="ViewGadgetReview" id="pageUrl">
								<s:param name="requestedPage">
									<s:property />
								</s:param>
							</s:url>
							<s:a href="%{pageUrl}">
								<s:property />
							</s:a>
						</s:iterator> 
							<s:if test="%{requestedPage < maxPage}">
								<s:url action="ViewGadgetReview" id="nextPageUrl">
								<s:param name="requestedPage" value="%{requestedPage + 1}" />
								</s:url>
							</s:if>
							<s:else>
								<s:url action="ViewGadgetReview" id="nextPageUrl">
								<s:param name="requestedPage" value="%{maxPage}" />
								</s:url>
							</s:else>
						 <em class="n"><s:a href="%{nextPageUrl}">다음</s:a></em>
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