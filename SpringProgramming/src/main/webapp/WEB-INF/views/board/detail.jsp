<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			body {
				font-family: "돋움";
				font-size: 12px;
				color: white;
			}
			span {
				display: inline-block;
				margin: 2px 10px;
			}
			
			span.title {
				margin: 2px 10px;
				border: 1px solid darkgray;
				background: #ef1919;
				width: 70px;
				text-align: center;
			}
			
			pre {
				margin: 10px;
				border: 1px solid darkgray;
				padding: 10px;
				width: 90%;
				height: 100px;
				font-size: 12px;
			}
			
			#part1 {display: flex;}
			#part1_1 {flex:1}
			#part1_2 {width: 120px; text-align: center; }
			#part1_2 img {display: block; padding: 10px; width: 100px; height: 100px;}
			
			#buttonGroup {
				margin: 10px;
				text-align: center;
			}
			
			#buttonGroup a {
				display:inline-block;
				width: 70px;
				line-height: 30px;
				text-decoration: none;
				font-size: small;
				color: white;
				border: 1px solid darkgray;
				background-color: gray;
				font-weight: bold;
			}
			
			#buttonGroup a:hover {
				color: black;
				background-color: lightgray;
			}

		</style>
	</head>
	
	<body>
		<h4>게시물 보기</h4>
		<div id="part1">
			<div id="part1_1">
				<span class="title">번호:</span> 
				<span class="content">${board.no }</span> <br/>
				<span class="title">제목:</span> 
				<span class="content">${board.title }</span> <br/>
				<span class="title">글쓴이:</span> 
				<span class="content">${board.writer }</span> <br/>
				<span class="title">날짜:</span> 
				<span class="content">${board.date }</span> <br/>
				<span class="title">조회수:</span> 
				<span class="content">${board.hitcount }</span> <br/>
				<span class="title">첨부:</span>
				<span class="content">${board.originalFileName }</span> <br/>
			</div>
			
			<div id="part1_2">
				<img src="${pageContext.request.contextPath }/resources/uploadfiles/${board.filesystemName}"/>
				<button>download</button>
			</div>
		</div>
		
		<div id="part2">
			<span class="title">내용:</span> <br/>
			<pre>${board.content }</pre>
		</div>
				
		<div id="buttonGroup">
			<a href="list">목록</a>
			<a href="updateForm?boardNo=${board.no }">수정</a>
			<a href="delete?boardNo=${board.no }">삭제</a>
		</div>		
	</body>
</html>