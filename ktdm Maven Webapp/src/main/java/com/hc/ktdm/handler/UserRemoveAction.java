package com.hc.ktdm.handler;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.hc.ktdm.service.ManagerService;
import com.hc.ktdm.service.TeacherService;

public class UserRemoveAction {
	private String ids;
	private ManagerService managerService;
	private TeacherService teacherService;
	private Object result;
	
	public String rmMan(){
		if(ids.length()==1){
			result=managerService.removeManager(Integer.parseInt(ids));
		}else{
			String[] idstr=ids.split(",");
			List<Integer> lists=new ArrayList<Integer>();
			for(String str:idstr){
				lists.add(Integer.parseInt(str));
			}
			result=managerService.removeManagers(lists);
		}
		return "success";
	}	
	
	public String rmThr(){
		if(ids.length()==1){
			result=teacherService.removeTeacher(Integer.parseInt(ids));
		}else{
			String[] idstr=ids.split(",");
			List<Integer> lists=new ArrayList<Integer>();
			for(String str:idstr){
				lists.add(Integer.parseInt(str));
			}
			result=teacherService.removeTeachers(lists);
		}
		return "success";
	}	
	@JSON(serialize=false)
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
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
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
}
