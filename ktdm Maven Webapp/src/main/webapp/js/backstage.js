$(function(){
	
    $('#man').click(function(){
    	//console.log($(".jc_center").get(0).dataset.options);
    	console.log($("#man a").text());
    	var title=$("#man a").text();
    	if($("#tabs").tabs('exists',title)){
    		$("#tabs").tabs('select',title);
    	}else{
    		console.log();
    		
    		$("#tabs").tabs("add",{
    			title:title,
    			closeable:true,
    			href:'/ktdm/static/manager_table.html', 
    			
    			cache:false,
    		});
    	}
    	$(this).addClass('selected');
    	//$("#tabs").load('/ktdm/static/manager_table.html');
    	
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
