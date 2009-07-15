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
<script>
window.name="GadgetList";
</script>
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


		<s:form action="SearchGadget" theme="simple">
	    <s:select label="검색조건" name="searchfield" headerKey="1" 
	    list="#{'gadgetname':'가젯이름','gadgetstatus':'가젯상태','developerid':'개발자ID'}"/> 
	    <s:textfield name="query" value="%{query}"/> 
	    <s:submit value="검색"/>
	</s:form>

		      </td>
	      </tr>
	      
	      
        <tr>
          <td>

<s:if test="%{totalcount != 0}">

          
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
      			    <td align="center">등록일자
	<s:if test="%{sortsc == 'desc'}">
   			<s:url var="sortUrl" namespace="/admin">
   			<s:param name="searchfield" value="%{searchfield}" />
   			<s:param name="query" value="%{query}" />
   			<s:param name="sortfield">registerDate</s:param>
   			<s:param name="sortsc">asc</s:param>
   			</s:url>
			<s:a href="%{sortUrl}">▲</s:a> 
	</s:if>
	<s:else>
   			<s:url var="sortUrl" namespace="/admin">
   			<s:param name="searchfield" value="%{searchfield}" />
   			<s:param name="query" value="%{query}" />
   			<s:param name="sortfield">registerDate</s:param>
   			<s:param name="sortsc">desc</s:param>
   			</s:url>
			<s:a href="%{sortUrl}">▼</s:a> 	
	</s:else>
      			    </td> 
      			    <td align="center">발행일자</td> 
      			    <td align="center">선호등록인수</td> 
      			    <td align="center">상태
	<s:if test="%{sortsc == 'desc'}">
   			<s:url var="sortUrl" namespace="/admin">
   			<s:param name="searchfield" value="%{searchfield}" />
   			<s:param name="query" value="%{query}" />
   			<s:param name="sortfield">status</s:param>
   			<s:param name="sortsc">asc</s:param>
   			</s:url>
			<s:a href="%{sortUrl}">▲</s:a> 
	</s:if>
	<s:else>
   			<s:url var="sortUrl" namespace="/admin">
   			<s:param name="searchfield" value="%{searchfield}" />
   			<s:param name="query" value="%{query}" />
   			<s:param name="sortfield">status</s:param>
   			<s:param name="sortsc">desc</s:param>
   			</s:url>
			<s:a href="%{sortUrl}">▼</s:a> 	
	</s:else>
      			    </td> 
      			    <td align="center">작업</td> 
      			    <td align="center">삭제</td> 
      			  </tr>
      			  <tr><td class="line" colspan="10"></td></tr>


    			<s:iterator value="gadgets">
    			  <tr> 
    			  
					<s:url id="gadgetPreviewUrl" namespace="/developer" action="PreviewGadget">
						<s:param name="gadgetId"><s:property value="id"/></s:param>
					</s:url>    			  
                	<td><s:a href="%{gadgetPreviewUrl}" target="_blank"><s:property value="id"/></s:a></td> 
                	
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
							<a href="#" onclick="javascript:adminpopup('popup_gadget_publish_response.jsp?gadgetId=<s:property value="id"/>','GadgetPublish');">
							<input type="button" value="발행">
							</a>
						</s:elseif>
						<s:elseif test="%{status.equals('pg')}">
							<a href="#" onclick="javascript:adminpopup('popup_gadget_cancel.jsp?gadgetId=<s:property value="id"/>','GadgetCancel');">
							<input type="button" value="발행취소">
							</a>
 			
						</s:elseif>
						<s:elseif test="%{status.equals('pd')}">
						</s:elseif>
						<s:elseif test="%{status.equals('nr')}">
							
						</s:elseif>

					</td>
					<td align="center">
					<s:url id="removeGadgetUrl" action="RemoveGadget" namespace="/admin" method="requestConfirm">
		    			<s:param name="searchfield" value="%{searchfield}" />
		    			<s:param name="query" value="%{query}" />
		    			<s:param name="currentpage" value="%{currentpage}"/>					
						<s:param name="gadgetId"><s:property value="id"/></s:param>
					</s:url>
<!--  	    			<s:a onclick='return confirmbox("삭제하시겠습니까?", "%{removeGadgetUrl}");'>-->
<!-- 	    			<input type="button" value="삭제"></s:a>	    -->
					<s:a href="#" onclick="javascript:adminpopup('%{removeGadgetUrl}','RemoveConfirm')"><input type="button" value="삭제"></s:a>
      			    </td> 
      			  </tr>
      			  <tr><td class="line" colspan="10"></td></tr>
      			</s:iterator>

				</table>
</s:if>	<!-- totalcount == 0 -->
<s:else>
		        <table cellpadding="0" cellspacing="0" width="100%" height="100" class="subtit_board" summary="게시판">
		        	<tr>
		        		<td align="center" valign="middle" style="font-weight:bold">
		        			'<s:property value="%{query}"/>'로 검색된 결과가 없습니다.
		        		</td>
		        	</tr> 
				</table>
</s:else>				
				
            </td>
           </tr>
           <tr>
           	<td>
            <!-- paging --> 
            
			<div class="paging"> 
			
	<s:if test="%{prepage != 0}">
   			<s:url var="pagingUrl" namespace="/admin">
   			<s:param name="searchfield" value="%{searchfield}" />
   			<s:param name="query" value="%{query}" />
  			<s:param name="currentpage" value="%{prepage}"/>
   			<s:param name="sortfield" value="%{sortfield}" />
   			<s:param name="sortsc" value="%{sortsc}" />	
   			</s:url>
			<em class="p"><s:a href="%{pagingUrl}">이전</s:a></em> 
	</s:if>
	
<s:if test="%{totalcount != 0}">
<s:iterator value="paging">
    			<s:url var="pagingUrl" namespace="/admin">
    			<s:param name="searchfield" value="%{searchfield}" />
    			<s:param name="query" value="%{query}" />
    			<s:param name="currentpage" value="top"/>
	   			<s:param name="sortfield" value="%{sortfield}" />
	   			<s:param name="sortsc" value="%{sortsc}" />		
    			</s:url>

	  			<s:if test="%{currentpage.equals(top)}">
					<span class="on"><s:property/></span>
				</s:if>
				<s:else>
	    			<s:a href="%{pagingUrl}"><s:property/></s:a>				
				</s:else>    			
</s:iterator>
</s:if>

	<s:if test="%{postpage != 0}">
   			<s:url var="pagingUrl" namespace="/admin">
   			<s:param name="searchfield" value="%{searchfield}" />
   			<s:param name="query" value="%{query}" />
   			<s:param name="currentpage" value="%{postpage}"/>
   			<s:param name="sortfield" value="%{sortfield}" />
   			<s:param name="sortsc" value="%{sortsc}" />	
   			</s:url>
			<em class="p"><s:a href="%{pagingUrl}">다음</s:a></em> 
	</s:if>		
				
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