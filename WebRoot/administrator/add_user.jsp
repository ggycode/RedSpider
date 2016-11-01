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
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          	用户管理
          <small>新建用户</small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i> 管理中心</a></li>
          <li><a href="user/findUser?pageSize=10&pageNum=1">用户管理</a></li>
          <li class="active">新建用户</li>
        </ol>
      </section>
      
      <!-- Main content -->
     <section class="content">
       <div class="row">
         <!-- left column -->
         <div class="col-md-12">
           <!-- general form elements -->
           <div class="box box-primary">
             <div class="box-header with-border">
               <%--<h3 class="box-title">新建用户</h3>--%>
             </div><!-- /.box-header -->
             <!-- form start -->
             <form id="userform" role="form" action="#" method="POST">
               <div class="box-body">
                 <div class="form-group">
                   <label for="inputUserName">用户名</label>
                   <input type="text" name="userName" class="form-control" id="inputUserName" placeholder="Enter userName">
                 </div>
                 <div class="form-group">
                   <label for="inputPassword1">密码</label>
                   <input type="password" name="password" class="form-control" id="inputPassword1" placeholder="Password">
                 </div>
                 <div class="form-group">
                   <label for="inputPassword2">确认密码</label>
                   <input type="password" name="repeatPassword" class="form-control" id="inputPassword2" placeholder="Password again">
                 </div>
                 <div class="form-group">
					<label for="selectRole">角色</label>
					<select class="form-control" id="selectRole">
						 <c:forEach items="${roleTypes}" var="item" >  
					        <option>${item.roleType}</option>  
					     </c:forEach> 
					</select>
				  </div>
                 <div class="form-group">
                   <label for="inputMobilePhone">手机号</label>
                   <input type="text" name="phoneNumber" class="form-control" id="inputMobilePhone" placeholder="mobilePhone">
                 </div>
                 <div class="form-group">
                   <label for="inputEmail">电子邮件</label>
                   <input type="text" name="email" class="form-control" id="inputEmail" placeholder="email">
                 </div>
                 <div class="form-group">
                   <label for="inputQQ">QQ</label>
                   <input type="text" name="qq" class="form-control" id="inputQQ" placeholder="qq">
                 </div>
                 <div class="form-group">
					<div class="radio">
						<fieldset>
							<legend>性别</legend>
							<label>
								<input id="optionsRadios1" type="radio" checked value="0" name="sex"/>
								男 &nbsp 
							</label>
							<label>
								<input id="optionsRadios2" type="radio" value="1" name="sex"/>
								女
							</label>
						</fieldset>
					</div>
				 </div>
                 <div class="form-group">
                   <label for="inputAddress">通信地址</label>
                   <input type="text" name="address" class="form-control" id="inputAddress" placeholder="address">
                 </div>
                 <div class="form-group">
					<label>描述</label>
					<textarea name="description" id="inputDescription" class="form-control" placeholder="Enter ..." rows="3"></textarea>
				</div>
                 <%--<div class="form-group">
                   <label for="exampleInputFile">File input</label>
                   <input type="file" id="exampleInputFile">
                   <p class="help-block">Example block-level help text here.</p>
                 </div>
               </div><!-- /.box-body -->--%>

               <div class="box-footer">
                 <button type="submit" class="btn btn-primary">保 存</button>
                 <button class="btn btn-default" type="button" onclick="history.go(-1)">取消</button>
               </div>
             </form>
           </div><!-- /.box -->
   		</div>
   	</div>
   </section>
   <script type="text/javascript">
  $().ready(function(){
  	var validate = $('#userform').validate({
//		debug: true, //调试模式取消submit的默认提交功能   
		focusInvalid: false, //当为false时，验证无效时，没有焦点响应  

		rules:{
  			userName: {
		     	maxlength: 32,
		     	required: true
  			},
  			phoneNumber: {
  				required: true
  			},
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
			},
			email: {
				required: true
			}
		},
		messages:{
			userName: {
				maxlength: "最多32个字符",
				required: "请输入用户名"
			},
			phoneNumber: {
				required: "请输入手机号"
			},
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
			},
			email: {
				required: "请输入邮箱地址"
			}
		},
		success: function () {
		},		
		submitHandler: saveUser
  	  });
    });
   
   	function saveUser(){
   	   	var param={
   	   		userName: $('#inputUserName').val(),
   	   		password: $('#inputPassword1').val(),
   	   		repeatPassword: $('#inputPassword2').val(),
   	   		role: $('#selectRole').val(),
   	   		phoneNumber: $('#inputMobilePhone').val(),
   	   		email: $('#inputEmail').val(),
   	 		qq: $('#inputQQ').val(),
   			sex:  $("input[name='sex']:checked").val(),
   			address: $('#inputAddress').val(),
   			description: $('#inputDescription').val()
   	   	};
   		$.ajax({
			type:'POST',
			url: "user/add",
			data: JSON.stringify(param),
			contentType:"application/json",
			dataType: "text",
			async: false,
			success: function(data) {
				if(data == "user_name_exists"){
					alert("用户名重复，创建失败");
				}else{
					alert("创建成功！");
					window.location.href = "user/findUser?pageSize=10&pageNum=1";
				}
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
