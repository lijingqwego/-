$(function(){
	var lengh=$("#examlenght").val()*60;
	var intDiff = parseInt(lengh);//倒计时总秒数量
	timer(intDiff);
	$("#btn-insert").click(function(){
		var num=1;
		var flast=true;
		while (flast) {
			var fromkey="sk_"+num;
			if($("input:radio[name='"+fromkey+"']").length<1){
				flast=false;
			}else{
				var s2 = $("input:radio[name='"+fromkey+"']:checked").val();
				if(s2==null){
					alert("第"+num+"尚未选择答案");
					return false;
				}else{
					num++;
				}
			}
		}
		flast=true;
		while (flast) {
			var fromkey="mk_"+num;
			if($("input:checkbox[name='"+fromkey+"']").length<1){
				flast=false;
			}else{
				var s2 = $("input:checkbox[name='"+fromkey+"']:checked").val();
				if(s2==null){
					alert("第"+num+"尚未选择答案");
					return false;
				}else{
					num++;
				}
			}
		}
		flast=true;
		while (flast) {
			var fromkey="dk_"+num;
			if($("input:radio[name='"+fromkey+"']").length<1){
				flast=false;
			}else{
				var s2 = $("input:radio[name='"+fromkey+"']:checked").val();
				if(s2==null){
					alert("第"+num+"尚未选择答案");
					return false;
				}else{
					num++;
				}
			}
		}
		$("#questionform").submit();
	});
})

function timer(intDiff){
	var s_end=setInterval(function(){
	var day=0,
		hour=0,
		minute=0,
		second=0;//时间默认值		
	if(intDiff > 0){
		hour = Math.floor(intDiff / (60 * 60)) - (day * 24);
		minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);
		second = Math.floor(intDiff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
	}
	
	if(minute==2 && second==0){
		alert("时间不足，请尽快交卷");
	}
	if(minute==0 && second==5){
		alert("时间不足，强制交卷");
		$("#questionform").submit();
		clearInterval(s_end);
	}
	if (minute <= 9) minute = '0' + minute;
	if (second <= 9) second = '0' + second;
	$('#hour_show').html('<s id="h"></s>'+hour+'时');
	$('#minute_show').html('<s></s>'+minute+'分');
	$('#second_show').html('<s></s>'+second+'秒');
	intDiff--;
	}, 1000);
} 	