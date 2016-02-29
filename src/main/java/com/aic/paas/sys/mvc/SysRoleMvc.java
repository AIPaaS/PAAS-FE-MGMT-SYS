package com.aic.paas.sys.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.frame.cross.bean.CSysRole;
import com.aic.paas.frame.cross.bean.GridParams;
import com.aic.paas.frame.cross.bean.SysRole;
import com.aic.paas.sys.peer.SysRolePeer;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.util.ControllerUtils;
import com.binary.jdbc.Page;

@Controller
@RequestMapping("/permis/sysrole")
public class SysRoleMvc {
	
	@Autowired
	SysRolePeer sysRolePeer;
	
	/**
	 * 查询SYS_ROLE列表
	 * @param request
	 * @param response
	 */
	@RequestMapping("/querySysRolePage")
	public void querySysRolePage(HttpServletRequest request, HttpServletResponse response){
		GridParams gp = GridParams.valueOf(request);
		CSysRole cdt = gp.getCondition(CSysRole.class);
		
		String order = gp.getSortAlias();
		if(!BinaryUtils.isEmpty(order)) order += gp.isSortType();
		
		Page<SysRole> page = sysRolePeer.queryPage((int)gp.getPageNum(), gp.getPageSize(), cdt, order);
		ControllerUtils.returnSimpleJson(request, response, page);
	}
	
	/**
	 * 根据ID查询SYSROLE对象
	 * @param request
	 * @param response
	 * @param id
	 */
	@RequestMapping("/querySysRoleById")
	public void querySysRoleById(HttpServletRequest request, HttpServletResponse response,Long id){
		SysRole sysRole = sysRolePeer.queryById(id);
		ControllerUtils.returnJson(request, response, sysRole);
	}
	/**
	 * 保存或更新操作
	 * 有id则为更新
	 * @param request
	 * @param response
	 * @param record
	 */
	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletRequest request, HttpServletResponse response,SysRole record){
		Long id = sysRolePeer.saveOrUpdate(record);
		ControllerUtils.returnJson(request, response, id);
	}
}
