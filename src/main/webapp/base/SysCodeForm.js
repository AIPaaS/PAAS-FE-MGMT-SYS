/**
 * 代码定义表单
 */


var P_form;		//表单
var P_base;		//最底层基础面版

var CurrentId;	//当前主键ID

var Components;	//表单组件


/** 初始化 **/
function init() {
	initData();
	initComponent();
	initListener();
	initFace();
	if(!CU.isEmpty(CurrentId)) {
		queryInfo();
	}
}

/** 初始化页面、内存等基本数据 **/
function initData() {
	CurrentId = PRQ.get("id");
	if(CU.isEmpty(CurrentId))CurrentId="";
}

/** 初始化组件 **/
function initComponent() {
	var B_save = EF.getButton({text:"保存",name:"btn_op_save",iconCls:"btn_save",handler:save});
	var B_cancel = EF.getButton({text:"返回",name:"btn_op_close",iconCls:"btn_unpassing",handler:closeWin});

	var formwidth = 780;		//表单总宽度
	var formheight = 180;		//表单总高度
	var labelWidth = 120;		//标签宽度
	var comwidth = 200;			//组件宽度
	var stdwidth = labelWidth+comwidth+10;	//标准宽度(标签宽度+组件宽度)

	var TF_f0 = EF.getTextField({fieldLabel:"定义代码",name:"defCode",width:comwidth,allowBlank:false});	
	var TF_f1 = EF.getTextField({fieldLabel:"代码名称",name:"codeName",width:comwidth,allowBlank:false});
	var TF_f2 = EF.getComboBox({fieldLabel:"代码类型",hiddenName:"codeType",width:comwidth,def:"V_SYS_CODE_DEF_CODE_TYPE",allowBlank:false});
	var TF_f3 = EF.getCheckBox({fieldLabel:"是否可维护",name:"isMaintain",inputValue:1,uncheckValue:0});
	var TF_f4 = EF.getCheckBox({fieldLabel:"有效状态",name:"status",inputValue:1,uncheckValue:0});
	var TF_f5 = EF.getTextArea({fieldLabel:"代码描述",name:"codeDesc",width:comwidth*2+labelWidth+10,height:60});	
	
	Components = [TF_f0,TF_f1,TF_f2,TF_f3,TF_f4,TF_f5];

	P_form = EF.getFormPanel({tbar:[B_save,B_cancel],region:"north",border:false,autoScroll:true,frame:false,width:formwidth,height:formheight,items:[
		{width:formwidth-20,border:false,bodyStyle:"padding-top:5px;",layout:"column",defaults:{layout:"form",width:stdwidth,border:false,labelWidth:labelWidth,labelAlign:"right"},items:[
			{items:[TF_f0]},{items:[TF_f1]},{items:[TF_f2]},{items:[TF_f3]},{items:[TF_f4],width:stdwidth*2},{items:[TF_f5],width:stdwidth*2}
		]}
	]});
	
	var fields = ["id","codeDefId","code","name","alias","enName","pinyin","parentCode","icon","color","orderNo","custom1","custom2","custom3","custom4","custom5","custom6","status"];
	
	var TF_editor0 = EF.getComboBox({def:"V_IS_VALID"});
	var sm = new Ext.grid.CheckboxSelectionModel({singleSelect:false});
	var cm = EF.getColumnModel([
	    {header:"<img src='"+ContextPath+"/frame/images/icons/16x16/add1.gif' style='cursor:hand;' onclick='addCodeRow()'></img>",    width:30, 	align:"center", sortable:false, dataIndex:"id", renderer:function(value, metaData, record, rowIndex, colIndex, store) {
	    	return "<img src='"+ContextPath+"/frame/images/icons/16x16/del.gif' style='cursor:hand;' onclick='removeCodeRow()'></img>";
        }},
	    {header:"代码",    width:80, 	align:"left", sortable:true, dataIndex:"code", editor:EF.getTextField()},            
        {header:"名称",    width:80, 	align:"left", sortable:true, dataIndex:"name", editor:EF.getTextField()},
  	    {header: "别名",    width:80, 	align:"left", sortable:true, dataIndex:"alias", editor:EF.getTextField()},
  	    {header: "英文名", 	width:80, 	align:"left",sortable:true,  dataIndex:"enName", editor:EF.getTextField()},
  	    {header: "拼音码", 	width:80, 	align:"left",sortable:true,  dataIndex:"pinyin", editor:EF.getTextField()},
  	    {header: "上级代码", width:80, 	align:"left",sortable:true,  dataIndex:"parentCode", editor:EF.getTextField()},
  	    {header: "图标", 	width:80, 	align:"left",sortable:true,  dataIndex:"icon", editor:EF.getTextField()},
  	    {header: "颜色", 	width:80, 	align:"left",sortable:true,  dataIndex:"color", editor:EF.getTextField()},
  	    {header: "排序", 	width:80, 	align:"left",sortable:true,  dataIndex:"orderNo", editor:EF.getNumberField({allowDecimals:false})},
  	    {header: "有效状态", width:60, 	align:"center",sortable:true,  dataIndex:"status", editor:TF_editor0, renderer:function(value, metaData, record, rowIndex, colIndex, store) {
  	    	if(CU.isEmpty(value)) return "";
  	    	var item = CU.getDropItemRecord("V_IS_VALID", value+"");
        	return "<font color='"+(value==1?"#0000ff":"#ff0000")+"'>"+item.name+"</font>";
        }},
  	    {header: "备用1", 	width:100, 	align:"left",sortable:true,  dataIndex:"custom1", editor:EF.getTextField()},
  	    {header: "备用2", 	width:100, 	align:"left",sortable:true,  dataIndex:"custom2", editor:EF.getTextField()},
	  	{header: "备用3", 	width:100, 	align:"left",sortable:true,  dataIndex:"custom3", editor:EF.getTextField()},
	  	{header: "备用4", 	width:100, 	align:"left",sortable:true,  dataIndex:"custom4", editor:EF.getNumberField({allowDecimals:false,domMaxLength:16})},
	  	{header: "备用5", 	width:100, 	align:"left",sortable:true,  dataIndex:"custom5", editor:EF.getNumberField({allowDecimals:false,domMaxLength:16})},
	  	{header: "备用6", 	width:100, 	align:"left",sortable:true,  dataIndex:"custom6", editor:EF.getNumberField({allowDecimals:false,domMaxLength:16})}
    ]);
	P_grid = EF.getEditorGrid({url:"/base/syscode/queryCodeList",region:"center",fields:fields,cm:cm,sm:sm,autoBreakHeader:false,addContextMenu:false,clicksToEdit:1});
	
	P_base = EF.getPanel({border:false, layout:"border",items:[P_form, P_grid]});
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
	RS.ajax({url:"/base/syscode/queryDefById",ps:{id:CurrentId},cb:function(result) {
		EU.setAllValue(Components, result);
		P_grid.executeQuery({codeDefId:CurrentId});
		if(CU.isFunction(callback)) callback();
	}});
}


function addCodeRow() {
	var record = P_grid.add();
	record.set("status", 1);
}
function removeCodeRow() {
	P_grid.deleteRow();
}


/** 保存 **/
function save() {
	if(!P_form.isValid()) return ;
	var def = EU.getAllValue(Components);
	if(!CU.isEmpty(CurrentId)) def.id = CurrentId;
	
	P_grid.stopEditing(false);
	var codes = P_grid.getDataList();
	if(CU.isEmpty(codes)) {EU.showMsg({msg:"代码编辑列表不可以为空"});return ;}
	for(var i=0; i<codes.length; i++) {
		if(CU.isEmpty(codes[i].code)) {EU.showMsg({msg:"代码编辑列表第["+(i+1)+"]行[代码]不可以为空"});return ;}
		if(CU.isEmpty(codes[i].name)) {EU.showMsg({msg:"代码编辑列表第["+(i+1)+"]行[名称]不可以为空"});return ;}
	}
	
	EU.RS({url:"/base/syscode/saveOrUpdate",ps:{defJson:CU.toString(def),codesJson:CU.toString(codes)},cb:function(rs) {
		CurrentId = rs;
		P_grid.executeQuery({codeDefId:CurrentId});
		EU.showMsg({msg:"保存成功!"});
	}});
}

/** 关闭 **/
function closeWin() {
	//PRQ.closeWindow();
	var url = ContextPath + "/dispatch/base/SysCodeList";
	window.location = url;
}




