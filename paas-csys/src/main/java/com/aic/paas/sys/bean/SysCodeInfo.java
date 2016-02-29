package com.aic.paas.sys.bean;

import java.io.Serializable;
import java.util.List;

import com.aic.paas.frame.cross.bean.SysCode;
import com.aic.paas.frame.cross.bean.SysCodeDef;

public class SysCodeInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private SysCodeDef def;
	private List<SysCode> codes;
	
	
	
	
	public SysCodeDef getDef() {
		return def;
	}
	public void setDef(SysCodeDef def) {
		this.def = def;
	}
	public List<SysCode> getCodes() {
		return codes;
	}
	public void setCodes(List<SysCode> codes) {
		this.codes = codes;
	}
	
	
	
	
	

}
