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
				<li><strong>사용자검색결과</strong></li>
            </ul>
            </div>
          </td>
        </tr>

        
        <!-- search -->
        <tr>
          <td>

	<s:form action="Search" namespace="/user" theme="simple">
	    <s:select label="검색조건" name="searchfield" headerKey="1" headerValue="-- 선택하세요 --" list="#{'username':'사용자이름','gadget':'가젯이름'}"/> 
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
								<col width="20%">
								<col width="20%">
								<col width="20%">
								<col width="20%">
								<col width="20%">
							</colgroup>
							<tbody>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>사용자ID</td>
									<td>사용자이름</td>
									<td align="center">사용자가입일</td>
									<td align="center">사용자설명</td>
									<td align="center">나이</td>
								</tr>
								<s:iterator value="users">
								<tr style="background-color: rgb(300, 300, 300);">
									<s:url id="userOtherUserInfoUrl" action="SearchOtherUserInfo">
										<s:param name="otherUserId"><s:property value="id"/></s:param>
									</s:url>
									<td><s:a href="%{userOtherUserInfoUrl}"><s:property value="id"/></s:a></td>
									<td><s:a href="%{userOtherUserInfoUrl}"><s:property value="person.nameFormatted"/></s:a></td>
									<td align="center"><s:date name="registeredDate" format="yyyy/MM/dd"/></td>
									<td align="center"><s:property value="person.aboutme" /></td>
									<td align="center"><s:property value="person.age" /></td>
									
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
						<div class="paging"><em class="p"><a href="ListGadgets.action">이 전</a></em><a href="ListGadgets.action">1</a> <a href="ListGadgets.action">2</a> <a href="ListGadgets.action">3</a> <em
							class="n"><a href="ListGadgets.action">다음</a></em></div>
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