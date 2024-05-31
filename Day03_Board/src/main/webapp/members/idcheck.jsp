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
table {
	width: 100%;
	margin:auto;
}
</style>


</head>
<body>
	<table border="1">
		<tr>
			<th>아이디 중복 확인 결과</th>
		</tr>

		<c:choose>
			<c:when test="${result}">
				<tr>
					<td align="center">이미 사용중인 ID입니다.</td>
				</tr>
				<tr>
					<td align="center"><button id="close">닫기</button> 
					<script>
						$("#close").on("click", function(){
							opener.document.getElementById("id").value="";
							window.close();
						})
					</script>
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td align="center">사용 가능한 ID입니다. <br> 정말 사용하시겠습니까?
					</td>
				</tr>
				<tr>
					<td align="center">
						<button id="use">사용</button>
						<button id="cancle">취소</button> <script>
							$("#use").on("click",function(){
								opener.didIdCheck = true;
								window.close();
							})
							
							$("#cancle").on("click",function(){
								opener.document.getElementById("id").value="";
								window.close();
							})
						</script>
					</td>
				</tr>
			</c:otherwise>
		</c:choose>


	</table>
</body>
</html>