<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="com.skt.opensocial.common.*" %>
<%@page import="com.skt.opensocial.persistence.*" %>
<%@page import="org.hibernate.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
<title>SKT OpenSocial Pilot - My Page</title>
</head>

<body leftmargin="0" topmargin="0"
	style="background-color: rgb(255, 255, 255);" marginheight="0"
	marginwidth="0">
	
<table border="1" cellpadding="0" cellspacing="0" height="567"
	width="1000">
  <!-- north -->
  <tr valign="top" height="15%">
    <td colspan="3" align="center" valign="top">
<%@ include file="/common/north.jsp"%>
    </td>
  </tr>
  <tr valign="top" height="80%">
  <!-- west -->
    <td width="25%" align="center" valign="top">

<%@ include file="/user/west_user.jsp"%>

    </td>
    <!-- east -->
    <td width="75%" align="left" valign="top">
    
      <div id="east">
  
      <table width="100%" cellpadding="10">
        <!-- navigation -->
        <tr>
          <td>            
            <div class="subject subject_char"> 
            <ul class="subject_sub">
            <li>홈</li>
            <li><strong>사용자검색결과</strong></li> 
            </ul>
            </div>
          </td>
        </tr>
 
 	    <tr>
 	    	<td>
            <!-- detail -->

            <table cellpadding="0" cellspacing="0" width="100%" border="1"> 
			<colgroup> 
                <col width="20%" /> 
                <col width="20%" /> 
                <col width="60%" /> 
			</colgroup>
			
				<tr>
          			<td rowspan="14"><img src='<s:url value="../images/logo.jpg"/>'></td> 
      			</tr>
			           
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="left">이름</td> 
                	<td align="center"><s:property value="name"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="left">아이디</td> 
                	<td align="center"><s:property value="otherUserId"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#FFFFFF;" height="25">
          			<td align="left">전화번호</td> 
                	<td align="center"><s:property value="otherUserId"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="left">나이</td> 
                	<td align="center"><s:property value="age"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="left">가입일</td> 
                	<td align="center"><s:property value="registeredDate"/></td> 
      			  </tr>
      			<tr><td class="line" colspan="6"></td></tr>
  
      		</table>
      		  
      		  <table cellpadding="0" cellspacing="0" width="100%" border="1"> 
					<colgroup> 
		                <col width="20%" /> 
		                <col width="20%" /> 
		                <col width="60%" /> 
					</colgroup>
				

	  			<tr>
	   				<td width='100%' bgcolor='#FFFFFF' align="center">
		      			<s:form action="SetFriend" namespace="/user" >

		        		<s:submit align="left" value= "친구등록" name= "SetFriend" />
						<s:hidden name="friendId" value="%{userId}"/>
		     			</s:form>    			
		     		</td>
		     	</tr>
      		  </table>
      		        		  
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
							<td>가젯이름</td>
							<td align="center">개발자</td>
							<td align="center">발행일자</td>
							<td align="center">사용자수</td>
							<td align="center">가젯설명</td>
							<td align="center">삭제요청</td>

						</tr>
						<s:iterator value="otherUserGadgets">
						<tr style="background-color: rgb(300, 300, 300);">
							<s:url id="gadgetInfoUrl" action="GadgetInfo">
								<s:param name="gadgetId"><s:property value="id"/></s:param>
							</s:url>
							<s:url id="userInfoUrl" action="UserInfo">
								<s:param name="developername"><s:property value="developer.person.nameFormatted"/></s:param>
							</s:url>
							<s:url id="userRemoveGadgetUrl" action="UserRemoveGadget">
								<s:param name="gadgetId"><s:property value="id"/></s:param>
							</s:url>
							<td><s:a href="%{gadgetInfoUrl}"><s:property value="id"/></s:a></td>
							<td><s:a href="%{gadgetInfoUrl}"><s:property value="name"/></s:a></td>
							<td align="center"><s:a href="%{userInfoUrl}"><s:property value="developer.person.nameFormatted" /></s:a></td>
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
						      		  
      		  <!-- east -->
			
			<!-- east div -->
      		  
 			</td>
		  </tr>

      </table>
      
     </div> <!-- east div -->
      
    </td>
  </tr>

  <!-- south -->
  <tr>
    <td colspan="3" align="center" valign="middle" style="background-color:#F5F5F5;" height="30px" >
<%@ include file="/common/south.jsp"%>
	</td>
  </tr> 

</table>


</body>
</html>