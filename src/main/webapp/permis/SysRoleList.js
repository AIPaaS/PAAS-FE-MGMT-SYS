
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
	var TF_cdt0 = EF.getTextField({fieldLabel:"角色代码",name:"roleCode",width:comwidth,enableKeyEvents:true,onKeyUp:doCdtTFKeyUp});
	var TF_cdt1 = EF.getTextField({fieldLabel:"角色名称",name:"roleName",width:comwidth,enableKeyEvents:true,onKeyUp:doCdtTFKeyUp});
//	var TF_cdt2 = EF.getComboBox({fieldLabel:"角色类型",hiddenName:"roleType",width:comwidth,def:"V_SYS_ROLE_ROLE_TYPE"});
	
	P_cdt_form = EF.getFormPanel({region:"north",border:false,frame:false,height:maxheight,items:[
		{width:maxwidth,height:maxheight,border:false,bodyStyle:"padding-top:5px;",layout:"column",defaults:{layout:"form",width:stdwidth,border:false,labelWidth:labelWidth,labelAlign:"right"},items:[
			{items:[TF_cdt0]},{items:[TF_cdt1]}
		]}
	]});
	
	var fields = ["id","roleCode","roleName","roleType","roleDesc","status"];
	var cm = EF.getColumnModel([new Ext.grid.RowNumberer(),
		{header:"角色代码", width:120, align:"left", dataIndex:"roleCode",renderer:function(value, metaData, record, rowIndex, colIndex, store) {
			var roleCode = record.get("roleCode");
			if(roleCode == '000'){
				return "<div><a href='###' >"+value+"</a></div>";
			}else{
				return "<div><a href='###' onclick='openInfo("+record.get("id")+")' >"+value+"</a></div>";
			}
			
        }},
		{header:"角色名称", width:160, align:"left", dataIndex:"roleName"},
        {header:"有效状态", width:100, align:"center", dataIndex:"status",renderer:function(value, metaData, record, rowIndex, colIndex, store) {
			var item = CU.getDropItemRecord("V_IS_VALID", value+"");
			return "<font color='"+(value==0?"#ff0000":"#0000ff")+"'>"+item.name+"</font>";
        }},
		{header:"角色描述", width:120, align:"center", dataIndex:"roleDesc"}
	]);
	
	P_grid = EF.getGridPanel({url:"/permis/sysrole/querySysRolePage",region:"center",layout:"fit",bodyStyle:"border-top: 1px solid #d8d8d8;",border:false,fields:fields,cm:cm,autoBreakHeader:false});
	
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
	ps.roleType = 1;
	P_grid.executeQuery(ps);
}


/** 请空查询条件 **/
function clear() {
	P_cdt_form.reset();
}

function openInfo(id){
	var url = ContextPath + "/dispatch/permis/SysRoleForm?roleType=1";
	if(!CU.isEmpty(id)) url += "&id="+id;
	PU.openModule({url:url,width:600,height:400,resizable:false,modal:true,callback:function() {
		P_grid.store.reload();
	}});
}



