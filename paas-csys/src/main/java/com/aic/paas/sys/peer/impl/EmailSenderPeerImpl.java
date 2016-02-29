package com.aic.paas.sys.peer.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.sys.peer.EmailSenderPeer;
import com.binary.core.io.FileSystem;
import com.binary.core.io.Resource;
import com.binary.core.io.ResourceResolver;
import com.binary.core.lang.StringLinker;
import com.binary.core.lang.StringUtils;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.exception.ServiceException;
import com.binary.framework.util.ControllerUtils;
import com.binary.tools.mail.BinaryEmailSender;

public class EmailSenderPeerImpl implements EmailSenderPeer {

	
	@Autowired
	BinaryEmailSender emailSender;
	
	/** 当前系统入口 **/
	private String httpRoot;
		
	/** PAAS主页 **/
	private String homeUrl;
	
	
	
	public String getHomeUrl() {
		return homeUrl;
	}
	public void setHomeUrl(String homeUrl) {
		this.homeUrl = homeUrl;
	}
	
	public String getHttpRoot() {
		return httpRoot;
	}
	public void setHttpRoot(String httpRoot) {
		BinaryUtils.checkEmpty(httpRoot, "httpRoot");
		this.httpRoot = ControllerUtils.formatContextPath(httpRoot).substring(1);
	}
	
	

	
	@Override
	public void sendMntCheckResult(String loginCode, Integer checkResult, String checkRemark, String email) {
		BinaryUtils.checkEmpty(loginCode, "loginCode");
		BinaryUtils.checkEmpty(checkResult, "checkResult");
		
		String title = "租户注册结果通知";
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("logo_url", this.httpRoot+"/layout/img/paas_web_logo.png");
		param.put("loginCode", loginCode);
		param.put("home_url", this.homeUrl);
		param.put("checkResult", checkResult.intValue()==1 ? "<font color='#008800'>[通过]</font>" : "<font color='#ff0000'>[未通过]</font>");
		if(checkResult.intValue()==1) {
			checkRemark = "欢迎使用亚信PAAS平台";
		}else {
			if(!BinaryUtils.isEmpty(checkRemark)) {
				checkRemark = "<font color='red'>审核意见："+checkRemark.replaceAll("\n", "<br>")+"</font>";
			}else {
				checkRemark = "";
			}
			checkRemark += "<br><br><br>如果疑问，请与平台管理员联系。";
		}
		param.put("checkRemark", checkRemark);
		
		String content = "";
		try {
			InputStream is = null;
			try {
				Resource rs = ResourceResolver.getResource("classpath:tpl/mail/mnt_check_result.tpl");
				is = rs.getInputStream();
				String s = FileSystem.read(is, "UTF-8");
				StringLinker sl = StringUtils.parseExpression(s);
				content = sl.link(param).toString();
			}finally {
				if(is != null) is.close();
			}
		}catch(Exception e) {
			throw BinaryUtils.transException(e, ServiceException.class);
		}
		
		emailSender.send(title, email, content);
	}
	
	
	
	
	
}
