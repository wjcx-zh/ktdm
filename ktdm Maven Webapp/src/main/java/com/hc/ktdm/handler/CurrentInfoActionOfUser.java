package com.hc.ktdm.handler;

import org.apache.struts2.json.annotations.JSON;

import com.hc.ktdm.domain.User;

import com.hc.ktdm.service.ManagerService;
import com.hc.ktdm.service.TeacherService;

public class CurrentInfoActionOfUser {
	private Integer id;
	private Object result;
	private ManagerService managerService;
	private TeacherService teacherService;
	
	public String manCurrent(){
		User user=managerService.findById(id);
		
		result=user;
		return "success";
	}
	
	public String thrCurrent(){
		User user=teacherService.findById(id);
		result=user;
		return "success";
	}
	
	
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	@JSON(serialize=false)
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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
