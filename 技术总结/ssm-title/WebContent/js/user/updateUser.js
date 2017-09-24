$(function(){
	var pwdreg=/^[a-zA-Z]{1}[a-zA-Z0-9_]{4,19}$/;
	$("#btn-update").click(function(){
		var username=$("#username").val().trim();
		var loginid=$("#loginid").val().trim();
		if(!pwdreg.test(loginid)){
			alert("账号id格式不正确");
			return false;
		}
		if(username.length<2){
			alert("用户姓名请输入两个字符以上");
			return false;
		}
		$("#updateform").submit();
	});
})