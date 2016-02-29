package com.aic.paas.sys.peer;


import java.util.List;

import com.aic.paas.frame.cross.bean.CSysOpRole;
import com.aic.paas.frame.cross.bean.SysOpRole;
import com.aic.paas.sys.bean.COpRole;
import com.aic.paas.sys.bean.OpRole;
import com.binary.jdbc.Page;


/**
 * SysOpRole服务
 */
public interface SysOpRolePeer {


	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 操作员角色表[SYS_OP_ROLE]查询列表
	 */
	public List<SysOpRole> queryListByOpId(Long opId, CSysOpRole cdt, String orders);


	
	
	
	/**
	 * 添加用户角色
	 * @param opId
	 * @param roleIds
	 */
	public void addOpRoles(Long opId, Long[] roleIds);
	
	
	
	
	/**
	 * 删除用户所对应的角色
	 * @param opId
	 * @param roleIds
	 */
	public void removeOpRoles(Long opId, Long[] roleIds);
	
	
	
	
	/**
	 * 设置主角色
	 * @param opId
	 * @param roleId
	 * @return
	 */
	public Integer setMasterRole(Long opId, Long roleId);
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 角色表[SYS_ROLE]分页列表对象
	 */
	public Page<OpRole> queryOpRolePage(Integer pageNum, Integer pageSize, Long opId, COpRole cdt, String orders);

	

}


