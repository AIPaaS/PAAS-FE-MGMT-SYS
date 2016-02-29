package com.aic.paas.sys.bean;




import com.binary.framework.bean.Condition;


/**
 * condition-table: 组织表[SYS_ORG]
 */
public class CSysOrg implements Condition {
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
	 * condition-field: 组织代码[ORG_CODE] operate-Like[like]
	 */
	private String orgCode;


	/**
	 * condition-field: 组织代码[ORG_CODE] operate-Equal[=]
	 */
	private String orgCodeEqual;


	/**
	 * condition-field: 组织代码[ORG_CODE] operate-In[in]
	 */
	private String[] orgCodes;


	/**
	 * condition-field: 组织名称[ORG_NAME] operate-Like[like]
	 */
	private String orgName;


	/**
	 * condition-field: 组织类型[ORG_TYPE_ID] operate-Equal[=]
	 */
	private Long orgTypeId;


	/**
	 * condition-field: 组织类型[ORG_TYPE_ID] operate-In[in]
	 */
	private Long[] orgTypeIds;


	/**
	 * condition-field: 组织类型[ORG_TYPE_ID] operate-GTEqual[>=]
	 */
	private Long startOrgTypeId;

	/**
	 * condition-field: 组织类型[ORG_TYPE_ID] operate-LTEqual[<=]
	 */
	private Long endOrgTypeId;


	/**
	 * condition-field: 上级组织ID[PARENT_ORG_ID] operate-Equal[=]
	 */
	private Long parentOrgId;


	/**
	 * condition-field: 上级组织ID[PARENT_ORG_ID] operate-In[in]
	 */
	private Long[] parentOrgIds;


	/**
	 * condition-field: 上级组织ID[PARENT_ORG_ID] operate-GTEqual[>=]
	 */
	private Long startParentOrgId;

	/**
	 * condition-field: 上级组织ID[PARENT_ORG_ID] operate-LTEqual[<=]
	 */
	private Long endParentOrgId;


	/**
	 * condition-field: 组织级别[ORG_LEVEL] operate-Equal[=]
	 * 组织级别：1-一级 2-二级 3-三级 4-四级 ...
	 */
	private Integer orgLevel;


	/**
	 * condition-field: 组织级别[ORG_LEVEL] operate-In[in]
	 * 组织级别：1-一级 2-二级 3-三级 4-四级 ...
	 */
	private Integer[] orgLevels;


	/**
	 * condition-field: 组织级别[ORG_LEVEL] operate-GTEqual[>=]
	 * 组织级别：1-一级 2-二级 3-三级 4-四级 ...
	 */
	private Integer startOrgLevel;

	/**
	 * condition-field: 组织级别[ORG_LEVEL] operate-LTEqual[<=]
	 * 组织级别：1-一级 2-二级 3-三级 4-四级 ...
	 */
	private Integer endOrgLevel;


	/**
	 * condition-field: 组织层级路径[ORG_LVL_PATH] operate-Like[like]
	 * 组织层级路径（从根组织ID到当前组织ID的上下级层级路径串，用#号分隔）
	 */
	private String orgLvlPath;


	/**
	 * condition-field: 是否末级[IS_LEAF] operate-Equal[=]
	 * 0=非末级 1=末级
	 */
	private Integer isLeaf;


	/**
	 * condition-field: 是否末级[IS_LEAF] operate-In[in]
	 * 0=非末级 1=末级
	 */
	private Integer[] isLeafs;


	/**
	 * condition-field: 是否末级[IS_LEAF] operate-GTEqual[>=]
	 * 0=非末级 1=末级
	 */
	private Integer startIsLeaf;

	/**
	 * condition-field: 是否末级[IS_LEAF] operate-LTEqual[<=]
	 * 0=非末级 1=末级
	 */
	private Integer endIsLeaf;


	/**
	 * condition-field: 权限组织ID[AUTH_ORG_ID] operate-Equal[=]
	 * 权限组织ID（记录该组织具有权限的组织ID，如公司类组织的权限组织是其自身，部门类组织的权限组织是所属公司）
	 */
	private Long authOrgId;


	/**
	 * condition-field: 权限组织ID[AUTH_ORG_ID] operate-In[in]
	 * 权限组织ID（记录该组织具有权限的组织ID，如公司类组织的权限组织是其自身，部门类组织的权限组织是所属公司）
	 */
	private Long[] authOrgIds;


	/**
	 * condition-field: 权限组织ID[AUTH_ORG_ID] operate-GTEqual[>=]
	 * 权限组织ID（记录该组织具有权限的组织ID，如公司类组织的权限组织是其自身，部门类组织的权限组织是所属公司）
	 */
	private Long startAuthOrgId;

	/**
	 * condition-field: 权限组织ID[AUTH_ORG_ID] operate-LTEqual[<=]
	 * 权限组织ID（记录该组织具有权限的组织ID，如公司类组织的权限组织是其自身，部门类组织的权限组织是所属公司）
	 */
	private Long endAuthOrgId;


	/**
	 * condition-field: 简称[SHORT_NAME] operate-Like[like]
	 */
	private String shortName;


	/**
	 * condition-field: 英文名[ENGLISH_NAME] operate-Like[like]
	 */
	private String englishName;


	/**
	 * condition-field: 地区编码[DISTRICT_ID] operate-Like[like]
	 */
	private String districtId;


	/**
	 * condition-field: 地区编码[DISTRICT_ID] operate-Equal[=]
	 */
	private String districtIdEqual;


	/**
	 * condition-field: 地区编码[DISTRICT_ID] operate-In[in]
	 */
	private String[] districtIds;


	/**
	 * condition-field: 人数[MEMBER_NUM] operate-Equal[=]
	 */
	private Integer memberNum;


	/**
	 * condition-field: 人数[MEMBER_NUM] operate-In[in]
	 */
	private Integer[] memberNums;


	/**
	 * condition-field: 人数[MEMBER_NUM] operate-GTEqual[>=]
	 */
	private Integer startMemberNum;

	/**
	 * condition-field: 人数[MEMBER_NUM] operate-LTEqual[<=]
	 */
	private Integer endMemberNum;


	/**
	 * condition-field: 负责人名称[MANAGER_NAME] operate-Like[like]
	 */
	private String managerName;


	/**
	 * condition-field: 负责人名称[MANAGER_NAME] operate-Equal[=]
	 */
	private String managerNameEqual;


	/**
	 * condition-field: 负责人名称[MANAGER_NAME] operate-In[in]
	 */
	private String[] managerNames;


	/**
	 * condition-field: 电子邮件地址[EMAIL] operate-Like[like]
	 */
	private String email;


	/**
	 * condition-field: 电子邮件地址[EMAIL] operate-Equal[=]
	 */
	private String emailEqual;


	/**
	 * condition-field: 电子邮件地址[EMAIL] operate-In[in]
	 */
	private String[] emails;


	/**
	 * condition-field: 联系电话[PHONE] operate-Like[like]
	 */
	private String phone;


	/**
	 * condition-field: 联系电话[PHONE] operate-Equal[=]
	 */
	private String phoneEqual;


	/**
	 * condition-field: 联系电话[PHONE] operate-In[in]
	 */
	private String[] phones;


	/**
	 * condition-field: 传真号[FAX] operate-Like[like]
	 */
	private String fax;


	/**
	 * condition-field: 传真号[FAX] operate-Equal[=]
	 */
	private String faxEqual;


	/**
	 * condition-field: 传真号[FAX] operate-In[in]
	 */
	private String[] faxs;


	/**
	 * condition-field: 组织地址[ORG_ADDRESS] operate-Like[like]
	 */
	private String orgAddress;


	/**
	 * condition-field: 联系人姓名[CONTACT_NAME] operate-Like[like]
	 */
	private String contactName;


	/**
	 * condition-field: 联系人姓名[CONTACT_NAME] operate-Equal[=]
	 */
	private String contactNameEqual;


	/**
	 * condition-field: 联系人姓名[CONTACT_NAME] operate-In[in]
	 */
	private String[] contactNames;


	/**
	 * condition-field: 联人证类型[CONTACT_CARD_TYPE] operate-Equal[=]
	 */
	private Integer contactCardType;


	/**
	 * condition-field: 联人证类型[CONTACT_CARD_TYPE] operate-In[in]
	 */
	private Integer[] contactCardTypes;


	/**
	 * condition-field: 联人证类型[CONTACT_CARD_TYPE] operate-GTEqual[>=]
	 */
	private Integer startContactCardType;

	/**
	 * condition-field: 联人证类型[CONTACT_CARD_TYPE] operate-LTEqual[<=]
	 */
	private Integer endContactCardType;


	/**
	 * condition-field: 联系人证件号码[CONTACT_CARD_CODE] operate-Like[like]
	 */
	private String contactCardCode;


	/**
	 * condition-field: 联系人证件号码[CONTACT_CARD_CODE] operate-Equal[=]
	 */
	private String contactCardCodeEqual;


	/**
	 * condition-field: 联系人证件号码[CONTACT_CARD_CODE] operate-In[in]
	 */
	private String[] contactCardCodes;


	/**
	 * condition-field: 联系人手机[CONTACT_MOBILE] operate-Like[like]
	 */
	private String contactMobile;


	/**
	 * condition-field: 联系人手机[CONTACT_MOBILE] operate-Equal[=]
	 */
	private String contactMobileEqual;


	/**
	 * condition-field: 联系人手机[CONTACT_MOBILE] operate-In[in]
	 */
	private String[] contactMobiles;


	/**
	 * condition-field: 国家ID[NATIONALITY_ID] operate-Equal[=]
	 */
	private Long nationalityId;


	/**
	 * condition-field: 国家ID[NATIONALITY_ID] operate-In[in]
	 */
	private Long[] nationalityIds;


	/**
	 * condition-field: 国家ID[NATIONALITY_ID] operate-GTEqual[>=]
	 */
	private Long startNationalityId;

	/**
	 * condition-field: 国家ID[NATIONALITY_ID] operate-LTEqual[<=]
	 */
	private Long endNationalityId;


	/**
	 * condition-field: 省份ID[PROVINCE_ID] operate-Equal[=]
	 */
	private Long provinceId;


	/**
	 * condition-field: 省份ID[PROVINCE_ID] operate-In[in]
	 */
	private Long[] provinceIds;


	/**
	 * condition-field: 省份ID[PROVINCE_ID] operate-GTEqual[>=]
	 */
	private Long startProvinceId;

	/**
	 * condition-field: 省份ID[PROVINCE_ID] operate-LTEqual[<=]
	 */
	private Long endProvinceId;


	/**
	 * condition-field: 地市ID[CITY_ID] operate-Equal[=]
	 */
	private Long cityId;


	/**
	 * condition-field: 地市ID[CITY_ID] operate-In[in]
	 */
	private Long[] cityIds;


	/**
	 * condition-field: 地市ID[CITY_ID] operate-GTEqual[>=]
	 */
	private Long startCityId;

	/**
	 * condition-field: 地市ID[CITY_ID] operate-LTEqual[<=]
	 */
	private Long endCityId;


	/**
	 * condition-field: 区县ID[COUNTY_ID] operate-Equal[=]
	 */
	private Long countyId;


	/**
	 * condition-field: 区县ID[COUNTY_ID] operate-In[in]
	 */
	private Long[] countyIds;


	/**
	 * condition-field: 区县ID[COUNTY_ID] operate-GTEqual[>=]
	 */
	private Long startCountyId;

	/**
	 * condition-field: 区县ID[COUNTY_ID] operate-LTEqual[<=]
	 */
	private Long endCountyId;


	/**
	 * condition-field: 邮政编码[POSTAL_CODE] operate-Equal[=]
	 */
	private Integer postalCode;


	/**
	 * condition-field: 邮政编码[POSTAL_CODE] operate-In[in]
	 */
	private Integer[] postalCodes;


	/**
	 * condition-field: 邮政编码[POSTAL_CODE] operate-GTEqual[>=]
	 */
	private Integer startPostalCode;

	/**
	 * condition-field: 邮政编码[POSTAL_CODE] operate-LTEqual[<=]
	 */
	private Integer endPostalCode;


	/**
	 * condition-field: 备注[REMARK] operate-Like[like]
	 */
	private String remark;


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
	 * condition-field: 状态[STATUS] operate-Equal[=]
	 * 状态：1-正常 0-停用
	 */
	private Integer status;


	/**
	 * condition-field: 状态[STATUS] operate-In[in]
	 * 状态：1-正常 0-停用
	 */
	private Integer[] statuss;


	/**
	 * condition-field: 状态[STATUS] operate-GTEqual[>=]
	 * 状态：1-正常 0-停用
	 */
	private Integer startStatus;

	/**
	 * condition-field: 状态[STATUS] operate-LTEqual[<=]
	 * 状态：1-正常 0-停用
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
	 * condition-field: 创建人[CREATOR] operate-Like[like]
	 */
	private String creator;


	/**
	 * condition-field: 创建人[CREATOR] operate-Equal[=]
	 */
	private String creatorEqual;


	/**
	 * condition-field: 创建人[CREATOR] operate-In[in]
	 */
	private String[] creators;


	/**
	 * condition-field: 修改人[MODIFIER] operate-Like[like]
	 */
	private String modifier;


	/**
	 * condition-field: 修改人[MODIFIER] operate-Equal[=]
	 */
	private String modifierEqual;


	/**
	 * condition-field: 修改人[MODIFIER] operate-In[in]
	 */
	private String[] modifiers;


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


	public String getOrgCode() {
		return this.orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}


	public String getOrgCodeEqual() {
		return this.orgCodeEqual;
	}
	public void setOrgCodeEqual(String orgCodeEqual) {
		this.orgCodeEqual = orgCodeEqual;
	}


	public String[] getOrgCodes() {
		return this.orgCodes;
	}
	public void setOrgCodes(String[] orgCodes) {
		this.orgCodes = orgCodes;
	}


	public String getOrgName() {
		return this.orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


	public Long getOrgTypeId() {
		return this.orgTypeId;
	}
	public void setOrgTypeId(Long orgTypeId) {
		this.orgTypeId = orgTypeId;
	}


	public Long[] getOrgTypeIds() {
		return this.orgTypeIds;
	}
	public void setOrgTypeIds(Long[] orgTypeIds) {
		this.orgTypeIds = orgTypeIds;
	}


	public Long getStartOrgTypeId() {
		return this.startOrgTypeId;
	}
	public void setStartOrgTypeId(Long startOrgTypeId) {
		this.startOrgTypeId = startOrgTypeId;
	}


	public Long getEndOrgTypeId() {
		return this.endOrgTypeId;
	}
	public void setEndOrgTypeId(Long endOrgTypeId) {
		this.endOrgTypeId = endOrgTypeId;
	}


	public Long getParentOrgId() {
		return this.parentOrgId;
	}
	public void setParentOrgId(Long parentOrgId) {
		this.parentOrgId = parentOrgId;
	}


	public Long[] getParentOrgIds() {
		return this.parentOrgIds;
	}
	public void setParentOrgIds(Long[] parentOrgIds) {
		this.parentOrgIds = parentOrgIds;
	}


	public Long getStartParentOrgId() {
		return this.startParentOrgId;
	}
	public void setStartParentOrgId(Long startParentOrgId) {
		this.startParentOrgId = startParentOrgId;
	}


	public Long getEndParentOrgId() {
		return this.endParentOrgId;
	}
	public void setEndParentOrgId(Long endParentOrgId) {
		this.endParentOrgId = endParentOrgId;
	}


	public Integer getOrgLevel() {
		return this.orgLevel;
	}
	public void setOrgLevel(Integer orgLevel) {
		this.orgLevel = orgLevel;
	}


	public Integer[] getOrgLevels() {
		return this.orgLevels;
	}
	public void setOrgLevels(Integer[] orgLevels) {
		this.orgLevels = orgLevels;
	}


	public Integer getStartOrgLevel() {
		return this.startOrgLevel;
	}
	public void setStartOrgLevel(Integer startOrgLevel) {
		this.startOrgLevel = startOrgLevel;
	}


	public Integer getEndOrgLevel() {
		return this.endOrgLevel;
	}
	public void setEndOrgLevel(Integer endOrgLevel) {
		this.endOrgLevel = endOrgLevel;
	}


	public String getOrgLvlPath() {
		return this.orgLvlPath;
	}
	public void setOrgLvlPath(String orgLvlPath) {
		this.orgLvlPath = orgLvlPath;
	}


	public Integer getIsLeaf() {
		return this.isLeaf;
	}
	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
	}


	public Integer[] getIsLeafs() {
		return this.isLeafs;
	}
	public void setIsLeafs(Integer[] isLeafs) {
		this.isLeafs = isLeafs;
	}


	public Integer getStartIsLeaf() {
		return this.startIsLeaf;
	}
	public void setStartIsLeaf(Integer startIsLeaf) {
		this.startIsLeaf = startIsLeaf;
	}


	public Integer getEndIsLeaf() {
		return this.endIsLeaf;
	}
	public void setEndIsLeaf(Integer endIsLeaf) {
		this.endIsLeaf = endIsLeaf;
	}


	public Long getAuthOrgId() {
		return this.authOrgId;
	}
	public void setAuthOrgId(Long authOrgId) {
		this.authOrgId = authOrgId;
	}


	public Long[] getAuthOrgIds() {
		return this.authOrgIds;
	}
	public void setAuthOrgIds(Long[] authOrgIds) {
		this.authOrgIds = authOrgIds;
	}


	public Long getStartAuthOrgId() {
		return this.startAuthOrgId;
	}
	public void setStartAuthOrgId(Long startAuthOrgId) {
		this.startAuthOrgId = startAuthOrgId;
	}


	public Long getEndAuthOrgId() {
		return this.endAuthOrgId;
	}
	public void setEndAuthOrgId(Long endAuthOrgId) {
		this.endAuthOrgId = endAuthOrgId;
	}


	public String getShortName() {
		return this.shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}


	public String getEnglishName() {
		return this.englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}


	public String getDistrictId() {
		return this.districtId;
	}
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}


	public String getDistrictIdEqual() {
		return this.districtIdEqual;
	}
	public void setDistrictIdEqual(String districtIdEqual) {
		this.districtIdEqual = districtIdEqual;
	}


	public String[] getDistrictIds() {
		return this.districtIds;
	}
	public void setDistrictIds(String[] districtIds) {
		this.districtIds = districtIds;
	}


	public Integer getMemberNum() {
		return this.memberNum;
	}
	public void setMemberNum(Integer memberNum) {
		this.memberNum = memberNum;
	}


	public Integer[] getMemberNums() {
		return this.memberNums;
	}
	public void setMemberNums(Integer[] memberNums) {
		this.memberNums = memberNums;
	}


	public Integer getStartMemberNum() {
		return this.startMemberNum;
	}
	public void setStartMemberNum(Integer startMemberNum) {
		this.startMemberNum = startMemberNum;
	}


	public Integer getEndMemberNum() {
		return this.endMemberNum;
	}
	public void setEndMemberNum(Integer endMemberNum) {
		this.endMemberNum = endMemberNum;
	}


	public String getManagerName() {
		return this.managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}


	public String getManagerNameEqual() {
		return this.managerNameEqual;
	}
	public void setManagerNameEqual(String managerNameEqual) {
		this.managerNameEqual = managerNameEqual;
	}


	public String[] getManagerNames() {
		return this.managerNames;
	}
	public void setManagerNames(String[] managerNames) {
		this.managerNames = managerNames;
	}


	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public String getEmailEqual() {
		return this.emailEqual;
	}
	public void setEmailEqual(String emailEqual) {
		this.emailEqual = emailEqual;
	}


	public String[] getEmails() {
		return this.emails;
	}
	public void setEmails(String[] emails) {
		this.emails = emails;
	}


	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPhoneEqual() {
		return this.phoneEqual;
	}
	public void setPhoneEqual(String phoneEqual) {
		this.phoneEqual = phoneEqual;
	}


	public String[] getPhones() {
		return this.phones;
	}
	public void setPhones(String[] phones) {
		this.phones = phones;
	}


	public String getFax() {
		return this.fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}


	public String getFaxEqual() {
		return this.faxEqual;
	}
	public void setFaxEqual(String faxEqual) {
		this.faxEqual = faxEqual;
	}


	public String[] getFaxs() {
		return this.faxs;
	}
	public void setFaxs(String[] faxs) {
		this.faxs = faxs;
	}


	public String getOrgAddress() {
		return this.orgAddress;
	}
	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}


	public String getContactName() {
		return this.contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}


	public String getContactNameEqual() {
		return this.contactNameEqual;
	}
	public void setContactNameEqual(String contactNameEqual) {
		this.contactNameEqual = contactNameEqual;
	}


	public String[] getContactNames() {
		return this.contactNames;
	}
	public void setContactNames(String[] contactNames) {
		this.contactNames = contactNames;
	}


	public Integer getContactCardType() {
		return this.contactCardType;
	}
	public void setContactCardType(Integer contactCardType) {
		this.contactCardType = contactCardType;
	}


	public Integer[] getContactCardTypes() {
		return this.contactCardTypes;
	}
	public void setContactCardTypes(Integer[] contactCardTypes) {
		this.contactCardTypes = contactCardTypes;
	}


	public Integer getStartContactCardType() {
		return this.startContactCardType;
	}
	public void setStartContactCardType(Integer startContactCardType) {
		this.startContactCardType = startContactCardType;
	}


	public Integer getEndContactCardType() {
		return this.endContactCardType;
	}
	public void setEndContactCardType(Integer endContactCardType) {
		this.endContactCardType = endContactCardType;
	}


	public String getContactCardCode() {
		return this.contactCardCode;
	}
	public void setContactCardCode(String contactCardCode) {
		this.contactCardCode = contactCardCode;
	}


	public String getContactCardCodeEqual() {
		return this.contactCardCodeEqual;
	}
	public void setContactCardCodeEqual(String contactCardCodeEqual) {
		this.contactCardCodeEqual = contactCardCodeEqual;
	}


	public String[] getContactCardCodes() {
		return this.contactCardCodes;
	}
	public void setContactCardCodes(String[] contactCardCodes) {
		this.contactCardCodes = contactCardCodes;
	}


	public String getContactMobile() {
		return this.contactMobile;
	}
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}


	public String getContactMobileEqual() {
		return this.contactMobileEqual;
	}
	public void setContactMobileEqual(String contactMobileEqual) {
		this.contactMobileEqual = contactMobileEqual;
	}


	public String[] getContactMobiles() {
		return this.contactMobiles;
	}
	public void setContactMobiles(String[] contactMobiles) {
		this.contactMobiles = contactMobiles;
	}


	public Long getNationalityId() {
		return this.nationalityId;
	}
	public void setNationalityId(Long nationalityId) {
		this.nationalityId = nationalityId;
	}


	public Long[] getNationalityIds() {
		return this.nationalityIds;
	}
	public void setNationalityIds(Long[] nationalityIds) {
		this.nationalityIds = nationalityIds;
	}


	public Long getStartNationalityId() {
		return this.startNationalityId;
	}
	public void setStartNationalityId(Long startNationalityId) {
		this.startNationalityId = startNationalityId;
	}


	public Long getEndNationalityId() {
		return this.endNationalityId;
	}
	public void setEndNationalityId(Long endNationalityId) {
		this.endNationalityId = endNationalityId;
	}


	public Long getProvinceId() {
		return this.provinceId;
	}
	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}


	public Long[] getProvinceIds() {
		return this.provinceIds;
	}
	public void setProvinceIds(Long[] provinceIds) {
		this.provinceIds = provinceIds;
	}


	public Long getStartProvinceId() {
		return this.startProvinceId;
	}
	public void setStartProvinceId(Long startProvinceId) {
		this.startProvinceId = startProvinceId;
	}


	public Long getEndProvinceId() {
		return this.endProvinceId;
	}
	public void setEndProvinceId(Long endProvinceId) {
		this.endProvinceId = endProvinceId;
	}


	public Long getCityId() {
		return this.cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}


	public Long[] getCityIds() {
		return this.cityIds;
	}
	public void setCityIds(Long[] cityIds) {
		this.cityIds = cityIds;
	}


	public Long getStartCityId() {
		return this.startCityId;
	}
	public void setStartCityId(Long startCityId) {
		this.startCityId = startCityId;
	}


	public Long getEndCityId() {
		return this.endCityId;
	}
	public void setEndCityId(Long endCityId) {
		this.endCityId = endCityId;
	}


	public Long getCountyId() {
		return this.countyId;
	}
	public void setCountyId(Long countyId) {
		this.countyId = countyId;
	}


	public Long[] getCountyIds() {
		return this.countyIds;
	}
	public void setCountyIds(Long[] countyIds) {
		this.countyIds = countyIds;
	}


	public Long getStartCountyId() {
		return this.startCountyId;
	}
	public void setStartCountyId(Long startCountyId) {
		this.startCountyId = startCountyId;
	}


	public Long getEndCountyId() {
		return this.endCountyId;
	}
	public void setEndCountyId(Long endCountyId) {
		this.endCountyId = endCountyId;
	}


	public Integer getPostalCode() {
		return this.postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}


	public Integer[] getPostalCodes() {
		return this.postalCodes;
	}
	public void setPostalCodes(Integer[] postalCodes) {
		this.postalCodes = postalCodes;
	}


	public Integer getStartPostalCode() {
		return this.startPostalCode;
	}
	public void setStartPostalCode(Integer startPostalCode) {
		this.startPostalCode = startPostalCode;
	}


	public Integer getEndPostalCode() {
		return this.endPostalCode;
	}
	public void setEndPostalCode(Integer endPostalCode) {
		this.endPostalCode = endPostalCode;
	}


	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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


	public String getCreator() {
		return this.creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}


	public String getCreatorEqual() {
		return this.creatorEqual;
	}
	public void setCreatorEqual(String creatorEqual) {
		this.creatorEqual = creatorEqual;
	}


	public String[] getCreators() {
		return this.creators;
	}
	public void setCreators(String[] creators) {
		this.creators = creators;
	}


	public String getModifier() {
		return this.modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}


	public String getModifierEqual() {
		return this.modifierEqual;
	}
	public void setModifierEqual(String modifierEqual) {
		this.modifierEqual = modifierEqual;
	}


	public String[] getModifiers() {
		return this.modifiers;
	}
	public void setModifiers(String[] modifiers) {
		this.modifiers = modifiers;
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


