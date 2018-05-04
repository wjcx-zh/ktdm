package com.hc.ktdm.handler;

import java.io.IOException;
import java.util.List;

/*import javax.servlet.http.HttpServletRequest;*/
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

/*import com.fasterxml.jackson.core.JsonProcessingException;*/
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.ktdm.domain.DataSet;
import com.hc.ktdm.domain.User;

import com.hc.ktdm.service.ManagerService;
import com.hc.ktdm.service.TeacherService;

public class UserInfoAction {
	private TeacherService teacherService;
	private ManagerService managerService;
	private Object result;
	private int rows;
	private int page;
	private String sort;
	private String order;
	public String manInfo() throws IOException{
		
		PageHelper.startPage(page, rows);
		List<User> users=managerService.findAll();
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
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	@JSON(serialize=false)
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	@JSON(serialize=false)
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	@JSON(serialize=false)
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	@JSON(serialize=false)
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@JSON(serialize=false)
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	@JSON(serialize=false)
	public ManagerService getManagerService() {
		return managerService;
	}
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
}
