<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    <%--<div class="page-content-wrapper">
		<div id="userContent" class="page-content" style="min-height:702px">
			<div id="userInfo_container" class="container-fluid">
				<div class="portlet light">
					--%>
			<!-- Content Wrapper. Contains page content -->
		    <div class="content-wrapper">
		        <!-- Content Header (Page header) -->
		        <section class="content-header">
		          <h1>
		            	用户管理
		            <small>重置密码页</small>
		          </h1>
		          <ol class="breadcrumb">
		              <li><a href="#"><i class="fa fa-dashboard"></i> 管理中心</a></li>
		              <li><a href="user/findUser?pageSize=10&pageNum=1">用户管理</a></li>
          			  <li class="active">重置密码</li>
		          </ol>
		        </section>
				<section class="content">
			       <div class="row">
			         <div class="col-md-12">
			           <div class="box box-primary">
							<div class="profile-sidebar">
								<div class="portlet light profile-sidebar-portlet">
									<div class="profile-userpic">
										<img src="adminLte/dist/img/user2-160x160.jpg" id="userPhoto" class="img-responsive" alt="User Image">
									</div>
									<div class="profile-usertitle">
										<div class="profile-usertitle-name">${user.userName }</div>
									</div>
								</div>
							</div>
							<div class="profile-content">
								<div class="row">
									<div class="col-md-12" >
										<div class="portlet light">
											<div class="portlet-title ">
												<div class="caption">
													<i class="iconfont icon-yonghuguanli01 font-blue-haze"></i>
													<span class="caption-subject font-blue-haze bold uppercase">账户信息</span>
												</div>
												<div class="actions">
													<div class="btn-group btn-group-devided" data-toggle="buttons">
														<button class="btn blue mr-5" onclick="window.location.href='user/reload/update?id=${user.uuid }'">
															<i class="fa fa-edit"></i>
															修改
														</button>
														<button class="btn blue mr-5" onclick="window.location.href='user/jump/page/modifyPassword?id=${user.uuid }'">
															<i class="fa fa-key"></i>
															重置密码
														</button>
													</div>
												</div>
											</div>
											<div class="portlet-body form">
												<form class="form-horizontal">
													<div class="form-body">
														<h5 class="form-section">个人信息</h5>
														<div class="row">
															<div class="col-md-12">
																<div class="form-group">
																	<label class="control-label col-md-3">姓名：</label>
																	<div class="col-md-9">
																	<p class="form-control-static">${user.userName }</p>
																	</div>
																</div>
																<div class="form-group">
																	<label class="control-label col-md-3">注册时间：</label>
																	<div class="col-md-9">
																		<p class="form-control-static" >${user.created }</p>
																	</div>
																</div>
																<div class="form-group">
																	<label class="control-label col-md-3">性别：</label>
																	<div class="col-md-9">
																		<p class="form-control-static">
																			<c:if test="${user.sex==0 }">男</c:if>
																			<c:if test="${user.sex==1 }">女</c:if>
																		</p>
																	</div>
																</div>
																<div class="form-group">
																	<label class="control-label col-md-3">所在地：</label>
																	<div class="col-md-9">
																		<p class="form-control-static" >${user.address }</p>
																	</div>
																</div>
															</div>
														</div>
														<h4 class="form-section">联系信息</h4>
														<div class="row">
															<div class="col-md-12">
																<div class="form-group">
																	<label class="control-label col-md-3">电子邮件：</label>
																	<div class="col-md-9">
																		<p class="form-control-static" >${user.email }</p>
																	</div>
																</div>
																<div class="form-group">
																	<label class="control-label col-md-3">联系电话：</label>
																	<div class="col-md-9">
																		<p class="form-control-static" >${user.phoneNumber }</p>
																	</div>
																</div>
																<div class="form-group">
																	<label class="control-label col-md-3">QQ：</label>
																	<div class="col-md-9">
																		<p class="form-control-static" >${user.qq }</p>
																	</div>
																</div>
															</div>
														</div>
														<h4 class="form-section">其他信息</h4>
														<div class="row">
															<div class="col-md-12">
																<div class="form-group">
																	<label class="control-label col-md-3">描述：</label>
																	<div class="col-md-9">
																		<p class="form-control-static" >${user.description }</p>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
				<%--</div>
			</div>
		</div>
	</div>
  --%></body>
</html>
