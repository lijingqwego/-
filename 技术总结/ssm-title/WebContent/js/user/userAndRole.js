$(function(){
    // 设置属性值
    $("#btn-relevance").click(function() {
        var roles =$("input:radio[name='roellist']:checked").val();
        if(roles==""){
        	alert("请选择一个角色");
        	return false;
        }
        var datejosn={roles:roles};
        $.ajax({
			type:"post",
			url:"relevance.action",
			data:datejosn,
			success:function(data){//返回json结果
				var floag=data;
				if(floag=="1"){
					self.location="showAccounts.action";
				}else{
					alert("关联失败");
				}
			}
			
		});   
    });
})