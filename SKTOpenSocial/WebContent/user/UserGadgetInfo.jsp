<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="../css/main.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../js/main.js"></script>
<%@page import="com.skt.opensocial.common.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="img" uri="/struts-images" %>

<script type="text/javascript" src="../js/developer.js"></script>


<!--// OpenSocial Gadget Related Setting -->
<s:set var="shindigServer"><%= request.getServerName() + ":" + request.getServerPort() %></s:set>
<link rel="stylesheet"
	href="http://<s:property value="#shindigServer"/>/gadgets/files/container/gadgets.css">
<script type="text/javascript"
	src="http://<s:property value="#shindigServer"/>/gadgets/js/rpc.js?c=1&debug=1"></script>
<script type="text/javascript"
	src="http://<s:property value="#shindigServer"/>/gadgets/files/container/cookies.js"></script>
<script type="text/javascript"
	src="http://<s:property value="#shindigServer"/>/gadgets/files/container/util.js"></script>
<script type="text/javascript"
	src="http://<s:property value="#shindigServer"/>/gadgets/files/container/gadgets.js"></script>
<script type="text/javascript"
	src="http://<s:property value="#shindigServer"/>/gadgets/files/container/cookiebaseduserprefstore.js"></script>
<script type="text/javascript"
	src="http://<s:property value="#shindigServer"/>/gadgets/files/container/osapi.js"></script>

<!-- //Local Gadget Enabling Function -->
<script type="text/javascript">
	// Specify Gadget XML file URL
	var gadget0Url = '<s:property value="gadgetUrl"/>';
	// Specify Gadget Owner & Viewer
	var viewerId = '<s:property value="viewerId"/>';
	var ownerId = '<s:property value="ownerId"/>';
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

		gadget0.setServerBase('http://<s:property value="#shindigServer"/>/gadgets/'); //Shindig Server Gadget Handling Endpoint

		gadget0.secureToken = escape(generateSecureToken()); // Including viewer and owner

		gadgets.container.addGadget(gadget0);
		gadgets.container.layoutManager
				.setGadgetChromeIds( [ 'gadget-chrome' ]);
		
		gadgets.container.renderGadget(gadget0);
	};
</script>
<!--// Gadget Style override -->
<style type="text/css">
  body {
    font-family: arial, sans-serif;
  }

  #headerDiv {
    padding: 10px;
    margin-bottom: 20px;
    background-color: #e5ecf9;
    color: #3366cc;
    font-size: larger;
    font-weight: bold;
  }

  .subTitle {
    font-size: smaller;
    float: right;
  }

  .gadgets-gadget-chrome {
    width: 90%;
    height: 100%;
    float: none;
    margin: auto;
    overflow: scroll;
    
  }

  .gadgets-gadget {
    width: 100%;
  }

</style>


<title>사용자 가젯 정보</title>
</head>

<body leftmargin="0" topmargin="0"
	style="background-color: rgb(255, 255, 255);" marginheight="0"
	marginwidth="0" onLoad="renderGadgets();">
<table border="1" cellpadding="0" cellspacing="0" height="800" width="100%">
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
			<%@ include file="/user/west_user.jsp"%>
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
							<li>사용자 메뉴</li>
							<li><strong>가젯 정보</strong></li>
						</ul>
						</div>
						</td>
					</tr>
					<tr>
						<td><!-- list of gadgets -->
						<table class="subtit_board" summary="List of Gadgets"
							cellpadding="0" cellspacing="0" width="100%" height="600px">
							<colgroup>
								<col width="10%">
								<col width="90%">
							</colgroup>
							<tbody>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>가젯 아이디:</td>
									<td><s:property value="gadgetId"/></td>
								</tr>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>가젯 이름:</td>
									
									<td><s:property value="name"/></td>
									
								</tr>
														
								<tr style="background-color: rgb(245, 245, 245);">
									<td>가젯 유형:</td>
									<td><s:property value="categoryStringList"/></td>
								</tr>
								
								<tr style="background-color: rgb(245, 245, 245);">
									<td valign="top">가젯 소개:</td>
									<td valign="top">
											<s:property value="introduction"/>
									</td>
								</tr>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>아이콘:</td>
									<td>
										<s:url id="iUrl" action="../developer/ViewIcon">
											<s:param name="gadgetId" value="%{gadgetId}"></s:param>
										</s:url>
										<img:image src="%{iUrl}" resize="false" height="50" width="50"/>
									</td>
								</tr>
								<s:if test="%{registerType.equals('src')}">
								<tr>
									<td valign="top">가젯 소스:</td>
									<td>
										<s:property value="gadgetSource" />
									</td>
								</tr>
								</s:if>
								<s:elseif test="%{registerType.equals('url')}">
								<tr>
									<td valign="top">가젯 URL:</td>
									<td>
										<s:property value="gadgetUrl" />
									</td>
								</tr>
								</s:elseif>
								<tr>
									<td class="line" colspan="2"></td>
								</tr>
								
								<tr height="600px">
									<td valign="top">가젯 실행</td>
									<s:if test="%{status.equals('pg')}">
										<s:if test="%{registerType.equals('url') || registerType.equals('src')}" >
											<td valign="top" width="70%" >
												<div id="gadget-chrome" class="gadgets-gadget-chrome"></div>
											</td>
										</s:if>
										<s:else>
											<td valign="top">Gadget Register Type is neither 'url' nor 'src'</td>
										</s:else>
									</s:if>	
									<s:else>
										<td valign="top">The gadget became not to be published</td>
									</s:else>
								</tr>
								
								<tr>
									<td class="line"></td>
									
								</tr>

								<tr  >
									<td valign="top">가젯 리뷰</td>
										
									<td valign="top" align="center">
										<iframe id="gadgetReview" src="<s:url value="%{'/user/Review.action?gadgetId='+gadgetId}"/>" width="90%" height="100"></iframe>
									</td>
									
								</tr>

							</tbody>
						</table>
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