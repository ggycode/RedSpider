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
	       <div class="col-xs-12">
	         <div class="box">
	           <div class="box-header">
	             <%--<h3 class="box-title">用户列表</h3>--%>
	             <div>
		           	<button id="add_user" class="btn blue-nx mr-5 btn-primary" onclick="window.location.href='user/reload/add'"><i class="fa fa-fw fa-plus"></i>新建</button>
		         </div>
	             <div class="box-tools">
	               <div class="input-group" style="width: 150px;">
	                 <input type="text" name="table_search" class="form-control input-sm pull-right" placeholder="Search">
	                 <div class="input-group-btn">
	                   <button id="search" class="btn btn-sm btn-default" onclick="search(10,1)"><i class="fa fa-search"></i></button>
	                 </div>
	               </div>
	             </div>
	           </div><!-- /.box-header -->
	           
	           <div class="box-body table-responsive no-padding">
	             <table class="table table-hover" style="text-align:center;">
	             	<thead>
	             		<tr>
	             			<th style="text-align:center;">序号</th>
	             			<th style="text-align:center;">用户名</th>
	             			<th style="text-align:center;">角色</th>
	             			<th style="text-align:center;">状态</th>
	             			<th style="text-align:center;">手机</th>
	             			<th style="text-align:center;">创建时间</th>
	             			<th style="text-align:center;">操作</th>
	             		</tr>
	             	</thead>
	             	<tbody >
	             		<c:forEach items="${pageSource.list}" var="item" varStatus="status">
	             			<tr <c:if test="${status.count%2==0}">bgcolor="#CCEFFF"</c:if>>
                				<td>${status.index }</td> 
	             				<td>${item.userName}</td>
	             				<td>${item.role}</td>
	             				<td>${item.state}</td>
	             				<td>${item.phoneNumber}</td>
	             				<td>${item.created }</td>
	             				<td>
	             					<a href="user/detail/${item.uuid}" style="color:black"><i class="fa fa-fw fa-info"></i></a>
	             					<a href="user/reload/update?id=${item.uuid}" style="color:black"><i class="fa fa-fw fa-edit"></i></a>
	             					<a href="javascript:deleteUser('${item.uuid}','${item.userName}')" style="color:black"><i class="fa fa-fw fa-trash-o"></i></a>
	             				</td>
	             			</tr>
	             		</c:forEach>
	             	</tbody>
	             </table>
	           </div><!-- /.box-body -->
	         </div><!-- /.box -->
	       </div>
	     </div>
	     <div class="row">
			<div class="col-sm-5">
				<div id="example2_info" class="dataTables_info" role="status" aria-live="polite">
					共<c:out value = "${pageSource.totalRows}" />条，当前第<c:out value = "${pageSource.currentPage}" />页，共<c:out value = "${pageSource.totalPages}" />页
				</div>
			</div>
			<div class="col-sm-7">
				<div id="example2_paginate" class="dataTables_paginate paging_simple_numbers">
					<ul class="pagination">
						<li id="example2_first" class="paginate_button">
							<a id="first_page" href="javascript:findUsers(${pageSource.pageSize},1);" aria-controls="example2" data-dt-idx="7" tabindex="0">首页</a>
						</li>
						<li id="example2_previous" class="paginate_button previous">
							<a id="previous_page" href="javascript:findUsers(${pageSource.pageSize},${pageSource.currentPage-1});" aria-controls="example2" data-dt-idx="7" tabindex="0">上一页</a>
						</li>
						<li id="example2_next" class="paginate_button next">
							<a id="next_page" href="javascript:findUsers(${pageSource.pageSize},${pageSource.currentPage+1})" aria-controls="example2" data-dt-idx="7" tabindex="0">下一页</a>
						</li>
						<li id="example2_last" class="paginate_button">
							<a id="last_page" href="javascript:findUsers(${pageSource.pageSize},${pageSource.totalPages});" aria-controls="example2" data-dt-idx="7" tabindex="0">尾页</a>
						</li>
					</ul>
				</div>
			</div>
		 </div>
	   </section>
	  </div>
     <script type="text/javascript">
     	function UserListManage(){
			var self = this;
			self.curUser = ko.observable({});
     	}

		var userlistManage = new UserListManage();   
		ko.applyBindings(userlistManage,$('div#content-wrapper')[0]); 

		window.onload =function()
	    {
		    console.log("sdaf");
	        document.getElementById("search").disabled=true;
	         
	        //搜索框失去焦点时判断。
	        document.getElementsByName("table_search")[0].onblur = function()
	        {
	            if(document.getElementsByName("table_search")[0].value==null || this.value=="")
	            {
	                document.getElementById("search").disabled=true;
	            }else
	            {
	                document.getElementById("search").disabled=false;
	            }
	        }

	        if(${pageSource.currentPage == 1}){
	        	$("#example2_first").addClass('disabled');
	        	$("#first_page").removeAttr('href');
	        	$("#example2_previous").addClass('disabled');
	        	$("#previous_page").removeAttr('href');
	        }
	        if(${pageSource.currentPage == pageSource.totalPages}){
	        	$("#example2_last").addClass('disabled');
	        	$("#last_page").removeAttr('href');
	        	$("#example2_next").addClass('disabled');
	        	$("#next_page").removeAttr('href');
	        }
	    } 	

		function deleteUser(id,name){
			if(confirm("确定删除用户"+name+"?") == false){
				return;
			}
			$.ajax({
				type: 'PUT',
	            url: "user/delete?id="+id,
	            dataType: "text",
	            contentType:"application/json",
	            async: false,
	            success: function(data) {
					window.location.reload();
				//	alert("删除成功");
	            },
	            error: function(XMLHttpResponse) {
	           	 	alert(XMLHttpResponse);
	            }
	        });
		}

		function search(pageSize,PageNum){
			var username = document.getElementsByName("table_search")[0].value;
			window.location.href = "user/findUser?pageSize="+pageSize+"&pageNum="+PageNum+"&username="+username;
		}

		function findUsers(pageSize,PageNum){
			var username = document.getElementsByName("table_search")[0].value;
			if(username != null && username != "" ){
				window.location.href = "user/findUser?pageSize="+pageSize+"&pageNum="+PageNum+"&username="+username;
			}else{
				window.location.href = "user/findUser?pageSize="+pageSize+"&pageNum="+PageNum;
			}

	//		window.location.href = "user/findUser?pageSize="+pageSize+"&pageNum="+PageNum;
      	}
		
     </script>
  </body>
</html>

