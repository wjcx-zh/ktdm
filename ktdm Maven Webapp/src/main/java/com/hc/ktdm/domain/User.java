package com.hc.ktdm.domain;

import java.util.Set;

import com.hc.ktdm.model.Course;

public class User {
	private Integer uid;
	private String uname;
	private String sex;
	private int age;
	private String password;
	private Set<Course> courses;
	
	
	public User(Integer uid, String uname, String sex, int age, String password, Set<Course> courses) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.sex = sex;
		this.age = age;
		this.password = password;
		this.courses = courses;
	}
	public User() {
		
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", sex=" + sex + ", age=" + age + ", password=" + password
				+ ", courses=" + courses + "]";
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
}
