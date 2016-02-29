package com.aic.paas.sys.peer;

import java.util.List;

import com.aic.paas.frame.cross.bean.CSysOp;
import com.aic.paas.frame.cross.bean.CSysOpRole;
import com.aic.paas.frame.cross.bean.CSysRole;
import com.aic.paas.frame.cross.bean.SysOp;
import com.aic.paas.frame.cross.bean.SysRole;
import com.binary.jdbc.Page;

public interface SysOpPeer {
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 操作员表[SYS_OP]分页列表对象
	 */
	public Page<SysOp> queryPage(Integer pageNum, Integer pageSize, CSysOp cdt, String orders);


	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 操作员表[SYS_OP]查询列表
	 */
	public List<SysOp> queryList(CSysOp cdt, String orders);


	/**
	 * 查询数据行数
	 * @param cdt : 条件对象
	 * @return 查询行数
	 */
	public long queryCount(CSysOp cdt);


	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 操作员表[SYS_OP]映射对象
	 */
	public SysOp queryById(Long id);


	

	/**
	 * 跟据主键ID更新记录
	 * @param record : 更新的操作员表[SYS_OP]映射对象
	 * @param id : 主键ID
	 * @return 新插入记录的主键ID列表
	 */
	public Integer updateById(SysOp record, Long id);


	/**
	 * 跟据条件更新记录
	 * @param record : 更新的操作员表[SYS_OP]映射对象
	 * @param cdt : 条件对象
	 * @return 更新记录数
	 */
	public Integer updateByCdt(SysOp record, CSysOp cdt);


	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : SysOp数据记录
	 * @return 当前记录主键[id]值
	 */
	public Long saveOrUpdate(SysOp record);


	
	
	
	/**
	 * 获取用户关联角列表
	 * @param opId : 用户ID
	 * @param rltcdt : 关联条件
	 * @param rolecdt : 角色条件
	 * @param orders : 排序
	 * @return
	 */
	public List<SysRole> queryRltRoleList(Long opId, CSysOpRole rltcdt, CSysRole rolecdt, String orders);
	
	
}
