package com.hc.ktdm.domain;

public class LinkTable {
	private Integer linkId;
	private String name;
	private Integer num;
	
	private String cname;
	public Integer getLinkId() {
		return linkId;
	}
	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public LinkTable(Integer linkId, Integer num) {
		this();
		this.linkId = linkId;
		this.num = num;
	}
	public LinkTable(Integer linkId, Integer num, String cname) {
		this();
		this.linkId = linkId;
		this.num = num;
		this.cname = cname;
	}
	public LinkTable() {
	
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "LinkTable [linkId=" + linkId + ", name=" + name + ", num=" + num + ", cname=" + cname + "]";
	}
	
	
}
