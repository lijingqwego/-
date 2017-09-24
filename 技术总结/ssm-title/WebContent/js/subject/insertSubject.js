$(function(){
	$("#div2").hide();
	$("#div3").hide();
	$("#btn-insert").click(function(){
		var fatherSubject="";
		var subjectCode=$("#subjectCode").val().trim();
		var subjectName=$("#subjectName").val().trim();
		var classHour=$("#classHour").val().trim();
		var subjectOrder=$("#subjectOrder").val();
		var cycleReg=/^[0-9]*$/;
		var codeReg=/^[A-Za-z]{4,}$/;
		var fatherReg=/^[A-Za-z]+$/;
		if(!codeReg.test(subjectCode)){
			alert("科目编号请输入4位以上的字母");
			return false;
		}
		if(subjectName.length<3){
			alert("课程名过短");
			return false;
		}
		if(!cycleReg.test(classHour)){
			alert("课时请输入纯数字");
			return false;
		}
    	if(subjectOrder=="1"){
    		fatherSubject="0";
    	}else if(subjectOrder=="2"){
    		fatherSubject=$("#select-mune2").val();
    	}else{
    		fatherSubject=$("#select-mune3").val();
    	}
		if(fatherSubject=="-1"){
			alert("请选择父级科目");
			return false;
		}
//		var parms=$("#updateform").serialize();
//		parms= decodeURIComponent(parms,true);
//		$.post("updateProduct.action?"+parms,{lse:'ss'},function(result){
//		    alert(result);
//		  },"json");
		var user = {
				subjectCode:subjectCode,
				subjectName:subjectName,
				classHour:classHour,
				fatherSubject:fatherSubject,
				subjectOrder:subjectOrder,
				classContent:$("#classContent").val().trim(),
				classTarget:$("#classTarget").val().trim(),
	        };
	        $.ajax({
	            url:'insertSubject.action',
	            contentType : "application/json;charset=utf-8",
	            data:JSON.stringify(user),
	            type:'post',
	            success:function(msg){
	            	alert(msg);
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
	 $("#subjectOrder").change(function() {
	    	var menu=$("#subjectOrder").val();
	    	if(menu=="1"){
	    		$("#div2").hide();
	    		$("#div3").hide();
	    	}else if(menu=="2"){
	    		$("#div2").show();
	    		$("#div3").hide();
	    	}else{
	    		$("#div2").show();
	    		$("#div3").show();
	    	}
	    });
	$("#select-mune1").change(function() {
    	var menu=$("#select-mune1").val();
    	var datejosn={subjectNo:menu,subjectOrder:"1"};
        $.ajax({
			type:"post",
			url:"http://localhost:8080/ssm-title/subject/ordermenu.action",
			data:datejosn,
			success:function(data){//返回json结果
				var jsons=JSON.parse(data);
				$("#select-mune2").empty();
				var opt1 = $("<option/>").text("一级菜单").attr("value", "-1"); 
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
    	var datejosn={subjectNo:menu,subjectOrder:"2"};
        $.ajax({
			type:"post",
			url:"http://localhost:8080/ssm-title/subject/ordermenu.action",
			data:datejosn,
			success:function(data){//返回json结果
				var jsons=JSON.parse(data);
				$("#select-mune3").empty();
				var opt1 = $("<option/>").text("二级菜单").attr("value", "-1"); 
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
})