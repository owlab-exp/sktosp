function confirmbox(msg, url) {
	var answer = confirm(msg);
	if (answer){
		location.href = url;
	}
	return true;
}

function form_chk()
{
	var myemail;
	var mypass;

	var falsepass = false;
	var cnt=0;
	myemail = document.login.email.value;
	mypass = document.login.passwd.value;

	var tempStr = "";
	for (var i = 0 ; i < myemail.length; i++) {
			 if (myemail.charAt(i) != " ") tempStr += myemail.charAt(i);
	}
	myemail = tempStr;

	document.login.email.value = tempStr;
	if (myemail == "") {
		 alert('아이디를 입력하세요!');
		 document.login.email.focus();
		 return false;
	}

	else if (mypass.split(" ").join("")=="") {
		alert('비밀번호를 입력하세요!');
		document.login.passwd.focus();
		return false;
	}


	if (myemail.substring(0,myemail.indexOf('@')) == mypass) falsepass = true;
	else if (mypass.length < 5) falsepass = true;
	else{
		for ( var i=0; i < mypass.length; ++i) {
			if ( mypass.charAt(0) == mypass.substring( i, i+1 ) ) ++cnt;
		}

		if( cnt == mypass.length ) {
			falsepass = true;
		}
	}

  return true;

}

