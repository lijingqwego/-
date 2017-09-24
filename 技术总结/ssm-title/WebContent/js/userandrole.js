$(function(){
    // 设置属性值
    $("#btn-relevance").click(function() {
        var roles = "";
        $("input:checkbox[name='fruit']:checked").each(function() {
            roles += $(this).val() + "+";
        });
        var jsns={roles:roles};
        $.ajax({
			type:"post",
			url:"Role/.action",
			data:jsns,
			success:function(data){//返回json结果
				window.location.href="showItems.action"; 
			}
			
		});
             
    });
})