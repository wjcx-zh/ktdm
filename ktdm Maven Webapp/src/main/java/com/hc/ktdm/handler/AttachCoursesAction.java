package com.hc.ktdm.handler;



import org.apache.struts2.json.annotations.JSON;

import com.hc.ktdm.domain.User;
import com.hc.ktdm.model.Teacher;
import com.hc.ktdm.service.NameTableService;
import com.hc.ktdm.service.TeacherService;

public class AttachCoursesAction {
	//ajax返回结果，以object为例
	private Object result;
	private TeacherService teacherService;
	private Integer tid;
	private NameTableService nameTableService;
	public Object attach(){
		nameTableService.removeAllInfo();
		User user=teacherService.findById(tid);
		result=user.getCourses();
		//System.out.println(result);
		return "success";
	}
	@JSON(serialize=false)
	public NameTableService getNameTableService() {
		return nameTableService;
	}
	public void setNameTableService(NameTableService nameTableService) {
		this.nameTableService = nameTableService;
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
	@JSON(serialize=false)
	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}
}
