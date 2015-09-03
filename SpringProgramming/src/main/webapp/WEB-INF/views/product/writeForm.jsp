<%@ page contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<style type="text/css">
			body {color: white}
		</style>
		
		
	</head>
	
	<body>
		<form method="post" action="write">
			<table id="form_table">
				<tr>
					<td>상품이름</td>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr>
					<td>상품가격</td>
					<td><input type="text" name="price"/></td>
				</tr>
				<tr>
					<td>상품수량</td>
					<td><input type="text" name="amount"/></td>
				</tr>
				<tr>
					<td>상품종류</td>
					<td><input type="text" name="kind"/></td>
				</tr>
				<tr>
					<td>상품설명</td>
					<td><textarea name="content" rows="5" cols="50"></textarea></td>
				</tr>
			</table>
			<input type="submit" value="글올리기"/>
			<input type="reset" value="다시작성"/>
		</form>
	</body>
</html>

  
  
  
  
  
  
  