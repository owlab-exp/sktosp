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

        
        <!-- search -->
        <tr>
          <td>

	<s:form action="Search" theme="simple">
	    <s:select label="검색조건" name="searchfield" headerKey="1" headerValue="-- 선택하세요 --" list="#{'username':'사용자이름','gadget':'가젯이름'}"/> 
	    <s:textfield name="query"/> 
	    <s:submit value="검색"/>
	    
	</s:form>

		      </td>
	      </tr>

        
        <tr>
          <td>
          
            <!-- bbs -->
            <table cellpadding="0" cellspacing="0" width="100%" class="subtit_board" summary="게시판"> 
			<colgroup> 
                <col width="10%" /> 
                <col width="45%" /> 
                <col width="10%" />
                <col width="15%" />
                <col width="15%" /> 
                <col width="5%" /> 
              </colgroup>
              
<!--  <s:property value="gadgetlistStr"/>	-->
					
					<!--   
    			  <tr style="background-color:#F5F5F5;">
          			<td>이름</td> 
                	<td>설명</td> 
      			    <td align="center">개발자</td> 
      			    <td align="center">등록일자</td> 
      			    <td align="center">상태</td> 
      			    <td align="center">삭제</td> 
      			  </tr>
      			  
      			  -->
      			  
      			  <tr><td class="line" colspan="6"></td></tr>

    			<s:iterator value="gadgetlist">
    			  <tr> 
          			<td><span class="num"><s:url var="url" namespace="/admin" action="GadgetDetail"/><s:a href="%{url}"><s:property value="name"/></s:a></span></td> 
                	<td><s:property value="desc"/></td> 
      			    <td align="center">
      			    <s:url var="url" namespace="/admin" action="DeveloperDetail"/><s:a href="%{url}"><s:property value="owner"/></s:a>
      			    </td> 
      			    <td align="center"><span class="num"><s:property value="createdDate"/></span></td> 
      			    <td align="center">					
 	    			<s:url var="url" action="GadgetController_changeStatus" namespace="/admin">
 	    			<s:param name="name" value="%{gadget.name}" />
 	    			<s:param name="status" value="%{gadget.status}" /></s:url>
 	    			<s:a onclick='return confirmbox("비활성화하시겠습니까?", "%{url}");'>
 	    			<input type="button" value="<s:property value="status"/>"></s:a> 	    			
					</td>					 
      			    <td align="center">
 	    			<s:url var="url" action="GadgetController_delete" namespace="/admin">
 	    			<s:param name="name" value="%{gadget.name}" /></s:url>
 	    			<s:a onclick='return confirmbox("삭제하시겠습니까?", "%{url}");'>
 	    			<input type="button" value="삭제"></s:a>			    
      			    </td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
      			</s:iterator>
				</table>
            </td>
           </tr>
           <tr>
           	<td>
            <!-- paging --> 
		<s:if test="%{gadgetlist}">
			<div class="paging"> 
				<em class="p"><a href="">이전</a></em> 
				<span class="on">1</span>
				<a href="">2</a>
				<a href="">3</a>
				<em class="n"><a href="">다음</a></em> 
			</div>
		</s:if>
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