$(function(){
    // 设置属性值
    $("#btn-relevance").click(function() {
        var authorityids = "";
        $("input:checkbox[name='roellist']:checked").each(function() {
        	authorityids += $(this).val() + "-";
        });
        var datejosn={authorityid:authorityids};
        $.ajax({
			type:"post",
			url:"relevance.action",
			data:datejosn,
			success:function(data){//返回json结果
				var floag=data;
				if(floag=="1"){
					self.location="showRoles.action";
				}else{
					alert("关联失败");
				}
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