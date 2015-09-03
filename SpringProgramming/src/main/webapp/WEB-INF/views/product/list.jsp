<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			body {color: white; font-weight: 300;}
			a {color: white; text-decoration: none;}
			table{
				width:100%;
				border-collapse: collapse;
				font-size: small;
			}
			table, th, td{
				border: 1px solid white;
				text-align: center;
				
			}
			
			th{
				background-color: #fe1919;
			}
			
			#buttonGroup{
				margin: 10px;
				text-align: center;
				border-radius: 2px;
				background-color: gray;
				width: 150px; height: auto;
				vertical-align: middle;
				padding: 5px 0;
				position: relative;
				left: 50%; transform: translateX(-50%);
			}
			#buttonGroup:hover {background-color: #bc1919;}
			#buttonGroup a {display: inline-block;}
		</style>
	</head>
	
	<body>
		<h4>게시물 목록</h4>
		
		<table>
			<tr>
				<th style="width:50px">상품번호</th>
				<th style="width:60px">상품이름</th>
				<th style="width:80px">상품가격</th>
				<th style="width:60px">상품수량</th>
				<th style="width:60px">상품종류</th>
				<th style="width:60px">상품설명</th>
			</tr>
			<c:forEach var="product" items="${list}">
				<tr>
					<td>${product.no }</td>
					<td><a href="#">${product.name}</a></td>
					<td>${product.price} </td>
					<td>${product.amount}</td>
					<td>${product.kind}</td>
					<td>${product.content}</td>
				</tr>
			</c:forEach>
		</table>
		
		
		
		<div id="buttonGroup">
			<a href="writeForm">
				상품등록
			</a>
		</div>
	</body>
</html>







