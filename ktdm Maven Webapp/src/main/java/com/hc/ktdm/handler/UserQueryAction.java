package com.hc.ktdm.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.ktdm.domain.DataSet;
import com.hc.ktdm.domain.QueryInfo;
import com.hc.ktdm.domain.User;
import com.hc.ktdm.service.ManagerService;
import com.hc.ktdm.service.TeacherService;

public class UserQueryAction {
	private ManagerService managerService;
	private TeacherService teacherService;
	private Object result;
	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String manQuery() throws IOException{
		HttpSession session=ServletActionContext.getRequest().getSession();
		QueryInfo info=(QueryInfo) session.getAttribute("queryInfo");
		PageHelper.startPage(info.getPage(), info.getRows());
		List<User> users=managerService.findByConditions(info.getName(), info.getSex(), info.getFrom(), info.getTo());
		DataSet dataSet=new DataSet();
		dataSet.setRows(users);
		PageInfo<User> pageInfo=new PageInfo<User>(users);
		dataSet.setTotal(pageInfo.getTotal());
		ObjectMapper mapper=new ObjectMapper();
		String jsonObj=mapper.writeValueAsString(dataSet);
		HttpServletResponse response = ServletActionContext.getResponse();  
        //HttpServletRequest request = ServletActionContext.getRequest();
        response.setCharacterEncoding("utf-8");//指定为utf-8  
        System.out.println(jsonObj);
        response.getWriter().write(jsonObj);
        result=dataSet;
		return null;
	}
	
	@JSON(serialize=false)
	public ManagerService getManagerService() {
		return managerService;
	}
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	@JSON(serialize=false)
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
}
