<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
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
    <title>新闻_赛利浦</title>
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
                <h2>新闻中心</h2>
                <p>我们致力于打造一个优秀的建站资源共享学习平台</p>
            </div>
        </div>
    </section>

    <main class="main">
        <div class="container">
            <!--menu-->
            <div class="ny-menu text-center">
                <ul class="list-inline">

                    <c:forEach var="newsCategory" items="${newsCategoryList }">
                    	<c:choose>
                    		<c:when test="${cateId eq newsCategory.id }">
                    			<li><a class="btn-title" href="${pageContext.request.contextPath }/newsAction_news?cateId=${newsCategory.id}" style="background-color: #df3741; border: 1px solid #df3741; color: #fff; text-decoration: none">${newsCategory.cateName }</a></li>
                    		</c:when>
                    		<c:otherwise>
                    			<li><a class="btn-title" href="${pageContext.request.contextPath }/newsAction_news?cateId=${newsCategory.id}">${newsCategory.cateName }</a></li>
                    		</c:otherwise>
                    	</c:choose>
                    </c:forEach>

                </ul>
            </div>
            <!--content start-->
            <section class="content">
                <div class="row new-news">
                    <div class="new-news-box col-xs-12 col-sm-12 col-md-10 col-lg-10 col-lg-offset-1 col-md-offset-1">
                        <c:forEach var="news" items="${newsList }">
                        <div class="row">
                            <figure class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                                <a href="${pageContext.request.contextPath }/newsAction_newsDetails?id=${news.id}" ><img src="${pageContext.request.contextPath }/upload/${news.newsImg}" alt="${news.newsTitle}" width="262" height="188" /><span class="new-pic hidden-xs"></span></a>
                            </figure>
                            <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                                <h3><a href="${pageContext.request.contextPath }/newsAction_newsDetails?id=${news.id}" >${news.newsTitle}</a></h3>
                                <time class="visible-lg-block">${news.newsDate}</time>
                                ${fn:substring(news.newsContent, 0, 300) }
                                <p class="hidden-xs"><a class="btn-center l-m-none" href="${pageContext.request.contextPath }/newsAction_newsDetails?id=${news.id}">阅读全文</a></p>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="list-page">
                    <div class="dede_pages">
                        <ul class="pagelist">
                        	<!-- 分页 -->
                            <pg:pager url="${pageContext.request.contextPath }/newsAction_news" items="${pager.total }" maxPageItems="${pageSize }" export="currentPageNumber=pageNumber">  
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
    <!-- fenxiang modal -->
    <div class="modal fade" id="fenxiang" tabindex="-1" role="dialog" aria-labelledby="fenxiang">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title m-none">分享给好友</h4>
                </div>
                <div class="modal-body p-40 text-center">
                    <div class="bdsharebuttonbox" data-tag="HBD_FX">
                        <a class="bds_sqq" data-cmd="sqq" href="#"></a>
                        <a class="bds_weixin" data-cmd="weixin" href="#"></a>
                        <a class="bds_qzone" data-cmd="qzone" href="#"></a>
                        <a class="bds_tsina" data-cmd="tsina"></a>
                        <a class="bds_baidu" data-cmd="baidu"></a>
                        <a class="bds_tqq" data-cmd="tqq"></a>
                        <a class="bds_mshare" data-cmd="mshare"></a>
                        <a class="bds_more" data-cmd="more">更多</a>
                        <a class="bds_copy" data-cmd="copy"></a>
                        <a class="bds_count" data-cmd="count"></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
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