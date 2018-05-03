package com.hc.ktdm.model;

import java.util.Set;

public class Teacher {
	private Integer tid;
	private String tname;
	private String sex;
	private int age;
	private String password;
	private Set<Course> courses;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
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
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", sex=" + sex + ", age=" + age + ", password=" + password
				+ ", courses=" + courses + "]";
	}
	
}
