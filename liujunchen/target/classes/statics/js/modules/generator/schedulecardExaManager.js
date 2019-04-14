$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'schedulecard/selfExaSubmit',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '开始时间', name: 'shijianStart', index: 'shijianStart', width: 80 }, 		
			{ label: '结束时间', name: 'shijianEnd', index: 'shijianEnd', width: 80 }, 	
			{ label: '教室', name: 'classroom', index: 'classroom', width: 80 }, 			
			{ label: '预约人', name: 'teacher', index: 'teacher', width: 80 }, 			
			{ label: '科目', name: 'subject', index: 'subject', width: 80 },
			{ label: '批复状态', name: 'approveStatus', index: 'approveStatus', width: 80 }
			
			
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

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		scheduleCard: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.scheduleCard = {};
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
			var url = vm.scheduleCard.id == null ? "schedulecard/save" : "schedulecard/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.scheduleCard),
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
			vm.scheduleCard = {id:id};
			var url = vm.scheduleCard.id == null ? "schedulecard/refuse" : "schedulecard/refuse";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.scheduleCard),
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
			vm.scheduleCard = {id:id};
			var url = vm.scheduleCard.id == null ? "schedulecard/agree" : "schedulecard/agree";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.scheduleCard),
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
		examination: function(){
			vm.showList = false;
			vm.title = "考试预约";
			vm.scheduleCard = {};
		},
		
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "schedulecard/delete",
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
			$.get(baseURL + "schedulecard/info/"+id, function(r){
                vm.scheduleCard = r.scheduleCard;
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