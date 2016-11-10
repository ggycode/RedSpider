<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ecsmanage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <!-- Content Wrapper. Contains page content -->
    <div id="content-wrapper" class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          	资源管理
          <small>列表页</small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i> 资源管理</a></li>
          <li class="active">云主机管理</a></li>
          <%--<li class="active">Data tables</li>--%>
        </ol>
      </section>
      <!-- Main content -->
  	  <section class="content">
	    <div class="row">
	       <div class="col-xs-12">
	         <div class="box">
	           <div class="box-header">
	             
	           </div><!-- /.box-header -->
	         </div>
	       </div>
	    </div>
	  </section>
      
      
    </div>
    <script type="text/javascript">
    window.onload =function()
    {
        console.log("dafd");
        $.ajax({
			type: 'GET',
            url: "resourcePool/find",
            dataType: "text",
            contentType:"application/json",
            async: false,
            success: function(data) {
            },
            error: function(XMLHttpResponse) {
           	 	alert(XMLHttpResponse);
            }
        });

        $.ajax({
			type: 'GET',
            url: "resourceObj/ecs/describeInstances/"+g_user_id,
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

    function ControlManage(){
		var self = this;
		self.resPool = ko.observable();
		self.ecs_status = ko.observable();
		self.ecsResource = ko.observable();
     }

	var controlManage = new ControlManage();   
	ko.applyBindings(controlManage,$('div#content-wrapper')[0]); 
	
		function findEcsTable(){
			
		}
		function findEcsDetail(){
			
		}
    </script>
  </body>
</html>
