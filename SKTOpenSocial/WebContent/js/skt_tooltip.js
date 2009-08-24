// http://www.walterzorn.com
function MyTip(text) {
	// for balloon help
	Tip(text,  SHADOW, true, BALLOON, true, ABOVE, true, DURATION, 2000);
	//Tip(text,  SHADOW, true, ABOVE, true, DURATION, 2000);
}
function MyTipBox(text) {
	//Tip(text,  SHADOW, true, BALLOON, true, ABOVE, true, DURATION, 2000);
	Tip(text,  SHADOW, true, ABOVE, true, DURATION, 2000);
}

function MyUnTip() {
	UnTip();
}