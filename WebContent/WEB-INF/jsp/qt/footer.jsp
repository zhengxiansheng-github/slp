<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--Action start-->
    ﻿<section class="action text-center">
        <div class="container sx-jianju action-bg">
            ${infoList[4].content }
            <p>
                <a href="index.jsp"  class="btn-center">访问官网</a><a href="${pageContext.request.contextPath }/contact" class="btn-center">联系方式</a>
            </p>
        </div>
    </section>
    <!--end-->
    <!--footer start-->
    <footer class="text-center">
        <div class="container">
            <div class="row footer">
                <figure class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
                    <span class="footer-dh"></span>
                    <h3>${infoList[0].name }</h3>
                    ${infoList[0].content }
                </figure>
                <figure class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
                    <span class="footer-dz"></span>
                    <h3>${infoList[1].name }</h3>
                    ${infoList[1].content }
                </figure>
                <figure class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
                    <span class="footer-yx"></span>
                    <h3>${infoList[2].name }</h3>
                    ${infoList[2].content }
                </figure>
            </div>
            <ul class="footer-nav list-inline menu-kj">
                <li><a href="index.jsp">网站首页</a></li>
                <li><a href="${pageContext.request.contextPath }/intro">关于我们</a></li>
                <li><a href="${pageContext.request.contextPath }/servicesAction_services">服务中心</a></li>
                <li><a href="${pageContext.request.contextPath }/servicesAction_services#fuwu2">服务优势</a></li>
                <li><a href="${pageContext.request.contextPath }/servicesAction_services#fuwu5">服务流程</a></li>
                <li><a href="${pageContext.request.contextPath }/servicesAction_services#fuwu6">服务客户</a></li>
                <li><a href="${pageContext.request.contextPath }/projectAction_project">成功案例</a></li>
                <li><a href="${pageContext.request.contextPath }/newsAction_news">公司新闻</a></li>
                <li><a href="${pageContext.request.contextPath }/newsAction_news">产品动态</a></li>
                <li><a href="${pageContext.request.contextPath }/contact">联系</a></li>
                <li><a data-toggle="collapse" href="javascript:void(0)" data-target="#links" aria-expanded="false" aria-controls="links">友情链接</a></li>
            </ul>
            <div class="collapse" id="links">
                <div class="well">
                    友情链接：<a href="#" target='_blank'>织码</a>
                </div>
            </div>
        </div>
        <div class="copy">
            <div class="container">
                ${infoList[3].content }
            </div>
        </div>
    </footer>
    <!--end-->
    <!--kefu start-->
    <ul class="kefu">
        <li><a href="#" class="kefu-top" data-toggle="tooltip" data-placement="left" id="top" title="回页面顶部" rel="nofollow">回顶部</a></li>
        <li class="visible-xs-block"><a href="tel://400-8888-616" class="kefu-dh"  data-toggle="tooltip" data-placement="left" title="拔打电话" rel="nofollow">拔打电话</a></li>
        <li><a href="#" class="kefu-gt"  data-toggle="tooltip" data-placement="left" title="在线沟通" rel="nofollow">在线沟通</a></li>
        <li class="hidden-xs" data-toggle="modal" data-target="#weixin"><a href="javascript:void(0)" class="kefu-wx" data-toggle="tooltip" data-placement="left" title="微信平台" rel="nofollow">官方微信平台</a></li>
        <li data-toggle="modal" data-target="#fenxiang"><a href="javascript:void(0)" class="kefu-fx" data-toggle="tooltip" data-placement="left" title="分享给好友" rel="nofollow">分享</a></li>
    </ul>
    <!--end-->
    <!-- weixin modal -->
    <div class="modal fade" id="weixin" tabindex="-1" role="dialog" aria-labelledby="weixin">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title m-none">赛利浦官方微信</h4>
                </div>
                <div class="modal-body p-40 text-center">
                    <img src="${pageContext.request.contextPath }/upload/${infoList[5].infoImg}" alt="赛利浦"><p>使用微信扫一扫关注赛利浦</p>
                </div>
            </div>
        </div>
    </div>
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