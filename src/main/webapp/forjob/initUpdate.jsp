<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>新闻修改</title>
	</head>

	<body>
		<s:set var="menu" value="\"forjob""></s:set>
		<div class="main">
			<form action="jobsManager/jobs!update.action" method="post">
				<table>
					<tr>
						<td>
							标题：
						</td>
						<td>
							<input type="hidden" name="cloudContext.vo.id"
								value="${cloudContext.vo.id }">
							<input type="text" name="cloudContext.vo.title" id="title"
								value="${cloudContext.vo.title}">
						</td>
					</tr>
					<tr>
						<td>
							内容：
						</td>
						<td>
							<textarea name="cloudContext.vo.content" id="content" rows="30"
								cols="100">${cloudContext.vo.content }</textarea>
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="修改">
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
