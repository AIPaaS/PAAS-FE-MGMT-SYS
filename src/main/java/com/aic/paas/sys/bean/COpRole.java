package com.aic.paas.sys.bean;

import com.aic.paas.frame.cross.bean.CSysRole;
import com.binary.framework.bean.Condition;

public class COpRole implements Condition {
	
	private static final long serialVersionUID = 1L;

	private Long opId;
	private CSysRole cSysRole;

	
	public CSysRole getcSysRole() {
		return cSysRole;
	}

	public void setcSysRole(CSysRole cSysRole) {
		this.cSysRole = cSysRole;
	}

	public Long getOpId() {
		return opId;
	}

	public void setOpId(Long opId) {
		this.opId = opId;
	}

}
