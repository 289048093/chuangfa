<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<head>
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
	<style type="text/css">
.login_btn {
	border: 1px solid gray;
	background-color: white;
	width: 50px;
	height: 20px;
}
</style>
	<script type="text/javascript">
function submitForm() {
	var n = g('newPwd').value;
	var rn = g('reNewPwd').value;
	if (n != rn) {
		g("errorMsg").innerHTML = "两次输入密码不一致";
		return;
	}
	g('updatePwdFOrm').submit();
}
function g(id) {
	return document.getElementById(id);
}
</script>
</head>
<body>
	<div class="main">
		<div  align="center"  style="height: 50px;color: red;font-size: large;font-weight: bold" id="errorMsg" >
			<font color="red"><s:iterator var="item"
					value="#request.cloudContext.errorMsgList">${item}<br>
				</s:iterator> </font>
		</div>
		<form action="indexManager/index!updatePwd.action" method="post"
			id="updatePwdFOrm">
			<table align="center" style="top: 50px;margin:0 300px 100px" border="1px solie #CCCCCC">
				<caption>
					管理员密码修改
				</caption>
				<tr>
					<td>
						原密码：
					</td>
					<td>
						<input type="password" name="cloudContext.params.password"
							id="password" />
					</td>
				</tr>
				<tr>
					<td>
						新密码：
					</td>
					<td>
						<input type="password" name="cloudContext.params.newPwd"
							id="newPwd" />
					</td>
				</tr>
				<tr>
					<td>
						再次输入新密码：
					</td>
					<td>
						<input type="password" id="reNewPwd" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<center>
							<br />
							<input type="button" value="登录" class="login_btn"
								onclick="submitForm()" />
							<input class="login_btn" type="reset" value="重置" />
						</center>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>