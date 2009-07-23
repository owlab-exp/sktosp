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
<title>사용자 가젯 모음</title>
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
							<li><strong>내 가젯 모음</strong></li>
						</ul>
						</div>
						</td>
					</tr>
					<tr>
						<td><!-- list of gadgets -->
						<table class="subtit_board" summary="List of Gadgets"
							cellpadding="0" cellspacing="0" width="100%">
							<colgroup>
								<col width="15%">
								<col width="15%">
								<col width="15%">
								<col width="15%">
								<col width="15%">
								<col width="20%">
								<col width="5%">

							</colgroup>
							<tbody>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>가젯ID</td>
									<td>가젯이름
										<s:if test="%{sortsc == 'desc'}">
								   			<s:url var="sortUrl" >
								   			<s:param name="sortfield">name</s:param>
								   			<s:param name="sortsc">asc</s:param>
								   			</s:url>
											<s:a href="%{sortUrl}">▲</s:a> 
										</s:if>
										<s:else>
								   			<s:url var="sortUrl" >
								   			<s:param name="sortfield">name</s:param>
								   			<s:param name="sortsc">desc</s:param>
								   			</s:url>
											<s:a href="%{sortUrl}">▼</s:a> 	
										</s:else>
									</td>
									<td align="center">개발자</td>
									<td align="center">발행일자
										<s:if test="%{sortsc == 'desc'}">
								   			<s:url var="sortUrl" >
								   			<s:param name="sortfield">publishDate</s:param>
								   			<s:param name="sortsc">asc</s:param>
								   			</s:url>
											<s:a href="%{sortUrl}">▲</s:a> 
										</s:if>
										<s:else>
								   			<s:url var="sortUrl" >
								   			<s:param name="sortfield">publishDate</s:param>
								   			<s:param name="sortsc">desc</s:param>
								   			</s:url>
											<s:a href="%{sortUrl}">▼</s:a> 	
										</s:else>
									</td>
									<td align="center">사용자수</td>
									<td align="center">가젯설명</td>
									<td align="center">삭제요청</td>

								</tr>
								<s:iterator value="gadgets">
								<tr style="background-color: rgb(300, 300, 300);">
									<s:url id="gadgetInfoUrl" action="GadgetInfo">
										<s:param name="gadgetId"><s:property value="id"/></s:param>
										<s:param name="ownerId"><s:property value="userId"/></s:param>
									</s:url>
									<s:url id="userOtherUserInfoUrl" action="SearchOtherUserInfo">
										<s:param name="otherUserId"><s:property value="developer.id"/></s:param>
									</s:url>
									<s:url id="userRemoveGadgetUrl" action="UserRemoveGadget">
										<s:param name="gadgetId"><s:property value="id"/></s:param>
									</s:url>
									<td><s:a href="%{gadgetInfoUrl}"><s:property value="id"/></s:a></td>
									<td><s:a href="%{gadgetInfoUrl}"><s:property value="name"/></s:a></td>
									<td align="center"><s:a href="%{userOtherUserInfoUrl}"><s:property value="developer.person.nameFormatted" /></s:a></td>
									<td align="center"><s:date name="publishDate" format="yyyy/MM/dd"/></td>
									<td align="center"><s:property value="favoriteUsers.size"/></td>
									<td align="center"><s:property value="introduction"/></td>
									<td align="center"><s:a href="%{userRemoveGadgetUrl}">삭제</s:a></td>
									
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
							<div class="paging"> 
			
							<s:if test="%{prepage != 0}">
						   			<s:url var="pagingUrl" >
						  			<s:param name="currentpage" value="%{prepage}"/>
						   			<s:param name="sortfield" value="%{sortfield}" />
						   			<s:param name="sortsc" value="%{sortsc}" />	
						   			</s:url>
									<em class="p"><s:a href="%{pagingUrl}">이전</s:a></em> 
							</s:if>
	
							<s:if test="%{totalcount != 0}">
								<s:iterator value="paging">
					    			<s:url var="pagingUrl" >
						    			<s:param name="currentpage" value="top"/>
							   			<s:param name="sortfield" value="%{sortfield}" />
							   			<s:param name="sortsc" value="%{sortsc}" />		
					    			</s:url>
					
						  			<s:if test="%{currentpage.equals(top)}">
										<span class="on"><s:property/></span>
									</s:if>
									<s:else>
						    			<s:a href="%{pagingUrl}"><s:property/></s:a>				
									</s:else>    			
								</s:iterator>
							</s:if>

							<s:if test="%{postpage != 0}">
						   			<s:url var="pagingUrl" >
						   			<s:param name="currentpage" value="%{postpage}"/>
						   			<s:param name="sortfield" value="%{sortfield}" />
						   			<s:param name="sortsc" value="%{sortsc}" />	
						   			</s:url>
									<em class="p"><s:a href="%{pagingUrl}">다음</s:a></em> 
							</s:if>		
				
							</div>
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