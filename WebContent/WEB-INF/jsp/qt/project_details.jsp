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
    <title>案例详情_赛利浦</title>
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

    <section style="background-image:url(images/banner-news.jpg)" class="banner text-center full_bg">
        <div class="banner-mask">
            <div class="container">
                <h2>${project.projectCategory.cateName }</h2>
                <p><a href="index.jsp">创客</a> > <a href="${pageContext.request.contextPath }/projectAction_project" >案例产品</a> > <a href="${pageContext.request.contextPath }/projectAction_project">${project.projectCategory.cateName }</a> >  查看内容</p>
            </div>
        </div>
    </section>
    <main class="main">
        <div class="container">
            <!--menu-->
            <!--content start-->
            <section class="content neirong">
                <div class="row">
                    <article class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-lg-offset-1 col-md-offset-1">
                        <header class="text-center">
                            <h2 class="title">${project.projectName}</h2>
                            <div class="info">
                                <small class="date">时间 ${project.projectDate}</small><small class="hits">
                                    点击 <span id="hits">${project.count }</span>
                                </small><small class="tags">栏目 ：${project.projectCategory.cateName }</small>
                            </div>
                        </header>
                       		<!-- 内容 -->
                       		${project.projectContent }
                    </article>
                </div>
            </section>
        </div>
    </main>
    
    <!-- 底部 -->
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