<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>签到页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ktdm/easy_ui/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="/ktdm/easy_ui/themes/icon.css">   
	<link rel="stylesheet" type="text/css" href="/ktdm/css/backstage.css"/>
	
	<script type="text/javascript" src="/ktdm/easy_ui/jquery.min.js"></script>   
	<script type="text/javascript" src="/ktdm/easy_ui/jquery.easyui.min.js"></script> 
	<script type="text/javascript" src="/ktdm/easy_ui/locale/easyui-lang-zh_CN.js"></script> 
	
  </head>
  
  <body>
  	
    <div id="jc_con">
    	<div id="cc" class="easyui-layout" style="width:520px;height:400px;">   
		    <div data-options="region:'north',split:false" style="height:100px;background-image: url('/ktdm/imgs/kmbs.png');" class="jc_north">
		    	<div class="jc_msg" >
		    		
		    		<div class="jc_show_name" value="${manager.mid}">欢迎您,<a><i>${manager.mname}</i></a>|<a href="/ktdm/index.jsp">退出</a></div>
		    	</div>
		    	
		    </div>  
		     <div data-options="region:'south',split:false" style="height:22px;background:#eee;">
		     	<div id="foot">&copy;wjcx实现</div>
		     </div> 
		    <div data-options="region:'west',title:'操作',split:false" style="width:100px;background:#eee;" id="west">
		    	 <ul>
		    		<li  class="nav-man" id="man"><a>管理员管理</a></li>
	                <li  class="nav-stu" id="stu"><a>学生管理</a></li>
	                <li  class="nav-tch" id="thr"><a>教师管理</a></li>
	                <li  class="nav-cus" id="cus"><a>课程管理</a></li>
	                <li  class="nav-time" id="link"><a>关系维护</a></li>
	                <li  class="nav-time" id="time"><a>定时管理</a></li>
	               
	            </ul>
		    	 
		    	
		    </div>   
		    <div data-options="region:'center',title:'内容展示',noheader:true" style="background:#eee;overflow:hidden" class="jc_center" >
		    	<div id="tabs" class="easyui-tabs jc_tabs" style="border:none"></div>
		    </div>   
		</div>  
    	
    </div>
    
  </body>
  <script type="text/javascript" src="/ktdm/js/backstage.js"></script>
</html>
