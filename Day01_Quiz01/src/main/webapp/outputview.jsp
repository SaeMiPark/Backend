<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message List</title>
</head>
<body>
	<div style="margin: auto;  width: 80%;">
			<table border="1">
				<tr>
					<th>id</th>
					<th>title</th>
					<th>genre</th>
					<th>opendate</th>
					<th>삭제</th>
					<th>수정</th>
				</tr>
				<c:forEach var="dto" items="${list}">
					<tr>
						<td>${dto.id}</td>
						<td>${dto.title}</td>
						<td>${dto.genre}</td>
						<td>${dto.opendate}</td>
						<td><button onclick="location.href='updateview.jsp?id=${dto.id}'">수정</button></td>
						<td><button onclick="location.href='DeleteServlet.movies?id=${dto.id}'">삭제</button></td>
					</tr>
				</c:forEach>
				<tr>
				<td>
					<button onclick="location.href='index.html'">BACK</button>
				</td>
				</tr>
			</table>
	</div>
</body>
</html>