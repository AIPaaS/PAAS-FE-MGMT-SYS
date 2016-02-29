package com.aic.paas.sys.mvc;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.frame.util.SysFrameUtil;
import com.binary.framework.exception.ServiceException;




@Controller
@RequestMapping("/dispatch")
public class DispatchMvc {
	
	private final Pattern NUM_REGX = Pattern.compile("[0-9]+");
		
	
	
	@RequestMapping("/base/SysCodeList")
	public String forward2SysCodeList(HttpServletRequest request, HttpServletResponse response) {
		String moduCode = "010301";
		String[] drops = new String[]{"V_YES_NO","V_IS_VALID","V_SYS_CODE_DEF_CODE_TYPE"};
		String[] reses = new String[]{"/base/SysCodeList.js"};
		SysFrameUtil.forwardModuleByCode(request, moduCode, drops, reses);
		return "forward:/frame/jsp/dynamic.jsp";

	}
	
	
	@RequestMapping("/base/SysCodeForm")
	public String forward2SysCodeForm(HttpServletRequest request, HttpServletResponse response) {
		String moduCode = "01030101";
		String[] drops = new String[]{"V_IS_VALID","V_SYS_CODE_DEF_CODE_TYPE"};
		String[] reses = new String[]{"/base/SysCodeForm.js"};
		SysFrameUtil.forwardModuleByCode(request, moduCode, drops, reses);
		return "forward:/frame/jsp/dynamic.jsp";
		
	}
	
	@RequestMapping("/base/SysModuList")
	public String forward2SysModuList(HttpServletRequest request, HttpServletResponse response) {
		String moduCode = "010302";
		String[] drops = new String[]{"V_SYS_MODU_IS_LEAF","V_SYS_MODU_IS_DIR","V_SYS_MODU_TYPE","V_SYS_MODU_TECHNIC_TYPE","V_IS_VALID","V_SYS_MODU_DROP_ADD_ATTRS","V_SYS_MODU_ADD_EMPTY","V_SYS_MODU_DATA_STATUS","V_SYS_MODU_RES_RES_TYPE"};
		String[] reses = new String[]{"/base/SysModuList.js"};
		SysFrameUtil.forwardModuleByCode(request, moduCode, drops, reses);
		return "forward:/frame/jsp/dynamic.jsp";
	}
	
	
	@RequestMapping("/base/SysMenuList")
	public String forward2SysMenuList(HttpServletRequest request, HttpServletResponse response) {
		String moduCode = "010303";
		String[] drops = new String[]{"V_SYS_MODU_TYPE"};
		String[] reses = new String[]{"/base/SysMenuList.js"};
		SysFrameUtil.forwardModuleByCode(request, moduCode, drops, reses);
		return "forward:/frame/jsp/dynamic.jsp";
	}
	
	@RequestMapping("/permis/SysRoleList")
	public String forward2SysRoleList(HttpServletRequest request, HttpServletResponse response) {
		String moduCode = "010102";
		String[] drops = new String[]{"V_SYS_ROLE_ROLE_TYPE","V_IS_VALID"};
		String[] reses = new String[]{"/permis/SysRoleList.js"};
		SysFrameUtil.forwardModuleByCode(request, moduCode, drops, reses);
		return "forward:/frame/jsp/dynamic.jsp";
	}
	
	@RequestMapping("/permis/SysRoleForm")
	public String forward2SysRoleForm(HttpServletRequest request, HttpServletResponse response){
		String moduCode = "01010201";
		String[] drops = new String[]{"V_SYS_ROLE_ROLE_TYPE"};
		String[] reses = new String[]{"/permis/SysRoleForm.js"};
		SysFrameUtil.forwardModuleByCode(request, moduCode, drops, reses);
		return "forward:/frame/jsp/dynamic.jsp";
	}
	
	@RequestMapping("/permis/SysOpList")
	public String forward2SysOpList(HttpServletRequest request, HttpServletResponse response) {
		String moduCode = "010101";
		String[] drops = new String[]{"V_SYS_OP_OP_KIND","V_SYS_OP_GENDER","V_SYS_OP_LOCK_FLAG","V_SYS_OP_IS_UPDATE_PWD","V_SYS_OP_STATUS"};
		String[] reses = new String[]{"/permis/SysOpList.js"};
		SysFrameUtil.forwardModuleByCode(request, moduCode, drops, reses);
		return "forward:/frame/jsp/dynamic.jsp";
		
	}
		
	
	
	@RequestMapping("/permis/SysOpForm")
	public String forward2SysOpForm(HttpServletRequest request, HttpServletResponse response) {
		String moduCode = "01010101";
		String[] drops = new String[]{"V_SYS_OP_OP_KIND","V_SYS_OP_GENDER","V_SYS_OP_LOCK_FLAG","V_SYS_OP_IS_UPDATE_PWD","V_SYS_OP_STATUS"};
		String[] reses = new String[]{"/permis/SysOpForm.js"};
		SysFrameUtil.forwardModuleByCode(request, moduCode, drops, reses);
		return "forward:/frame/jsp/dynamic.jsp";
		
	}
	
	@RequestMapping("/permis/SysOpRoleList")
	public String forward2SysOpRole(HttpServletRequest request, HttpServletResponse response){
		String moduCode = "010103";
		String[] drops = new String[]{"V_SYS_OP_OP_KIND","V_SYS_ROLE_ROLE_TYPE"};
		String[] reses = new String[]{"/permis/SysOpRoleList.js"};
		SysFrameUtil.forwardModuleByCode(request, moduCode, drops, reses);
		return "forward:/frame/jsp/dynamic.jsp";
	}
	
	@RequestMapping("/permis/SysModuRoleList")
	public String SysModuRoleList(HttpServletRequest request, HttpServletResponse response){
		String moduCode = "010104";
		String[] drops = new String[]{"V_SYS_ROLE_ROLE_TYPE","V_IS_VALID"};
		String[] reses = new String[]{"/permis/SysModuRoleList.js"};
		SysFrameUtil.forwardModuleByCode(request, moduCode, drops, reses);
		return "forward:/frame/jsp/dynamic.jsp";
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping("/websys/WebModuList")
	public String forward2WebModuList(HttpServletRequest request, HttpServletResponse response) {
		String moduCode = "010304";
		String[] drops = new String[]{"V_SYS_MODU_IS_LEAF","V_SYS_MODU_IS_DIR","V_SYS_MODU_TYPE","V_SYS_MODU_TECHNIC_TYPE","V_IS_VALID","V_SYS_MODU_DROP_ADD_ATTRS","V_SYS_MODU_ADD_EMPTY","V_SYS_MODU_DATA_STATUS","V_SYS_MODU_RES_RES_TYPE"};
		String[] reses = new String[]{"/websys/SysModuList.js"};
		SysFrameUtil.forwardModuleByCode(request, moduCode, drops, reses);
		return "forward:/frame/jsp/dynamic.jsp";
	}
	
	
	@RequestMapping("/websys/WebMenuList")
	public String forward2WebMenuList(HttpServletRequest request, HttpServletResponse response) {
		String moduCode = "010305";
		String[] drops = new String[]{"V_SYS_MODU_TYPE"};
		String[] reses = new String[]{"/websys/SysMenuList.js"};
		SysFrameUtil.forwardModuleByCode(request, moduCode, drops, reses);
		return "forward:/frame/jsp/dynamic.jsp";
	}
	
	
	@RequestMapping("/websys/WebOpList")
	public String forward2WebOpList(HttpServletRequest request, HttpServletResponse response) {
		String moduCode = "010201";
		String[] drops = new String[]{"V_SYS_OP_OP_KIND","V_SYS_OP_GENDER","V_SYS_OP_LOCK_FLAG","V_SYS_OP_IS_UPDATE_PWD","V_SYS_OP_STATUS"};
		String[] reses = new String[]{"/websys/SysOpList.js"};
		SysFrameUtil.forwardModuleByCode(request, moduCode, drops, reses);
		return "forward:/frame/jsp/dynamic.jsp";
		
	}
	
	
	@RequestMapping("/websys/WebRoleList")
	public String forward2WebRoleList(HttpServletRequest request, HttpServletResponse response) {
		String moduCode = "010202";
		String[] drops = new String[]{"V_SYS_ROLE_ROLE_TYPE","V_IS_VALID"};
		String[] reses = new String[]{"/websys/SysRoleList.js"};
		SysFrameUtil.forwardModuleByCode(request, moduCode, drops, reses);
		return "forward:/frame/jsp/dynamic.jsp";
	}
	
	@RequestMapping("/websys/WebOpRoleList")
	public String forward2WebOpRole(HttpServletRequest request, HttpServletResponse response){
		String moduCode = "010203";
		String[] drops = new String[]{"V_SYS_OP_OP_KIND","V_SYS_ROLE_ROLE_TYPE"};
		String[] reses = new String[]{"/websys/SysOpRoleList.js"};
		SysFrameUtil.forwardModuleByCode(request, moduCode, drops, reses);
		return "forward:/frame/jsp/dynamic.jsp";
	}
	
	@RequestMapping("/websys/WebModuRoleList")
	public String forward2WebModuRoleList(HttpServletRequest request, HttpServletResponse response){
		String moduCode = "010204";
		String[] drops = new String[]{"V_SYS_ROLE_ROLE_TYPE","V_IS_VALID"};
		String[] reses = new String[]{"/websys/SysModuRoleList.js"};
		SysFrameUtil.forwardModuleByCode(request, moduCode, drops, reses);
		return "forward:/frame/jsp/dynamic.jsp";
	}
	
	
	
	
	@RequestMapping("/mnt/MerchentCheck")
	public String forward2MerchentCheck(HttpServletRequest request, HttpServletResponse response){
		SysFrameUtil.forwardModuleByCode(request, "0301");
		return "forward:/mnt/MerchentCheck.jsp";
	}
	
	
	
	@RequestMapping("/mi/**")
	public String openModuById(HttpServletRequest request, HttpServletResponse response) {
		String url = request.getRequestURI();
		int idx = url.indexOf("/mi/");
		if(idx < 0) throw new ServiceException(" is wrong url '"+url+"'! ");
		String id = url.substring(idx+4).trim();
		
		if(!NUM_REGX.matcher(id).matches()) {
			throw new ServiceException(" is wrong url '"+url+"'! ");
		}
		
		return "forward:/sys/frame/cross/modu/openModuleById?moduleId="+id;
	}
	
	
	
	
	@RequestMapping("/mc/**")
	public String openModuByCode(HttpServletRequest request, HttpServletResponse response) {
		String url = request.getRequestURI();
		int idx = url.indexOf("/mc/");
		if(idx < 0) throw new ServiceException(" is wrong url '"+url+"'! ");
		String code = url.substring(idx+4).trim();
		return "forward:/sys/frame/cross/modu/openModuleByCode?moduleCode="+code;
	}
	

}
