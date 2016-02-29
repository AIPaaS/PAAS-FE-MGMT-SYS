package com.aic.paas.sys.bean;




import com.binary.framework.bean.EntityBean;


/**
 * mapping-table: 组织表[SYS_ORG]
 */
public class SysOrg implements EntityBean {
	private static final long serialVersionUID = 1L;


	/**
	 * mapping-field: ID[ID]
	 */
	private Long id;


	/**
	 * mapping-field: 组织代码[ORG_CODE]
	 */
	private String orgCode;


	/**
	 * mapping-field: 组织名称[ORG_NAME]
	 */
	private String orgName;


	/**
	 * mapping-field: 组织类型[ORG_TYPE_ID]
	 */
	private Long orgTypeId;


	/**
	 * mapping-field: 上级组织ID[PARENT_ORG_ID]
	 */
	private Long parentOrgId;


	/**
	 * mapping-field: 组织级别[ORG_LEVEL]
	 * 组织级别：1-一级 2-二级 3-三级 4-四级 ...
	 */
	private Integer orgLevel;


	/**
	 * mapping-field: 组织层级路径[ORG_LVL_PATH]
	 * 组织层级路径（从根组织ID到当前组织ID的上下级层级路径串，用#号分隔）
	 */
	private String orgLvlPath;


	/**
	 * mapping-field: 是否末级[IS_LEAF]
	 * 0=非末级 1=末级
	 */
	private Integer isLeaf;


	/**
	 * mapping-field: 权限组织ID[AUTH_ORG_ID]
	 * 权限组织ID（记录该组织具有权限的组织ID，如公司类组织的权限组织是其自身，部门类组织的权限组织是所属公司）
	 */
	private Long authOrgId;


	/**
	 * mapping-field: 简称[SHORT_NAME]
	 */
	private String shortName;


	/**
	 * mapping-field: 英文名[ENGLISH_NAME]
	 */
	private String englishName;


	/**
	 * mapping-field: 地区编码[DISTRICT_ID]
	 */
	private String districtId;


	/**
	 * mapping-field: 人数[MEMBER_NUM]
	 */
	private Integer memberNum;


	/**
	 * mapping-field: 负责人名称[MANAGER_NAME]
	 */
	private String managerName;


	/**
	 * mapping-field: 电子邮件地址[EMAIL]
	 */
	private String email;


	/**
	 * mapping-field: 联系电话[PHONE]
	 */
	private String phone;


	/**
	 * mapping-field: 传真号[FAX]
	 */
	private String fax;


	/**
	 * mapping-field: 组织地址[ORG_ADDRESS]
	 */
	private String orgAddress;


	/**
	 * mapping-field: 联系人姓名[CONTACT_NAME]
	 */
	private String contactName;


	/**
	 * mapping-field: 联人证类型[CONTACT_CARD_TYPE]
	 */
	private Integer contactCardType;


	/**
	 * mapping-field: 联系人证件号码[CONTACT_CARD_CODE]
	 */
	private String contactCardCode;


	/**
	 * mapping-field: 联系人手机[CONTACT_MOBILE]
	 */
	private String contactMobile;


	/**
	 * mapping-field: 国家ID[NATIONALITY_ID]
	 */
	private Long nationalityId;


	/**
	 * mapping-field: 省份ID[PROVINCE_ID]
	 */
	private Long provinceId;


	/**
	 * mapping-field: 地市ID[CITY_ID]
	 */
	private Long cityId;


	/**
	 * mapping-field: 区县ID[COUNTY_ID]
	 */
	private Long countyId;


	/**
	 * mapping-field: 邮政编码[POSTAL_CODE]
	 */
	private Integer postalCode;


	/**
	 * mapping-field: 备注[REMARK]
	 */
	private String remark;


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
	 * mapping-field: 状态[STATUS]
	 * 状态：1-正常 0-停用
	 */
	private Integer status;


	/**
	 * mapping-field: 数据状态[DATA_STATUS]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer dataStatus;


	/**
	 * mapping-field: 创建人[CREATOR]
	 */
	private String creator;


	/**
	 * mapping-field: 修改人[MODIFIER]
	 */
	private String modifier;


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


	public String getOrgCode() {
		return this.orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
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


	public Long getParentOrgId() {
		return this.parentOrgId;
	}
	public void setParentOrgId(Long parentOrgId) {
		this.parentOrgId = parentOrgId;
	}


	public Integer getOrgLevel() {
		return this.orgLevel;
	}
	public void setOrgLevel(Integer orgLevel) {
		this.orgLevel = orgLevel;
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


	public Long getAuthOrgId() {
		return this.authOrgId;
	}
	public void setAuthOrgId(Long authOrgId) {
		this.authOrgId = authOrgId;
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


	public Integer getMemberNum() {
		return this.memberNum;
	}
	public void setMemberNum(Integer memberNum) {
		this.memberNum = memberNum;
	}


	public String getManagerName() {
		return this.managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}


	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getFax() {
		return this.fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
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


	public Integer getContactCardType() {
		return this.contactCardType;
	}
	public void setContactCardType(Integer contactCardType) {
		this.contactCardType = contactCardType;
	}


	public String getContactCardCode() {
		return this.contactCardCode;
	}
	public void setContactCardCode(String contactCardCode) {
		this.contactCardCode = contactCardCode;
	}


	public String getContactMobile() {
		return this.contactMobile;
	}
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}


	public Long getNationalityId() {
		return this.nationalityId;
	}
	public void setNationalityId(Long nationalityId) {
		this.nationalityId = nationalityId;
	}


	public Long getProvinceId() {
		return this.provinceId;
	}
	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}


	public Long getCityId() {
		return this.cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}


	public Long getCountyId() {
		return this.countyId;
	}
	public void setCountyId(Long countyId) {
		this.countyId = countyId;
	}


	public Integer getPostalCode() {
		return this.postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
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


	public String getCreator() {
		return this.creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}


	public String getModifier() {
		return this.modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
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


