$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'classroominquiry/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '教室号', name: 'classroomNum', index: 'classroom_num', width: 80 }, 			
			{ label: '教室类型', name: 'classroomType', index: 'classroom_type', width: 80 }, 			
			{ label: '是否使用', name: 'isAppointment', index: 'is_appointment', width: 80 }, 			
			{ label: '开始时间', name: 'shijianStart', index: 'shijianStart', width: 80 }, 			
			{ label: '结束时间', name: 'shijianEnd', index: 'shijianEnd', width: 80 }, 			
			{ label: '审核状态', name: 'approveStatus', index: 'approveStatus', width: 80 },
			{ label: '创建人', name: 'createBy', index: 'createBy', width: 80 }
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
//安卓端调用--获取应用列表list数据
/*$(function () {
	$.get(baseURL + "classroominquiry/list?page=1&limit=10&order=asc&sidx=", function(r){
		console.log(r.page);
    });
});*/
var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		classroomInquiry: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.classroomInquiry = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.classroomInquiry.id == null ? "classroominquiry/save" : "classroominquiry/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.classroomInquiry),
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
		
		refuse: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.classroominquiry = {id:id};
			var url = vm.classroominquiry.id == null ? "classroominquiry/refuse" : "classroominquiry/refuse";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.classroominquiry),
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
		
		agree: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.classroominquiry = {id:id};
			var url = vm.classroominquiry.id == null ? "classroominquiry/agree" : "classroominquiry/agree";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.classroominquiry),
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
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "classroominquiry/delete",
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
		
		appointment: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.classroomInquiry={id:id};
			$.ajax({
				type: "POST",
				url: baseURL + "classroominquiry/appointment",
			    contentType: "application/json",
			    data: JSON.stringify(vm.classroomInquiry),
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
		
		
		getInfo: function(id){
			$.get(baseURL + "classroominquiry/info/"+id, function(r){
                vm.classroomInquiry = r.classroomInquiry;
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