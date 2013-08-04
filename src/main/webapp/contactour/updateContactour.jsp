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

		<title>联系我们</title>
	</head>

	<body>
		<s:set var="menu" value="\"contactour\""></s:set>
		<div class="main">
			<div class="right">
				<div class="bt">
					<img src="images/co_tp.jpg" width="93" height="27">
				</div>
				<div>
				</div>
				<form action="contactOurManager/contactOur!update.action"
					method="post">
					<div class="top_10">
						<div id="joblist" class="about_r">
							<h2 class="contact">
								联系创发 CONTACT CHUANGFA
							</h2>
							<div class="contactus">
								<br />
								<br />
								<br />
								<ul>
									<li>
										服务电话：
										<input type="text" name="cloudContext.vo.serviceTel"
											value="<s:property value="#request.cloudContext.vo.serviceTel"/>" />
									</li>
								</ul>
								<p class="black14pxbold">
									&nbsp;
								</p>
								<p class="black14pxbold">
									<span style="font-size: small;">创发商务合作热线：</span>
								</p>
								<ul>
									<li>
										<input type="text" name="cloudContext.vo.cooperationTel"
											value="<s:property value="#request.cloudContext.vo.cooperationTel"/>" />
									</li>
								</ul>
								<p class="black14pxbold">
									&nbsp;
								</p>
								<p class="black14pxbold">
								</p>
								<ul>
									<li>
										<span style="font-size: small;">服务时间： </span><input type="text" name="cloudContext.vo.workTime"
											value="<s:property value="#request.cloudContext.vo.workTime"/>">
									</li>
									<li>
										<span style="font-size: small;">公司名称：<input type="text" name="cloudContext.vo.comName"
												value="<s:property value="#request.cloudContext.vo.comName"/>">
									</li>
									<li>
										<span style="font-size: small;">客服Email：<input
												type="text" name="cloudContext.vo.email"
												value="<s:property value="#request.cloudContext.vo.email"/>">
									</li>
									<li>
										<span style="font-size: small;">公司地址：<input type="text" name="cloudContext.vo.addr"
												value="<s:property value="#request.cloudContext.vo.addr"/>">
									</li>
								</ul>
								<p>
									&nbsp;
								</p>
							</div>
							<input type="submit" value="修改"> &nbsp;&nbsp;|&nbsp;&nbsp;<input type="reset" value="重置">
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
