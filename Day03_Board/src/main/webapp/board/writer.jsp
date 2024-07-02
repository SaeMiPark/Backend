<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Form</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
* {
	box-sizing: border-box;
}

div {
	border: 1px solid black;
}

.container {
	width: 1000px;
	height: 800px;
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

.freeboardwrite {
	flex: 0.5;
}

.title {
	flex: 0.5;
}

.contents {
	flex: 8.5;
}

.btns {
	flex: 0.5;
}

#title, #contents {
	width: 100%;
	height: 100%;
}

.backlist, .complete {
	float: right;
}

#name{
	float: left;
}
</style>


</head>


<body>
	<form action="/insert.boards" method="post" enctype="multipart/form-data">
		<div class="container col">
			<div class="freeboardwrite text">자유게시판 글 작성하기</div>
			<div class="title">
				<input name="title" type="text" id="title" placeholder="제목을 입력하세요.">
			</div>
			
			<div class="contents">
				<textarea name="contents" id="contents" placeholder="내용을 입력하세요"></textarea>
			</div>
			<div class="btns">
				<input type="file" name="file">
				<button class="backlist" type="button">목록으로</button>
				<button class="complete" type="submit">작성완료</button>
			</div>
		</div>
	</form>


	<script>
        $(".backlist").on("click",function(){
            location.href="/list.boards";
        })
    </script>

</body>
</html>