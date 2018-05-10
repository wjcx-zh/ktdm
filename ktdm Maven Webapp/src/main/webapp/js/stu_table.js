$(function(){
	
	$("#stu_table").datagrid({
		url:"/ktdm/stu_stuInfo.action",
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
		sortName:'sid',
		sortOrder:"desc",
		toolbar:'#stu_tool',
		showFooter:true,
		columns:[[
			{
				field:'sid',
				title:'编号',
				/*width:100,*/
				checkbox:true
			},
			{
				field:'sname',
				title:'学生姓名',
				width:100,
			},
			{
				field:'sex',
				title:'性别',
				width:100,
			},
			{
				field:'snum',
				title:'学号',
				width:100,
			},
			
		]],
	});
	
	stu_initAll();
	/**/
	tool={
		add:function(){
			//console.log($("#user_add"));
			$("#stu_add").dialog('open');
			//rendering_crs();
		},
		edit:function(){
			var rows=$('#stu_table').datagrid('getSelections');
			if(rows.length>1){
				$.messager.alert('WARNING!','编辑记录只能选定一条数据!','warning');
			}else if(rows.length==1){
				//console.log(rows);
				$.ajax({
					url:"/ktdm/stu_stuCurrent.action",
					type:"POST",
					data:{
						id:rows[0].sid,
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
							
							$("#stu_edit").form('load',{
								name:data.result.sname,
								snum:data.result.snum,
								sex:data.result.sex,
								id:data.result.sid,
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
			var rows=$("#stu_table").datagrid('getSelections');
			if(rows.length>0){
				$.messager.confirm('确定操作','确定删除所选记录?',function(flag){
					if(flag){
						var ids=[];
						for(var i=0;i<rows.length;i++){
							ids.push(rows[i].sid);
						}
						
						$.ajax({
							type:'POST',
							url:'/ktdm/stu_rmStu.action',
							data:{
								ids:ids.join(','),
							},
							beforeSend:function(){
								$("#stu_table").datagrid('loading');
							},
							success:function(data){
								$("#stu_table").datagrid('loaded');
								$("#stu_table").datagrid('load');
								$("#stu_table").datagrid('unselectAll');
								$.messager.show({
									title:'提示',
									msg:data.result+'条记录删除成功!',
								});
							},
						});
					}else{
						$("#stu_table").datagrid('unselectAll');
					}
				});
			}else{
				$.messager.alert('提示','请选择要删除的记录!','info');
			}
		},
		search:function(){
			$("#stu_query").dialog("open");
		},
	}
	//rendering_crs();
})

function stu_initAll(){
	$('#stu_tool_add').linkbutton({    
	    iconCls: 'icon-add' ,
	    plain:true,
	});
	$('#stu_tool_edit').linkbutton({    
	    iconCls: 'icon-edit',
	    plain:true,
	});
	$('#stu_tool_remove').linkbutton({    
	    iconCls: 'icon-remove',
	    plain:true,
	});
	$('#stu_tool_search').linkbutton({    
	    iconCls: 'icon-search',
	    plain:true,   
	});
	$.each($('#stu_add p'),function(index,data){
		//console.log(index+","+data);
		$(data).css("margin","10px auto");
	});
	
	$("#stu_add").dialog({
		width:360,
		title:'新增学员',
		modal:true,
		closed:true,
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			plain:true,
			handler:function(){
				if($("#stu_add").form('validate')){
					//console.log($("input[name='name']").val());
					$.ajax({
						url:'/ktdm/stu_stuAdd.action',
						type:'POST',
						data:{
							name:$("#stu_add input[name='name']").val(),
							snum:$("#stu_add input[name='snum']").val(),
							sex:$("#stu_add input[name='sex']").val(),
							courses:$("#stu_add input[name='courses']").val(),
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
									msg:'学员已成功添加!',
								});
								
								$("#stu_add").form('reset');
								$("#stu_add").dialog('close');
								$("#stu_table").datagrid('reload');
								
							}else{
								$("#stu_add").form('reset');
								$("#stu_add").dialog('close');
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
				$("#stu_add").form('reset');
				$("#stu_add").dialog('close');
			}
		}],
	});
	
	
	$("#stu_edit").dialog({
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
					url:"/ktdm/stu_modifyStu.action",
					type:'POST',
					data:{
						id:$("#stu_edit input[name='id']").val(),
						name:$("#stu_edit input[name='name']").val(),
						sex:$("#stu_edit input[name='sex']").val(),
						snum:$("#stu_edit input[name='snum']").val(),
						courses:$("#stu_edit input[name='courses']").val(),
						
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
							$("#stu_edit").dialog('close').form('reset');
							$("#stu_table").datagrid('reload');
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
				$("#stu_edit").dialog('close').form('reset');
			}
		}],
	});

	
	$("#stu_query").dialog({
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
				$("#stu_table").datagrid("load",{
					name:$.trim($("#stu_query [name='name']").val()),
					snum:$("#stu_query [name='snum']").val(),
					course:$("#stu_query [name='course']").val(),
					sex:$.trim($("#stu_query [name='sex']").val()),
					switcher:true,
				});
				$("#stu_query").dialog('close').form('reset');
			}
		},{
			text:'取消',
			iconCls:'icon-undo',
			plain:true,
			handler:function(){
				$("#stu_query").dialog('close').form('reset');
			}
		}],
	});
	
}
function rendering_crs(){
	console.log($("#stu_wins input[name='courses']"));
	$("#stu_add input[name='courses']").tagbox({
		url:'/ktdm/stu_crsRender',
		hasDownArrow:true,
		valueField:result.cid,
		textField:result.cname,
	});
}