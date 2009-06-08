<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="../css/main.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../js/main.js"></script>


<title>개발자 가젯 목록</title>
</head>

<body leftmargin="0" topmargin="0"
	style="background-color: rgb(255, 255, 255);" marginheight="0"
	marginwidth="0">
<table border="1" cellpadding="0" cellspacing="0" height="567"
	width="100%"> <!--  position: height="567" width="100%" -->
	<tbody>
		<tr valign="top" height="15%"> <!--  position: valign="top" height="15%" -->
			<!-- north -->
			<td colspan="3" align="center" valign="top"><!-- position: valign="top" -->
			<!--<div id="header">
			<table border="1" width="100%">
				<tbody>
					<tr align="center">
						<td style="background-color: rgb(255, 255, 255);" width="25%"><img
							src="../images/logo.jpg"></td>
						<td onclick="javacript:location.href='/index.jsp'" style=""
							width="20%">SKT OpenSocial 홈</td>
						<td style="background-color: rgb(255, 255, 255);" width="5%"></td>
						<td width="10%">사 용자 메뉴</td>
						<td style="background-color: rgb(255, 255, 255);" width="5%"></td>
						<td width="10%">개 발자 메뉴</td>
						<td style="background-color: rgb(255, 255, 255);"></td>
						<td width="10%">관 리자</td>
					</tr>
				</tbody>
			</table>
			</div>
			-->
			<%@ include file="/common/north.jsp"%>
			</td>
		</tr>
		<tr valign="top" height="80%"><!--  position: valign="top" height="80%" -->
			<!-- west -->
			<td align="center" valign="top" width="25%">
			<%@ include file="/common/west_dev.jsp"%>
			</td>
			<!-- east -->
			<td align="left" valign="top" width="75%">
			<div id="east">
			<table cellpadding="10" width="100%">
				<!-- navigation -->
				<tbody valign="top">
					<tr v>
						<td valign="top">
						<div class="subject subject_char">
						<ul class="subject_sub">
							<li>홈</li>
							<li>개발자 메뉴</li>
							<li><strong>내 가젯 관리</strong></li>
						</ul>
						</div>
						</td>
					</tr>
					<!-- search -->
					<!-- 
					<tr>
						<td>
						<form id="GadgetList" name="GadgetList"
							action="/SKTOpenSocial/admin/GadgetList.action;jsessionid=590A534436310361FD836650D1E8FF9C"
							method="post"><select name="searchfield"
							id="GadgetList_searchfield">
							<option value="1">-- 선택하세요 --</option>
							<option value="name">이 름</option>
							<option value="owner">등 록자</option>
						</select> <input name="query" value="" id="GadgetList_query" type="text">
						<input id="GadgetList_0" value="검색" type="submit"></form>
						</td>
					</tr>
					-->
					<tr>
						<td><!-- list of gadgets -->
						<table class="subtit_board" summary="List of Gadgets"
							cellpadding="0" cellspacing="0" width="100%">
							<colgroup>
								<col width="10%">
								<col width="20%">
								<col width="10%">
								<col width="10%">
								<col width="10%">
								<col width="20%">
								<col width="20%">
							</colgroup>
							<tbody>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>ID</td>
									<td>가젯이름</td>
									<td align="center">등록일자</td>
									<td align="center">발행일자</td>
									<td align="center">사용자수</td>
									<td align="center">가젯상태</td>
									<td align="center">작 업</td>
								</tr>
								<tr style="background-color: rgb(300, 300, 300);">
									<td>Entertain</td>
									<td>카트놀이터</td>
									<td align="center">2009/05/09</td>
									<td align="center">2009/05/10</td>
									<td align="center">5000</td>
									<td align="center">발행</td>
									<!-- 등록/발행요청/발행 -->
									<td align="center">리뷰보기</td>
									<!-- 수정/삭제/발행요청/리뷰보기 -->
								</tr>
								<tr style="background-color: rgb(300, 300, 300);">
									<td>himart</td>
									<td>하이마트</td>
									<td align="center">2009/05/09</td>
									<td align="center"></td>
									<td align="center"></td>
									<td align="center">등록</td>
									<!-- 등록/발행요청/발행 -->
									<td align="center">수정/삭제/발행요청</td>
								</tr>
								<tr style="background-color: rgb(300, 300, 300);">
									<td>emart</td>
									<td>이마트</td>
									<td align="center">2009/05/09</td>
									<td align="center"></td>
									<td align="center"></td>
									<td align="center">발행요청</td>
									<!-- 등록/발행요청/발행 -->
									<td align="center">N/A</td>
								</tr>
								<tr>
									<td class="line" colspan="7"></td>
								</tr>
							</tbody>
						</table>
						</td>
					</tr>
					<tr>
						<td><!-- paging -->
						<div class="paging"><em class="p"><a href="">이 전</a></em> <span
							class="on">1</span> <a href="">2</a> <a href="">3</a> <em
							class="n"><a href="">다음</a></em></div>
						</td>
					</tr>
				</tbody>
			</table>
			</div>
			<!-- east div -->
			</td>
		</tr>
		<!-- south -->
		<tr height="5%"><!--  position: height="5%" -->
			<td colspan="3" align="center"  valign="middle">
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