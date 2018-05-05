$(function(){
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
});
