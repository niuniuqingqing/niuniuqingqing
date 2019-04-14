login: function (event) {
			//var data = "username="+vm.username+"&password="+vm.password+"&captcha="+vm.captcha+"&android=false";
			var data = "username="+vm.username+"&password="+vm.password+"&android=true";//安卓端调用
			$.ajax({
				type: "POST",
			    url: "sys/login",
			    data: data,
			    dataType: "json",
			    success: function(result){
					if(result.code == 0){//登录成功
						parent.location.href ='index.html';
					}else{
						vm.error = true;
						vm.errorMsg = result.msg;
						
						vm.refreshCode();
					}
				}
			});
		}