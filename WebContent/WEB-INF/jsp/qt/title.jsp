<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--head start-->
    <header class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <!--mobile nav start-->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!--logo start-->
                <h1 class="logo"><a class="navbar-brand" href="index.htm">赛利浦</a><small class="pull-left visible-lg-block visible-xs-block">建站资源共享学习平台</small></h1>
            </div><!--end-->
            <!--nav start-->
            <nav class="collapse navbar-right navbar-collapse" role="navigation">
                <ul class="nav navbar-nav pull-left" id="nav">
                    <li><a href="${pageContext.request.contextPath }/indexAction_index">首页</a></li>
                    <li>
                        <a href="${pageContext.request.contextPath }/servicesAction_services">服务</a>
                        <ul class="list-unstyled">
                        	<c:forEach var="services" items="${servicesList }">
                            <li><a href="#fuwu${services.id }">${services.serviceName }</a></li>
                        	</c:forEach>
                        </ul>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/projectAction_project">案例</a>
                        <ul class="list-unstyled">
                        	<c:forEach var="projectCategory" items="${projectCategoryList }">
                            <li><a href="${pageContext.request.contextPath }/projectAction_project?cateId=${projectCategory.id}">${projectCategory.cateName }</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/teamAction_team">团队</a>
                        <ul class="list-unstyled"></ul>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/newsAction_news">资讯</a>
                        <ul class="list-unstyled">
                        	<c:forEach var="newsCategory" items="${newsCategoryList }">
                            <li><a href="${pageContext.request.contextPath }/newsAction_news?cateId=${newsCategory.id}">${newsCategory.cateName }</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                    <li><a href="${pageContext.request.contextPath }/intro">简介</a></li>
                    <li><a href="${pageContext.request.contextPath }/contact">联系</a></li>
                </ul>
                <ul class=" list-unstyled nav-kj pull-right visible-md-block visible-lg-block">
                    <li>
                        <a href="javascript:void(0)" class="fuwu">赛利浦客服</a>
                        <div class="fuwu-nr">
                            <h4>24小时在线服务</h4>
                            <p>
                                不论您遇到任何问题，装修服务或售后支持等<br />
                                均可随时致电与我们沟通，我们会迅速为您解决问题
                            </p>
                            <hr class="small white" />
                            <h4>400-8888-616</h4>
                            <p>020-8888888 | 181-8888-8888</p>
                            <hr class="small white" />
                            <h4>在线咨询</h4>
                            <p><a class="sq" href="#" >联系我们</a><a class="qq" href="javascript:if(confirm('http://wpa.qq.com/msgrd?v=3&uin=88889999&site=qq&menu=yes'))window.location='http://wpa.qq.com/msgrd?v=3&uin=88889999&site=qq&menu=yes'" >QQ咨询</a></p>
                        </div>
                    </li>
                </ul>
            </nav>
        </div>
        <!--end-->
    </header>
    <!--end-->