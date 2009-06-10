<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
            <li>사용자 메뉴</li>
            <li><strong>마이페이지</strong></li> 
            </ul>
            </div>
          </td>
        </tr>
 
 	    <tr>
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
                	<td><s:text name="%{user.name}"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="center">아이디</td> 
                	<td><s:text name="%{user.id}"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#FFFFFF;" height="25">
          			<td align="center">전화번호</td> 
                	<td><s:text name="%{user.phone}"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="center">주소</td> 
                	<td><s:text name="%{user.address}"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="center">가입일</td> 
                	<td><s:text name="%{user.regDate}"/></td> 
      			  </tr>
      			<tr><td class="line" colspan="6"></td></tr>
      			
      			<s:form action="Modification" namespace="/user" >

		  			<tr>
		   				<td width='100%' bgcolor='#FFFFFF'>
		      				<table border='0' cellpadding='0' cellspacing='0' width='100%'>
		    					<colgroup> 

                					<col width="40%" /> 
                					<col width="60%" />
								</colgroup>
		        				<tr>
		          		          	<s:submit align="left" value= "개인정보수정" name= "modification" 
	               />
				</tr>
		     				</table>
		     			</td>
		     		</tr>
		     	</s:form>    			
      			
      			
      		  </table>
 
             <table cellpadding="0" cellspacing="0" width="100%" class="subtit_board" summary="게시판"> 
			 <colgroup> 
                <col width="10%" /> 
                <col width="45%" /> 
                <col width="10%" />
                <col width="15%" />
                <col width="15%" /> 
                <col width="5%" /> 
              </colgroup>
              
    		  <tr style="background-color:#F5F5F5;">
        		<td>이름</td> 
              	<td>설명</td> 
      		    <td align="center">개발자</td> 
      		    <td align="center">등록일자</td> 
      		    <td align="center">상태</td> 
      		    <td align="center">삭제</td> 
      		  </tr>
      			  
      		<tr><td class="line" colspan="6"></td></tr>
			<tr>
    			<s:iterator value="gadgetlist">
    			  <tr> 
          			<td><span class="num"><s:url var="url" namespace="/user" action="GadgetList"/><s:a href="%{url}"><s:property value="name"/></s:a></span></td> 
                	<td><s:property value="desc"/></td> 
      			    <td align="center">
      			    <s:url var="url" namespace="/user" action="DeveloperDetail"/><s:a href="%{url}"><s:property value="owner"/></s:a>
      			    </td> 
      			    <td align="center"><span class="num"><s:property value="createdDate"/></span></td> 
					 
      			    <td align="center">
 	    			<s:url var="url" action="GadgetController_delete" namespace="/user">
 	    			<s:param name="name" value="%{gadget.name}" /></s:url>
 	    			<s:a onclick='return confirmbox("삭제하시겠습니까?", "%{url}");'>
 	    			<input type="button" value="삭제"></s:a>			    
      			    </td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
      			</s:iterator>
      		 </tr>
		   </table>
		  </tr>
		  
          <tr>
           	<td>
            <!-- paging --> 
            
			<div class="paging"> 
				<em class="p"><a href="">이전</a></em> 
				<span class="on">1</span>
				<a href="">2</a>
				<a href="">3</a>
				<em class="n"><a href="">다음</a></em> 
			</div>
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
	</td>
  </tr> 

</table>


</body>
</html>