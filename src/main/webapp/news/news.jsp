<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@page import="com.chuangfa.PropertyManager"%>
<%@page import="com.chuangfa.CloudContext"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<html>
	<head>
		<base href="<%=basePath%>">
		<title>新闻与活动</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="text/javascript" src="news/news.js">
</script>
	</head>

	<body>
		<s:set var="menu" value="\"news\""></s:set>
		<div class="main">
			<div class="right">
				<div class="bt">
					<img src="images/news[1].jpg" width="93" height="27">
					<a href="news/addNews.jsp" style="display:none;"  authUrl="addNews"><font color="red">添加新闻</font>
					</a>
				</div>
				<ul class="news_lb">
					<!-- news item start -->
					<s:if test="#request.cloudContext.params['news'][0]!=null">
						<s:iterator var="item" value="#request.cloudContext.params.news">
							<li>
								<a
									href="newsManager/news!newsDetail.action?cloudContext.vo.id=${item.id}"><s:property
										value="#request.item.title" /> </a>
								<span> <s:date name="#item.addTime" format="[yyyy-MM-dd]" />
								</span><a style="display:none;"  authUrl="delNews" href="javascript:deleteNews(${item.id});"
									id="deleteNews"><font color="red">删除</font> </a>&nbsp;
								<a style="display:none;"  authUrl="updateNews"
									href="javascript:initUpdateNews(${item.id});" id="updateNews"><font
									color="red">修改</font> </a>
							</li>
						</s:iterator>
					</s:if>
					<s:else>
						<li>
							<a href="javascript:;">暂无相关信息</a>
							<span> </span>
						</li>
					</s:else>
				</ul>

				<!-- AspNetPager V7.2.1 for VS2005 & VS2008  Copyright:2003-2007 Webdiyer (www.webdiyer.com) 
				<div id="AspNetPager1">
					<a style="margin-right: 5px;">首页</a><a style="margin-right: 5px;">上一页</a><span
						style="margin-right: 5px; font-weight: Bold; color: red;">1</span><a
						href="" style="margin-right: 5px;">2</a><a href=""
						style="margin-right: 5px;">3</a><a href=""
						style="margin-right: 5px;">下一页</a><a href=""
						style="margin-right: 5px;">尾页</a>
				</div>-->
			</div>
		</div>
	</body>
</html>
