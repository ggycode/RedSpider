<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'header.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  		<div class="navbar-header">
            <a href="" class="navbar-brand"><b>RedSpider</b> Cloud Service</a>
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
              <i class="fa fa-bars"></i>
            </button>
          </div>

          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="home.do">首页 <span class="sr-only">(current)</span></a></li>
              <%--<li><a href="#">Link</a></li>--%>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">资源申请 <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="product/skipto/order/page?resType=ecs">云主机</a></li>
                  <li><a href="#">关系型数据库</a></li>
                </ul>
              </li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">资源管理 <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="#">控制中心概况</a></li>
                  <li><a href="#">云主机管理</a></li>
                  <li><a href="#">开放存储管理</a></li>
                  <li><a href="#">分布式数据库管理</a></li>
                  <li><a href="#">关系型数据库管理</a></li>
                  <li><a href="#">负载均衡管理</a></li>
                  <li><a href="#">资源利用率概况</a></li>
                </ul>
              </li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">管理中心 <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="#">客户控制中心概况</a></li>
                  <li><a href="user/findUser?pageSize=10&pageNum=1">用户管理</a></li>
                  <li><a href="#">消息管理</a></li>
                  <li><a href="#">监控报警</a></li>
                </ul>
              </li>
            </ul>
          </div><!-- /.navbar-collapse -->
          <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
              <ul class="nav navbar-nav">
                <!-- Messages: style can be found in dropdown.less-->
                <li class="dropdown messages-menu">
                  <!-- Menu toggle button -->
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="fa fa-envelope-o"></i>
                    <span class="label label-success">4</span>
                  </a>
                  <ul class="dropdown-menu">
                    <li class="header">您有 4 条未读消息</li>
                    <li>
                      <!-- inner menu: contains the messages -->
                      <ul class="menu">
                        <li><!-- start message -->
                          <a href="#">
                            <div class="pull-left">
                              <!-- User Image -->
                              <img src="adminLte/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                            </div>
                            <!-- Message title and timestamp -->
                            <h4>
                              	团队支持
                              <small><i class="fa fa-clock-o"></i> 5 分钟</small>
                            </h4>
                            <!-- The message -->
                            <p>Why not buy a new awesome theme?</p>
                          </a>
                        </li><!-- end message -->
                      </ul><!-- /.menu -->
                    </li>
                    <li class="footer"><a href="#">查看所有的消息</a></li>
                  </ul>
                </li><!-- /.messages-menu -->

                <!-- Notifications Menu -->
                <li class="dropdown notifications-menu">
                  <!-- Menu toggle button -->
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="fa fa-bell-o"></i>
                    <span class="label label-warning">10</span>
                  </a>
                  <ul class="dropdown-menu">
                    <li class="header">您有 10 条待查看通知</li>
                    <li>
                      <!-- Inner Menu: contains the notifications -->
                      <ul class="menu">
                        <li><!-- start notification -->
                          <a href="#">
                            <i class="fa fa-users text-aqua"></i> 5 new members joined today
                          </a>
                        </li><!-- end notification -->
                      </ul>
                    </li>
                    <li class="footer"><a href="#">View all</a></li>
                  </ul>
                </li>
                <!-- Tasks Menu -->
                <li class="dropdown tasks-menu">
                  <!-- Menu Toggle Button -->
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="fa fa-flag-o"></i>
                    <span class="label label-danger">9</span>
                  </a>
                  <ul class="dropdown-menu">
                    <li class="header">您有 9 个待执行任务</li>
                    <li>
                      <!-- Inner menu: contains the tasks -->
                      <ul class="menu">
                        <li><!-- Task item -->
                          <a href="#">
                            <!-- Task title and progress text -->
                            <h3>
                              Design some buttons
                              <small class="pull-right">20%</small>
                            </h3>
                            <!-- The progress bar -->
                            <div class="progress xs">
                              <!-- Change the css width attribute to simulate progress -->
                              <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                <span class="sr-only">20% Complete</span>
                              </div>
                            </div>
                          </a>
                        </li><!-- end task item -->
                      </ul>
                    </li>
                    <li class="footer">
                      <a href="#">View all tasks</a>
                    </li>
                  </ul>
                </li>
                <!-- User Account Menu -->
                <li class="dropdown user user-menu">
                  <!-- Menu Toggle Button -->
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <!-- The user image in the navbar-->
                    <img src="adminLte/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                    <!-- hidden-xs hides the username on small devices so only the image appears. -->
                    <span class="hidden-xs"><sec:authentication property="principal.username" /></span>
                  </a>
                  <ul class="dropdown-menu">
                    <!-- The user image in the menu -->
                    <li class="user-header">
                      <img src="adminLte/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                      <p>
                        <sec:authentication property="principal.username" /> - Web Developer
                        <%--<small>Member since <sec:authentication property="principal.created" /></small>
                      --%></p>
                    </li>
                    <!-- Menu Body -->
                    <li class="user-body">
                      <div class="col-xs-4 text-center">
                        <a href="#">Followers</a>
                      </div>
                      <div class="col-xs-4 text-center">
                        <a href="#">Sales</a>
                      </div>
                      <div class="col-xs-4 text-center">
                        <a href="#">Friends</a>
                      </div>
                    </li>
                    <!-- Menu Footer-->
                    <li class="user-footer">
                      <div class="pull-left">
                        <%--<a href="javascript:detailUser('<sec:authentication property="principal.uuid" />')" class="btn btn-default btn-flat">Profile</a>
                      --%></div>
                      <div class="pull-right">
                        <a href="/RedSpider/j_spring_security_logout" class="btn btn-default btn-flat">退 出</a>
                      </div>
                    </li>
                  </ul>
                </li>
              </ul>
            </div><!-- /.navbar-custom-menu -->
          <script type="text/javascript">
          	function findUsers(){
          		$.ajax({
    				type: 'GET',
    	            url: "user/findUser?pageSize=10&pageNum=1",
    	            dataType: "text",
    	            contentType:"application/json",
    	            async: false,
    	            success: function(data) {
    	            },
    	            error: function(XMLHttpResponse) {
    	           	 	alert(XMLHttpResponse);
    	            }
    	        });
          	}
          </script>    
  </body>
</html>
