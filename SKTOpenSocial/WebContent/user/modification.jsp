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
        <tbody>
	        <tr>
	          <td>            
	            <div class="subject subject_char"> 
	            <ul class="subject_sub">
	            <li>홈</li>
	            <li>사용자메뉴</li>
	            <li><strong>개인정보수정</strong></li> 
	            </ul>
	            </div>
	          </td>
	        </tr>
        
	        <tr>
	          <td width='100%' align='center' height='10'></td>
	        </tr>

      		<tr>
				<td><!-- list of gadgets -->
      				<table cellpadding="0" cellspacing="0" width="100%" border='0' >
      				<colgroup>
						<col width="20%">
						<col width="70%">
						<col width="10%">
					</colgroup>
					
					<tbody>
						<s:form action="ModificationSubmit" namespace="/user" 
							id="UserRegistrationForm" theme="simple" method="post" enctype="multipart/form-data">
														        				
		  					<tr>
								<td>*사용자아이디</td>
								<td>
									<s:property value="%{userId}" />										
									
								</td>
							</tr>
							
							<tr>
								<td>*암호</td>
								<td>
									<s:password name= "passwordWant" required="true" />										
								</td>
							</tr>

							<tr>
								<td>*암호확인</td>
								<td>
									<s:password name= "passwordConfirm" required="true" />										
								</td>
							</tr>
							
							<tr>
								<td>*사용자이름</td>
								<td>
									<s:textfield name= "userName" required="true" value="%{userName}"/>										
								</td>
							</tr>
			  		      
			  		      ` <tr>
								<td>나이</td>
								<td>
									<s:textfield name= "age" required="false" value="%{age}"/> 										
								</td>
							</tr>
							
							<tr>
								<td>성별</td>
								<td>
									<s:select label="성별" name="gender" headerKey="1" headerValue="-- 선택하세요 --" list="#{'male':'남성','female':'여성'}" value="%{gender}"/>  										
								</td>
							</tr>
							
							<tr>
								<td>생일</td>
								<td>
									<s:textfield name= "birthday" required="false" value="%{birthday}"/>   
								</td>
							</tr>
							
							<tr>
								<td>*이메일</td>
								<td>
									<s:textfield name= "email" required="true" value="%{email}"/> 
								</td>
							</tr>
						      		
						    <tr>
								<td>추가이메일</td>
								<td>
									<s:textfield name= "email2" required="false" value="%{email2}"/> 
								</td>
							</tr>
							
							<tr>
								<td>주소</td>
								<td>
									<s:textfield name= "address" required="false" value="%{address}"/> 
								</td>
							</tr>
				
		      				<tr>
								<td>추가주소</td>
								<td>
							      	<s:textfield name= "address2" required="false" value="%{address2}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>학교</td>
								<td>
								   	<s:textfield label= "학교" name= "school" required="false" value="%{school}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>추가학교</td>
								<td>
							    	
						          	<s:textfield label= "추가학교" name= "school2" required="false" value="%{school2}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>직업</td>
								<td>
							    
						      		      
						          	<s:textfield label= "직업" name= "job" required="false" value="%{job}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>추가직업</td>
								<td>
							    
						          	<s:textfield label= "추가직업" name= "job2" required="false" value="%{job2}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>난?</td>
								<td>
							    
							  
						          	<s:textarea label= "난?" name= "aboutMe" required="false" value="%{aboutMe}!"/> 
						       		      
						     	</td>
							</tr>
							
							<tr>
								<td>체격</td>
								<td>
							    
							  
						          	<s:textfield label= "체격" name= "bodytypeBuild" required="false" value="%{bodytypeBuild}"/> 
						       		      
						     	</td>
							</tr>
							
							<tr>
								<td>눈동자색상</td>
								<td>
							 
						          	<s:textfield label= "눈동자색상" name= "bodytypeEyecolor" required="false" value="%{bodytypeEyecolor}"/> 
						     	</td>
							</tr>
							
							<tr>
								<td>머리색상</td>
								<td>
							   
						     
						          	<s:textfield label= "머리색상" name= "bodytypeHaircolor" required="false" value="%{bodytypeHaircolor}"/> 
						     	</td>
							</tr>
							
							<tr>
								<td>키</td>
								<td>
							   
						      
						      
						          	<s:textfield label= "키" name= "bodytypeHeight" required="false" value="%{bodytypeHeight}"/> 
						     	</td>
							</tr>
							
							<tr>
								<td>몸무게</td>
								<td>
							   
						     
						          	<s:textfield label= "몸무게" name= "bodytypeWeight" required="false" value="%{bodytypeWeight}"/> 
						     	</td>
							</tr>
							
							<tr>
								<td>좋아하는 책</td>
								<td>
							  		      
						      
						          	<s:textfield label= "좋아하는 책" name= "book" required="false" value="%{book}"/> 
						       
						     	</td>
							</tr>
							
							<tr>
								<td>좋아하는 책 추가</td>
								<td>
							 
						     
						          	<s:textfield label= "좋아하는 책 추가" name= "book2" required="false" value="%{book2}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>좋아하는 자동차</td>
								<td>
							        
						      
						          	<s:textfield label= "좋아하는 자동차" name= "car" required="false" value="%{car}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>좋아하는 자동차추가</td>
								<td>
							  
						          	<s:textfield label= "좋아하는 자동차추가" name= "car2" required="false" value="%{car2}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>자녀</td>
								<td>
							   
						          	<s:textfield label= "자녀" name= "children" required="false" value="%{children}"/> 
						    	</td>
							</tr>
							
							
							<tr>
								<td>현재위치</td>
								<td>
							   
						          	<s:textfield label= "현재위치" name= "currentLocation" required="false" value="%{currentLocation}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>음주</td>
								<td>
							    
						       		<s:select label="음주" name="drinker" headerKey="1" headerValue="-- 선택하세요 --" 
						       		list="#{'HEAVILY':'HEAVILY'
						       				,'NO':'NO'
						       				,'OCCASIONALLY':'OCCASIONALLY'
						       				,'QUIT':'QUIT'
						       				,'QUITTING':'QUITTING'
						       				,'REGULARLY':'REGULARLY'
						       				,'SOCIALLY':'SOCIALLY'
						       				,'YES':'YES'
						       				}"
						       				value="%{drinker}"/> 
						       				
					   	     	</td>
							</tr>
							
							<tr>
								<td>민족</td>
								<td>
							   
						          	<s:textfield label="민족" name="ethnicity" required="false" value="%{ethnicity}"/> 
						     	</td>
							</tr>
							
							<tr>
								<td>패션</td>
								<td>
							   
						          	<s:textfield label="패션" name="fashion" required="false" value="%{fashion}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>좋아하는음식</td>
								<td>
							    
						          	<s:textfield label="좋아하는음식" name="food" required="false" value="%{food}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>좋아하는음식추가</td>
								<td>
							    
						          	<s:textfield label="좋아하는음식추가" name="food2" required="false" value="%{food2}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>행복한때</td>
								<td>
							    
						          	<s:textfield label="행복한때" name="happiestWhen" required="false" value="%{happiestWhen}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>좋아하는영웅</td>
								<td>
							   
						          	<s:textfield label="좋아하는영웅" name="hero" required="false" value="%{hero}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>좋아하는영웅추가</td>
								<td>
							    
						          	<s:textfield label="좋아하는영웅추가" name="hero2" required="false" value="%{hero2}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>유머에대한생각</td>
								<td>
							    
						          	<s:textfield label="유머에대한생각" name="humor" required="false" value="%{humor}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>취미,특기</td>
								<td>
							    
						          	<s:textfield label="취미,특기" name="interest" required="false" value="%{interest}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>취미,특기추가</td>
								<td>
							    
						          	<s:textfield label="취미,특기추가" name="interest2" required="false" value="%{interest2}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>관심직업</td>
								<td>
							    
						          	<s:textfield label="관심직업" name="jobInterest" required="false" value="%{jobInterest}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>관심직업추가</td>
								<td>
							    
						          	<s:textfield label="관심직업추가" name="jobInterest2" required="false" value="%{jobInterest2}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>사용언어</td>
								<td>
							    
						          	<s:textfield label="사용언어" name="languageSpoken" required="false" value="%{languageSpoken}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>사용언어추가</td>
								<td>
							    
						          	<s:textfield label="사용언어추가" name="languageSpoken2" required="false" value="%{languageSpoken2}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>주거형태</td>
								<td>
							    
						          	<s:textfield label="주거형태" name="livingArrangement" required="false" value="%{livingArrangement}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>관심분야</td>
								<td>
							    
						       		<s:select label="관심분야" name="lookingFor" headerKey="1" headerValue="-- 선택하세요 --" 
						       		list="#{'ACTIVITY_PARTNERS':'ACTIVITY_PARTNERS'
						       				,'DATING':'DATING'
						       				,'FRIENDS':'FRIENDS'
						       				,'NETWORKING':'NETWORKING'
						       				,'RANDOM':'RANDOM'
						       				,'RELATIONSHIP':'RELATIONSHIP'
						       				}"/> 
					   	    	</td>
							</tr>
							
							<tr>
								<td>좋아하는영화</td>
								<td>
							    
						          	<s:textfield label="좋아하는영화" name="movie" required="false" value="%{movie}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>영화추가</td>
								<td>
							    
						          	<s:textfield label="영화추가" name="movie2" required="false" value="%{movie2}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>좋아하는음악</td>
								<td>
							    
						          	<s:textfield label="좋아하는음악" name="music" required="false" value="%{music}"/> 
						   	</td>
							</tr>
							
							<tr>
								<td>음악추가</td>
								<td>
							     
						          	<s:textfield label="음악추가" name="music2" required="false" value="%{music2}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>추가이름</td>
								<td>
							   
						          	<s:textfield label="추가이름" name="additionalName" required="false" value="%{additionalName}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>성</td>
								<td>
							    
						          	<s:textfield label="성" name="familyName" required="false" value="%{familyName}"/> 
						   	</td>
							</tr>
							
							<tr>
								<td>이름</td>
								<td>
							     
						          	<s:textfield label="이름" name="givenName" required="false" value="%{givenName}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>호</td>
								<td>
							    
						          	<s:textfield label="호" name="honorificPrefix" required="false" value="%{honorificPrefix}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>접미호</td>
								<td>
							    
						          	<s:textfield label="접미호" name="honorificSuffix" required="false" value="%{honorificSuffix}"/> 
						    	</td>
							</tr>
							
							
							<tr>
								<td>네트워크환경</td>
								<td>
							    
						       		<s:select label="네트워크환경" name="networkPresence" headerKey="1" headerValue="-- 선택하세요 --" 
						       		list="#{'AWAY':'AWAY'
						       				,'CHAT':'CHAT'
						       				,'DND':'DND'
						       				,'OFFLINE':'OFFLINE'
						       				,'ONLINE':'ONLINE'
						       				,'XA':'XA'
						       				}"
						       				value="%{networkPresence}"/> 
					   	    	</td>
							</tr>
							
							<tr>
								<td>별명</td>
								<td>
							    
						          	<s:textfield label="별명" name="nickname" required="false" value="%{nickname}"/> 
						   	</td>
							</tr>
							
							<tr>
								<td>애완동물</td>
								<td>
							    
						          	<s:textfield label="애완동물" name="pets" required="false" value="%{pets}"/> 
						    	</td>
							</tr>
							
							
							<tr>
								<td>전화번호</td>
								<td>
							    
						          	<s:textfield label="전화번호" name="phoneNumber" required="false" value="%{phoneNumber}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>전화번호종류</td>
								<td>
							    
						          	<s:textfield label="전화번호종류" name="phoneType" required="false" value="%{phoneType}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>추가전화번호</td>
								<td>
							    
						          	<s:textfield label="추가전화번호" name="phoneNumber2" required="false" value="%{phoneNumber2}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>추가전화번호종류</td>
								<td>
							    
						          	<s:textfield label="추가전화번호종류" name="phoneType2" required="false" value="%{phoneType2}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>정치적관점</td>
								<td>
							    
						          	<s:textfield label="정치적관점" name="politicalViews" required="false" value="%{politicalViews}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>프로파일송위치</td>
								<td>
							    
						          	<s:textfield label="프로파일송위치" name="profilesongUrlAddress" required="false" value="%{profilesongUrlAddress}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>프로파일송내용</td>
								<td>
							   
						          	<s:textfield label="프로파일송내용" name="profilesongUrlLinktext" required="false" value="%{profilesongUrlLinktext}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>프로파일송위치종류</td>
								<td>
							    
						          	<s:textfield label="프로파일송위치종류" name="profilesongUrlType" required="false" value="%{profilesongUrlType}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>프로파일위치</td>
								<td>
							    
						          	<s:textfield label="프로파일위치" name="profileUrlAddress" required="false" value="%{profileUrlAddress}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>프로파일내용</td>
								<td>
							    
						          	<s:textfield label="프로파일내용" name="profileUrlLinktext" required="false" value="%{profileUrlLinktext}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>프로파일위치종류</td>
								<td>
							    
						          	<s:textfield label="프로파일위치종류" name="profileUrlType" required="false" value="%{profileUrlType}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>프로파일비디오위치</td>
								<td>
							    
						          	<s:textfield label="프로파일비디오위치" name="profilevideoUrlAddress" required="false" value="%{profilevideoUrlAddress}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>프로파일비디오내용</td>
								<td>
							    
						          	<s:textfield label="프로파일비디오내용" name="profilevideoUrlLinktext" required="false" value="%{profilevideoUrlLinktext}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>프로파일비디오위치종류</td>
								<td>
							    
						          	<s:textfield label="프로파일비디오위치종류" name="profilevideoUrlType" required="false" value="%{profilevideoUrlType}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>좋아하는인용문</td>
								<td>
							    
						          	<s:textfield label="좋아하는인용문" name="quote" required="false" value="%{quote}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>인용문추가</td>
								<td>
							    
						          	<s:textfield label="인용문추가" name="quote2" required="false" value="%{quote2}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>관계상태</td>
								<td>
							   
						          	<s:textfield label="관계상태" name="relationshipStatus" required="false" value="%{relationshipStatus}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>종교</td>
								<td>
							    
						          	<s:textfield label="종교" name="religion" required="false" value="%{religion}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>로맨스에대한</td>
								<td>
							    
						          	<s:textfield label="로맨스에대한" name="romance" required="false" value="%{romance}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>무서운것</td>
								<td>
							    
						          	<s:textfield label="무서운것" name="scaredOf" required="false" value="%{scaredOf}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>성적방향</td>
								<td>
							    
						          	<s:textfield label="성적방향" name="sexualOrientation" required="false" value="%{sexualOrientation}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>흡연</td>
								<td>
							    
						       		<s:select label="흡연" name="smoker" headerKey="1" headerValue="-- 선택하세요 --" 
						       		list="#{'HEAVILY':'HEAVILY'
						       				,'NO':'NO'
						       				,'OCCASIONALLY':'OCCASIONALLY'
						       				,'QUIT':'QUIT'
						       				,'QUITTING':'QUITTING'
						       				,'REGULARLY':'REGULARLY'
						       				,'SOCIALLY':'SOCIALLY'
						       				,'YES':'YES'
						       				}"
						       				value="%{smoker}"/> 
					   	     	</td>
							</tr>
							
							<tr>
								<td>좋아하는스포츠</td>
								<td>
							   
						          	<s:textfield label="좋아하는스포츠" name="sport" required="false" value="%{sport}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>스포츠추가</td>
								<td>
							    
						          	<s:textfield label="스포츠추가" name="sport2" required="false" value="%{sport2}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>상태</td>
								<td>
							    
						          	<s:textfield label="상태" name="status" required="false" value="%{status}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>태그</td>
								<td>
							    
						          	<s:textfield label="태그" name="tag" required="false" value="%{tag}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>태그추가</td>
								<td>
							    
						          	<s:textfield label="태그추가" name="tag2" required="false" value="%{tag2}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>이미지위치</td>
								<td>
							    
						          	<s:textfield label="이미지위치" name="thumbnailUrlAddress" required="false" value="%{thumbnailUrlAddress}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>이미지내용</td>
								<td>
							    
						          	<s:textfield label="이미지내용" name="thumbnailUrlLinktext" required="false" value="%{thumbnailUrlLinktext}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>이미지위치종류</td>
								<td>
							    
						          	<s:textfield label="이미지위치종류" name="thumbnailUrlType" required="false" value="%{thumbnailUrlType}"/> 
						    	</td>
							</tr>
							
							
							<tr>
								<td>turnOff</td>
								<td>
							   
						          	<s:textfield label="turnOff" name="turnOff" required="false" value="%{turnOff}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>turnOff추가</td>
								<td>
							    
						          	<s:textfield label="turnOff추가" name="turnOff2" required="false" value="%{turnOff2}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>turnOn</td>
								<td>
							    
						          	<s:textfield label="turnOn" name="turnOn" required="false" value="%{turnOn}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>turnOn추가</td>
								<td>
							    
						          	<s:textfield label="turnOn추가" name="turnOn2" required="false" value="%{turnOn2}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>tvShow</td>
								<td>
							    
						          	<s:textfield label="tvShow" name="tvShow" required="false" value="%{tvShow}"/> 
						    	</td>
							</tr>
							
							<tr>
								<td>tvShow추가</td>
								<td>
							    
						          	<s:textfield label="tvShow추가" name="tvShow2" required="false" value="%{tvShow2}"/> 
						    	</td>
							</tr>
							<tr>
							    <td>
							   		<s:submit align="center" action= "ModificationSubmit" 
							   			value= "개인정보수정" name= "ModificationSubmit"/>
						        </td>
						        <td>
						        	<s:submit align="center" action= "ResetModification" 
						        		value= "다시입력" name= "ResetModification"/>
						        </td>	  
						        <td>
						        	<s:submit align="center" action= "CancelModification" 
						        		value= "취소" name= "CancelModification"/>
					            </td>      
							</tr>

						</s:form>
					</tbody>
					</table>
				</td>
			</tr>
		</tbody>
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