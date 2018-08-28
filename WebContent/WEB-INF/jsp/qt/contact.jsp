<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta http-equiv="content-language" content="zh-CN">
    <meta http-equiv="Cache-Control" content="no-transform" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>联系我们_赛利浦</title>
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


    <section style="background-image:url(images/banner-contact.jpg)" class="banner text-center full_bg">
        <div class="banner-mask">
            <div class="container">
                <h2>联系我们</h2>
                <p>始终站在客户的角度主动服务，每一次都超越您的期待</p>
            </div>
        </div>
    </section>

    <main class="main">
        <div class="container">
            <!--menu-->
            <!--content start-->
            <section class="content">
                <h2 class="text-center b-m-50">
                    沟通无障碍，服务更省心
                </h2>
                <div class="row b-m-40">
                    <figure class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                        <div class="contact">
                            <span class="contact-dh hidden-xs"></span>
                            <h3>
                                致电赛利浦
                            </h3>
                            <p>
                                24小时服务热线（售前/售中/售后）<small>400-8888-888 | 020-88888888 | 186-8888-8888</small>
                            </p>
                        </div>
                    </figure>
                    <figure class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                        <div class="contact">
                            <span class="contact-dz hidden-xs"></span>
                            <h3>
                                亲临公司
                            </h3>
                            <p>
                                <a data-target="#baidumap" data-toggle="modal" href="javascript:void(0)">在地图上找到我们 →</a><small>四川省成都市高新区孵化园科技大厦18楼101号</small>
                            </p>
                        </div>
                    </figure>
                    <div class="clearfix visible-md-block"></div>
                    <figure class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                        <div class="contact">
                            <span class="contact-gt hidden-xs"></span>
                            <h3>
                                在线沟通
                            </h3>
                            <p>
                                周一至周六09:00 - 18:00<small> <a  href="#">QQ在线沟通</a></small>
                            </p>
                        </div>
                    </figure>
                    <figure class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                        <div class="contact">
                            <span class="contact-hz hidden-xs"></span>
                            <h3>
                                业务合作
                            </h3>
                            <p>
                                周一至周六09:00 - 18:00<small>业务合作QQ：272922238</small>
                            </p>
                        </div>
                    </figure>


                </div>
                <div aria-labelledby="baidumap" role="dialog" tabindex="-1" id="baidumap" class="modal fade bs-example-modal-lg">
                    <div role="document" class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button aria-label="Close" data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span></button>
                                <h4 class="modal-title m-none">
                                    在地图上找到我们
                                </h4>
                            </div>
                            <div class="modal-body p-40 text-center">
                                <div class="embed-responsive embed-responsive-4by3"></div>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
                <div class="list_page"></div>
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