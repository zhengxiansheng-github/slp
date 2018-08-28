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
    <title>案例_赛利浦</title>
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

    <section style="background-image:url(images/banner-case.jpg)" class="banner text-center full_bg">
        <div class="banner-mask">
            <div class="container">
                <h2>案例产品</h2>
                <p>我们提供网站模板，网页模板等建站素材下载</p>
            </div>
        </div>
    </section>

    <main class="main">
        <div class="container">
            <!--menu-->
            <div class="ny-menu text-center">
                <ul class="list-inline">
					<!--  -->
                    <c:forEach var="projectCategory" items="${projectCategoryList }">
                    	<c:choose>
                    		<c:when test="${cateId eq projectCategory.id }">
                    			<li><a class="btn-title" href="${pageContext.request.contextPath }/projectAction_project?cateId=${projectCategory.id}" style="background-color: #df3741; border: 1px solid #df3741; color: #fff; text-decoration: none">${projectCategory.cateName }</a></li>
                    		</c:when>
                    		<c:otherwise>
                    			<li><a class="btn-title" href="${pageContext.request.contextPath }/projectAction_project?cateId=${projectCategory.id}">${projectCategory.cateName }</a></li>
                    		</c:otherwise>
                    	</c:choose>
                    </c:forEach>

                </ul>
            </div>
            <!--content start-->
            <section class="content">
                <div class="row case-box">
                  <c:forEach var="project" items="${projectList }">
                    <div class="col-xs-6 col-sm-6 col-md-4 col-lg-4">
                        <figure>
                            <a href="${pageContext.request.contextPath }/projectAction_projectDetails?id=${project.id}" ><img src="${pageContext.request.contextPath }/upload/${project.projectImg}" alt="${project.projectName}" width="360" height="258" /></a>
                            <figcaption class="pic-hover">
                                <h3><a href="${pageContext.request.contextPath }/projectAction_projectDetails?id=${project.id}"  >${project.projectName}</a></h3>
                                <ul class="list-inline">
                                    <li>Category /&nbsp;</li>
                                    <li><a href="${pageContext.request.contextPath }/projectAction_project?cateId=${project.projectCategory.id}" >${project.projectCategory.cateName }</a></li>
                                </ul>
                                <span class="visible-lg-block visible-md-block"></span>
                            </figcaption>
                        </figure>
                    </div>
                  </c:forEach>
                </div>
                <div class="list-page">
                    <div class="dede_pages">
                        <ul class="pagelist">
                            <li><a href="${pageContext.request.contextPath }/projectAction_project?cateId=${cateId}&currentPage=1">首页</a></li>
                            
                            <c:forEach var="index" begin="1" end="${totalPage }">
                            <li ${currentPage eq index ? "class='thisclass'" : "" }><a href="${pageContext.request.contextPath }/projectAction_project?cateId=${cateId}&currentPage=${index }">${index }</a></li>
                            </c:forEach>
                            
                            <li><a href="${pageContext.request.contextPath }/projectAction_project?cateId=${cateId}&currentPage=${currentPage ge totalPage ?totalPage :(currentPage+1) }">下一页</a></li>
                            
                            <li><a href="${pageContext.request.contextPath }/projectAction_project?cateId=${cateId}&currentPage=${totalPage}">末页</a></li>
                            
                            <li><span class="pageinfo">共 <strong>${totalPage}</strong>页<strong>${totalCount}</strong>条</span></li>

                        </ul>
                    </div><!-- /pages -->
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