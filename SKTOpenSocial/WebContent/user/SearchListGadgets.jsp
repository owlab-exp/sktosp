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
<%@ include file="/common/north.jsp"%>
    </td>
  </tr>
  
  <tr>
  <!-- west -->
    <td width="25%" align="center" valign="top" height="80%">

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
            	<li>사용자메뉴</li>
				<li><strong>가젯검색결과</strong></li>
            </ul>
            </div>
          </td>
        </tr>

        
        <!-- search -->
        <tr>
          <td>

	<s:form action="Search" namespace="/user" theme="simple">
	    <s:select label="검색조건" name="searchfield" headerKey="1" list="#{'username':'사용자이름','gadget':'가젯이름','tag':'사용자태그'}"/> 
	    <s:textfield name="query"/> 
	    <s:submit value="검색"/>
	    
	</s:form>
	
		      </td>
	      </tr>

        
        			<tr>
						<td><!-- list of gadgets -->
						<table class="subtit_board" summary="List of Gadgets"
							cellpadding="0" cellspacing="0" width="100%">
							<colgroup>
								<col width="15%">
								<col width="15%">
								<col width="15%">
								<col width="15%">
								<col width="15%">
								<col width="20%">


							</colgroup>
							<tbody>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>가젯ID</td>
									<td>가젯이름
										<s:if test="%{sortsc == 'desc'}">
								   			<s:url id="sortUrl" action="Search" >
								   			<s:param name="searchfield" value="%{searchfield}" />
								   			<s:param name="query" value="%{query}" />
								   			<s:param name="sortfield">name</s:param>
								   			<s:param name="sortsc">asc</s:param>
								   			</s:url>
											<s:a href="%{sortUrl}">▲</s:a> 
										</s:if>
										<s:else>
											<s:url id="sortUrl" action="Search" >
								   			<s:param name="searchfield" value="%{searchfield}" />
								   			<s:param name="query" value="%{query}" />
								   			<s:param name="sortfield">name</s:param>
								   			<s:param name="sortsc">desc</s:param>
								   			</s:url>
											<s:a href="%{sortUrl}">▼</s:a> 	
										</s:else>
									</td>
									<td align="center">개발자</td>
									<td align="center">발행일자
										<s:if test="%{sortsc == 'desc'}">
								   			<s:url id="sortUrl" action="Search" >
								   			<s:param name="searchfield" value="%{searchfield}" />
								   			<s:param name="query" value="%{query}" />
								   			<s:param name="sortfield">publishDate</s:param>
								   			<s:param name="sortsc">asc</s:param>
								   			</s:url>
											<s:a href="%{sortUrl}">▲</s:a> 
										</s:if>
										<s:else>
								   			<s:url id="sortUrl" action="Search" >
								   			<s:param name="searchfield" value="%{searchfield}" />
								   			<s:param name="query" value="%{query}" />
								   			<s:param name="sortfield">publishDate</s:param>
								   			<s:param name="sortsc">desc</s:param>
								   			</s:url>
											<s:a href="%{sortUrl}">▼</s:a> 	
										</s:else>
									</td>
									<td align="center">사용자수</td>
									<td align="center">가젯설명</td>


								</tr>
								<s:iterator value="gadgets">
								<tr style="background-color: rgb(300, 300, 300);">
									<s:url id="gadgetInfoUrl" action="SearchGadgetInfo">
										<s:param name="gadgetId"><s:property value="id"/></s:param>
										<s:param name="ownerId"><s:property value="userId"/></s:param>
									</s:url>
									<s:url id="userOtherUserInfoUrl" action="SearchOtherUserInfo">
										<s:param name="otherUserId"><s:property value="developer.id"/></s:param>
									</s:url>

									<td><s:a href="%{gadgetInfoUrl}"><s:property value="id"/></s:a></td>
									<td><s:a href="%{gadgetInfoUrl}"><s:property value="name"/></s:a></td>
									
									<td align="center"><s:a href="%{userOtherUserInfoUrl}"><s:property value="developer.person.nameFormatted" /></s:a></td>
									
									 
									<td align="center"><s:date name="publishDate" format="yyyy/MM/dd"/></td>
									<td align="center"><s:property value="favoriteUsers.size"/></td>
									<td align="center"><s:property value="introduction"/></td>

									
								</tr>
								</s:iterator>
								<tr>
									<td class="line" colspan="7"></td>
								</tr>
							</tbody>
						</table>
						</td>
					</tr>
					<tr>
						<td><!-- paging -->
							<div class="paging"> 
			
							<s:if test="%{prepage != 0}">
						   			<s:url id="pagingUrl" action="Search" >
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
					    			<s:url id="pagingUrl" action="Search" >
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
						   			<s:url id="pagingUrl" action="Search" >
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