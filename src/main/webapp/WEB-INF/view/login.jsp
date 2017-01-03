<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>登录界面</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="电影抢票系统" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<!--//fonts-->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
					</script>

</head>
<body>
	<!--header-->
	<div class="header-in">
		<div class="container">
			<div class="logo">
				<h1><a href="index.html">电影抢票系统</a></h1>
			</div>
			<div class="header-top">
				<div class="header-top-in">
					<ul class="header-grid">
						<li ><a href="">欢迎您   </a> <label></label></li>
								
					</ul>
					<div class="act">
						<a href="#" class="done">都是最新电影喔</a>
					</div>
				<div class="clearfix"> </div>
				</div>

				<div class="clearfix"> </div>
			</div>
			<!---->
			<div class="header-bottom">
				<div class="top-nav">
					<span class="menu"> </span>
					<ul>
						<li  ><a href="single" >首页</a><label>- </label> </li>
						<li><a href="account" >注册</a><label>- </label></li>
					</ul>
					<!--script-->
				<script>
					$("span.menu").click(function(){
						$(".top-nav ul").slideToggle(500, function(){
						});
					});
			</script>
				</div>
					<div class="search">
						<form>
							<input type="text" value="Search film here ..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" >
							<input type="submit" value="">
						</form>
					</div>
			<div class="clearfix"> </div>
		</div>
		<!---->
			
			
				</div>
	
			<div class="clearfix"> </div>
		</div>
		
		
	
	<!---->
	<div class="container">
		<div class="account">
		<h2>登录</h2>
			<form >
			<div>
				<span>用户名称</span>
				<input type="text" id="user_name" name="ucount"> 				
			</div>
			<div>
				<span>用户密码</span>
				<input type="password" id="user_password" name="password"> 
			</div>
				<a class="forgot" href="#">忘记密码?</a>
				<input type="submit" value="登录" id="singup_button"> 
			</form>
		</div>
	
	</div>

	<!---->


	
	<script type="text/javascript">  
            $(function(){  
                $("#singup_button").click(function(){
                		var name = $("#user_name").val();
                		var password = $("#user_password").val();
                		
                		if($.trim(name) == ""){
                			alert("用户名不能为空！");
                			return false;
                		}
                		if($.trim(password) == ""){
                			alert("密码不能为空！");
                			return false;
                		}
                    $.ajax({ //no need to judge the browser type
                    		async : false,
                        type: "POST", //类型  
                        url: "checkuser", //请求访问的servlet  
                        dataType: "json",     
                        data: {
                        	ucount:name,
                        	password:password
                        }, //传递的参数  
                  success:function(msg){   //成功返回的回调函数
                	  if(msg === 1){
                		   var tourl = "/moana/single?ucount="+name;
		        				window.location.href=tourl;
		        				alert("test");
                	  }else{
                		  alert("用户名或密码错误！");
                		  return false;
                	  	   }
                        

                        },
                  error:function(msg){  
                        alert("error test");  
                        }
                    });  
                });  
            });  
       </script>
        
	<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>


</body>
</html>
