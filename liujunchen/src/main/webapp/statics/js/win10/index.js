
var vm = new Vue({
	el:'#win10-shortcuts',
	data:{
		user:{},
		menuList:{},
		item:{},
		main:"main.html",
		password:'',
		newPassword:'',
        navTitle:"控制台"
	},
	methods: {
		getMenuList: function (event) {
			$.getJSON("${request.contextPath}/sys/menu/nav?_"+$.now(), function(r){
				vm.menuList = r.menuList;
				$("#win10-shortcuts").empty();
				 var menuList=r.menuList;
				 for(var item in menuList){
						 var urlopen="${request.contextPath}/"+menuList[item].url;
						 var i="<i class="+menuList[item].icon+"></i>"+menuList[item].name+"";
						 $("#win10-shortcuts").append(" <div class=\"shortcut\" onclick=\"Win10.openUrl('"+urlopen+"','"+i+"')\">" +
						 		"<i class=\"icon "+menuList[item].icon+"\"></i>" +
						 				"<div class=\"title\">"+menuList[item].name+"</div>" +
						 						"</div>");
						
				}
			});
		},
		getUser: function(){
			$.getJSON("${request.contextPath}/sys/user/info?_"+$.now(), function(r){
				vm.user = r.user;
			
			});
		},
		
		
	},
	created: function(){
		this.getMenuList();
		this.getUser();
	},
	
});




