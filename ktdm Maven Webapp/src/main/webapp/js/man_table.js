$(function(){
	
	$("#man_table").datagrid({
		url:"/ktdm/userInfo_manInfo.action",
		fit:true,
		closeable:true,
		autoRowHeight:false,
		fitColumns:true,
		striped:true,
		rownumbers:true,
		border:false,
		pagination:true,
		pageSize:3,
		pageList:[3,5],
		pageNumber:1,
		pagePosition:'bottom',
		sortName:'uid',
		sortOrder:"desc",
		toolbar:'#man_tool',
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
				title:'管理员姓名',
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
	
	initAll_man();
	
	tool={
		add:function(){
			//console.log($("#user_add"));
			$("#user_add").form().dialog('open');
		},
		edit:function(){
			var rows=$('#man_table').datagrid('getSelections');
			if(rows.length>1){
				$.messager.alert('WARNING!','编辑记录只能选定一条数据!','warning');
			}else if(rows.length==1){
				//console.log(rows);
				$.ajax({
					url:"/ktdm/info_manCurrent.action",
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
							
							$("#user_edit").form('load',{
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
			var rows=$("#man_table").datagrid('getSelections');
			if(rows.length>0){
				$.messager.confirm('确定操作','确定删除所选记录?',function(flag){
					if(flag){
						var ids=[];
						for(var i=0;i<rows.length;i++){
							ids.push(rows[i].uid);
						}
						
						$.ajax({
							type:'POST',
							url:'/ktdm/userRemove_rmMan.action',
							data:{
								ids:ids.join(','),
							},
							beforeSend:function(){
								$("#man_table").datagrid('loading');
							},
							success:function(data){
								$("#man_table").datagrid('loaded');
								$("#man_table").datagrid('load');
								$("#man_table").datagrid('unselectAll');
								$.messager.show({
									title:'提示',
									msg:data.result+'条记录删除成功!',
								});
							},
						});
					}else{
						$("#man_table").datagrid('unselectAll');
					}
				});
			}else{
				$.messager.alert('提示','请选择要删除的记录!','info');
			}
		},
		search:function(){
			$("#man_query").dialog("open");
		},
	}
	
	$.parser.parse("#man_tool");
	$.parser.parse();
})

function initAll_man(){
	$('#man_tool_add').linkbutton({    
	    iconCls: 'icon-add' ,
	    plain:true,
	});
	$('#man_tool_edit').linkbutton({    
	    iconCls: 'icon-edit',
	    plain:true,
	});
	$('#man_tool_remove').linkbutton({    
	    iconCls: 'icon-remove',
	    plain:true,
	});
	$('#man_tool_search').linkbutton({    
	    iconCls: 'icon-search',
	    plain:true,   
	});
	$.each($('#user_add p'),function(index,data){
		//console.log(index+","+data);
		$(data).css("margin","10px auto");
	});
	
	$("#user_add").dialog({
		width:360,
		title:'新增管理员',
		modal:true,
		closed:true,
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			plain:true,
			handler:function(){
				if($("#user_add").form('validate')){
					console.log($("input[name='name']").val());
					$.ajax({
						url:'/ktdm/user_manAdd.action',
						type:'POST',
						data:{
							name:$("#user_add input[name='name']").val(),
							password:$("#user_add input[name='password']").val(),
							sex:$("#user_add input[name='sex']").val(),
							age:$("#user_add input[name='age']").val(),
							role:1
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
									msg:'管理员已成功添加!',
								});
								
								$("#user_add").form('reset');
								$("#user_add").dialog('close');
								$("#man_table").datagrid('reload');
								
							}else{
								$("#user_add").form('reset');
								$("#user_add").dialog('close');
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
				$("#user_add").form('reset');
				$("#user_add").dialog('close');
			}
		}],
	});
	
	
	$("#user_edit").dialog({
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
					url:"/ktdm/userModify_modifyMan.action",
					type:'POST',
					data:{
						id:$("#user_edit input[name='id']").val(),
						name:$("#user_edit input[name='name']").val(),
						sex:$("#user_edit input[name='sex']").val(),
						age:$("#user_edit input[name='age']").val(),
						password:$("#user_edit input[name='password']").val(),
						role:1
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
							$("#user_edit").dialog('close').form('reset');
							$("#man_table").datagrid('reload');
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
				$("#user_edit").dialog('close').form('reset');
			}
		}],
	});

	
	$("#man_query").dialog({
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
				$("#man_table").datagrid("load",{
					name:$.trim($("#man_query [name='name']").val()),
					from:$("#man_query [name='from']").val(),
					to:$("#man_query [name='to']").val(),
					sex:$.trim($("#man_query [name='sex']").val()),
					switcher:true,
				});
				$("#man_query").dialog('close').form('reset');
			}
		},{
			text:'取消',
			iconCls:'icon-undo',
			plain:true,
			handler:function(){
				$("#man_query").dialog('close').form('reset');
			}
		}],
	});
	
}

/*
$("#man_tool").load("/ktdm/static_view/tool.html",function(){});
$("#wins").html("");
$("#wins").load("/ktdm/static_view/user_add.html",function(){});
$("#wins").load("/ktdm/static_view/user_edit.html",function(){});
$("#wins").load("/ktdm/static_view/man_query.html",function(){});*/