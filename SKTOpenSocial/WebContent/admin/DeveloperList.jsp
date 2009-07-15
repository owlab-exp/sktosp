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
window.name="DeveloperList";
</script>
<title>관리자  개발자리스트 보기</title>
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

        
        <!-- search -->
        <tr>
          <td>


		<s:form action="SearchGadget" theme="simple">
	    <s:select label="검색조건" name="searchfield" headerKey="1" list="#{'developername':'개발자이름','developerid':'개발자ID'}"/>	     	     
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
                <col width="20%" /> 
                <col width="20%" /> 
                <col width="20%" />
                <col width="20%" />
                <col width="20%" /> 
                <col width="20%" /> 
              </colgroup>
   			  <tr style="background-color:#F5F5F5;">
           			<td>아이디</td> 
                	<td>이름</td> 
      			    <td align="center">생일</td> 
      			    <td align="center">소개</td> 
      			    <td align="center">등록일
	<s:if test="%{sortsc == 'desc'}">
   			<s:url var="sortUrl" namespace="/admin">
   			<s:param name="searchfield" value="%{searchfield}" />
   			<s:param name="query" value="%{query}" />
   			<s:param name="sortfield">registeredDate</s:param>
   			<s:param name="sortsc">asc</s:param>
   			</s:url>
			<s:a href="%{sortUrl}">▲</s:a> 
	</s:if>
	<s:else>
   			<s:url var="sortUrl" namespace="/admin">
   			<s:param name="searchfield" value="%{searchfield}" />
   			<s:param name="query" value="%{query}" />
   			<s:param name="sortfield">registeredDate</s:param>
   			<s:param name="sortsc">desc</s:param>
   			</s:url>
			<s:a href="%{sortUrl}">▼</s:a> 	
	</s:else>
      			    </td> 
      			    <td align="center">비활성</td> 
      			  </tr>
      			  <tr><td class="line" colspan="10"></td></tr>


    			<s:iterator value="developers">
    			  <tr> 
    			  
                	<td><s:property value="id"/></td> 
                	
          				<s:url var="DeveloperDetailUrl" namespace="/admin" action="DeveloperDetail">
          					<s:param name="developerId"><s:property value="id"/></s:param>
          				</s:url>
          			<td><span class="num"><s:a href="%{DeveloperDetailUrl}"><s:property value="person.nameFormatted"/></s:a></span></td> 
          			
                	<td align="center"><s:property value="person.birthday"/></td> 
               		<td align="center"><s:property value="person.aboutme"/></td> 
					<td align="center"><s:date name="registeredDate" format="yyyy/MM/dd"/></td>
					<td align="center">
					     <s:if test="%{isDeveloper.equals('1')}">
							<a href="#" onclick="javascript:adminpopup('popup_developer_cancel.jsp?developerId=<s:property value="id"/>','DeveloperCancel');"><input type="button" value="개발자취소"></a>
						</s:if>
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