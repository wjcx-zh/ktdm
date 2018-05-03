package com.hc.ktdm.model;

import java.util.Date;

public class NameTable {
	private Integer id;
	private String sname;
	private String cname;
	private String tname;
	private Integer snum;
	private Date signtime;
	private Type type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Date getSigntime() {
		return signtime;
	}
	public void setSigntime(Date signtime) {
		this.signtime = signtime;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "NameTable [id=" + id + ", sname=" + sname + ", cname=" + cname + ", tname=" + tname + ", snum=" + snum
				+ ", signtime=" + signtime + ", type=" + type + "]";
	}
	
	
	
}
