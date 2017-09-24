$(function(){
	$("#btn-update").click(function(){
		var loginid=$("input[name='loginid']").val().trim();
		var password=$("input[name='password']").val().trim();
		var loginreg=/^[A-Za-z0-9]{6,}$/;
		if(!loginreg.test(loginid)){
			alert("账号过短请输入6位");
			return false;
		}
		var passwordreg=/^[a-zA-Z]\w{5,17}$/;
		if(!passwordreg.test(password)){
			alert("密码不符合规则");
			return false;
		}
		$("#updateform").submit();
	});
})