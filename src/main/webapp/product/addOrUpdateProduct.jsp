<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@page import="java.io.File"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLEncoder"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setAttribute("files", new File(getServletContext().getRealPath("/"), "productImage").listFiles());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title><s:if test="#request.cloudContext.vo.id==null">添加产品</s:if>
			<s:else>修改产品</s:else>
		</title>
		<SCRIPT type="text/javascript" src="product/validate.js"></SCRIPT>
		<script type="text/javascript">
$(function() {
	$('#desc').val('${cloudContext.vo.desc}');
});</script>
	</head>

	<body>
		<s:set var="menu" value='\"product\"'></s:set>
		<div class="main">
			<form
				<s:if test="#request.cloudContext.vo.id==null">
				action="productManager/product!insert.action"
			</s:if>
				<s:else>
				action="productManager/product!update.action"
			</s:else>
				method="post">
				<input type="hidden" id="productId" name="cloudContext.vo.id"
					value='<s:property value="#request.cloudContext.vo.id"/>'>
				<table>
					<tr>
						<td>
							产品名称：
						</td>
						<td>
							<input type="text" name="cloudContext.vo.name" id="title"
								value='<s:property value="#request.cloudContext.vo.name"/>'>
						</td>
					</tr>
					<tr>
						<td>
							产品类别：
						</td>
						<td>
							<select id="types" name="cloudContext.vo.typeId">
								<option value="">
									--请选择--
								</option>
								<s:iterator var="item"
									value="#request.cloudContext.params['types']">
									<option value="${item.id }"
										<s:if test="#request.cloudContext.vo.typeId==#request.item.id">selected="selected"</s:if>>
										${item.name }
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							产品价格：
						</td>
						<td>
							<input type="text" name="cloudContext.vo.price" id="price"
								value='<s:property value="#request.cloudContext.vo.price"/>'>
							<span class="errorMsg" style="color: red"></span>
						</td>
					</tr>
					<tr>
						<td>
							品牌名称：
						</td>
						<td>
							<input type="text" name="cloudContext.vo.brand" id="brand"
								value='<s:property value="#request.cloudContext.vo.brand"/>'>
						</td>
					</tr>
					<tr>
						<td>
							产品型号：
						</td>
						<td>
							<input type="text" name="cloudContext.vo.model" id="model"
								value='<s:property value="#request.cloudContext.vo.model"/>'>
						</td>
					</tr>
					<tr>
						<td>
							生产厂家：
						</td>
						<td>
							<input type="text" name="cloudContext.vo.com" id="com"
								value='<s:property value="#request.cloudContext.vo.com"/>'>
						</td>
					</tr>
					<tr>
						<td>
							生产日期：
						</td>
						<td>
							<input type="text" name="cloudContext.vo.produceTime"
								id="produceTime"
								value="<s:date name="#request.cloudContext.vo.produceTime"
								format="yyyy-MM-dd" />">
							<span class="errorMsg" style="color: red"></span>
						</td>
					</tr>
					<tr>
						<td>
							热门产品排名：
						</td>
						<td>
							<input type="text" name="cloudContext.vo.topIndex" id="topIndex"
								value='<s:property value="#request.cloudContext.vo.topIndex"/>'>
						</td>
					</tr>
					<tr>
						<td>
							产品图片
						</td>
						<td>

							<div style="height: 200px;width:800px; overflow: auto;">
								<s:iterator value="#request.files" var="item">
									<!-- <table>
										<tr>
											<td rowspan="2"></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
										</tr>
									</table> -->
									<span
										style="border: 1px solid gray; display: inline-block; width: 120px; height: 120px">
										<input type="radio" name="cloudContext.vo.proPic"
											value="<s:property value="#request.item.name"/>"
											<s:if test="#request.item.name==#request.cloudContext.vo.proPic">checked="true"</s:if>
											id="radio_<s:property value="#request.item.name"/>" /> <label
											for="radio_<s:property value="#request.item.name"/>">
											<img disabled="disabled" src="productImage/${item.name}"
												width="90px" height="90px" title="${item.name}" />
											<br />
											<div title="${item.name}"
												style="width: 300px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis; -o-text-overflow: ellipsis;">
												<font size="2px">${item.name}</font>
											</div>
										</label> </span>
								</s:iterator>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							详细信息：
						</td>
						<td>
							<textarea name="cloudContext.vo.desc" id="desc" rows="30"
								cols="100"></textarea>
						</td>
					</tr>
					<tr>
						<td>
							<s:if test="#request.cloudContext.vo.id==null">
								<input type="submit" value="添加" class="submit">
							</s:if>
							<s:else>
								<input type="submit" value="修改" class="submit">
							</s:else>
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
