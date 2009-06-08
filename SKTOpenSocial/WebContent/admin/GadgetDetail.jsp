<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/common/header.jsp"%>

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

<%@ include file="/common/west.jsp"%>

    </td>
    <!-- east -->
    <td width="75%" align="left" valign="top">
      <div id="east">
  
      <table width="100%" cellpadding="10">
        <!-- navigation -->
        <tr>
          <td>
                      
<%@ include file="gadgetnav.jsp"%>

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
          			<td rowspan="8"><img src='<s:url value="../images/logo.jpg"/>'></td> 
      			</tr>
			           
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="center">가젯명</td> 
                	<td><s:text name="%{gadget.name}"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#FFFFFF;" height="25">
          			<td align="center">개발자</td> 
                	<td><s:text name="%{gadget.owner}"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="center">등록유저수</td> 
                	<td><s:text name="%{gadget.numRegUsers}"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="center">소개</td> 
                	<td><s:text name="%{gadget.desc}"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
     		 </table>
 	     </td>
 	    </tr>
 	    <tr>
 	    	<td align="center">
 	    	<table width="80%">
 	    		<tr>
 	    			<td style="font-size=13px">
 	    			<s:url var="url" action="GadgetController_delete" namespace="/admin">
 	    			<s:param name="name" value="%{gadget.name}" /></s:url>
 	    			<s:a onclick='return confirmbox("삭제하시겠습니까?", "%{url}");'>
 	    			<input type="button" value="삭제"></s:a>
 	    			</td>
 	    			<td style="font-size=13px">
 	    			<s:url var="url" action="GadgetController_changeStatus" namespace="/admin">
 	    			<s:param name="name" value="%{gadget.name}" />
 	    			<s:param name="status" value="%{gadget.status}" /></s:url>
 	    			<s:a onclick='return confirmbox("비활성화하시겠습니까?", "%{url}");'>
 	    			<input type="button" value="비활성화"></s:a>
 	    			</td>
 	    		</tr>
 	    	</table>
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
</table>

</body>

</html>