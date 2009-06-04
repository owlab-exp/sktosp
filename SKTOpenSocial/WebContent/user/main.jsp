<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/common/header.jsp"%>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >

<table width="1023" height="767" border="1" cellspacing="0" cellpadding="0">

    <tr>
  <!-- north -->
    <td colspan="3" height="10%" align="center" valign="middle">

<%@ include file="/common/north.jsp"%>

    </td>
  </tr>
  
  <tr>
  <!-- west -->
    <td width="25%" align="center" valign="top">

<%@ include file="/common/west.jsp"%>
<%@ include file="/common/menu.jsp"%>

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
            <li><strong>홈</strong></li>
            </ul>
            </div>
          </td>
        </tr>

        
        <!-- search -->
        <tr>
          <td>
          <dl class="snbsearch">
		      <dd align="center">
          	<form name="search" action="search.jsp">
		        <select name="w" id="w" onChange="onClick_Select(this);">
		          <option name="user" value="name" >사용자 이름</option>
		          <option name="gadget" value="desc" >가젯 이름</option>
		        </select>
		        <input type="text" name="query" id="query" onfocus="this.value='';"/>&nbsp;
		        <img type="submit" src="images/btn_search.gif" align=absmiddle alt="검색" >
  		      </form>
		       </dd>
		      </dl>
		      </td>
	      </tr>

        
        <tr>
          <td>
          
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
          			<td><span class="num">183</span></td> 
                <td>박보영</td> 
      			    <td align="center">팬클럽</td> 
      			    <td align="center"><span class="num">2009.02.20</span></td> 
      			    <td align="center"><span class="num">12</span></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>			  
      			  
              <tr> 
          			<td><span class="num">184</span></td> 
                <td>박보영</td> 
      			    <td align="center">[스크랩] 박보영 - 키위닷컴 인터뷰1</td> 
      			    <td align="center"><span class="num">2009.02.21</span></td> 
      			    <td align="center"><span class="num">12</span></td> 
      			  </tr> 
      			  <tr><td class="line" colspan="6"></td></tr>
      
              <tr> 
          			<td><span class="num">184</span></td> 
                <td>박보영</td> 
      			    <td align="center">[스크랩] 박보영 - 키위닷컴 인터뷰2</td> 
      			    <td align="center"><span class="num">2009.02.22</span></td> 
      			    <td align="center"><span class="num">12</span></td> 
      			  </tr> 
      			  <tr><td class="line" colspan="6"></td></tr>
      
              <tr> 
          			<td><span class="num">184</span></td> 
                <td>박보영</td> 
      			    <td align="center">[스크랩] 박보영 - 키위닷컴 인터뷰3</td> 
      			    <td align="center"><span class="num">2009.02.23</span></td> 
      			    <td align="center"><span class="num">12</span></td> 
      			  </tr> 
      			  <tr><td class="line" colspan="6"></td></tr>
      
              <tr> 
          			<td><span class="num">184</span></td> 
                <td>박보영</td> 
      			    <td align="center">[스크랩] 박보영 - 키위닷컴 인터뷰4</td> 
      			    <td align="center"><span class="num">2009.02.24</span></td> 
      			    <td align="center"><span class="num">12</span></td> 
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
      		</td>
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