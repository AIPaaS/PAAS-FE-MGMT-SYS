package com.aic.paas.sys.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.frame.cross.bean.GridParams;
import com.aic.paas.sys.bean.COpRole;
import com.aic.paas.sys.bean.OpRole;
import com.aic.paas.sys.peer.SysOpRolePeer;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.util.ControllerUtils;
import com.binary.jdbc.Page;

@Controller
@RequestMapping("/permis/sysoprole")
public class SysOpRoleMvc {
	
	@Autowired
	SysOpRolePeer sysOpRolePeer;
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 角色表[SYS_ROLE]分页列表对象
	 */
	@RequestMapping("/queryOpRolePage")
	public void queryOpRolePage(HttpServletRequest request, HttpServletResponse response) {
		GridParams gp = GridParams.valueOf(request);
		COpRole cdt = gp.getCondition(COpRole.class);
		
		String order = gp.getSortAlias();
		if(!BinaryUtils.isEmpty(order)) order += gp.isSortType();
		
		Page<OpRole> page = sysOpRolePeer.queryOpRolePage((int)gp.getPageNum(), gp.getPageSize(), cdt.getOpId(), cdt, order);
		ControllerUtils.returnSimpleJson(request, response, page);
	}

	/**
	 * 添加用户角色
	 * @param opId
	 * @param roleIds
	 */
	@RequestMapping("/addOpRoles")
	public void addOpRoles(HttpServletRequest request, HttpServletResponse response,Long opId,Long[] roleIds){
		sysOpRolePeer.addOpRoles(opId, roleIds);
		ControllerUtils.returnJson(request, response, true);
	}
	/**
	 * 删除用户所对应的角色
	 * @param opId
	 * @param roleIds
	 */
	@RequestMapping("/removeOpRoles")
	public void removeOpRoles(HttpServletRequest request, HttpServletResponse response,Long opId,Long[] roleIds){
		sysOpRolePeer.removeOpRoles(opId, roleIds);
		ControllerUtils.returnJson(request, response, true);
	}
	
	@RequestMapping("/setMasterRole") 
	public void setMasterRole(HttpServletRequest request, HttpServletResponse response,Long opId,Long roleId){
		sysOpRolePeer.setMasterRole(opId, roleId);
		ControllerUtils.returnJson(request, response, true);
	}
}
