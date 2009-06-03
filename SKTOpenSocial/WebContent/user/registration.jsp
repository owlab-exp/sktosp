<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>User Registration - SKT OpenSocial Pilot</title>

<link rel="stylesheet" type="text/css" href="main.css">
<script type="text/javascript" src="main.js"></script>
<script type="text/javascript" src="registration.js"></script>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >




<table width="1023" height="767" border="1" cellspacing="0" cellpadding="0">
  <tr>
  <!-- north -->

    <td colspan=3 height="10%" align="center" valign="middle">
      <div id="header">
      <table width="100%" height="100%" border="1">
        <tr align="center">
          <td width="25%" onclick="javascript:location.href=''">홈</td>
          <td width="20%">사용자 메뉴</td>
          <td width="20%">개발자 메뉴</td>
          <td></td>
          <td width="10%">관리자</td>
        </tr>
      </table>
    </div>
    </td>

  </tr>
  <tr>
  <!-- west -->

    <td width="25%" align="center" valign="top">
    <div id="west">
      <div class="login">
      <table>
        <tr>
          <td>
          <form> 
          	
          </form>
          <!--  
              <form id="login" name="login" action="login.jsp" target="_self" method="post" autocomplete="off" onsubmit="return form_chk();"> 
              이메일: <input type="text" id="loginEmail" name="email" class="bg" title="이메일 주소 입력" onfocus="ChgInput(this);" onkeydown="ChgInput(this);" onmouseover="this.focus();" datatype="an" mask="-_@." /> 
              <br>비밀번호: <input type="password" id="loginPasswd" name="passwd" class="bg" title="비밀번호 입력" onfocus="ChgInput(this);" onkeydown="ChgInput(this);" onmouseover="this.focus();" enc="on" /> 
              <br><br><input type="submit" class="btn" title="로그인버튼" value="로그인"/>
              <input type="submit" class="btn" title="회원가입" value="회원가입"/>  
              <input type="hidden" id="loginEChk" name="echk" value="" /> 
              </form>
              -->
          </td>
        </tr>
      </table>
      </div>
    </div>
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
            <li><strong>회원가입</strong></li> 
            </ul>
            </div>
          </td>
        </tr>
        
      </table>
      
      <table border='0' width='550' align='center' cellspacing='0' cellpadding='0'>
        <tr>
          <td width='100%' align='center' height='30'></td>
        </tr>
      </table>
      <table border='0' width='550' align='center' cellspacing='1' cellpadding='5' bgcolor='#686868' style='line-height: 150%'>
        <tr>
          <td width='100%' bgcolor='#FFFFFF'><font color='#f26e15'>* 회원 ID는
            4 자 ~ 20자 이내의 영문과 숫자로 하시면 됩니다.<br>
            * 비밀번호는 4 ~ 15자의 영문과 숫자로 하시면
            됩니다.</font><br>* <font color='#F4554D'><b>√</b></font><font color='#f26e15'> 표시는 회원등록시 반드시 입력하셔야 합니다.</font></td>
        </tr>
      </table>
      <table border='0' width='550' align='center' cellspacing='0' cellpadding='0'>
        <tr>
          <td width='100%' align='center' height='20'></td>
        </tr>
      </table>
      
      <table border='0' width='550' align='center' bgcolor='#686868' cellspacing='1' cellpadding='0'>
<form name='member_form' method='POST' Onsubmit='return chk_member_form();' action='member.php3'>
<input type='hidden' name='link' value='input'>
<input type='hidden' name='mode' value='new'>
</form>
  <tr>
    <td width='100%' bgcolor='#FFFFFF'>

    
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 원하는 아이디 <font color='red'><b>√</b></font></td>
          <td width='1%'></td>
          <td width='74%'><input type='text' name='id' size='20' maxlength='20'> <a href='#' Onclick='search_id(document.member_form)'><img align='absMiddle' border='0' src='images/bt_double.gif' width='62' height='19' align='absmiddle'></a></td>
        </tr>
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 암호 <font color='red'><b>√</b></font></td>
          <td width='1%'></td>
          <td width='74%'><input type='password' name='passwd' size='20'></td>
        </tr>
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 암호 확인 <font color='red'><b>√</b></font></td>
          <td width='1%'></td>
          <td width='74%'><input type='password' name='re_passwd' size='20'></td>
        </tr>
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 회원명 <font color='red'><b>√</b></font></td>
          <td width='1%'></td>
          <td width='74%'><input type='text' name='name' size='20'></td>
        </tr>
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr> 
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 이메일 <font color='red'><b>√</b></font></td> 
          <td width='1%'></td>
          <td width='74%'><input type='text' name='email' size='39'></td> 
        </tr> 
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr> 
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 홈페이지 <font color='red'><b>√</b></font></td> 
          <td width='1%'></td>
          <td width='74%'><input type='text' name='homepage' size='46'></td> 
        </tr> 
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr> 
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 핸드폰 <font color='red'><b>√</b></font></td> 
          <td width='1%'></td>
          <td width='74%'><input type='text' name='c_phone1' size='5'>  -&nbsp; <input type='text' name='c_phone2' size='5'>   
            -&nbsp; <input type='text' name='c_phone3' size='5'></td>  
        </tr>  
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>  
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 전화번호 <font color='red'><b>√</b></font></td>  
          <td width='1%'></td>
          <td width='74%'><input type='text' name='h_phone1' size='5'> -&nbsp; <input type='text' name='h_phone2' size='5'>   
            -&nbsp; <input type='text' name='h_phone3' size='5'></td>  
        </tr>  
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 주민등록번호 <font color='red'><b>√</b></font></td>
          <td width='1%'></td>
          <td width='74%'><input type='text' name='jumin1' size='10'> -&nbsp; <input type='text' name='jumin2' size='10'></td> 
        </tr> 
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>  
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 생일 <font color='red'><b>√</b></font></td>  
          <td width='1%'></td>
          <td width='74%'><input type='text' name='birth1' size='5'> -&nbsp; <input type='text' name='birth2' size='5'>&nbsp;   
            - <input type='text' name='birth3' size='5'></td>  
        </tr>  
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>  
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 음(양)력 <font color='red'><b>√</b></font></td>  
          <td width='1%'></td>
          <td width='74%'>음력 <input type='radio' value='음력' checked name='birth_type'>&nbsp;&nbsp;&nbsp;   
            양력 <input type='radio' value='양력' name='birth_type'></td>  
        </tr>  
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>  
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> zip code <font color='red'><b>√</b></font></td>  
          <td width='1%'></td>
          <td width='74%'><input type='text' name='h_zip1' size='5'> -&nbsp; <input type='text' name='h_zip2' size='5'>&nbsp; <a href='javascript:void(post_searching());'><img align='absMiddle' border='0' src='http://www.keodo.co.kr/bbseboard/images/bt_search.gif'></a></td>  
        </tr>  
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>  
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 집주소 <font color='red'><b>√</b></font></td>  
          <td width='1%'></td>
          <td width='74%'><input type='text' name='h_addr' size='55'>&nbsp; </td>  
        </tr>  
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>  
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 성별 <font color='red'><b>√</b></font></td>  
          <td width='1%'></td>
          <td width='74%'>남자 <input type='radio' value='남' checked name='sex'>&nbsp;&nbsp;   
            여자 <input type='radio' value='여' name='sex'></td>  
        </tr>  
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>  
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 직업 <font color='red'><b>√</b></font></td>  
          <td width='1%'></td>
          <td width='74%'><select size='1' name='job'>  
              <option value=''>- 선택 -</option><option  value='무직'>무직</option><option  value='학생'>학생</option><option  value='컴퓨터/인터넷'>컴퓨터/인터넷</option><option  value='언론'>언론</option><option  value='공무원'>공무원</option><option  value='군인'>군인</option><option  value='서비스업'>서비스업</option><option  value='교육'>교육</option><option  value='금융/증권/보험업'>금융/증권/보험업</option><option  value='유통업'>유통업</option><option  value='예술'>예술</option><option  value='의료'>의료</option><option  value='볍률'>법률</option><option  value='건설업'>건설업</option><option  value='제조업'>제조업</option><option  value='부동산업'>부동산업</option><option  value='운송업'>운송업</option><option  value='농/수/임/광산업'>농/수/임/광산업</option><option  value='가사'>가사</option><option  value='기타'>기타</option>
            </select></td>
        </tr>
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 메일링 수신 <font color='red'><b>√</b></font></td> 
          <td width='1%'> </td>
          <td width='74%'>수신 <input type='radio' value='yes' checked name='mailling'>&nbsp;&nbsp;   
            수신거부 <input type='radio' value='no' name='mailling'></td>  
        </tr>  
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>  
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 개인정보공개 <font color='red'><b>√</b></font></td> 
          <td width='1%'> </td>
          <td width='74%'>공개 <input type='radio' value='yes' checked name='info_open'>&nbsp;&nbsp;   
            비공개 <input type='radio' value='no' name='info_open'></td>  
        </tr>  
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>  
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 추천아이디</td>  
          <td width='1%'></td>
          <td width='74%'><input type='text' name='recom_id' size='20'></td>  
        </tr>  
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 자기 소개 <font color='red'><b>√</b></font></td>
          <td width='1%'>   </td>       
          <td width='74%'><textarea rows='5' name='intro' style='width:100%'></textarea></td>
        </tr>
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>  
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 좋아하는 연애인 <font color='red'><b>√</b></font></td>  
          <td width='1%'></td>
          <td width='74%'><select size='1' name='add_01'>
<option value=''>-- 선택 --</option>
<option value='유호성'>유호성</option>
<option value='장동건'>장동건</option>
<option value='정우성'>정우성</option>
<option value='차태현'>차태현</option>
<option value='없음'>아무도 없음</option>
</select></td>
        </tr>
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 직장명 <font color='red'><b>√</b></font></td>  
          <td width='1%'></td>
          <td width='74%'><input type='text' name='add_02'></td>
        </tr>
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 경혼 유무 <font color='red'><b>√</b></font></td>  
          <td width='1%'></td>
          <td width='74%'>미혼 <input type='radio' value='미혼' checked name='add_03'> &nbsp;&nbsp;기혼 <input type='radio' value='기혼' name='add_03'></td>
        </tr>
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 뉴스 레터 받기 <font color='red'><b>√</b></font></td>  
          <td width='1%'></td>
          <td width='74%'>받음 <input type='checkbox' name='add_04' checked value='받음'></td>
        </tr>
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> 사이트 건의사항 <font color='red'><b>√</b></font></td>  
          <td width='1%'></td>
          <td width='74%'><textarea rows='5' name='add_05' style='width:100%'></textarea></td>
        </tr>
      </table>

    </td>
  </tr>

</table>
     
<table border='0' width='550' align='center' cellspacing='0' cellpadding='0'>
  <tr>
    <td width='100%' align='center' height='30'><input type='image' src='http://www.keodo.co.kr/bbseboard/images/bt_memberjoin.gif' border='0' align='absmiddle' style='border:0'>&nbsp;&nbsp;&nbsp;<a href='javascript:document.member_form.reset()'><img src='http://www.keodo.co.kr/bbseboard/images/bt_cancel.gif' border='0' align='absmiddle'></a></td>
  </tr>
</table>
      
      
      </div> <!-- east div -->
      
    </td>
  </tr>
  <!-- south -->
  <tr>
    <td colspan=3 height="10%" align="center" valign="middle">
      <div id="footer">
      <table width="100%" height="100%" border="1px">
        <tr>
          <td><strong>Copyright &copy; SK Telecom. All rights reserved.</strong>
          </td>
        </tr>
      </table>
      </div>
      </td>
	</tr> 
</table>


</body>
</html>