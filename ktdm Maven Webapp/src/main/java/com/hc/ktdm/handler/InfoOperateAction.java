package com.hc.ktdm.handler;

import org.apache.struts2.json.annotations.JSON;

import com.hc.ktdm.model.Course;
import com.hc.ktdm.service.CourseService;

public class InfoOperateAction {
	private String name;
	private Integer id;
	private Object result;
	private CourseService courseService;
	
	public String crsAdd(){
		Course course=new Course();
		course.setCname(name);
		result=(courseService.addCourse(course)!=0)?1:0;
		return "success";
	}
	
	public String modifyCrs(){
		Course course=new Course();
		course.setCname(name);
		course.setCid(id);
		result=(courseService.modifyCourse(course)!=0)?1:0;
		return "success";
	}
	
	@JSON(serialize=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JSON(serialize=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	@JSON(serialize=false)
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
}
