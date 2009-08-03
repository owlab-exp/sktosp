function popup(mylink, windowname) {
	if (!window.focus)
		return true;
	var href;
	if (typeof (mylink) == 'string')
		href = mylink;
	else
		href = mylink.href;
	window.open(href, windowname, 'width=300,height=100,scrollbars=yes');
	return false;
}

function popup2(mylink, windowname) {
	if (!window.focus)
		return true;
	var href;
	if (typeof (mylink) == 'string')
		href = mylink;
	else
		href = mylink.href;
	window.open(href, windowname, 'width=300,height=200,scrollbars=yes');
	return false;
}
/*
 * From Struts 2 in Action  
 */

var req = null;
var console = null;
var READY_STATE_UNINITIALIZED = 0;
var READY_STATE_LOADING = 1;
var READY_STATE_LOADED = 2;
var READY_STATE_INTERACTIVE = 3;
var READY_STATE_COMPLETE = 4;

function sendRequest(url, params, HttpMethod) {
	//alert('url='+url +",params="+params+",method="+HttpMethod);
	if (!HttpMethod) {
		HttpMethod = "GET";
	}
	req = initXMLHTTPRequest();

	if (req) {
		req.onreadystatechange = onReadyState;
		req.open(HttpMethod, url, true);
		req.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		req.send(params);
	} else {
		alert("Error: no req");
	}
}

//function sendRequestByXML ( url, params, HttpMethod ) {
//	// alert('url='+url +",params="+params+",method="+HttpMethod);
// if ( !HttpMethod ){
// HttpMethod="GET";
// }
// req=initXMLHTTPRequest();
//		
// if ( req ) {
// req.onreadystatechange=onReadyState;
// req.open(HttpMethod, url, true );
// req.setRequestHeader ( "Content-Type", "text/xml");
// req.send(params);
// } else {
// alert("Error: no req");
// }
// }

function initXMLHTTPRequest() {
	var xRequest = null;
	if (window.XMLHttpRequest) {
		// code for IE7+, FireFox, Chrome, Opera, Safari
		xRequest = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		// code for IE5, IE
		xRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xRequest;
}

function onReadyState() {
	var ready = req.readyState;
	var jsonObject = null;

	if (ready == READY_STATE_COMPLETE) {
		jsonObject = eval("(" + req.responseText + ")");
		toDisplay(jsonObject);
	}
}

function toDisplay(jsonObject) {
	var msg = null;
	if (console != null) {
		//alert(jsonObject.validationMessage.isValid);
		if (document.getElementById('registerTypeTxt').value == 'url') {
			if (jsonObject.validationMessage.isValid) {
				document.getElementById('previewButton').disabled = false;
				document.getElementById('gadgetUrlTxt').readyOnly = true;
				msg = "XML validation result: "
						+ jsonObject.validationMessage.message;
				msg = '<span style="color:green">'+ msg + '</span>';
			} else {
				document.getElementById('previewButton').disabled = true;
			
				msg = "XML validation result: "
						+ jsonObject.validationMessage.message;
				msg = '<span style="color:red">'+ msg + '</span>';
			}
		} else if (document.getElementById('registerTypeTxt').value == 'src') {
			if (jsonObject.validationMessage.isValid) {
				document.getElementById('previewButton').disabled = false;
				//document.getElementById('gadgetUrlTxt').readyOnly = true;
				msg = "XML validation result: "
						+ jsonObject.validationMessage.message;
				msg = '<span style="color:green">'+ msg + '</span>';
			} else {
				document.getElementById('previewButton').disabled = true;
				msg = "XML validation result: "
						+ jsonObject.validationMessage.message;
				msg = '<span style="color:red">'+ msg + '</span>';
			}
		}
		console.innerHTML = msg;
	} else {
		alert('no console definition');
	}
}

/*
 * function toFinalConsole(jsonObject){
 if (console!=null){
 removeAllChildren ( console );
 var div = document.createElement("p");
 var txt=document.createTextNode("Name: " + jsonObject.artist.firstName + " " + jsonObject.artist.lastName );
 div.appendChild ( txt );
 console.appendChild(div);

 // mess of Javascript references because we didn't mediate the JSON
	// interpretation of our maps, etc.
 var portfolios = jsonObject.artist.portfolios.entry;
 var portfolioCount = portfolios.length;
 for ( var index = 0;  index < portfolioCount; index++ ) {
 var portfolio = portfolios[index];
 txt=document.createTextNode("Portfolio Name: " + portfolio['string']  );
 div = document.createElement("p");
 div.appendChild ( txt );
 console.appendChild(div);
 }
 }
 }

 function removeAllChildren( node ){
 var childCount = node.childNodes.length;
 for ( var count = 1; count <= childCount; count++) {
 node.removeChild ( node.childNodes[0] );
 }
 }*/
function validateGadgetXML(url) {

	console = document.getElementById('validationResult');
	// alert('called');
	var gadgetRegisterType = document.getElementById('registerTypeTxt').value;
	// alert('registerType '+gadgetRegisterType);
	var gadgetUrl = null;
	var gadgetSrc = null;
	if (gadgetRegisterType == 'url') {
		gadgetUrl = document.getElementById('gadgetUrlTxt').value;
		sendRequest(url, "registerType=" + gadgetRegisterType + "&gadgetUrl="
				+ gadgetUrl, "POST");
	} else if (gadgetRegisterType == 'src') {
		gadgetSrc = document.getElementById('gadgetSrcTxt').value;
		// sendRequestByXML(url, gadgetSrc, "POST");
		sendRequest(url, "registerType=" + gadgetRegisterType + "&gadgetSrc="
				+ encodeURIComponent(gadgetSrc), "POST");
	}
}
