<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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


    <section style="background-image:url(images/banner-service.jpg)" class="banner text-center full_bg">
        <div class="banner-mask">
            <div class="container">
                <h2>打造完美空间</h2>
                <p>更贴心的设计，更放心的质量，更省心的服务</p>
            </div>
        </div>
    </section>

    <main class="main">
        <div id="fuwu" class="container">
            <!--menu-->
            <div class="ny-menu text-center">
                <ul class="list-inline">
                	
                    <c:forEach var="services" items="${servicesList }"> 
                    	<li><a class="btn-title" href="#fuwu${services.id }">${services.serviceName}</a></li>
                    </c:forEach>
                    
                </ul>
            </div>
            <!--content start-->
            <section class="content">
                <div class="row hbfw">
                    <div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-lg-offset-1 col-md-offset-1">
                        <div id="fuwu${servicesList[0].id }" class="row">
                            <div class="col-xs-12 col-sm-5 col-md-5 col-lg-5 col-lg-push-7">
                                <img alt="${servicesList[0].serviceTitle }" title="${servicesList[0].serviceTitle }" src="${pageContext.request.contextPath }/upload/${servicesList[0].serviceImg }">
                            </div>
                            <div class="col-xs-12 col-sm-7 col-md-7 col-lg-7 col-lg-pull-5">
                                <h2>${servicesList[0].serviceTitle }</h2>
                                ${servicesList[0].serviceContent }
                                <!-- <p>
                                    <a  class="btn-center l-m-none" href="#">了解更多</a>
                                </p> -->
                            </div>
                        </div>
                        <div class="text-center">
                            <div id="fuwu${servicesList[1].id }">
                                <h2 class="b-m-60">${servicesList[1].serviceTitle }</h2>
                                <p class="b-m-40">
                                    <img alt="${servicesList[1].serviceTitle }" title="${servicesList[1].serviceTitle }" src="${pageContext.request.contextPath }/upload/${servicesList[1].serviceImg }">
                                </p>
                                ${servicesList[1].serviceContent }
                                <!-- <p>
                                    <a class="btn-center" href="#">了解更多</a>
                                </p> -->
                            </div>
                        </div>
                        <div class="text-center">
                            <c:forEach var="service" items="${servicesList }" begin="2" end="${fn:length(servicesList) }">
                            	<div id="fuwu${service.id }">
                                <h2 class="b-m-60">${service.serviceTitle }</h2>
                                <p>
                                    <img alt="${service.serviceTitle }" title="${service.serviceTitle }" src="${pageContext.request.contextPath }/upload/${service.serviceImg }" />
                                </p>
                                <!-- <p>
                                    <a class="btn-center" href="#">了解更多</a>
                                </p> -->
                            	</div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="list_page"></div>
            </section>
        </div>
    </main>
    
    ﻿<!-- 底部 -->
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