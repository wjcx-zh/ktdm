<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ktdm/easy_ui/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="/ktdm/easy_ui/themes/icon.css">   
	<link rel="stylesheet" type="text/css" href="/ktdm/css/success.css"/>
	<script type="text/javascript" src="/ktdm/easy_ui/jquery.min.js"></script>   
	<script type="text/javascript" src="/ktdm/easy_ui/jquery.easyui.min.js"></script> 
	<script type="text/javascript" src="/ktdm/easy_ui/locale/easyui-lang-zh_CN.js"></script> 

  </head>
  
  <body>
  	<div id="jc_con">
  		<img alt="背景图" src="/ktdm/imgs/ktdm.png">
  		<div class="msg">
  			<h1>恭喜你！签到成功！！</h1>
  		</div>
  
	</div>
  </body>
</html>
