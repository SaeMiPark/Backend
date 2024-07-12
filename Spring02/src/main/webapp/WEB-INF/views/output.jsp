<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<th colspan="4">메세지 리스트</th>
		</tr>
		<c:forEach var="i" items="${list }">
				<tr>
					<td><input class="seqInput" type="text" name="seq" value="${i.seq }" disabled></td>
					<td><input class="writerInput" type="text" name="writer" value="${i.writer}" disabled></td>
					<td><input class="messageInput" type="text" name="message" value="${i.message }" disabled></td>
					<td>
						<button class="updatebtn" type="button">수정</button>
						<button class="completebtn" type="submit">완료</button>
					</td>
				</tr>
		</c:forEach>
		<tr>
			<td colspan="4">
				<form action="/delete">
					<input name="seq" type="text" placeholder="input seq to delete">
					<button>삭제</button>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<a href="/"><button>Back</button></a>
			</td>
		</tr>
	</table>
	<script>
	
	$(document).on("click", ".updatebtn", function(){
		//열기
		$(this).closest("tr").find(".writerInput, .messageInput").removeAttr("disabled");
	});
	
	$(document).on("click", ".completebtn", function(){
		//완료 누를는 순간 수정 사항 잠그기
		$(this).closest("tr").find(".writerInput, .messageInput").attr("disabled", true);
		
		//사용 변수
		let seqInput=$(this).closest("tr").find(".seqInput");
		let writerInput=$(this).closest("tr").find(".writerInput");
		let messageInput=$(this).closest("tr").find(".messageInput");
		
		writerInput.value
		messageInput.value
		
		//보내기
		let form=$("<form>");
		form.append(seqInput, writerInput,messageInput).attr("action","/update");
		$("body").append(form);
		form.submit();
		
	});
	
	</script>
</body>
</html>