//var baseurl="http://localhost:8080/rentingsystem/servlet/";
/*var getCookie = function(Key) {
	var search = Key + "=";
	begin = document.cookie.indexOf(search);
	if (begin != -1) {
		begin += search.length;
		end = document.cookie.indexOf(";", begin);
		if (end == -1)
			end = document.cookie.length;

	} else {
		location.href = "../htmltemplate/login.html"
	}
}*/
var getCookie = function(name) {
	var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");

	if (arr = document.cookie.match(reg))

		return unescape(arr[2]);
	else
		location.href = "../htmltemplate/login.html";
};
var delCookie = function(key) {
	var d = new Date();
	d.setTime(d.getTime() + (-1 * 24 * 60 * 60 * 1000));
	var expires = "expires=" + d.toUTCString();
	document.cookie = key + "=; " + expires;
};
