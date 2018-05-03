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
	<link rel="stylesheet" type="text/css" href="/ktdm/css/sign.css"/>
	<script type="text/javascript" src="/ktdm/easy_ui/jquery.min.js"></script>   
	<script type="text/javascript" src="/ktdm/easy_ui/jquery.easyui.min.js"></script> 
	<script type="text/javascript" src="/ktdm/easy_ui/locale/easyui-lang-zh_CN.js"></script> 
	<script type="text/javascript" src="/ktdm/js/sign.js"></script>

  </head>
  
  <body>
    <div id="jc_con">
    	<div id="cc" class="easyui-layout" style="width:500px;height:400px;">   
		    <div data-options="region:'north',split:false" style="height:100px;background-image: url('/ktdm/imgs/sign.png');" class="jc_north">
		    	<div class="jc_msg" >
		    		
		    		<div class="jc_show_name" value="${teacher.tid}">欢迎您,<a><i>${teacher.tname}</i></a>|<a href="/ktdm/index.jsp">退出</a></div>
		    	</div>
		    	
		    </div>   
		    <div data-options="region:'west',title:'操作',split:false" style="width:100px;background:#eee;" id="west">
		    	<div id="kb_con">
		    		<select id="kb" class="easyui-combobox" name="courses" style="width:80px;">   
					    <option value="aa">请选择</option>
					       
					</select> 
		    	</div>
		    	 <ul>
	                <li  class="nav-img" id="img"><a>上课签到</a></li>
	                <li  class="nav-table" id="table"><a>签到信息</a></li>
	                <li  class="nav-exit" id="exit"><a>导出Excel</a></li>
	            </ul>
		    	 
		    	
		    </div>   
		    <div data-options="region:'center',title:'内容展示'" style="padding:5px;background:#eee;" >
		    	<div class="show" id="show">
			    	<div class="show-img" id="show-img" style="opacity:1;"></div>
		            <div class="show-table" id="show-table">
					</div>
		    	</div>
		    </div>   
		</div>  
    	
    </div>
  </body>
</html>
