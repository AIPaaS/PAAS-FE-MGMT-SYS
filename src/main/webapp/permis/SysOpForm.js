/**
 * 代码定义表单
 */


var P_form;		//表单
var P_base;		//最底层基础面版

var CurrentId;	//当前主键ID
var OpKind = 1;

var p_Components;	//表单组件


/** 初始化 **/
function init() {
	initData();
	initComponent();
	initListener();
	initFace();
	P_form.setWidth(P_base.getInnerWidth());
	P_form.setHeight(P_base.getInnerHeight());
	if(!CU.isEmpty(CurrentId)) {
		queryInfo();
	}
}

/** 初始化页面、内存等基本数据 **/
function initData() {
	CurrentId = PRQ.get("id");
	OpKind = PRQ.get("opKind");
	if(CU.isEmpty(OpKind)) OpKind = 1;
	if(CU.isEmpty(CurrentId))CurrentId="";
}

/** 初始化组件 **/
function initComponent() {
	var B_save = EF.getButton({text:"保存",name:"btn_op_save",iconCls:"btn_save",handler:save});
	var B_cancel = EF.getButton({text:"返回",name:"btn_op_close",iconCls:"btn_unpassing",handler:closeWin});

	var formwidth = 600;		//表单总宽度
	var formheight = 400;		//表单总高度
	var labelWidth = 100;		//标签宽度
	var comwidth = 140;			//组件宽度
	var stdwidth = labelWidth+comwidth+10;	//标准宽度(标签宽度+组件宽度)

	var TF_f0 = EF.getTextField({fieldLabel:"用户编号",name:"opCode",width:comwidth,allowBlank:false,regex:/^[0-9a-zA-Z_]+$/});	
	var TF_f1 = EF.getTextField({fieldLabel:"用户姓名",name:"opName",width:comwidth,allowBlank:false});
//	var TF_f2 = EF.getComboBox({fieldLabel:"用户类别",hiddenName:"opKind",width:comwidth,def:"V_SYS_OP_OP_KIND",allowBlank:false});
	var TF_f3 = EF.getTextField({fieldLabel:"手机号",name:"mobileNo",width:comwidth});
	var TF_f4 = EF.getTextField({fieldLabel:"电子邮件地址",name:"emailAdress",width:comwidth,allowBlank:false,regex:/^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/});
	var TF_f5 = EF.getTextField({fieldLabel:"登录代码",name:"loginCode",width:comwidth,allowBlank:false,regex:/^[0-9a-zA-Z_]+$/});
	var TF_f6 = EF.getComboBox({fieldLabel:"性别",hiddenName:"gender",width:comwidth,def:"V_SYS_OP_GENDER"});
	var TF_f7 = EF.getTextField({fieldLabel:"办公电话",name:"officeTel",width:comwidth});	
	var TF_f9 = EF.getCheckBox({fieldLabel:"是否锁定",name:"lockFlag",width:comwidth,def:"V_SYS_OP_LOCK_FLAG",inputValue:1,uncheckValue:0});
	var TF_f10 = EF.getCheckBox({fieldLabel:"是否修改密码",name:"isUpdatePwd",width:comwidth,def:"V_SYS_OP_IS_UPDATE_PWD",inputValue:1,uncheckValue:0});
	var TF_f11 = EF.getCheckBox({fieldLabel:"是否有效",name:"status",inputValue:1,uncheckValue:0});
	var TF_f8 = EF.getTextArea({fieldLabel:"备注",name:"notes",width:comwidth,height:80,width:comwidth*2+labelWidth+10});	
	
	p_Components = [TF_f0,TF_f1,TF_f3,TF_f4,TF_f5,TF_f6,TF_f7,TF_f9,TF_f10,TF_f11,TF_f8];

	P_form = EF.getFormPanel({tbar:[B_save,B_cancel],border:false,autoScroll:true,frame:false,width:formwidth,height:formheight,items:[
		{width:formwidth-20,border:false,bodyStyle:"padding-top:5px;",layout:"column",defaults:{layout:"form",width:stdwidth,border:false,labelWidth:labelWidth,labelAlign:"right"},items:[
			{items:[TF_f0]},{items:[TF_f1]},{items:[TF_f3]},{items:[TF_f4]},{items:[TF_f5]},{items:[TF_f6]},
			{items:[TF_f7]},{items:[TF_f9]},{items:[TF_f10]},{items:[TF_f11],width:stdwidth*2},{items:[TF_f8],width:stdwidth*2}
		]}
	]});
	
	P_base = EF.getPanel({border:false,items:[P_form]});
}

/** 对组件设置监听 **/
function initListener() {
}

/** 初始化界面 **/
function initFace() {
	new Ext.Viewport({layout:"fit",items: [P_base]});
}

/** 查询详细信息 **/
function queryInfo(callback) {
	RS.ajax({url:"/permis/sysop/querySysOpById",ps:{id:CurrentId},cb:function(result) {
		EU.setAllValue(p_Components, result);
		if(CU.isFunction(callback)) callback();
	}});
}

/** 保存 **/
function save() {
	if(!P_form.isValid()) return ;
	var bean = EU.getAllValue(p_Components);
	bean.opKind = OpKind;
	if(!CU.isEmpty(CurrentId)) bean.id = CurrentId;
	EU.RS({url:"/permis/sysop/saveOrUpdate",ps:bean,cb:function(rs) {
		CurrentId = rs;
		EU.showMsg({msg:"保存成功!"});
	}});
}





/** 关闭 **/
function closeWin() {
	//PRQ.closeWindow();
	var url = ContextPath + "/dispatch/permis/SysOpList";
	window.location = url;
}




