package com.hc.ktdm.handler;

import org.apache.struts2.json.annotations.JSON;

import com.hc.ktdm.model.Manager;
import com.hc.ktdm.model.Teacher;
import com.hc.ktdm.service.ManagerService;
import com.hc.ktdm.service.TeacherService;

public class UserAddAction {
	private String name;
	private String password;
	private String sex;
	private int age;
	private Object result;
	private ManagerService managerService;
	private TeacherService teacherService;
	public String manAdd(){
		Manager man=new Manager();
		man.setAge(age);
		man.setMname(name);
		man.setPassword(password);
		man.setSex(sex);
		result=managerService.addManager(man);
		return "success";
	}
	
	public String thrAdd(){
		Teacher thr=new Teacher();
		thr.setAge(age);
		thr.setTname(name);
		thr.setPassword(password);
		thr.setSex(sex);
		result=teacherService.addTeacher(thr);
		return "success";
	}
	
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	@JSON(serialize=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@JSON(serialize=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@JSON(serialize=false)
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@JSON(serialize=false)
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
