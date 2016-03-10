<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="com.binary.framework.web.SessionKey,com.binary.framework.bean.User"%>

<%
String ContextPath = request.getContextPath();
User user = (User)session.getAttribute(SessionKey.SYSTEM_USER);

if(user == null) {
	response.sendRedirect(ContextPath+"/index.jsp");
	return ;
}

Long userId = user.getId();
%>

<!doctype html>
<html>
<head>
<title>EBDP-SDAS-CONSOLE Main</title>
<script type="text/javascript">
var ContextPath = "<%=ContextPath%>";
function forward2SysCodeList() {
	var url = ContextPath + "/dispatch/base/SysCodeList";
	forward(url);
}
function forward2SysModuList() {
	var url = ContextPath + "/dispatch/base/SysModuList";
	forward(url);
}
function forward2SysMenuList() {
	var url = ContextPath + "/dispatch/base/SysMenuList";
	forward(url);
}

function forward2SysRoleList(){
	var url = ContextPath + "/dispatch/permis/SysRoleList";
	forward(url);
}

function forward2SysOpList() {
	var url = ContextPath + "/dispatch/permis/SysOpList";
	forward(url);
}

function forward2SysOpRole(){
	var url = ContextPath + "/dispatch/permis/SysOpRoleList";
	forward(url);
}

function forward2SysModuRole(){
	var url = ContextPath + "/dispatch/permis/SysModuRoleList";
	forward(url);
}

function forward2ModuCode(mc) {
	var url = ContextPath + "/dispatch/mc/"+mc;
	forward(url);
}

function forwardDispatch(url) {
	forward(ContextPath+url);
}
function forward(url) {
	document.getElementById("if_page").src = url + "?PARENT_SID=<%=userId%>&ParentLeftWidth=220&ParentHeaderHeight=50&d="+new Date().getTime();
}


</script>
</head>

<body>

<table>
<tr>
	<td colspan="2">
	&nbsp;
	</td>
</tr>
<tr>
	<td width="300" valign="top">
		<table>
			<tr>
				<td>
					<span style="padding-left:20px;">权限管理</span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forward2SysOpList()">系统用户</a></span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forward2SysRoleList()">系统角色</a></span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forward2SysOpRole()">用户角色分配</a></span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forward2SysModuRole()">角色资源分配</a></span><br>
				</td>
			</tr>
			<tr>
				<td>
					<span style="padding-left:20px;">前台管理</span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forwardDispatch('/dispatch/websys/WebOpList')">前台用户</a></span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forwardDispatch('/dispatch/websys/WebRoleList')">前台角色</a></span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forwardDispatch('/dispatch/websys/WebOpRoleList')">用户角色分配</a></span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forwardDispatch('/dispatch/websys/WebModuRoleList')">角色资源分配</a></span><br>
				</td>
			</tr>
			<tr>
				<td width="300" valign="top">
					<span style="padding-left:20px;">基础管理</span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forward2SysCodeList()">系统代码</a></span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forward2SysModuList()">系统模块</a></span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forward2SysMenuList()">系统菜单</a></span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forwardDispatch('/dispatch/websys/WebModuList')">前台模块</a></span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forwardDispatch('/dispatch/websys/WebMenuList')">前台菜单</a></span><br>
				</td>
			</tr>
			<tr>
				<td width="300" valign="top">
					<span style="padding-left:20px;">租户管理</span><br>
					<span style="padding-left:60px;"><a href="###" onclick="forward2ModuCode('0301')">租户注册审批</a></span><br>
				</td>
			</tr>
		</table>
	</td>
	<td align="center">
		<iframe id="if_page" frameborder='1' width='900' height='600' src="###"></iframe>
	</td>
</tr>
</table>

<br>
<br>

</body>

</html>
