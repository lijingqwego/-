$(function(){
	$("#btn_change").click(function(){
		var oldpassword=$("#oldpwd").val().trim();
		var newpassword=$("#newpwd").val().trim();
		var newpassword1=$("#newpwd1").val().trim();
//		去除前后端空格
		var pwdreg=/^[a-zA-Z]{1}[a-zA-Z0-9_]{4,19}$/;
		if(!pwdreg.test(oldpassword)){
			alert("原密码格式不对");
			return false;
		}
		if(!pwdreg.test(newpassword)){
			alert("新密码格式不对");
			return false;
		}
		if(newpassword != newpassword1){
			alert("两个密码不相同，请重新输入");
			return false;
		}
		var datejosn={
				"oldpassword":oldpassword,
				"newpassword":newpassword
			}
		$.ajax({
			type:"post",
			url:"changePassword.action",
			data:datejosn,
			success:function(data){//返回json结果
				var falog=data;
				if(falog=="1"){
					alert("更新密码成功");
					self.location="ssm-title/loginOut.action";
				}else if(falog=="0"){
					alert("更新密码失败");
				}else{
					alert("原密码错误");
				}
			}
			
		});   
	});
})