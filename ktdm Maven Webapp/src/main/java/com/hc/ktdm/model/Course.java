package com.hc.ktdm.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Course {
	private Integer cid;
	private String cname;
	
	private Set<Student> students;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@JsonIgnore
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname +"]";
	}
	
}
