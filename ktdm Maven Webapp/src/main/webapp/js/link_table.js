$(function(){
	$("#sc_table").datagrid({
		url:"/ktdm/link_scInfo.action",
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
		sortName:'num',
		sortOrder:"desc",
		toolbar:'#sc_tool',
		showFooter:true,
		columns:[[
			{
				field:'linkId',
				title:'学生',
				width:100,
				checkbox:true
			},
			{
				field:'num',
				title:'学号',
				width:100,
				/*checkbox:true*/
			},
			{
				field:'cname',
				title:'课程',
				width:100,
			},
			
		]],
	});
	
	$("#tc_table").datagrid({
		url:"/ktdm/link_tcInfo.action",
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
		sortName:'num',
		sortOrder:"desc",
		toolbar:'#tc_tool',
		showFooter:true,
		columns:[[
			{
				field:'linkId',
				title:'学生',
				width:100,
				checkbox:true
			},
			{
				field:'num',
				title:'教师号',
				width:100,
				/*checkbox:true*/
			},
			{
				field:'cname',
				title:'课程',
				width:100,
			},
			
		]],
	});
	
	
	initAll_sc();
	initAll_tc();
	
	load_tool();
})

function load_tool(){
	sctool={
		add:function(){
			//console.log($("#user_add"));
			$("#sc_add").dialog('open');
		},
		edit:function(){
			var rows=$('#sc_table').datagrid('getSelections');
			if(rows.length>1){
				$.messager.alert('WARNING!','编辑记录只能选定一条数据!','warning');
			}else if(rows.length==1){
				//console.log(rows);
				$.ajax({
					url:"/ktdm/link_scCurrent.action",
					type:"POST",
					data:{
						linkId:rows[0].linkId,
						cname:rows[0].cname,
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
							
							$("#sc_edit").form('load',{
								id:data.result.linkId,
								num:data.result.num,
								cname:data.result.cname,
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
			var rows=$("#sc_table").datagrid('getSelections');
			if(rows.length>1){
				$.messager.alert('WARNING!','删除记录当前只能选定一条数据!','warning');
			}else if(rows.length==1){
				
				$.messager.confirm('确定操作','确定删除所选记录?',function(flag){
					if(flag){
				
						$.ajax({
							type:'POST',
							url:'/ktdm/link_rmSC.action',
							data:{
								linkId:rows[i].linkId,
								cname:rows[i].cname,
							},
							beforeSend:function(){
								$("#sc_table").datagrid('loading');
							},
							success:function(data){
								$("#sc_table").datagrid('loaded');
								$("#sc_table").datagrid('load');
								$("#sc_table").datagrid('unselectAll');
								$.messager.show({
									title:'提示',
									msg:'记录删除成功!',
								});
							},
						});
					}else{
						$("#sc_table").datagrid('unselectAll');
					}
				});
			}else{
				$.messager.alert('提示','请选择要删除的记录!','info');
			}
		},
		
	}
	
	tctool={
		add:function(){
			//console.log($("#user_add"));
			$("#tc_add").dialog('open');
		},
		edit:function(){
			var rows=$('#tc_table').datagrid('getSelections');
			if(rows.length>1){
				$.messager.alert('WARNING!','编辑记录只能选定一条数据!','warning');
			}else if(rows.length==1){
				//console.log(rows);
				$.ajax({
					url:"/ktdm/link_tcCurrent.action",
					type:"POST",
					data:{
						tname:rows[0].tname,
						cname:rows[0].cname,
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
							
							$("#tc_edit").form('load',{
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
			var rows=$("#tc_table").datagrid('getSelections');
			if(rows.length>0){
				$.messager.confirm('确定操作','确定删除所选记录?',function(flag){
					if(flag){
						var tnames=[];
						var cnames=[];
						for(var i=0;i<rows.length;i++){
							tnames.push(rows[i].tname);
							cnames.push(rows[i].cname);
						}
						
						$.ajax({
							type:'POST',
							url:'/ktdm/userRemove_rmSC.action',
							data:{
								tnames:tnames.join(','),
								cnames:cnames.join(','),
							},
							beforeSend:function(){
								$("#tc_table").datagrid('loading');
							},
							success:function(data){
								$("#tc_table").datagrid('loaded');
								$("#tc_table").datagrid('load');
								$("#tc_table").datagrid('unselectAll');
								$.messager.show({
									title:'提示',
									msg:data.result+'条记录删除成功!',
								});
							},
						});
					}else{
						$("#tc_table").datagrid('unselectAll');
					}
				});
			}else{
				$.messager.alert('提示','请选择要删除的记录!','info');
			}
		},
		
	}
}

function initAll_sc(){
	$('#sc_tool_add').linkbutton({    
	    iconCls: 'icon-add' ,
	    plain:true,
	});
	$('#sc_tool_edit').linkbutton({    
	    iconCls: 'icon-edit',
	    plain:true,
	});
	$('#sc_tool_remove').linkbutton({    
	    iconCls: 'icon-remove',
	    plain:true,
	});
	$('#sc_tool_search').linkbutton({    
	    iconCls: 'icon-search',
	    plain:true,   
	});
	$.each($('#sc_add p'),function(index,data){
		//console.log(index+","+data);
		$(data).css("margin","10px auto");
	});
	
	$("#sc_add").dialog({
		width:360,
		title:'新增学生选课关系',
		modal:true,
		closed:true,
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			plain:true,
			handler:function(){
				if($("#sc_add").form('validate')){
					//console.log($("input[name='name']").val());
					$.ajax({
						url:'/ktdm/link_scAdd.action',
						type:'POST',
						data:{
							linkId:$("#sc_add input[name='id']").val(),
							num:$("#sc_add input[name='num']").val(),
							cname:$("#sc_add input[name='cname']").val(),
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
									msg:'选课关系已成功添加!',
								});
								
								$("#sc_add").form('reset');
								$("#sc_add").dialog('close');
								$("#sc_table").datagrid('reload');
								
							}else{
								$("#sc_add").form('reset');
								$("#sc_add").dialog('close');
								$.messager.alert('操作失败!',data.result,'warning');
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
				$("#sc_add").form('reset');
				$("#sc_add").dialog('close');
			}
		}],
	});
	
	
	$("#sc_edit").dialog({
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
					url:"/ktdm/link_modifySC.action",
					type:'POST',
					data:{
						id:$("#sc_edit input[name='id']").val(),
						cname:$("#sc_edit input[name='cname']").val(),
						num:$("#sc_edit input[name='num']").val(),
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
							$("#sc_edit").dialog('close').form('reset');
							$("#sc_table").datagrid('reload');
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
				$("#sc_edit").dialog('close').form('reset');
			}
		}],
	});
	
	
	$("#sc_query").dialog({
		width:350,
		title:'信息查询',
		modal:true,
		closed:true,
		buttons:[{
			text:'查询',
			iconCls: 'icon-search',
		    plain:true,
			handler:function(){
				//检验
				$("#sc_table").datagrid("load",{
					name:$.trim($("#sc_query [name='name']").val()),
					from:$("#sc_query [name='from']").val(),
					to:$("#sc_query [name='to']").val(),
					sex:$.trim($("#sc_query [name='sex']").val()),
					switcher:true,
				});
				$("#sc_query").dialog('close').form('reset');
			}
		},{
			text:'取消',
			iconCls:'icon-undo',
			plain:true,
			handler:function(){
				$("#sc_query").dialog('close').form('reset');
			}
		}],
	});
}
function initAll_tc(){
	$('#tc_tool_add').linkbutton({    
	    iconCls: 'icon-add' ,
	    plain:true,
	});
	$('#tc_tool_edit').linkbutton({    
	    iconCls: 'icon-edit',
	    plain:true,
	});
	$('#tc_tool_remove').linkbutton({    
	    iconCls: 'icon-remove',
	    plain:true,
	});
	$('#tc_tool_search').linkbutton({    
	    iconCls: 'icon-search',
	    plain:true,   
	});
	$.each($('#tc_add p'),function(index,data){
		//console.log(index+","+data);
		$(data).css("margin","10px auto");
	});
	
	$("#tc_add").dialog({
		width:360,
		title:'新增课程',
		modal:true,
		closed:true,
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			plain:true,
			handler:function(){
				if($("#tc_add").form('validate')){
					//console.log($("input[name='name']").val());
					$.ajax({
						url:'/ktdm/user_tcAdd.action',
						type:'POST',
						data:{
							name:$("#tc_add input[name='name']").val(),
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
								
								$("#tc_add").form('reset');
								$("#tc_add").dialog('close');
								$("#tc_table").datagrid('reload');
								
							}else{
								$("#tc_add").form('reset');
								$("#tc_add").dialog('close');
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
				$("#tc_add").form('reset');
				$("#tc_add").dialog('close');
			}
		}],
	});
	
	
	$("#tc_edit").dialog({
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
					url:"/ktdm/modifyTC.action",
					type:'POST',
					data:{
						id:$("#tc_edit input[name='id']").val(),
						name:$("#tc_edit input[name='name']").val(),
						
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
							$("#tc_edit").dialog('close').form('reset');
							$("#tc_table").datagrid('reload');
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
				$("#tc_edit").dialog('close').form('reset');
			}
		}],
	});
	
	
	$("#tc_query").dialog({
		width:350,
		title:'信息查询',
		modal:true,
		closed:true,
		buttons:[{
			text:'查询',
			iconCls: 'icon-search',
		    plain:true,
			handler:function(){
				//检验
				$("#tc_table").datagrid("load",{
					name:$.trim($("#tc_query [name='name']").val()),
					from:$("#tc_query [name='from']").val(),
					to:$("#tc_query [name='to']").val(),
					sex:$.trim($("#tc_query [name='sex']").val()),
					switcher:true,
				});
				$("#tc_query").dialog('close').form('reset');
			}
		},{
			text:'取消',
			iconCls:'icon-undo',
			plain:true,
			handler:function(){
				$("#tc_query").dialog('close').form('reset');
			}
		}],
	});
}