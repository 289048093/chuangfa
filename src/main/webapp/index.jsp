<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<head>
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
	<SCRIPT type="text/javascript" >
	//location = "indexManager/index!initIndex.action";
	</SCRIPT>
	<%//response.sendRedirect("indexManager/index!initIndex.action");
	//request.getRequestDispatcher("indexManager/index!initIndex.action").forward(request,response); %>
</head>
<body>
	<s:set var="menu" value="\"index\""></s:set>
	<s:action name="indexManager/index.action!initIndex"></s:action>
</body>