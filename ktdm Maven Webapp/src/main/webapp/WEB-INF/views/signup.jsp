<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生签到页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ktdm/easy_ui/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="/ktdm/easy_ui/themes/icon.css">   
	<link rel="stylesheet" type="text/css" href="/ktdm/css/login.css"/>
	<script type="text/javascript" src="/ktdm/easy_ui/jquery.min.js"></script>   
	<script type="text/javascript" src="/ktdm/easy_ui/jquery.easyui.min.js"></script> 
	<script type="text/javascript" src="/ktdm/easy_ui/locale/easyui-lang-zh_CN.js"></script> 

  </head>
  
  <body>
  	<div id="jc_con">
  		<img alt="背景图" src="/ktdm/imgs/ktdm.png">
	    <form id="ff" action="/ktdm/login.action" method="post">   
		    <div>   
		        <label for="name" style="width:60px;display:inline-block">姓 名:</label>   
		        <input class="easyui-validatebox" type="text" name="name" data-options="required:true" />   
		    </div>   
		    <div>   
		        <label for="stunum" style="width:60px;display:inline-block;">学 号:</label>   
		        <input class="easyui-validatebox" type="text" name="stunum" data-options="validType:'password'" />   
		    </div>   
		    <input name="login" type="submit" value="签到"/>   
		</form>  
  
	</div>
  </body>
</html>
