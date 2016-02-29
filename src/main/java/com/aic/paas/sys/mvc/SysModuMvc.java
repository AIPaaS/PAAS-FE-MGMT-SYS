package com.aic.paas.sys.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.frame.cross.bean.CSysModu;
import com.aic.paas.frame.cross.bean.CSysModuDrop;
import com.aic.paas.frame.cross.bean.CSysModuRes;
import com.aic.paas.frame.cross.bean.GridParams;
import com.aic.paas.frame.cross.bean.NodeProMapping;
import com.aic.paas.frame.cross.bean.SysModu;
import com.aic.paas.frame.cross.bean.SysModuDrop;
import com.aic.paas.frame.cross.bean.SysModuRes;
import com.aic.paas.frame.cross.bean.TreeNode;
import com.aic.paas.frame.cross.bean.TreeParams;
import com.aic.paas.frame.util.ComponentUtil;
import com.aic.paas.frame.util.TreeNodeHandler;
import com.aic.paas.sys.peer.SysModuPeer;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.Local;
import com.binary.framework.util.ControllerUtils;
import com.binary.json.JSON;

@Controller
@RequestMapping("/base/sysmodu")
public class SysModuMvc {
	
	@Autowired
	SysModuPeer sysModuPeer;
	
	/**
	 * 查询菜单树
	 * @param request
	 * @param response
	 */
	@RequestMapping("/querySysModuTree")
	public void querySysModuTree(HttpServletRequest request, HttpServletResponse response, Integer moduType){

		TreeParams tp = TreeParams.valueOf(request);
		
		Long parentId = 0l;
		if(!BinaryUtils.isEmpty(tp.getParentId())) {
			parentId = Long.valueOf(tp.getParentId());
		}
		CSysModu cdt = new CSysModu();
		cdt.setParentId(parentId);
		cdt.setModuType(moduType);
		List<SysModu> treeList = sysModuPeer.queryModuList(cdt, "ORDER_NO,MODU_CODE");
		
		List<TreeNode> nodes = null;
		Boolean appAttr = tp.getAppAttributes();
		if(appAttr == null) appAttr = true;
		if(treeList.size() > 0) {
			final String contextPath = Local.getCriticalObject().getContextPath();
			nodes = ComponentUtil.toTreeNodeList(treeList, appAttr, false, new NodeProMapping[] {
					new NodeProMapping("id", "id", null),
					new NodeProMapping("text", "moduName", null),
					new NodeProMapping("parentid", "parentId", null),
					new NodeProMapping("leaf", "isLeaf", null)
			}, new TreeNodeHandler<SysModu>() {
				public void handle(TreeNode node, SysModu record) {
					int dir = record.getIsDir();//0=模块    1=目录
					if(dir == 1) {
						node.setIcon(contextPath + "/frame/images/tree/f18.gif");
					}else {
						node.setIcon(contextPath + "/frame/images/tree/com.gif");
					}
					if(record.getStatus()==0){
						node.setText("<font class='ux-cell-color-gray'>["+record.getModuCode()+"] "+record.getModuName()+"</font>");
					}else{
						node.setText("<font color='#0000cc'>["+record.getModuCode()+"]</font> "+record.getModuName());
					}
				}
			});
		}else {
			nodes = new ArrayList<TreeNode>();
		}
		
		ControllerUtils.returnSimpleJson(request, response, nodes);
	
	}
	/**
	 * 根据Id查询SysModu
	 * @param request
	 * @param response
	 * @param id
	 */
	@RequestMapping("/querySysModuById")
	public void querySysModuById(HttpServletRequest request, HttpServletResponse response,Long id){
		SysModu sysModu = sysModuPeer.queryModuById(id);
		ControllerUtils.returnJson(request, response, sysModu);
	}
	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : SysModu数据记录
	 * @return 当前记录主键[id]值
	 */
	@RequestMapping("saveOrUpdate")
	public void saveOrUpdate(HttpServletRequest request, HttpServletResponse response,SysModu record){
		
		long id = sysModuPeer.saveOrUpdateModu(record);
		ControllerUtils.returnJson(request, response, id);
	}
	/**
	 * 根据SysModuId查询SysModuDrop的list
	 * @param request
	 * @param response
	 * @param moduId
	 */
	@RequestMapping("/querySysModuDropByModuId")
	public void querySysModuDropList(HttpServletRequest request, HttpServletResponse response){
		GridParams gp = GridParams.valueOf(request);
		CSysModuDrop cdt = gp.getCondition(CSysModuDrop.class);
		
		String order = gp.getSortAlias();
		if(!BinaryUtils.isEmpty(order)) {
			order += gp.isSortType();
		}else {
			order = " MODU_ID,DEF_CODE ";
		}
		
		List<SysModuDrop> list = sysModuPeer.queryModuDropList(cdt.getModuId(), cdt, order);
		ControllerUtils.returnSimpleJson(request, response, list);
	}
	/**
	 * 根据SysModuId查询SysModuRes的list
	 * @param request
	 * @param response
	 * @param moduId
	 */
	@RequestMapping("/querySysModuResByModuId")
	public void querySysModuResByModuId(HttpServletRequest request, HttpServletResponse response){
		GridParams gp = GridParams.valueOf(request);
		CSysModuRes cdt = gp.getCondition(CSysModuRes.class);
		
		String order = gp.getSortAlias();
		if(!BinaryUtils.isEmpty(order)) {
			order += gp.isSortType();
		}else {
			order = " MODU_ID";
		}
		List<SysModuRes> list = sysModuPeer.queryModuResList(cdt.getModuId(), cdt, order);
		ControllerUtils.returnSimpleJson(request, response, list);
	}
	/**
	 * 保存SysModuDrop列表
	 * @param request
	 * @param response
	 * @param codesJson 列表数据
	 * @param moduId
	 */
	@RequestMapping("/saveSysModuDrop")
	public void saveSysModuDrop(HttpServletRequest request, HttpServletResponse response,String codesJson,Long moduId){
		BinaryUtils.checkEmpty(codesJson, "codesJson");
		List<SysModuDrop> list = JSON.toList(codesJson, SysModuDrop.class);
		sysModuPeer.saveOrUpdateModuDropList(moduId, list);
		
		ControllerUtils.returnJson(request, response, true);
	}
	/**
	 * 保存SysModuRes列表
	 * @param request
	 * @param response
	 * @param codesJson 列表数据
	 * @param moduId
	 */
	@RequestMapping("/saveSysModuRes")
	public void saveSysModuRes(HttpServletRequest request, HttpServletResponse response,String codesJson,Long moduId){
		
		BinaryUtils.checkEmpty(codesJson, "codesJson");
		List<SysModuRes> list = JSON.toList(codesJson, SysModuRes.class);
		sysModuPeer.saveOrUpdateModuResList(moduId, list);
		
		ControllerUtils.returnJson(request, response, true);
	}
}
