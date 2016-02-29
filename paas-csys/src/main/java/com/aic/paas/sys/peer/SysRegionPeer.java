package com.aic.paas.sys.peer;


import java.util.List;

import com.aic.paas.sys.bean.CSysRegion;
import com.aic.paas.sys.bean.SysRegion;
import com.binary.jdbc.Page;


/**
 * SysRegion服务
 */
public interface SysRegionPeer {


	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 区域表[SYS_REGION]分页列表对象
	 */
	public Page<SysRegion> queryPage(Integer pageNum, Integer pageSize, CSysRegion cdt, String orders);


	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 区域表[SYS_REGION]查询列表
	 */
	public List<SysRegion> queryList(CSysRegion cdt, String orders);


	/**
	 * 查询数据行数
	 * @param cdt : 条件对象
	 * @return 查询行数
	 */
	public long queryCount(CSysRegion cdt);


	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 区域表[SYS_REGION]映射对象
	 */
	public SysRegion queryById(Long id);


	

}


