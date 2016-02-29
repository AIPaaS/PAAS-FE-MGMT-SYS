package com.aic.paas.sys.bean;




import com.binary.framework.bean.Condition;


/**
 * condition-table: 用户登录日志[SYS_LOGIN_LOG]
 */
public class CSysLoginLog implements Condition {
	private static final long serialVersionUID = 1L;


	/**
	 * condition-field: ID[ID] operate-Equal[=]
	 */
	private Long id;


	/**
	 * condition-field: ID[ID] operate-In[in]
	 */
	private Long[] ids;


	/**
	 * condition-field: ID[ID] operate-GTEqual[>=]
	 */
	private Long startId;

	/**
	 * condition-field: ID[ID] operate-LTEqual[<=]
	 */
	private Long endId;


	/**
	 * condition-field: 用户ID[USER_ID] operate-Equal[=]
	 */
	private Long userId;


	/**
	 * condition-field: 用户ID[USER_ID] operate-In[in]
	 */
	private Long[] userIds;


	/**
	 * condition-field: 用户ID[USER_ID] operate-GTEqual[>=]
	 */
	private Long startUserId;

	/**
	 * condition-field: 用户ID[USER_ID] operate-LTEqual[<=]
	 */
	private Long endUserId;


	/**
	 * condition-field: 用户代码[USER_CODE] operate-Like[like]
	 */
	private String userCode;


	/**
	 * condition-field: 用户代码[USER_CODE] operate-Equal[=]
	 */
	private String userCodeEqual;


	/**
	 * condition-field: 用户代码[USER_CODE] operate-In[in]
	 */
	private String[] userCodes;


	/**
	 * condition-field: 用户姓名[USER_NAME] operate-Like[like]
	 */
	private String userName;


	/**
	 * condition-field: 用户姓名[USER_NAME] operate-Equal[=]
	 */
	private String userNameEqual;


	/**
	 * condition-field: 用户姓名[USER_NAME] operate-In[in]
	 */
	private String[] userNames;


	/**
	 * condition-field: 会话ID[SESSION_ID] operate-Like[like]
	 */
	private String sessionId;


	/**
	 * condition-field: 会话ID[SESSION_ID] operate-Equal[=]
	 */
	private String sessionIdEqual;


	/**
	 * condition-field: 会话ID[SESSION_ID] operate-In[in]
	 */
	private String[] sessionIds;


	/**
	 * condition-field: 登录时间[LOGIN_TIME] operate-Equal[=]
	 * yyyyMMddHHmmss
	 */
	private Long loginTime;


	/**
	 * condition-field: 登录时间[LOGIN_TIME] operate-In[in]
	 * yyyyMMddHHmmss
	 */
	private Long[] loginTimes;


	/**
	 * condition-field: 登录时间[LOGIN_TIME] operate-GTEqual[>=]
	 * yyyyMMddHHmmss
	 */
	private Long startLoginTime;

	/**
	 * condition-field: 登录时间[LOGIN_TIME] operate-LTEqual[<=]
	 * yyyyMMddHHmmss
	 */
	private Long endLoginTime;


	/**
	 * condition-field: 登出时间[LOGOUT_TIME] operate-Equal[=]
	 * yyyyMMddHHmmss
	 */
	private Long logoutTime;


	/**
	 * condition-field: 登出时间[LOGOUT_TIME] operate-In[in]
	 * yyyyMMddHHmmss
	 */
	private Long[] logoutTimes;


	/**
	 * condition-field: 登出时间[LOGOUT_TIME] operate-GTEqual[>=]
	 * yyyyMMddHHmmss
	 */
	private Long startLogoutTime;

	/**
	 * condition-field: 登出时间[LOGOUT_TIME] operate-LTEqual[<=]
	 * yyyyMMddHHmmss
	 */
	private Long endLogoutTime;


	/**
	 * condition-field: 描述[REMARK] operate-Like[like]
	 */
	private String remark;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-Equal[=]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer dataStatus;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-In[in]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer[] dataStatuss;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-GTEqual[>=]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer startDataStatus;

	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-LTEqual[<=]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer endDataStatus;


	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-Equal[=]
	 * yyyyMMddHHmmss
	 */
	private Long createTime;


	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-In[in]
	 * yyyyMMddHHmmss
	 */
	private Long[] createTimes;


	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-GTEqual[>=]
	 * yyyyMMddHHmmss
	 */
	private Long startCreateTime;

	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-LTEqual[<=]
	 * yyyyMMddHHmmss
	 */
	private Long endCreateTime;


	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-Equal[=]
	 * yyyyMMddHHmmss
	 */
	private Long modifyTime;


	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-In[in]
	 * yyyyMMddHHmmss
	 */
	private Long[] modifyTimes;


	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-GTEqual[>=]
	 * yyyyMMddHHmmss
	 */
	private Long startModifyTime;

	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-LTEqual[<=]
	 * yyyyMMddHHmmss
	 */
	private Long endModifyTime;




	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public Long[] getIds() {
		return this.ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}


	public Long getStartId() {
		return this.startId;
	}
	public void setStartId(Long startId) {
		this.startId = startId;
	}


	public Long getEndId() {
		return this.endId;
	}
	public void setEndId(Long endId) {
		this.endId = endId;
	}


	public Long getUserId() {
		return this.userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long[] getUserIds() {
		return this.userIds;
	}
	public void setUserIds(Long[] userIds) {
		this.userIds = userIds;
	}


	public Long getStartUserId() {
		return this.startUserId;
	}
	public void setStartUserId(Long startUserId) {
		this.startUserId = startUserId;
	}


	public Long getEndUserId() {
		return this.endUserId;
	}
	public void setEndUserId(Long endUserId) {
		this.endUserId = endUserId;
	}


	public String getUserCode() {
		return this.userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}


	public String getUserCodeEqual() {
		return this.userCodeEqual;
	}
	public void setUserCodeEqual(String userCodeEqual) {
		this.userCodeEqual = userCodeEqual;
	}


	public String[] getUserCodes() {
		return this.userCodes;
	}
	public void setUserCodes(String[] userCodes) {
		this.userCodes = userCodes;
	}


	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserNameEqual() {
		return this.userNameEqual;
	}
	public void setUserNameEqual(String userNameEqual) {
		this.userNameEqual = userNameEqual;
	}


	public String[] getUserNames() {
		return this.userNames;
	}
	public void setUserNames(String[] userNames) {
		this.userNames = userNames;
	}


	public String getSessionId() {
		return this.sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}


	public String getSessionIdEqual() {
		return this.sessionIdEqual;
	}
	public void setSessionIdEqual(String sessionIdEqual) {
		this.sessionIdEqual = sessionIdEqual;
	}


	public String[] getSessionIds() {
		return this.sessionIds;
	}
	public void setSessionIds(String[] sessionIds) {
		this.sessionIds = sessionIds;
	}


	public Long getLoginTime() {
		return this.loginTime;
	}
	public void setLoginTime(Long loginTime) {
		this.loginTime = loginTime;
	}


	public Long[] getLoginTimes() {
		return this.loginTimes;
	}
	public void setLoginTimes(Long[] loginTimes) {
		this.loginTimes = loginTimes;
	}


	public Long getStartLoginTime() {
		return this.startLoginTime;
	}
	public void setStartLoginTime(Long startLoginTime) {
		this.startLoginTime = startLoginTime;
	}


	public Long getEndLoginTime() {
		return this.endLoginTime;
	}
	public void setEndLoginTime(Long endLoginTime) {
		this.endLoginTime = endLoginTime;
	}


	public Long getLogoutTime() {
		return this.logoutTime;
	}
	public void setLogoutTime(Long logoutTime) {
		this.logoutTime = logoutTime;
	}


	public Long[] getLogoutTimes() {
		return this.logoutTimes;
	}
	public void setLogoutTimes(Long[] logoutTimes) {
		this.logoutTimes = logoutTimes;
	}


	public Long getStartLogoutTime() {
		return this.startLogoutTime;
	}
	public void setStartLogoutTime(Long startLogoutTime) {
		this.startLogoutTime = startLogoutTime;
	}


	public Long getEndLogoutTime() {
		return this.endLogoutTime;
	}
	public void setEndLogoutTime(Long endLogoutTime) {
		this.endLogoutTime = endLogoutTime;
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


	public Integer[] getDataStatuss() {
		return this.dataStatuss;
	}
	public void setDataStatuss(Integer[] dataStatuss) {
		this.dataStatuss = dataStatuss;
	}


	public Integer getStartDataStatus() {
		return this.startDataStatus;
	}
	public void setStartDataStatus(Integer startDataStatus) {
		this.startDataStatus = startDataStatus;
	}


	public Integer getEndDataStatus() {
		return this.endDataStatus;
	}
	public void setEndDataStatus(Integer endDataStatus) {
		this.endDataStatus = endDataStatus;
	}


	public Long getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}


	public Long[] getCreateTimes() {
		return this.createTimes;
	}
	public void setCreateTimes(Long[] createTimes) {
		this.createTimes = createTimes;
	}


	public Long getStartCreateTime() {
		return this.startCreateTime;
	}
	public void setStartCreateTime(Long startCreateTime) {
		this.startCreateTime = startCreateTime;
	}


	public Long getEndCreateTime() {
		return this.endCreateTime;
	}
	public void setEndCreateTime(Long endCreateTime) {
		this.endCreateTime = endCreateTime;
	}


	public Long getModifyTime() {
		return this.modifyTime;
	}
	public void setModifyTime(Long modifyTime) {
		this.modifyTime = modifyTime;
	}


	public Long[] getModifyTimes() {
		return this.modifyTimes;
	}
	public void setModifyTimes(Long[] modifyTimes) {
		this.modifyTimes = modifyTimes;
	}


	public Long getStartModifyTime() {
		return this.startModifyTime;
	}
	public void setStartModifyTime(Long startModifyTime) {
		this.startModifyTime = startModifyTime;
	}


	public Long getEndModifyTime() {
		return this.endModifyTime;
	}
	public void setEndModifyTime(Long endModifyTime) {
		this.endModifyTime = endModifyTime;
	}


}


