<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>        
        <!-- META SECTION -->
        <title>Atlant - Responsive Bootstrap Admin Template</title>            
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        
        <link rel="icon" href="favicon.ico" type="image/x-icon" />
        <!-- END META SECTION -->
        
        <!-- CSS INCLUDE -->        
        <link rel="stylesheet" type="text/css" id="theme" href="css/theme-default.css"/>
        <!-- EOF CSS INCLUDE -->                                    
    </head>
    <body>
        <!-- 页面容器 -->
        <div class="page-container">

            <!-- 页面导航 -->
            <jsp:include page="left.jsp"></jsp:include>
            <!-- END 页面导航 -->
            
            <!-- 页面内容 -->
            <div class="page-content">

                <!-- START X-NAVIGATION VERTICAL -->
                <ul class="x-navigation x-navigation-horizontal x-navigation-panel">
                    <!-- TOGGLE NAVIGATION -->
                    <li class="xn-icon-button">
                        <a href="#" class="x-navigation-minimize"><span class="fa fa-dedent"></span></a>
                    </li>
                    <!-- END TOGGLE NAVIGATION -->
                    <!-- 查询框 -->
                    <!--<li class="xn-search">
                        <form role="form">
                            <input type="text" name="search" placeholder="Search..."/>
                        </form>
                    </li>-->
                    <!-- END 查询框 -->
                    <!-- 登出 -->
                    <li class="xn-icon-button pull-right">
                        <a href="#" class="mb-control" data-box="#mb-signout"><span class="fa fa-sign-out"></span></a>
                    </li>
                    <!-- END 登出 -->


                </ul>
                <!-- END X-NAVIGATION VERTICAL -->
                <!-- 面包屑 -->
                <ul class="breadcrumb">
                    <li><a href="/index.html">首页</a></li>
                    <li class="active">控制台</li>
                </ul>
                <!-- END 面包屑 -->
                <!-- 页面内容 -->
                <div class="page-content-wrap">
                    <!-- 插件 -->
                    <div class="row">
                        <div class="col-md-4">

                            <!-- START WIDGET CLOCK -->
                            <div class="widget widget-danger widget-padding-sm">
                                <div class="widget-big-int plugin-clock">00:00</div>
                                <div class="widget-subtitle plugin-date">Loading...</div>
                                <div class="widget-controls">
                                    <a href="#" class="widget-control-right widget-remove" data-toggle="tooltip" data-placement="left" title="Remove Widget"><span class="fa fa-times"></span></a>
                                </div>
                                <div class="widget-buttons widget-c3">
                                    <div class="col">
                                        <a href="#"><span class="fa fa-clock-o"></span></a>
                                    </div>
                                    <div class="col">
                                        <a href="#"><span class="fa fa-bell"></span></a>
                                    </div>
                                    <div class="col">
                                        <a href="#"><span class="fa fa-calendar"></span></a>
                                    </div>
                                </div>
                            </div>
                            <!-- END WIDGET CLOCK -->
                        </div>
                        <div class="col-md-4">
                            <!-- START WIDGET SLIDER -->
                            <!-- <div class="widget widget-success widget-carousel">
                                <div class="owl-carousel" id="owl-example">
                                    <div>
                                        <div class="widget-title">今天访客数</div>
                                        <div class="widget-subtitle">27/08/2014 15:23</div>
                                        <div class="widget-int">3,548</div>
                                    </div>
                                    <div>
                                        <div class="widget-title">老客户</div>
                                        <div class="widget-subtitle">Visitors</div>
                                        <div class="widget-int">1,695</div>
                                    </div>
                                    <div>
                                        <div class="widget-title">新客户</div>
                                        <div class="widget-subtitle">Visitors</div>
                                        <div class="widget-int">1,977</div>
                                    </div>
                                </div>
                                <div class="widget-controls">
                                    <a href="#" class="widget-control-right widget-remove" data-toggle="tooltip" data-placement="top" title="Remove Widget"><span class="fa fa-times"></span></a>
                                </div>
                            </div> -->
                            <div class="widget widget-primary widget-item-icon" onclick="location.href='${pageContext.request.contextPath}/siteInfoAction_list';">
                                <div class="widget-item-left">
                                    <span class="fa fa-files-o"></span>
                                </div>
                                <div class="widget-data">
                                    <div class="widget-int num-count">${siteInfoTotalCount }</div>
                                    <div class="widget-title">站点</div>
                                    <div class="widget-subtitle">我们致力于打造一个优秀的建站资源共享学习资源</div>
                                </div>
                                <div class="widget-controls">
                                    <a href="#" class="widget-control-right widget-remove" data-toggle="tooltip" data-placement="top" title="Remove Widget"><span class="fa fa-times"></span></a>
                                </div>
                            </div>
                            <!-- END WIDGET SLIDER -->

                        </div>

                    </div>
                    <div class="row">
                        <div class="col-md-4">

                            <!-- START WIDGET MESSAGES -->
                            <div class="widget widget-primary widget-item-icon" onclick="location.href='${pageContext.request.contextPath}/newsAction_list';">
                                <div class="widget-item-left">
                                    <span class="fa fa-files-o"></span>
                                </div>
                                <div class="widget-data">
                                    <div class="widget-int num-count">${newsTotalCount }</div>
                                    <div class="widget-title">资讯</div>
                                    <div class="widget-subtitle">公司行业产品资讯</div>
                                </div>
                                <div class="widget-controls">
                                    <a href="#" class="widget-control-right widget-remove" data-toggle="tooltip" data-placement="top" title="Remove Widget"><span class="fa fa-times"></span></a>
                                </div>
                            </div>
                            <!-- END WIDGET MESSAGES -->

                        </div>
                        <div class="col-md-4">
                            <!-- START WIDGET REGISTRED -->
                            <div class="widget widget-default widget-item-icon" onclick="location.href='${pageContext.request.contextPath}/projectAction_list';">
                                <div class="widget-item-left">
                                    <span class="fa fa-folder-o"></span>
                                </div>
                                <div class="widget-data">
                                    <div class="widget-int num-count">${projectTotalCount }</div>
                                    <div class="widget-title">案例</div>
                                    <div class="widget-subtitle">手机网站平面案例展示</div>
                                </div>
                                <div class="widget-controls">
                                    <a href="#" class="widget-control-right widget-remove" data-toggle="tooltip" data-placement="top" title="Remove Widget"><span class="fa fa-times"></span></a>
                                </div>
                            </div>
                            <!-- END WIDGET REGISTRED -->
                        </div>
                        <div class="col-md-4">
                            <!-- START WIDGET REGISTRED -->
                            <div class="widget widget-info widget-item-icon" onclick="location.href='${pageContext.request.contextPath}/teamAction_list';">
                                <div class="widget-item-left">
                                    <span class="fa fa-folder-o"></span>
                                </div>
                                <div class="widget-data">
                                    <div class="widget-int num-count">${teamTotalCount }</div>
                                    <div class="widget-title">团队成员</div>
                                    <div class="widget-subtitle">我们团队成员</div>
                                </div>
                                <div class="widget-controls">
                                    <a href="#" class="widget-control-right widget-remove" data-toggle="tooltip" data-placement="top" title="Remove Widget"><span class="fa fa-times"></span></a>
                                </div>
                            </div>
                            <!-- END WIDGET REGISTRED -->
                        </div>
                    </div>
                </div>
                <!-- END 插件-->


                <div class="row">
                    <div class="col-md-4">

                        <!-- START SALES & EVENTS BLOCK -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="panel-title-box">
                                    <h3>Sales & Event</h3>
                                    <span>Event "Purchase Button"</span>
                                </div>
                                <ul class="panel-controls" style="margin-top: 2px;">
                                    <li><a href="#" class="panel-fullscreen"><span class="fa fa-expand"></span></a></li>
                                    <li><a href="#" class="panel-refresh"><span class="fa fa-refresh"></span></a></li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="fa fa-cog"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="#" class="panel-collapse"><span class="fa fa-angle-down"></span> Collapse</a></li>
                                            <li><a href="#" class="panel-remove"><span class="fa fa-times"></span> Remove</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                            <div class="panel-body padding-0">
                                <div class="chart-holder" id="dashboard-line-1" style="height: 200px;"></div>
                            </div>
                        </div>
                        <!-- END SALES & EVENTS BLOCK -->

                    </div>
                    <div class="col-md-4">

                        <!-- START USERS ACTIVITY BLOCK -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="panel-title-box">
                                    <h3>Users Activity</h3>
                                    <span>Users vs returning</span>
                                </div>
                                <ul class="panel-controls" style="margin-top: 2px;">
                                    <li><a href="#" class="panel-fullscreen"><span class="fa fa-expand"></span></a></li>
                                    <li><a href="#" class="panel-refresh"><span class="fa fa-refresh"></span></a></li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="fa fa-cog"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="#" class="panel-collapse"><span class="fa fa-angle-down"></span> Collapse</a></li>
                                            <li><a href="#" class="panel-remove"><span class="fa fa-times"></span> Remove</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                            <div class="panel-body padding-0">
                                <div class="chart-holder" id="dashboard-bar-1" style="height: 200px;"></div>
                            </div>
                        </div>
                        <!-- END USERS ACTIVITY BLOCK -->

                    </div>
                    <div class="col-md-4">

                        <!-- START VISITORS BLOCK -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="panel-title-box">
                                    <h3>Visitors</h3>
                                    <span>Visitors (last month)</span>
                                </div>
                                <ul class="panel-controls" style="margin-top: 2px;">
                                    <li><a href="#" class="panel-fullscreen"><span class="fa fa-expand"></span></a></li>
                                    <li><a href="#" class="panel-refresh"><span class="fa fa-refresh"></span></a></li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="fa fa-cog"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="#" class="panel-collapse"><span class="fa fa-angle-down"></span> Collapse</a></li>
                                            <li><a href="#" class="panel-remove"><span class="fa fa-times"></span> Remove</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                            <div class="panel-body padding-0">
                                <div class="chart-holder" id="dashboard-donut-1" style="height: 200px;"></div>
                            </div>
                        </div>
                        <!-- END VISITORS BLOCK -->

                    </div>
                </div>

                <!-- START DASHBOARD CHART -->
                <div class="block-full-width">
                    <div id="dashboard-chart" style="height: 250px; width: 100%; float: left;"></div>
                    <div class="chart-legend">
                        <div id="dashboard-legend"></div>
                    </div>
                </div>
                <!-- END DASHBOARD CHART -->

            </div>
            <!-- END 页面内容-->
        </div>
        <!-- END 页面容器 -->
        <!-- MESSAGE BOX-->
        <div class="message-box animated fadeIn" data-sound="alert" id="mb-signout">
            <div class="mb-container">
                <div class="mb-middle">
                    <div class="mb-title"><span class="fa fa-sign-out"></span> 登 <strong>出</strong> ?</div>
                    <div class="mb-content">
                        <p>你确定要登出系统吗?</p>
                        <p>点击取消按钮继续工作. 点击确定登出当前用户.</p>
                    </div>
                    <div class="mb-footer">
                        <div class="pull-right">
                            <a href="${pageContext.request.contextPath}/adminLogin" class="btn btn-success btn-lg">确定</a>
                            <button class="btn btn-default btn-lg mb-control-close">取消</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END MESSAGE BOX-->
        <!-- 脚本 -->
        <jsp:include page="common_footer.jsp"></jsp:include>
        <!-- END 模板 -->
        <!-- END 脚本 -->
    </body>
</html>