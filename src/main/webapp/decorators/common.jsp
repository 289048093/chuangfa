<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.chuangfa.LoginedUser"%>
<%@page import="com.chuangfa.util.Constant"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<decorator:usePage id="decoratedPage" />
<html>
	<head>
		<base href="<%=basePath%>">
		<META content="IE=7.0000" http-equiv="X-UA-Compatible">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title><decorator:title default="创发贸易商行" />
		</title>
		<meta name="description" content="萍乡创发贸易商行">
		<meta name="keywords" content="萍乡创发贸易商行、电器专营、萍乡厨卫、萍乡创发贸易、创发贸易商行、江西萍乡创发贸易商行、江西萍乡创发贸易、创发贸易、贸易商行、萍乡>创发、萍乡电器商行、萍乡电器、chuangfa、chuangfamaoyi、chuangfamaoyishanghang">
		<link rel="stylesheet" type="text/css" href="css/main.css">
		<script type="text/javascript" src="index.js">
</script>
		<script type="text/javascript" src="js/jquery-1.7.2.min.js">
</script>
		<script type="text/javascript" src="js/CkGobal.js">
</script>
		<script type="text/javascript">
<!--
		var rightsUrls;
<%//权限
            LoginedUser loginedUser = (LoginedUser) session.getAttribute(Constant.LOGINED_USER);
            if (loginedUser != null) {
                out.println(String.format("rightsUrls='%1$s';", loginedUser.getLastLoginTime().toString()));
            }%>
	  function showLocale(objD){
			 var yy = objD.getFullYear();
			 var MM = objD.getMonth()+1;
			 if(MM<10){
			 	MM = '0' + MM;
			 }
			 var dd = objD.getDate();
			 if(dd<10){ 
			 	dd = '0' + dd;
			 }
			 var hh = objD.getHours();
			 var hour=objD.getHours();
			 if(hh<10){
			 	 hh = '0' + hh;
			 }
			 var mm = objD.getMinutes();
			 if(mm<10){
			 	mm = '0' + mm;
			 }
			 var ss = objD.getSeconds();
			 if(ss<10){
				 ss = '0' + ss;
			 }
			 var ww = objD.getDay();
			 if  (ww==0){ 
			 	ww="星期日";
			 }else if  (ww==1){
			 	ww="星期一";
			 }else if  (ww==2){
			 	ww="星期二";
			 }else if  (ww==3){
			 	ww="星期三";
			 }else if  (ww==4){
			 	ww="星期四";
			 }else if  (ww==5){
			 	ww="星期五";
			 }else if (ww==6){
			 	ww="星期六";
			 }
			 var hello="";
			 if(hour < 6){
			 	hello="凌晨好";
			 }else if (hour < 9){
			 	hello="早上好";
			 }else if (hour < 12){
			 	hello="上午好";
			 }else if (hour < 14){
			 	hello="中午好";
			 }else if (hour < 17){
			 	hello="下午好";
			 }else if (hour < 19){
			 	hello="傍晚好";
			 }else if (hour < 22){
			 	hello="晚上好";
			 }else {
			 	hello="夜里好";
			 }
			 var session_realname= $("#session_realnameId").val();
			 //下午好,开发人员! 今天是:2011-08-10 星期三 
			  var str =hello+"，"+session_realname+"！ 今天是："+yy + "-" + MM + "-" + dd+" "+ww + " " + hh + ":" + mm + ":" + ss ;
			 return str;
			}
			function tick(){
			 $("#realTime").html(showLocale(new Date()));
			 window.setTimeout("tick()", 1000);
			}

	$(function(){
		tick();
		$('#header1_gudonglink').change(function(){
			if($(this).val()){
				window.open($(this).val());
			}
		});
	});

//-->
</script>
		<decorator:head />
	</head>
	<body>
		<s:set var="menus" value="@com.chuangfa.PropertyManager@getMenus()"></s:set>
		<!--header-->
		<div class="header">
			<div class="top">
				友情链接：
				<select name="header1$gudonglink" id="header1_gudonglink">
					<option selected="selected" value="">
						点击进入相应网站
					</option>
					<option value="http://www.xingyeyinghua.com/">
						兴业樱花
					</option>
					<option value="http://www.cn-modern.com/zh-CN/pop.html">
						现代
					</option>
				</select>
			</div>
			<a style="display:none;"  authUrl="updatePwd" href="updatePwd.jsp"><font color="red"
				size="3"><b>密码修改</b> </font> </a>
			<a style="display:none;"  authUrl="logout" href="indexManager/index!logout.action"><font
				color="red" size="3"><b>注销</b> </font> </a>
			<div class="logo">
				<s:set var="logoPic"
					value="@com.chuangfa.PropertyManager@getInstance().webPage.logoPic"></s:set>
				<a href="index.jsp"><img style="border: 0px"
						src="webPageImage/<s:property value="logoPic"/>" width="470"
						height="60"> </a>
				<a style="display:none;"  authUrl="updateLogo" href="updateLogo.jsp"><font color="red">修改logo</font>
				</a>
			</div>
			<ul class="nav">
				<s:iterator var="item" value="menus">
					<li>
						<s:if test="#request.item.name==#request.menu">
							<a href="${item.url}"><img border="0"
									src="images/${item.name}Active.jpg"> </a>
						</s:if>
						<s:else>
							<a href="${item.url}"><img border="0"
									onmouseover="src='images/${item.name}Active.jpg'"
									onmouseout="src='images/${item.name}.jpg'"
									src="images/${item.name}.jpg"> </a>
						</s:else>
					</li>
				</s:iterator>
			</ul>
		</div>
		<!--End				-->
		<decorator:body />
		<!--Fooder-->
		<div id="bottom" class="fooder">
			<p align="center">
				<a href="#" target="_blank">版权所有2013</a> |
				<a href="#" target="_blank">萍乡创发商行</a>
			</p>
		</div>
		<!--End		Fooder-->
	</body>
</html>