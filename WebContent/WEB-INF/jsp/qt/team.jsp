<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta http-equiv="content-language" content="zh-CN">
    <meta http-equiv="Cache-Control" content="no-transform" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>团队_赛利浦</title>
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

    <section style="background-image:url(images/banner-team.jpg)" class="banner text-center full_bg">
        <div class="banner-mask">
            <div class="container">
                <h2>团队人员</h2>
                <p>我们致力于打造一个优秀的建站资源共享学习平台</p>
            </div>
        </div>
    </section>

    <main class="main">
        <div class="container">
            <!--menu-->
            <!--content start-->
            <section class="content">
                <div class="row team-box text-center">
                    <c:forEach var="team" items="${teamList }">
                    <div class="col-xs-6 col-sm-3 col-md-3 col-lg-3">
                        <figure>
                            <a href="${pageContext.request.contextPath }/teamAction_teamMember?id=${team.id}" ><img src="${pageContext.request.contextPath }/upload/${team.photo}" alt="Eeala" width="260" height="260" /><span class="new-pic"></span></a>
                            <figcaption class="pic-hover">
                                <h3><a href="${pageContext.request.contextPath }/teamAction_teamMember?id=${team.id}" >${team.name}</a></h3>
                                <span></span>
                                <p>${team.position}</p>
                            </figcaption>
                        </figure>
                    </div>
                    </c:forEach>
                    
                </div>
                <div class="list-page">
                    <div class="dede_pages">
                        <ul class="pagelist">
                            
                            <pg:pager url="${pageContext.request.contextPath }/teamAction_team" items="${totalCount }" maxPageItems="${pageSize }" export="currentPageNumber=pageNumber">  
    							<pg:first>  
        							<a href="${pageUrl }">首页</a>  
    							</pg:first>  
    							<pg:prev>  
        							<a href="${pageUrl }">上一页</a>  
    							</pg:prev>  
    							<pg:pages>  
        							<c:choose>  
            							<c:when test="${currentPageNumber eq pageNumber}">  
                							<font color="red">${pageNumber }</font>  
            							</c:when>  
            							<c:otherwise>  
                							<a href="${pageUrl }">${pageNumber }</a>  
            							</c:otherwise>  
        							</c:choose>  
    							</pg:pages>  
    							<pg:next>  
        							<a href="${pageUrl }">下一页</a>  
    							</pg:next>  
    							<pg:last>  
        							<a href="${pageUrl }">尾页</a>  
    							</pg:last>  
							</pg:pager>
                            
                        </ul>
                    </div><!-- /pages -->
                </div>
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