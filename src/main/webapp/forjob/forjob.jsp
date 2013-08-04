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

		<title>求职与招聘</title>
	</head>

	<body>
		<s:set var="menu" value="\"forjob\""></s:set>
		<div class="main">
			<div class="right">
				<div class="bt">
					<img src="images/ryzp_tp1[1].jpg" width="93" height="27">
					<a href="forjob/addOrUpdateJobs.jsp" style="display:none;"  authUrl="addJobs"><font
						color="red">添加招聘信息</font> </a>
				</div>
				<s:iterator value="#request.cloudContext.params['jobses']"
					var="item">
					<div>
						<br />
						<h3>
							<s:property value="#request.item.title" />
							<a style="display:none;"  authUrl="updateJobs"
								href="jobsManager/jobs!initUpdate.action?cloudContext.vo.id=<s:property value="#request.item.id"/>"><font
								color="red">修改&nbsp;&nbsp;</font>
							</a>
							<a style="display:none;"  authUrl="deleteJobs"
								href="jobsManager/jobs!delete.action?cloudContext.vo.id=<s:property value="#request.item.id"/>"><font
								color="red">删除&nbsp;&nbsp;</font>
							</a>
						</h3>
						<br />
						<div>
							${item.content}
						</div>
						<br />
						<div style="border-bottom: 1px solid #CCCCCC"></div>
					</div>
				</s:iterator>
			</div>
		</div>
	</body>
</html>
