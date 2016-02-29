package com.aic.paas.sys.peer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.sys.bean.CSysRegion;
import com.aic.paas.sys.bean.SysRegion;
import com.aic.paas.sys.peer.SysRegionPeer;
import com.aic.paas.sys.rest.SysRegionSvc;
import com.binary.jdbc.Page;

public class SysRegionPeerImpl implements SysRegionPeer {
	
	
	@Autowired
	SysRegionSvc sysRegionSvc;
	
	
	

	@Override
	public Page<SysRegion> queryPage(Integer pageNum, Integer pageSize, CSysRegion cdt, String orders) {
		return sysRegionSvc.queryPage(pageNum, pageSize, cdt, orders);
	}

	
	
	
	@Override
	public List<SysRegion> queryList(CSysRegion cdt, String orders) {
		return sysRegionSvc.queryList(cdt, orders);
	}
	
	

	@Override
	public long queryCount(CSysRegion cdt) {
		return sysRegionSvc.queryCount(cdt);
	}
	
	
	

	@Override
	public SysRegion queryById(Long id) {
		return sysRegionSvc.queryById(id);
	}
	
	
	

}



