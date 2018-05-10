package com.hc.ktdm.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.ktdm.domain.DataSet;
import com.hc.ktdm.domain.LinkTable;
import com.hc.ktdm.domain.User;
import com.hc.ktdm.model.Course;
import com.hc.ktdm.model.Student;
import com.hc.ktdm.model.Teacher;
import com.hc.ktdm.service.CourseService;
import com.hc.ktdm.service.StudentService;
import com.hc.ktdm.service.TeacherService;

public class LinkInfoAction {
	private int rows;
	private int page;
	private String sort;
	private String order;
	private Integer linkId;
	private Integer num;
	private String cname;
	private String name;
	private Object result;
	private StudentService studentService;
	private CourseService courseService;
	private TeacherService teacherService;
	
	public String scInfo() throws IOException{
		PageHelper.startPage(page, rows);
		List<Student> stus=studentService.findAll();
		List<LinkTable> links=new ArrayList<LinkTable>();
		if(stus!=null&&stus.size()>0){
			for(Student s:stus){
				LinkTable link=null;
				if(s.getCourses()!=null&&s.getCourses().size()>0){
					Set<Course> c_set=s.getCourses();
					for(Course c:c_set){
						link=new LinkTable(s.getSid(),s.getSnum());
						link.setCname(c.getCname());
						links.add(link);
					}
					
				}else{
					link=new LinkTable(s.getSid(),s.getSnum());
					links.add(link);
				}
				
			}
		}
		DataSet dataSet=new DataSet();
		dataSet.setRows(links);
		PageInfo<LinkTable> info=new PageInfo<LinkTable>(links);
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
	
	public String tcInfo() throws IOException{
		PageHelper.startPage(page, rows);
		List<User> thrs=teacherService.findAll();
		List<LinkTable> links=new ArrayList<LinkTable>();
		if(thrs!=null&&thrs.size()>0){
			for(User t:thrs){
				LinkTable link=null;
				if(t.getCourses()!=null&&t.getCourses().size()>0){
					Set<Course> c_set=t.getCourses();
					for(Course c:c_set){
						link=new LinkTable(t.getUid(),t.getUid());
						link.setCname(c.getCname());
						links.add(link);
					}
					
				}else{
					link=new LinkTable(t.getUid(),t.getUid());
					links.add(link);
				}
				
			}
		}
		
		DataSet dataSet=new DataSet();
		dataSet.setRows(links);
		PageInfo<LinkTable> info=new PageInfo<LinkTable>(links);
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
	
	
	public String scAdd(){
		
		List<Student> stus=studentService.findAll();
		List<Course> cous=courseService.findAll();
		boolean flag1=false,flag2=false;
		//LinkTable link=new LinkTable();
		Student stu=null;
		Course cou=null;
		System.out.println(num+";"+cname);
		if(stus!=null&&stus.size()>0){
			for(Student s:stus){
				//System.out.println(s);
				if(s.getSnum().equals(num)){
					//System.out.println(s.getSname());
					stu=s;
					//link.setNum(num);
					flag1=true;
				}
			}
		}
		if(cous!=null&&cous.size()>0){
			for(Course c:cous){
				if(c.getCname().equals(cname)){
					cou=c;
					//link.setCname(cname);
					flag2=true;
				}
			}
		}
		if(flag1&&flag2){
			stu.getCourses().add(cou);
			result=studentService.modifyStudent(stu);
			return "success";
		}else{
			result="学生或课程不存在！请先插入对应数据！";
			return "noexist";
		}
		
	}
	
	public String scCurrent(){
		Student stu=studentService.findById(linkId);
		LinkTable link=new LinkTable();
		link.setLinkId(linkId);
		link.setNum(stu.getSnum());
		link.setCname(cname);
		ServletActionContext.getRequest().getSession().setAttribute("currentCrsName", cname);
		result=link;
		return "success";
	}
	
	public String modifySC(){
		Student stu=studentService.findById(linkId);
		Set<Course> cous=stu.getCourses();
		List<Course> couList=courseService.findAll();
		String cc=(String) ServletActionContext.getRequest().getSession().getAttribute("currentCrsName");
		System.out.println(cc);
		boolean flag=false;
		for(Course c:couList){
			System.out.println(c.getCname());
			System.out.println((c.getCname().equals(cc)));
			if(c.getCname().equals(cc)){
				flag=true;
			}
		}
		if(!flag){
			return null;
		}
		
		if(cous!=null&&cous.size()>0){
			for(Course c:cous){
				if(c.getCname().equals(cc)){
					c.setCname(cname);
				}
			}
		}
		stu.setCourses(cous);
		result=studentService.modifyStudent(stu);
		return "success";
	}
	
	public String rmSC(){
		Student stu=studentService.findById(linkId);
		Set<Course> cous=stu.getCourses();
		if(cous!=null&&cous.size()>0){
			for(Course c:cous){
				if(c.getCname().equals(cname)){
					c.setCname(null);
				}
			}
		}
		stu.setCourses(cous);
		result=studentService.modifyStudent(stu);
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
	public Integer getLinkId() {
		return linkId;
	}
	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}
	@JSON(serialize=false)
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@JSON(serialize=false)
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
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
	@JSON(serialize=false)
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
}
