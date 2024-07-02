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
</head>
<body>
	<form action="/upload.file" method="post" enctype="multipart/form-data">
		<input type="text" placeholder="메세지" name="message"><br>
		첨부파일 : <input type="file" name="file"><br> 첨부파일 : <input
			type="file" name="file1"><br> 첨부파일 : <input type="file"
			name="file2"><br>
		<button>등록</button>
	</form>
	<fieldset>
		<legend>File List</legend>
		<div id="filelist"></div>
	</fieldset>
	<button id="listcall">파일 목록 불러오기</button>

	<script>
		$("#listcall").on("click", function() {
			$.ajax({
				url : "/list.file",
				dataType : "json",
			}).done(function(list) {
				for(let dto of list){
					 $("#filelist").empty();
					let span=$("<span>").html(dto.seq+". ");
					let ac = $("<a>").attr("href", "/download.file?sysname="+dto.sysname+"&oriname="+dto.oriname).html(dto.oriname);
					$("#filelist").append(span, ac,"<br>");
				}			
			});
		})
	</script>

</body>
</html>