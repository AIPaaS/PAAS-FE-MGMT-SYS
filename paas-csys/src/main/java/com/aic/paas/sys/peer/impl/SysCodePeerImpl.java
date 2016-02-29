package com.aic.paas.sys.peer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.frame.cross.bean.CSysCode;
import com.aic.paas.frame.cross.bean.CSysCodeDef;
import com.aic.paas.frame.cross.bean.SysCode;
import com.aic.paas.frame.cross.bean.SysCodeDef;
import com.aic.paas.sys.bean.SysCodeInfo;
import com.aic.paas.sys.peer.SysCodePeer;
import com.aic.paas.sys.rest.SysCodeSvc;
import com.binary.jdbc.Page;

public class SysCodePeerImpl implements SysCodePeer {
	
	
	@Autowired
	SysCodeSvc sysCodeSvc;
		
	
	
	
	@Override
	public Page<SysCodeDef> queryDefPage(Integer pageNum, Integer pageSize, CSysCodeDef cdt, String orders) {
		return sysCodeSvc.queryDefPage(pageNum, pageSize, cdt, orders);
	}

	@Override
	public List<SysCodeDef> queryDefList(CSysCodeDef cdt, String orders) {
		return sysCodeSvc.queryDefList(cdt, orders);
	}

	@Override
	public SysCodeDef queryDefById(Long id) {
		return sysCodeSvc.queryDefById(id);
	}

	@Override
	public List<SysCode> queryCodeList(CSysCode cdt, String orders) {
		return sysCodeSvc.queryCodeList(cdt, orders);
	}

	@Override
	public SysCodeInfo querySysCodeInfo(Long defId, CSysCode cdt, String orders) {
		return sysCodeSvc.querySysCodeInfo(defId, cdt, orders);
	}

	@Override
	public Long saveOrUpdate(SysCodeDef def, List<SysCode> codes) {
		return sysCodeSvc.saveOrUpdate(def, codes);
	}

	
	
}
