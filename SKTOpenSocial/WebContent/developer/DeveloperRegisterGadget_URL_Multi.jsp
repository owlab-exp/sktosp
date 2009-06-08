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
<table border="1" cellpadding="0" cellspacing="0" height="567"
	width="100%">
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
								<col width="10%">
								<col width="10%">
								<col width="20%">
								<col width="50%">
							</colgroup>
							<tbody>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>등록 유형:</td>
									<td colspan="4">
										<form action="" method=""">
											<input type="radio" name="registerType" value="source" >소스 등록 
											<input type="radio" name="registerType" value="url">URL 등록
											<input type="radio" name="registerType" value="url" checked="checked">다중 URL 등록
										</form>
									</td>
								</tr>
								<tr>
									<td class="line" colspan="5"></td>
								</tr>
								<tr style="background-color: rgb(245, 245, 245);">
									<td>아이디</td>
									<td>이름</td>
									<td>가젯유형</td>
									<td>소개</td>
									<td>URL</td>
								</tr>
								<tr style="background-color: rgb(300, 300, 300);">
									<td><form action=""><input type="text" size="5"></form> </td>
									<td><form action=""><input type="text" size="5"></form> </td>
									<td><form action=""><select id="appCategory"
										name="appCategory"
										onchange="_showValidationError(this,_validateRequired(this));">
										<option value="">유형을 선택하세요</option>
										<!-- option value="badges">Badges</option> -->
										<option value="communication">커뮤니케이션</option>
										<option value="dating">데이트</option>
										<option value="events">이벤트</option>
										<option value="finance">경제</option>
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
									<td><form action=""><input type="text"></form></td>
									<td><form action=""><input type="text"></form></td>
								</tr>
								<tr style="background-color: rgb(300, 300, 300);">
									<td><form action=""><input type="text" size="5"></form> </td>
									<td><form action=""><input type="text" size="5"></form> </td>
									<td><form action=""><select id="appCategory"
										name="appCategory"
										onchange="_showValidationError(this,_validateRequired(this));">
										<option value="">유형을 선택하세요</option>
										<!-- option value="badges">Badges</option> -->
										<option value="communication">커뮤니케이션</option>
										<option value="dating">데이트</option>
										<option value="events">이벤트</option>
										<option value="finance">경제</option>
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
									<td><form action=""><input type="text"></form></td>
									<td><form action=""><input type="text"></form></td>
								</tr>
								<tr style="background-color: rgb(300, 300, 300);">
									<td><form action=""><input type="text" size="5"></form> </td>
									<td><form action=""><input type="text" size="5"></form> </td>
									<td><form action=""><select id="appCategory"
										name="appCategory"
										onchange="_showValidationError(this,_validateRequired(this));">
										<option value="">유형을 선택하세요</option>
										<!-- option value="badges">Badges</option> -->
										<option value="communication">커뮤니케이션</option>
										<option value="dating">데이트</option>
										<option value="events">이벤트</option>
										<option value="finance">경제</option>
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
									<td><form action=""><input type="text"></form></td>
									<td><form action=""><input type="text"></form></td>
								</tr>
								<tr style="background-color: rgb(300, 300, 300);">
									<td><form action=""><input type="text" size="5"></form> </td>
									<td><form action=""><input type="text" size="5"></form> </td>
									<td><form action=""><select id="appCategory"
										name="appCategory"
										onchange="_showValidationError(this,_validateRequired(this));">
										<option value="">유형을 선택하세요</option>
										<!-- option value="badges">Badges</option> -->
										<option value="communication">커뮤니케이션</option>
										<option value="dating">데이트</option>
										<option value="events">이벤트</option>
										<option value="finance">경제</option>
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
									<td><form action=""><input type="text"></form></td>
									<td><form action=""><input type="text"></form></td>
								</tr>
								<tr style="background-color: rgb(300, 300, 300);">
									<td><form action=""><input type="text" size="5"></form> </td>
									<td><form action=""><input type="text" size="5"></form> </td>
									<td><form action=""><select id="appCategory"
										name="appCategory"
										onchange="_showValidationError(this,_validateRequired(this));">
										<option value="">유형을 선택하세요</option>
										<!-- option value="badges">Badges</option> -->
										<option value="communication">커뮤니케이션</option>
										<option value="dating">데이트</option>
										<option value="events">이벤트</option>
										<option value="finance">경제</option>
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
									<td><form action=""><input type="text"></form></td>
									<td><form action=""><input type="text"></form></td>
								</tr>
								<tr>
									<td class="line" colspan="5"></td>
								</tr>
							</tbody>
						</table>
						</td>
					</tr>
					<tr>
						<td><!-- buttons -->
						<div class="paging"><em class="p"><a href="javascript:void">다중 아이디 중목 체크</a></em><em class="n"><a href="DeveloperRegisterGadget_Source2.jsp">가젯등록</a></em></div>
						</td>
					</tr>
				</tbody>
			</table>
			</div>
			<!-- east div --></td>
		</tr>
		<!-- south -->
		<tr height="5%">
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