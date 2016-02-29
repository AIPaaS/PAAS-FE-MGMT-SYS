package com.aic.paas.sys.peer;

public interface EmailSenderPeer {
	
	
	
	
	/**
	 * 发送租户注册结果通知
	 * @param loginCode 
	 * @param checkResult 1=审核通过  2=审核退回
	 * @param checkRemark
	 */
	public void sendMntCheckResult(String loginCode, Integer checkResult, String checkRemark, String email);

	
	
	
	
	
}
