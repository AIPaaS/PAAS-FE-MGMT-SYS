package com.aic.paas.sys.bean;

import com.aic.paas.frame.cross.bean.CSysModu;
import com.binary.framework.bean.Condition;

public class CRoleModu implements Condition{

	private static final long serialVersionUID = 1L;
	private CSysModu cSysModu;
	private Long roleId;
	
	
	public CSysModu getcSysModu() {
		return cSysModu;
	}
	public void setcSysModu(CSysModu cSysModu) {
		this.cSysModu = cSysModu;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
}
