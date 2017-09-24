$(function(){
	$("#div-mune3").hide();
	$("#btn-insert").click(function(){
		var examinationType=$("#examinationType").val();
		var subjectNo=$("#select-mune3").val();
		if(examinationType=="2"){
			subjectNo=$("#select-mune2").val();
		}
		if(subjectNo=="-1"){
			alert("未选择科目");
			return false;
		}
		self.location="getpage.action?subjectno="+subjectNo;
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
})
