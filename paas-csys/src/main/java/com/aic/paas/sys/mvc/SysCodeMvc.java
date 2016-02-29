package com.aic.paas.sys.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.frame.cross.bean.CSysCode;
import com.aic.paas.frame.cross.bean.CSysCodeDef;
import com.aic.paas.frame.cross.bean.GridParams;
import com.aic.paas.frame.cross.bean.SysCode;
import com.aic.paas.frame.cross.bean.SysCodeDef;
import com.aic.paas.sys.bean.SysCodeInfo;
import com.aic.paas.sys.peer.SysCodePeer;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.util.ControllerUtils;
import com.binary.jdbc.Page;
import com.binary.json.JSON;

@Controller
@RequestMapping("/base/syscode")
public class SysCodeMvc {
	
	@Autowired
	SysCodePeer sysCodePeer;

	
	/**
	 * 分页查询
	 */
	@RequestMapping("/queryDefPage")
	public void queryDefPage(HttpServletRequest request, HttpServletResponse response){
		GridParams gp = GridParams.valueOf(request);
		CSysCodeDef cdt = gp.getCondition(CSysCodeDef.class);
		
		String order = gp.getSortAlias();
		if(!BinaryUtils.isEmpty(order)) order += gp.isSortType();
		
		Page<SysCodeDef> page = sysCodePeer.queryDefPage((int)gp.getPageNum(), gp.getPageSize(), cdt, order);
		
		ControllerUtils.returnSimpleJson(request, response, page);
	}
	
	
	
	@RequestMapping("/queryDefById")
	public void queryDefById(HttpServletRequest request, HttpServletResponse response, Long id) {
		SysCodeDef def = sysCodePeer.queryDefById(id);
		ControllerUtils.returnJson(request, response, def);
	}
	
	
	
	/**
	 * 跟据主键查询
	 * @param id : 代码定义ID
	 */
	@RequestMapping("/querySysCodeInfo")
	public void querySysCodeInfo(HttpServletRequest request, HttpServletResponse response, Long id) {
		SysCodeInfo info = sysCodePeer.querySysCodeInfo(id, null, "CODE,ID");
		ControllerUtils.returnJson(request, response, info);
	}
	
	
	
	/**
	 * 跟据代码定义ID查询代码列表
	 * @param id : 代码定义ID
	 */
	@RequestMapping("/queryCodeList")
	public void queryCodeList(HttpServletRequest request, HttpServletResponse response) {
		GridParams gp = GridParams.valueOf(request);
		CSysCode cdt = gp.getCondition(CSysCode.class);
		
		String order = gp.getSortAlias();
		if(!BinaryUtils.isEmpty(order)) {
			order += gp.isSortType();
		}else {
			order = " CODE,ID ";
		}
		List<SysCode> list = sysCodePeer.queryCodeList(cdt, order);
		ControllerUtils.returnSimpleJson(request, response, list);
	}
	
	
	
	/**
	 * 跟据代码定义ID查询代码列表
	 * @param def : 代码定义
	 */
	@RequestMapping("/queryCodeExpList")
	public void queryCodeExpList(HttpServletRequest request, HttpServletResponse response, SysCodeDef def) {
		BinaryUtils.checkEmpty(def, "def");
		BinaryUtils.checkEmpty(def.getId(), "def.id");
		
		CSysCode cdt = new CSysCode();
		cdt.setCodeDefId(def.getId());
		List<SysCode> list = sysCodePeer.queryCodeList(cdt, "CODE,ID");
		ControllerUtils.returnJson(request, response, list);
	}
	
	
	
	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : SysCodeDef数据记录
	 * @return 当前记录主键[id]值
	 */
	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletRequest request, HttpServletResponse response, String defJson, String codesJson) {
		BinaryUtils.checkEmpty(defJson, "defJson");
		BinaryUtils.checkEmpty(codesJson, "codesJson");
		
		SysCodeDef def = JSON.toObject(defJson, SysCodeDef.class);
		List<SysCode> codes = JSON.toList(codesJson, SysCode.class);
		
		Long id = sysCodePeer.saveOrUpdate(def, codes);
		ControllerUtils.returnJson(request, response, id);
	}
	
	
	
	
}
