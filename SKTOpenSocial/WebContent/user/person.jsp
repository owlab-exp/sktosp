<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>User My Page - SKT OpenSocial Pilot</title>

<link rel="stylesheet" type="text/css" href="main.css">
<script type="text/javascript" src="main.js"></script>

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
              <form id="login" name="login" action="login.jsp" target="_self" method="post" autocomplete="off" onsubmit="return form_chk();"> 
              �̸���: <input type="text" id="loginEmail" name="email" class="bg" title="�̸��� �ּ� �Է�" onfocus="ChgInput(this);" onkeydown="ChgInput(this);" onmouseover="this.focus();" datatype="an" mask="-_@." /> 
              <br>��й�ȣ: <input type="password" id="loginPasswd" name="passwd" class="bg" title="��й�ȣ �Է�" onfocus="ChgInput(this);" onkeydown="ChgInput(this);" onmouseover="this.focus();" enc="on" /> 
              <br><br><input type="submit" class="btn" title="�α��ι�ư" value="�α���"/> 
              <input type="hidden" id="loginEChk" name="echk" value="" /> 
              </form>
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
            <li>����� �޴�</li>
            <li><strong>���������������</strong></li> 
            </ul>
            </div>
          </td>
        </tr>
 
 		<tr>
 			<form id="createaccount" action="UpdateUserInfo" method="post">
  			<input type="hidden" name="timeStmp" id="timeStmp" value='1244032680'/>
			<input type="hidden" name="secTok" id="secTok" value='8fcbe0f2eec327eba0c743c1c5270b74'/>
  			<table width="100%" cellpadding="3">
  				<tr>
  					<td nowrap>
  						<b><font color="#333333">
  						���������
  							</font></b>
  					</td>
  					<td width="100%"><hr></td>
  				</tr>
  			</table>
  			<table width="100%" border="0" cellspacing="2" cellpadding="2">
  				<tr>
  					<td width="20%" nowrap="nowrap" valign="top">
  						<font size="-1">
  						��:
  						</font>
  					</td>
  					<td>
  					<input  type="text" name="LastName"  id="LastName" size="30" value="Lim" />
  					</td>
  				</tr>
  				<tr>
  					<td width="20%" nowrap="nowrap" valign="top">
  						<font size="-1">
  						�̸�:
 						 </font>
  					</td>
  					<td>
  						<input  type="text" name="FirstName"  id="FirstName" size="30" value="Seong Yong" />
  					</td>
  				</tr>
  				<tr>
  					<td width="20%" nowrap="nowrap" valign="top">
  						<font size="-1">
  							����:
  						</font>
  					</td>
	  				<td>
	  				<input  type="text" name="NickName"  id="NickName" size="30" value="nyongs" />
	  				</td>			
  				</tr>
  			</table>
			</form>
			<br/><br/>
			
			
          
            <!-- bbs -->
            <table cellpadding="0" cellspacing="0" width="100%" class="subtit_board" summary="�Խ���"> 
              <colgroup> 
                <col width="10%" /> 
                <col width="20%" /> 
                <col width="50%" /> 
                <col width="10%" /> 
                <col width="10%" /> 
              </colgroup>
              <tr> 
          			<td><span class="num">1</span></td> 
                <td>����1</td> 
      			    <td align="center">���� ����</td> 
      			    <td align="center"><span class="num">2009.02.21</span></td> 
      			    <td align="center"><span class="num">user1</span></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>			  
      			  
              <tr> 
          			<td><span class="num">2</span></td> 
                <td>����2</td> 
      			    <td align="center">�ٺ� ����</td> 
      			    <td align="center"><span class="num">2009.02.22</span></td> 
      			    <td align="center"><span class="num">user2</span></td> 
      			  </tr> 
      			  <tr><td class="line" colspan="6"></td></tr>
      
              <tr> 
          			<td><span class="num">3</span></td> 
                <td>����3</td> 
      			    <td align="center">���� ����</td> 
      			    <td align="center"><span class="num">2009.02.23</span></td> 
      			    <td align="center"><span class="num">user3</span></td> 
      			  </tr> 
      			  <tr><td class="line" colspan="6"></td></tr>
      
              <tr> 
          			<td><span class="num">4</span></td> 
                <td>����4</td> 
      			    <td align="center">���� ����</td> 
      			    <td align="center"><span class="num">2009.02.24</span></td> 
      			    <td align="center"><span class="num">user4</span></td> 
      			  </tr> 
      			  <tr><td class="line" colspan="6"></td></tr>
      
              <tr> 
          			<td><span class="num">5</span></td> 
                <td>����5</td> 
      			    <td align="center">¦���� ����</td> 
      			    <td align="center"><span class="num">2009.02.25</span></td> 
      			    <td align="center"><span class="num">user5</span></td> 
      			  </tr> 
      			  <tr><td class="line" colspan="6"></td></tr>
      			  	
            </table>
            
            <!-- paging --> 
            <div class="right_basic" style="clear:both;"> 
      			<table width="100%" border="0" cellspacing="0" cellpadding="0" > 
      		    <tr> 
      			    <td align="center" height="28" valign="bottom" > 
      					  <table cellspacing="0" cellpadding="0" border="0"> 
      						  <tr>
      						      <td align=center onMouseOut=this.style.color='#333333' onMouseOver=this.style.color='#FF6600' style='padding:0 6 1 6; cursor:hand;' nowrap><b><font color='#FF6600'>1</font></b></td> 
			                      <td style='padding-top:1px;'>
			                        <table width='1' height='12' border='0' cellspacing='0' cellpadding='0'> 
			                          <tr> 
			                            <td bgcolor=#aaaaaa><img height=1 width=1 src='http://c1img.cyworld.co.kr/img/no.gif'></td> 
			                          </tr> 
			                        </table>
			                      </td>
			                      
			                      <td align=center style='padding:0 6 1 6; cursor:hand;' onMouseOut=this.style.color='#333333' onMouseOver=this.style.color='#FF6600' onClick=location.href='genbrd_list.asp?club_id=51937716&board_no=87&search_type=&search_keyword=&cpage=2&board_type=1&club_auth=x&club_did=&list_type=2&show_type=1&headtag_seq=' class='bbsla' nowrap>2</td> 
			                      <td style='padding-top:1px;'>
			                        <table width='1' height='12' border='0' cellspacing='0' cellpadding='0'> 
			                          <tr> 
			                            <td bgcolor=#aaaaaa><img height=1 width=1 src='http://c1img.cyworld.co.kr/img/no.gif'></td> 
			                          </tr> 
			                        </table>
			                      </td>
			      
			                      <td align=center style='padding:0 6 1 6; cursor:hand;' onMouseOut=this.style.color='#333333' onMouseOver=this.style.color='#FF6600' onClick=location.href='genbrd_list.asp?club_id=51937716&board_no=87&search_type=&search_keyword=&cpage=2&board_type=1&club_auth=x&club_did=&list_type=2&show_type=1&headtag_seq=' class='bbsla' nowrap>2</td> 
			                      <td style='padding-top:1px;'>
			                        <table width='1' height='12' border='0' cellspacing='0' cellpadding='0'> 
			                          <tr> 
			                            <td bgcolor=#aaaaaa><img height=1 width=1 src='http://c1img.cyworld.co.kr/img/no.gif'></td> 
			                          </tr> 
			                        </table>
			                      </td>
			      
			                      <td align=center style='padding:0 6 1 6; cursor:hand;' onMouseOut=this.style.color='#333333' onMouseOver=this.style.color='#FF6600' onClick=location.href='genbrd_list.asp?club_id=51937716&board_no=87&search_type=&search_keyword=&cpage=2&board_type=1&club_auth=x&club_did=&list_type=2&show_type=1&headtag_seq=' class='bbsla' nowrap>2</td> 
			                      <td style='padding-top:1px;'>
			                        <table width='1' height='12' border='0' cellspacing='0' cellpadding='0'> 
			                          <tr> 
			                            <td bgcolor=#aaaaaa><img height=1 width=1 src='http://c1img.cyworld.co.kr/img/no.gif'></td> 
			                          </tr> 
			                        </table>
			                      </td>
      
                    			</tr>
      						</table>
      					</td>
      				</tr>
      			</table>
      			</div>

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