<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/common/header.jsp"%>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >

<table width="1023" height="767" border="1" cellspacing="0" cellpadding="0">
  <tr>
  <!-- north -->
    <td colspan="3" height="10%" align="center" valign="middle">

<%@ include file="/common/north.jsp"%>

    </td>
  </tr>
  <tr>
  <!-- west -->
    <td width="25%" align="center" valign="top">

<%@ include file="/common/west.jsp"%>
<%@ include file="/common/menu.jsp"%>

    </td>
    <!-- east -->
    <td width="75%" align="left" valign="top">
      <div id="east">
  
      <table width="100%" cellpadding="10">
        <!-- navigation -->
        <tr>
          <td>
                      
<%@ include file="/common/nav.jsp"%>

          </td>
        </tr>
     
        <tr>
          <td>
          
            <!-- detail -->
            <table cellpadding="0" cellspacing="0" width="100%" border="1"> 
			<colgroup> 
                <col width="20%" /> 
                <col width="80%" /> 
			</colgroup>            
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="center">이름</td> 
                	<td><s:property value="gadget"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#FFFFFF;" height="25">
          			<td align="center">이름</td> 
                	<td><s:property value="name"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="center">이름</td> 
                	<td><s:property value="name"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>

     		 </table>
 	     </td>
 	    </tr>
 	    </table>
      </div> <!-- east div -->
    </td>
  </tr>
  <!-- south -->
  <tr>
    <td colspan=3 height="10%" align="center" valign="middle">
<%@ include file="/common/south.jsp"%>
	</tr> 
</table>

</body>

</html>