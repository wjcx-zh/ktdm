package com.hc.ktdm.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Student {
	private Integer sid;
	private String sname;
	private Integer snum;
	private String sex;
	private Set<Course> courses;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getSnum() {
		return snum;
	}
	public void setSnum(Integer snum) {
		this.snum = snum;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", snum=" + snum + ", sex=" + sex + "]";
	}
	
}
