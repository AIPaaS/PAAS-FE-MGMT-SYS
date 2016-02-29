package com.aic.paas.sys.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.frame.cross.bean.CWsMerchent;
import com.aic.paas.frame.cross.bean.WsMerchent;
import com.aic.paas.sys.peer.MerchentPeer;
import com.binary.framework.util.ControllerUtils;
import com.binary.jdbc.Page;


@Controller
@RequestMapping("/mnt/merchent")
public class MerchentMvc {
	
	
	@Autowired
	MerchentPeer merchentPeer;
	
	
	
	@RequestMapping("/queryMntPage")
	public void queryMntPage(HttpServletRequest request, HttpServletResponse response,Integer pageNum, Integer pageSize, CWsMerchent cdt, String orders) {
		Page<WsMerchent> page = merchentPeer.queryMntPage(pageNum, pageSize, cdt, orders);
		ControllerUtils.returnJson(request, response, page);
	}
	
	
	
	@RequestMapping("/checkMntPass")
	public void checkMntPass(HttpServletRequest request, HttpServletResponse response, Long id, String checkDesc) {
		merchentPeer.checkMnt(id, 1, checkDesc);
		ControllerUtils.returnJson(request, response, true);
	}
	
	

	
	@RequestMapping("/checkMntBack")
	public void checkMntBack(HttpServletRequest request, HttpServletResponse response, Long id, String checkDesc) {
		merchentPeer.checkMnt(id, 2, checkDesc);
		ControllerUtils.returnJson(request, response, true);
	}
	
	
	
	
}





