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
<title>가젯 리뷰</title>
</head>
<body leftmargin="0" topmargin="0"
	style="background-color: rgb(255, 255, 255);" marginheight="0"
	marginwidth="0">    
      <div id="south">
      <table width="100%" height="30px" border="0">
        
        <colgroup>
			<col width="50%">
			<col width="15%">
			<col width="20%">
			<col width="15%">			
		</colgroup>
		<tbody>
			<tr style="background-color: rgb(245, 245, 245);">
				<td>리뷰</td>
				<td>평가</td>
				<td align="center">리뷰어</td>
				<td align="center">작업</td>
			</tr>
			
			<s:iterator value="gadgetReviews">
				<tr style="background-color: rgb(300, 300, 300);">
					<s:url id="userInfoUrl" action="SearchOtherUserInfo">
						<s:param name="otherUserId"><s:property value="reviewer.id"/></s:param>
					</s:url>
					<s:url id="removeReviewUrl" action="RemoveReview">
						<s:param name="gadgetId"><s:property value="gadgetId"/></s:param>
						<s:param name="reviewId"><s:property value="id"/></s:param>
					</s:url>
					<td align="left"><s:property value="reviewText"/></td>
					<td align="center"><s:property value="reviewGrade"/></td>
					<td align="center"><s:property value="reviewer.person.nameFormatted"/></td>
					<td align="center">
						<s:if test="%{userId.equals(reviewer.id)}">
							<s:a href="%{removeReviewUrl}">삭제</s:a>
						</s:if>
					</td>
				</tr>
			</s:iterator>

       		<tr>
          	 
          	<s:form action="AddReview" namespace="/user" theme="simple">
	    	<td> 
	    		<s:textarea  name="reviewText"/>
	    	</td> 
	    	<td> 
	    		<s:select label="평가" name="reviewGrade" headerKey="1" headerValue="- 선택 -" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5','6':'6','7':'7','8':'8','9':'9','10':'10'}"/>
	    	</td>
	    	<td>
	    		<s:hidden name="gadgetId" value="%{gadgetId}"/>
	    		<s:submit value="리뷰추가"/>
	    	</td>     
          	      
          	</s:form>          
        	</tr>
        </tbody>
      </table>
      </div>
   </body>
 </html>