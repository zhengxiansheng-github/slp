<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta http-equiv="content-language" content="zh-CN">
    <meta http-equiv="Cache-Control" content="no-transform" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>赛利浦设计官网</title>
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <meta name="author" content="by 赛利浦">
    <link rel="icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="icon" href="/favicon.png" type="image/png" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="bookmark" href="/favicon.ico" />
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script>var webroot = "/";</script>
</head>
<body>
    <!--head start-->
    <jsp:include page="title.jsp"></jsp:include>
    <!--end-->
    	<!-- 因为为了页面效果所以加了一点banner的样式 -->
    	<section class="banner"></section>
    	<!--end-->
    <!--Service start-->
    <section class="service container sx-jianju text-center">
        <h2 class="h-h2">赛利浦模板平台</h2>
        <p class="m-sm xx">我们致力于打造一个优秀的建站资源共享学习平台</p>
        <div class="row">
        	<c:forEach var="siteInfo" items="${siteInfoList }">
            	<figure class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                	<span class="service-kj"></span>
                	<h3><a href="#">${siteInfo.name }</a></h3>
               	 	<ul class="list-unstyled">
                    	${siteInfo.content }
                	</ul>
            	</figure>
            </c:forEach>
        </div>
    </section>
    <!--end-->
    
    <!-- 尾部 -->
    <jsp:include page="footer.jsp"></jsp:include>
    
    <!-- /.modal -->
    <!--jQuery-->
    <script src="scripts/jquery.min.js" ></script>
    <script>$(function () { $("#h").addClass("hover"); })</script>
    <script src="scripts/bootstrap.min.js" ></script>
    <script>$(function () { $("[data-toggle='tooltip']").tooltip(); })</script>
    <script src="scripts/owl.carousel.min.js" ></script>
    <script src="scripts/owl.carousel.quote.js"></script>
</body>
</html>