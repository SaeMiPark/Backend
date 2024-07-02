<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

	<fieldset>
		<legend>단순 요청</legend>
		<button id="ajax01">TEST</button>
	</fieldset>
	<hr>
	<fieldset>
		<legend>파라미터 전달 요청</legend>
		<button id="ajax02">TEST</button>
	</fieldset>
	<hr>
	<fieldset>
		<legend>응답 받아보기</legend>
		<button id="ajax03">TEST</button>
	</fieldset>
		<hr>
	<fieldset>
		<legend>배열 데이터 받아보기</legend>
		<button id="ajax04">TEST</button>
	</fieldset>
			<hr>
	<fieldset>
		<legend>객체 데이터 받아보기</legend>
		<button id="ajax05">TEST</button>
	</fieldset>
		<hr>
	<fieldset>
		<legend>리스트 안 객체 데이터 받아보기</legend>
		<button id="ajax06">TEST</button>
	</fieldset>
	<hr>
	<fieldset>
		<legend>임의 객체 데이터 받아보기</legend>
		<button id="ajax07">TEST</button>
	</fieldset>
	
	<script>
		$("#ajax01").on("click", function(){
			$.ajax({
				url : "/exam01.ajax"
			});
		})
		
		$("#ajax02").on("click", function(){
			$.ajax({
				url : "/exam02.ajax",
				type: "post",
				data : {
					key1 : "apple", //input type=text name=key1 value="Apple"
					key2 : "orange",
					key3 : "kewi"
					
				}
			});
		})
		
		$("#ajax03").on("click", function(){
			$.ajax({
				url : "/exam03.ajax"
			}).done(function(resp){  //printWriter받는 곳
				//서버로부터 정상적 응답이 돌아왔을 때 실행되는 CallBack이다
				//서버의 응답 데이터는 callback의 매개변수로 전달 됨.
				console.log(resp);
				
			});
		})
		
		$("#ajax04").on("click", function(){
			$.ajax({
				url : "/exam04.ajax"
			}).done(function(resp){ 
				let fruits=JSON.parse(resp); // 방법2 역직렬화 문자열->자기껄로
				console.log(resp);
				console.log(fruits[0]);
			});
		})
		
		$("#ajax05").on("click", function(){
			$.ajax({
				url : "/exam05.ajax",
				dataType: "json" //방법1
			}).done(function(resp){ 
				console.log(resp);
			});
		})
		
		$("#ajax06").on("click", function(){
			$.ajax({
				url : "/exam06.ajax",
				dataType: "json"
			}).done(function(resp){ 
				console.log(resp);
			});
		})
		
		$("#ajax07").on("click", function(){
			$.ajax({
				url : "/exam07.ajax",
				dataType: "json"
			}).done(function(resp){ 
				console.log(resp);
			});
		})
	</script>

</body>
</html>