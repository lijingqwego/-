$(function(){
	$("#div-decide").hide();
	$("#div-excl").hide();
	$("#select-div").change(function(){
		var obj=$("#select-div").val();
		if(obj=="1"){
			$("#div-excl").hide();
			$("#div-select").show();
		}else{
			$("#div-excl").show();
			$("#div-select").hide();
		}
	});
	$("#btn-singln").click(function(){
		var singlnName=$("#singlnName").val().trim();
		var anwerone=$("#anwerone").val().trim();
		var anwertwo=$("#anwertwo").val().trim();
		var anwerthree=$("#anwerthree").val().trim();
		var anwerfour=$("#anwerfour").val().trim();
		var singlnkey=$("#singlnkey").val().trim();
		var type=$("#select-question").val();
		var codeReg=/^[A-Za-z]{1,}$/;
		if(singlnName.length<3){
			alert("题目内容过短");
			return false;
		}
		if(anwerone.length<3){
			alert("选项一过短");
			return false;
		}
		if(anwertwo.length<3){
			alert("选项二过短");
			return false;
		}
		if(anwerthree.length<3){
			alert("选项三过短");
			return false;
		}
		if(anwerfour.length<3){
			alert("选项四过短");
			return false;
		}
		if(!codeReg.test(singlnkey)){
			alert("答案不能为空");
			return false;
		}
		
//		var parms=$("#updateform").serialize();
//		parms= decodeURIComponent(parms,true);
//		$.post("updateProduct.action?"+parms,{lse:'ss'},function(result){
//		    alert(result);
//		  },"json");
		var user = {
				questionname:singlnName,
				questiontype:type,
				answerone:anwerone,
				rightkey:singlnkey,
				answertwo:anwerone,
				answerthree:anwerthree,
				answerfour:anwerfour
	        };
	        $.ajax({
	            url:'addQuestion.action',
	            contentType : "application/json;charset=utf-8",
	            data:JSON.stringify(user),
	            type:'post',
	            success:function(msg){
	            	alert(msg);
	            	var message=msg;
	            	if(message==1){
	            		alert("添加成功");
	            	}else{
	            		alert("添加失败");
	            	}
	            	
	            }
	             
	        });
	});
	$("#select-question").change(function(){
		var obj=$("#select-question").val();
		if(obj=="1"){
			$("#div-decide").hide();
			$("#div-singln").show();
		}else{
			$("#div-singln").hide();
			$("#div-decide").show();
		}
	});
	$("#btn-decide").click(function(){
		var decideName=$("#decideName").val().trim();
		var decideKey=$("#decideKey").val().trim();
		var type=$("#select-question").val();
		if(decideName.length<3){
			alert("题目内容过短");
			return false;
		}
		if(decideKey.length<1){
			alert("答案不能为空");
			return false;
		}
		
//		var parms=$("#updateform").serialize();
//		parms= decodeURIComponent(parms,true);
//		$.post("updateProduct.action?"+parms,{lse:'ss'},function(result){
//		    alert(result);
//		  },"json");
		var user = {
				questionname:decideName,
				questiontype:type,
				rightkey:decideKey
	        };
	        $.ajax({
	            url:'addQuestion.action',
	            contentType : "application/json;charset=utf-8",
	            data:JSON.stringify(user),
	            type:'post',
	            success:function(msg){
	            	alert(msg);
	            	var message=msg;
	            	if(message==1){
	            		alert("添加成功");
	            	}else{
	            		alert("添加失败");
	            	}
	            	
	            }
	             
	        });
	});
//	$("#btn-input").click(function(){
//        var formData = new FormData();
//        formData.append("file",$("#fileexl")[0].files[0]);   
//        $.ajax({
//            url: "inputQuestions.action",
//            type: "POST",
//            data: formData,
//            cache: false,
//            /**
//            *必须false才会自动加上正确的Content-Type
//            */
//            contentType: false,
//            /**
//            * 必须false才会避开jQuery对 formdata 的默认处理
//            * XMLHttpRequest会对 formdata 进行正确的处理
//            */
//            processData: false,
//            success: function (data) {
//            	alert(data);
//            },
//            error: function () {
//                alert("上传失败！");
//            }
//        }).done(function(res) {}).fail(function(res) {});
//    });
})
