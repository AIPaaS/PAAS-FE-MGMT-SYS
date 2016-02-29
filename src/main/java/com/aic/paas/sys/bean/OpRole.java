package com.aic.paas.sys.bean;

import com.aic.paas.frame.cross.bean.SysOpRole;
import com.aic.paas.frame.cross.bean.SysRole;

public class OpRole {

	
	private SysRole role;
	private SysOpRole opRole;	//如果未分配则为空
	
	private Integer assign; //是否已分配
	
	
	
	public SysRole getRole() {
		return role;
	}
	public void setRole(SysRole role) {
		this.role = role;
	}
	public Integer getAssign() {
		return assign;
	}
	public void setAssign(Integer assign) {
		this.assign = assign;
	}
	public SysOpRole getOpRole() {
		return opRole;
	}
	public void setOpRole(SysOpRole opRole) {
		this.opRole = opRole;
	}
	
	
	
	
	
	
}
