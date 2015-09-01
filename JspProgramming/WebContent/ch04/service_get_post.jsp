<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h4>Get Request</h4>
		<a href="../ServiceGetPostServlet">get request</a>
		<form name="get_request" method="get" action="../ServiceGetPostServlet">
			<input type="submit" value="get_request"/>
		</form>
		
		<h4>Post Request</h4>
		<form name="post_request" method="post" action="../ServiceGetPostServlet">
			<input type="submit" value="post"/>
		</form>
	</body>
</html>