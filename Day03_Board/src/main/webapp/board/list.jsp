<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>

.body{
	overflow-y: auto;
}


* {
	box-sizing: border-box;
}


.container {
	border: 1px solid black;
	width: 1000px;
	height: 900px;
	margin: auto;
}

.col {
	display: flex;
	flex-direction: column;
}

.row {
	display: flex;
}

.text {
	display: flex;
	justify-content: center;
	align-items: center;
}

.freeboard {
	flex: 0.5;
	background-color: gray;
	border: 1px solid black;
}

.bin {
	flex: 0.5;
}

.title {
	flex: 7;
}

.writer {
	flex: 1;
}

.date {
	flex: 1;
}

.lookup {
	flex: 0.5;
}

.navi {
	flex: 0.5;
	background-color: lightgray;
	border: 1px solid black;
}

.main {
	flex: 8;
  
}

.page {
	flex: 0.5;
}

.btn_div {
	flex: 0.5;
	padding-right: 10px;
}

.write_btn {
	float: right;
}

.rowcontainer {
	width: 100%;
	height: 50px;
	border-bottom:1px solid black ;
}
</style>
</head>
<body>
	<div class="container col">
		<div class="freeboard text">자유게시판</div>
		<div class="navi row">
			<div class="bin"></div>
			<div class="title text">제목</div>
			<div class="writer text">작성자</div>
			<div class="date text">날짜</div>
			<div class="lookup text">조회</div>
		</div>
		<div class="main col">
			<c:forEach var="dto" items="${list}">
				<div class="rowcontainer row">
					<div class="bin text">${dto.seq}</div>
					<div class="title text"><a href="/detail.boards?seq=${dto.seq}">${dto.title}</a></div>
					<div class="writer text">${dto.writer}</div>
					<div class="date text">${dto.write_date}</div>
					<div class="lookup text">${dto.view_cout}</div>
				</div>
			</c:forEach>
		</div>
		<div class="page text">${pageNavi}</div>
		<div class="btn_div">
			<button class="write_btn">작성하기</button>
		</div>
	</div>

	<script>
		$(".write_btn").on("click", function() {
			location.href="/board/writer.jsp";
		})
	</script>

</body>
</html>