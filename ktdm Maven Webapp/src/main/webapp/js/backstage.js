$(function(){
	$("#tabs").tabs({
		fit:true,
		border:false,
		closeable:true,
	});
    $('#man').click(function(){
    	//console.log($(".jc_center").get(0).dataset.options);
    	console.log($("#man a").text());
    	var title=$("#man a").text();
    	if($("#tabs").tabs('exists',title)){
    		$("#tabs").tabs('select',title);
    	}else{
    		$("#tabs").tabs("add",{
    			title:title,
    			closeable:true,
    			href:'/ktdm/static_view/manager_table.html', 
    			
    			cache:false,
    		});
    	}
    	
    	$(this).addClass('selected');
    	//$("#tabs").load('/ktdm/static/manager_table.html');
    	/*$.parser.parse("#man_tool");
    	$.parser.parse();*/
    });
    $('#stu').click(function(){
    	//console.log($("#stu a").text());
    	var title=$("#stu a").text();
    	if($("#tabs").tabs('exists',title)){
    		$("#tabs").tabs('select',title);
    	}else{
    		
    		$("#tabs").tabs("add",{
    			title:title,
    			
    			href:'/ktdm/static_view/stu_table.html', 
    			closeable:true,
    			cache:false,
    		});
    	}
    	
    	$(this).addClass('selected');
    });
   
    $('#thr').click(function(){
    	//console.log($(".jc_center").get(0).dataset.options);
    	console.log($("#thr a").text());
    	var title=$("#thr a").text();
    	if($("#tabs").tabs('exists',title)){
    		$("#tabs").tabs('select',title);
    	}else{
    		$("#tabs").tabs("add",{
    			title:title,
    			closeable:true,
    			href:'/ktdm/static_view/thr_table.html', 
    			
    			cache:false,
    		});
    	}
    	
    	/*$(this).addClass('selected');*/
    });
   
    $('#cus').click(function(){
    	//console.log($(".jc_center").get(0).dataset.options);
    	console.log($("#cus a").text());
    	var title=$("#cus a").text();
    	if($("#tabs").tabs('exists',title)){
    		$("#tabs").tabs('select',title);
    	}else{
    		
    		$("#tabs").tabs("add",{
    			title:title,
    			closeable:true,
    			href:'/ktdm/static_view/course_table.html', 
    			
    			cache:false,
    		});
    	}
    	
    	$(this).addClass('selected');
    });
    
    $('#time').click(function(){
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
    			href:'/ktdm/static_view/manager_table.html', 
    			
    			cache:false,
    		});
    	}
    	
    	$(this).addClass('selected');
    	//$("#tabs").load('/ktdm/static/manager_table.html');
    	/*$.parser.parse("#man_tool");
    	$.parser.parse();*/
    });
    $('#link').click(function(){
    	var title=$("#link a").text();
    	if($("#tabs").tabs('exists',title)){
    		$("#tabs").tabs('select',title);
    	}else{
    		
    		$("#tabs").tabs("add",{
    			title:title,
    			closeable:true,
    			href:'/ktdm/static_view/link_table.html', 
    			
    			cache:false,
    		});
    	}
    	
    	/*$(this).addClass('selected');*/
    });
})
