<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>签到系统首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ktdm/easy_ui/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="/ktdm/easy_ui/themes/icon.css">   
	<link rel="stylesheet" type="text/css" href="/ktdm/css/index.css"/>
	<script type="text/javascript" src="/ktdm/easy_ui/jquery.min.js"></script>   
	<script type="text/javascript" src="/ktdm/easy_ui/jquery.easyui.min.js"></script> 
	<script type="text/javascript" src="/ktdm/easy_ui/locale/easyui-lang-zh_CN.js"></script> 

  </head>
  
  <body>
  	<div id="jc_con">
	    <div id="jc_panel" >
	    	<img alt="背景图" src="/ktdm/imgs/ktdm.png">   
		    <a name="a1" href="/ktdm/loginpage.action?choose=1">管理员登录</a>   
		    <a name="a2" href="/ktdm/loginpage.action?choose=2">教师登录</a>   
		</div>  
	</div>
  </body>
</html>
