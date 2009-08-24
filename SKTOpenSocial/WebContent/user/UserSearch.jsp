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
<title>SKT OpenSocial Pilot - User, Gadget, Tag Search</title>
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
            <li>사용자 메뉴</li>
            <li><strong>친구찾기</strong></li> 
            </ul>
            </div>
          </td>
        </tr>
 
 	    <!-- search -->
        <tr>
          <td>
		
			<s:form action="Search" namespace="/user" theme="simple">
			    <s:select label="검색조건" name="searchfield" headerKey="1" list="#{'username':'사용자이름', 'tag':'사용자태그'}"/> 
			    <s:textfield name="query"/> 
			    <s:submit value="검색"/>
			    
			</s:form>
	
		      </td>
	      </tr>
 		  <tr>
	    	<td> -- 검색어의 종류를 사용자 이름 혹은 사용자 태그를 먼저 선택하세요. -- </td> 
	      </tr>	
	      <tr>
	    	<td> -- 입력된 검색어를 포함한 사용자 이름 혹은 사용자태그를 가진 사용자들을 목록으로 보여 드립니다. --</td> 
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