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