package com.aic.paas.sys.bean;




import com.binary.framework.bean.EntityBean;


/**
 * mapping-table: 区域表[SYS_REGION]
 */
public class SysRegion implements EntityBean {
	private static final long serialVersionUID = 1L;


	/**
	 * mapping-field: ID[ID]
	 */
	private Long id;


	/**
	 * mapping-field: 区域代码[REG_CODE]
	 */
	private String regCode;


	/**
	 * mapping-field: 区域名称[REG_NAME]
	 */
	private String regName;


	/**
	 * mapping-field: 区域全称[REG_FULL_NAME]
	 */
	private String regFullName;


	/**
	 * mapping-field: 区域级别[REG_LEVEL]
	 * 1=国家 2=省 3=市 4=县区
	 */
	private Integer regLevel;


	/**
	 * mapping-field: 上级区域ID[REG_PARENT_ID]
	 */
	private Long regParentId;


	/**
	 * mapping-field: 区域描述[REG_DESC]
	 */
	private String regDesc;


	/**
	 * mapping-field: 区域代码层级路径[REG_CODE_PATH]
	 * 区域层级路径（从根节点ID到当前节点ID的上下级层级路径串，以#号分隔，并以#开头和结尾）
	 */
	private String regCodePath;


	/**
	 * mapping-field: 区域名称层级路径[REG_NAME_PATH]
	 * 区域名称()层级路径
	 */
	private String regNamePath;


	/**
	 * mapping-field: 邮政编码[REG_ZIP_CODE]
	 */
	private String regZipCode;


	/**
	 * mapping-field: 图标[ICON]
	 */
	private String icon;


	/**
	 * mapping-field: 排序号[ORDER_NO]
	 */
	private Integer orderNo;


	/**
	 * mapping-field: 备用_1[CUSTOM_1]
	 */
	private String custom1;


	/**
	 * mapping-field: 备用_2[CUSTOM_2]
	 */
	private String custom2;


	/**
	 * mapping-field: 备用_3[CUSTOM_3]
	 */
	private String custom3;


	/**
	 * mapping-field: 备用_4[CUSTOM_4]
	 */
	private Long custom4;


	/**
	 * mapping-field: 备用_5[CUSTOM_5]
	 */
	private Long custom5;


	/**
	 * mapping-field: 备用_6[CUSTOM_6]
	 */
	private Long custom6;


	/**
	 * mapping-field: 有效状态[STATUS]
	 * 1-有效 0-无效
	 */
	private Integer status;


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


	public String getRegCode() {
		return this.regCode;
	}
	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}


	public String getRegName() {
		return this.regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}


	public String getRegFullName() {
		return this.regFullName;
	}
	public void setRegFullName(String regFullName) {
		this.regFullName = regFullName;
	}


	public Integer getRegLevel() {
		return this.regLevel;
	}
	public void setRegLevel(Integer regLevel) {
		this.regLevel = regLevel;
	}


	public Long getRegParentId() {
		return this.regParentId;
	}
	public void setRegParentId(Long regParentId) {
		this.regParentId = regParentId;
	}


	public String getRegDesc() {
		return this.regDesc;
	}
	public void setRegDesc(String regDesc) {
		this.regDesc = regDesc;
	}


	public String getRegCodePath() {
		return this.regCodePath;
	}
	public void setRegCodePath(String regCodePath) {
		this.regCodePath = regCodePath;
	}


	public String getRegNamePath() {
		return this.regNamePath;
	}
	public void setRegNamePath(String regNamePath) {
		this.regNamePath = regNamePath;
	}


	public String getRegZipCode() {
		return this.regZipCode;
	}
	public void setRegZipCode(String regZipCode) {
		this.regZipCode = regZipCode;
	}


	public String getIcon() {
		return this.icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}


	public Integer getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}


	public String getCustom1() {
		return this.custom1;
	}
	public void setCustom1(String custom1) {
		this.custom1 = custom1;
	}


	public String getCustom2() {
		return this.custom2;
	}
	public void setCustom2(String custom2) {
		this.custom2 = custom2;
	}


	public String getCustom3() {
		return this.custom3;
	}
	public void setCustom3(String custom3) {
		this.custom3 = custom3;
	}


	public Long getCustom4() {
		return this.custom4;
	}
	public void setCustom4(Long custom4) {
		this.custom4 = custom4;
	}


	public Long getCustom5() {
		return this.custom5;
	}
	public void setCustom5(Long custom5) {
		this.custom5 = custom5;
	}


	public Long getCustom6() {
		return this.custom6;
	}
	public void setCustom6(Long custom6) {
		this.custom6 = custom6;
	}


	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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


