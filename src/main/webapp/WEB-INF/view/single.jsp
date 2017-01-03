<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>抢票界面</title>
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
						<li ><a href="">欢迎您：   </a> <label id="user_name">${ucount}</label></li>
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
						<li><a href="account" >退出</a><label>- </label></li>
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
		<div class="single">
			<div class="col-md-9  single-top">
				<div class="text-in">					
						<div class="single-men">
							<img class="img-responsive" src="" alt="" id="film_image"/><br>
							<form>
								<div>
									<p>
										<span class="film">电影编号</span>										
										<input type="text" value="" id="film_id" readOnly="true">
									</p><br>
								</div>
								<div>
									<p>
										<span class="film">电影名称</span>										
										<input type="text" value="" id="film_name" readOnly="true">
									</p><br>
								</div>
								<div>
									<p>
										<span class="film2">导演</span>										
										<input type="text" value="" id="film_director" readOnly="true">
									</p><br>
								</div>
								<div>
									<p>
										<span class="film2">主演</span>
										<input type="text" value="" id="film_actor" readOnly="true">
									</p><br>
								</div>
								<div>
									<p>
										<span class="film">剩余票数</span>
										<input type="text" value="" id="film_count" readOnly="true">
									</p><br>
								</div>
								<div>
									<p>
										<span class="film">简介</span>	
									</p><br>								
										<textarea id="film_remark" style="width:408px; height:168px;" readonly="true"></textarea>
										<br>
									
								</div><br>
								<div class="sub-in">
									<input type="submit" value="抢票" id="film_buy">
									
								</div>
							</form>
							<br><br>
						</div>


				</div>
				
				
			</div>

				<div class="clearfix"> </div>
			</div>
		</div>
	<!---->

	 <script type="text/javascript">
						$(document).ready(function() {
							$.ajax({ 
		                        type: "POST", 
		                        url: "selectfilmbyid", 
		                        dataType: "json",     
		                        data: {
		                        	fid:1
		                        }, 
		                        success:function(data){
		                        	$("#film_image").attr("src", "images/zoo.jpg");
			                        $("#film_id").val(data.fid);
			                        $("#film_name").val(data.fname);
			                        $("#film_director").val(data.fdirector);
			                        $("#film_actor").val(data.factor);
			                        $("#film_remark").val(data.fremark);
			                        $("#film_count").val(data.fcount);
		                        return true;
		                        

		                        },
		                        error:function(data){  
		                            alert("error test");  
		                        },
		                    });
							
						});
					</script>
	<script type="text/javascript">
		(function ($) {
	        $.getUrlParam = function (name) {
	            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	            var r = window.location.search.substr(1).match(reg);
	            if (r != null) return unescape(r[2]); return null;
	        }
	    })(jQuery);
		var name = $.getUrlParam('ucount');
		
		if(name == "" || name == undefined || name == null){
			
		}else{
			var label=document.getElementById("user_name");
			label.innerText=name;
			$("#user_name").html(name);
		}		 
	</script>
	
	<script type="text/javascript">
		$(function(){  
	        $("#film_buy").click(function(){
	        		var fid = $("#film_id").val();
	        		var name = document.getElementById("user_name").innerHTML;
	        		
	        		if(name == "null" || $.trim(name) == ""){
	        			alert("请先登录");
	        			return false;
	        		}
	        		
	        		if($.trim(fid) == ""){
	        			alert("抢票失败！");
	        			return false;
	        		}
	        		        		
	        		$.ajax({
	        			async : false,
	        			type:"POST",
	        			dataType:"json",
	        			url:"purchase",

	        			data:{
	        				fid:fid,
	        				ucount:name
	        			},
		        		success:function(msg){
		        			if(msg === 1){
		        				alert("抢票成功！");
		        				var tourl = "/moana/single?ucount="+name;
		        				window.location.href=tourl;
		        				alert("test");
		        				
		        			}
		        			if(msg === 0){
		        				alert("抢票失败，每位用户只能抢两张！");
		        				
		        			}
		        			
		        		},
	        			error:function(msg){
	        				alert("抢票失败！");
	        				return false;
	        			}
	        		});

	        });
	        
	        $("#test_button").click(function(){
		        	var name = document.getElementById("user_name").innerHTML;
		        	if(name == "null" || $.trim(name) == ""){
	        			alert("请先登录");
	        			return false;
	        		}else{
	        			alert("success");
	        		}
	        });
	        
	        
	    });
	</script>
	
	<script>
		$(function(){
			var count = 10;
			setInterval(reflash,3000);
			function reflash(){
				$.ajax({
                    type: "POST", 
                    url: "selectfilmbyid", 
                    dataType: "json",     
                    data: {
                    	fid:1
                    }, 
                    success:function(data){   
                        $("#film_count").val(data.fcount);
                    return true;
                    

                    },
                    error:function(data){  
                        alert("error test");  
                    },
                });
			}
		})
	</script>

</body>
</html>
