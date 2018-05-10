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
import com.hc.ktdm.model.Student;
import com.hc.ktdm.service.CourseService;
import com.hc.ktdm.service.StudentService;

public class StuInfoAction {
	private String name;
	private Integer id;
	private String ids;
	private Integer snum;
	private String sex;
	private boolean switcher;
	private Integer rows;
	private Integer page;
	private String order;
	private String sort;
	private StudentService studentService;
	private CourseService courseService;
	private Object result;
	
	public String stuInfo() throws IOException{
		PageHelper.startPage(page, rows);
		List<Student> students=studentService.findAll();
		//List<Course> courses=courseService.findAll();
		DataSet dataSet=new DataSet();
		System.out.println(rows+","+page+","+order+","+sort);
		dataSet.setRows(students);
		PageInfo<Student> info=new PageInfo<Student>(students);
		dataSet.setTotal(info.getTotal());
		ObjectMapper mapper=new ObjectMapper();
		String jsonObj=mapper.writeValueAsString(dataSet);
		HttpServletResponse response = ServletActionContext.getResponse();  
        //HttpServletRequest request = ServletActionContext.getRequest();
        response.setCharacterEncoding("utf-8");//指定为utf-8  
        System.out.println(jsonObj);
       
        //ServletActionContext.getRequest().getSession().setAttribute("sc_courses",courses);
        response.getWriter().write(jsonObj);
        result=dataSet;
		return null;
	}
	
	public String stuAdd(){
		Student student=new Student();
		student.setSname(name);
		student.setSnum(snum);
		student.setSex(sex);
		result=studentService.addStudent(student);
		
		return "success";
	}
	
	public String stuCurrent(){
		Student stu=studentService.findById(id);
		result=stu;
		return "success";
	}
	
	public String modifyStu(){
		Student stu=new Student();
		stu.setSid(id);
		stu.setSname(name);
		stu.setSnum(snum);
		stu.setSex(sex);
		result=studentService.modifyStudent(stu);
		return "success";
	}
	
	public String rmStu(){
		result=studentService.removeByIds(ids);
		return "success";
	}
	
	public String crsRender(){
		List<Course> courses=courseService.findAll();
		result=courses;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@JSON(serialize=false)
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	@JSON(serialize=false)
	public Integer getSnum() {
		return snum;
	}
	public void setSnum(Integer snum) {
		this.snum = snum;
	}
	@JSON(serialize=false)
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@JSON(serialize=false)
	public boolean isSwitcher() {
		return switcher;
	}
	public void setSwitcher(boolean switcher) {
		this.switcher = switcher;
	}
	@JSON(serialize=false)
	public Integer getRows() {
		return rows;
	}


	public void setRows(Integer rows) {
		this.rows = rows;
	}

	@JSON(serialize=false)
	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}

	@JSON(serialize=false)
	public String getOrder() {
		return order;
	}


	public void setOrder(String order) {
		this.order = order;
	}

	@JSON(serialize=false)
	public String getSort() {
		return sort;
	}


	public void setSort(String sort) {
		this.sort = sort;
	}


	@JSON(serialize=false)
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@JSON(serialize=false)
	public CourseService getCourseService() {
		return courseService;
	}


	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
}
