package com.aic.paas.sys.rest;


import java.util.List;

import com.aic.paas.sys.bean.CSysLoginLog;
import com.aic.paas.sys.bean.SysLoginLog;
import com.binary.jdbc.Page;


/**
 * SysLoginLog服务
 */
public interface SysLoginLogSvc {


	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 用户登录日志[SYS_LOGIN_LOG]分页列表对象
	 */
	public Page<SysLoginLog> queryPage(Integer pageNum, Integer pageSize, CSysLoginLog cdt, String orders);


	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 用户登录日志[SYS_LOGIN_LOG]查询列表
	 */
	public List<SysLoginLog> queryList(CSysLoginLog cdt, String orders);


	/**
	 * 查询数据行数
	 * @param cdt : 条件对象
	 * @return 查询行数
	 */
	public long queryCount(CSysLoginLog cdt);


	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 用户登录日志[SYS_LOGIN_LOG]映射对象
	 */
	public SysLoginLog queryById(Long id);


	/**
	 * 插入记录
	 * @param record : 用户登录日志[SYS_LOGIN_LOG]映射对象
	 * @return 新插入记录的主键ID
	 */
	public Long save(SysLoginLog record);


	/**
	 * 批量插入记录
	 * @param records : 用户登录日志[SYS_LOGIN_LOG]映射对象列表
	 * @return 新插入记录的主键ID列表
	 */
	public long[] saveBatch(List<SysLoginLog> records);


	/**
	 * 跟据主键ID更新记录
	 * @param record : 更新的用户登录日志[SYS_LOGIN_LOG]映射对象
	 * @param id : 主键ID
	 * @return 新插入记录的主键ID列表
	 */
	public Integer updateById(SysLoginLog record, Long id);


	/**
	 * 跟据条件更新记录
	 * @param record : 更新的用户登录日志[SYS_LOGIN_LOG]映射对象
	 * @param cdt : 条件对象
	 * @return 更新记录数
	 */
	public Integer updateByCdt(SysLoginLog record, CSysLoginLog cdt);


	/**
	 * 批量更新记录(跟据记录主键ID)
	 * @param records : 更新的用户登录日志[SYS_LOGIN_LOG]映射对象列表
	 * @return 更新记录数列表
	 */
	public int[] updateBatch(List<SysLoginLog> records);


	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : SysLoginLog数据记录
	 * @return 当前记录主键[id]值
	 */
	public Long saveOrUpdate(SysLoginLog record);

	

}


