package com.hc.ktdm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hc.ktdm.dao.TeacherDao;
import com.hc.ktdm.domain.User;

import com.hc.ktdm.model.Teacher;
import com.hc.ktdm.service.TeacherService;

public class TeacherServiceImpl implements TeacherService{
	private TeacherDao teacherDao;
	@Override
	public User findById(int id) {
		Teacher teacher=teacherDao.selectById(id);
		if(teacher!=null){
			User user=new User(teacher.getTid(),teacher.getTname(),teacher.getSex(),teacher.getAge(),teacher.getPassword(),teacher.getCourses());
			return user;
		}
		return null;
	}

	@Override
	public Teacher findByLoginInfo(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addTeacher(Teacher teacher) {
		return teacherDao.insertTeacher(teacher);	
	}

	@Override
	public int removeTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyTeacher(Teacher teacher) {
		
		return teacherDao.updateTeacher(teacher);
	}

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Override
	public List<User> findAll() {
		List<Teacher> teachers=teacherDao.selectAll();
		List<User> users=new ArrayList<User>();
		if(teachers!=null&&teachers.size()!=0){
			for(Teacher t:teachers){
				User user=new User(t.getTid(),t.getTname(),t.getSex(),t.getAge(),t.getPassword(),t.getCourses());
				users.add(user);
			}
			return users;
		}
		return null;
	}

	@Override
	public List<User> findByConditions(String name, String sex, Integer from, Integer to) {
		System.out.println(name+","+sex+","+from+","+to);
		Map<String,Object> map=new HashMap<String,Object>();
		List<User> users=new ArrayList<User>();
		if(name==""){
			name=null;
		}
		if(sex==""){
			sex=null;
		}
		if(name!=null){
			map.put("name", name);
		}
		if(from!=null){
			map.put("from", from);
		}
		if(to!=null){
			map.put("to", to);
		}
		if(sex!=null){
			map.put("sex", sex);
		}
		List<Teacher> thrs=teacherDao.selectByConditions(map);
		if(thrs!=null&&thrs.size()>0){
			for(Teacher thr:thrs){
				User user=new User(thr.getTid(),thr.getTname(),thr.getSex(),thr.getAge(),thr.getPassword(),thr.getCourses());
				users.add(user);
			}
			return users;
		}
		
		List<Teacher> all=teacherDao.selectAll();
		if(all!=null&&all.size()>0){
			for(Teacher thr:all){
				User user=new User(thr.getTid(),thr.getTname(),thr.getSex(),thr.getAge(),thr.getPassword(),thr.getCourses());
				users.add(user);
			}
		}
		return users;
	}

	@Override
	public int removeTeacher(int id) {
		Teacher thr=teacherDao.selectById(id);
		return teacherDao.deleteTeacher(thr);
	}

	@Override
	public int removeTeachers(List<Integer> ids) {
		int result=0;
		for(int id:ids){
			Teacher thr=teacherDao.selectById(id);
			result=(teacherDao.deleteTeacher(thr))>0?result+1:0;
		}
		return result;
	}

}
