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
		<title>${cloudContext.vo.title }</title>
		<script type="text/javascript" src="news/news.js">
</script>
	</head>

	<body>
		<s:set var="menu" value="\"news\""></s:set>
		<!--detail    Main-->
		<!--detail    Main-->
		<!--detail    Main-->
		<div class="main">
			<div class="nr">
				<div class="left">
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
															<s:if test="#request.cloudContext.params.news.size()>0">
																<s:iterator var="item"
																	value="#request.cloudContext.params.news">
																	<div class="ygtvitem" id="news_detail_${item.id}">
																		<table border="0" cellpadding="0" cellspacing="0">
																			<tbody>
																				<tr>
																					<td id="ygtvt2" class="ygtvtn">
																						&nbsp;
																					</td>
																					<td>
																						<s:if
																							test="#request.item.id==#request.cloudContext.vo.id">
																							<a id="ygtvlabelel2" class="ygtvlabel"><font
																								color="white"><b><s:property
																											value="#request.item.title" /> </b> </font> </a>
																						</s:if>
																						<s:else>
																							<a id="ygtvlabelel2" class="ygtvlabel"
																								href="newsManager/news!newsDetail.action?cloudContext.vo.id=${item.id}"><s:property
																									value="#request.item.title" /> </a>
																						</s:else>
																					</td>
																				</tr>
																			</tbody>
																		</table>
																		<div class="ygtvchildren" id="ygtvc2"
																			style="display: none;"></div>
																	</div>
																</s:iterator>
															</s:if>
															<s:else>
																<li>
																	<a href="javascript:;">暂无相关信息</a>
																	<span> </span>
																</li>
															</s:else>



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
						<br />
						<h1>
							<b>${cloudContext.vo.title }</b>
							<a href="javascript:initUpdateNews(${item.id});"
								authUrl="updateNews"><font color="red"> 修改</font> </a>
						</h1>
						<a style="float: right">时间:<s:date
								name="#request.cloudContext.vo.addTime" format="[yyyy年MM月dd日]" />
						</a>
						<br />
					</div>
					<table cellspacing="0" cellpadding="0">
						<tbody>
							<tr>
								<td bgcolor="#ffffff" height="19" valign="top" align="left">
									<div align="justify">
										<br />
										<br />
										${cloudContext.vo.content }
										<br />
										<br />
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
		<!--End		detail		Main-->
	</body>
</html>
