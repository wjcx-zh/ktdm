package com.hc.ktdm.model;



public class Manager {
	private Integer mid;
	private String mname;
	private String sex;
	private int age;
	private String password;
	
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
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
	
	@Override
	public String toString() {
		return "Manager [mid=" + mid + ", mname=" + mname + ", sex=" + sex + ", age=" + age + ", password=" + password
				+  "]";
	}
	
}
