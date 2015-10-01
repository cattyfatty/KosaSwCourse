<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			body {font-size: 16px; color: white;}
			a {color: white;}
			a:hover {color:oragne;}
		</style>
	</head>
	<body>
		<h3>Chap07. Spring MVC</h3>
		<hr/>
		<div>
			<h4>Command Object</h4>
			<ul>
				<li><a href="commandObject">/commandObject</a></li>
			</ul>
		</div>

		<div>
			<h4>@ModelAttribute</h4>
			<ul>
				<li><a href="modelAttribute1">/modelAttribute1</a></li>
				<li><a href="modelAttribute2">/modelAttribute2</a></li>
			</ul>
		</div>

		<div>
			<h4>@CookieValue, @RequestHeader</h4>
			<ul>
				<li><a href="cookieValueSet">/cookieValueSet</a>
					<a href="cookieValueGet">/cookieValueGet</a>
				</li>
				<li><a href="requestHeader">/requestHeader</a></li>
			</ul>
		</div>
		
		<div>
			<h4>Validation Check & Err.Message for Command Object</h4>
			<ul>
				<li><a href="login">Login Command Validation</a></li>
				<li><a href="join">Member Command Validation</a></li>
			</ul>
		</div>
	</body>
</html>