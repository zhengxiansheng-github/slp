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
    <link rel="stylesheet" type="text/css" id="theme" href="${pageContext.request.contextPath}/css/theme-default.css" />
    <!-- EOF CSS INCLUDE -->
</head>
<body>
    <!-- 页面容器 -->
    <div class="page-container">

        <!-- 页面导航 -->
      	<jsp:include page="../left.jsp"></jsp:include>
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
                <li class="active">管理员信息添加</li>
            </ul>
            <!-- END 面包屑 -->
            <!-- 页面内容 -->
            <div class="page-content-wrap">
                <!-- 插件 -->
                <div class="row">
                    <div class="col-md-12">

                        <form class="form-horizontal" id="myfrom" action="${pageContext.request.contextPath}/adminAction_add" onsubmit="return checkdata()">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><strong>添加管理员信息</strong> </h3>
                                    <ul class="panel-controls">
                                        <li><a href="#" class="panel-remove"><span class="fa fa-times"></span></a></li>
                                    </ul>
                                </div>
                                <div class="panel-body">
                                </div>
                                <div class="panel-body form-group-separated">

                                    <div class="form-group">
                                        <label class="col-md-2 col-xs-12 control-label">管理员名称</label>
                                        <div class="col-md-8 col-xs-12">
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                <input type="text" class="form-control" id="adminName" name="admin.adminName"/>
                                            </div>
                                            <span class="help-block" style="display: none;color: red" id="adminName_lable">管理员名称不能为空，并且长度不能小于6位！</span>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-2 col-xs-12 control-label">管理员密码</label>
                                        <div class="col-md-8 col-xs-12">
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-unlock-alt"></span></span>
                                                <input type="password" class="form-control" id="pwd" name="admin.password"/>
                                            </div>
                                            <span class="help-block" style="display: none;color: red" id="pwd_lable">登陆密码不能为空，并且长度不能小于6位！</span>
                                        </div>
                                    </div>

                              
                                    <div class="form-group">
                                        <label class="col-md-2 col-xs-12 control-label">确认密码</label>
                                        <div class="col-md-8 col-xs-12">
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-unlock-alt"></span></span>
                                                <input type="password" class="form-control" id="pwd2" name="repassword" />
                                            </div>
                                            <span class="help-block" style="display: none;color: red" id="pwd2_lable">两次密码不一致,请重新输入！</span>
                                        </div>
                                    </div>

                                </div>
                                <div class="panel-footer">
                                     <button class="btn btn-primary pull-right" type="submit" >提交</button>
                                     <a class="btn btn-default" href="javascript:clearFrom()">清空</a>
                                </div>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
            <!-- END 插件-->
        </div>
        <!-- END 页面内容-->
    </div>
    <!-- END 页面容器 -->
    <!-- MESSAGE BOX-->
    <!-- 退出系统 -->
    <jsp:include page="../logOut.jsp"></jsp:include>
    <!-- END MESSAGE BOX-->
	<jsp:include page="../common_form_footer.jsp"></jsp:include>

    <script>
        $(document).ready(function () {
            $('#summernote').summernote({
                height: 400
            });

            $("#submit").click(function (e) {
                var markupStr = $('#summernote');
                $("#preview").html(markupStr.code(undefined));
                e.preventDefault();
            })
        });
        //校验添加的数据
        function checkdata(){
       		var name = $("#adminName").val();
       		if(name.length<6||name==""){
       			$("#adminName_lable").show();
       			return false;
       		}
       		var pwd = $("#pwd").val();
       		if(pwd.length<6||pwd==""){
       			$("#pwd_lable").show();
       			return false;
       		}
       		var pwd2 = $("#pwd2").val();
       		if(pwd!=pwd2){
       			$("#pwd2_lable").show();
       			return false;
       		}

        }
        //清空表单
        function clearFrom(){
        	$("#adminName").val("");
        	$("#pwd").val("");
        	$("#pwd2").val("");
        	$("#adminName_lable").hide();
        	$("#pwd_lable").hide();
        	$("#pwd2_lable").hide();
        }
        
    </script>
</body>
</html>



