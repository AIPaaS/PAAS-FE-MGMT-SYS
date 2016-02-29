
var CurrDataMap = {};

var CurrentCheckMnt = null;


function init() {
	initData(function() {
		initComponent();
		initListener();
		initFace();
		$("#cdtStatus").val(0);
		query(1);
	});
	
}


function initData(cb) {
	var statusselhtml = PU.getSelectOptionsHtml("V_WS_MERCHENT_STATUS");
	$("#cdtStatus").html(statusselhtml);
	if(CU.isFunction(cb)) cb();
}
function initComponent() {
}
function initListener() {
	$("#cdtMntCode").bind("keyup", doCdtTFKeyUp);
	$("#cdtMntName").bind("keyup", doCdtTFKeyUp);
	$("#cdtStatus").bind("change",function(){query(1);});
	
	$("#btn_query").bind("click",function(){query(1);});
	$("#grid_pageSize").bind("change",function(){query(1);});
	
	$("#btn_check_pass").bind("click", checkMntPass);
	$("#btn_check_back").bind("click", checkMntBack);
}
function initFace() {
}


/** 执行条件文本框回车查询 **/
function doCdtTFKeyUp(e) {
	if(e.keyCode === 13) query(1);
}


function query(pageNum){
	if(CU.isEmpty(pageNum)) pageNum = 1;
	
	$("#tabList").html("");
	$("#ul_pagination").remove();
	$("#pagination_box").html('<ul id="ul_pagination" class="pagination-sm"></ul>');
	
	var pageSize = $("#grid_pageSize").val();
	var mntCode = $("#cdtMntCode").val();
	var mntName = $("#cdtMntName").val();
	var status = $("#cdtStatus").val();
	var orders = "MNT_CODE";
	
	var ps = {pageNum:pageNum,pageSize:pageSize,mntCode:mntCode,mntName:mntName,status:status,orders:orders};
	RS.ajax({url:"/mnt/merchent/queryMntPage",ps:ps,cb:function(r) {
		if(!CU.isEmpty(r)){
			var data = r.data;
			for(var i=0; i<data.length; i++) {
				CurrDataMap["key_"+data[i].id] = data[i];
			}
			
			$("#ul_pagination").twbsPagination({
		        totalPages: r.totalPages?r.totalPages:1,
		        visiblePages: 7,
		        startPage: r.pageNum,
		        first:"首页",
		        prev:"上一页",
		        next:"下一页",
		        last:"尾页",
		        onPageClick: function (event, page) {
		        	query(page);
		        }
		    	
		    });
			$('#tabList-tmpl').tmpl(r).appendTo("#tabList");
			
			for(var i=0;i<data.length;i++){
				$("#btn_check_view_"+data[i].id).bind("click", function() {
					var obj = CurrDataMap["key_"+this.id.substring(this.id.lastIndexOf("_")+1)];
					showCheckView(obj);
				});
				
				$("#btn_checking_"+data[i].id).bind("click",function(){
					var obj = CurrDataMap["key_"+this.id.substring(this.id.lastIndexOf("_")+1)];
					showCheckForm(obj);
				});
			}
		}
	}});
	
}


function showCheckForm(mnt) {
	CurrentCheckMnt = mnt;
	$("#div_checkFormTitle").html("租户[<font color='blue'>"+mnt.mntCode+"</font>][<font color='blue'>"+mnt.mntName+"</font>]审核");
	$('#div_checkForm').modal('show');
}
function showCheckView(mnt) {
	$("#tabCheckView").html("");
	$("#div_checkViewTitle").html("租户[<font color='blue'>"+mnt.mntCode+"</font>][<font color='blue'>"+mnt.mntName+"</font>]审核情况");
	$('#tabCheckView-tmpl').tmpl(mnt).appendTo("#tabCheckView");
	$('#div_checkView').modal('show');
}


function replaceDesc(desc) {
	if(CU.isEmpty(desc)) return "";
	return (desc+"").replace(/\n/g, "<br>");
}


function checkMntPass() {
	checkMnt(1);
}
function checkMntBack() {
	checkMnt(2);
}


//ct=1通过, ct=2退回
function checkMnt(ct) {
	var desc = $("#winCheckDesc").val();
	if(CU.isEmpty(desc)) {
		CC.showMsg({msg:"请输入审核意见!",option:1});
		return ;
	}
	
	CC.showMsg({msg:"您确定要审核[<font color='"+(ct==1?"#008800":"red")+"'>"+(ct==1?"通过":"退回")+"</font>]当前租户吗?",option:2,callback:function(cr) {
		if(cr != "ok") return ;
		var url = "/mnt/merchent/"+(ct==1?"/checkMntPass":"/checkMntBack");
		RS.ajax({url:url,ps:{id:CurrentCheckMnt.id,checkDesc:desc,cb:function() {
			$('#div_checkForm').modal('hide');
			setTimeout(function(){query();}, 500);
		}}});
	}});
}

