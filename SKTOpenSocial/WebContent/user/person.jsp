<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="s" uri="/struts-tags" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
<title>SKT OpenSocial Pilot - Person</title>
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
            <li><strong>사용자정보페이지</strong></li> 
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
  						사용자정보
  							</font></b>
  					</td>
  					<td width="100%"><hr></td>
  				</tr>
  			</table>
  			<table width="100%" border="0" cellspacing="2" cellpadding="2">
  				<tr>
  					<td width="20%" nowrap="nowrap" valign="top">
  						<font size="-1">
  						성:
  						</font>
  					</td>
  					<td>
  					<input  type="text" name="LastName"  id="LastName" size="30" value="Lim" />
  					</td>
  				</tr>
  				<tr>
  					<td width="20%" nowrap="nowrap" valign="top">
  						<font size="-1">
  						이름:
 						 </font>
  					</td>
  					<td>
  						<input  type="text" name="FirstName"  id="FirstName" size="30" value="Seong Yong" />
  					</td>
  				</tr>
  				<tr>
  					<td width="20%" nowrap="nowrap" valign="top">
  						<font size="-1">
  							별명:
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
            <table cellpadding="0" cellspacing="0" width="100%" class="subtit_board" summary="게시판"> 
              <colgroup> 
                <col width="10%" /> 
                <col width="20%" /> 
                <col width="50%" /> 
                <col width="10%" /> 
                <col width="10%" /> 
              </colgroup>
              <tr> 
          			<td><span class="num">1</span></td> 
                <td>가젯1</td> 
      			    <td align="center">동안 가젯</td> 
      			    <td align="center"><span class="num">2009.02.21</span></td> 
      			    <td align="center"><span class="num">user1</span></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>			  
      			  
              <tr> 
          			<td><span class="num">2</span></td> 
                <td>가젯2</td> 
      			    <td align="center">바보 가젯</td> 
      			    <td align="center"><span class="num">2009.02.22</span></td> 
      			    <td align="center"><span class="num">user2</span></td> 
      			  </tr> 
      			  <tr><td class="line" colspan="6"></td></tr>
      
              <tr> 
          			<td><span class="num">3</span></td> 
                <td>가젯3</td> 
      			    <td align="center">날씨 가젯</td> 
      			    <td align="center"><span class="num">2009.02.23</span></td> 
      			    <td align="center"><span class="num">user3</span></td> 
      			  </tr> 
      			  <tr><td class="line" colspan="6"></td></tr>
      
              <tr> 
          			<td><span class="num">4</span></td> 
                <td>가젯4</td> 
      			    <td align="center">게임 가젯</td> 
      			    <td align="center"><span class="num">2009.02.24</span></td> 
      			    <td align="center"><span class="num">user4</span></td> 
      			  </tr> 
      			  <tr><td class="line" colspan="6"></td></tr>
      
              <tr> 
          			<td><span class="num">5</span></td> 
                <td>가젯5</td> 
      			    <td align="center">짝짓기 가젯</td> 
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
<%@ include file="/common/south.jsp"%>
	</td>
  </tr> 

</table>


</body>
</html>