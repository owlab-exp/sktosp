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
          <td width="25%" onclick="javascript:location.href=''">Ȩ</td>
          <td width="20%">����� �޴�</td>
          <td width="20%">������ �޴�</td>
          <td></td>
          <td width="10%">������</td>
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
              �̸���: <input type="text" id="loginEmail" name="email" class="bg" title="�̸��� �ּ� �Է�" onfocus="ChgInput(this);" onkeydown="ChgInput(this);" onmouseover="this.focus();" datatype="an" mask="-_@." /> 
              <br>��й�ȣ: <input type="password" id="loginPasswd" name="passwd" class="bg" title="��й�ȣ �Է�" onfocus="ChgInput(this);" onkeydown="ChgInput(this);" onmouseover="this.focus();" enc="on" /> 
              <br><br><input type="submit" class="btn" title="�α��ι�ư" value="�α���"/>
              <input type="submit" class="btn" title="ȸ������" value="ȸ������"/>  
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
            <li>Ȩ</li>
            <li><strong>ȸ������</strong></li> 
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
          <td width='100%' bgcolor='#FFFFFF'><font color='#f26e15'>* ȸ�� ID��
            4 �� ~ 20�� �̳��� ������ ���ڷ� �Ͻø� �˴ϴ�.<br>
            * ��й�ȣ�� 4 ~ 15���� ������ ���ڷ� �Ͻø�
            �˴ϴ�.</font><br>* <font color='#F4554D'><b>��</b></font><font color='#f26e15'> ǥ�ô� ȸ����Ͻ� �ݵ�� �Է��ϼž� �մϴ�.</font></td>
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
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> ���ϴ� ���̵� <font color='red'><b>��</b></font></td>
          <td width='1%'></td>
          <td width='74%'><input type='text' name='id' size='20' maxlength='20'> <a href='#' Onclick='search_id(document.member_form)'><img align='absMiddle' border='0' src='images/bt_double.gif' width='62' height='19' align='absmiddle'></a></td>
        </tr>
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> ��ȣ <font color='red'><b>��</b></font></td>
          <td width='1%'></td>
          <td width='74%'><input type='password' name='passwd' size='20'></td>
        </tr>
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> ��ȣ Ȯ�� <font color='red'><b>��</b></font></td>
          <td width='1%'></td>
          <td width='74%'><input type='password' name='re_passwd' size='20'></td>
        </tr>
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> ȸ���� <font color='red'><b>��</b></font></td>
          <td width='1%'></td>
          <td width='74%'><input type='text' name='name' size='20'></td>
        </tr>
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr> 
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> �̸��� <font color='red'><b>��</b></font></td> 
          <td width='1%'></td>
          <td width='74%'><input type='text' name='email' size='39'></td> 
        </tr> 
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr> 
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> Ȩ������ <font color='red'><b>��</b></font></td> 
          <td width='1%'></td>
          <td width='74%'><input type='text' name='homepage' size='46'></td> 
        </tr> 
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr> 
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> �ڵ��� <font color='red'><b>��</b></font></td> 
          <td width='1%'></td>
          <td width='74%'><input type='text' name='c_phone1' size='5'>  -&nbsp; <input type='text' name='c_phone2' size='5'>   
            -&nbsp; <input type='text' name='c_phone3' size='5'></td>  
        </tr>  
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>  
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> ��ȭ��ȣ <font color='red'><b>��</b></font></td>  
          <td width='1%'></td>
          <td width='74%'><input type='text' name='h_phone1' size='5'> -&nbsp; <input type='text' name='h_phone2' size='5'>   
            -&nbsp; <input type='text' name='h_phone3' size='5'></td>  
        </tr>  
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> �ֹε�Ϲ�ȣ <font color='red'><b>��</b></font></td>
          <td width='1%'></td>
          <td width='74%'><input type='text' name='jumin1' size='10'> -&nbsp; <input type='text' name='jumin2' size='10'></td> 
        </tr> 
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>  
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> ���� <font color='red'><b>��</b></font></td>  
          <td width='1%'></td>
          <td width='74%'><input type='text' name='birth1' size='5'> -&nbsp; <input type='text' name='birth2' size='5'>&nbsp;   
            - <input type='text' name='birth3' size='5'></td>  
        </tr>  
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>  
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> ��(��)�� <font color='red'><b>��</b></font></td>  
          <td width='1%'></td>
          <td width='74%'>���� <input type='radio' value='����' checked name='birth_type'>&nbsp;&nbsp;&nbsp;   
            ��� <input type='radio' value='���' name='birth_type'></td>  
        </tr>  
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>  
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> zip code <font color='red'><b>��</b></font></td>  
          <td width='1%'></td>
          <td width='74%'><input type='text' name='h_zip1' size='5'> -&nbsp; <input type='text' name='h_zip2' size='5'>&nbsp; <a href='javascript:void(post_searching());'><img align='absMiddle' border='0' src='http://www.keodo.co.kr/bbseboard/images/bt_search.gif'></a></td>  
        </tr>  
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>  
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> ���ּ� <font color='red'><b>��</b></font></td>  
          <td width='1%'></td>
          <td width='74%'><input type='text' name='h_addr' size='55'>&nbsp; </td>  
        </tr>  
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>  
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> ���� <font color='red'><b>��</b></font></td>  
          <td width='1%'></td>
          <td width='74%'>���� <input type='radio' value='��' checked name='sex'>&nbsp;&nbsp;   
            ���� <input type='radio' value='��' name='sex'></td>  
        </tr>  
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>  
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> ���� <font color='red'><b>��</b></font></td>  
          <td width='1%'></td>
          <td width='74%'><select size='1' name='job'>  
              <option value=''>- ���� -</option><option  value='����'>����</option><option  value='�л�'>�л�</option><option  value='��ǻ��/���ͳ�'>��ǻ��/���ͳ�</option><option  value='���'>���</option><option  value='������'>������</option><option  value='����'>����</option><option  value='���񽺾�'>���񽺾�</option><option  value='����'>����</option><option  value='����/����/�����'>����/����/�����</option><option  value='�����'>�����</option><option  value='����'>����</option><option  value='�Ƿ�'>�Ƿ�</option><option  value='����'>����</option><option  value='�Ǽ���'>�Ǽ���</option><option  value='������'>������</option><option  value='�ε����'>�ε����</option><option  value='��۾�'>��۾�</option><option  value='��/��/��/�����'>��/��/��/�����</option><option  value='����'>����</option><option  value='��Ÿ'>��Ÿ</option>
            </select></td>
        </tr>
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> ���ϸ� ���� <font color='red'><b>��</b></font></td> 
          <td width='1%'> </td>
          <td width='74%'>���� <input type='radio' value='yes' checked name='mailling'>&nbsp;&nbsp;   
            ���Űź� <input type='radio' value='no' name='mailling'></td>  
        </tr>  
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>  
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> ������������ <font color='red'><b>��</b></font></td> 
          <td width='1%'> </td>
          <td width='74%'>���� <input type='radio' value='yes' checked name='info_open'>&nbsp;&nbsp;   
            ����� <input type='radio' value='no' name='info_open'></td>  
        </tr>  
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>  
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> ��õ���̵�</td>  
          <td width='1%'></td>
          <td width='74%'><input type='text' name='recom_id' size='20'></td>  
        </tr>  
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> �ڱ� �Ұ� <font color='red'><b>��</b></font></td>
          <td width='1%'>   </td>       
          <td width='74%'><textarea rows='5' name='intro' style='width:100%'></textarea></td>
        </tr>
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>  
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> �����ϴ� ������ <font color='red'><b>��</b></font></td>  
          <td width='1%'></td>
          <td width='74%'><select size='1' name='add_01'>
<option value=''>-- ���� --</option>
<option value='��ȣ��'>��ȣ��</option>
<option value='�嵿��'>�嵿��</option>
<option value='���켺'>���켺</option>
<option value='������'>������</option>
<option value='����'>�ƹ��� ����</option>
</select></td>
        </tr>
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> ����� <font color='red'><b>��</b></font></td>  
          <td width='1%'></td>
          <td width='74%'><input type='text' name='add_02'></td>
        </tr>
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> ��ȥ ���� <font color='red'><b>��</b></font></td>  
          <td width='1%'></td>
          <td width='74%'>��ȥ <input type='radio' value='��ȥ' checked name='add_03'> &nbsp;&nbsp;��ȥ <input type='radio' value='��ȥ' name='add_03'></td>
        </tr>
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> ���� ���� �ޱ� <font color='red'><b>��</b></font></td>  
          <td width='1%'></td>
          <td width='74%'>���� <input type='checkbox' name='add_04' checked value='����'></td>
        </tr>
      </table>
      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
        <tr>
          <td bgcolor='#f4f4f4' width='25%' height='30'>&nbsp;<img src='http://www.keodo.co.kr/bbseboard/images/dot_20.gif'> ����Ʈ ���ǻ��� <font color='red'><b>��</b></font></td>  
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