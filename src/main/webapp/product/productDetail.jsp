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
		<title>产品详情</title>
		<link media="screen" href="css/productDetail2.css" type="text/css"
			rel="stylesheet">
		<link media="screen" href="css/productDetail.css" type="text/css"
			rel="stylesheet">
		<script type="text/javascript" src="product/product.js">
</script>
	</head>
	<body>
		<s:set var="menu" value="\"product\""></s:set>
		<div id="mainbody">

			<!--box start-->
			<div class="cl" style="margin-top: 20px;">

				<div class="l">
					<div class="cl">
						<img src="images/Product_Left_title[1].jpg">
					</div>

					<!-- type start -->

					<div id="leftmenu">
						<ul>
							<s:iterator var="typeItem"
								value="#request.cloudContext.params['types']">
								<table width="160" height="22" border="0" cellpadding="0"
									cellspacing="0"
									id='typeTab_<s:property value="#request.typeItem.id"/>'>
									<tbody>
										<tr>
											<td>
												<a
													href='javascript:typeProductList(<s:property value="#request.typeItem.id"/>)'
													class="LeftLink"> <s:if
														test="#request.cloudContext.vo.typeId==#request.typeItem.id">
														<b>+ <s:property value="#request.typeItem.name" /><b>
													</s:if> <s:else>
													+ <s:property value="#request.typeItem.name" />
													</s:else> </a>
											</td>
										</tr>
									</tbody>
								</table>
								<div id='divType_<s:property value="#request.typeItem.id"/>'
									<s:if test="#request.cloudContext.vo.typeId!=#request.typeItem.id">
														style="display: none;"
													</s:if>>
									<s:if test="#request.typeItem.proEntitys.size()>0">
										<s:iterator var="product_Item"
											value="#request.typeItem.proEntitys">
											<table width="100%" height="22" border="0" cellpadding="0"
												cellspacing="0">
												<tbody>
													<tr>
														<td>
															<s:if
																test="#request.product_Item.id==#request.cloudContext.vo.id">
																<a href="javascript:;" class="LeftLink"
																	style="font-weight: bold;">- ${product_Item.name}</a>
															</s:if>
															<s:else>
																<a href='javascript:productDetail(${product_Item.id});'
																	class="LeftLink">- ${product_Item.name}</a>
															</s:else>
														</td>
													</tr>
												</tbody>
											</table>
										</s:iterator>
									</s:if>
									<s:else>
										<a href="javascript:;" class="LeftLink">--无--</a>
									</s:else>
								</div>
							</s:iterator>
						</ul>
					</div>
				</div>
			</div>
			<div id="Rightcontent">
				<div id="content">
					<div id="Right_top">
						<div id="Righttitle">
							产品中心
							<a
								href='javascript:deleteProduct(<s:property value="#request.cloudContext.vo.id"/>);'
								authUrl="deleteProduct"><font color="red">删除</font> </a>
							<a
								href='javascript:initUpdateProduct(<s:property value="#request.cloudContext.vo.id"/>);'
								authUrl="deleteProduct"><font color="red">修改</font> </a>
						</div>
						<div id="Position">
							<a href="index.jsp">首页</a> &gt;
							<a href="productManager/product!query.action">产品中心</a> &gt;
							<span class="action">产品列表</span>
						</div>
					</div>
					<div id="productinfo">

						<table width="99%" height="390" border="0" cellpadding="0"
							cellspacing="0" background="images/product_view_bg[1].gif">
							<tbody>
								<tr>
									<td align="center" valign="top">
										<a rel="lightbox" target="blank"
											href="productImage/<s:property value="#request.cloudContext.vo.proPic"/>"><img
												src="productRealImage/<s:property value="#request.cloudContext.vo.proPic"/>"
												width="511" height="342" border="0"> <br> </a>
									</td>
								</tr>
								<tr>
									<td align="center" valign="top">
										<span style="font-weight: bold"><s:property
												value="#request.cloudContext.vo.name" />&gt;&gt;</span>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="line"></div>
						<table width="100%" border="0" cellspacing="0" cellpadding="5">
							<tbody>
								<tr>
									<td class="title">
										♦&nbsp;产品详情
									</td>
								</tr>
								<tr>
									<td>
										<a name="TD" id="TD"><strong>价格：</strong> </a>
										<span><strong><s:property
													value="#request.cloudContext.vo.price" /> </strong> </span>
										<br />
										<br />
										<a name="CS" id="CS"><strong>品牌：</strong> </a>
										<span><strong><s:property
													value="#request.cloudContext.vo.brand" /> </strong> </span>
										<br />
										<br />
										<a name="CS" id="CS"><strong>型号：</strong> </a>
										<span><strong><s:property
													value="#request.cloudContext.vo.model" /> </strong> </span>
										<br />
										<br />
										<a name="CS" id="CS"><strong>生产厂家：</strong> </a>
										<span><strong><s:property
													value="#request.cloudContext.vo.com" /> </strong> </span>
										<br />
										<br />
										<a name="CS" id="CS"><strong>生产日期：</strong> </a>
										<span><strong> <s:date
													name="#request.cloudContext.vo.produceTime"
													format="yyyy-MM-dd" /> </strong> </span>
										<br />
										<br />
										<a name="CS" id="CS"><strong>详情：</strong> </a>
										<div>
											<s:property value="#request.cloudContext.vo.desc" />
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!--box over-->
	</body>