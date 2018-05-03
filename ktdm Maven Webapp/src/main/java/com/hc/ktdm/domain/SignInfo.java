package com.hc.ktdm.domain;

public class SignInfo {
	private Integer tid;
	private Integer cid;
	private String cname;
	public Integer getTid() {
		return tid;
	}
	@Override
	public String toString() {
		return "SignInfo [tid=" + tid + ", cid=" + cid + ", cname=" + cname + "]";
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
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
}
