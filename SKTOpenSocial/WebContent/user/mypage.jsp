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
          			<td align="left">이름</td> 
                	<td><s:text name="%{user.name}"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="left">아이디</td> 
                	<td><s:text name="%{user.id}"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#FFFFFF;" height="25">
          			<td align="left">전화번호</td> 
                	<td><s:text name="%{user.phone}"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="left">주소</td> 
                	<td><s:text name="%{user.address}"/></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
				<tr style="background-color:#F5F5F5;" height="25">
          			<td align="left">가입일</td> 
                	<td><s:text name="%{user.regDate}"/></td> 
      			  </tr>
      			<tr><td class="line" colspan="6"></td></tr>
      			


      		  </table>
      		  
      		  <table cellpadding="0" cellspacing="0" width="100%" border="1"> 
					<colgroup> 
		                <col width="20%" /> 
		                <col width="20%" /> 
		                <col width="60%" /> 
					</colgroup>
				

	  			<tr>
	   				<td width='100%' bgcolor='#FFFFFF' align="center">
		      			<s:form action="Modification" namespace="/user" >

		        		<s:submit align="left" value= "개인정보수정" name= "modification" />

		     			</s:form>    			
		     		</td>
		     	</tr>
      		  </table>
      		  
      		  <!-- east -->

			<table cellpadding="10" width="100%">
				<!-- navigation -->
				<tbody valign="top">

					<tr>
						<td><!-- list of gadgets -->
						<table class="subtit_board" summary="List of Gadgets"
							cellpadding="0" cellspacing="0" width="100%">
							<colgroup>
								<col width="10%">
								<col width="10%">
								<col width="10%">
								<col width="10%">
								<col width="10%">
								<col width="20%">
								<col width="30%">
							</colgroup>
							<tbody>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>친구ID</td>
									<td>친구이름</td>
									<td align="center">친구등록일</td>
									<td align="center">이메일</td>
									<td align="center">전화번호</td>
									<td align="center">주소</td>
									<td align="center">작업</td>
								</tr>
								<s:iterator value="gadgets" id="gadget">
								<tr style="background-color: rgb(300, 300, 300);">
									<s:url id="gadgetPreviewUrl" action="PreviewGadget">
										<s:param name="gadgetStatus"><s:property value="gadgetStatus"/></s:param>
									</s:url>
									<td><s:a href="%{gadgetPreviewUrl}"><s:property value="gadgetId"/></s:a></td>
									<td><s:a href="%{gadgetPreviewUrl}"><s:property value="gadgetName"/></s:a></td>
									<td align="center"><s:property value="registerDate"/></td>
									<td align="center"><s:property value="publishDate"/></td>
									<td align="center"><s:property value="numberOfUsers"/></td>
									
									<td align="center">
									<s:if test="%{gadgetStatus.equals('rg')}">
										등록완료
									</s:if>
									<s:elseif test="%{gadgetStatus.equals('pr')}">
										발행요청중
									</s:elseif>
									<s:elseif test="%{gadgetStatus.equals('pg')}">
										발행완료
									</s:elseif>
									<s:elseif test="%{gadgetStatus.equals('pd')}">
										발행거절
									</s:elseif>
									</td>
									
									<s:if test="gadgetStatus.equals('rg')">
									<td align="center">
										<a href="#" onclick="javascript:popup('popup_gadget_publish_request.jsp','IDCheck')">발행요청</a>/<s:a href="ModifyGadget.action">수정</s:a>/<a href="#" onclick="javascript:popup('popup_gadget_remove.jsp','IDCheck')">삭제</a>
									</td>
									</s:if>
									<s:elseif test="gadgetStatus.equals('pg')">
									<td align="center">
										<a href="ViewGadgetReview.action">사용자 리뷰 보기</a>
									</td> 
									</s:elseif>
									<s:elseif test="gadgetStatus.equals('pd')">
										<td align="center">
										<a href="#" onclick="javascript:popup('popup_publish_deny.jsp','PublishDeny')">거절사유</a>/<s:a href="ModifyGadget.action">수정</s:a>/<a href="#" onclick="javascript:popup('popup_gadget_remove.jsp','IDCheck')">삭제</a>
										</td>
									</s:elseif>
									<s:else>
									<td align="center">
									</td> 
									</s:else>
									
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
				</tbody>
			</table>

			<table cellpadding="10" width="100%">
				<!-- navigation -->
				<tbody valign="top">

					<tr>
						<td><!-- list of gadgets -->
						<table class="subtit_board" summary="List of Gadgets"
							cellpadding="0" cellspacing="0" width="100%">
							<colgroup>
								<col width="10%">
								<col width="10%">
								<col width="10%">
								<col width="10%">
								<col width="10%">
								<col width="20%">
								<col width="30%">
							</colgroup>
							<tbody>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>가젯ID</td>
									<td>가젯이름</td>
									<td align="center">등록일자</td>
									<td align="center">발행일자</td>
									<td align="center">사용자수</td>
									<td align="center">가젯상태</td>
									<td align="center">작 업</td>
								</tr>
								<s:iterator value="gadgets" id="gadget">
								<tr style="background-color: rgb(300, 300, 300);">
									<s:url id="gadgetPreviewUrl" action="PreviewGadget">
										<s:param name="gadgetStatus"><s:property value="gadgetStatus"/></s:param>
									</s:url>
									<td><s:a href="%{gadgetPreviewUrl}"><s:property value="gadgetId"/></s:a></td>
									<td><s:a href="%{gadgetPreviewUrl}"><s:property value="gadgetName"/></s:a></td>
									<td align="center"><s:property value="registerDate"/></td>
									<td align="center"><s:property value="publishDate"/></td>
									<td align="center"><s:property value="numberOfUsers"/></td>
									
									<td align="center">
									<s:if test="%{gadgetStatus.equals('rg')}">
										등록완료
									</s:if>
									<s:elseif test="%{gadgetStatus.equals('pr')}">
										발행요청중
									</s:elseif>
									<s:elseif test="%{gadgetStatus.equals('pg')}">
										발행완료
									</s:elseif>
									<s:elseif test="%{gadgetStatus.equals('pd')}">
										발행거절
									</s:elseif>
									</td>
									
									<s:if test="gadgetStatus.equals('rg')">
									<td align="center">
										<a href="#" onclick="javascript:popup('popup_gadget_publish_request.jsp','IDCheck')">발행요청</a>/<s:a href="ModifyGadget.action">수정</s:a>/<a href="#" onclick="javascript:popup('popup_gadget_remove.jsp','IDCheck')">삭제</a>
									</td>
									</s:if>
									<s:elseif test="gadgetStatus.equals('pg')">
									<td align="center">
										<a href="ViewGadgetReview.action">사용자 리뷰 보기</a>
									</td> 
									</s:elseif>
									<s:elseif test="gadgetStatus.equals('pd')">
										<td align="center">
										<a href="#" onclick="javascript:popup('popup_publish_deny.jsp','PublishDeny')">거절사유</a>/<s:a href="ModifyGadget.action">수정</s:a>/<a href="#" onclick="javascript:popup('popup_gadget_remove.jsp','IDCheck')">삭제</a>
										</td>
									</s:elseif>
									<s:else>
									<td align="center">
									</td> 
									</s:else>
									
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
				</tbody>
			</table>
			
			<table cellpadding="10" width="100%">
				<!-- navigation -->
				<tbody valign="top">

					<tr>
						<td><!-- list of gadgets -->
						<table class="subtit_board" summary="List of Gadgets"
							cellpadding="0" cellspacing="0" width="100%">
							<colgroup>
								<col width="10%">
								<col width="10%">
								<col width="10%">
								<col width="10%">
								<col width="10%">
								<col width="20%">
								<col width="30%">
							</colgroup>
							<tbody>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>AppID</td>
									<td>가젯ID</td>
									<td align="center">title</td>
									<td align="center">body</td>
									<td align="center">streamTitle</td>
									<td align="center">priority</td>
									<td align="center">작업</td>
								</tr>
								<s:iterator value="gadgets" id="gadget">
								<tr style="background-color: rgb(300, 300, 300);">
									<s:url id="gadgetPreviewUrl" action="PreviewGadget">
										<s:param name="gadgetStatus"><s:property value="gadgetStatus"/></s:param>
									</s:url>
									<td><s:a href="%{gadgetPreviewUrl}"><s:property value="gadgetId"/></s:a></td>
									<td><s:a href="%{gadgetPreviewUrl}"><s:property value="gadgetName"/></s:a></td>
									<td align="center"><s:property value="registerDate"/></td>
									<td align="center"><s:property value="publishDate"/></td>
									<td align="center"><s:property value="numberOfUsers"/></td>
									
									<td align="center">
									<s:if test="%{gadgetStatus.equals('rg')}">
										등록완료
									</s:if>
									<s:elseif test="%{gadgetStatus.equals('pr')}">
										발행요청중
									</s:elseif>
									<s:elseif test="%{gadgetStatus.equals('pg')}">
										발행완료
									</s:elseif>
									<s:elseif test="%{gadgetStatus.equals('pd')}">
										발행거절
									</s:elseif>
									</td>
									
									<s:if test="gadgetStatus.equals('rg')">
									<td align="center">
										<a href="#" onclick="javascript:popup('popup_gadget_publish_request.jsp','IDCheck')">발행요청</a>/<s:a href="ModifyGadget.action">수정</s:a>/<a href="#" onclick="javascript:popup('popup_gadget_remove.jsp','IDCheck')">삭제</a>
									</td>
									</s:if>
									<s:elseif test="gadgetStatus.equals('pg')">
									<td align="center">
										<a href="ViewGadgetReview.action">사용자 리뷰 보기</a>
									</td> 
									</s:elseif>
									<s:elseif test="gadgetStatus.equals('pd')">
										<td align="center">
										<a href="#" onclick="javascript:popup('popup_publish_deny.jsp','PublishDeny')">거절사유</a>/<s:a href="ModifyGadget.action">수정</s:a>/<a href="#" onclick="javascript:popup('popup_gadget_remove.jsp','IDCheck')">삭제</a>
										</td>
									</s:elseif>
									<s:else>
									<td align="center">
									</td> 
									</s:else>
									
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
				</tbody>
			</table>
			
			<!-- east div -->

      		  
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