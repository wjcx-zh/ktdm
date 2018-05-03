package com.hc.ktdm.handler;

import org.apache.struts2.json.annotations.JSON;

import com.hc.ktdm.service.NameTableService;

public class SignUpInfoAction {
	private NameTableService nameTableService;
	private Object result;
	
	public String info(){
		result=nameTableService.findAllInfo();
		return "success";
	}
	
	@JSON(serialize=false)
	public NameTableService getNameTableService() {
		return nameTableService;
	}

	public void setNameTableService(NameTableService nameTableService) {
		this.nameTableService = nameTableService;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
	
}
