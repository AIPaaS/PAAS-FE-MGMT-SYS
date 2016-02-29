

var P_base;			//最底层基础面版
var p_Components;	//表单组件
var P_dropgrid;    //SYS_MODU_DROP查询列表
var P_resgrid;     //SYS_MODU_RES查询列表

var CurrentId = "";		//当前主键ID
var CurrentNode = "";//当前节点
var ParentNode = "";//父节点


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
	B_saveSysModu = EF.getButton({text:"保存",name:"btn_op_save",iconCls:"btn_save",handler:saveSysModu,disabled:true});
	B_saveSysModuDrop = EF.getButton({text:"保存",name:"btn_op_save",iconCls:"btn_save",handler:saveSysModuDrop,disabled:true});
	B_saveSysModuRes = EF.getButton({text:"保存",name:"btn_op_save",iconCls:"btn_save",handler:saveSysModuRes,disabled:true});
	var B_addChildNode = EF.getButton({text:"子节点",name:"btn_add",iconCls:"btn_add",handler:addChildNode});
	var B_addNode = EF.getButton({text:"一级",name:"btn_add",iconCls:"btn_add",handler:addFirstNode});
	
	var formwidth = 330;		//表单总宽度
	var formheight = 500;		//表单总高度
	var labelWidth = 80;		//标签宽度
	var comwidth = 200;			//组件宽度
	var stdwidth = labelWidth+comwidth+10;	//标准宽度(标签宽度+组件宽度)
	
	var TF_f0 = EF.getTextField({fieldLabel:"模块代码",name:"moduCode",width:comwidth,allowBlank:false,regex:/^[0-9a-zA-Z_]{1,40}$/});	
	var TF_f1 = EF.getTextField({fieldLabel:"模块名称",name:"moduName",width:comwidth,allowBlank:false});	
	var TF_f2 = EF.getCheckBox({fieldLabel:"是否目录",name:"isDir",width:comwidth,inputValue:1,uncheckValue:0});
//	var TF_f3 = EF.getComboBox({fieldLabel:"模块类型",hiddenName:"moduType",width:comwidth,def:"V_SYS_MODU_TYPE",allowBlank:false});
	var TF_f4 = EF.getComboBox({fieldLabel:"技术类型",hiddenName:"technicType",width:comwidth,def:"V_SYS_MODU_TECHNIC_TYPE",allowBlank:false});
	var TF_f5 = EF.getTextField({fieldLabel:"链接地址",name:"moduUrl",width:comwidth});	
	var TF_f6 = EF.getTextField({fieldLabel:"模块参数",name:"moduParam",width:comwidth});	
	var TF_f7 = EF.getTextField({fieldLabel:"帮助地址",name:"helpUrl",width:comwidth});	
	var TF_f8 = EF.getCheckBox({fieldLabel:"有效状态",name:"status",width:comwidth,inputValue:1,uncheckValue:0});
	var TF_f9 = EF.getTextField({fieldLabel:"模块描述",name:"moduDesc",width:comwidth});	
	
	p_Components = [TF_f0,TF_f1,TF_f2,TF_f4,TF_f5,TF_f6,TF_f7,TF_f8,TF_f9];
	P_form = EF.getFormPanel({tbar:[B_saveSysModu],border:false,autoScroll:true,frame:false,width:formwidth,height:formheight,items:[
	   {width:formwidth-20,border:false,bodyStyle:"padding-top:5px;",layout:"column",defaults:{layout:"form",width:stdwidth,border:false,labelWidth:labelWidth,labelAlign:"right"},items:[
	      {items:[TF_f0]},{items:[TF_f1]},{items:[TF_f2]},{items:[TF_f4]},{items:[TF_f5]},{items:[TF_f6]},
	      {items:[TF_f7]},{items:[TF_f8]},{items:[TF_f9]}
	   ]}
	]});
	//树
	TR_menu = EF.getTreePanel({tbar:[B_addNode,B_addChildNode],border:true,layout:"fit",collapseMode:"mini",split:true,region:"west",width:260,root:EF.getTreeRoot({id:"00"}),url:"/base/sysmodu/querySysModuTree?moduType=2"});
	
	P_dropgrid = createDropGrid();
	P_resgrid = createResGrid();
	
	
	P_base = EF.getPanel({border:false,layout:"border",items:[
        TR_menu,
        {region:"center",border:false,layout:"border",items:[
            {region:"center",border:false,layout:"border",items:[
               {region:"west",width:300,items:[P_form]}, 
               {tbar:[B_saveSysModuDrop],region:"center",layout:"fit",items:[P_dropgrid]}
            ]},
            {tbar:[B_saveSysModuRes],region:"south",height:200,layout:"fit",items:[P_resgrid]}
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





function createDropGrid() {
	
	var fields = ["id","moduId","defCode","addAttrs","addEmpty","remark","dataStatus"];
	
	var TF_editor0 = EF.getComboBox({def:"V_SYS_MODU_DROP_ADD_ATTRS"});
	var TF_editor1 = EF.getComboBox({def:"V_SYS_MODU_ADD_EMPTY"});
	var sm = new Ext.grid.CheckboxSelectionModel({singleSelect:false});
	var cm = EF.getColumnModel([
	    {header:"<img src='"+ContextPath+"/frame/images/icons/16x16/add1.gif' style='cursor:hand;' onclick='addCodeRow()'></img>",    width:30, 	align:"center", sortable:false, dataIndex:"id", renderer:function(value, metaData, record, rowIndex, colIndex, store) {
	    	return "<img src='"+ContextPath+"/frame/images/icons/16x16/del.gif' style='cursor:hand;' onclick='removeCodeRow()'></img>";
        }},
	    {header:"定义代码",    width:80, 	align:"left", sortable:true, dataIndex:"defCode", editor:EF.getTextField()},            
        {header:"携带参数",    width:80, 	align:"left", sortable:true, dataIndex:"addAttrs", editor:TF_editor0,renderer:function(value, metaData, record, rowIndex, colIndex, store) {
  	    	if(CU.isEmpty(value)) return "";
  	    	var item = CU.getDropItemRecord("V_SYS_MODU_DROP_ADD_ATTRS", value+"");
        	return item.name;
        }},
  	    {header: "添加空行",    width:80, 	align:"left", sortable:true, dataIndex:"addEmpty", editor:TF_editor1,renderer:function(value, metaData, record, rowIndex, colIndex, store) {
  	    	if(CU.isEmpty(value)) return "";
  	    	var item = CU.getDropItemRecord("V_SYS_MODU_ADD_EMPTY", value+"");
        	return item.name;
        }},
  	    {header: "描述", 	width:80, 	align:"left",sortable:true,  dataIndex:"remark", editor:EF.getTextField()}
  	    
  	    ]);
	P_dropgrid = EF.getEditorGrid({url:"/base/sysmodu/querySysModuDropByModuId",region:"center",fields:fields,cm:cm,sm:sm,autoBreakHeader:false,addContextMenu:false,clicksToEdit:1});
	return P_dropgrid;
}
function createResGrid() {
	
	var fields = ["id","moduId","orderNo","resUrl","resType","resDesc","dataStatus"];
	
	var TF_editor0 = EF.getComboBox({def:"V_SYS_MODU_RES_RES_TYPE"});
	var sm = new Ext.grid.CheckboxSelectionModel({singleSelect:false});
	var cm = EF.getColumnModel([
	    {header:"<img src='"+ContextPath+"/frame/images/icons/16x16/add1.gif' style='cursor:hand;' onclick='addResCodeRow()'></img>",    width:30, 	align:"center", sortable:false, dataIndex:"id", renderer:function(value, metaData, record, rowIndex, colIndex, store) {
	    	return "<img src='"+ContextPath+"/frame/images/icons/16x16/del.gif' style='cursor:hand;' onclick='removeResCodeRow()'></img>";
        }},
	    {header:"资源类型",    width:80, 	align:"left", sortable:true, dataIndex:"resType", editor:TF_editor0,renderer:function(value, metaData, record, rowIndex, colIndex, store) {
  	    	if(CU.isEmpty(value)) return "";
  	    	var item = CU.getDropItemRecord("V_SYS_MODU_RES_RES_TYPE", value);
        	return item.name;
        }},            
        {header:"资源地址",    width:200, 	align:"left", sortable:true, dataIndex:"resUrl",  editor:EF.getTextField()},
  	    {header: "资源序号",    width:80, 	align:"left", sortable:true, dataIndex:"orderNo",  editor:EF.getTextField()},
  	    {header: "资源描述", 	width:200, 	align:"left",sortable:true,  dataIndex:"resDesc", editor:EF.getTextField()}
  	    
  	    ]);
	P_resgrid = EF.getEditorGrid({url:"/base/sysmodu/querySysModuResByModuId",region:"center",fields:fields,cm:cm,sm:sm,autoBreakHeader:false,addContextMenu:false,clicksToEdit:1});
	return P_resgrid;
}









function menuTreeClick(node, e) {
	setFormEditable(true);
	CurrentId = node.id;
	CurrentNode = node;
	ParentNode = node.parentNode;
	
	var modu = node.attributes.attributes;
	queryInfo(node.id);//query_modu
	if(modu.isDir != 1) {
		e.stopEvent();
		query_drop(node.id);
		query_res(node.id);
	}
}

function setFormEditable(editable){
	B_saveSysModu.setDisabled(!editable);
	B_saveSysModuDrop.setDisabled(!editable);
	B_saveSysModuRes.setDisabled(!editable);
	
}
function clearForm(){
	//清空三个表单中的数据
	P_form.reset();
	P_dropgrid.deleteAll();
	P_resgrid.deleteAll();
}

function addFirstNode() {
	clearForm();
	setFormEditable(true);
	ParentNode = TR_menu.root;
	CurrentNode = "";
	
}
/**添加子节点*/
function addChildNode() {
	clearForm();
	setFormEditable(true);
	ParentNode = CurrentNode;
	CurrentNode = "";
}










/** 查询SysModu详细信息 **/
function queryInfo(sysId,callback) {
	clearForm();
	RS.ajax({url:"/base/sysmodu/querySysModuById",ps:{id:sysId},cb:function(result) {
		EU.setAllValue(p_Components, result);
		if(CU.isFunction(callback)) callback();
	}});
	
}
/** 查询SysModuDrop详细信息 **/
function query_drop(moduId) {
	P_dropgrid.executeQuery({moduId:moduId});
}
/** 查询SysModuRes详细信息 **/
function query_res(moduId,callback) {
	P_resgrid.executeQuery({moduId:moduId});
}


function reloadParentNode(currentid,callback) {
	EU.reloadParentNode(ParentNode, currentid, function(pn,cn) {
		ParentNode = pn;
		CurrentNode = CU.isEmpty(cn) ? "" : cn;
		if(CU.isFunction(callback))callback();
	});
}




/** 保存SysModu对象 **/
function saveSysModu() {
	if(!P_form.isValid()) return ;
	//if(CU.isEmpty(CurrentNode)) {EU.showMsg({msg:"11111"}); return ;}
	
	var bean = EU.getAllValue(p_Components);
	bean.id = CU.isEmpty(CurrentNode) ? "" : CurrentNode.id;
	bean.parentId = ParentNode.id;
	bean.moduType = 2;
	
	EU.RS({url:"/base/sysmodu/saveOrUpdate",ps:bean,cb:function(rs) {
		EU.showMsg({msg:"保存成功!"});
		reloadParentNode(rs);
	}});
}



/** 保存SysModuDrop对象 **/
function saveSysModuDrop() {
	var moduId = CurrentNode.id;
	P_dropgrid.stopEditing(false);
	var drops = P_dropgrid.getDataList();
	if(CU.isEmpty(drops)) {EU.showMsg({msg:"代码编辑列表不可以为空"});return ;}
	for(var i=0; i<drops.length; i++) {
		if(CU.isEmpty(drops[i].defCode)) {EU.showMsg({msg:"代码编辑列表第["+(i+1)+"]行[代码]不可以为空"});return ;}
	}
	EU.RS({url:"/base/sysmodu/saveSysModuDrop",ps:{codesJson:CU.toString(drops),moduId:moduId},cb:function(rs) {
		EU.showMsg({msg:"保存成功!"});
	}});
}
/** 保存SysModuRes对象 **/
function saveSysModuRes() {
	var moduId = CurrentId;
	P_resgrid.stopEditing(false);
	var ress = P_resgrid.getDataList();
	if(CU.isEmpty(ress)) {EU.showMsg({msg:"代码编辑列表不可以为空"});return ;}
	for(var i=0; i<ress.length; i++) {
		if(CU.isEmpty(ress[i].resUrl)) {EU.showMsg({msg:"代码编辑列表第["+(i+1)+"]行[资源地址]不可以为空"});return ;}
		if(CU.isEmpty(ress[i].resType)) {EU.showMsg({msg:"代码编辑列表第["+(i+1)+"]行[资源类型]不可以为空"});return ;}
	}
	EU.RS({url:"/base/sysmodu/saveSysModuRes",ps:{codesJson:CU.toString(ress),moduId:moduId},cb:function(rs) {
		EU.showMsg({msg:"保存成功!"});
	}});
}
function addCodeRow() {
	var record = P_dropgrid.add();
	record.set("status", 1);
}
function addResCodeRow(){
	var record = P_resgrid.add();
	record.set("status", 1);
}
function removeCodeRow() {
	P_dropgrid.deleteRow();
}
function removeResCodeRow() {
	P_resgrid.deleteRow();
}


