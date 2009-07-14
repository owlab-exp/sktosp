<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page import="com.skt.opensocial.common.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<link href="../css/main.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../js/main.js"></script>
<script type="text/javascript" src="../js/developer.js"></script>

<!--// OpenSocial Gadget Related Setting -->
<link rel="stylesheet"
	href="http://localhost:8080/gadgets/files/container/gadgets.css">
<script type="text/javascript"
	src="http://localhost:8080/gadgets/js/rpc.js?c=1&debug=1"></script>
<script type="text/javascript"
	src="http://localhost:8080/gadgets/files/container/cookies.js"></script>
<script type="text/javascript"
	src="http://localhost:8080/gadgets/files/container/util.js"></script>
<script type="text/javascript"
	src="http://localhost:8080/gadgets/files/container/gadgets.js"></script>
<script type="text/javascript"
	src="http://localhost:8080/gadgets/files/container/cookiebaseduserprefstore.js"></script>
<script type="text/javascript"
	src="http://localhost:8080/gadgets/files/container/osapi.js"></script>

<!-- //Local Gadget Enabling Function -->
<script type="text/javascript">
	// Specify Gadget XML file URL
	<s:if test="%{registerType.equals('url')}">
		var gadget0Url = '<s:property value="gadgetUrl"/>';
	</s:if>
	<s:elseif test="%{registerType.equals('src')}">
		var gadget0Url = '<s:property value="gadgetUrl"/>';
	</s:elseif>
	// Specify Gadget Owner & Viewer
	var viewerId = '<s:property value="developerId"/>';
	var ownerId = '<s:property value="developerId"/>';
	var appId = '<s:property value="gadgetId"/>';
	
	function generateSecureToken() {
	    // TODO: Use a less silly mechanism of mapping a gadget URL to an appid
	    //var appId = 0;
	    //for (var i = 0; i < gadget0Url.length; i++) {
	    //  appId += gadget0Url.charCodeAt(i);
	    //}
	    var fields = [ownerId, viewerId, appId, "shindig", gadget0Url, "0", "default"];
	    for (var i = 0; i < fields.length; i++) {
	      // escape each field individually, for metachars in URL
	      fields[i] = escape(fields[i]);
	    }
	    return fields.join(":");
	  }
	  
	function renderGadgets() {
		var gadget0 = gadgets.container.createGadget( {
			specUrl : gadget0Url
		});

		gadget0.setServerBase('http://localhost:8080/gadgets/'); //Shindig Server Gadget Handling Endpoint

		gadget0.secureToken = escape(generateSecureToken()); // Including viewer and owner

		gadgets.container.addGadget(gadget0);
		gadgets.container.layoutManager
				.setGadgetChromeIds( [ 'gadget-chrome' ]);
		gadgets.container.renderGadget(gadget0);
	};
</script>
<!--// Gadget Style override -->
<style type="text/css">

 .gadgets-gadget-chrome {
    width: 90%;
    height: 100%;
    float: center;
    margin: auto;
  }

  .gadgets-gadget {
    width: 100%;
    height: 100%;
  }

</style>
<title>가젯 미리보기</title>
</head>

<body leftmargin="0" topmargin="0"
	style="background-color: rgb(255, 255, 255);" marginheight="0" 
	marginwidth="0" onLoad="renderGadgets();"><!-- height="567" -->
<table border="1" cellpadding="0" cellspacing="0" 
	width="100%">
	<tbody>
		<tr valign="top" height="15%">
			<!-- north -->
			<td colspan="3" align="center" valign="top"><%@ include
				file="/common/north.jsp"%></td><!-- height="10%"  -->
		</tr>
		<tr valign="top"><!-- height="80%" -->
			<!-- west -->
			<td align="center" valign="top" width="25%"><%@ include
				file="/common/west_dev.jsp"%></td>
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
									<td>가젯 이름(ID): <s:property value="gadgetName" /> (<s:property
										value="gadgetId" />)</td>
								</tr>
								<tr>
									<s:if test="%{registerType.equals('url') || registerType.equals('src')}">
										<td valign="top">
											<div id="gadget-chrome" class="gadgets-gadget-chrome"></div>
										</td>
									</s:if>
									<s:else>
										<td valign="top">Gadget Register Type is neither 'url' nor 'src'</td>
									</s:else>
								</tr>
								<tr>
									<td class="line"></td>

								</tr>
							</tbody>
						</table>
						</td>
					</tr>
					<tr>
						<td><!-- buttons -->
						<div class="paging"><s:url id="finishRegisterUrl"
							action="RegisterGadget" method="finishGadgetRegister">
							<s:param name="gadgetId">
								<s:property value="gadgetId" />
							</s:param>
						</s:url> <s:url id="viewReviewUrl" action="ViewGadgetReview">
							<s:param name="gadgetId">
								<s:property value="gadgetId" />
							</s:param>
						</s:url> <s:url id="modifyGadgetUrl" action="ModifyGadget"
							method="getModifyGadgetPage">
							<s:param name="gadgetId">
								<s:property value="gadgetId" />
							</s:param>
						</s:url> <s:url id="publishRequestUrl" action="PublishRequest"
							method="publishConfirm">
							<s:param name="gadgetId">
								<s:property value="gadgetId" />
							</s:param>
						</s:url> <s:url id="removeGadgetUrl" action="RemoveGadget"
							method="requestConfirm">
							<s:param name="gadgetId">
								<s:property value="gadgetId" />
							</s:param>
						</s:url> <s:url id="viewDenyReasonUrl" action="ViewDenyReason">
							<s:param name="gadgetId">
								<s:property value="gadgetId" />
							</s:param>
						</s:url> <s:if test="%{gadgetStatus.equals('nr')}">
							<%-- Not registered--%>
							<em class="p"><s:a href="%{finishRegisterUrl}">등록완료</s:a>/<s:a
								href="%{modifyGadgetUrl}">수정</s:a>/<s:a href="#"
								onclick="javascript:popup('%{removeGadgetUrl}','RemoveConfirm')">삭제</s:a></em>
						</s:if> <s:elseif test="%{gadgetStatus.equals('rg')}">
							<%-- Registered--%>
							<em class="p"><s:a href="#"
								onclick="javascript:popup('%{publishRequestUrl}','PublishConfirm')">발행요청</s:a>/<s:a
								href="%{modifyGadgetUrl}">수정</s:a>/<s:a href="#"
								onclick="javascript:popup('%{removeGadgetUrl}','RemoveConfirm')">삭제</s:a></em>
						</s:elseif> <s:elseif test="%{gadgetStatus.equals('pd')}">
							<%-- Publish Denied--%>
							<em class="p"><s:a href="#"
								onclick="javascript:popup('%{viewDenyReasonUrl}','PublishDeny')">거절사유</s:a>/<s:a
								href="%{modifyGadgetUrl}">수정</s:a>/<s:a href="#"
								onclick="javascript:popup('%{removeGadgetUrl}','RemoveConfirm')">삭제</s:a></em>
						</s:elseif> <s:else>
							<%-- Published or Publish requested--%>
							<em class="p"><a href="#"
								onclick="javacript:location.href='<%=request.getContextPath()%>/developer/ListGadgets.action'">목록으로
							돌아가기</a></em>
						</s:else></div>
						</td>
					</tr>
				</tbody>
			</table>
			</div>
			<!-- east div --></td>
		</tr>
		<!-- south -->
		<tr valign="top" height="5%">
			<td colspan="3" align="center" height="10%" valign="middle">
			<div id="footer">
			<table border="1" height="100%" width="100%">
				<tbody>
					<tr>
						<td><strong>Copyright &copy; SK Telecom. All rights
						reserved.</strong></td>
					</tr>
				</tbody>
			</table>
			</div>
			</td>
		</tr>
	</tbody>
</table>
</body>
</html>