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
<script type="text/javascript" src="../js/developer.js"></script>
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

        
        <!-- search -->
        <tr>
          <td>


		<s:form action="GadgetList" theme="simple">
	    <s:select label="검색조건" name="searchfield" headerKey="1" headerValue="-- 선택하세요 --" list="#{'NAME':'이름','DEVELOPER_ID':'개발자'}"/> 
	    <s:textfield name="query" value="%{query}"/> 
	    <s:submit value="검색"/>
	</s:form>

		      </td>
	      </tr>
	      
	      
        <tr>
          <td>
          
            <!-- bbs -->
            <table cellpadding="0" cellspacing="0" width="100%" class="subtit_board" summary="게시판"> 
			<colgroup> 
                <col width="5%" /> 
                <col width="10%" /> 
                <col width="20%" />
                <col width="10%" />
                <col width="10%" /> 
                <col width="10%" /> 
                <col width="10%" /> 
                <col width="10%" /> 
                <col width="10%" /> 
                <col width="5%" /> 
              </colgroup>
              
<!--  <s:property value="gadgetlistStr"/>	-->

    			  <tr style="background-color:#F5F5F5;">
          			<td>번호</td> 
          			<td>이름</td> 
                	<td>설명</td> 
      			    <td align="center">개발자</td> 
      			    <td align="center">등록일자</td> 
      			    <td align="center">발행일자</td> 
      			    <td align="center">선호등록인수</td> 
      			    <td align="center">상태</td> 
      			    <td align="center">작업</td> 
      			    <td align="center">삭제</td> 
      			  </tr>
      			  <tr><td class="line" colspan="10"></td></tr>


    			<s:iterator value="gadgets">
    			  <tr> 
    			  
					<s:url id="gadgetPreviewUrl" namespace="/developer" action="PreviewGadget">
						<s:param name="gadgetId"><s:property value="id"/></s:param>
					</s:url>    			  
                	<td><s:a href="%{gadgetPreviewUrl}"><s:property value="id"/></s:a></td> 
                	
          				<s:url var="GadgetDetailUrl" namespace="/admin" action="GadgetDetail">
          					<s:param name="gadgetId"><s:property value="id"/></s:param>
          				</s:url>
          			<td><span class="num"><s:a href="%{GadgetDetailUrl}"><s:property value="name"/></s:a></span></td> 
          			
                	<td><s:property value="introduction"/></td> 
      			    <td align="center">
      			    <s:url var="url" namespace="/admin" action="DeveloperDetail"/><s:a href="%{url}"><s:property value="developer.id"/></s:a>
      			    </td> 
					<td align="center"><s:date name="registerDate" format="yyyy/MM/dd"/></td>
					<td align="center"><s:date name="publishDate" format="yyyy/MM/dd"/></td>
					<td align="center"><s:property value="favoriteUsers.size"/></td>
      			    
					<td align="center">
					<s:if test="%{status.equals('rg')}">
						등록완료
					</s:if>
					<s:elseif test="%{status.equals('pr')}">
						발행요청
					</s:elseif>
					<s:elseif test="%{status.equals('pg')}">
						발행완료
					</s:elseif>
					<s:elseif test="%{status.equals('pd')}">
						발행거절
					</s:elseif>
					<s:elseif test="%{status.equals('nr')}">
						미등록
					</s:elseif>
					</td>
					 
      			    <td align="center">      			    
     					<s:if test="%{status.equals('rg')}">

						</s:if>
						<s:elseif test="%{status.equals('pr')}">
							<a href="#" onclick="javascript:adminpopup('popup_gadget_publish_response.jsp?gadgetId=<s:property value="gadgetId"/>','GadgetPublish');">
							<input type="button" value="발행">
							</a>
						</s:elseif>
						<s:elseif test="%{status.equals('pg')}">
		 	    			<s:url var="url" action="GadgetController_changeStatus" namespace="/admin">
		 	    			<s:param name="name" value="%{gadget.name}" />
		 	    			<s:param name="status" value="%{gadget.status}" /></s:url>
		 	    			<s:a onclick='return confirmbox("발행취소하시겠습니까?", "%{url}");'>
		 	    			<input type="button" value="발행취소"/></s:a>    			
						</s:elseif>
						<s:elseif test="%{status.equals('pd')}">
							
						</s:elseif>
						<s:elseif test="%{status.equals('nr')}">
							
						</s:elseif>

					</td>
					<td align="center">
					<s:url id="removeGadgetUrl" action="RemoveGadget" namespace="/admin">
						<s:param name="gadgetId"><s:property value="gadgetId"/></s:param>
					</s:url>
  	    			<s:a onclick='return confirmbox("삭제하시겠습니까?", "%{removeGadgetUrl}");'>
 	    			<input type="button" value="삭제"></s:a>	    
      			    </td> 
      			  </tr>
      			  <tr><td class="line" colspan="10"></td></tr>
      			</s:iterator>

				</table>
            </td>
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
    <td colspan="3" align="center" valign="middle" style="background-color:#F5F5F5;" height="30px" >
<%@ include file="/common/south.jsp"%>
	</td>
  </tr> 
</table>

</body>

</html>