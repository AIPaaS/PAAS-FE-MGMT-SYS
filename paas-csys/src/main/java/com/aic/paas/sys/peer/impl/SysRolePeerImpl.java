package com.aic.paas.sys.peer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.frame.cross.bean.CSysRole;
import com.aic.paas.frame.cross.bean.SysRole;
import com.aic.paas.sys.peer.SysRolePeer;
import com.aic.paas.sys.rest.SysRoleSvc;
import com.binary.jdbc.Page;

public class SysRolePeerImpl implements SysRolePeer {
	
	
	@Autowired
	SysRoleSvc sysRoleSvc;
	

	@Override
	public Page<SysRole> queryPage(Integer pageNum, Integer pageSize, CSysRole cdt, String orders) {
		return sysRoleSvc.queryPage(pageNum, pageSize, cdt, orders);
	}
	
	
	

	@Override
	public List<SysRole> queryList(CSysRole cdt, String orders) {
		return sysRoleSvc.queryList(cdt, orders);
	}
	
	
	

	@Override
	public long queryCount(CSysRole cdt) {
		return sysRoleSvc.queryCount(cdt);
	}

	
	
	
	@Override
	public SysRole queryById(Long id) {
		return sysRoleSvc.queryById(id);
	}
	
	
	
	

	@Override
	public Integer updateById(SysRole record, Long id) {
		return sysRoleSvc.updateById(record, id);
	}

	
	
	
	@Override
	public Integer updateByCdt(SysRole record, CSysRole cdt) {
		return sysRoleSvc.updateByCdt(record, cdt);
	}
	
	
	

	@Override
	public Long saveOrUpdate(SysRole record) {
		return sysRoleSvc.saveOrUpdate(record);
	}
	
	
	
	

}
