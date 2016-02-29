package com.aic.paas.sys.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.frame.cross.bean.CSysModu;
import com.aic.paas.frame.cross.bean.CSysRole;
import com.aic.paas.frame.cross.bean.GridParams;
import com.aic.paas.frame.cross.bean.NodeProMapping;
import com.aic.paas.frame.cross.bean.SysRole;
import com.aic.paas.frame.cross.bean.TreeNode;
import com.aic.paas.frame.cross.bean.TreeParams;
import com.aic.paas.frame.util.ComponentUtil;
import com.aic.paas.frame.util.TreeNodeHandler;
import com.aic.paas.sys.bean.RoleModu;
import com.aic.paas.sys.peer.SysModuPeer;
import com.aic.paas.sys.peer.SysModuRolePeer;
import com.aic.paas.sys.peer.SysRolePeer;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.Local;
import com.binary.framework.util.ControllerUtils;
import com.binary.jdbc.Page;

@Controller
@RequestMapping("/permis/sysmodurole")
public class SysModuRoleMvc {
	
	@Autowired
	SysRolePeer sysRolePeer;
	@Autowired
	SysModuRolePeer sysModuRolePeer;
	@Autowired
	SysModuPeer sysModuPeer;
	
	/**
	 * 查询有效的SYS_ROLE
	 * @param request
	 * @param response
	 */
	@RequestMapping("/querySysRolePage")
	public void querySysRolePage(HttpServletRequest request, HttpServletResponse response){
		GridParams gp = GridParams.valueOf(request);
		CSysRole cdt = gp.getCondition(CSysRole.class);
		cdt.setStatus(1);
		
		String order = gp.getSortAlias();
		if(!BinaryUtils.isEmpty(order)) order += gp.isSortType();
		
		Page<SysRole> page = sysRolePeer.queryPage((int)gp.getPageNum(), gp.getPageSize(), cdt, order);
		ControllerUtils.returnSimpleJson(request, response, page);
	}
	
	/**
	 * 查询菜单树
	 * @param request
	 * @param response
	 */
	@RequestMapping("/querySysModuTree")
	public void querySysModuTree(HttpServletRequest request, HttpServletResponse response,Long roleId, Integer moduType){
		if(BinaryUtils.isEmpty(roleId)) {
			ControllerUtils.returnSimpleJson(request, response, new ArrayList<RoleModu>());
			return ;
		}
		
		TreeParams tp = TreeParams.valueOf(request);
		
		Long parentId = 0l;
		if(!BinaryUtils.isEmpty(tp.getParentId())) {
			parentId = Long.valueOf(tp.getParentId());
		}
		
		CSysModu cSysModu = new CSysModu();
		cSysModu.setParentId(parentId);
		cSysModu.setModuType(moduType);
		cSysModu.setStatus(1);
		
		List<RoleModu> rms = sysModuRolePeer.queryRoleModuList(roleId, cSysModu, "ORDER_NO,MODU_CODE");
		
		List<TreeNode> nodes = null;
		Boolean appAttr = tp.getAppAttributes();
		if(appAttr == null) appAttr = true;
		if(rms.size() > 0) {
			final String contextPath = Local.getCriticalObject().getContextPath();
			nodes = ComponentUtil.toTreeNodeList(rms, appAttr, false, new NodeProMapping[] {
					new NodeProMapping("id", "id", null),
					new NodeProMapping("text", "moduName", null),
					new NodeProMapping("parentid", "parentId", null),
					new NodeProMapping("leaf", "isLeaf", null)
			}, new TreeNodeHandler<RoleModu>() {
				public void handle(TreeNode node, RoleModu record) {
					int dir = record.getIsDir();//0=模块    1=目录
					if(dir == 1) {
						node.setIcon(contextPath + "/frame/images/tree/f18.gif");
					}else {
						node.setIcon(contextPath + "/frame/images/tree/com.gif");
					}
					
					node.setText("<font color='#0000cc'>["+record.getModuCode()+"]</font> "+record.getModuName()+"&nbsp;&nbsp;&nbsp;<font color='"+(record.getAssign()==1?"#00CC00":"#FF0000")+"'><b>"+(record.getAssign()==1?"已分配":"未分配")+"</b></font>");
				}
			});
		}else {
			nodes = new ArrayList<TreeNode>();
		}
		
		ControllerUtils.returnSimpleJson(request, response, nodes);
	
	}
	
	/**
	 * 分配权限
	 * @param request
	 * @param response
	 * @param roleId
	 * @param moduId
	 */
	@RequestMapping("/addRoleModu")
	public void addRoleModu(HttpServletRequest request, HttpServletResponse response,Long roleId,Long moduId){
		Long[] moduIds = new Long[]{moduId};
		sysModuRolePeer.addRoleModus(roleId, moduIds);
		ControllerUtils.returnJson(request, response, true);
	}
	
	/**
	 * 分配及子节点权限
	 * @param request
	 * @param response
	 * @param roleId
	 * @param moduId
	 */
	@RequestMapping("/addRoleModus")
	public void addRoleModus(HttpServletRequest request, HttpServletResponse response,Long roleId,String moduCode){
		CSysModu cdt = new CSysModu();
		cdt.setModuCode(moduCode+"%");
		
		Long[] moduIds = sysModuRolePeer.getmoduIds(cdt);
		sysModuRolePeer.addRoleModus(roleId, moduIds);
		
		ControllerUtils.returnJson(request, response, true);
	}
	
	/**
	 * 删除权限
	 * @param request
	 * @param response
	 * @param roleId
	 * @param moduId
	 */
	@RequestMapping("/removeLimit")
	public void removeLimit(HttpServletRequest request, HttpServletResponse response,Long roleId,Long moduId){
		Long[] moduIds = new Long[]{moduId};
		sysModuRolePeer.removeRoleModus(roleId, moduIds);
		ControllerUtils.returnJson(request, response, true);
	}
	/**
	 * 删除及子节点权限
	 * @param request
	 * @param response
	 * @param roleId
	 * @param moduCode
	 */
	@RequestMapping("/removeLimits")
	public void removeLimits(HttpServletRequest request, HttpServletResponse response,Long roleId,String moduCode){
		CSysModu cdt = new CSysModu();
		cdt.setModuCode(moduCode+"%");
		
		Long[] moduIds = sysModuRolePeer.getmoduIds(cdt);
		sysModuRolePeer.removeRoleModus(roleId, moduIds);
		
		ControllerUtils.returnJson(request, response, true);
	}
}
