package com.aic.paas.sys.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.frame.cross.bean.CSysMenu;
import com.aic.paas.frame.cross.bean.NodeProMapping;
import com.aic.paas.frame.cross.bean.SysMenu;
import com.aic.paas.frame.cross.bean.TreeNode;
import com.aic.paas.frame.cross.bean.TreeParams;
import com.aic.paas.frame.util.ComponentUtil;
import com.aic.paas.frame.util.TreeNodeHandler;
import com.aic.paas.sys.peer.SysMenuPeer;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.Local;
import com.binary.framework.util.ControllerUtils;


@Controller
@RequestMapping("/base/sysmenu")
public class SysMenuMvc {
	
	@Autowired
	SysMenuPeer sysMenuPeer;
	
	/**
	 * 查询菜单树
	 * @param request
	 * @param response
	 */
	@RequestMapping("/querySysMenuTree")
	public void querySysModuTree(HttpServletRequest request, HttpServletResponse response, Integer menuType){

		TreeParams tp = TreeParams.valueOf(request);
		
		Long parentId = 0l;
		if(!BinaryUtils.isEmpty(tp.getParentId())) {
			parentId = Long.valueOf(tp.getParentId());
		}
		CSysMenu cdt = new CSysMenu();
		cdt.setParentId(parentId);
		cdt.setMenuType(menuType);
		List<SysMenu> treeList = sysMenuPeer.queryList(cdt, "ORDER_NO,MENU_CODE");
		
		List<TreeNode> nodes = null;
		Boolean appAttr = tp.getAppAttributes();
		if(appAttr == null) appAttr = true;
		if(treeList.size() > 0) {
			final String contextPath = Local.getCriticalObject().getContextPath();
			nodes = ComponentUtil.toTreeNodeList(treeList, appAttr, false, new NodeProMapping[] {
					new NodeProMapping("id", "id", null),
					new NodeProMapping("text", "menuName", null),
					new NodeProMapping("parentid", "parentId", null),
					new NodeProMapping("leaf", "isLeaf", null)
			}, new TreeNodeHandler<SysMenu>() {
				public void handle(TreeNode node, SysMenu record) {
					int dir = record.getIsDir();//0=模块    1=目录
					if(dir == 1) {
						node.setIcon(contextPath + "/frame/images/tree/f18.gif");
					}else {
						node.setIcon(contextPath + "/frame/images/tree/com.gif");
					}
					if(record.getStatus()==0){
						node.setText("<font class='ux-cell-color-gray'>["+record.getMenuCode()+"] "+record.getMenuName()+"</font>");
					}else{
						node.setText("<font color='#0000cc'>["+record.getMenuCode()+"]</font> "+record.getMenuName());
					}
				}
			});
		}else {
			nodes = new ArrayList<TreeNode>();
		}
		
		ControllerUtils.returnSimpleJson(request, response, nodes);
	
	}
	/**
	 * 根据Id查询SysMenu
	 * @param request
	 * @param response
	 * @param id
	 */
	@RequestMapping("/querySysMenuById")
	public void querySysMenuById(HttpServletRequest request, HttpServletResponse response,Long id){
		SysMenu sysMenu = sysMenuPeer.queryById(id);
		ControllerUtils.returnJson(request, response, sysMenu);
	}
	
	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : SysMenu数据记录
	 * @return 当前记录主键[id]值
	 */
	@RequestMapping("saveOrUpdate")
	public void saveOrUpdate(HttpServletRequest request, HttpServletResponse response,SysMenu record){
		long id = sysMenuPeer.saveOrUpdate(record);
		ControllerUtils.returnJson(request, response, id);
	}
}
