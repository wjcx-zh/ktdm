$(function(){
	$("#course_table").datagrid({
		url:"/ktdm/crs_crsInfo.action",
		fit:true,
		closeable:true,
		autoRowHeight:false,
		fitColumns:true,
		striped:true,
		rownumbers:true,
		border:false,
		pagination:true,
		pageSize:5,
		pageList:[5,10,15,20],
		pageNumber:1,
		pagePosition:'bottom',
		sortName:'cid',
		sortOrder:"desc",
		toolbar:'#crs_tool',
		showFooter:true,
		columns:[[
			{
				field:'cid',
				title:'编号',
				/*width:100,*/
				checkbox:true
			},
			{
				field:'cname',
				title:'课程名',
				width:100,
			},
			
		]],
	});
	
	initAll();
	
	tool={
		add:function(){
			//console.log($("#user_add"));
			$("#crs_add").dialog('open');
		},
		edit:function(){
			var rows=$('#course_table').datagrid('getSelections');
			if(rows.length>1){
				$.messager.alert('WARNING!','编辑记录只能选定一条数据!','warning');
			}else if(rows.length==1){
				//console.log(rows);
				$.ajax({
					url:"/ktdm/crs_crsCurrent.action",
					type:"POST",
					data:{
						id:rows[0].cid,
					},
					beforeSend:function(){
						$.messager.progress({
							text:'数据获取中....',
						});
					},
					success:function(data,response,status){
						$.messager.progress('close');
						//console.log(data);
						if(data.result){
							
							$("#crs_edit").form('load',{
								id:data.result.cid,
								name:data.result.cname,
							}).dialog('open');
						}else{
							$.messager.alert('数据获取失败!','未知错误导致失败,请重试!','warning');
						}
					}
				});
			}else{
				$.messager.alert('WARNING!','编辑记录至少选定一条数据!','warning');
			}
		},
		remove:function(){
			var rows=$("#course_table").datagrid('getSelections');
			if(rows.length>0){
				$.messager.confirm('确定操作','确定删除所选记录?',function(flag){
					if(flag){
						var ids=[];
						for(var i=0;i<rows.length;i++){
							ids.push(rows[i].cid);
						}
						
						$.ajax({
							type:'POST',
							url:'/ktdm/crs_rmCrs.action',
							data:{
								ids:ids.join(','),
							},
							beforeSend:function(){
								$("#course_table").datagrid('loading');
							},
							success:function(data){
								$("#course_table").datagrid('loaded');
								$("#course_table").datagrid('load');
								$("#course_table").datagrid('unselectAll');
								$.messager.show({
									title:'提示',
									msg:data.result+'条记录删除成功!',
								});
							},
						});
					}else{
						$("#course_table").datagrid('unselectAll');
					}
				});
			}else{
				$.messager.alert('提示','请选择要删除的记录!','info');
			}
		},
		
	}
	
})

function initAll(){
	$('#crs_tool_add').linkbutton({    
	    iconCls: 'icon-add' ,
	    plain:true,
	});
	$('#crs_tool_edit').linkbutton({    
	    iconCls: 'icon-edit',
	    plain:true,
	});
	$('#crs_tool_remove').linkbutton({    
	    iconCls: 'icon-remove',
	    plain:true,
	});
	/*$('#crs_tool_search').linkbutton({    
	    iconCls: 'icon-search',
	    plain:true,   
	});*/
	$.each($('#crs_add p'),function(index,data){
		//console.log(index+","+data);
		$(data).css("margin","10px auto");
	});
	
	$("#crs_add").dialog({
		width:360,
		title:'新增课程',
		modal:true,
		closed:true,
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			plain:true,
			handler:function(){
				if($("#crs_add").form('validate')){
					//console.log($("input[name='name']").val());
					$.ajax({
						url:'/ktdm/crs_crsAdd.action',
						type:'POST',
						data:{
							name:$("#crs_add input[name='name']").val(),
						},
						beforeSend:function(){
							$.messager.progress({
								text:'信息提交中....',
							});
						},
						success:function(data,response,status){
							$.messager.progress('close');
							//console.log(data.result+" :"+response+" :"+status);
							if(data.result>0){
								$.messager.show({
									title:'提示',
									msg:'课程已成功添加!',
								});
								
								$("#crs_add").form('reset');
								$("#crs_add").dialog('close');
								$("#course_table").datagrid('reload');
								
							}else{
								$("#crs_add").form('reset');
								$("#crs_add").dialog('close');
								$.messager.alert('操作失败!','未知错误导致失败,请重试!','warning');
							}
							
						}
					});
				}
			}
		},{
			text:'取消',
			iconCls:'icon-undo',
			plain:true,
			handler:function(){
				$("#crs_add").form('reset');
				$("#crs_add").dialog('close');
			}
		}],
	});
	
	
	$("#crs_edit").dialog({
		width:350,
		title:'信息修改',
		modal:true,
		closed:true,
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			plain:true,
			handler:function(){
				//检验
				$.ajax({
					url:"/ktdm/crs_modifyCrs.action",
					type:'POST',
					data:{
						id:$("#crs_edit input[name='id']").val(),
						name:$("#crs_edit input[name='name']").val(),
						
					},
					beforeSend:function(){
						$.messager.progress({
							text:'信息修改中....',
						});
					},
					success:function(data,response,status){
						$.messager.progress('close');
						if(data.result>0){
							$.messager.show({
								title:'提示',
								msg:'信息修改成功!',
							});
							$("#crs_edit").dialog('close').form('reset');
							$("#course_table").datagrid('reload');
						}else{
							$.messager.alert('信息修改失败!','未知错误导致失败,请重试!','warning');
						}
					}
				});
				
			}
		},{
			text:'取消',
			iconCls:'icon-undo',
			plain:true,
			handler:function(){
				$("#crs_edit").dialog('close').form('reset');
			}
		}],
	});
	
}