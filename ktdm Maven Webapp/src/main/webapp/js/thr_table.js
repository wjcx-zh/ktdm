$(function(){
	
	$("#thr_table").datagrid({
		url:"/ktdm/userInfo_thrInfo.action",
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
		sortName:'uid',
		sortOrder:"desc",
		toolbar:'#thr_tool',
		showFooter:true,
		columns:[[
			{
				field:'uid',
				title:'编号',
				/*width:100,*/
				checkbox:true
			},
			{
				field:'uname',
				title:'教师姓名',
				width:100,
			},
			{
				field:'sex',
				title:'性别',
				width:100,
			},
			{
				field:'age',
				title:'年龄',
				width:100,
			},
			
		]],
	});
	
	initAll_thr();
	
	tool={
		add:function(){
			//console.log($("#user_add"));
			$("#thr_add").form().dialog('open');
		},
		edit:function(){
			var rows=$('#thr_table').datagrid('getSelections');
			if(rows.length>1){
				$.messager.alert('WARNING!','编辑记录只能选定一条数据!','warning');
			}else if(rows.length==1){
				//console.log(rows);
				$.ajax({
					url:"/ktdm/info_thrCurrent.action",
					type:"POST",
					data:{
						id:rows[0].uid,
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
							
							$("#thr_edit").form('load',{
								name:data.result.uname,
								age:data.result.age,
								sex:data.result.sex,
								id:data.result.uid,
								password:data.result.password,
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
			var rows=$("#thr_table").datagrid('getSelections');
			if(rows.length>0){
				$.messager.confirm('确定操作','确定删除所选记录?',function(flag){
					if(flag){
						var ids=[];
						for(var i=0;i<rows.length;i++){
							ids.push(rows[i].uid);
						}
						
						$.ajax({
							type:'POST',
							url:'/ktdm/userRemove_rmThr.action',
							data:{
								ids:ids.join(','),
							},
							beforeSend:function(){
								$("#thr_table").datagrid('loading');
							},
							success:function(data){
								$("#thr_table").datagrid('loaded');
								$("#thr_table").datagrid('load');
								$("#thr_table").datagrid('unselectAll');
								$.messager.show({
									title:'提示',
									msg:data.result+'条记录删除成功!',
								});
							},
						});
					}else{
						$("#thr_table").datagrid('unselectAll');
					}
				});
			}else{
				$.messager.alert('提示','请选择要删除的记录!','info');
			}
		},
		search:function(){
			$("#thr_query").dialog("open");
		},
	}
})

function initAll_thr(){
	$('#thr_tool_add').linkbutton({    
	    iconCls: 'icon-add' ,
	    plain:true,
	});
	$('#thr_tool_edit').linkbutton({    
	    iconCls: 'icon-edit',
	    plain:true,
	});
	$('#thr_tool_remove').linkbutton({    
	    iconCls: 'icon-remove',
	    plain:true,
	});
	$('#thr_tool_search').linkbutton({    
	    iconCls: 'icon-search',
	    plain:true,   
	});
	$.each($('#thr_add p'),function(index,data){
		//console.log(index+","+data);
		$(data).css("margin","10px auto");
	});
	
	$("#thr_add").dialog({
		width:360,
		title:'新增教师',
		modal:true,
		closed:true,
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			plain:true,
			handler:function(){
				if($("#thr_add").form('validate')){
					$.ajax({
						url:'/ktdm/user_thrAdd.action',
						type:'POST',
						data:{
							name:$("#thr_add input[name='name']").val(),
							password:$("#thr_add input[name='password']").val(),
							sex:$("#thr_add input[name='sex']").val(),
							age:$("#thr_add input[name='age']").val(),
							role:2
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
									msg:'教师已成功添加!',
								});
								
								$("#thr_add").form('reset');
								$("#thr_add").dialog('close');
								$("#thr_table").datagrid('reload');
								
							}else{
								$("#thr_add").form('reset');
								$("#thr_add").dialog('close');
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
				$("#thr_add").form('reset');
				$("#thr_add").dialog('close');
			}
		}],
	});
	
	
	$("#thr_edit").dialog({
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
					url:"/ktdm/userModify_modifyThr.action",
					type:'POST',
					data:{
						id:$("#thr_edit input[name='id']").val(),
						name:$("#thr_edit input[name='name']").val(),
						sex:$("#thr_edit input[name='sex']").val(),
						age:$("#thr_edit input[name='age']").val(),
						password:$("#thr_edit input[name='password']").val(),
						role:2
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
							$("#thr_edit").dialog('close').form('reset');
							$("#thr_table").datagrid('reload');
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
				$("#thr_edit").dialog('close').form('reset');
			}
		}],
	});

	
	$("#thr_query").dialog({
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
				$("#thr_table").datagrid("load",{
					name:$.trim($("#thr_query [name='name']").val()),
					from:$("#thr_query [name='from']").val(),
					to:$("#thr_query [name='to']").val(),
					sex:$.trim($("#thr_query [name='sex']").val()),
					switcher:true,
				});
				$("#thr_query").dialog('close').form('reset');
			}
		},{
			text:'取消',
			iconCls:'icon-undo',
			plain:true,
			handler:function(){
				$("#thr_query").dialog('close').form('reset');
			}
		}],
	});
	
}
