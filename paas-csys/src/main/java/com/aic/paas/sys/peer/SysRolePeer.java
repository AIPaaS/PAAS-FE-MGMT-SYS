package com.aic.paas.sys.peer;


import java.util.List;

import com.aic.paas.frame.cross.bean.CSysRole;
import com.aic.paas.frame.cross.bean.SysRole;
import com.binary.jdbc.Page;


/**
 * SysRole服务
 */
public interface SysRolePeer {


	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 角色表[SYS_ROLE]分页列表对象
	 */
	public Page<SysRole> queryPage(Integer pageNum, Integer pageSize, CSysRole cdt, String orders);


	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 角色表[SYS_ROLE]查询列表
	 */
	public List<SysRole> queryList(CSysRole cdt, String orders);


	/**
	 * 查询数据行数
	 * @param cdt : 条件对象
	 * @return 查询行数
	 */
	public long queryCount(CSysRole cdt);


	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 角色表[SYS_ROLE]映射对象
	 */
	public SysRole queryById(Long id);
	

	/**
	 * 跟据主键ID更新记录
	 * @param record : 更新的角色表[SYS_ROLE]映射对象
	 * @param id : 主键ID
	 * @return 新插入记录的主键ID列表
	 */
	public Integer updateById(SysRole record, Long id);


	/**
	 * 跟据条件更新记录
	 * @param record : 更新的角色表[SYS_ROLE]映射对象
	 * @param cdt : 条件对象
	 * @return 更新记录数
	 */
	public Integer updateByCdt(SysRole record, CSysRole cdt);


	
	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : SysRole数据记录
	 * @return 当前记录主键[id]值
	 */
	public Long saveOrUpdate(SysRole record);
	
	
	


}


