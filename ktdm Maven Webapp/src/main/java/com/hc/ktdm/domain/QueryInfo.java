package com.hc.ktdm.domain;

public class QueryInfo {
	private String name;
	private String sex;
	private Integer from;
	private Integer to;
	private int rows;
	private int page;
	private String sort;
	private String order;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getFrom() {
		return from;
	}
	public void setFrom(Integer from) {
		this.from = from;
	}
	public Integer getTo() {
		return to;
	}
	public void setTo(Integer to) {
		this.to = to;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	@Override
	public String toString() {
		return "QueryInfo [name=" + name + ", sex=" + sex + ", from=" + from + ", to=" + to + ", rows=" + rows
				+ ", page=" + page + ", sort=" + sort + ", order=" + order + "]";
	}
	public QueryInfo() {
		
	}
	public QueryInfo(String name, String sex, Integer from, Integer to,int rows,int page,String sort,String order) {
		this();
		this.name = name;
		this.sex = sex;
		this.from = from;
		this.to = to;
		this.rows=rows;
		this.page=page;
		this.sort=sort;
		this.order=order;
	}
	
}
