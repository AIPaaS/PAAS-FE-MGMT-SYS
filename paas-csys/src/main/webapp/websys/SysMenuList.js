

var P_base;			//最底层基础面版
var p_Components;	//表单组件

var CurrentId = "";		//当前主键ID
var CurrentNode = "";//当前节点
var ParentNode = "";//父节点

var W_selectModuWin = null;


/** 初始化 **/
function init() {
	initData();
	initComponent();
	initListener();
	initFace();
	setFormEditable(false);
}

/** 初始化页面、内存等基本数据 **/
function initData() {
}
/** 初始化组件 **/
function initComponent() {
	B_saveSysMenu = EF.getButton({text:"保存",name:"btn_op_save",iconCls:"btn_save",handler:saveSysMenu,disabled:true});
	var B_addChildNode = EF.getButton({text:"子节点",name:"btn_add",iconCls:"btn_add",handler:addChildNode});
	var B_addNode = EF.getButton({text:"一级",name:"btn_add",iconCls:"btn_add",handler:addFirstNode});
	
	var formwidth = 330;		//表单总宽度
	var formheight = 500;		//表单总高度
	var labelWidth = 80;		//标签宽度
	var comwidth = 200;			//组件宽度
	var stdwidth = labelWidth+comwidth+10;	//标准宽度(标签宽度+组件宽度)
	
	var TF_f0 = EF.getTextField({fieldLabel:"菜单代码",name:"menuCode",width:comwidth,allowBlank:false,regex:/^[0-9a-zA-Z_]{1,40}$/});	
	var TF_f1 = EF.getTextField({fieldLabel:"菜单名称",name:"menuName",width:comwidth,allowBlank:false});	
//	var TF_f2 = EF.getComboBox({fieldLabel:"菜单类型",hiddenName:"menuType",width:comwidth,def:"V_SYS_MODU_TYPE",allowBlank:false});
	var TF_f3 = EF.getCheckBox({fieldLabel:"有效状态",name:"status",width:comwidth,inputValue:1,uncheckValue:0});
	var TF_f4 = EF.getCheckBox({fieldLabel:"是否目录",name:"isDir",width:comwidth,inputValue:1,uncheckValue:0});
	var TF_f5 = EF.getTextField({fieldLabel:"菜单描述",name:"menuDesc",width:comwidth});	
	TF_f6 = EF.getTextField({fieldLabel:"所属模块",name:"moduId",width:comwidth});
	
	var TF_select = EF.getButton({text:"选择",width:60,height:26,handler:showSelectModu});
	
	p_Components = [TF_f0,TF_f1,TF_f3,TF_f4,TF_f5,TF_f6];
	P_form = EF.getFormPanel({tbar:[B_saveSysMenu],border:false,autoScroll:true,frame:false,width:formwidth,height:formheight,items:[
	   {width:formwidth-20,border:false,bodyStyle:"padding-top:5px;",layout:"column",defaults:{layout:"form",width:stdwidth,border:false,labelWidth:labelWidth,labelAlign:"right"},items:[
	      {items:[TF_f0]},{items:[TF_f1]},{items:[TF_f3]},{items:[TF_f4]},{items:[TF_f5]},{items:[TF_f6,TF_select]}
	   ]}
	]});
	//树
	TR_menu = EF.getTreePanel({tbar:[B_addNode,B_addChildNode],border:true,layout:"fit",collapseMode:"mini",split:true,region:"west",width:360,root:EF.getTreeRoot({id:"00"}),url:"/base/sysmenu/querySysMenuTree?menuType=2"});
	
	
	
	P_base = EF.getPanel({border:false,layout:"border",items:[
        TR_menu,
        {region:"center",border:false,layout:"fit",items:[
            P_form
        ]}
   ]});
}



/** 对组件设置监听 **/
function initListener() {
	TR_menu.on("click",menuTreeClick);
}


/** 初始化界面 **/
function initFace() {
	new Ext.Viewport({layout:"fit",items: [P_base]});
}



function showSelectModu() {
	if(W_selectModuWin == null) {
		W_moduTree = EF.getTreePanel({border:false,layout:"fit",root:EF.getTreeRoot({id:"00"}),url:"/base/sysmodu/querySysModuTree?moduType=2"});
		W_selectModuWin = EF.getWindow({title:"模块选择",width:400,height:600,layout:"fit",items:[W_moduTree]});
		W_moduTree.on("dblclick",function(node) {
			TF_f6.setValue(node.id);
			W_selectModuWin.hide();
		});
	}
	W_selectModuWin.show();
}










function menuTreeClick(node, e) {
	setFormEditable(true);
	CurrentId = node.id;
	CurrentNode = node;
	ParentNode = node.parentNode;
	
	queryInfo(node.id);//query_menu
}

function setFormEditable(editable){
	B_saveSysMenu.setDisabled(!editable);
	
}

function addFirstNode() {
	//清空表单中的数据
	P_form.reset();
	setFormEditable(true);
	ParentNode = TR_menu.root;
	CurrentNode = "";
	
}
/**添加子节点*/
function addChildNode() {
	//清空表单中的数据
	P_form.reset();
	setFormEditable(true);
	ParentNode = CurrentNode;
	CurrentNode = "";
}










/** 查询SysMenu详细信息 **/
function queryInfo(sysId,callback) {
	//清空表单中的数据
	P_form.reset();
	RS.ajax({url:"/base/sysmenu/querySysMenuById",ps:{id:sysId},cb:function(result) {
		EU.setAllValue(p_Components, result);
		if(CU.isFunction(callback)) callback();
	}});
	
}


function reloadParentNode(currentid,callback) {
	EU.reloadParentNode(ParentNode, currentid, function(pn,cn) {
		ParentNode = pn;
		CurrentNode = CU.isEmpty(cn) ? "" : cn;
		if(CU.isFunction(callback))callback();
	});
}




/** 保存SysMenu对象 **/
function saveSysMenu() {
	if(!P_form.isValid()) return ;
	
	var bean = EU.getAllValue(p_Components);
	bean.id = CU.isEmpty(CurrentNode) ? "" : CurrentNode.id;
	bean.parentId = ParentNode.id;
	bean.menuType = 2;
	
	EU.RS({url:"/base/sysmenu/saveOrUpdate",ps:bean,cb:function(rs) {
		EU.showMsg({msg:"保存成功!"});
		reloadParentNode(rs);
	}});
}




