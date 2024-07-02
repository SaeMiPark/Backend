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
.body {
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
	border-bottom: 1px solid black;
}

#navi a {
	display: inline-block;
	margin-right: 5px; /* 필요에 따라 간격을 조정하세요 */
	text-decoration: none; /* 기본 링크 스타일 제거 */
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
					<div class="title text">
						<a href="/detail.boards?seq=${dto.seq}">${dto.title}</a>
					</div>
					<div class="writer text">${dto.writer}</div>
					<div class="date text">${dto.write_date}</div>
					<div class="lookup text">${dto.view_cout}</div>
				</div>
			</c:forEach>
		</div>
		<div class="page text" id="navi"></div>
		<div class="btn_div">
			<button class="write_btn">작성하기</button>
		</div>
	</div>

	<script>
		$(".write_btn").on("click", function() {
			location.href="/board/writer.jsp";
		})
		
		
		//페이지 만들기
		let cpage=${cpage};//현재 나의 페이지
		let record_total_count=${record_total_count};//1. 전체 글의 갯수 ex. 317개
		let record_count_per_page=${record_count_per_page};//2. 한 페에지에 몇개의 게시글을 보여줄 것인지 결정
		let navi_count_per_page=${navi_count_per_page};//3.Page Navigater 페이지 번호 자체를 몇 개씩 보여줄건지 결정
		

		//4. 1번/2번 필요한 페이지 숫자
		let page_total_count= 0;
		if(record_total_count%record_count_per_page>0) {
			page_total_count=Math.floor(record_total_count/record_count_per_page)+1;
		}else {
			page_total_count=Math.floor(record_total_count/record_count_per_page);
		}

		//현재 나의 페이지 위치도 알아야한다. 내가 11페이지면 11~20까지 나와야 할 것
		//int currentPage=11; //향후 클라이언트가 페이지번호를 누르면 인자 값으로 받아야 할 것

		//알고리즘. 내가 볼 범위의 번호를 구해야 한다. 1~10
		//start
		 let startNavi = Math.floor((cpage - 1) / navi_count_per_page) * navi_count_per_page + 1;
		//end
		let endNavi=startNavi+navi_count_per_page-1;
		if(endNavi>page_total_count) {endNavi=page_total_count;}

		//화살표 붙이기
		let needNext=true;
		let needPrev=true;
		
		//각 화살표 필요없는 경우
		if(startNavi==1) {needPrev=false;}
		if(endNavi==page_total_count) {needNext=false;}

		//출력
		if(needPrev==true){
			let needPreva=$("<a>").attr("href","/list.boards?cpage="+(startNavi-1)).html(" < ");
			$("#navi").append(needPreva);
		}
		
		for(let i=startNavi; i<=endNavi; i++) {
			let pagesa=$("<a>").attr("href","/list.boards?cpage="+i).html(i+"&nbsp;");
			$("#navi").append(pagesa);
		}
		
		
		if(needNext==true){
			let needNexta=$("<a>").attr("href","/list.boards?cpage="+(endNavi+1)).html(" > ");	 
			$("#navi").append(needNexta);
		}

	</script>

</body>
</html>