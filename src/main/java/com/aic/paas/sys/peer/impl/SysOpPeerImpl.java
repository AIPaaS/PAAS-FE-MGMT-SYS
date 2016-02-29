package com.aic.paas.sys.peer.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.frame.cross.bean.CSysOp;
import com.aic.paas.frame.cross.bean.CSysOpRole;
import com.aic.paas.frame.cross.bean.CSysRole;
import com.aic.paas.frame.cross.bean.SysOp;
import com.aic.paas.frame.cross.bean.SysOpRole;
import com.aic.paas.frame.cross.bean.SysRole;
import com.aic.paas.sys.peer.SysOpPeer;
import com.aic.paas.sys.rest.SysOpRoleSvc;
import com.aic.paas.sys.rest.SysOpSvc;
import com.aic.paas.sys.rest.SysRoleSvc;
import com.binary.core.util.BinaryUtils;
import com.binary.jdbc.Page;

public class SysOpPeerImpl implements SysOpPeer {

	
	@Autowired
	SysOpSvc sysOpSvc;

	
	@Autowired
	SysOpRoleSvc sysOpRoleSvc;
	
	@Autowired
	SysRoleSvc sysRoleSvc;
	
	
	
	
	@Override
	public Page<SysOp> queryPage(Integer pageNum, Integer pageSize, CSysOp cdt, String orders) {
		return sysOpSvc.queryPage(pageNum, pageSize, cdt, orders);
	}

	
	@Override
	public List<SysOp> queryList(CSysOp cdt, String orders) {
		return sysOpSvc.queryList(cdt, orders);
	}

	@Override
	public long queryCount(CSysOp cdt) {
		return sysOpSvc.queryCount(cdt);
	}

	@Override
	public SysOp queryById(Long id) {
		return sysOpSvc.queryById(id);
	}


	@Override
	public Integer updateById(SysOp record, Long id) {
		return sysOpSvc.updateById(record, id);
	}

	@Override
	public Integer updateByCdt(SysOp record, CSysOp cdt) {
		return sysOpSvc.updateByCdt(record, cdt);
	}

	
	@Override
	public Long saveOrUpdate(SysOp record) {
		if(BinaryUtils.isEmpty(record.getId())){
			record.setLoginFlag(0);
			record.setSuperUserFlag(0);
		}
		return sysOpSvc.saveOrUpdate(record);
	}

	
	

	@Override
	public List<SysRole> queryRltRoleList(Long opId, CSysOpRole rltcdt, CSysRole rolecdt, String orders) {
		List<SysOpRole> rltlist = sysOpRoleSvc.queryListByOpId(opId, rltcdt, orders);

		if (rltlist.size() == 0) return new ArrayList<SysRole>();

		Long[] roleIds = new Long[rltlist.size()];
		for (int i = 0; i < rltlist.size(); i++) {
			SysOpRole rlt = (SysOpRole) rltlist.get(i);
			roleIds[i] = rlt.getRoleId();
		}

		if (rolecdt == null) rolecdt = new CSysRole();
		rolecdt.setIds(roleIds);

		List<SysRole> list = sysRoleSvc.queryList(rolecdt, orders);

		return list;
	}
}


