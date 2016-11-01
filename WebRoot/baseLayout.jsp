<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	 <base href="<%=basePath%>">
    <title><tiles:insertAttribute name="title" ignore="true" /></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome 4.4.0 -->
    <link rel="stylesheet" href="<%=basePath%>font-awesome-4.5.0/css/font-awesome.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="<%=basePath%>adminLte/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="<%=basePath%>adminLte/dist/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="<%=basePath%>adminLte/plugins/datatables/dataTables.bootstrap.css">
    
    <!-- added by self -->
    <link rel="stylesheet" href="<%=basePath%>assets/layout/css/custom.css">

	<!-- jQuery 2.1.4 -->
    <script src="<%=basePath%>adminLte/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
    <!-- SlimScroll -->
    <script src="<%=basePath%>adminLte/plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <!-- FastClick -->
    <script src="<%=basePath%>adminLte/plugins/fastclick/fastclick.min.js"></script>
    <!-- AdminLTE App -->
    <script src="<%=basePath%>adminLte/dist/js/app.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="<%=basePath%>adminLte/dist/js/demo.js"></script>
    <!-- knockout -->
    <script src="<%=basePath%>media/js/knockout-3.2.0.debug.js" type="text/javascript"></script>
	<script src="<%=basePath%>media/js/knockout.mapping-latest.debug.js" type="text/javascript"></script>
	<script src="<%=basePath%>media/js/knockout.validation.js" type="text/javascript"></script>
	<!-- jquery validation -->
	<script src="<%=basePath%>media/js/jquery.validate.min.js" type="text/javascript"></script>
	
	<script src="<%=basePath%>media/js/commFunctions.js" type="text/javascript"></script>
  </head>
  
  <body class="hold-transition skin-blue layout-top-nav">
    <div class="wrapper">

      <header class="main-header">
        <nav class="navbar navbar-static-top">
          <div class="container">
          	<tiles:insertAttribute name="header" />
          </div><!-- /.container-fluid -->
        </nav>
      </header>
      
      <!-- Full Width Column -->
      <div class="content-wrapper">
        <div class="container">
      		<tiles:insertAttribute name="body" />
      	</div>
   	  </div>
   	  
   	  <footer class="main-footer">
        <div class="container">
        	<tiles:insertAttribute name="footer" />
        </div>
      </footer>
      
    </div>
    
    <script type="text/javascript">
    	var g_user_id = '';
      	var g_user_name = '<sec:authentication property="principal.username" />';

      	findUserByName(g_user_name);

      	function findUserByName(userName){
      		$.ajax({
				type: 'GET',
	            url: "user/getUserInfo/userName/"+userName,
	            dataType: "json",
	            contentType:"application/json",
	            async: false,
	            success: function(data) {
	            	if(data != null){
	            		g_user_id = data.uuid;
	            	}
	            },
	            error: function(XMLHttpResponse) {
	           	 	alert(XMLHttpResponse);
	            }
	        });
      	}
    </script>
    
  </body>
</html>
