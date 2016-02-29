package com.aic.paas.sys.bean;

import com.aic.paas.frame.cross.bean.SysModu;

public class RoleModu extends SysModu {
	private static final long serialVersionUID = 1L;
	
	
	private Integer assign;//是否分配角色
	
	
	
	public Integer getAssign() {
		return assign;
	}
	public void setAssign(Integer assign) {
		this.assign = assign;
	}
	

}
