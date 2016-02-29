package com.aic.paas.sys.peer.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.frame.cross.bean.CWsMerchent;
import com.aic.paas.frame.cross.bean.WsMerchent;
import com.aic.paas.frame.cross.rest.MerchentSvc;
import com.aic.paas.sys.peer.EmailSenderPeer;
import com.aic.paas.sys.peer.MerchentPeer;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.exception.ServiceException;
import com.binary.jdbc.Page;

public class MerchentPeerImpl implements MerchentPeer {
	
	
	@Autowired
	MerchentSvc merchentSvc;
	
	@Autowired
	EmailSenderPeer emailSendPeer;
	
	

	@Override
	public Page<WsMerchent> queryMntPage(Integer pageNum, Integer pageSize, CWsMerchent cdt, String orders) {
		return merchentSvc.queryPage(pageNum, pageSize, cdt, orders);
	}

	

	@Override
	public void checkMnt(Long id, Integer checkType, String checkDesc) {
		BinaryUtils.checkEmpty(id, "id");
		BinaryUtils.checkEmpty(checkType, "checkType");
		BinaryUtils.checkEmpty(checkDesc, "checkDesc");
		
		WsMerchent mnt = merchentSvc.queryById(id);
		if(mnt == null) throw new ServiceException(" not found mnt by id '"+id+"'! ");
		
		merchentSvc.checkMnt(id, checkType, checkDesc);
		
		//发送结果邮件
		emailSendPeer.sendMntCheckResult(mnt.getMntCode(), checkType, checkDesc, mnt.getContactEmail());
	}

	
	
	
	
	

}
