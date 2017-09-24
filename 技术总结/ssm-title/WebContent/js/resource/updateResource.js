$(function(){
	$("#btn-update").click(function(){
		var resourceName=$("input[name='resourceName']").val();
//		去除前后端空格
		resourceName=$.trim(resourceName);
		if(resourceName.length <4){
			alert("用户账号过短请重新输入");
			return false;
		}
		$("#updateform").submit();
	});
})