$(function(){
	var Expression = /^[a-zA-Z]{1}[a-zA-Z0-9_]{4,19}$/;
	var objExp = new RegExp(Expression);
	$('#btn_login').click(function(){	
		var username=$("#username").val();
		var password=$("#password").val();
		if(!objExp.test(username)){
			alert("账号格式不符合要求，请检查后重新登录");
			return false;
		}else if(!objExp.test(password)){
			alert("密码格式不符合要求，请检查后重新登录");
			return false;
		}else{
			$("#loginform").submit();
		}
	});
	$("#password").keyup(
			function(event) {
				if (event.which == "13") {
					var username=$("#username").val();
					var password=$("#password").val();
					if(!objExp.test(username)){
						alert("账号格式不符合要求，请检查后重新登录");
						return false;
					}else if(!objExp.test(password)){
						alert("密码格式不符合要求，请检查后重新登录");
						return false;
					}else{
						$("#loginform").submit();
					}
				}
			}
	)
	$('#btn_sign').click(function(){
		self.location="tosign.jsp";
	});
});