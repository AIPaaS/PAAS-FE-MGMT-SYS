package com.aic.paas.sys.peer;

import com.aic.paas.frame.cross.bean.CWsMerchent;
import com.aic.paas.frame.cross.bean.WsMerchent;
import com.binary.jdbc.Page;

public interface MerchentPeer {
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<WsMerchent> queryMntPage(Integer pageNum, Integer pageSize, CWsMerchent cdt, String orders);


	
	/**
	 * 审核租户
	 * @param id
	 * @param checkType 1=通过    2=退回
	 * @param checkDesc
	 */
	public void checkMnt(Long id, Integer checkType, String checkDesc);
	
	
	

}
