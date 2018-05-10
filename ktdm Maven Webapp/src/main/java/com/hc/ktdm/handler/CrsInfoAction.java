package com.hc.ktdm.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.ktdm.domain.DataSet;
import com.hc.ktdm.model.Course;
import com.hc.ktdm.service.CourseService;

public class CrsInfoAction {
	private int rows;
	private int page;
	private String sort;
	private String order;
	private Integer id;
	private String name;
	private Object result;
	private String ids;
	private CourseService courseService;
	
	public String crsInfo() throws IOException{
		PageHelper.startPage(page, rows);
		List<Course> courses=courseService.findAll();
		DataSet dataSet=new DataSet();
		System.out.println(rows+","+page+","+order+","+sort);
		dataSet.setRows(courses);
		PageInfo<Course> info=new PageInfo<Course>(courses);
		dataSet.setTotal(info.getTotal());
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
	public String crsCurrent(){
		Course crs=courseService.findById(id);
		result=crs;
		return "success";
	}
	
	public String rmCrs(){
		result=courseService.removeCourseByIds(ids);
		return "success";
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
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
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
