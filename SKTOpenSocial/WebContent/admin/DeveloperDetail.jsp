<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="s" uri="/struts-tags" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin.js"></script>
<title>관리자 개발자 상세 보기</title>
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

<%@ include file="/common/west_admin.jsp"%>

    </td>
    <!-- east -->
    <td width="75%" align="left" valign="top">
      <div id="east">
  
      <table width="100%" cellpadding="10">
        <!-- navigation -->
        <tr>
          <td>
                      
<%@ include file="developernav.jsp"%>

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

    		<s:iterator value="displayList" status="stat">
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="left"><s:property/></td>
                	<td align="center"><s:text name="%{top}"/></td>
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
    		</s:iterator>
     		 </table>
 	     </td>
 	    </tr>
 	    <tr>
 	    	<td align="center">
 	    	<table width="80%">
 	    		<tr>
 	    			<td style="font-size=13px">
						<a href="#" onclick="javascript:adminpopup('popup_developer_cancel.jsp?developerId=<s:property value="%{user_id}"/>','DeveloperCancel');"><input type="button" value="개발자취소"></a>
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
  </tr> 
</table>

</body>

</html>