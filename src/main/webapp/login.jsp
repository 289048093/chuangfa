<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<head>
	<base href="<%=basePath%>">
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
	<style type="text/css">
.login_btn {
	border: 1px solid gray;
	background-color: white;
	width: 50px;
	height: 20px;
}
</style>
</head>
<body>
	<div align="center"
		style="height: 50px; color: red; font-size: large; font-weight: bold">
		<font color="red"><s:iterator var="item"
				value="#request.cloudContext.errorMsgList">${item}<br>
			</s:iterator> </font>
	</div>
	<form action="indexManager/index!login.action" method="post">
		<table align="center" style="top: 50px;" border="1px solie #CCCCCC">
			<caption>
				管理员登录
			</caption>
			<tr>
				<td>
					用户名：
				</td>
				<td>
					<input type="text" name="cloudContext.params.username"
						id="username" />
				</td>
			</tr>
			<tr>
				<td>
					密码：
				</td>
				<td>
					<input type="password" name="cloudContext.params.password"
						id="password" />
				</td>
			</tr>

			<tr>

				<td>
					验证码：
				</td>
				<td>
					<input type="text" name="cloudContext.params.userCode">
					<img src="VerifyCode?Math.random()" id="vcImg"
						onclick="(function(){document.getElementById('vcImg').src='VerifyCode?Math.random()';})();" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<center>
						<br />
						<input type="submit" value="登录" class="login_btn" />
						<input class="login_btn" type="reset" value="重置" />
					</center>
				</td>
			</tr>
		</table>
	</form>
</body>