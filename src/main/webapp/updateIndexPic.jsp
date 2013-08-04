<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.io.File"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<head>
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
	<SCRIPT type="text/javascript" src="index.js"></SCRIPT>
	<%
	    request.setAttribute("files", new File(getServletContext().getRealPath("/"), "webPageImage").listFiles());
	%>
</head>
<body>
	<s:set var="menu" value="\"index\""></s:set>
	<!--Main-->
	<div class="main">
		<!-- banner start  -->
		<form method="post" action="indexManager/index!updateIndexPic.action">
			<s:iterator value="#request.files" var="item">

				<input type="radio" name="cloudContext.params.indexPic" value="<s:property value="#request.item.name"/>"
					id="radio_<s:property value="#request.item.name"/>" />
				<label for="radio_<s:property value="#request.item.name"/>">
				<img src="webPageImage/<s:property value="#request.item.name"/>"
					height="90px" /></label>
				<br />
				<div style="border-bottom: 1px solid gray"></div>
			</s:iterator>
			<input type="submit" value="提交">
			<input type="button" value="取消" onclick="history.back()">
			<div class="clear"></div>
		</form>
		<!-- new end -->
	</div>
</body>