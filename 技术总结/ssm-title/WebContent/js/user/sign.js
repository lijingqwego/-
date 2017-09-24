$(function(){
	$("#btn_sign").click(function(){
		var loginid=$("#userid").val().trim();
		var password=$("#password").val().trim();
		var username=$("#username").val().trim();
		var pwdreg=/^[a-zA-Z]{1}[a-zA-Z0-9_]{4,19}$/;
		if(!pwdreg.test(loginid)){
			alert("请输入格式为字母加数字且长度最少为6位的账号id");
			return false;
		}
		if(!pwdreg.test(password)){
			alert("请输入格式为字母加数字且长度最少为6位的密码");
			return false;
		}
		var datejosn={
				"loginid":loginid,
				"password":password,
				"username":username
			}
		$.ajax({
			type:"post",
			url:"user/sign.action",
			data:datejosn,
			success:function(data){//返回json结果
				var falog=data;
				if(falog=="1"){
					alert("跳转");
					self.location="login.jsp";
				}else{
					alert("注册失败");
				}
			}
			
		});   
	});
	$("#btn_check").click(function(){
		var loginid=$("#userid").val().trim();
//		去除前后端空格
		var pwdreg=/^[a-zA-Z]{1}[a-zA-Z0-9_]{4,19}$/;
		if(!pwdreg.test(loginid)){
			alert("请输入格式为字母加数字且长度最少为6位的账号");
			return false;
		}
		var datejosn={
				"loginid":loginid
			}
		$.ajax({
			type:"post",
			url:"user/check.action",
			data:datejosn,
			success:function(data){//返回json结果
				var falog=data;
				if(falog=="1"){
					alert("该账号可以注册");
				}else{
					alert("该账号已经存在");
				}
			}
			
		});   
	});
})