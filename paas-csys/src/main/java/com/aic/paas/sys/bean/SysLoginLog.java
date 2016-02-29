package com.aic.paas.sys.bean;




import com.binary.framework.bean.EntityBean;


/**
 * mapping-table: 用户登录日志[SYS_LOGIN_LOG]
 */
public class SysLoginLog implements EntityBean {
	private static final long serialVersionUID = 1L;


	/**
	 * mapping-field: ID[ID]
	 */
	private Long id;


	/**
	 * mapping-field: 用户ID[USER_ID]
	 */
	private Long userId;


	/**
	 * mapping-field: 用户代码[USER_CODE]
	 */
	private String userCode;


	/**
	 * mapping-field: 用户姓名[USER_NAME]
	 */
	private String userName;


	/**
	 * mapping-field: 会话ID[SESSION_ID]
	 */
	private String sessionId;


	/**
	 * mapping-field: 登录时间[LOGIN_TIME]
	 * yyyyMMddHHmmss
	 */
	private Long loginTime;


	/**
	 * mapping-field: 登出时间[LOGOUT_TIME]
	 * yyyyMMddHHmmss
	 */
	private Long logoutTime;


	/**
	 * mapping-field: 描述[REMARK]
	 */
	private String remark;


	/**
	 * mapping-field: 数据状态[DATA_STATUS]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer dataStatus;


	/**
	 * mapping-field: 创建时间[CREATE_TIME]
	 * yyyyMMddHHmmss
	 */
	private Long createTime;


	/**
	 * mapping-field: 修改时间[MODIFY_TIME]
	 * yyyyMMddHHmmss
	 */
	private Long modifyTime;




	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public Long getUserId() {
		return this.userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getUserCode() {
		return this.userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}


	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getSessionId() {
		return this.sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}


	public Long getLoginTime() {
		return this.loginTime;
	}
	public void setLoginTime(Long loginTime) {
		this.loginTime = loginTime;
	}


	public Long getLogoutTime() {
		return this.logoutTime;
	}
	public void setLogoutTime(Long logoutTime) {
		this.logoutTime = logoutTime;
	}


	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Integer getDataStatus() {
		return this.dataStatus;
	}
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}


	public Long getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}


	public Long getModifyTime() {
		return this.modifyTime;
	}
	public void setModifyTime(Long modifyTime) {
		this.modifyTime = modifyTime;
	}


}


