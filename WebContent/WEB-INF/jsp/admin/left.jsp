<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 页面导航 -->
            <div class="page-sidebar">
                <ul class="x-navigation">
                    <li class="xn-logo">
                        <a href="index.html"></a>
                        <a href="#" class="x-navigation-control"></a>
                    </li>
                    <li class="xn-profile">
                        <a href="#" class="profile-mini">
                            <img src="assets/images/users/avatar.jpg" alt="John Doe" />
                        </a>
                        <div class="profile">
                            <div class="profile-image">
                                <img src="assets/images/users/avatar.jpg" alt="John Doe" />
                            </div>
                            <div class="profile-data">
                                <div class="profile-data-name">${admin.adminName }</div>
                                <!--<div class="profile-data-title">Web Developer/Designer</div>-->
                            </div>
                        </div>
                    </li>
                    <li class="active">
                        <a href="${pageContext.request.contextPath }/adminAction_main"><span class="fa fa-desktop"></span> <span class="xn-text">控制台</span></a>
                    </li>
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-cogs"></span> <span class="xn-text">站点管理</span></a>
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/bannerAction_list"><span class="fa fa-money"></span> Banner管理</a></li>
                            <li><a href="${pageContext.request.contextPath}/adminAction_list"><span class="fa fa-user"></span> 管理员管理</a></li>
                            <li><a href="${pageContext.request.contextPath}/siteInfoAction_list"><span class="fa fa-cogs"></span> 站点信息管理</a></li>
                            <li><a href="${pageContext.request.contextPath}/linksAction_list"><span class="fa fa-anchor"></span> 友情链接管理</a></li>
                        </ul>
                    </li>
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-users"></span> <span class="xn-text">团队管理</span></a>
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/teamAction_list"><span class="fa fa-users"></span> 团队管理</a></li>
                        </ul>
                    </li>
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-globe"></span> <span class="xn-text">服务管理</span></a>
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/servicesAction_list"><span class="fa fa-globe"></span> 服务管理</a></li>
                            <li><a href="${pageContext.request.contextPath}/servicesCategoryAction_list"><span class="fa fa-th-list"></span> 服务分类管理</a></li>
                        </ul>
                    </li>
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-files-o"></span> <span class="xn-text">资讯管理</span></a>
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/newsAction_list"><span class="fa fa-files-o"></span> 资讯管理</a></li>
                            <li><a href="${pageContext.request.contextPath}/newsCategoryAction_list"><span class="fa fa-th-list"></span> 资讯分类管理</a></li>
                        </ul>
                    </li>
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-folder-o"></span> <span class="xn-text">案例管理</span></a>
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/projectAction_list"><span class="fa fa-folder-o"></span> 案例管理</a></li>
                            <li><a href="${pageContext.request.contextPath}/projectCategoryAction_list"><span class="fa fa-th-list"></span> 案例分类管理</a></li>
                        </ul>
                    </li>
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-laptop"></span> <span class="xn-text">账户管理</span></a>
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/adminAction_toUpdate?admin.id=${admin.id}"><span class="fa fa-lock"></span> 修改密码</a></li>
                            <li><a href="#" onclick="Exit()" ><span class="fa fa-sign-out"></span> 退出系统</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- END 页面导航 -->
            <div class="modal fade" id="deleteForm">
        <div class="modal-dialog">
            <div class="modal-content message_align">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                    <h4 class="modal-title">提示</h4>
                </div>
                <div class="modal-body">
                    <p>您确认要退出登录吗？</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default"
                            data-dismiss="modal">
                        取消
                    </button>
                    <button type="button" class="btn btn-primary"
                            id="deleteComfirm">
                        确认
                    </button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
    </div>
    <script>
    function Exit() {
            $("#deleteForm").modal({
                backdrop: 'static',
                keyboard: false
            });

            $("#deleteComfirm").unbind("click").click(function () {
                //删除数据
                //alert(id);
                //重新加载页面数据
                $("#deleteForm").modal('hide');
                window.location.href = "${pageContext.request.contextPath}/adminLogin";
            })
            return false;
        }
        </script>