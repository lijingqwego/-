$(function(){
	$("#btn-update").click(function(){
		var username=$("input[name='username']").val().trim();
		if(username.length<2){
			alert("用户姓名请输入两个字符以上");
			return false;
		}
		$("#updateform").submit();
	});
})