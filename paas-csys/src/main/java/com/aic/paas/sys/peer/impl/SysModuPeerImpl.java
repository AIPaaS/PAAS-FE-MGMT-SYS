package com.aic.paas.sys.peer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.frame.cross.bean.CSysModu;
import com.aic.paas.frame.cross.bean.CSysModuDrop;
import com.aic.paas.frame.cross.bean.CSysModuRes;
import com.aic.paas.frame.cross.bean.SysModu;
import com.aic.paas.frame.cross.bean.SysModuDrop;
import com.aic.paas.frame.cross.bean.SysModuRes;
import com.aic.paas.sys.peer.SysModuPeer;
import com.aic.paas.sys.rest.SysModuSvc;
import com.binary.jdbc.Page;

public class SysModuPeerImpl implements SysModuPeer {
	
	
	@Autowired
	SysModuSvc sysModuSvc;

	
	
	@Override
	public Page<SysModu> queryModuPage(Integer pageNum, Integer pageSize, CSysModu cdt, String orders) {
		return sysModuSvc.queryModuPage(pageNum, pageSize, cdt, orders);
	}

	@Override
	public List<SysModu> queryModuList(CSysModu cdt, String orders) {
		return sysModuSvc.queryModuList(cdt, orders);
	}

	@Override
	public long queryModuCount(CSysModu cdt) {
		return sysModuSvc.queryModuCount(cdt);
	}

	@Override
	public SysModu queryModuById(Long id) {
		return sysModuSvc.queryModuById(id);
	}

	@Override
	public Integer updateModuById(SysModu record, Long id) {
		return sysModuSvc.updateModuById(record, id);
	}

	@Override
	public Integer updateModuByCdt(SysModu record, CSysModu cdt) {
		return sysModuSvc.updateModuByCdt(record, cdt);
	}

	@Override
	public int[] updateModuBatch(List<SysModu> records) {
		return sysModuSvc.updateModuBatch(records);
	}

	@Override
	public Long saveOrUpdateModu(SysModu record) {
		return sysModuSvc.saveOrUpdateModu(record);
	}

	@Override
	public List<SysModuDrop> queryModuDropList(Long moduId, CSysModuDrop cdt, String orders) {
		return sysModuSvc.queryModuDropList(moduId, cdt, orders);
	}

	@Override
	public void saveOrUpdateModuDropList(Long moduId, List<SysModuDrop> records) {
		sysModuSvc.saveOrUpdateModuDropList(moduId, records);
	}

	@Override
	public List<SysModuRes> queryModuResList(Long moduId, CSysModuRes cdt, String orders) {
		return sysModuSvc.queryModuResList(moduId, cdt, orders);
	}

	@Override
	public void saveOrUpdateModuResList(Long moduId, List<SysModuRes> records) {
		sysModuSvc.saveOrUpdateModuResList(moduId, records);
	}
	

}
