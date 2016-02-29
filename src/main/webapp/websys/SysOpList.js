
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
//	B_add = EF.getButton({text:"添加",iconCls:"btn_add",handler:function(){openInfo("");}});
	
	var cols = 5;		//列数
	var rows = 1;		//行数
	var stdwidth = 180;	//标准宽度(标签宽度+组件宽度)
	var labelWidth = 80;	//标签宽度
	var comwidth = stdwidth-labelWidth-10;	//组件宽度
	var maxwidth = stdwidth*cols + 5;			//条件域总宽度
	var maxheight = rows * 28 + 5;			//条件域总高度
	var TF_cdt0 = EF.getTextField({fieldLabel:"用户编号",name:"opCode",width:comwidth,enableKeyEvents:true,onKeyUp:doCdtTFKeyUp});
	var TF_cdt1 = EF.getTextField({fieldLabel:"用户姓名",name:"opName",width:comwidth,enableKeyEvents:true,onKeyUp:doCdtTFKeyUp});
//	var TF_cdt2 = EF.getComboBox({fieldLabel:"用户类别",hiddenName:"opKind",width:comwidth,def:"V_SYS_OP_OP_KIND"});
	var TF_cdt3 = EF.getTextField({fieldLabel:"手机号",name:"mobileNo",width:comwidth,enableKeyEvents:true,onKeyUp:doCdtTFKeyUp});
	var TF_cdt4 = EF.getTextField({fieldLabel:"邮箱",name:"emailAdress",width:comwidth,enableKeyEvents:true,onKeyUp:doCdtTFKeyUp});
	
	P_cdt_form = EF.getFormPanel({region:"north",border:false,frame:false,height:maxheight,items:[
		{width:maxwidth,height:maxheight,border:false,bodyStyle:"padding-top:5px;",layout:"column",defaults:{layout:"form",width:stdwidth,border:false,labelWidth:labelWidth,labelAlign:"right"},items:[
			{items:[TF_cdt0]},{items:[TF_cdt1]},{items:[TF_cdt3]},{items:[TF_cdt4]}
		]}
	]});
	
	var fields = ["id","opCode","opName","opKind","mobileNo","emailAdress","loginCode","gender","officeTel","notes","lockFlag","isUpdatePwd","status"];
	var cm = EF.getColumnModel([new Ext.grid.RowNumberer(),
		{header:"用户编号", width:80, align:"left", dataIndex:"opCode",renderer:function(value, metaData, record, rowIndex, colIndex, store) {
			return "<div><a href='###' onclick='openInfo("+record.get("id")+")' >"+value+"</a></div>";
        }},
		{header:"用户姓名", width:80, align:"left", dataIndex:"opName"},
		{header:"手机号", width:120, align:"center", dataIndex:"mobileNo"},
        {header:"邮箱地址", width:180, align:"center", dataIndex:"emailAdress"},
		{header:"登录代码", width:120, align:"left", dataIndex:"loginCode"},
		{header:"性别", width:80, align:"left", dataIndex:"gender",renderer:function(value, metaData, record, rowIndex, colIndex, store) {
			var item = CU.getDropItemRecord("V_SYS_OP_GENDER", value);
			return item.name;
        }},
        {header:"办公电话", width:120, align:"left", dataIndex:"officeTel"},
        
        {header:"锁定标志", width:80, align:"left", dataIndex:"lockFlag",renderer:function(value, metaData, record, rowIndex, colIndex, store) {
			var item = CU.getDropItemRecord("V_SYS_OP_LOCK_FLAG", value);
			return item.name;
        }},
        {header:"是否需要修改密码", width:110, align:"left", dataIndex:"isUpdatePwd",renderer:function(value, metaData, record, rowIndex, colIndex, store) {
			var item = CU.getDropItemRecord("V_SYS_OP_IS_UPDATE_PWD", value);
			return item.name;
        }},
        {header:"有效状态", width:200, align:"left", dataIndex:"status",renderer:function(value, metaData, record, rowIndex, colIndex, store) {
			var item = CU.getDropItemRecord("V_SYS_OP_STATUS", value);
			//return item.name;
			return "<font color='"+(value==0?"#ff0000":"#0000ff")+"'>"+item.name+"</font>";
        }},
        {header:"备注", width:200, align:"left", dataIndex:"notes"}
	]);
	
	P_grid = EF.getGridPanel({url:"/permis/sysop/querySysOpPage",region:"center",layout:"fit",bodyStyle:"border-top: 1px solid #d8d8d8;",border:false,fields:fields,cm:cm,autoBreakHeader:false});
	
	P_base = EF.getPanel({tbar:[B_query,B_clear],layout:"border",items:[P_cdt_form,P_grid]});
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
	ps.opKind = 2;
	P_grid.executeQuery(ps);
}


/** 请空查询条件 **/
function clear() {
	P_cdt_form.reset();
}

//function openInfo(id){
//	var url = ContextPath + "/dispatch/permis/SysOpForm";
//	if(!CU.isEmpty(id)) url += "?id="+id;
//	PU.openModule({url:url,width:600,height:400,resizable:false,modal:true,callback:function() {
//		P_grid.store.reload();
//	}});
//}



