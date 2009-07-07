<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/common/header.jsp"%>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >

<table height="567"	width="1000" border="1" cellspacing="0" cellpadding="0">

    <tr valign="top" height="15%">
  <!-- north -->
    <td colspan="3" align="center" valign="top" >
<%@ include file="/common/north_no_login.jsp"%>
    </td>
  </tr>
  
  <tr>
  <!-- west -->
    <td width="25%" align="center" valign="top" height="80%">

<%@ include file="/common/login.jsp"%>


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
            <li><strong>홈</strong></li>
            </ul>
            </div>
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