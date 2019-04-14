$(function () {
	
    $("#jqGrid").jqGrid({
        url: baseURL + 'appointment/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '预约时间', name: 'shijian', index: 'shijian', width: 80 }, 			
			{ label: '创建人', name: 'createby', index: 'createBy', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });

});

var setting = {
	    data: {
	        simpleData: {
	            enable: true,
	         
	        }
	       
	    }
	};
	var ztree;
	var ztree2;
	var ztree3;
	
var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		appointment: {},
       user: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		

		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.getDept();
			vm.getDeptmentManagement();
			vm.getDoctor();
			vm.classroomInquiry = {};
			$("#jqGridOW").jqGrid({
		        url: baseURL + 'appointment/list',
		        datatype: "json",
		        colModel: [			
		               	{ label: '检查项目', name: 'projectmanagement', index: 'projectmanagement',  editable: false,width: 300,formatter:  function(value, options, row){
		               		return	'<input type="text" class="form-control"  style="cursor:pointer;"  onClick="deptTree(this)" readonly="readonly" placeholder="选择项目"/>'}
		               	}, 			
						{ label: '科室', name: 'departmentManagement', index: 'departmentManagement',  editable: false,width: 300,formatter:  function(value, options, row){
		               		return	'<input type="text" class="form-control"  style="cursor:pointer;"  onClick="deptmentManagement(this)" readonly="readonly" placeholder="选择科室"/>'} },	
						{ label: '医务人员', name: 'doctor', index: 'doctor',  editable: false,width: 300,formatter:  function(value, options, row){
		               		return	'<input type="text" class="form-control"  style="cursor:pointer;"  onClick="doctor(this)" readonly="readonly" placeholder="选择医务人员"/>'} }	
		        ],
				viewrecords: true,
		        height: 385,
		        rowNum: 10,
				rowList : [10,30,50],
		        rownumbers: true, 
		        rownumWidth: 25, 
		        autowidth:true,
		        multiselect: true,
		        pager: "#jqGridPagerOW",
		        jsonReader : {
		            root: "page.list",
		            page: "page.currPage",
		            total: "page.totalPage",
		            records: "page.totalCount"
		        },
		        prmNames : {
		            page:"page", 
		            rows:"limit", 
		            order: "order"
		        },
		        gridComplete:function(){
		        	//隐藏grid底部滚动条
		        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
		        }
		    });
		},
		
		
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            vm.getDept();
            vm.getDeptmentManagement();
			vm.getDoctor();
            vm.getInfo(id);
            $("#jqGridOW").jqGrid({
		        url: baseURL + 'appointment/list',
		        datatype: "json",
		        colModel: [			
		                	{ label: '检查项目', name: 'projectmanagement', index: 'projectmanagement',  editable: false,width: 300,formatter:  function(value, options, row){
			               		return	'<input type="text" class="form-control"  style="cursor:pointer;"  onClick="deptTree(this)" readonly="readonly" placeholder="选择项目"/>'}
			               	}, 			
							{ label: '科室', name: 'departmentManagement', index: 'departmentManagement',  editable: false,width: 300,formatter:  function(value, options, row){
			               		return	'<input type="text" class="form-control"  style="cursor:pointer;"  onClick="deptmentManagement(this)" readonly="readonly" placeholder="选择科室"/>'} },	
							{ label: '医务人员', name: 'doctor', index: 'doctor',  editable: false,width: 300,formatter:  function(value, options, row){
			               		return	'<input type="text" class="form-control"  style="cursor:pointer;"  onClick="doctor(this)" readonly="readonly" placeholder="选择医务人员"/>'} }	
		        ],
				viewrecords: true,
		        height: 385,
		        rowNum: 10,
				rowList : [10,30,50],
		        rownumbers: true, 
		        rownumWidth: 25, 
		        autowidth:true,
		        multiselect: true,
		        pager: "#jqGridPagerOW",
		        jsonReader : {
		            root: "page.list",
		            page: "page.currPage",
		            total: "page.totalPage",
		            records: "page.totalCount"
		        },
		        prmNames : {
		            page:"page", 
		            rows:"limit", 
		            order: "order"
		        },
		        gridComplete:function(){
		        	//隐藏grid底部滚动条
		        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
		        }
		    });
		},
		

		
		
		 getDept: function(){
	            //加载部门树
	            $.get(baseURL + "appointment/getProject", function(r){
	                ztree = $.fn.zTree.init($("#deptTree"), setting, r);
	                var node = ztree.getNodeByParam("id", vm.appointment.id);
	                if(node != null){
	                    ztree.selectNode(node);

	                    vm.appointment.name = node.name;
	                }
	            })
	        },
		
	       
	        getDeptmentManagement: function(){
	            //加载部门树
	            $.get(baseURL + "appointment/getDeptmentManagement", function(r){
	            	ztree2 = $.fn.zTree.init($("#deptmentManagementTree"), setting, r);
	                var node = ztree2.getNodeByParam("id", vm.appointment.id);
	                if(node != null){
	                	ztree2.selectNode(node);

	                    vm.appointment.name = node.name;
	                }
	            })
	        },
	        
	        
	        getDoctor: function(){
	            //加载部门树
	            $.get(baseURL + "appointment/getDoctor", function(r){
	                ztree3 = $.fn.zTree.init($("#doctorTree"), setting, r);
	                var node = ztree3.getNodeByParam("username", vm.appointment.username);
	                if(node != null){
	                    ztree3.selectNode(node);
	                    vm.appointment.username = node.username;
	                }
	            })
	        },
			
		saveOrUpdate: function (event) {
			var url = vm.appointment.id == null ? "appointment/save" : "appointment/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.appointment),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
	
		del: function (event) {
			delRow();
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "appointment/delete",
				    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "appointment/info/"+id, function(r){
                vm.appointment = r.appointment;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});



function deptTree(obj){
	 layer.open({
	        type: 1,
	        offset: '50px',
	        skin: 'layui-layer-molv',
	        title: "选择项目",
	        area: ['300px', '450px'],
	        shade: 0,
	        shadeClose: false,
	        content: jQuery("#deptLayer"),
	        btn: ['确定', '取消'],
	        btn1: function (index) {
	            var node = ztree.getSelectedNodes();
	            //选择上级部门
	            vm.appointment.id = node[0].id;
	            vm.appointment.name = node[0].name;
	            obj.value=node[0].name;
	            layer.close(index);
	        }
	    });
}

function deptmentManagement(obj){
	 layer.open({
	        type: 1,
	        offset: '50px',
	        skin: 'layui-layer-molv',
	        title: "选择科室",
	        area: ['300px', '450px'],
	        shade: 0,
	        shadeClose: false,
	        content: jQuery("#deptmentManagementLayer"),
	        btn: ['确定', '取消'],
	        btn1: function (index) {
	            var node = ztree2.getSelectedNodes();
	            //选择上级部门
	            vm.appointment.id = node[0].id;
	            vm.appointment.name = node[0].name;
	            obj.value=node[0].name;
	            layer.close(index);
	        }
	    });
}


function doctor(obj){
	 layer.open({
	        type: 1,
	        offset: '50px',
	        skin: 'layui-layer-molv',
	        title: "选择体检医务人员",
	        area: ['300px', '450px'],
	        shade: 0,
	        shadeClose: false,
	        content: jQuery("#doctorLayer"),
	        btn: ['确定', '取消'],
	        btn1: function (index) {
	            var node = ztree3.getSelectedNodes();
	            //选择上级部门
	            vm.appointment.id = node[0].id;
	            vm.appointment.username = node[0].username;
	            obj.value=node[0].username;
	            layer.close(index);
	        }
	    });
}


function deptTreeW(){
	return '<input type="text" class="form-control" style="cursor:pointer;" v-model="user.deptName" @click="deptTree" readonly="readonly" placeholder="所属部门"/>'
}

function addRowData(){ //创建一条空的记录，待编辑  
    var tableObject = $('#jqGridOW');  
    //获取表格的初始model    
     var colModel = tableObject.jqGrid().getGridParam("colModel") ;    
    var newRow = JSON.stringify(colModel);   
    var ids = tableObject.jqGrid('getDataIDs');    
    //如果jqgrid中没有数据 定义行号为1 ，否则取当前最大行号+1    
    var rowid = (ids.length ==0 ? 1: Math.max.apply(Math,ids)+1);    
    //获得新添加行的行号（为什么是负数呢,与编辑行差别对待）    
    var newrowid = (0-rowid);    
    //设置grid单元格不可编辑 （防止在添加时，用户修改其他非添加行的数据）    
    tableObject.setGridParam({cellEdit:true});    
     //将新行追加到表格头部    
     tableObject.jqGrid("addRowData", newrowid,newRow,"end");    
     //设置grid单元格可编辑（防止追加行后，可编辑列无法编辑）    
    tableObject.jqGrid('editRow', newrowid, false);    
}  

function delRow() {
    var grid = $("#jqGridOW");
    var rowKey = grid.getGridParam("selrow");
    if (rowKey) {
        grid.delGridRow(rowKey);
    }
    else {
        alert("No rows are selected");
    }
}

