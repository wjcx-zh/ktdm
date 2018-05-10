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
import com.hc.ktdm.domain.QueryInfo;
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
	private String name;
	private Integer from;
	private Integer to;
	private String sex;
	private boolean switcher=false;
	public String thrInfo() throws IOException{
		/*if(switcher){
			QueryInfo info=new QueryInfo(name,sex,from,to,rows,page,sort,order);
			ServletActionContext.getRequest().getSession().setAttribute("queryInfo", info);
			return "query";
		}*/
		PageHelper.startPage(page, rows);
		System.out.println(name+","+sex+","+from+","+to);
		List<User> users=teacherService.findAll();
		if(switcher){
			System.out.println(name+","+sex+","+from+","+to);
			users=teacherService.findByConditions(name, sex, from, to);
		}
		System.out.println(name+";"+sex+";"+from+";s"+to);
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
	
	public String manInfo() throws IOException{
		/*if(switcher){
			QueryInfo info=new QueryInfo(name,sex,from,to,rows,page,sort,order);
			ServletActionContext.getRequest().getSession().setAttribute("queryInfo", info);
			return "query";
		}*/
		PageHelper.startPage(page, rows);
		System.out.println(name+","+sex+","+from+","+to);
		List<User> users=managerService.findAll();
		if(switcher){
			System.out.println(name+","+sex+","+from+","+to);
			users=managerService.findByConditions(name, sex, from, to);
		}
		System.out.println(name+";"+sex+";"+from+";s"+to);
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@JSON(serialize=false)
	public Integer getFrom() {
		return from;
	}
	public void setFrom(Integer from) {
		this.from = from;
	}
	@JSON(serialize=false)
	public Integer getTo() {
		return to;
	}
	public void setTo(Integer to) {
		this.to = to;
	}
	@JSON(serialize=false)
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@JSON(serialize=false)
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	@JSON(serialize=false)
	public boolean isSwitcher() {
		return switcher;
	}
	
	public void setSwitcher(boolean switcher) {
		this.switcher = switcher;
	}
	@JSON(serialize=false)
	public ManagerService getManagerService() {
		return managerService;
	}
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
}
