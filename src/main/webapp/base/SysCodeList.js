
var P_cdt_form;		//条件表单
var P_grid;			//查询列表
var P_base;			//最底层基础面版


/** 初始化 **/
function init() {
	initData(function() {
		initComponent();
		initListener();
		initFace();
		query();
	});
}

/** 初始化页面、内存等基本数据 **/
function initData(cb) {
	cb();
}

/** 初始化组件 **/
function initComponent() {
	B_query = EF.getButton({text:"查询",iconCls:"btn_query",handler:query});
	B_clear = EF.getButton({text:"清空",iconCls:"btn_clear",handler:clear});
	B_add = EF.getButton({text:"添加",iconCls:"btn_add",handler:function(){openInfo("");}});
	
	var cols = 5;		//列数
	var rows = 1;		//行数
	var stdwidth = 200;	//标准宽度(标签宽度+组件宽度)
	var labelWidth = 80;	//标签宽度
	var comwidth = stdwidth-labelWidth-10;	//组件宽度
	var maxwidth = stdwidth*cols + 5;			//条件域总宽度
	var maxheight = rows * 28 + 5;			//条件域总高度
	var TF_cdt0 = EF.getTextField({fieldLabel:"定义代码",name:"defCode",width:comwidth,enableKeyEvents:true,onKeyUp:doCdtTFKeyUp});
	var TF_cdt1 = EF.getTextField({fieldLabel:"代码名称",name:"codeName",width:comwidth,enableKeyEvents:true,onKeyUp:doCdtTFKeyUp});
	var TF_cdt2 = EF.getComboBox({fieldLabel:"是否可维护",hiddenName:"isMaintain",width:comwidth,def:"V_YES_NO"});
	var TF_cdt3 = EF.getComboBox({fieldLabel:"有效状态",hiddenName:"status",width:comwidth,def:"V_IS_VALID"});
	
	P_cdt_form = EF.getFormPanel({region:"north",border:false,frame:false,height:maxheight,items:[
		{width:maxwidth,height:maxheight,border:false,bodyStyle:"padding-top:5px;",layout:"column",defaults:{layout:"form",width:stdwidth,border:false,labelWidth:labelWidth,labelAlign:"right"},items:[
			{items:[TF_cdt0]},{items:[TF_cdt1]},{items:[TF_cdt2]},{items:[TF_cdt3]}
		]}
	]});
	
	
	var stsfields = ["id","codeDefId","code","name","alias","enName","pinyin","parentCode","icon","color","orderNo","custom1","custom2","custom3","custom4","custom5","custom6","status"];
	var stscm = [
		{header:"代码",    width:80, 	align:"left", sortable:true, dataIndex:"code"},            
        {header:"名称",    width:100, 	align:"left", sortable:true, dataIndex:"name"},
  	    {header: "别名",    width:80, 	align:"left", sortable:true, dataIndex:"alias"},
  	    {header: "英文名", 	width:80, 	align:"left",sortable:true,  dataIndex:"enName"},
  	    {header: "拼音码", 	width:80, 	align:"left",sortable:true,  dataIndex:"pinyin"},
  	    {header: "上级代码", width:80, 	align:"left",sortable:true,  dataIndex:"parentCode"},
  	    {header: "图标", 	width:80, 	align:"left",sortable:true,  dataIndex:"icon"},
  	    {header: "颜色", 	width:80, 	align:"left",sortable:true,  dataIndex:"color"},
  	    {header: "排序", 	width:80, 	align:"left",sortable:true,  dataIndex:"orderNo"},
  	    {header: "有效状态", width:80, 	align:"center",sortable:true,  dataIndex:"status", renderer:function(value, rowData, rowIndex, row, baseIndex, baseRecord, exp, data) {
  	    	if(CU.isEmpty(value)) return "";
  	    	var item = CU.getDropItemRecord("V_IS_VALID", value+"");
        	return "<font color='"+(value==1?"#0000ff":"#ff0000")+"'>"+item.name+"</font>";
        }},
  	    {header: "备用1", 	width:100, 	align:"left",sortable:true,  dataIndex:"custom1"},
  	    {header: "备用2", 	width:100, 	align:"left",sortable:true,  dataIndex:"custom2"},
	  	{header: "备用3", 	width:100, 	align:"left",sortable:true,  dataIndex:"custom3"},
	  	{header: "备用4", 	width:100, 	align:"left",sortable:true,  dataIndex:"custom4"},
	  	{header: "备用5", 	width:100, 	align:"left",sortable:true,  dataIndex:"custom5"},
	  	{header: "备用6", 	width:100, 	align:"left",sortable:true,  dataIndex:"custom6"}
	];	
	stsexpander = EF.getGridExpander({url:"/base/syscode/queryCodeExpList",fields:stsfields,cm:stscm});
	
	var fields = ["id","defCode","codeName","codeType","codeDesc","isMaintain","status","dataStatus"];
	var cm = EF.getColumnModel([
	    stsexpander,
		{header:"定义代码", width:300, align:"left", dataIndex:"defCode",renderer:function(value, metaData, record, rowIndex, colIndex, store) {
			return "<div><a href='###' onclick='openInfo("+record.get("id")+")' >"+value+"</a></div>";
        }},
		{header:"代码名称", width:120, align:"left", dataIndex:"codeName"},
		{header:"代码类型", width:80, align:"center", dataIndex:"codeType",renderer:function(value, metaData, record, rowIndex, colIndex, store) {
			var item = CU.getDropItemRecord("V_SYS_CODE_DEF_CODE_TYPE", value);
			return item.name;
        }},
		{header:"是否可维护", width:80, align:"center", dataIndex:"isMaintain",renderer:function(value, metaData, record, rowIndex, colIndex, store) {
			var item = CU.getDropItemRecord("V_YES_NO", value+"");
			return item.name;
        }},
        {header:"有效状态", width:80, align:"center", dataIndex:"status",renderer:function(value, metaData, record, rowIndex, colIndex, store) {
        	var item = CU.getDropItemRecord("V_IS_VALID", value+"");
        	return "<font color='"+(value==1?"#0000ff":"#ff0000")+"'>"+item.name+"</font>";
        }},
		{header:"代码描述", width:300, align:"left", dataIndex:"codeDesc"}
	]);
	
	P_grid = EF.getGridPanel({url:"/base/syscode/queryDefPage",region:"center",remark:stsexpander,layout:"fit",bodyStyle:"border-top: 1px solid #d8d8d8;",border:false,fields:fields,cm:cm,autoBreakHeader:false});
	
	P_base = EF.getPanel({tbar:[B_query,B_clear,"-",B_add],layout:"border",items:[P_cdt_form,P_grid]});
}


/** 对组件设置监听 **/
function initListener() {
	P_grid.on("rowdblclick", function(grid,rowIndex,e) {
		var record = P_grid.store.getAt(rowIndex);
		openInfo(record.get("id"));
	});
}


/** 初始化界面 **/
function initFace() {
	new Ext.Viewport({layout:"fit",items: [P_base]});
}


/** 执行条件文本框回车查询 **/
function doCdtTFKeyUp(e) {
	if(e.keyCode === 13) query();
}


/** 查询 **/
function query() {
	var ps = P_cdt_form.getValues();
	P_grid.executeQuery(ps);
}


/** 请空查询条件 **/
function clear() {
	P_cdt_form.reset();
}

function openInfo(id){
	var url = ContextPath + "/dispatch/base/SysCodeForm";
	if(!CU.isEmpty(id)) url += "?id="+id;
	PU.openModule({url:url,width:800,height:600,resizable:false,modal:true,callback:function() {
		P_grid.store.reload();
	}});
}



