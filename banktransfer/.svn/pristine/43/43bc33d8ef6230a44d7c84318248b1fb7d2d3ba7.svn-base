$(function(){
	pageObj.Init();
});
var pagesize = 2;
var pageObj={
	
	Init:function(){
		getCookie("currentuser");
		$("#kh").text(getCookie("currentuser"));
		pageObj.del();
		pageObj.findbalance();
		pageObj.Transfer();
		pageObj.Transfers();
		pageObj.findtiem();
		$("#sj").on("click","#bt",function(){
			pageObj.GetTotalData();
		});
		pageObj.pwd();
		pageObj.updatepassword();
	},
	
	del:function(){
		$("#tc").click(function(){
		if(confirm("你确定退出吗？")){
				delCookie("currentuser");
				location.href = '../htmltemplate/login.html';
			}
		});
	},
	findbalance:function(){
		$("#ye").click(function(){
			$.post("../account/accountid.php",{"id":window.localStorage.getItem("id")},function(data) {
				var jsonObj = $.ConvertJsonString(data);
				$("#gn").html("");
				var str="<div id='ss'><p>你的账户余额是：</p><p>人民币：<span id='mo'>"+jsonObj.balance+"</span></p></div>";
				$("#gn").html(str);
				$("#sj").hide();
					});
			
		});
	},
	Transfer:function(){
		$("#zz").click(function(){
			$("#gn").html("");
			var str="<div id='dd'><h4>当前操作：转账。请输入转入账号和金额后点“转账”按钮</h1><form action='' id='add_action'><table><tr><td>转入账号</td><td><input type='text' name='cardNo' id='ca'/> </td></tr><tr><td>转账金额</td><td><input type='text' name='transactionAmount' id='tr'/> </td></tr><tr><td><input type='button' value='转账' id='bu'/></td><td></tr></table></form></div>";
			$("#gn").html(str);
			$("#sj").hide();
		})
	},
	Transfers:function(){
		$("#gn").on("click","#bu",function(){
			var parm={
					"id":window.localStorage.getItem("id"),
					"cardNo":$("#ca").val(),
					"transactionAmount":$("#tr").val()
			};
			$.post("../account/accountupdate.php",parm,function(data) {
				var jsonObj = $.ConvertJsonString(data);
				if(jsonObj==2){
					$("#gn").html("");
					var str="<div id='sc'><h3>操作已成功！请继续选择其他服务</h3></div>";
					$("#gn").html(str);
				}else if(jsonObj==-1){
					alert("转账失败！目标账户不存在！");
				}else if(jsonObj==0){
					alert("转账失败！目标账户已冻结");
				}else if(jsonObj==-2){
					alert("转账失败！目标账余额不足");
				};
					});
		});
	},

	findtiem:function(){
		$("#cx").click(function(){
			$("#gn").html("");
			$("#sj").show();
			$("#on").val("");
			$("#tw").val("");
			$("#sd").html("");
			$("#div_page").html("");
		})
	},
	GetTotalData : function() {
		$.post("../transactionrecord/transactionrecordcount.php",{"cardNo":getCookie("currentuser")}, function(data) {
			var jsonObj = $.ConvertJsonString(data);
			pageObj.InitPagerControl(jsonObj);
			pageObj.LoadTable(1, pagesize);
		});
	},
	
	LoadTable:function(pageno, pagesize){
		var parm={
				"cardNo":getCookie("currentuser"),
				"begin":$("#on").val(),
				"end":$("#tw").val(),
				"pageno" : pageno,
				"pagesize" : pagesize
		};
		$.post("../transactionrecord/transactionrecordfind.php",parm,function(data) {
			var jsonObj = $.ConvertJsonString(data);
		//	if(jsonObj.length>0){
			
				var strs="<tr><td>交易日期</td><td>交易额</td><td>账户余额</td><td>交易类型</td><td>备注</td>";
				for ( var i = 0; i < jsonObj.length; i++) {
					transactionDate=jsonObj[i].transactionDate.replace("+"," ");
					strs+="</tr><tr><td>"+transactionDate+"</td><td>"+jsonObj[i].transactionAmount+"</td><td>"+jsonObj[i].balance+"</td><td>"+jsonObj[i].transactionType+"</td><td>"+jsonObj[i].remark+"</td></tr>"
				}
				
				$("#sd").html(strs)
			//}else{
			//	var strs="<p>此时间范围内没有交易记录</p>"
				//alert("此时间范围内没有交易记录")
			//	$("#ss").html(strs)
				
			//}
			
				
	});
	},

	InitPagerControl : function(total) {
		$("#div_page").hello({
			items : total,
			itemsOnPage : pagesize,
			prevText : "上一页",
			nextText : "下一页",
			cssStyle : 'light-theme',
			onPageClick : function(pageNumber, event) {
				pageObj.LoadTable(pageNumber, pagesize);
			}
		});
	},
	pwd:function(){
		$("#pw").click(function(){
			$("#gn").html("");
			var str="<div id='dd'><h4>当前操作：修改密码。请按要求填写完整后点“修改”按钮</h1><form action='' id='add_action'><table><tr><td>请输入现在的密码：</td><td><input type='password' name='jpassword' id='pa'/> </td></tr><tr><td>请输入新密码：</td><td><input type='password' name='newpassword' id='npa'/> </td></tr><tr><td>请再次输入新的密码：</td><td><input type='password' name='newspassword' id='newpa'/><tr><td><input type='button' value='修改' id='but'/></td><td></tr></table></form></div>";
			$("#gn").html(str);
			$("#sj").hide();
		})
	},
	updatepassword:function(){
		$("#gn").on("click","#but",function(){
			var parm={
					"cardNo":getCookie("currentuser"),
					"password":$("#pa").val(),
					"newspassword":$("#newpa").val()
			};
			$.post("../account/accountupdatepwd.php",parm,function(data) {
				var jsonObj = $.ConvertJsonString(data);
				if(jsonObj==1){
					$("#gn").html("");
					var str="<div><h3>操作已成功！请继续选择其他服务</h3></div>";
					$("#gn").html(str);
				}else if(jsonObj==0){
					alert("原始密码错误")
				}
					});
		});
	}
};