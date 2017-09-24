$(function(){
    // 设置属性值
    $("#btn-relevance").click(function() {
        var questionno = "";
        $("input:checkbox[name='roellist']:checked").each(function() {
        	questionno += $(this).val() + "-";
        });
        var subjectno=$("#select-mune3").val();
        if(subjectno=='-1'){
        	alert("三级菜单未选择正确的科目");
        	return false;
        }
        var subject=$("#select-mune2").val();
        if(subject=='-1'){
        	alert("二级菜单未选择正确的科目");
        	return false;
        }
        var questionsname=$("#questionsname").val().trim();
        var questionsdesc=$("#questionsdesc").val().trim();
        var datejosn={
        		questionno:questionno,
        		subjectno:subjectno,
        		subjecttwo:subject,
        		questionsname:questionsname,
        		questionsdesc:questionsdesc
        		};
        $.ajax({
			type:"post",
			url:"toRelation.action",
			data:datejosn,
			success:function(data){//返回json结果
				var floag=data;
				alert(floag);
				if(floag=="1"){
					self.location="relation.action";
				}else{
					alert("关联失败");
				}
			}
			
		});   
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