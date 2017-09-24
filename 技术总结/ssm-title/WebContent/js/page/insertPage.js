$(function(){
	$("#div-mune3").hide();
	$("#btn-insert").click(function(){
		var examinationName=$("#examinationName").val().trim();
		var examinationType=$("#examinationType").val();
		var examinationContent=$("#examinationContent").val().trim();
		var subjectNo=$("#select-mune3").val();
		var examLength=$("#examLength").val();
		var singln=$("#singln").val().trim();
		var multil=$("#multil").val().trim();
		var decide=$("#decide").val().trim();
		var numReg=/^\+?[1-9][0-9]*$/;
		if(examinationName.length<3){
			alert("试卷名称过短");
			return false;
		}
		if(examinationContent.length<3){
			alert("试卷描述过短");
			return false;
		}
		if(examinationType=="2"){
			subjectNo=$("#select-mune2").val();
		}
		if(!numReg.test(singln)){
			alert("单选题个数只能输入纯数字");
			return false;
		}
		if(singln>15){
			alert("单选题过多");
			return false;
		}
		if(!numReg.test(multil)){
			alert("多选题个数只能输入纯数字");
			return false;
		}
		if(multil>10){
			alert("多选题过多");
			return false;
		}
		if(!numReg.test(decide)){
			alert("判断题个数只能输入纯数字");
			return false;
		}
		if(decide>10){
			alert("判断题过多");
			return false;
		}
		if(subjectNo=="-1"){
			alert("未选择科目");
			return false;
		}
//		var parms=$("#updateform").serialize();
//		parms= decodeURIComponent(parms,true);
//		$.post("updateProduct.action?"+parms,{lse:'ss'},function(result){
//		    alert(result);
//		  },"json");
		var user = {
				examinationName:examinationName,
				examinationType:examinationType,
				examinationContent:examinationContent,
				subjectNo:subjectNo,
				examLength:examLength,
				singln:singln,
				multil:multil,
				decide:decide
	        };
	        $.ajax({
	            url:'addPage.action',
	            contentType : "application/json;charset=utf-8",
	            data:JSON.stringify(user),
	            type:'post',
	            success:function(msg){
	            	alert(msg);
	            	var message=msg;
	            	if(message==1){
	            		alert("添加成功");
	            		self.location="showPages.action";
	            	}else{
	            		alert("添加失败");
	            	}
	            	
	            }
	             
	        });
	});
	$("#examinationType").change(function(){
		var obj=$("#examinationType").val();
		if(obj=="2"){
			$("#div-mune3").hide();
		}else{
			$("#div-mune3").show();
		}
	});
	 $("#select-mune1").change(function() {
	    	var menu=$("#select-mune1").val();
	    	var datejosn={subjectNo:menu,subjectOrder:"2"};
	        $.ajax({
				type:"post",
				url:"http://localhost:8080/ssm-title/subject/ordermenu.action",
				data:datejosn,
				success:function(data){//返回json结果
					var jsons=JSON.parse(data);
					$("#select-mune2").empty();
					var opt1 = $("<option/>").text("二级菜单").attr("value", "-1"); 
					$("#select-mune2").append(opt1);
					$.each(jsons,function(index2,value2){ // 遍历Object数组 ，每个对象的值存放在value ，index2表示为第几个对象 
						$.each(value2,function(index2,value){
						// 根据自己的逻辑进行数据的处理 
							var opt = $("<option/>").text(value.subjectName).attr("value", value.subjectNo);  
		                    $("#select-mune2").append(opt); 
					// TODO: 逻辑 
						});
					}); 
				}
				
			});   
	    });
	    $("#select-mune2").change(function() {
	    	var menu=$("#select-mune2").val();
	    	var datejosn={subjectNo:menu,subjectOrder:"3"};
	        $.ajax({
				type:"post",
				url:"http://localhost:8080/ssm-title/subject/ordermenu.action",
				data:datejosn,
				success:function(data){//返回json结果
					var jsons=JSON.parse(data);
					$("#select-mune3").empty();
					var opt1 = $("<option/>").text("三级菜单").attr("value", "-1"); 
					$("#select-mune3").append(opt1);
					$.each(jsons,function(index2,value2){ // 遍历Object数组 ，每个对象的值存放在value ，index2表示为第几个对象 
						$.each(value2,function(index2,value){
						// 根据自己的逻辑进行数据的处理 
							var opt = $("<option/>").text(value.subjectName).attr("value", value.subjectNo);  
		                    $("#select-mune3").append(opt); 
					// TODO: 逻辑 
						});
					}); 
				}
				
			});   
	    });
	    $("#singln").change(function() {
	    	var sinnum=$("#singln").val().trim();
	    	var mulnum=$("#multil").val().trim();
	    	var decnum=$("#decide").val().trim();
	    	var numReg=/^\+?[1-9][0-9]*$/;
	    	var sumnum=0;
	    	if(!numReg.test(sinnum)){
	    		return false;
	    	}
	    	if(!numReg.test(mulnum)){
	    		return false;
	    	}
	    	if(!numReg.test(decnum)){
	    		return false;
	    	}
	    	sumnum=sinnum*4+mulnum*5+decnum*2;
	    	$("#span1").html(sumnum);
	    });
		 $("#multil").change(function() {
			 var sinnum=$("#singln").val().trim();
		    	var mulnum=$("#multil").val().trim();
		    	var decnum=$("#decide").val().trim();
		    	var numReg=/^\+?[1-9][0-9]*$/;
		    	var sumnum=0;
		    	if(!numReg.test(sinnum)){
		    		return false;
		    	}
		    	if(!numReg.test(mulnum)){
		    		return false;
		    	}
		    	if(!numReg.test(decnum)){
		    		return false;
		    	}
		    	sumnum=sinnum*4+mulnum*5+decnum*2;
		    	$("#span1").html(sumnum);
			    });
		 $("#decide").change(function() {
			 var sinnum=$("#singln").val().trim();
		    	var mulnum=$("#multil").val().trim();
		    	var decnum=$("#decide").val().trim();
		    	var numReg=/^\+?[1-9][0-9]*$/;
		    	var sumnum=0;
		    	if(!numReg.test(sinnum)){
		    		return false;
		    	}
		    	if(!numReg.test(mulnum)){
		    		return false;
		    	}
		    	if(!numReg.test(decnum)){
		    		return false;
		    	}
		    	sumnum=sinnum*4+mulnum*5+decnum*2;
		    	$("#span1").html(sumnum);
		 });
})
