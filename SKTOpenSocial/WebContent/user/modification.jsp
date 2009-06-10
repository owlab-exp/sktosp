<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- for use of struts tags -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
<title>SKT OpenSocial Pilot - My Profile Modification</title>
</head>

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
            <li><strong>개인정보수정</strong></li> 
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
      
      <table border='0' width='550' align='center' bgcolor='#686868' cellspacing='1' cellpadding='0'>
		<s:form action="Registration" namespace="/user" >

		  <tr>
		    <td width='100%' bgcolor='#FFFFFF'>
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		    	<colgroup> 

                	<col width="40%" /> 
                	<col width="60%" />
				</colgroup>
		        <tr>
		          	<s:textfield label= "사용자아이디" name= "userid" required="true" value="nash2" /> 
		          	<s:submit align="left" action= "Multiplication_Check" value= "중복검사" name= "multi-check" 
	              />
		        </tr>
		      </table>
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" />
				</colgroup>
		        <tr>
		          	<s:password label= "암호" name= "password" required="true" value="nash2"/> 
		        </tr>
		      </table>
		      		  
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" />
				</colgroup>
		        <tr>
		          	<s:password label= "암호확인" name= "password_confirm" required="true" value="nash2"/> 
		        </tr>
		      </table>   
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" />
				</colgroup>
		        <tr>
		          	<s:textfield label= "사용자이름" name= "username" required="true" value="nashbabo"/> 
		        </tr>
		      </table>  
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" />
				</colgroup>
		        <tr>
		          	<s:textfield label= "나이" name= "age" required="false" value="30"/> 
		        </tr>
		      </table>  
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" />
				</colgroup>
		        <tr>
		       		<s:select label="성별" name="gender" headerKey="1" headerValue="-- 선택하세요 --" list="#{'male':'남성','female':'여성'}"/> 
	   	        </tr>
		      </table> 
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" />
				</colgroup>
		        <tr>
		          	<s:textfield label= "생일" name= "dataOfBirth" required="false" value="1979.08.24."/> 
		        </tr>
		      </table>  
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" />
				</colgroup>
		        <tr>
		          	<s:textfield label= "이메일" name= "email" required="true" value="skt@nate.com"/> 
		        </tr>
		      </table>  
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" />
				</colgroup>
		        <tr>
		          	<s:textfield label= "추가이메일" name= "email2" required="false" /> 
		        </tr>
		      </table> 
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" />
				</colgroup>
		        <tr>
		          	<s:textfield label= "주소" name= "address" required="false" value="서울"/> 
		        </tr>
		      </table>  
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" />
				</colgroup>
		        <tr>
		          	<s:textfield label= "추가주소" name= "address_optional" required="false" /> 
		        </tr>
		      </table>  
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" />
				</colgroup>
		        <tr>
		          	<s:textfield label= "학교" name= "school" required="false" value="KAIST"/> 
		        </tr>
		      </table> 
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" />
				</colgroup>
		        <tr>
		          	<s:textfield label= "추가학교" name= "school" required="false" /> 
		        </tr>
		      </table> 
		      
		      		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label= "직업" name= "job" required="false" value="student"/> 
		        </tr>
		      </table> 
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label= "추가직업" name= "job2" required="false" /> 
		        </tr>
		      </table> 
		
			  <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label= "체격" name= "bodytype.build" required="false" value="호리호리"/> 
		        </tr>
		      </table> 
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label= "눈동자색상" name= "bodytype.eyecolor" required="false" value="black"/> 
		        </tr>
		      </table> 
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label= "머리색상" name= "bodytype.haircolor" required="false" value="black"/> 
		        </tr>
		        
		      </table> 
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label= "키" name= "bodytype.height" required="false" value="180"/> 
		        </tr>
		      </table> 
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label= "몸무게" name= "bodytype.weight" required="false" value="80"/> 
		        </tr>
		      </table> 
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label= "좋아하는 책" name= "book" required="false" value="Architecture"/> 
		        </tr>
		      </table> 
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label= "좋아하는 책 추가" name= "book2" required="false" /> 
		        </tr>
		      </table> 
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label= "좋아하는 자동차" name= "car" required="false" value="아반떼"/> 
		        </tr>
		      </table> 
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label= "좋아하는 자동차추가" name= "car2" required="false" /> 
		        </tr>
		      </table> 
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label= "자녀" name= "child" required="false" value="destinychild"/> 
		        </tr>
		      </table> 
		      
		      		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label= "추가자녀" name= "child2" required="false" /> 
		        </tr>
		      </table> 
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label= "현재위치" name= "currentLocation" required="false" value="대전"/> 
		        </tr>
		      </table> 
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" />
				</colgroup>
		        <tr>
		       		<s:select label="음주" name="gender" headerKey="1" headerValue="-- 선택하세요 --" 
		       		list="#{'HEAVILY':'HEAVILY'
		       				,'NO':'NO'
		       				,'OCCASIONALLY':'OCCASIONALLY'
		       				,'QUIT':'QUIT'
		       				,'QUITTING':'QUITTING'
		       				,'REGULARLY':'REGULARLY'
		       				,'SOCIALLY':'SOCIALLY'
		       				,'YES':'YES'
		       				}"/> 
	   	        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="민족" name="ethnicity" required="false" value="한국인"/> 
		        </tr>
		      </table> 
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="패션" name="fashion" required="false" value="밀리터리룩"/> 
		        </tr>
		      </table> 
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="좋아하는음식" name="food" required="false" value="김치찌개"/> 
		        </tr>
		      </table> 
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="좋아하는음식추가" name="food2" required="false" /> 
		        </tr>
		      </table> 
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="행복한때" name="happiesWhen" required="false" value="프로젝트끝날때"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="좋아하는영웅" name="heroes" required="false" value="superman"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="좋아하는영웅추가" name="heroes" required="false" /> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="유머에대한생각" name="humor" required="false" value="글쎄"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="취미,특기" name="interest" required="false" value="공부"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="취미,특기추가" name="interests" required="false" /> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="관심직업" name="jobinterest" required="false" value="대통령"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="관심직업추가" name="jobinterests" required="false" /> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="사용언어" name="languageSpoken" required="false" value="한국어"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="사용언어추가" name="languageSpoken2" required="false" /> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="주거형태" name="livingArrangement" required="false" value="아파트"/> 
		        </tr>
		      </table>
		      
			  <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" />
				</colgroup>
		        <tr>
		       		<s:select label="관심분야" name="lookingfor" headerKey="1" headerValue="-- 선택하세요 --" 
		       		list="#{'ACTIVITY_PARTNERS':'ACTIVITY_PARTNERS'
		       				,'DATING':'DATING'
		       				,'FRIENDS':'FRIENDS'
		       				,'NETWORKING':'NETWORKING'
		       				,'RANDOM':'RANDOM'
		       				,'RELATIONSHIP':'RELATIONSHIP'
		       				}"/> 
	   	        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="좋아하는영화" name="movie" required="false" value="동해물과"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="영화추가" name="movie2" required="false" /> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="좋아하는음악" name="music" required="false" value="백두산이"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="음악추가" name="music2" required="false" /> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="추가이름" name="additional_name" required="false" value="없어"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="성" name="family_name" required="false" value="na"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="이름" name="given_name" required="false" value="sh2"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="호" name="honorific_prefix" required="false" value="Dr."/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="접미" name="honorific_suffix" required="false" value="great"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="비구조이름" name="unstructured" required="false" value="nash2"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" />
				</colgroup>
		        <tr>
		       		<s:select label="관심분야" name="lookingfor" headerKey="1" headerValue="-- 선택하세요 --" 
		       		list="#{'AWAY':'AWAY'
		       				,'CHAT':'CHAT'
		       				,'DND':'DND'
		       				,'OFFLINE':'OFFLINE'
		       				,'ONLINE':'ONLINE'
		       				,'XA':'XA'
		       				}"/> 
	   	        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="별명" name="nickname" required="false" value="Dr. nash"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="애완동물" name="pet" required="false" value="백구"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="애완동물추가" name="pet2" required="false" /> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="전화번호" name="phone.number" required="false" value="042-869-6114"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="전화번호종류" name="phone.type" required="false" value="유선전화"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="추가전화번호" name="pet2" required="false" /> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="추가전화번호종류" name="pet2" required="false" /> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="정치적관점" name="politicalviews" required="false" value="보수"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="프로파일송위치" name="profilesong_url_address" required="false" value="http://nate.com"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="프로파일송내용" name="profilesong_url_linktext" required="false" value="애국가"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="프로파일송위치종류" name="profilesong_url_type" required="false" value="website"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="프로파일위치" name="profile_url_address" required="false" value="http://nate.com"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="프로파일내용" name="profile_url_linktext" required="false" value="애국가"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="프로파일위치종류" name="profilevideo_url_type" required="false" value="website"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="프로파일비디오위치" name="profilevideo_url_address" required="false" value="http://nate.com"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="프로파일비디오내용" name="profilevideo_url_linktext" required="false" value="애국가"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="프로파일비디오위치종류" name="profilevideo_url_type" required="false" value="website"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="좋아하는인용문" name="quote" required="false" value="산은산이오"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="인용문추가" name="quote2" required="false" /> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="관계상태" name="relationshipstatus" required="false" value="좋음"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="종교" name="religion" required="false" value="무교"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="로맨스에대한" name="romance" required="false" value="내가하면로맨스"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="무서운것" name="scaredOf" required="false" value="벌레"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="성적방향" name="sexualOrientation" required="false" value="이성"/> 
		        </tr>
		      </table>

			  <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" />
				</colgroup>
		        <tr>
		       		<s:select label="흡연" name="smoker" headerKey="1" headerValue="-- 선택하세요 --" 
		       		list="#{'HEAVILY':'HEAVILY'
		       				,'NO':'NO'
		       				,'OCCASIONALLY':'OCCASIONALLY'
		       				,'QUIT':'QUIT'
		       				,'QUITTING':'QUITTING'
		       				,'REGULARLY':'REGULARLY'
		       				,'SOCIALLY':'SOCIALLY'
		       				,'YES':'YES'
		       				}"/> 
	   	        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="좋아하는스포츠" name="sport" required="false" value="숨쉬기"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="스포츠추가" name="sport2" required="false" /> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="상태" name="status" required="false" value="건들지마세요"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="태그" name="tag" required="false" value="숨쉬기"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="태그추가" name="tag2" required="false" /> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="이미지위치" name="thumbnail_url_address" required="false" value="http://nate.com"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="이미지내용" name="thumbnail_url_linktext" required="false" value="애국가"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="이미지위치종류" name="thumbnail_url_type" required="false" value="website"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="시간대" name="timzone" required="false" value="+9"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="turnOff" name="turnOff" required="false" value=""/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="turnOff추가" name="turnOff2" required="false" /> 
		        </tr>
		      </table>	
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="turnOn" name="turnOn" required="false" value=""/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="turnOn추가" name="turnOn2" required="false" /> 
		        </tr>
		      </table>	
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="tvShow" name="tvShow" required="false" value="무한도전"/> 
		        </tr>
		      </table>
		      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		      		<colgroup> 
                	<col width="40%" /> 
                	<col width="60%" /> 
				</colgroup>
		        <tr>
		          	<s:textfield label="tvShow추가" name="tvShow2" required="false" /> 
		        </tr>
		      </table>	
	      		      
	      
		      <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		    	<colgroup> 
                	<col width="30%" /> 
                	<col width="30%" />
                	<col width="40%" />
                </colgroup>
		        <tr>
		          <td>
		          	<s:submit align="center" action= "ModificationSubmit" value= "개인정보수정" name= "modificationsubmit" 
	              		/>
	              </td>
	         	  <td>
	              	<s:reset align="center" action= "ResetModification" value= "다시입력" name= "reset" 
	              		 />
	              </td>	  
	              <td>
	              	<s:submit align="center" action= "CancelModification" value= "취소" name= "cancel" 
	              		 />
                  </td>      
		        </tr>
		      </table>
		
		    </td>
		  </tr>
		</s:form>

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