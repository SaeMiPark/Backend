<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup Form</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
span {
	display: inline-block;
	width: 130px;
}

fieldset {
	padding-left: 25px;
	width: 400px;
	height: 600px;
	margin: auto;
}

legend {
	text-align: center;
	color: steelblue;
	font-size: x-large;
}

.join_btn {
	float: right;
}

input {
	height: 25px;
}

input:focus {
	background-color: lightgrey;
}

.container {
	margin: auto;
}
</style>
</head>
<body>
	<!-- ★submit event의 소스는 form 태그이다 -->
	<div class="container">
		<form action="/signup.members" id="join_form" method="post">
			<fieldset>
				<legend>회원가입</legend>
				<br>
				<div>
					<span>아이디</span><input name="id" class="input_id" type="text"
						placeholder="아이디">
					<button class="id_check" type="button">중복체크</button>
				</div>
				<br>
				<div>
					<span>패스워드</span><input name="pw" class="input_pw" type="password"
						placeholder="패스워드">
				</div>
				<br>
				<div>
					<span>패스워드 확인</span><input name="pw2" class="input_pw2"
						type="password" placeholder="패스워드 재입력">
				</div>
				<div class="pwcheck" style="display: none;"></div>
				<br>
				<div>
					<span>이름</span><input name="name" class="input_name" type="text"
						placeholder="이름">
				</div>
				<br>
				<div>
					<span>전화번호</span><input name="phone" class="input_phone"
						type="text" placeholder="전화번호">
				</div>
				<br>
				<div>
					<span>이메일</span><input name="email" class="input_email" type="text"
						placeholder="이메일">
				</div>
				<br>
				<div>
					<span>우편번호</span><input name="zipcode" class="zonecode" type="text"
						placeholder="우편번호" readonly>
					<button type="button" class="juso_btn">검색</button>
				</div>
				<br>
				<div>
					<span>기본주소</span><input name="address1" class="basicaddress"
						type="text" placeholder="기본주소" readonly>
				</div>
				<br>
				<div>
					<span>상세주소</span><input name="address2" class="detailaddress"
						type="text" placeholder="상세주소">
				</div>
				<br> <br>
				<button type="submit" class="join_btn"
					style="background-color: steelblue; color: white;">가입하기</button>
				<button type="button" class="back_btn"
					onclick="location.href='/index.jsp'"
					style="background-color: steelblue; color: white;">BACK</button>
			</fieldset>
		</form>
	</div>

	<script>
		let didIdCheck = false;
		
		//focusout, input, keyup
		//id 중복 체크 버튼 기능
		$(".id_check").on("click", function() {
			let id = $(".input_id");
			//id유효성체크
			if (id.val() == "") {
				alert("id를 먼저 입력해주세요.");
				return false;
			} else {
				let regexid = /[a-z0-9_]{8,}/;
				let resultid = regexid.test(id.val());
				if (resultid == false) {
					alert("유효하지 않은 id입니다.");
					return false;
				}
				//window.open("/idcheck.members?id=" + id.val(), "",
				//	"width=300, height=300");
				$.ajax({
					url : "/idcheck.members",
					type : "post",
					data : {id : id.val()},
					dataType: "json"
				}).done(function(result){
					console.log(result);
					if (result) {  
						alert("이미 사용 중인 ID입니다.");
	                } else {
	                    alert("사용 가능한 ID입니다.");
	                }
				});
			}
		})

		//주소 검색 기능
		$(".juso_btn").on("click", function() {
			new daum.Postcode({
				oncomplete : function(data) {
					$(".zonecode").val(data.zonecode);
					$(".basicaddress").val(data.jibunAddress);
				}
			}).open();
		})

		//가입하기 기능
		$("#join_form")
				.on(
						"submit",
						function() {

							//id유효성체크
							if ($(".input_id").val() == "") {
								alert("아이디를 입력해주세요.");
								return false;
							} else {
								let regexid = /[a-z0-9_]{8,}/;
								let resultid = regexid.test($(".input_id")
										.val());
								if (resultid == false) {
									alert("유효하지 않은 id입니다.");
									return false;
								}
							}

							//id중복체크 확인
							if (didIdCheck == false) {
								alert("ID 중복 체크를 확인하세요.");
								return false;
							}

							//pw유효성 체크
							if ($(".input_pw").val() == "") {
								alert("패스워드를 입력해주세요.");
								return false;//e.preventDefault();
							} else {
								let regexpw = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
								let resultpw = regexpw.test($(".input_pw")
										.val());
								if (resultpw == false) {
									alert("유효하지 않은 pw입니다.");
									return false;
								}
							}

							//pw확인 유효성 체크
							if ($(".input_pw2").val() == "") {
								alert("패스워드 확인을 입력해주세요.");
								return false;//e.preventDefault();
							} else {
								let regexpw2 = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
								let resultpw2 = regexpw2.test($(".input_pw2")
										.val());
								if (resultpw2 == false) {
									alert("유효하지 않은 패스워드 확인입니다.");
									return false;
								}
							}

							//이름 유효성 체크
							if ($(".input_name").val() == "") {
								alert("이름을 입력해주세요.");
								return false;//e.preventDefault();
							} else {
								let regexn = /^[가-힣]{2,5}$/;
								let resultn = regexn.test($(".input_name")
										.val());
								if (resultn == false) {
									alert("유효하지 않은 이름입니다.");
									return false;
								}
							}

							//전화번호 유효성 체크
							if ($(".input_phone").val() != "") {
								let regexp = /01[\d]-?\d{4}-?\d{4}/;
								let resultp = regexp.test($(".input_phone")
										.val());
								if (resultp == false) {
									alert("유효하지 않은 번호입니다.");
									return false;
								}
							}

							//이메일 유효성 체크
							if ($(".input_email").val() != "") {
								let regexe = /.+?@.+?\.com/;
								let resulte = regexe.test($(".input_email")
										.val());
								if (resulte == false) {
									alert("유효하지 않은 이메일입니다.");
									return false;
								}
							}
						})

		//패스워드 확인 기능 
		$(".input_pw2").on("keyup", function(e) {
			let pw = $(".input_pw");
			let pw2 = $(".input_pw2");
			let pwcheck = $(".pwcheck");

			if (pw.val() == pw2.val()) {
				pwcheck.html("패스워드가 일치합니다.").css("color", "green");
				pwcheck.css("display", "block");
			} else {
				pwcheck.html("패스워드가 다릅니다.").css("color", "red");
				pwcheck.css("display", "block");
				return false;
			}

			setTimeout(function() {
				pwcheck.remove();
			}, 3000);

		})
	</script>
</body>
</html>