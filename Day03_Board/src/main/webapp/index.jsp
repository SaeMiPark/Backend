<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
	table{
		margin:auto;
		width:350px;
		text-align:center;
	}
	
</style>


</head>
<body>
	<c:choose>
		<c:when test="${loginID != null}">

			<table border=1>
				<tr>
					<th colspan=4>${loginID}님 환영합니다.</th>
				</tr>

				<tr>
				<th><button id="list">게시판으로</button></th>
					<th><button id="mypage">내정보</button></th>
					<th><button id="logout">로그아웃</button></th>
					<th><button id="memberout">회원탈퇴</button></th>
				</tr>
			</table>

			<script>
				$("#list").on("click",function(){
					location.href="/list.boards";
				})
			
			
				
				$("#logout").on(
						"click",
						function() {
							location.href="/logout.members";
						})
						
						
				$("#memberout").on(
						"click",
						function() {
							window.open("/members/memberout.jsp",
									"", "width=300, height=300");
						})
						
				$("#mypage").on(
						"click",
						function() {
							location.href="/mypage.members";
						})
			</script>
		</c:when>
		<c:otherwise>
			<form action="login.members">
				<table border="1">
					<tr>
						<th>Login</th>
					</tr>
					<tr>
						<th><input type="text" placeholder="input your id" name="id"></th>
					</tr>
					<tr>
						<th><input type="password" placeholder="input your pw"
							name="pw"></th>
					</tr>
					<tr>
						<td>
							<button>Login</button>
							<button type="button" type="button" id="signup"
								onclick="location.href='/members/signup.jsp'">Signup</button>
						</td>
					</tr>
				</table>
			</form>
		</c:otherwise>
	</c:choose>



</body>
</html>