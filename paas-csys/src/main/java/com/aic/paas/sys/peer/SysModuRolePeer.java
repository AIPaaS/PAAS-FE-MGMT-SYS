package com.aic.paas.sys.peer;

import java.util.List;

import com.aic.paas.frame.cross.bean.CSysModu;
import com.aic.paas.sys.bean.CSysModuRole;
import com.aic.paas.sys.bean.RoleModu;
import com.aic.paas.sys.bean.SysModuRole;




/**
 * SysModuRole服务
 */
public interface SysModuRolePeer {

	
	
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
	
	
	/**
	 * 查询列表
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return MODU_ROLE列表对象
	 */
	public List<RoleModu> queryRoleModuList( Long roleId, CSysModu cdt, String orders);
	
	/**
	 * 根据条件查询moudIds
	 * @param cdt
	 * @return
	 */
	public Long[] getmoduIds(CSysModu cdt);

}


