/**
 * 代码定义表单
 */


var P_form;		//表单
var P_base;		//最底层基础面版

var CurrentId;	//当前主键ID
var RoleType = 1;

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
	
	/**框的校验*/
	textarea_change();
	textarea_add_Div();
}

/** 初始化页面、内存等基本数据 **/
function initData() {
	CurrentId = PRQ.get("id");
	RoleType = PRQ.get("roleType");
	if(CU.isEmpty(RoleType)) RoleType = 1;
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

	var TF_f0 = EF.getTextField({fieldLabel:"角色代码",name:"roleCode",width:comwidth,allowBlank:false,regex:/^[0-9a-zA-Z_]+$/});	
	var TF_f1 = EF.getTextField({fieldLabel:"角色名称",name:"roleName",width:comwidth,allowBlank:false});
//	var TF_f2 = EF.getComboBox({fieldLabel:"角色类型",hiddenName:"roleType",width:comwidth,def:"V_SYS_ROLE_ROLE_TYPE"});
	var TF_f3 = EF.getCheckBox({fieldLabel:"是否有效",name:"status",inputValue:1,uncheckValue:0});
	var TF_f4 = EF.getTextArea({fieldLabel:"角色描述",name:"roleDesc",width:comwidth,height:80,width:comwidth*2+labelWidth+10});	
	
	p_Components = [TF_f0,TF_f1,TF_f3,TF_f4];

	P_form = EF.getFormPanel({tbar:[B_save,B_cancel],border:false,autoScroll:true,frame:false,width:formwidth,height:formheight,items:[
		{width:formwidth-20,border:false,bodyStyle:"padding-top:5px;",layout:"column",defaults:{layout:"form",width:stdwidth,border:false,labelWidth:labelWidth,labelAlign:"right"},items:[
			{items:[TF_f0]},{items:[TF_f1]},{items:[TF_f3]},{items:[TF_f4],width:stdwidth*2}
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
	RS.ajax({url:"/permis/sysrole/querySysRoleById",ps:{id:CurrentId},cb:function(result) {
		EU.setAllValue(p_Components, result);
		if(CU.isFunction(callback)) callback();
	}});
}

/** 保存 **/
function save() {
	//alert("保存")
	if(!P_form.isValid()) return ;
	
	
	var v1 = document.getElementById("ext-comp-1004").value.length;
	var v2 = document.getElementById("ext-comp-1005").value.length;
	if(v1>40 ){
		EU.showMsg({msg:"角色代码输入太多！（最多可输入40个字符）"});
		return false;
	}
	if(v2> 40){
		EU.showMsg({msg:"角色名称输入太多！（最多可输入40个字符）"});
		return false;
	}
	
    if(document.getElementById("x-form-el-ext-comp_110").style.display=="block"){
    	EU.showMsg({msg:"请正确填写选项  !"});
    	return false;
    }	
		
	var bean = EU.getAllValue(p_Components);
	if(!CU.isEmpty(CurrentId)) bean.id = CurrentId;
	bean.roleType = RoleType;
	EU.RS({url:"/permis/sysrole/saveOrUpdate",ps:bean,cb:function(rs) {
		CurrentId = rs;
		EU.showMsg({msg:"保存成功!"});
	}});
}





/** 关闭 **/
function closeWin() {
	//PRQ.closeWindow();
	
	var url = ContextPath;
	if(RoleType == 1) {
		url += "/dispatch/permis/SysRoleList";
	}else {
		url += "/dispatch/websys/WebRoleList";
	}
	window.location = url;
}






/**判断文本框的值改变**/
function textarea_change() {
	document.getElementById("ext-comp-1007").addEventListener("change",function(event) { 
		var html_object = document.getElementById("ext-comp-1007");
		//alert(html_object.value.length)//400
		var message_object = document.getElementById("x-form-el-ext-comp_110");
		if(html_object.value.length>400){//
			html_object.className="x-form-textarea x-form-field x-form-focus x-form-invalid";//.x-form-invalid
			message_object.innerHTML = "输入框的值最大可输入400个字符，当前已输入"+html_object.value.length+"个字符"; 
			message_object.style.display = "block"; 
			return false;
		}
		message_object.style.display = "none";

		},false);	
}

function textarea_add_Div(){
	var father_object = document.getElementById("x-form-el-ext-comp-1007");
	var newNode = document.createElement("div"); 
	newNode.innerHTML = " "; 
	newNode.style = "width: 280px; margin-left:95px; display: none;";
	newNode.className = "x-form-invalid-msg";
	newNode.id = "x-form-el-ext-comp_110";
	father_object.appendChild(newNode); 
	//father_object.insertBefore(newNode,null);
}













