$(function(){
	attach_courses();
    $('#img').click(function(){
    	$('#show-table').css("display","none");
    	$('#show-img').html("");
    	$(this).addClass('selected');
    	$.ajax({
    		url:"/ktdm/signImg.action",
    		type:"POST",
    		data:imgData(),
    		success:function(data){
        		//console.log(data);
        		//var rs=eval("("+data+")");
        		$('#show-img').append(data.result);
        	},
        	dataType:"json",
    	});//k.1从后台下载图片
    	$("#show-img").css('display','block');
    });
   
    $('#table').click(function(){
    	$("#show-img").css('display','none');
        $('#show-table').css("display","block");
        $(this).addClass('selected');
        $('#table').css("display","block");
        $.getJSON('StudentInfo.json',function(data){//k.2从后台获取签到的StudentInfo.json文件
            $('#show-table').empty();
           
          
            var strHTML='';
            $.each(data,function(InfoIndex,Info){
                strHTML+='学号：'+Info['num']+' '+'姓名：'+Info['name']+"<br>";
            })
            $("#show-table").html(strHTML);
        });
    })
})

function attach_courses(){
	$.ajax({
		url:"/ktdm/attachCourses.action",
		type:'POST',
		data:{
			tid:$(".jc_show_name").get(0).attributes.value.value,
		},
		success:function(data){
			console.log(data.result);
			var courses=$("#kb");
			var option=$("#kb option")[0].text;
			var dataList=[];
			dataList.push({"value":0,"text":option});
			$.each(data.result,function(index,course){
				dataList.push({"value":course.cid,"text":course.cname});
			});
			courses.combobox("loadData",dataList);
			courses.combobox("select",0);
		},
		dataType:'json',
	});
}

function imgData(){
	var cid=$("#kb").combobox("getValue");
	var cname=$("#kb").combobox("getText");
	var tid=$(".jc_show_name").get(0).attributes.value.value;
	var data={tid:tid,cid:cid,cname:cname};
	return data;
}