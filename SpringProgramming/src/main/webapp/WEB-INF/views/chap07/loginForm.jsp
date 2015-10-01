<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login Form</title>
		
		<style type="text/css">
			body {font-size: 16px; color: white;}
		</style>
	</head>
	<body>
		<h4>Sign In</h4>
		<hr/>
		<form:form commandName="login">
			<form:input path="memberId" size="20" placeholder="ID"/>
			<form:errors path="memberId"/><br/>
			
			<form:password path="memberPw" size="20" placeholder="Password"/>
			<form:errors path="memberPw" /><br/>
			<!-- <input type="text" name="memberId" size="20" placeholder="ID"/><br/> -->
			<!-- <input type="password" name="memberPw" size="20" placeholder="Password"/><br/> -->
			<input type="submit" value="Sign In"/>
		</form:form>
	</body>
</html>