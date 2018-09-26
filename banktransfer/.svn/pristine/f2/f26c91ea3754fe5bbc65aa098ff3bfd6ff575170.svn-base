$(function(){
	pageObj.Init()
})

var pageObj={
	Init:function(){
		$("#bu").click(function(){
			pageObj.Login();
		})
	},
	Login:function(){
		$.post("../account/accounts.php",$("#add_action").serialize(),function(data) {
			var jsonObj = $.ConvertJsonString(data);
		if(jsonObj!==null&&jsonObj.status==1){
			document.cookie = "currentuser="
				+ $("#ca").val();
		window.localStorage.setItem("id",jsonObj.id);
			location.href = "../htmltemplate/main.html";
		}else if(jsonObj!==null&&jsonObj.status==0){
			alert("登录失败！账户已冻结");
			//location.href = "../htmltemplate/login.html";
		}else{
			alert("登录失败！账户不存在");
			//location.href = "../htmltemplate/login.html";
		}
				});
	}
}