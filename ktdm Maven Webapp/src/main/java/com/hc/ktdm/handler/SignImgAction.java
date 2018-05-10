package com.hc.ktdm.handler;

import java.io.File;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.hc.ktdm.utils.QrcodeUtil;

public class SignImgAction {
	private String result;
	private String tid;
	private String cid;
	private String cname;
	private StringBuffer url=new StringBuffer("http://192.168.20.55:8080/ktdm/signup.jsp");
	
	public String generate(){
		String content=url.append("?tid="+tid).append("&cid="+cid).append("&cname="+cname).toString();
		String path=ServletActionContext.getServletContext().getRealPath("/")+"qrcode"+File.separator+"sign.png";
		System.out.println(content+"\n"+path);
		QrcodeUtil.encoderQrcode(content, path);
		result="<img src='/ktdm/qrcode/sign.png' />";
		return "success";
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@JSON(serialize=false)
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	@JSON(serialize=false)
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	@JSON(serialize=false)
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
}
