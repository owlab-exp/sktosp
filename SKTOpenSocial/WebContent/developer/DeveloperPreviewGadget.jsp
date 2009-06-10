<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page import="com.skt.opensocial.common.*" %>
<link href="../css/main.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../js/main.js"></script>
<script type="text/javascript" src="../js/developer.js"></script>


<title>가젯 미리보기</title>
</head>

<body leftmargin="0" topmargin="0"
	style="background-color: rgb(255, 255, 255);" marginheight="0"
	marginwidth="0">
<table border="1" cellpadding="0" cellspacing="0" position: height="567" width="1000">
	<tbody>
		<tr valign="top" height="15%">
			<!-- north -->
			<td colspan="3" align="center" height="10%" valign="top">
			<%@ include file="/common/north.jsp"%>
			</td>
		</tr>
		<tr valign="top" height="80%">
			<!-- west -->
			<td align="center" valign="top" width="25%">
			<%@ include file="/common/west_dev.jsp"%>
			</td>
			<!-- east -->
			<td align="left" valign="top" width="75%">
			<div id="east">
			<table cellpadding="10" width="100%">
				<!-- navigation -->
				<tbody>
					<tr>
						<td>
						<div class="subject subject_char">
						<ul class="subject_sub">
							<li>홈</li>
							<li>개발자 메뉴</li>
							<li><strong>가젯 미리보기</strong></li>
						</ul>
						</div>
						</td>
					</tr>
					<tr>
						<td><!-- list of gadgets -->
						<table class="subtit_board" summary="List of Gadgets"
							cellpadding="0" cellspacing="0" width="100%">
							<colgroup>
								<col width="100%">
							</colgroup>
							<tbody>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>가젯 이름(ID): iLike (ilike)</td>
								</tr>
								<tr>
									<td valign="top"><img src="ilike.png" height="70%" width="70%"> </td>
								</tr>
								<tr>
									<td class="line" colspan="2"></td>
								</tr>
							</tbody>
						</table>
						</td>
					</tr>
					<tr>
						<td><!-- buttons -->
						<div class="paging">
						<s:if test="%{gadgetStatus.equals('nr')}"> <%-- Not registered--%>
							<em class="p"><a href="#" onclick="javacript:location.href='<%= request.getContextPath() %>/developer/ListGadgets.action'">등록완료</a> <a href="javascript: history.go(-1)">수정</a> <a href="#" onclick="javascript:popup('popup_gadget_remove.jsp','IDCheck')">삭제</a></em>
						</s:if>
						<s:elseif test="%{gadgetStatus.equals('rg')}"><%-- Registered--%>
							<em class="p"><a href="#" onclick="javascript:popup('popup_gadget_publish_request.jsp','IDCheck')">발행요청</a> <a href="<%= request.getContextPath() %>/developer/ModifyGadget.action">수정</a> <a href="#" onclick="javascript:popup('popup_gadget_remove.jsp','IDCheck')">삭제</a></em>
						</s:elseif>
						<s:elseif test="%{gadgetStatus.equals('pd')}"><%-- Publish Denied--%>
							<em class="p"><a href="<%= request.getContextPath() %>/developer/ModifyGadget.action">수정</a> <a href="#" onclick="javascript:popup('popup_gadget_remove.jsp','IDCheck')">삭제</a></em>
						</s:elseif>
						<s:else>	<%-- Published or Publish requested--%>
							<em class="p"><a href="#" onclick="javacript:location.href='<%= request.getContextPath() %>/developer/ListGadgets.action'">목록으로 돌아가기</a></em>
						</s:else>
						</div>
						</td>
					</tr>
				</tbody>
			</table>
			</div>
			<!-- east div --></td>
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