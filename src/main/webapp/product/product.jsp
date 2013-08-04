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
		<title>产品与支持</title>
		<script type="text/javascript" src="product/product.js">
</script>
	</head>

	<body>
		<s:set var="menu" value='\"product\"'></s:set>
		<!--Main-->
		<div class="main">
			<div class="nr">

				<div class="left">
					<a style="display:none;"  authUrl="managerType" href="typeManager/type!query.action"
						style="position: absolute; top: -13px"><font color="red">产品类型管理</font>
					</a>
					<p>
						<img src="images/cp_tp3[1].jpg" width="208" height="8">
					</p>
					<div class="left_middon2">
						<!--ml-->
						<div class="left_middonlb">
							<table width="200" cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<tr>
										<td width="200" valign="top" class="nifty_blue_column">
											<div>
												<div id="tree_div" class="tree_div_v4">
													<div class="ygtvitem" id="ygtv0">
														<div class="ygtvchildren" id="ygtvc0">
															<!-- type start -->
															<div class="ygtvitem" id="ygtv2">
																<table border="0" cellpadding="0" cellspacing="0">
																	<tbody>
																		<tr>
																			<td>
																				<a id="ygtvlabelel2" class="ygtvlabel"
																					<s:if test="#request.cloudContext.params['typeId'][0]>0">
																					href="javascript:queryProduct();" 
																					</s:if>
																					<s:else>
																					href="javascript:;"
																					style=" font-weight:bold; color: #ccccff;" 
																					</s:else>>全部
																				</a>
																			</td>
																		</tr>
																	</tbody>
																</table>
																<div class="ygtvchildren" id="ygtvc2"
																	style="display: none;"></div>
															</div>
															<s:if
																test="#request.cloudContext.params['types'].size()>0">
																<s:iterator var="item"
																	value="#request.cloudContext.params['types']">
																	<div class="ygtvitem" id="ygtv3">
																		<table border="0" cellpadding="0" cellspacing="0">
																			<tbody>
																				<tr>
																					<td id="ygtvt3" class="ygtvtn">
																						&nbsp;
																					</td>
																					<td>
																						<a id="ygtvlabelel3" class="ygtvlabel"
																							href="javascript:queryProduct(${item.id});"
																							<s:if test="#request.cloudContext.params['typeId'][0]!=#request.item.id">
																					href="javascript:queryProduct(${item.id});" 
																					</s:if>
																							<s:else>
																					href="javascript:;"
																					style=" font-weight:bold; color: #ccccff;" 
																					</s:else>>${item.name
																							}</a>
																					</td>
																				</tr>
																			</tbody>
																		</table>
																		<div class="ygtvchildren" id="ygtvc3"
																			style="display: none;"></div>
																	</div>
																</s:iterator>
															</s:if>
															<!-- type end -->
														</div>
													</div>
												</div>


											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<!--End			ml	-->
					</div>
				</div>

				<!-- RIGHT -->
				<div class="right">
					<div class="bt">
						<img src="images/cp_tp12[1].jpg" width="37" height="18">
						<a style="display:none;"  authUrl="addProduct" href="productManager/product!init.action"><font
							color="red">产品添加</font> </a>
					</div>
					<table cellspacing="0" cellpadding="0">
						<tbody>
							<tr>
								<td bgcolor="#ffffff" height="19" valign="top" align="left">
									<div align="justify">



										<s:if test="#request.cloudContext.params['products'].size()>0">
											<ul class="imiddon_lb">
												<s:iterator var="item"
													value="#request.cloudContext.params['products']">
													<li>
														<a href="javascript:productDetail(${item.id });"
															class="tp"><img src="<s:property value="@com.chuangfa.util.Constant@PRODUCT_HEAD_PIC_DIC"/>${item.headPic }" width="90"
																height="90" border="0"> </a>
														<p>
															<font style="color: #0554b1">${item.name }</font>
															<br />
															<a>价格:</a>${item.price }
															<br />
															<a href="javascript:productDetail(${item.id });"
																class="lj">了解更多&gt;&gt;</a>
														</p>
														<a href="javascript:deleteProduct(${item.id });"
															authUrl="deleteProduct"><font color="red">删除</font> </a>
														<a href="javascript:initUpdateProduct(${item.id });"
															authUrl="updateProduct"><font color="red">修改</font> </a>
													</li>
												</s:iterator>
											</ul>
										</s:if>
										<s:else>暂无相关产品信息</s:else>

									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
			<p class="le11">
				<img src="images/cp_tp14[1].jpg" width="208" height="8">
			</p>
		</div>
		<!--End				Main-->
		<div class="clear"></div>
	</body>
</html>
