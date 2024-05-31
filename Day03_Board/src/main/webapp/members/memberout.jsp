<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
	<table>
		<tr><td>정말 삭제하시겠습니까?</td></tr>
		<tr><td>
			<button id="yes">확인</button>
			<button id="no">취소</button>
		</td></tr>
	
	</table>

	<script>
		$("#yes").on("click",function(){
			window.close();
			window.opener.location.href="/memberout.members";
		})
		
		$("#no").on("click",function(){
			window.close();
		})
	</script>
</body>
</html>