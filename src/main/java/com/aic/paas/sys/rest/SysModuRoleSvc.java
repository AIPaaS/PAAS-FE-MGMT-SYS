package com.aic.paas.sys.rest;

import java.util.List;

import com.aic.paas.sys.bean.CSysModuRole;
import com.aic.paas.sys.bean.SysModuRole;




/**
 * SysModuRole服务
 */
public interface SysModuRoleSvc {

	
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 模块角色表[SYS_MODU_ROLE]查询列表
	 */
	public List<SysModuRole> queryListByRoleId(Long roleId, CSysModuRole cdt, String orders);
	

	
	
	
	/**
	 * 添加模块角色
	 * @param roleId
	 * @param moduIds
	 */
	public void addRoleModus(Long roleId, Long[] moduIds);
	
	
	
	
	/**
	 * 删除角色所对应的模块
	 * @param roleId
	 * @param moduIds
	 */
	public void removeRoleModus(Long roleId, Long[] moduIds);
	
	
	
		
	

}


