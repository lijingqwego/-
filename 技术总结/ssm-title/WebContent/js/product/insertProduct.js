$(function(){
	$("#div-add").hide();
	$("#btn-add").click(function(){
		$("#updateform")[0].reset();
		$("#div-add").show();
	});
	$("#btn-insert").click(function(){
		var lessonCode=$("#lessonCode").val().trim();
		var lessonName=$("#lessonName").val().trim();
		var lessonCycle=$("#lessonCycle").val().trim();
		var cycleReg=/^[0-9]*$/;
		var codeReg=/^[A-Za-z]{4,}$/;
		if(!codeReg.test(lessonCode)){
			alert("请输入4位以上的字母");
			return false;
		}
		if(lessonName.length<3){
			alert("课程名过短");
			return false;
		}
		if(!cycleReg.test(lessonCycle)){
			alert("请输入纯数字");
			return false;
		}
//		var parms=$("#updateform").serialize();
//		parms= decodeURIComponent(parms,true);
//		$.post("updateProduct.action?"+parms,{lse:'ss'},function(result){
//		    alert(result);
//		  },"json");
		var user = {
				lessonCode:lessonCode,
				lessonName:lessonName,
				lessonCycle:lessonCycle,
				lessonContent:$("#lessonContent").val().trim()
	        };
	        $.ajax({
	            url:'insertProduct.action',
	            contentType : "application/json;charset=utf-8",
	            data:JSON.stringify(user),
	            type:'post',
	            success:function(msg){
	            	alert(msg);
	            	var message=msg;
	            	if(message==1){
	            		alert("添加成功");
	            		$("#div-add").hide();
	            	}else{
	            		alert("添加失败");
	            	}
	            	
	            }
	             
	        });
	});
})