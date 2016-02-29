package com.aic.paas.sys.rest;

import java.util.List;

import com.aic.paas.sys.bean.CSysOrg;
import com.aic.paas.sys.bean.SysOrg;
import com.binary.jdbc.Page;


public interface SysOrgSvc {
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 操作员表[SYS_ORG]分页列表对象
	 */
	public Page<SysOrg> queryPage(Integer pageNum, Integer pageSize, CSysOrg cdt, String orders);


	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 操作员表[SYS_ORG]查询列表
	 */
	public List<SysOrg> queryList(CSysOrg cdt, String orders);
	
	
	
	/**
	 * 查询数据行数
	 * @param cdt : 条件对象
	 * @return 查询行数
	 */
	public long queryCount(CSysOrg cdt);


	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_ORG]映射对象
	 */
	public SysOrg queryById(Long id);
	
	

}
