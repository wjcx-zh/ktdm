package com.hc.ktdm.handler;

import org.apache.struts2.json.annotations.JSON;

import com.hc.ktdm.model.Manager;
import com.hc.ktdm.model.Teacher;
import com.hc.ktdm.service.ManagerService;
import com.hc.ktdm.service.TeacherService;

public class ModifyInfoAction {
	private Integer id;
	private String name;
	private String sex;
	private String password;
	private int age;
	private Object result;
	private ManagerService managerService;
	private TeacherService teacherService;
	
	public String modifyMan(){
		Manager man=new Manager();
		man.setAge(age);
		man.setMid(id);
		man.setMname(name);
		man.setSex(sex);
		man.setPassword(password);
		System.out.println(man);
		result=managerService.modifyManager(man);
		return "success";
	}
	
	public String modifyThr(){
		Teacher thr=new Teacher();
		thr.setAge(age);
		thr.setTid(id);
		thr.setTname(name);
		thr.setSex(sex);
		thr.setPassword(password);
		System.out.println(thr);
		result=teacherService.modifyTeacher(thr);
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
	@JSON(serialize=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
