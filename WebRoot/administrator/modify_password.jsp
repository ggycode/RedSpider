<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          	用户管理
          <small>列表页</small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i> 管理中心</a></li>
          <li class="active">用户管理</a></li>
          <%--<li class="active">Data tables</li>--%>
        </ol>
      </section>
      <!-- Main content -->
     <section class="content">
       <div class="row">
         <div class="col-md-12">
           <!-- general form elements -->
           <div class="box box-primary">
             <!-- form start -->
             <form id="passform" role="form" action="#" method="POST">
               <div class="box-body">
               	 <input type="hidden" id="inputUuid" name="uuid" value="${uuid }"/>
                 <div class="form-group">
                   <label for="inputPassword1">密码</label>
                   <input type="password" name="password" class="form-control" id="inputPassword1" placeholder="Password">
                 </div>
                 <div class="form-group">
                   <label for="inputPassword2">确认密码</label>
                   <input type="password" name="repeatPassword" class="form-control" id="inputPassword2" placeholder="Password again">
                 </div>
                 <div class="box-footer">
                 <button type="submit" class="btn btn-primary">保 存</button>&nbsp;&nbsp;
                 <button class="btn btn-default" type="button" onclick="history.go(-1)">取消</button>
               </div>
             </form>
           </div><!-- /.box -->
         </div>
       </div>
     </section>
     </div>
     <script type="text/javascript">
     $().ready(function(){
    	  	var validate = $('#passform').validate({
    			focusInvalid: false, //当为false时，验证无效时，没有焦点响应  

    			rules:{
    	  			password: {
    	             	minlength: 6,
    	             	maxlength: 16,
    	             	required: true
    				},
    				repeatPassword: {
    					minlength: 6,
    					maxlength: 16,
    					required: true,
    					equalTo: "#inputPassword1"
    				}
    			},
    			messages:{
    				password: {
    					minlength: "最少6个字符",
    					maxlength: "最多16个字符",
    					required: "请输入密码"
    				},
    				repeatPassword: {
    					minlength: "最少6个字符",
    					maxlength:" 最大16个字符",
    					required: "请再次输入密码",
    					equalTo: "密码不一致"
    				}
    			},
    			success: function () {
    			},		
    			submitHandler: modifyPassword
   	  	   });
   	    });
     
		function modifyPassword(){
			var param={
		    	   	uuid: $('#inputUuid').val(),
		    	   	password: $('#inputPassword1').val(),
		   	   		repeatPassword: $('#inputPassword2').val()
		  	   	};
		  		$.ajax({
					type:'PUT',
					url: "user/update",
					data: JSON.stringify(param),
					contentType:"application/json",
					dataType: "text",
					async: false,
					success: function(data) {
						alert("重置密码成功！");
						history.go(-1);
				//		window.location.href = "user/findUser?pageSize=10&pageNum=1";
		           },
			        error: function(XMLHttpResponse) {
		   	        console.log(XMLHttpResponse);
						alert(XMLHttpResponse);
			        }
				});
		}
     </script>
  </body>
</html>
