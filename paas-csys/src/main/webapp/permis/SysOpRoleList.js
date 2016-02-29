

var P_base;			//最底层基础面版

var CurrentOpId = "";	//当前用户ID

var RoleIdArray = new Array(); //存放选中角色的id的数组

var assign;//是否已分配角色


/** 初始化 **/
function init() {
	initData();
	initComponent();
	initListener();
	initFace();
	queryOp();
	
}

/** 初始化页面、内存等基本数据 **/
function initData() {
}
/** 初始化组件 **/
function initComponent() {
	var B_opquery = EF.getButton({text:"查询",iconCls:"btn_query",handler:queryOp});
	var B_opclear = EF.getButton({text:"清空",iconCls:"btn_clear",handler:clearOp});
	
	var opformwidth = 450;
	var formheight = 60;		//表单总高度
	var labelWidth = 60;		//标签宽度
	var comwidth = 75;			//组件宽度
	var stdwidth = labelWidth+comwidth+10;	//标准宽度(标签宽度+组件宽度)
	
	var TF_opcdt0 = EF.getTextField({fieldLabel:"用户编号",name:"opCode",width:comwidth});
	var TF_opcdt1 = EF.getTextField({fieldLabel:"用户姓名",name:"opName",width:comwidth});
	var TF_opcdt2 = EF.getTextField({fieldLabel:"手机号",name:"mobileNo",width:comwidth});
	
	P_opcdt_form = EF.getFormPanel({tbar:[B_opquery,B_opclear],region:"north",border:false,frame:false,height:formheight,items:[
   		{width:opformwidth-5,border:false,bodyStyle:"padding-top:5px;",layout:"column",defaults:{layout:"form",width:stdwidth,border:false,labelWidth:labelWidth,labelAlign:"right"},items:[
   			{items:[TF_opcdt0]},{items:[TF_opcdt1]},{items:[TF_opcdt2]}
   		]}
   	]});
	
	
	var opfields = ["id","opCode","opName","opKind","mobileNo","emailAdress","loginCode","gender","officeTel","notes","lockFlag","isUpdatePwd","status"];
	var opsm = new Ext.grid.CheckboxSelectionModel({singleSelect:true});
	var opcm = EF.getColumnModel([opsm,
		{header:"用户编号", width:100, align:"left", dataIndex:"opCode"},
		{header:"用户姓名", width:100, align:"left", dataIndex:"opName"},
		{header:"手机号", width:100, align:"center", dataIndex:"mobileNo"},
        {header:"邮箱", width:140, align:"center", dataIndex:"emailAdress"}
	]);
	
	P_opgrid = EF.getGridPanel({layout:"fit",url:"/permis/sysop/querySysOpPage",region:"center",bodyStyle:"border-top: 1px solid #d8d8d8;",border:false,fields:opfields,cm:opcm,sm:opsm,autoBreakHeader:false});
	
	
	
	
	//---role start -------------------------------------------------------------------------------------------------------
	
	B_rolequery = EF.getButton({text:"查询",iconCls:"btn_query",handler:queryRole});
	B_roleclear = EF.getButton({text:"清空",iconCls:"btn_clear",handler:clearRole});
	B_currentOp = EF.getLabel({html:"<font color='#0000c0'>当前用户：</font>"});
	B_addOpRoles = EF.getButton({text:"分配角色",iconCls:"btn_add",handler:addOpRoles});
	B_removeRole = EF.getButton({text:"删除角色",iconCls:"btn_delete",handler:removeRole});
	B_setMasterRole = EF.getButton({text:"设置主角色",iconCls:"btn_passing",handler:setMasterRole});
	
	var TF_rolecdt0 = EF.getTextField({fieldLabel:"角色代码",name:"roleCode",width:comwidth});
	var TF_rolecdt1 = EF.getTextField({fieldLabel:"角色名称",name:"roleName",width:comwidth});
	
	P_rolecdt_form = EF.getFormPanel({tbar:[B_rolequery,B_roleclear,"-",B_addOpRoles,B_removeRole,B_setMasterRole,"-",B_currentOp],region:"north",border:false,frame:false,height:formheight,items:[
		{border:false,bodyStyle:"padding-top:5px;",layout:"column",defaults:{layout:"form",width:stdwidth,border:false,labelWidth:labelWidth,labelAlign:"right"},items:[
			{items:[TF_rolecdt0]},{items:[TF_rolecdt1]}
		]}
	]});
	
	//设置复选框
	var rolesm = new Ext.grid.CheckboxSelectionModel({  });   
	var rolefields = ["role.id","role.roleCode","role.roleName","role.roleType","role.roleDesc","role.status",
	                  "opRole.isMaster",
	                  "assign"];
	var rolecm = EF.getColumnModel([rolesm,
		{header:"角色代码", width:120, align:"center", dataIndex:"role.roleCode"},
		{header:"角色名称", width:120, align:"left", dataIndex:"role.roleName"},
        {header:"是否分配", width:70, align:"center", dataIndex:"assign",renderer:function(value, metaData, record, rowIndex, colIndex, store) {
			return "<font color='"+(value==1?"#00CC00":"#FF0000")+"'><b>"+(value==1?"已分配":"未分配")+"</b></font>";
        }},
        {header:"主角色", width:60, align:"center", dataIndex:"opRole.isMaster",renderer:function(value, metaData, record, rowIndex, colIndex, store) {
			if(value == 1) return "<img src='"+ContextPath+"/frame/images/icons/16x16/checked.gif'></img>";
        }}
	]);
	
	P_rolegrid = EF.getGridPanel({id:"rolegrid",url:"/permis/sysoprole/queryOpRolePage",region:"center",layout:"fit",bodyStyle:"border-top: 1px solid #d8d8d8;",border:false,fields:rolefields,cm:rolecm,sm:rolesm,autoBreakHeader:false});
	
	P_base = EF.getPanel({border:false,layout:"border",items:[
        {width:480,region:"west",border:true,collapseMode:"mini",split:true,layout:"border",items:[P_opcdt_form,P_opgrid]},
        {region:"center",border:true,layout:"border",items:[P_rolecdt_form, P_rolegrid]}
   ]});
}

/** 对组件设置监听 **/
function initListener() {
	P_opgrid.on("rowclick", function(grid,rowIndex,e) {
		var record = P_opgrid.store.getAt(rowIndex);
		CurrentOpId = record.get("id");
		B_currentOp.el.dom.innerHTML = "<font color='#0000c0'>当前用户：["+record.get("opCode")+"] "+record.get("opName")+"</font>";
		queryRole();
	});
	P_rolegrid.on("rowclick", function(grid,rowIndex,e) {
		var record = P_rolegrid.store.getAt(rowIndex);
		assign = record.get("assign");
		RoleIdArray.splice(0,RoleIdArray.length);//清空数组 
		var rows = Ext.getCmp('rolegrid').getSelectionModel().getSelections(); //获取所有选中行，
		for(var i=0;i <rows.length;i++){
			RoleIdArray[i] = rows[i].get("role.id");
		}
		
	});
}


/** 初始化界面 **/
function initFace() {
	new Ext.Viewport({layout:"fit",items: [P_base]});
}


function queryOp() {
	var ps = P_opcdt_form.getValues();
	ps.opKind = 1;
	P_opgrid.executeQuery(ps);
}
function queryRole() {
	if(CU.isEmpty(CurrentOpId)) {
		EU.showMsg({msg:"请先选择用户!"});
		return ;
	}
	var cdt = P_rolecdt_form.getValues();
	cdt.roleType = 1;
	P_rolegrid.executeQuery({opId:CurrentOpId,cSysRole:cdt});
}


/** 删除角色**/
function removeRole(){
	EU.RS({url:"/permis/sysoprole/removeOpRoles",ps:{opId:CurrentOpId,roleIds:RoleIdArray},cb:function(rs) {
		queryRole();
		EU.showMsg({msg:"删除角色成功!"});
	}});
}
/** 分配角色**/
function addOpRoles(){
	EU.RS({url:"/permis/sysoprole/addOpRoles",ps:{opId:CurrentOpId,roleIds:RoleIdArray},cb:function(rs) {
		queryRole();
		EU.showMsg({msg:"分配角色成功!"});
	}});
	
}
/** 设置主角色**/
function setMasterRole(){
	if(assign == 0){
		EU.showMsg({msg:"必须为已分配角色"});
		return;
	}
	if(CU.isEmpty(RoleIdArray)){
		EU.showMsg({msg:"请选择角色!"});
		return ;
	}
	if(RoleIdArray.length>1){
		EU.showMsg({msg:"只能选择一个主角色!"});
		return ;
	}
	EU.RS({url:"/permis/sysoprole/setMasterRole",ps:{opId:CurrentOpId,roleId:RoleIdArray},cb:function(rs) {
		queryRole();
		EU.showMsg({msg:"设置主角色成功!"});
	}});
}

/** 执行条件文本框回车查询 **/
function doCdtTFKeyUp(e) {
	if(e.keyCode === 13) query();
}





/** 请空查询条件 **/
function clearOp() {
	P_opcdt_form.reset();
}
function clearRole(){
	P_rolecdt_form.reset();
}
