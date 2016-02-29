

var P_base;			//最底层基础面版
var CurrentRoleId; //当前的角色id
var M_popup;		//右键菜单
var CurrentNode;	//当前节点对象
var ParentNode;

/** 初始化 **/
function init() {
	initData();
	initComponent();
	initListener();
	initFace();
	queryRole();
	
}

/** 初始化页面、内存等基本数据 **/
function initData() {
}
/** 初始化组件 **/
function initComponent() {
	
	var formheight = 60;		//表单总高度
	var labelWidth = 60;		//标签宽度
	var comwidth = 80;			//组件宽度
	var stdwidth = labelWidth+comwidth+10;	//标准宽度(标签宽度+组件宽度)
	
	//---role start -------------------------------------------------------------------------------------------------------
	
	B_rolequery = EF.getButton({text:"查询",iconCls:"btn_query",handler:queryRole});
	B_roleclear = EF.getButton({text:"清空",iconCls:"btn_clear",handler:clearRole});
	B_currentRole = EF.getLabel({height:400,html:"<font color='#0000c0'>当前角色：</font>"});
	
	var TF_rolecdt0 = EF.getTextField({fieldLabel:"角色代码",name:"roleCode",width:comwidth});
	var TF_rolecdt1 = EF.getTextField({fieldLabel:"角色名称",name:"roleName",width:comwidth});
//	var TF_rolecdt2 = EF.getComboBox({fieldLabel:"角色类型",hiddenName:"roleType",width:comwidth,def:"V_SYS_ROLE_ROLE_TYPE"});
	
	P_rolecdt_form = EF.getFormPanel({tbar:[B_rolequery,B_roleclear],region:"north",border:false,frame:false,height:formheight,items:[
		{border:false,bodyStyle:"padding-top:5px;",layout:"column",defaults:{layout:"form",width:stdwidth,border:false,labelWidth:labelWidth,labelAlign:"right"},items:[
			{items:[TF_rolecdt0]},{items:[TF_rolecdt1]}
		]}
	]});
	
	//设置复选框
	var rolesm = new Ext.grid.CheckboxSelectionModel({singleSelect:true});   
	var rolefields = ["id","roleCode","roleName","roleType","roleDesc","status"];
	var rolecm = EF.getColumnModel([rolesm,
		{header:"角色代码", width:120, align:"center", dataIndex:"roleCode"},
		{header:"角色名称", width:140, align:"left", dataIndex:"roleName"},
		{header:"角色描述", width:140, align:"center", dataIndex:"roleDesc"}
       
	]);
	
	P_rolegrid = EF.getGridPanel({id:"rolegrid",url:"/permis/sysmodurole/querySysRolePage",region:"center",layout:"fit",bodyStyle:"border-top: 1px solid #d8d8d8;",border:false,fields:rolefields,cm:rolecm,sm:rolesm,autoBreakHeader:false});
	
	//树
	TR_menu = EF.getTreePanel({tbar:EF.getToolBar({items:[B_currentRole],height:26}),border:false,layout:"fit",root:EF.getTreeRoot({id:"00"}),url:"/permis/sysmodurole/querySysModuTree?moduType=2"});
	
	P_base = EF.getPanel({border:false,layout:"border",items:[
        {width:450,region:"west",border:true,collapseMode:"mini",split:true,layout:"border",items:[P_rolecdt_form, P_rolegrid]},
        {region:"center",border:true,layout:"fit",items:[TR_menu]}
   ]});
}

/** 对组件设置监听 **/
function initListener() {
	P_rolegrid.on("rowclick", function(grid,rowIndex,e) {
		var record = P_rolegrid.store.getAt(rowIndex);
		CurrentRoleId = record.get("id");
		B_currentRole.el.dom.innerHTML = "<font color='#0000c0'>当前角色：["+record.get("roleCode")+"] "+record.get("roleName")+"</font>";
		querySysModu();
	});
	TR_menu.on("contextmenu", function(node,e) {
    	CurrentNode = node;
		ParentNode = node.parentNode;
		node.select();
		if(CU.isEmpty(M_popup)) initPopupMenu();
		EU.showPopupMenu(M_popup, 0, 0, P_base.getWidth(), P_base.getHeight(),5,null,null,e);
	});
}


/** 初始化界面 **/
function initFace() {
	new Ext.Viewport({layout:"fit",items: [P_base]});
}

function initPopupMenu() {
	var MI_addmenu = EF.getMenuItem({text:"分配权限",handler:addLimit});
	var MI_delete = EF.getMenuItem({text:"删除权限",handler:removeLimit});
	var MI_addmenus = EF.getMenuItem({text:"分配及子节点权限",handler:addLimits});
	var MI_deletes = EF.getMenuItem({text:"删除及子节点权限",handler:removeLimits});
	M_popup = EF.getMenu({items:[MI_addmenu,MI_delete,"-",MI_addmenus,MI_deletes]});
}

function queryRole() {
	var ps = P_rolecdt_form.getValues();
	ps.roleType = 2;
	P_rolegrid.executeQuery(ps);
}
function querySysModu(){
	if(CU.isEmpty(CurrentRoleId)) {
		EU.showMsg({msg:"请先选择角色!"});
		return ;
	}
	TR_menu.setParams({roleId:CurrentRoleId});
	TR_menu.root.reload();
}

function addLimit() {
	EU.RS({url:"/permis/sysmodurole/addRoleModu",ps:{roleId:CurrentRoleId,moduId:CurrentNode.id},cb:function(rs) {
		ParentNode.reload();
	}});
}
function addLimits() {
	EU.RS({url:"/permis/sysmodurole/addRoleModus",ps:{roleId:CurrentRoleId,moduCode:CurrentNode.attributes.attributes.moduCode},cb:function(rs) {
		ParentNode.reload();
	}});
}
function removeLimit() {
	EU.RS({url:"/permis/sysmodurole/removeLimit",ps:{roleId:CurrentRoleId,moduId:CurrentNode.id},cb:function(rs) {
		ParentNode.reload();
	}});
}
function removeLimits() {
	EU.RS({url:"/permis/sysmodurole/removeLimits",ps:{roleId:CurrentRoleId,moduCode:CurrentNode.attributes.attributes.moduCode},cb:function(rs) {
		ParentNode.reload();
	}});
}

/** 执行条件文本框回车查询 **/
function doCdtTFKeyUp(e) {
	if(e.keyCode === 13) query();
}




/** 请空查询条件 **/
function clearRole(){
	P_rolecdt_form.reset();
}
