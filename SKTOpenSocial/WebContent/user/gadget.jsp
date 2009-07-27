<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="s" uri="/struts-tags" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
<title>SKT OpenSocial Pilot - Gadget Information</title>
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
            <li><strong>가젯정보페이지</strong></li> 
            </ul>
            </div>
          </td>
        </tr>
 
 		<tr>
 			<td>
 			<form id="createaccount" action="UpdateUserInfo" method="post">
  			<input type="hidden" name="timeStmp" id="timeStmp" value='1244032680'/>
			<input type="hidden" name="secTok" id="secTok" value='8fcbe0f2eec327eba0c743c1c5270b74'/>
  			<table width="100%" cellpadding="3">
  				<tr>
  					<td nowrap>
  						<b><font color="#333333">
  						가젯 정보
  							</font></b>
  					</td>
  					<td width="100%"><hr></td>
  				</tr>
  			</table>
  			<table width="100%" border="0" cellspacing="2" cellpadding="2">
  				<tr>
  					<td width="20%" nowrap="nowrap" valign="top">
  						<font size="-1">
  						가젯이름:
  						</font>
  					</td>
  					<td>
  					<input  type="text" name="LastName"  id="LastName" size="30" value="Lim" />
  					</td>
  				</tr>
  				<tr>
  					<td width="20%" nowrap="nowrap" valign="top">
  						<font size="-1">
  						가젯개발자:
 						 </font>
  					</td>
  					<td>
  						<input  type="text" name="FirstName"  id="FirstName" size="30" value="Seong Yong" />
  					</td>
  				</tr>
  				<tr>
  					<td width="20%" nowrap="nowrap" valign="top">
  						<font size="-1">
  							가젯개발날짜:
  						</font>
  					</td>
	  				<td>
	  				<input  type="text" name="NickName"  id="NickName" size="30" value="nyongs" />
	  				</td>			
  				</tr>
  			</table>
			</form>
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