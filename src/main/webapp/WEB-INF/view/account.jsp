<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>注册界面</title>

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
<!--  -->
<script type="application/x-javascript"> 
addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>

<!--//fonts -->
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
						<li><a href="/moana" >登录</a><label>- </label></li>
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
	</div>
	<!---->
	<div class="container">
		<div class="account">
		<h2>注册</h2>
			<form>			
			<div> 	
				<span class="mail">邮箱</span>
				<input type="text" id="film_mail"> 
			</div>
			<div> 
				<span class="word">密码</span>
				<input type="password" id="film_password">
			</div>	
			<div> 
				<span class="word2">再次输入密码</span>
				<input type="password" id="film_password_again">
			</div>			
				<span style="display:block; width:230px; text-align:center">
				<input type="submit" value="注册" id="film_register" style="width:120px;"> 
				</span>
			</form>
			<br><br>
		</div>
	
	</div>

	<!---->

	<script type="text/javascript">
		$(function(){  
	        $("#film_register").click(function(){
	        		var mail = $("#film_mail").val();
	        		var password = $("#film_password").val();
	        		var password_again = $("#film_password_again").val();
	        		
	        		var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
					if (!reg.test(mail)){
						alert("请输入正确的邮箱格式");
						return false;
					}
	        		   
	        		if($.trim(mail) == ""){
	        			alert("用户名不能为空！");
	        			return false;
	        		}
	        		if($.trim(password) == ""){
	        			alert("密码不能为空！");
	        			return false;
	        		}
	        		if($.trim(password_again) == ""){
	        			alert("请再次输入密码！");
	        			return false;
	        		}
	        		if(password !== password_again){
	        			alert("两次输入密码不一致！");
	        			$("#film_password").val("");
	        			$("#film_password_again").val("");
	        			return false;
	        		}
	        		
	        		$.ajax({
	        			async : false,
	        			type:"POST",
	        			dataType:"json",
	        			url:"register",
	        			//url:"",
	        			data:{
	        				ucount:mail,
	        				upassword:password
	        			},
		        		success:function(msg){
		        			if(msg === 1){
		        				alert("注册成功！");
		        				var tourl = "/moana/single?ucount="+mail;
		        				window.location.href=tourl;
		        				alert("test");
		        				
		        			}
		        			if(msg === 0){
		        				alert("注册失败，邮箱已注册！");
		        				return false;
		        			}
		        			
		        		},
	        			error:function(msg){
	        				alert("注册失败！");
	        				return false;
	        			}
	        		});

	        });
	        
	        $("#test_button").click(function(){
	        	var mail = "test@163.com";
	        	var tourl = "/moana/single?ucount="+mail;
	        	window.location.href=tourl;
	        });
	        
	        
	    });
	</script>
	
	
        
	<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>



</body>
</html>