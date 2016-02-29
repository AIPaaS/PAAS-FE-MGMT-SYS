package com.aic.paas.sys.bean;




import com.binary.framework.bean.Condition;


/**
 * condition-table: 区域表[SYS_REGION]
 */
public class CSysRegion implements Condition {
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
	 * condition-field: 区域代码[REG_CODE] operate-Like[like]
	 */
	private String regCode;


	/**
	 * condition-field: 区域代码[REG_CODE] operate-Equal[=]
	 */
	private String regCodeEqual;


	/**
	 * condition-field: 区域代码[REG_CODE] operate-In[in]
	 */
	private String[] regCodes;


	/**
	 * condition-field: 区域名称[REG_NAME] operate-Like[like]
	 */
	private String regName;


	/**
	 * condition-field: 区域名称[REG_NAME] operate-Equal[=]
	 */
	private String regNameEqual;


	/**
	 * condition-field: 区域名称[REG_NAME] operate-In[in]
	 */
	private String[] regNames;


	/**
	 * condition-field: 区域全称[REG_FULL_NAME] operate-Like[like]
	 */
	private String regFullName;


	/**
	 * condition-field: 区域级别[REG_LEVEL] operate-Equal[=]
	 * 1=国家 2=省 3=市 4=县区
	 */
	private Integer regLevel;


	/**
	 * condition-field: 区域级别[REG_LEVEL] operate-In[in]
	 * 1=国家 2=省 3=市 4=县区
	 */
	private Integer[] regLevels;


	/**
	 * condition-field: 区域级别[REG_LEVEL] operate-GTEqual[>=]
	 * 1=国家 2=省 3=市 4=县区
	 */
	private Integer startRegLevel;

	/**
	 * condition-field: 区域级别[REG_LEVEL] operate-LTEqual[<=]
	 * 1=国家 2=省 3=市 4=县区
	 */
	private Integer endRegLevel;


	/**
	 * condition-field: 上级区域ID[REG_PARENT_ID] operate-Equal[=]
	 */
	private Long regParentId;


	/**
	 * condition-field: 上级区域ID[REG_PARENT_ID] operate-In[in]
	 */
	private Long[] regParentIds;


	/**
	 * condition-field: 上级区域ID[REG_PARENT_ID] operate-GTEqual[>=]
	 */
	private Long startRegParentId;

	/**
	 * condition-field: 上级区域ID[REG_PARENT_ID] operate-LTEqual[<=]
	 */
	private Long endRegParentId;


	/**
	 * condition-field: 区域描述[REG_DESC] operate-Like[like]
	 */
	private String regDesc;


	/**
	 * condition-field: 区域代码层级路径[REG_CODE_PATH] operate-Like[like]
	 * 区域层级路径（从根节点ID到当前节点ID的上下级层级路径串，以#号分隔，并以#开头和结尾）
	 */
	private String regCodePath;


	/**
	 * condition-field: 区域名称层级路径[REG_NAME_PATH] operate-Like[like]
	 * 区域名称()层级路径
	 */
	private String regNamePath;


	/**
	 * condition-field: 邮政编码[REG_ZIP_CODE] operate-Like[like]
	 */
	private String regZipCode;


	/**
	 * condition-field: 邮政编码[REG_ZIP_CODE] operate-Equal[=]
	 */
	private String regZipCodeEqual;


	/**
	 * condition-field: 邮政编码[REG_ZIP_CODE] operate-In[in]
	 */
	private String[] regZipCodes;


	/**
	 * condition-field: 图标[ICON] operate-Like[like]
	 */
	private String icon;


	/**
	 * condition-field: 图标[ICON] operate-Equal[=]
	 */
	private String iconEqual;


	/**
	 * condition-field: 图标[ICON] operate-In[in]
	 */
	private String[] icons;


	/**
	 * condition-field: 排序号[ORDER_NO] operate-Equal[=]
	 */
	private Integer orderNo;


	/**
	 * condition-field: 排序号[ORDER_NO] operate-In[in]
	 */
	private Integer[] orderNos;


	/**
	 * condition-field: 排序号[ORDER_NO] operate-GTEqual[>=]
	 */
	private Integer startOrderNo;

	/**
	 * condition-field: 排序号[ORDER_NO] operate-LTEqual[<=]
	 */
	private Integer endOrderNo;


	/**
	 * condition-field: 备用_1[CUSTOM_1] operate-Like[like]
	 */
	private String custom1;


	/**
	 * condition-field: 备用_2[CUSTOM_2] operate-Like[like]
	 */
	private String custom2;


	/**
	 * condition-field: 备用_3[CUSTOM_3] operate-Like[like]
	 */
	private String custom3;


	/**
	 * condition-field: 备用_4[CUSTOM_4] operate-Equal[=]
	 */
	private Long custom4;


	/**
	 * condition-field: 备用_4[CUSTOM_4] operate-In[in]
	 */
	private Long[] custom4s;


	/**
	 * condition-field: 备用_4[CUSTOM_4] operate-GTEqual[>=]
	 */
	private Long startCustom4;

	/**
	 * condition-field: 备用_4[CUSTOM_4] operate-LTEqual[<=]
	 */
	private Long endCustom4;


	/**
	 * condition-field: 备用_5[CUSTOM_5] operate-Equal[=]
	 */
	private Long custom5;


	/**
	 * condition-field: 备用_5[CUSTOM_5] operate-In[in]
	 */
	private Long[] custom5s;


	/**
	 * condition-field: 备用_5[CUSTOM_5] operate-GTEqual[>=]
	 */
	private Long startCustom5;

	/**
	 * condition-field: 备用_5[CUSTOM_5] operate-LTEqual[<=]
	 */
	private Long endCustom5;


	/**
	 * condition-field: 备用_6[CUSTOM_6] operate-Equal[=]
	 */
	private Long custom6;


	/**
	 * condition-field: 备用_6[CUSTOM_6] operate-In[in]
	 */
	private Long[] custom6s;


	/**
	 * condition-field: 备用_6[CUSTOM_6] operate-GTEqual[>=]
	 */
	private Long startCustom6;

	/**
	 * condition-field: 备用_6[CUSTOM_6] operate-LTEqual[<=]
	 */
	private Long endCustom6;


	/**
	 * condition-field: 有效状态[STATUS] operate-Equal[=]
	 * 1-有效 0-无效
	 */
	private Integer status;


	/**
	 * condition-field: 有效状态[STATUS] operate-In[in]
	 * 1-有效 0-无效
	 */
	private Integer[] statuss;


	/**
	 * condition-field: 有效状态[STATUS] operate-GTEqual[>=]
	 * 1-有效 0-无效
	 */
	private Integer startStatus;

	/**
	 * condition-field: 有效状态[STATUS] operate-LTEqual[<=]
	 * 1-有效 0-无效
	 */
	private Integer endStatus;


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


	public String getRegCode() {
		return this.regCode;
	}
	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}


	public String getRegCodeEqual() {
		return this.regCodeEqual;
	}
	public void setRegCodeEqual(String regCodeEqual) {
		this.regCodeEqual = regCodeEqual;
	}


	public String[] getRegCodes() {
		return this.regCodes;
	}
	public void setRegCodes(String[] regCodes) {
		this.regCodes = regCodes;
	}


	public String getRegName() {
		return this.regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}


	public String getRegNameEqual() {
		return this.regNameEqual;
	}
	public void setRegNameEqual(String regNameEqual) {
		this.regNameEqual = regNameEqual;
	}


	public String[] getRegNames() {
		return this.regNames;
	}
	public void setRegNames(String[] regNames) {
		this.regNames = regNames;
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


	public Integer[] getRegLevels() {
		return this.regLevels;
	}
	public void setRegLevels(Integer[] regLevels) {
		this.regLevels = regLevels;
	}


	public Integer getStartRegLevel() {
		return this.startRegLevel;
	}
	public void setStartRegLevel(Integer startRegLevel) {
		this.startRegLevel = startRegLevel;
	}


	public Integer getEndRegLevel() {
		return this.endRegLevel;
	}
	public void setEndRegLevel(Integer endRegLevel) {
		this.endRegLevel = endRegLevel;
	}


	public Long getRegParentId() {
		return this.regParentId;
	}
	public void setRegParentId(Long regParentId) {
		this.regParentId = regParentId;
	}


	public Long[] getRegParentIds() {
		return this.regParentIds;
	}
	public void setRegParentIds(Long[] regParentIds) {
		this.regParentIds = regParentIds;
	}


	public Long getStartRegParentId() {
		return this.startRegParentId;
	}
	public void setStartRegParentId(Long startRegParentId) {
		this.startRegParentId = startRegParentId;
	}


	public Long getEndRegParentId() {
		return this.endRegParentId;
	}
	public void setEndRegParentId(Long endRegParentId) {
		this.endRegParentId = endRegParentId;
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


	public String getRegZipCodeEqual() {
		return this.regZipCodeEqual;
	}
	public void setRegZipCodeEqual(String regZipCodeEqual) {
		this.regZipCodeEqual = regZipCodeEqual;
	}


	public String[] getRegZipCodes() {
		return this.regZipCodes;
	}
	public void setRegZipCodes(String[] regZipCodes) {
		this.regZipCodes = regZipCodes;
	}


	public String getIcon() {
		return this.icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}


	public String getIconEqual() {
		return this.iconEqual;
	}
	public void setIconEqual(String iconEqual) {
		this.iconEqual = iconEqual;
	}


	public String[] getIcons() {
		return this.icons;
	}
	public void setIcons(String[] icons) {
		this.icons = icons;
	}


	public Integer getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}


	public Integer[] getOrderNos() {
		return this.orderNos;
	}
	public void setOrderNos(Integer[] orderNos) {
		this.orderNos = orderNos;
	}


	public Integer getStartOrderNo() {
		return this.startOrderNo;
	}
	public void setStartOrderNo(Integer startOrderNo) {
		this.startOrderNo = startOrderNo;
	}


	public Integer getEndOrderNo() {
		return this.endOrderNo;
	}
	public void setEndOrderNo(Integer endOrderNo) {
		this.endOrderNo = endOrderNo;
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


	public Long[] getCustom4s() {
		return this.custom4s;
	}
	public void setCustom4s(Long[] custom4s) {
		this.custom4s = custom4s;
	}


	public Long getStartCustom4() {
		return this.startCustom4;
	}
	public void setStartCustom4(Long startCustom4) {
		this.startCustom4 = startCustom4;
	}


	public Long getEndCustom4() {
		return this.endCustom4;
	}
	public void setEndCustom4(Long endCustom4) {
		this.endCustom4 = endCustom4;
	}


	public Long getCustom5() {
		return this.custom5;
	}
	public void setCustom5(Long custom5) {
		this.custom5 = custom5;
	}


	public Long[] getCustom5s() {
		return this.custom5s;
	}
	public void setCustom5s(Long[] custom5s) {
		this.custom5s = custom5s;
	}


	public Long getStartCustom5() {
		return this.startCustom5;
	}
	public void setStartCustom5(Long startCustom5) {
		this.startCustom5 = startCustom5;
	}


	public Long getEndCustom5() {
		return this.endCustom5;
	}
	public void setEndCustom5(Long endCustom5) {
		this.endCustom5 = endCustom5;
	}


	public Long getCustom6() {
		return this.custom6;
	}
	public void setCustom6(Long custom6) {
		this.custom6 = custom6;
	}


	public Long[] getCustom6s() {
		return this.custom6s;
	}
	public void setCustom6s(Long[] custom6s) {
		this.custom6s = custom6s;
	}


	public Long getStartCustom6() {
		return this.startCustom6;
	}
	public void setStartCustom6(Long startCustom6) {
		this.startCustom6 = startCustom6;
	}


	public Long getEndCustom6() {
		return this.endCustom6;
	}
	public void setEndCustom6(Long endCustom6) {
		this.endCustom6 = endCustom6;
	}


	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}


	public Integer[] getStatuss() {
		return this.statuss;
	}
	public void setStatuss(Integer[] statuss) {
		this.statuss = statuss;
	}


	public Integer getStartStatus() {
		return this.startStatus;
	}
	public void setStartStatus(Integer startStatus) {
		this.startStatus = startStatus;
	}


	public Integer getEndStatus() {
		return this.endStatus;
	}
	public void setEndStatus(Integer endStatus) {
		this.endStatus = endStatus;
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


