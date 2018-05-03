$(function(){
	attach_courses();
    $('#img').click(function(){
    	//alert($("#kb").combobox("getValue"));
    	if($("#kb").combobox("getValue")==0){
    		alert("请选择课程!");
    		return false;
    	}
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
        $.ajax({//k.2从后台获取签到信息
        	url:"/ktdm/signupInfo.action",
        	type:"POST",
        	data:'',
        	success:function(data){
        		$('#show-table').empty();
        		console.log(data.result);
	    		var table=$("<table style='width:800px'>").append($("<tr>").append($("<th >学号</th>"))
    					.append($("<th >姓名</th>")).append($("<th >课程</th>"))
    					.append($("<th >教师</th>")).append($("<th >签到时间</th>"))
    					.append($("<th >类别</th>")));
	    		
	    		$.each(data.result,function(index,info){
	    			console.log(info +" "+index);
	    			fullfilling(index,info,table);
	    			
	    		});
	    		$("#show-table").append(table);
        	},      
        });
    })
})

function fullfilling(index,info,table){
	var tr=$("<tr>");
	tr.append($("<td >").html(info.snum)).append($("<td >").html(info.sname))
	  .append($("<td >").html(info.cname)).append($("<td >").html(info.tname))
	  .append($("<td >").html(info.signtime)).append($("<td >").html(info.type.type));
	table.append(tr)
}
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

function clear_table_data(){
	$.ajax({
		url:"/ktdm/clearData.action",
		type:'POST',
		data:{
			
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