<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.chuangfa.entity.SubshopInfoEntity"%>
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

		<title>招聘信息</title>
	</head>

	<body>
		<s:set var="menu" value="\"contactour\""></s:set>
		<div class="main">
			<form action="contactOurManager/contactOur!updateSubshop.action" method="post" >
				<table>
					<tr>
						<td>
							<input type="hidden" value="<s:property value="#request.cloudContext.params['subshop']['id']"/>">
							店名：
						</td>
						<td>
							<input type="text" name="cloudContext.params.name" id="name" value="<s:property value="cloudContext.params['subshop']['name']"/>">
						</td>
					</tr>
					<tr>
						<td>
							联系电话：
						</td>
						<td>
							<input name="cloudContext.params.telphone" id="content" value="<s:property value="cloudContext.params['subshop']['telphone']"/>"/>
						</td>
					</tr>
					<tr>
						<td>
							联系人：
						</td>
						<td>
							<input name="cloudContext.params.contacter" id="content" value="<s:property value="cloudContext.params['subshop']['contacter']"/>">
						</td>
					</tr>
					<tr>
						<td>
							地址：
						</td>
						<td>
							<input name="cloudContext.params.addr" id="content" value="<s:property value="#request.cloudContext.params['subshop']['addr']"/>">
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
