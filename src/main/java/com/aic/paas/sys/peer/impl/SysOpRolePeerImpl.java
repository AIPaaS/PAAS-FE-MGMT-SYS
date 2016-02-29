package com.aic.paas.sys.peer.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.frame.cross.bean.CSysOpRole;
import com.aic.paas.frame.cross.bean.SysOpRole;
import com.aic.paas.frame.cross.bean.SysRole;
import com.aic.paas.sys.bean.COpRole;
import com.aic.paas.sys.bean.OpRole;
import com.aic.paas.sys.peer.SysOpRolePeer;
import com.aic.paas.sys.rest.SysOpRoleSvc;
import com.aic.paas.sys.rest.SysRoleSvc;
import com.binary.jdbc.Page;

public class SysOpRolePeerImpl implements SysOpRolePeer {
	
	
	@Autowired
	SysOpRoleSvc sysOpRoleSvc;
	
	@Autowired
	SysRoleSvc sysRoleSvc;

	@Override
	public List<SysOpRole> queryListByOpId(Long opId, CSysOpRole cdt, String orders) {
		return sysOpRoleSvc.queryListByOpId(opId, cdt, orders);
	}

	
	@Override
	public void addOpRoles(Long opId, Long[] roleIds) {
		sysOpRoleSvc.addOpRoles(opId, roleIds);
	}

	
	
	
	@Override
	public void removeOpRoles(Long opId, Long[] roleIds) {
		sysOpRoleSvc.removeOpRoles(opId, roleIds);
	}

	
	
	
	@Override
	public Integer setMasterRole(Long opId, Long roleId) {
		return sysOpRoleSvc.setMasterRole(opId, roleId);
	}
	
	
	@Override
	public Page<OpRole> queryOpRolePage(Integer pageNum, Integer pageSize, Long opId, COpRole cdt, String orders) {
		if(cdt == null) 
		cdt = new COpRole();
		cdt.getcSysRole().setDataStatus(1);
		
		Page<SysRole> p = sysRoleSvc.queryPage(pageNum, pageSize, cdt.getcSysRole(), orders);
		List<SysRole> list = p.getData();
		
		
		List<OpRole> orlist = new ArrayList<OpRole>();
		
		if(list.size() > 0) {
			Long[] roleIds = new Long[list.size()];
			for(int i=0; i<roleIds.length; i++) {
				SysRole r = list.get(i);
				roleIds[i] = r.getId();
				
				OpRole or = new OpRole();
				or.setRole(r);
				orlist.add(or);
			}
			
			CSysOpRole orcdt = new CSysOpRole();
			orcdt.setRoleIds(roleIds);
			List<SysOpRole> ls = sysOpRoleSvc.queryListByOpId(opId, orcdt, null);
			
			//Key=RoleId
			Map<Long, SysOpRole> map = new HashMap<Long, SysOpRole>();
			for(int i=0; i<ls.size(); i++) {
				SysOpRole or = ls.get(i);
				map.put(or.getRoleId(), or);
			}
			
			
			for(int i=0; i<orlist.size(); i++) {
				OpRole or = orlist.get(i);
				Long roleId = or.getRole().getId();
				SysOpRole sor = map.get(roleId);
				or.setAssign(sor!=null ? 1 : 0);
				if(sor == null) sor = new SysOpRole();
				or.setOpRole(sor);
			}
		}
		
		return new Page<OpRole>(p.getPageNum(), p.getPageSize(), p.getTotalRows(), p.getTotalPages(), orlist);
	}
	

}
