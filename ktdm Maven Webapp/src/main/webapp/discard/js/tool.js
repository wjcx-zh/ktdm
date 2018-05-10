$(function(){
	
	
	/**/
	$("#man_tool").show();
});
function init(){
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
					$.ajax({
						url:'/ktdm/user_manAdd.action',
						type:'POST',
						data:{
							name:$("input[name='name']").val(),
							password:$("input[name='password']").val(),
							sex:$("input[name='sex']").val(),
							age:$("input[name='age']").val(),
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