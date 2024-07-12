<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Input</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
<form action="/inputProc" method="post">
	<table border="1">
		<tr>
			<th colspan=2>Index</th>
		</tr>
		<tr>
			<td><input type="text" name="writer" placeholder="input your name"></td>
			<td><input type="text" name="message" placeholder="input message"></td>
		</tr>
		<tr>
			<td colspan=2><button>제출</button><button type="button" id="back">Back</button></td>
		</tr>
	</table>
</form>

<script>
	$("#back").on("click", function(){
		location.href="/";
	})
</script>

</body>
</html>