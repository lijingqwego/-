$(function(){
	$("#btn-update").click(function(){
		var authorityname=$("input[name='authorityname']").val().trim();
		var descn=$("input[name='descn']").val().trim();
		if(authorityname.length <4){
			alert("权限名过短请重新输入");
			return false;
		}
		if(descn.length <4){
			alert("权限简介过短请重新输入");
			return false;
		}
		$("#updateform").submit();
	});
})