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

		<title>添加新闻</title>
	</head>

	<body>
		<s:set var="menu" value="\"news\""></s:set>
		<div class="main">
			<form action="newsManager/news!insert.action" method="post" >
				<table>
					<tr>
						<td>
							标题：
						</td>
						<td>
							<input type="text" name="cloudContext.vo.title" id="title">
						</td>
					</tr>
					<tr>
						<td>
							内容：
						</td>
						<td>
							<textarea name="cloudContext.vo.content" id="content" rows="30"
								cols="100"></textarea>
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="添加">
						</td>
						<td>
							<input type="reset" value="重置">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
