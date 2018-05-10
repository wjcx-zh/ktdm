package com.hc.ktdm.handler;

import java.util.Date;

import com.hc.ktdm.domain.User;
import com.hc.ktdm.model.NameTable;
import com.hc.ktdm.model.Teacher;
import com.hc.ktdm.model.Type;
import com.hc.ktdm.service.NameTableService;
import com.hc.ktdm.service.SignUpService;
import com.hc.ktdm.service.TeacherService;
import com.hc.ktdm.service.TypeService;

public class SignUpAction {
	private Integer tid;
	private Integer cid;
	private String cname;
	private String name;
	private Integer snum;
	private SignUpService signUpService;
	private NameTableService nameTableService;
	private TeacherService teacherService;
	private TypeService typeService;
	public String execute(){
		/*System.out.println(ServletActionContext.getRequest().getParameter("tid"));
		System.out.println(ServletActionContext.getRequest().getParameter("cid"));
		System.out.println(ServletActionContext.getRequest().getParameter("cname"));
		*/
		System.out.println(tid+";"+cid+";"+cname);
		User user =teacherService.findById(tid);
		int typeId=signUpService.Exists(name, snum, cid);
		Type tp=typeService.findById(typeId);
		if(nameTableService.Exists(name, snum)){
			return "successed";
		}
		NameTable nameTable=new NameTable();
		nameTable.setCname(cname);
		nameTable.setSigntime(new Date());
		nameTable.setSname(name);
		nameTable.setTname(user.getUname());
		nameTable.setType(tp);
		nameTable.setSnum(snum);
		nameTableService.addToTable(nameTable);
		return "success";
	}
	
	public Integer getTid() {
		return tid;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSnum() {
		return snum;
	}
	public void setSnum(Integer snum) {
		this.snum = snum;
	}
	public SignUpService getSignUpService() {
		return signUpService;
	}
	public void setSignUpService(SignUpService signUpService) {
		this.signUpService = signUpService;
	}


	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	public NameTableService getNameTableService() {
		return nameTableService;
	}

	public void setNameTableService(NameTableService nameTableService) {
		this.nameTableService = nameTableService;
	}

	
}
