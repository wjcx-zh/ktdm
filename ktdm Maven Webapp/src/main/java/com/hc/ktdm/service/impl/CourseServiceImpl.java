package com.hc.ktdm.service.impl;


import java.util.List;

import com.hc.ktdm.dao.CourseDao;
import com.hc.ktdm.model.Course;
import com.hc.ktdm.service.CourseService;

public class CourseServiceImpl implements CourseService {
	private CourseDao courseDao;
	@Override
	public Course findById(int id) {
		
		return courseDao.findById(id);
	}

	@Override
	public List<Course> findAll() {
		
		return courseDao.findAll();
	}

	@Override
	public int addCourse(Course course) {
		
		return courseDao.addCourse(course);
}

	@Override
	public int removeCourse(Course course) {
		return 0;
		// TODO Auto-generated method stub

	}

	@Override
	public int modifyCourse(Course course) {
		
		return courseDao.modifyCourse(course);
	}

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	@Override
	public int removeCourseByIds(String ids) {
		String[] id=ids.split(",");
		boolean flag=false;
		int ret=0;
		for(String cid:id){
			Course course=courseDao.findById(Integer.parseInt(cid));
			
			ret=courseDao.removeCourse(course);
			
		}
		if(ret!=0){
			flag=true;
		}
		return flag?1:0;
	}

}
