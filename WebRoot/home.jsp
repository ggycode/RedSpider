<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=basePath%>assets/layout/css/homePage.css">

  </head>
  
  <body>
  	<div id = "shwoInfo" style="position: fixed; top: 50%; margin-top: -80px; background: #0f3773; border: 1px solid #fff; border-left: 0; border-top-right-radius: 10px !important; border-bottom-right-radius: 10px !important; padding: 10px; width: 80px; height: 160px; z-index: 999;">
        <div style="width: 100%; line-height: 24px; color: #fff;">严禁在本站发布涉密文件及相关信息</div>
        <a style="position: relative;display: block; margin: 10px auto; border-radius: 15px !important; border: 1px solid #fff; width: 30px; height: 30px; line-height: 30px; text-align: center; color: #fff" class="fa fa-times" onclick="$('#shwoInfo').addClass('hide');"></a>
    </div>
    <div class="page-container" id="content">
	    <div class="promo-block" id="promo-block">
	      <div class="container">
	        <div class="tab-index">
	          <div id="tabbox">
	                <ul class="tabs" id="tabs">
	                   <li class="active"><a href="#" tab="tab1">云主机</a></li>
	                   <li><a href="#" tab="tab2">负载均衡</a></li>
	                   <li><a href="#" tab="tab3">关系型数据库</a></li>
	                   <li><a href="#" tab="tab4">开放存储服务</a></li>
	                   <li><a href="#" tab="tab5">大数据服务</a></li>
	                   <div class="clearfix"></div>
	                </ul>
	                <ul class="tab_conbox">
	                    <li id="tab1" class="tab_con">
	                        <div class="index-tab-box">
	                            <h2><span>云</span>主机</h2>
	                            <p>云主机是云计算在基础设施应用上的重要组成部分，位于云计算产业链金字塔底层，产品源自云计算平台。该平台整合了互联网应用三大核心要素：计算、存储、网络，面向用户提供公用化的互联网基础设施服务。</p>
	                        </div>
	                        <div class="index-tab-img">
	                            <!-- <img src="assets/frontend/layout/img/cloud-gov/ecs-index.png" width="373" height="261" alt="云主机" /> -->
	                        </div>
	                    </li>
	
	                    <li id="tab2" class="tab_con">
	                        <div class="index-tab-box">
	                            <h2><span>负载</span>均衡</h2>
	                            <p>负载均衡是对多台云服务器进行流量分发的复杂均衡服务。可以通过流量分发扩展应用系统对位的服务能力，通过消除单点故障提升应用系统的可用性。</p>
	                        </div>
	                        <div class="index-tab-img">
	                            <!-- <img src="assets/frontend/layout/img/cloud-gov/slb-index.png" width="373" height="261" alt="云主机" /> -->
	                        </div>
	                    </li>
	
	                    <li id="tab3" class="tab_con">
	                        <div class="index-tab-box">
	                            <h2><span>关系型</span>数据库</h2>
	                            <p>云数据库是一种即开即用、稳定可靠、可弹性伸缩的在线数据库服务。具有多重安全防护措施和完善的性能监控体系。并提供专业的数据库备份、恢复及优化方案，使您能专注于应用开发和业务发展。</p>
	                        </div>
	                        <div class="index-tab-img">
	                            <!-- <img src="assets/frontend/layout/img/cloud-gov/rds-index.png" width="373" height="261" alt="云主机" /> -->
	                        </div>
	                    </li>
	
	                    <li id="tab4" class="tab_con">
	                        <div class="index-tab-box">
	                            <h2><span>云</span>存储</h2>
	                            <p>对象储存是为客户提供的一种海量、弹性、高可用、高性价比的云存储服务，提供了基于Web门户和基于REST接口两种访问方式，用户可以在任何地方通过互联网对数据进行管理和访问。</p>
	                        </div>
	                        <div class="index-tab-img">
	                            <!-- <img src="assets/frontend/layout/img/cloud-gov/oss-index.png" width="373" height="261" alt="云主机" /> -->
	                        </div>
	                    </li>
	                    <li id="tab5" class="tab_con">
	                        <div class="index-tab-box">
	                            <h2><span>大数据</span>服务</h2>
	                            <p>大数据服务是基于互联网的相关服务的增加、使用和交付模式，通常涉及通过互联网来提供动态易扩展且经常是虚拟化的资源。大数据服务指通过网络以按需、易扩展的方式获得所需服务。这种服务可以是IT和软件、互联网相关，也可是其他服务。</p>
	                        </div>
	                        <div class="index-tab-img">
	                            <!-- <img src="assets/frontend/layout/img/cloud-gov/bigdata-index.png" width="373" height="261" alt="云主机" /> -->
	                        </div>
	                    </li>
	                </ul>
	            </div>
	          <div class="clearfix"></div>
	        </div>
	    	 
	      </div>
	    </div>
  <!-- block END -->
  	</div>
  	<script type="text/javascript">

        $(document).ready(function() {
            jQuery.jqtab = function(tabtit,tabcon) {
                $(tabcon).hide();

                $(tabcon+":first").show();

                $(tabtit+" li").click(function() {
                    $(tabtit+" li").removeClass("active");
                    $(this).addClass("active");
                    $(tabcon).hide();
                    var activeTab = $(this).find("a").attr("tab");
                    $("#"+activeTab).fadeIn();
                    return false;
                });

            };

            $.jqtab("#tabs",".tab_con");
        });
    </script>
  </body>
</html>
