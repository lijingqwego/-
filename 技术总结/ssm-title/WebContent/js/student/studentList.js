$(function(){
	$("#btn-update").click(function(){
		var loginid=$("input[name='loginid']").val();
		var password=$("input[name='password']").val();
//		去除前后端空格
		loginid=$.trim(loginid);
		password=$.trim(password);
		if(loginid.length <=4){
			alert("用户账号过短请重新输入");
			return false;
		}
		if(password.length <6){
			alert("用户密码过短请重新输入");
			return false;
		}
		$("#updateform").submit();
	});
})