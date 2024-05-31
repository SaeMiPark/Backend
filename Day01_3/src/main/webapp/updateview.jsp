<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
    // JavaScript를 사용하여 param.id 값을 가져와서 필드의 기본값으로 설정합니다.
    window.onload = function() {
        let id = '${param.id}';
        document.getElementById('idField').value = id;
    };
</script>
</head>
<body>
	<form action="UpdateServlet.messages">
		<c:if test="${not empty param.id}">
   			 ID: <input type="text" id="idField" name="id" readonly>
		</c:if><br>
		writer : <input type="text" name="writer"><br> 
		contents : <input type="text" name="contents"><br>
		<button>수정하기</button>
	</form>
</body>
</html>