package com.aic.paas.sys.peer;


import java.util.List;

import com.aic.paas.frame.cross.bean.CSysMenu;
import com.aic.paas.frame.cross.bean.SysMenu;
import com.binary.jdbc.Page;


/**
 * SysMenu服务
 */
public interface SysMenuPeer {


	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 系统菜单表[SYS_MENU]分页列表对象
	 */
	public Page<SysMenu> queryPage(Integer pageNum, Integer pageSize, CSysMenu cdt, String orders);


	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 系统菜单表[SYS_MENU]查询列表
	 */
	public List<SysMenu> queryList(CSysMenu cdt, String orders);


	/**
	 * 查询数据行数
	 * @param cdt : 条件对象
	 * @return 查询行数
	 */
	public long queryCount(CSysMenu cdt);


	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 系统菜单表[SYS_MENU]映射对象
	 */
	public SysMenu queryById(Long id);


	
	/**
	 * 跟据主键ID更新记录
	 * @param record : 更新的系统菜单表[SYS_MENU]映射对象
	 * @param id : 主键ID
	 * @return 新插入记录的主键ID列表
	 */
	public Integer updateById(SysMenu record, Long id);
	
	
	
	/**
	 * 跟据条件更新记录
	 * @param record : 更新的系统菜单表[SYS_MENU]映射对象
	 * @param cdt : 条件对象
	 * @return 更新记录数
	 */
	public Integer updateByCdt(SysMenu record, CSysMenu cdt);
	
	
	
	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : SysMenu数据记录
	 * @return 当前记录主键[id]值
	 */
	public Long saveOrUpdate(SysMenu record);


	
	
	

}


