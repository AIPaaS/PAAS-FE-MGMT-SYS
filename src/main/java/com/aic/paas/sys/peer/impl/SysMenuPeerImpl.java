package com.aic.paas.sys.peer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.frame.cross.bean.CSysMenu;
import com.aic.paas.frame.cross.bean.SysMenu;
import com.aic.paas.sys.peer.SysMenuPeer;
import com.aic.paas.sys.rest.SysMenuSvc;
import com.binary.jdbc.Page;

public class SysMenuPeerImpl implements SysMenuPeer {
	
	
	@Autowired
	SysMenuSvc sysMenuSvc;
	

	@Override
	public Page<SysMenu> queryPage(Integer pageNum, Integer pageSize, CSysMenu cdt, String orders) {
		return sysMenuSvc.queryPage(pageNum, pageSize, cdt, orders);
	}
	
	

	@Override
	public List<SysMenu> queryList(CSysMenu cdt, String orders) {
		return sysMenuSvc.queryList(cdt, orders);
	}

	
	
	@Override
	public long queryCount(CSysMenu cdt) {
		return sysMenuSvc.queryCount(cdt);
	}

	
	
	@Override
	public SysMenu queryById(Long id) {
		return sysMenuSvc.queryById(id);
	}

	
	
	
	@Override
	public Integer updateById(SysMenu record, Long id) {
		return sysMenuSvc.updateById(record, id);
	}
	
	

	@Override
	public Integer updateByCdt(SysMenu record, CSysMenu cdt) {
		return sysMenuSvc.updateByCdt(record, cdt);
	}

	@Override
	public Long saveOrUpdate(SysMenu record) {
		return sysMenuSvc.saveOrUpdate(record);
	}
	
	
	
	
	

}
