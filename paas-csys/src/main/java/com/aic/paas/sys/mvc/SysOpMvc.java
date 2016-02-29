package com.aic.paas.sys.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.frame.cross.bean.CSysOp;
import com.aic.paas.frame.cross.bean.GridParams;
import com.aic.paas.frame.cross.bean.SysOp;
import com.aic.paas.sys.peer.SysOpPeer;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.util.ControllerUtils;
import com.binary.jdbc.Page;

@Controller
@RequestMapping("/permis/sysop")
public class SysOpMvc {
	
	@Autowired
	SysOpPeer sysOpPeer;
	
	/**
	 * 分页查询
	 */
	@RequestMapping("/querySysOpPage")
	public void querySysOpPage(HttpServletRequest request, HttpServletResponse response){
		GridParams gp = GridParams.valueOf(request);
		CSysOp cdt = gp.getCondition(CSysOp.class);
		
		String order = gp.getSortAlias();
		if(!BinaryUtils.isEmpty(order)) order += gp.isSortType();
		
		Page<SysOp> page = sysOpPeer.queryPage((int)gp.getPageNum(), gp.getPageSize(), cdt, order);
		ControllerUtils.returnSimpleJson(request, response, page);
	}
	
	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : SysOp数据记录
	 * @return 当前记录主键[id]值
	 */
	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(HttpServletRequest request, HttpServletResponse response,SysOp record){
		Long id = sysOpPeer.saveOrUpdate(record);
		ControllerUtils.returnJson(request, response, id);
	}
	
	@RequestMapping("/querySysOpById")
	public void querySysOpById(HttpServletRequest request, HttpServletResponse response,Long id){
		SysOp sysOp = sysOpPeer.queryById(id);
		ControllerUtils.returnJson(request, response, sysOp);
	}
	
}
