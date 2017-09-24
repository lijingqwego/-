$(function(){
	$("#btn-update").click(function(){
		var rolename=$("input[name='rolename']").val().trim();
		var descn=$("input[name='descn']").val().trim();
		if(rolename.length <=2){
			alert("角色名称过短请重新输入");
			return false;
		}
		if(descn.length <=2){
			alert("角色简介过短请重新输入");
			return false;
		}
		$("#updateform").submit();
	});
})