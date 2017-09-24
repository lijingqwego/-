$(function(){
	$("#btn-update").click(function(){
		var subjectCode=$("#subjectCode").val().trim();
		var subjectName=$("#subjectName").val().trim();
		var classHour=$("#classHour").val().trim();
		var cycleReg=/^[0-9]*$/;
		var codeReg=/^[A-Za-z]{4,}$/;
		if(!codeReg.test(subjectCode)){
			alert("请输入4位以上的字母");
			return false;
		}
		if(subjectName.length<3){
			alert("课程名过短");
			return false;
		}
		if(!cycleReg.test(classHour)){
			alert("请输入纯数字");
			return false;
		}
//		var parms=$("#updateform").serialize();
//		parms= decodeURIComponent(parms,true);
//		$.post("updateProduct.action?"+parms,{lse:'ss'},function(result){
//		    alert(result);
//		  },"json");
		var user = {
				subjectNo:$("#subjectNo").val().trim(),
				subjectCode:subjectCode,
				subjectName:subjectName,
				classHour:classHour,
				classContent:$("#classContent").val().trim(),
				classTarget:$("#classTarget").val().trim(),
	        };
	        $.ajax({
	            url:'updateSubject.action',
	            contentType : "application/json;charset=utf-8",
	            data:JSON.stringify(user),
	            type:'post',
	            success:function(msg){
	            	var message=msg;
	            	if(message==1){
	            		alert("添加成功");
	            		self.location="showSubjects.action";
	            	}else{
	            		alert("添加失败");
	            	}
	            	
	            }
	             
	        });
	});
})