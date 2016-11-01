<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en-US">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=${encoding}">
<title>Insert title here</title>
</head>
  
  <body>
    <!-- Content Wrapper. Contains page content -->
    <div id="content-wrapper" class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          	订购
          <small>云主机</small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i> 资源申请</a></li>
          <li class="active">云主机</a></li>
        </ol>
      </section>
      <!-- Main content -->
	  <section class="content">
	  	<div class="portlet-title">
			<p>云主机是一种简单高效，处理能力可弹性伸缩的计算服务助您快速构建更稳定、安全的应用。提升运维效率，降低IT成本，使您更专注于核心业务创新。</p>
		</div>
	    <div class="row">
	       <div class="col-xs-12">
	         <div class="box">
	           <div class="box-header">
	             <div>
	             	<%--<h4>云主机配置</h4> --%>
		        </div>
	           </div><!-- /.box-header -->
	           <form id="userform" role="form" action="#" method="POST">
	               <%--<div class="box-body">--%>
		           <div class="form-body">
					 <div class="form-group" id="resource_pool" >
					 	<label class="control-label col-md-3">资源中心：</label>
					 	<div class="col-md-8 has-error">
							<div data-bind="foreach: vm_res_poolList">
								<button class="btn btn-default btn-flat" style="margin:1px 2.5px" data-bind="css: {blue: $parent.vm_res_pool() == $data.id},click:function(){$parent.vm_res_pool($data.id);}">
									<span data-bind="text: id"/>
								</button>
							</div>
						</div>
					 </div>
					 <div class="form-group" id="cpu">
					 	<label class="control-label col-md-3">CPU(核)：</label>
					 	<div class="col-md-8 has-error">
							<div data-bind="foreach: vm_cpuList">
								<button class="btn btn-default btn-flat" style="margin:1px 2.5px" data-bind="css: {blue: $parent.vm_cpu() == $data},click:function(){$parent.vm_cpu($data);}">
									<span data-bind="text: $data"/>
								</button>
							</div>
						</div>
					 </div>
					 <div class="form-group" id="memory" >
					 	<label class="control-label col-md-3">内存(G)：</label>
					 	<div class="col-md-8 has-error">
							<div data-bind="foreach: vm_memoryList">
								<button class="btn btn-default btn-flat" style="margin:1px 2.5px" data-bind="css: {blue: $parent.vm_memory() == $data},click:function(){$parent.vm_memory($data);}">
									<span data-bind="text: $data"/>
								</button>
							</div>
						</div>
					 </div>
					 <div class="form-group">
						<label class="control-label col-md-3">数据盘大小：</label>
						<div id="cloud-disk" data-bind="validationOptions: {insertMessages: false, decorateInputElement: true, errorElementClass: 'errorMsg'}" class="col-md-8 input-inline">
							<div data-bind="visible: showdisk1" style="width: 400px; margin-top: 3px; background-color: LightGray;">
								<div class="col-sm-3" style="height: 36px;line-height: 36px;text-align: center;">云磁盘</div>
								<div class="col-sm-3" style="height: 36px;line-height: 36px;">
									<input type="text" name="diskSize" data-bind="value: disksize1" onblur="validateDiskSize(this)" class="form-control"  placeholder="5-2000">
								</div>
								<div class="col-sm-4" style="height: 36px;line-height: 36px;">自动分配挂载点</div>
								<div class="col-sm-2" style="height: 36px;line-height: 36px;"><a href="#" data-bind="click: function(){deleteCloudDisk(1);}">删除</a></div>
								<div style="clear: both;"></div>
							</div>
							<div data-bind="visible: showdisk2" style="width: 400px; margin-top: 3px; background-color: LightGray;">
								<div class="col-sm-3" style="height: 36px;line-height: 36px;text-align: center;">云磁盘</div>
								<div class="col-sm-3" style="height: 36px;line-height: 36px;">
									<input type="text" name="diskSize" data-bind="value: disksize2" onblur="validateDiskSize(this)" class="form-control"  placeholder="5-2000">
								</div>
								<div class="col-sm-4" style="height: 36px;line-height: 36px;">自动分配挂载点</div>
								<div class="col-sm-2" style="height: 36px;line-height: 36px;"><a href="#" data-bind="click: function(){deleteCloudDisk(2);}">删除</a></div>
								<div style="clear: both;"></div>
							</div>
							<div data-bind="visible: showdisk3" style="width: 400px; margin-top: 3px; background-color: LightGray;">
								<div class="col-sm-3" style="height: 36px;line-height: 36px;text-align: center;">云磁盘</div>
								<div class="col-sm-3" style="height: 36px;line-height: 36px;">
									<input type="text" name="diskSize" data-bind="value: disksize3" onblur="validateDiskSize(this)" class="form-control"  placeholder="5-2000">
								</div>
								<div class="col-sm-4" style="height: 36px;line-height: 36px;">自动分配挂载点</div>
								<div class="col-sm-2" style="height: 36px;line-height: 36px;"><a href="#" data-bind="click: function(){deleteCloudDisk(3);}">删除</a></div>
								<div style="clear: both;"></div>
							</div>
							<div data-bind="visible: showdisk4" style="width: 400px; margin-top: 3px; background-color: LightGray;">
								<div class="col-sm-3" style="height: 36px;line-height: 36px;text-align: center;">云磁盘</div>
								<div class="col-sm-3" style="height: 36px;line-height: 36px;">
									<input type="text" name="diskSize" data-bind="value: disksize4" onblur="validateDiskSize(this)" class="form-control"  placeholder="5-2000">
								</div>
								<div class="col-sm-4" style="height: 36px;line-height: 36px;">自动分配挂载点</div>
								<div class="col-sm-2" style="height: 36px;line-height: 36px;"><a href="#" data-bind="click: function(){deleteCloudDisk(4);}">删除</a></div>
								<div style="clear: both;"></div>
							</div>
							<button class="btn" style="margin-top: 3px;" data-bind="click: addDataDisk, enable: btnAdd">增加一块</button>
						</div>
				     </div>
				     <div class="form-group">
						<label class="control-label col-md-3">选择镜像：</label>
						<div class="col-md-8 input-inline" data-bind="foreach: templateFromList">
							<button style="margin:1px 2.5px" class="btn mr-5"
								data-bind="css:{blue: $parent.templateFrom()==$data.value},click:function(){$parent.templateFrom($data.value);}"><span data-bind="text: name"></span></button>
						</div>
					</div>
					<div class="form-group" id="os" data-bind="visible: templateFrom() == 'publicTemplate'" >
					 	<label class="control-label col-md-3">操作系统：</label>
					 	<div class="col-md-8 has-error">
							<select class="form-control select2me select2-offscreen" data-bind="value: vm_os,options: vm_osList" style="min-width:80px;max-width:250px;" tabindex="-1" title=""></select>
							<span class="validationMessage help-inline" style="display: none;"></span>
						</div>
					</div>
					<div class="form-group" id="OS" data-bind="visible: templateFrom() == 'privateTemplate'">
						<label class="control-label col-md-3">操作系统：</label>
						<div class="col-md-8 has-error">
							<select class="form-control select2me" data-bind="options: customImageList, optionsValue:'id', optionsText:'name', value: customImage" style="min-width:80px;max-width:250px;"></select>
							<span class="validationMessage help-inline" style="display: none;"></span>
						</div>
					</div>
					<div class="form-group" id="rootDiskSize" data-bind="visible: templateFrom() == 'publicTemplate'">
						<label class="control-label col-md-3">系统盘(G)：</label>
						<div class="col-md-4 input-inline has-error" style="vertical-align: middle;">
							<span data-bind="text: vm_root_disk_size"></span> G
						</div>	`
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">虚拟机名称：</label>
						<div class="col-md-4 has-error">
							<input type="text" data-bind="value: vm_name" class="form-control">
							<span class="validationMessage help-inline" style="display: none;"></span>
						</div>
					</div>
				  </div>
				  <div class="form-actions ceilinglamp" id="ceilinglamp">
					<div id="buy_alerts_div"></div>
					<div class="row"><div class="col-md-offset-3 col-md-12">
						<button type="button" name="buyNow" class="btn yellow btn-danger" onclick="perSubmit()">立即购买</button>
					</div></div>
				  </div>
	           </form>
	           
      		 </div>
      	 </div>
       </div>
      </section>
    </div>
    
    <script type="text/javascript">
     	function OrderManage(){
			var self = this;
			self.vm_res_poolList = ko.pureComputed(loadResPoolList);
			self.vm_res_pool = ko.observable();
			self.vm_cpuList = ko.pureComputed(loadCpuList);
			self.vm_cpu = ko.observable();
			self.vm_memoryList = ko.pureComputed(loadMemoryList);
			self.vm_memory = ko.observable();
			self.vm_osList = ko.pureComputed(loadOSList);
			self.vm_os = ko.observable();
			self.productSpecList = ko.observableArray();
			self.initForm = function()
	     	{
				<c:forEach items="${productSpecList}" var="item">
					var productSpec = {
						name: '',
						resourcePoolList: [],
						cpuList: [],
						memoryList: [],
						osList: []
					};
					productSpec.name = "${item.specName}";
				 	<c:forEach items="${item.productSpecValues}" var="it" varStatus="st">
				 		<c:if test="${it.attrName=='vm_res_pool'}">
				 			productSpec.resourcePoolList.push("${it.attrValue}");
				 		</c:if>
				 		<c:if test="${it.attrName=='vm_cpu'}">
				 			productSpec.cpuList.push("${it.attrValue}");
				 		</c:if>
				 		<c:if test="${it.attrName=='vm_memory'}">
				 			productSpec.memoryList.push("${it.attrValue}");
				 		</c:if>
				 		<c:if test="${it.attrName=='vm_os'}">
				 			productSpec.osList.push("${it.attrValue}");
				 		</c:if>
					 </c:forEach>
					 self.productSpecList.push(productSpec);
				</c:forEach>
	     	}

			self.diskNum = ko.observable(0);
	        self.btnAdd = ko.pureComputed(function() {
	        	if(self.diskNum() <= 3) {
	        		return true;
	        	}else {
	        		return false;
	        	}
	        });
			self.showdisk1 = ko.observable(false);
			self.showdisk2 = ko.observable(false);
			self.showdisk3 = ko.observable(false);
			self.showdisk4 = ko.observable(false);
			self.disksize1 = ko.observable().extend({required:{onlyIf:function(){return self.showdisk1();}}});
			self.disksize2 = ko.observable().extend({required:{onlyIf:function(){return self.showdisk2();}}});
			self.disksize3 = ko.observable().extend({required:{onlyIf:function(){return self.showdisk3();}}});
			self.disksize4 = ko.observable().extend({required:{onlyIf:function(){return self.showdisk4();}}});
			self.addDataDisk = function() {
				var n = $("#cloud-disk > div:visible").size();
				n = n + 1;
				var name = "showdisk" + n;
				self[name](true);
				self.diskNum(self.diskNum() + 1);
			};
			self.templateFrom = ko.observable();
			self.templateFromList = ko.pureComputed(function(){
				var list = [{value:"publicTemplate",name:"公有镜像"},{value:"privateTemplate",name:"自定义镜像"}];
				orderManage.templateFrom(list[0].value);
				return list;
			});
			self.customImage = ko.observable().extend({
				required:{
					message:"该项目下无自定义镜像，请先创建镜像",
					onlyIf: function() {
						return self.templateFrom() == 'privateTemplate';
					}
				}
			});
			self.customImageList = ko.pureComputed(getCustomImageList);
			self.vm_root_disk_size = ko.pureComputed(function() {
				var os = self.vm_os();
				if(os && os.indexOf("Windows") != -1) {
					return "40";
				} else if( os.indexOf("CentOS  7.2") != -1 ){
					return "40";
				}else {
					return "20";
				}
			});
			self.vm_name = ko.observable().extend({
				required: {params: true, message: "虚拟机名称必须选择或输入"},
				pattern:{
					message: '名称必须以大小写字母或中文开头，可包含数字。不能以http://和https://开头。',
	                params: '^[a-zA-Z\u4e00-\u9fa5][\\w\.\\-\u4e00-\u9fa5]{1,127}$'
	           	}
	        });
	     }

		var orderManage = new OrderManage();   
		orderManage.initForm();
		ko.applyBindings(orderManage,$('div#content-wrapper')[0]); 


		function loadResPoolList(){
			var res_poolList = new Array();
			var specs = orderManage.productSpecList();
			for(var i in specs){
				var resPools = specs[i].resourcePoolList;
				for(var j in resPools){
					res_poolList.push({
						name: "Yin Chuan",
						id: resPools[j]
					});
				} 
			}
			orderManage.vm_res_pool(res_poolList[0].id);
			return res_poolList;
		}

		function loadCpuList(){
			var cpuList = [];
			var specs = orderManage.productSpecList();
			for(var i in specs){
				var resPools = specs[i].resourcePoolList;
				for(var j in resPools){
					if(resPools[j] != orderManage.vm_res_pool()){
						continue;
					}

					var cpus = specs[i].cpuList;
					for(var k in cpus){
						cpuList.push(cpus[k]);
					}
					break;
				} 
			}
			orderManage.vm_cpu(cpuList[0]);
			return cpuList;
		}

		function loadMemoryList(){
			var memoryList = [];
			var specs = orderManage.productSpecList();
			for(var i in specs){
				var resPools = specs[i].resourcePoolList;
				for(var j in resPools){
					if(resPools[j] != orderManage.vm_res_pool()){
						continue;
					}
					var cpus = specs[i].cpuList;
					for(var k in cpus){
						if(cpus[k] != orderManage.vm_cpu()){
							continue;
						}else{
							var memorys = specs[i].memoryList;
							for(var m in memorys){
								memoryList.push(memorys[m]);
							}
							break;
						}
					}
				} 
			}
			orderManage.vm_memory(memoryList[0]);
			return memoryList;
		}

		function loadOSList(){
			var osList = [];
			var specs = orderManage.productSpecList();
			for(var i in specs){
				var resPools = specs[i].resourcePoolList;
				for(var j in resPools){
					if(resPools[j] != orderManage.vm_res_pool()){
						continue;
					}

					var oses = specs[i].osList;
					for(var k in oses){
						osList.push(oses[k]);
					}
					break;
				} 
			}
			orderManage.vm_os(osList[0]);
			return osList;
		}

		function validateDiskSize(obj) {
			var result = 5;
			var val = $(obj).val().trim();
			var reg = /^\d+$/;
			if(reg.test(val)) {
				var newVal = parseInt(val.substring(val.search(/[1-9]/)));
				if(newVal > 2000) {
					result = 2000;
				}else if(newVal < 5) {
					result = 5;
				}else {
					result = newVal;
				}
			}else {
				result = 5;
			}
			var attrName = $(obj).attr("data-bind").split(":")[1].trim();
			orderManage[attrName](result);
		}

		function deleteCloudDisk(num){
			eval("orderManage.showdisk"+num)(false);
			eval("orderManage.disksize"+num)('');
			orderManage.diskNum(orderManage.diskNum() - 1);
		}

		function getCustomImageList() {
			var result = [];

			return result;
		}

		// 磁盘子订单
		function generateDiskAttribute() {
			var result = [];
			var character = ['b', 'c', 'd', 'e'];
			var diskAttr = null;
			if($("#cloud-disk > div:visible input[name='diskSize']").length > 0){
				diskAttr = $("#cloud-disk > div:visible input[name='diskSize']");
			}else{
				diskAttr = $("#ephemeral-ssd-disk > div:visible input[name='diskSize']");
			}
				
			diskAttr.each(function(i) {
				var size = $(this).val() == "" ? 5 : $(this).val();

				var nameProperty = {
					"propertyId": "",
	     			"propertyName": "disk_" + (i+1) + "_name",
	     			"propertyType": "0",
	     			"propertyDisplay": "磁盘名称",
	     			"propertyValue": "sd" + character[i]
				};
				var sizeProperty = {
					"propertyId": "",
	     			"propertyName": "disk_" + (i+1) + "_size",
	     			"propertyType": "0",
	     			"propertyDisplay": "磁盘空间",
	     			"propertyValue": size
				};
				result.push(nameProperty);
				result.push(sizeProperty);
			});
			
			return result;
		}
		
		function perSubmit(){
			var diskAttrs = generateDiskAttribute();
			var workOrderBo={
				userId: g_user_id,
				type: 1,
	    		state: 0,
	    		resourcePoolId: orderManage.vm_res_pool(),
	    		resourceId: '',
	    		resourceType: "ecs",
				action: "modify_vnc_password",
				created: new Date(),
				workOrderProperties: [
		            {
		                propertyId: Math.uuid(32),
		                propertyId: "vm_os",
	                    propertyName: "osName",
	                    propertyDisplay: "操作系统",
	                    propertyValue: orderManage.vm_os(),
		                isnull: false
		            },
		            {
		                propertyId: Math.uuid(32),
		                propertyId: "vm_cpu",
	                    propertyName: "cpu",
	                    propertyDisplay: "CPU",
	                    propertyValue: orderManage.vm_cpu(),
		                isnull: false
		            },
		            {
		                propertyId: Math.uuid(32),
		                propertyId: "vm_memory",
	                    propertyName: "memory",
	                    propertyDisplay: "内存",
	                    propertyValue: orderManage.vm_memory(),
		                isnull: false
		            },
		            {
		                propertyId: Math.uuid(32),
		                propertyId: "vm_res_pool",
	                    propertyName: "resource_pool",
	                    propertyDisplay: "资源中心",
	                    propertyValue: orderManage.vm_res_pool(),
		                isnull: false
		            },
		            {
		                propertyId: Math.uuid(32),
		                propertyId: "vm_root_disk_size",
	                    propertyName: "root_disk",
	                    propertyDisplay: "系统盘",
	                    propertyValue: orderManage.vm_root_disk_size(),
		                isnull: false
		            },
		            {
		                propertyId: Math.uuid(32),
		                propertyId: "vm_name",
	                    propertyName: "vm_name",
	                    propertyDisplay: "虚拟机名称",
	                    propertyValue: orderManage.vm_name(),
		                isnull: false
		            }
	        	]
			};

			//增加磁盘属性
			if(diskAttrs) {
				for(var i = 0; i < diskAttrs.length; i++) {
					workOrderBo.workOrderProperties.push(diskAttrs[i]);
				}
			}
			
	   		$.ajax({
				type:'POST',
				url: "workorder/add/workorders",
				data: JSON.stringify(workOrderBo),
				contentType:"application/json",
				dataType: "text",
				async: false,
				success: function(data) {
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
