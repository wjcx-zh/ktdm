package com.hc.ktdm.handler;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hc.ktdm.model.Manager;
import com.hc.ktdm.model.Teacher;
import com.hc.ktdm.service.LoginService;
import com.hc.ktdm.service.NameTableService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String name;
	private String password;
	private Integer choose;
	private LoginService<?> loginService;
	
	public String execute(){
		Teacher teacher=(Teacher) loginService.Exists(name, password);
		HttpSession session=ServletActionContext.getRequest().getSession();
		if(teacher!=null){
			session.setAttribute("teacher", teacher);
			return "success";
		}
		
		return "input";
	}
	
	public String backstageLogin(){
		Manager manager=(Manager) loginService.Exists(name, password);
		HttpSession session=ServletActionContext.getRequest().getSession();
		if(manager!=null){
			session.setAttribute("manager", manager);
			return "success";
		}
		
		return "input";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getChoose() {
		return choose;
	}
	public void setChoose(Integer choose) {
		this.choose = choose;
	}
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}
