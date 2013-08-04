<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<head>
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
	<SCRIPT type="text/javascript" src="index.js"></SCRIPT>
</head>
<body>
	<s:set var="menu" value="\"index\""></s:set>
	<!--Main-->
	<div class="main">
		<!-- banner start  -->
		<div class="banner">
			<div class="banner_left">
				<img src="images/banner_left[1].jpg" width="72" height="353">
			</div>
			<div class="banner_right" style="overflow: hidden;">
				<!-- screen scroll img -->
				<s:set var="indexPic" value="@com.chuangfa.PropertyManager@getInstance().webPage.indexPic"></s:set>
				<img alt="" src="webPageImage/<s:property value="indexPic"/>">
			</div>
			<a style="display:none;"  authUrl="updateIndexPic" href="updateIndexPic.jsp"><font
				color="red"
				style="font-weight: bold; font-size: large; float: right;">修改首页图</font>
			</a>
			<div class="clear"></div>
		</div>
		<!-- banner end -->
		<!-- product start -->
		<div class="imiddon">
			<div class="imiddon_top">
				<img src="images/product_service_title.jpg" width="95" height="16">
			</div>
			<ul class="imiddon_lb">
				<s:iterator var="item"
					value="#request.cloudContext.params.topProducts">
					<li>
						<a href="javascript:productDetail(${item.id });" class="tp"><img
								src="<s:property value="@com.chuangfa.util.Constant@PRODUCT_HEAD_PIC_DIC"/>${item.headPic }"
								width="90" height="90" border="0"> </a>
						<p>
							<font style="color: #0554b1">${item.name }</font>
							<br />
							<a>价格:</a>${item.price }
							<br />
							<a href="javascript:productDetail(${item.id });" class="lj">了解更多&gt;&gt;</a>
						</p>
						<a href="javascript:deleteProduct(${item.id });"
							authUrl="deleteProduct"><font color="red">删除</font> </a>
						<a href="javascript:initUpdateProduct(${item.id });"
							authUrl="updateProduct"><font color="red">修改</font> </a>
					</li>
				</s:iterator>
			</ul>
		</div>
		<!-- product end -->

		<!-- new start -->
		<div class="iright">
			<div class="iright_top">
				<img src="images/news_top.jpg" width="95" height="16">
			</div>
			<br />
			<s:if test="#request.cloudContext.params['topNews'][0]!=null">
				<s:iterator var="item" value="#request.cloudContext.params.topNews">
					<div>
						<img src="images/news_top2.jpg">
						<a
							href="newsManager/news!newsDetail.action?cloudContext.vo.id=${item.id}"><s:property
								value="#request.item.title" /> </a>
					</div>
					<a style="display:none;"  authUrl="delNews" href="javascript:deleteNews(${item.id});"
						id="deleteNews"><font color="red">删除</font> </a>&nbsp;
								<a style="display:none;"  authUrl="updateNews"
						href="javascript:initUpdateNews(${item.id});" id="updateNews"><font
						color="red">修改</font> </a>
				</s:iterator>
			</s:if>
			<s:else>
				<p>
					<a href="javascript:;">暂无相关信息</a>
				</p>
			</s:else>
		</div>
		<div class="clear"></div>
		<!-- new end -->
	</div>
</body>