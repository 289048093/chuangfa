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
				<div class="top_10">
					<div id="joblist" class="about_r">
						<h2 class="contact">
							联系创发 CONTACT CHUANGFA
							<a style="display:none;"  authUrl="updateContactOurInfo"
								href="contactOurManager/contactOur!initUpdate.action"><font
								color="red">修改基本信息</font> </a>
						</h2>
						<div class="contactus">
							<br />
							<br />
							<br />
							<ul>
								<li>
									<span style="font-size: small;">创发服务热线：</span>
									<br />
									<span class="red14pxbold"><span
										style="font-size: small;"><s:property
												value="#request.cloudContext.vo.serviceTel" /> </span> </span>
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
									<span style="font-size: small;"><span
										class="red14pxbold">&nbsp;</span><span class="red14pxbold"><s:property
												value="#request.cloudContext.vo.cooperationTel" /> &nbsp;</span><span
										class="red14pxbold">&nbsp;</span><span class="red14pxbold">
											<br /> </span> </span>
								</li>
							</ul>
							<p class="black14pxbold">
								&nbsp;
							</p>
							<p class="black14pxbold">
								<span style="font-size: small;">服务时间: </span>
								<span style="font-size: small;"><s:property
										value="#request.cloudContext.vo.workTime" /> </span>

							</p>
							<ul>
								<li>
								</li>
								<li>
									<span style="font-size: small;">公司名称：<span
										class="red14pxbold"><s:property
												value="#request.cloudContext.vo.comName" /> </span> </span>
								</li>
								<li>
									<span style="font-size: small;">客服Email：<span
										class="red14pxbold"><s:property
												value="#request.cloudContext.vo.email" /> </span> </span>
								</li>
								<li>
									<span style="font-size: small;">公司地址：<s:property
											value="#request.cloudContext.vo.addr" />
								</li>
							</ul>
							<p>
								&nbsp;
							</p>
						</div>
					</div>

					<p>
						<b>分店信息</b><a style="display:none;"  authUrl="addSubShops"
							href="contactour/addSubshop.jsp"><font color="red">添加分店</font>
						</a>
					</p>
					<!-- 分店联系电话 -->
					<s:iterator value="#request.cloudContext.params['subshops']"
						var="item">
						<p class="black14pxbold">
							&nbsp;
						</p>
						<p class="black14pxbold">
							<span style="font-size: small;"><b><s:property
										value="#request.item.name" />
							</b>
							</span>
							<a style="display:none;"  authUrl="updateSubshop"
								href="contactOurManager/contactOur!initUpdateSubshop.action?cloudContext.params.subshopId=<s:property value="#request.item.id"/>"><font
								color="red">修改</font> </a>
							<a style="display:none;"  authUrl="deleteSubshop" href="contactOurManager/contactOur!deleteSubshop.action?cloudContext.params.subshopId=<s:property value="#request.item.id"/>"><font color="red">删除</font></a>
						</p>
						<ul>
							<li>
								<span style="font-size: small;">联系电话:<span
									class="red14pxbold"><s:property
											value="#request.item.telphone" />
								</span> </span>
							</li>
							<li>
								<span style="font-size: small;">联系人:<span
									class="red14pxbold"> <s:property
											value="#request.item.contacter" />
								</span> </span>
							</li>
							<li>
								<span style="font-size: small;">地址:<span
									class="red14pxbold"><s:property
											value="#request.item.addr" />
								</span> </span>
							</li>
						</ul>
						<p>
							&nbsp;
						</p>
					</s:iterator>
					<!-- 分店 end -->

				</div>
			</div>
		</div>
	</body>
</html>
