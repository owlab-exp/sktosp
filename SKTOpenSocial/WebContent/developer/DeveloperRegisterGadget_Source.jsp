<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="../css/main.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../js/main.js"></script>


<title>개발자 신규가젯등록</title>
</head>

<body leftmargin="0" topmargin="0"
	style="background-color: rgb(255, 255, 255);" marginheight="0"
	marginwidth="0">
<table border="1" cellpadding="0" cellspacing="0" position: height="567" width="100%">
	<tbody>
		<tr valign="top" height="15%">
			<!-- north -->
			<td colspan="3" align="center" height="10%" valign="top">
			<div id="header">
			<table border="1" height="100%" width="100%">
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
			</td>
		</tr>
		<tr valign="top" height="80%">
			<!-- west -->
			<td align="center" valign="top" width="25%">
			<div id="west"><!-- 
			<div class="login">
			<table>
				<tbody>
					<tr>
						<td>
						<form id="login" name="login" action="login.jsp" target="_self"
							method="post" autocomplete="off" onsubmit="return form_chk();">
						이메일: <input id="loginEmail" name="email" class="bg"
							title="이메일 주소 입력" onfocus="ChgInput(this);"
							onkeydown="ChgInput(this);" onmouseover="this.focus();"
							datatype="an" mask="-_@." type="text"> <br>
						비밀번호: <input id="loginPasswd" name="passwd" class="bg"
							title="비밀번호 입력" onfocus="ChgInput(this);"
							onkeydown="ChgInput(this);" onmouseover="this.focus();" enc="on"
							type="password"> <br>
						<br>
						<input class="btn" title="로그인버튼" value="로그인" type="submit">
						<input id="loginEChk" name="echk" value="" type="hidden">
						</form>
						</td>
					</tr>
				</tbody>
			</table>
			</div>
			 --></div>
			<br>
			<table class="menu" border="1" cellpadding="0" cellspacing="0" width="90%">
				<tbody>
					<tr height="30">
						<td align="left">
						<h3>▷ 개발자 메뉴</h3>
						</td>
					</tr>
					<tr>
						<td><a href="DeveloperListGadgets.jsp">내 가젯 관리</a></td>
					</tr>
					<tr>
						<td><a href="DeveloperRegisterGadget.jsp">신규 가젯 등록</a></td>
					</tr>
					<!--<tr>
						<td>가젯 미리보기</td>
					</tr>
					<tr>
						<td>가젯 리뷰 보기</td>
					</tr>
				--></tbody>
			</table>
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
							<li><strong>신규 가젯 등록</strong></li>
						</ul>
						</div>
						</td>
					</tr>
					<tr>
						<td><!-- list of gadgets -->
						<table class="subtit_board" summary="List of Gadgets"
							cellpadding="0" cellspacing="0" width="100%">
							<colgroup>
								<col width="10%">
								<col width="90%">
							</colgroup>
							<tbody>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>등록 유형:</td>
									<td>
									<form action="" method="""><input type="radio"
										name="registerType" value="source" checked="checked">소스 등록 <input
										type="radio" name="registerType" value="url">URL 등록
										<input type="radio" name="registerType" value="url">다중 URL 등록
										</form>
									</td>
								</tr>
								<tr>
									<td>*가젯 아이디:</td>
									<td>
									<form action=""><input type="text" value="emartgame">
									<input type="button" value="중복검사"></form>
									</td>
								</tr>
								<tr>
									<td>*가젯 이름:</td>
									<td>
									<form action=""><input type="text" value="기상천외">
									</form>
									</td>
								</tr>
								<tr>
									<td>*가젯 유형:</td>
									<td>
									<form action=""><select id="appCategory"
										name="appCategory"
										onchange="_showValidationError(this,_validateRequired(this));">
										<option value="">유형을 선택하세요</option>
										<!-- option value="badges">Badges</option> -->
										<option value="communication">커뮤니케이션</option>
										<option value="dating">데이트</option>
										<option value="events">이벤트</option>
										<option value="finance" selected="selected">경제</option>
										<option value="food_and_drinks">음식</option>
										<option value="games_and_fun">게임&재미</option>
										<option value="lifestyle">생활</option>
										<option value="movies_and_tv">영화& TV</option>
										<option value="music">음악</option>
										<option value="news">뉴스</option>
										<option value="politics">정치</option>
										<option value="sports">스포츠</option>
										<option value="tools">도구</option>
										<option value="travel">여행</option>
										<option value="video">비디오</option>
									</select></form>
									</td>
								</tr>
								<tr>
									<td valign="top">*가젯 소개:</td>
									<td>
										<form action="">
											<textarea rows="2" cols="20" >경제를 살리자</textarea>
										</form>
									</td>
								</tr>
								<tr>
									<td>아이콘:</td>
									<td>
										<form action="">
											<input type="text"><input type="button" value="찾아보기"> 권장사이즈: 23px X 23px
										</form>
									</td>
								</tr>
								<tr>
									<td valign="top">가젯 소스:</td>
									<td>
										<textarea cols="70" rows="10" name="gadgetSource" ></textarea>
									</td>
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
						<div class="paging"><em class="n"><a href="DeveloperRegisterGadget_Source2.jsp">등록 확인</a></em></div>
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