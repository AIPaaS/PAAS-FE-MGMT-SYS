package com.aic.paas.sys.peer.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.frame.cross.bean.CSysModu;
import com.aic.paas.frame.cross.bean.SysModu;
import com.aic.paas.sys.bean.CSysModuRole;
import com.aic.paas.sys.bean.RoleModu;
import com.aic.paas.sys.bean.SysModuRole;
import com.aic.paas.sys.peer.SysModuPeer;
import com.aic.paas.sys.peer.SysModuRolePeer;
import com.aic.paas.sys.rest.SysModuRoleSvc;
import com.aic.paas.sys.rest.SysModuSvc;
import com.binary.core.bean.BMProxy;

public class SysModuRolePeerImpl implements SysModuRolePeer {

	@Autowired
	SysModuRoleSvc sysModuRoleSvc;

	@Autowired
	SysModuSvc sysModuSvc;
	@Autowired
	SysModuPeer sysModuPeer;
	
	@Override
	public List<SysModuRole> queryListByRoleId(Long roleId, CSysModuRole cdt,
			String orders) {
		return sysModuRoleSvc.queryListByRoleId(roleId, cdt, orders);
	}

	@Override
	public void addRoleModus(Long roleId, Long[] moduIds) {
		sysModuRoleSvc.addRoleModus(roleId, moduIds);
	}

	@Override
	public void removeRoleModus(Long roleId, Long[] moduIds) {
		sysModuRoleSvc.removeRoleModus(roleId, moduIds);
	}

	@Override
	public List<RoleModu> queryRoleModuList(Long roleId, CSysModu cdt,String orders) {

		List<SysModu> list = sysModuSvc.queryModuList(cdt, orders);

		List<RoleModu> rmlist = new ArrayList<RoleModu>();
		BMProxy<RoleModu> proxy = BMProxy.getInstance(RoleModu.class);

		if (list.size() > 0) {
			Long[] moduIds = new Long[list.size()];
			for (int i = 0; i < moduIds.length; i++) {
				SysModu r = list.get(i);
				moduIds[i] = r.getId();

				RoleModu om = proxy.newInstance();
				proxy.copyFrom(r);
				rmlist.add(om);
			}

			CSysModuRole mrcdt = new CSysModuRole();
			mrcdt.setModuIds(moduIds);
			List<SysModuRole> ls = sysModuRoleSvc.queryListByRoleId(roleId, mrcdt, null);

			// Key=ModuId
			Set<Long> set = new HashSet<Long>();
			for (int i = 0; i < ls.size(); i++) {
				SysModuRole mr = ls.get(i);
				set.add(mr.getModuId());
			}

			for (int i = 0; i < rmlist.size(); i++) {
				RoleModu rm = rmlist.get(i);
				Long moduId = rm.getId();
				rm.setAssign(set.contains(moduId) ? 1 : 0);

			}
		}

		return rmlist;
	}

	@Override
	public Long[] getmoduIds(CSysModu cdt) {
		List<SysModu> list = sysModuPeer.queryModuList(cdt, null);
		Long[] moduIds = new Long[list.size()];
		for(int i=0;i<list.size();i++){
			SysModu s = list.get(i);
			moduIds[i] = s.getId();
		}
		return moduIds;
	}

}
