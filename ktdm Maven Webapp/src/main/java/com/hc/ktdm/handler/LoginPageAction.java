package com.hc.ktdm.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class LoginPageAction {
	private Integer choose;
	
	public String execute(){
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		session.setAttribute("choose", choose);
		return "success";
	}
	
	public Integer getChoose() {
		return choose;
	}

	public void setChoose(Integer choose) {
		this.choose = choose;
	}
	
}
