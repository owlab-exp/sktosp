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
<title>관리자 가젯 리스트 보기</title>
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
          			<td rowspan="14"><img src='<s:url value="../images/logo.jpg"/>'></td> 
      			</tr>
			           
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="center">가젯ID</td> 
                	<td><s:property value="gadgetId"/></td> 
      			</tr>
      			<tr><td class="line" colspan="6"></td></tr>

				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="center">가젯이름</td> 
                	<td><s:property value="gadgetName"/></td> 
      			</tr>
      			<tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#FFFFFF;" height="25">
          			<td align="center">개발자</td> 
                	<td><s:property value="%{developer.id}"/></td> 
      			</tr>
      			<tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="center">선호등록유저수</td> 
                	<td><s:property value="%{favoriteUsers.size()}"/></td> 
      			</tr>
      			<tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="center">소개</td> 
                	<td><s:property value="gadgetIntro"/></td> 
      			  </tr>
      			<tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="center">상태</td> 
                	<td>
					<s:if test="%{gadgetStatus.equals('rg')}">
						등록완료
					</s:if>
					<s:elseif test="%{gadgetStatus.equals('pr')}">
						발행요청
					</s:elseif>
					<s:elseif test="%{gadgetStatus.equals('pg')}">
						발행완료
					</s:elseif>
					<s:elseif test="%{gadgetStatus.equals('pd')}">
						발행거절
					</s:elseif>
					<s:elseif test="%{gadgetStatus.equals('nr')}">
						미등록
					</s:elseif>                	
                	</td> 
                	
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

					<s:url id="removeGadgetUrl" action="RemoveGadget" namespace="/admin">
						<s:param name="gadgetId"><s:property value="gadgetId"/></s:param>
					</s:url>
  	    			<s:a onclick='return confirmbox("삭제하시겠습니까?", "%{removeGadgetUrl}");'>
 	    			<input type="button" value="삭제"></s:a>
 	    			</td>
 	    			<td style="font-size=13px">
 	    			
 	    			

      					<s:if test="%{gadgetStatus.equals('rg')}">
		 	    			<s:url var="url" action="GadgetController_changeStatus" namespace="/admin">
		 	    			<s:param name="name" value="%{gadget.name}" />
		 	    			<s:param name="status" value="%{gadget.status}" /></s:url>
		 	    			<s:a onclick='return confirmbox("발행취소하시겠습니까?", "%{url}");'>
		 	    			<input type="button" value="발행취소"/></s:a> 	     			
						</s:if>
						<s:elseif test="%{gadgetStatus.equals('pr')}">
							<a href="#" onclick="javascript:adminpopup('popup_gadget_publish_response.jsp?gadgetId=<s:property value="gadgetId"/>','GadgetPublish');">
							<input type="button" value="발행">
							</a>
						</s:elseif>
						<s:elseif test="%{gadgetStatus.equals('pg')}">
		 	    			<s:url var="url" action="GadgetController_changeStatus" namespace="/admin">
		 	    			<s:param name="name" value="%{gadget.name}" />
		 	    			<s:param name="status" value="%{gadget.status}" /></s:url>
		 	    			<s:a onclick='return confirmbox("발행취소하시겠습니까?", "%{url}");'>
		 	    			<input type="button" value="발행취소"/></s:a>    			
						</s:elseif>
						<s:elseif test="%{gadgetStatus.equals('pd')}">
							
						</s:elseif>
						<s:elseif test="%{gadgetStatus.equals('nr')}">
							
						</s:elseif>

 	    			
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