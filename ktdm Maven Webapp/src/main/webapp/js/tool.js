$(function(){
	$('#tool_add').linkbutton({    
	    iconCls: 'icon-add' ,
	    plain:true,
	});
	$('#tool_edit').linkbutton({    
	    iconCls: 'icon-edit',
	    plain:true,
	});
	$('#tool_remove').linkbutton({    
	    iconCls: 'icon-remove',
	    plain:true,
	});
	$('#tool_search').linkbutton({    
	    iconCls: 'icon-search',
	    plain:true,   
	});
	$.each($('#user_add p'),function(index,data){
		//console.log(index+","+data);
		$(data).css("margin","10px auto");
	});
	
	$("#man_tool").show();
});