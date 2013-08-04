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

		<title>产品类型管理</title>
		<SCRIPT type="text/javascript" src="product/type.js"></SCRIPT>
	</head>

	<body>
		<!--Main-->
				<s:set var="menu" value='\"product\"'></s:set>
		<div class="main">
			<form action="#" method="post" id="typeManagerForm">
				<input type="hidden" name="cloudContext.vo.id" id="typeIdInput">
				<input type="hidden" name="cloudContext.vo.name" id="typeNameInput">
				<table border="1" width="100%">
					<caption>
						<b>产品类型管理</b>
						<a style="display:none;"  authUrl="insertType" href="javascript:initInsertType();"><font
							color="red">添加</font> </a>
					</caption>
					<thead id="typeTabBody">
						<tr>
							<td>
								<div>
									编号
								</div>
							</td>
							<td>
								<div>
									名称
								</div>
							</td>
							<td>
								<div>
									操作
								</div>
							</td>
						</tr>
					</thead>
					<tbody>
						<s:if test="#request.cloudContext.params['types'].size()>0">
							<s:iterator var="item" status="status"
								value="#request.cloudContext.params['types']">
								<tr id="typeTr_${item.id }">
									<td>
										${status.index }
									</td>
									<td id="typeName_${item.id }">
										<div id="typeNameDiv_${item.id }">
											${item.name }
										</div>
										<div style="display: none" id="typeNameInput_${item.id}"></div>
									</td>
									<td>
										<div id="originalOperateType_${item.id }">
											<a style="display:none;"  authUrl="deleteType"
												href="javascript:deleteType(${item.id });"><font
												color="red">删除</font> </a>&nbsp;
											<a style="display:none;"  authUrl="updateType"
												href="javascript:initUpdateType(${item.id });"><font
												color="red">修改</font> </a>
										</div>
										<div id="operateConfirm_${item.id }" style="display: none">
											<a href="javascript:confirmUpdate(${item.id })"><font
												color="red">确定</font> </a><a
												href="javascript:cancelUpdate(${item.id });"><font
												color="red">取消</font> </a>
										</div>
									</td>
								</tr>
							</s:iterator>
						</s:if>
						<s:else>
							<tr id="noRecordTr">
								<td colspan="3">
									暂无相关记录
								</td>
							</tr>
						</s:else>
					</tbody>
				</table>
			</form>
		</div>
	</body>
</html>
