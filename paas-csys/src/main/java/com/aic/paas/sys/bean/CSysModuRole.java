package com.aic.paas.sys.bean;




import com.binary.framework.bean.Condition;


/**
 * condition-table: 模块角色表[SYS_MODU_ROLE]
 */
public class CSysModuRole implements Condition {
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
	 * condition-field: 模块ID[MODU_ID] operate-Equal[=]
	 */
	private Long moduId;


	/**
	 * condition-field: 模块ID[MODU_ID] operate-In[in]
	 */
	private Long[] moduIds;


	/**
	 * condition-field: 模块ID[MODU_ID] operate-GTEqual[>=]
	 */
	private Long startModuId;

	/**
	 * condition-field: 模块ID[MODU_ID] operate-LTEqual[<=]
	 */
	private Long endModuId;


	/**
	 * condition-field: 角色ID[ROLE_ID] operate-Equal[=]
	 */
	private Long roleId;


	/**
	 * condition-field: 角色ID[ROLE_ID] operate-In[in]
	 */
	private Long[] roleIds;


	/**
	 * condition-field: 角色ID[ROLE_ID] operate-GTEqual[>=]
	 */
	private Long startRoleId;

	/**
	 * condition-field: 角色ID[ROLE_ID] operate-LTEqual[<=]
	 */
	private Long endRoleId;


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


	public Long getModuId() {
		return this.moduId;
	}
	public void setModuId(Long moduId) {
		this.moduId = moduId;
	}


	public Long[] getModuIds() {
		return this.moduIds;
	}
	public void setModuIds(Long[] moduIds) {
		this.moduIds = moduIds;
	}


	public Long getStartModuId() {
		return this.startModuId;
	}
	public void setStartModuId(Long startModuId) {
		this.startModuId = startModuId;
	}


	public Long getEndModuId() {
		return this.endModuId;
	}
	public void setEndModuId(Long endModuId) {
		this.endModuId = endModuId;
	}


	public Long getRoleId() {
		return this.roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}


	public Long[] getRoleIds() {
		return this.roleIds;
	}
	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}


	public Long getStartRoleId() {
		return this.startRoleId;
	}
	public void setStartRoleId(Long startRoleId) {
		this.startRoleId = startRoleId;
	}


	public Long getEndRoleId() {
		return this.endRoleId;
	}
	public void setEndRoleId(Long endRoleId) {
		this.endRoleId = endRoleId;
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


