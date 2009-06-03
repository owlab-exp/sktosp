<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>User Gadget Page - SKT OpenSocial Pilot</title>

<link rel="stylesheet" type="text/css" href="main.css">
<script type="text/javascript" src="main.js"></script>

</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >

<table width="1023" height="767" border="1" cellspacing="0" cellpadding="0">
  <tr>
  <!-- north -->
    <td colspan=3 height="10%" align="center" valign="middle">
      <div id="header">
      <table width="100%" height="100%" border="1">
        <tr align="center">
          <td width="25%" onclick="javascript:location.href=''">홈</td>
          <td width="20%">사용자 메뉴</td>
          <td width="20%">개발자 메뉴</td>
          <td></td>
          <td width="10%">관리자</td>
        </tr>
      </table>
    </div>
    </td>
  </tr>
  <tr>
  <!-- west -->
    <td width="25%" align="center" valign="top">
    <div id="west">
      <div class="login">
      <table>
        <tr>
          <td>
              <form id="login" name="login" action="login.jsp" target="_self" method="post" autocomplete="off" onsubmit="return form_chk();"> 
              이메일: <input type="text" id="loginEmail" name="email" class="bg" title="이메일 주소 입력" onfocus="ChgInput(this);" onkeydown="ChgInput(this);" onmouseover="this.focus();" datatype="an" mask="-_@." /> 
              <br>비밀번호: <input type="password" id="loginPasswd" name="passwd" class="bg" title="비밀번호 입력" onfocus="ChgInput(this);" onkeydown="ChgInput(this);" onmouseover="this.focus();" enc="on" /> 
              <br><br><input type="submit" class="btn" title="로그인버튼" value="로그인"/> 
              <input type="hidden" id="loginEChk" name="echk" value="" /> 
              </form>
          </td>
        </tr>
      </table>
      </div>
    </div>
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

      	</tr>
      </table>
      
      </div> <!-- east div -->
      
    </td>
  </tr>
  <!-- south -->
  <tr>
    <td colspan=3 height="10%" align="center" valign="middle">
      <div id="footer">
      <table width="100%" height="100%" border="1px">
        <tr>
          <td><strong>Copyright &copy; SK Telecom. All rights reserved.</strong>
          </td>
        </tr>
      </table>
      </div>
      </td>
	</tr> 
</table>


</body>
</html>