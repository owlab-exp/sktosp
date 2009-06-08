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
                      
<%@ include file="developernav.jsp"%>

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
          			<td align="center">이름</td> 
                	<td><s:text name="%{gadget.name}"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="center">아이디</td> 
                	<td><s:text name="%{gadget.id}"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#FFFFFF;" height="25">
          			<td align="center">전화번호</td> 
                	<td><s:text name="%{gadget.phone}"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="center">주소</td> 
                	<td><s:text name="%{gadget.address}"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="center">등록일</td> 
                	<td><s:text name="%{gadget.regDate}"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="center">마지막 가젯 등록일</td> 
                	<td>2009-06-05</td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="center">등록 가젯 수</td> 
                	<td>22</td> 
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
 	    			<s:url var="url" action="DeveloperController_changeStatus" namespace="/admin">
 	    			<s:param name="name" value="%{developer.name}" />
 	    			<s:param name="status" value="%{developer.status}" /></s:url>
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