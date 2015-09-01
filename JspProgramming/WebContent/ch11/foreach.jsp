<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		forEach.jsp
		<hr/>
		<c:forEach var="i" begin="1" end="5">
			${i } <br/>
		</c:forEach>
		<hr/>
		<c:forEach var="i" begin="1" end="10" step="2">
			${i } <br/>
		</c:forEach>
		<hr/>
		
		<%
		List<String> names = new ArrayList<String>();
		names.add("홍길동");
		names.add("임꺽정");
		names.add("일지매");
		request.setAttribute("names", names);
		%>
		<c:forEach var="name" items="${names}" varStatus="stat">
			first: ${stat.first},
			last: ${stat.last},
			index: ${stat.index },
			count: ${stat.count } <br/>
		</c:forEach>
		
		<hr/>
		<c:forEach var="name" items="${names}" varStatus="stat">
			<c:if test="${stat.first}">
				<table>
					<tr>
						<th>이름</th>
					</tr>
			</c:if>
					<tr>
						<td>${name }</td>
					</tr>
			<c:if test="${stat.last}">
				</table>
			</c:if>
		</c:forEach>
	</body>
</html>