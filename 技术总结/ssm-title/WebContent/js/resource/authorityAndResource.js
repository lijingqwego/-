$(function(){
    // 设置属性值
    $("#btn-relevance").click(function() {
        var resourceId = "";
        $("input:checkbox[name='roellist']:checked").each(function() {
        	resourceId += $(this).val() + "-";
        });
        var datejosn={resourceId:resourceId};
        $.ajax({
			type:"post",
			url:"relevance.action",
			data:datejosn,
			success:function(data){//返回json结果
				alert(data);
//				重定向
//				window.localhost.href="#";
			}
			
		});   
    });
    $("#btn-norelevance").click(function() {
    	var roles = "";
        $("input:checkbox[name='roellist']:checked").each(function() {
            roles += $(this).val() + "-";
        });
        var datejosn={roles:roles};
        $.ajax({
			type:"post",
			url:"norelevance.action",
			data:datejosn,
			success:function(data){//返回json结果
//				重定向
//				window.localhost.href="#";
				alert(data);
			}
			
		});   
    });
})