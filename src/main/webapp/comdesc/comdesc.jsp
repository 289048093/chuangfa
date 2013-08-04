<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>公司简介</title>
	</head>
	<body>
		<s:set var="menu" value="\"comdesc\""></s:set>
		<div class="main">
			<div class="right">
				<div class="bt">
					<img src="images/jj[1].jpg" width="93" height="27">
					<a href="comdescManager/comdesc!initUpdate.action" style="display:none;"  authUrl="updateComdesc"><font color="red">修改</font>
					</a>
				</div>
				<div>
					<br />
					${cloudContext.vo.content }
					<br />
				</div>
			</div>
		</div>
	</body>
</html>
