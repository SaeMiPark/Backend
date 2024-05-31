<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mypage</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
table {
	margin: auto;
	width: 250px;
	text-align: center;
}

input {
	width: 95%;
	height: 100%;
	border: none;
}
</style>
</head>
<body>
	<form action="/update.members" method="post">
		<table border=1>
			<tr>
				<th colspan="2">MyPage</th>
			</tr>
			<tr>
				<td>이름</td>
				<td><input name="hiddenname" id="hiddenname"
					value="${dto.name}" readonly></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input name="hiddenid" id="hiddenid" value="${dto.id}"
					disabled></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input name="hiddenphone" id="hiddenphone"
					value="${dto.phone}" readonly></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input name="hiddenemail" id="hiddenemail"
					value="${dto.email}" readonly></td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td><input name="hiddenzipcode" id="hiddenzipcode"
					value="${dto.zipcode}" readonly></td>
			</tr>
			<tr>
				<td>기본주소</td>
				<td><input name="hiddenaddress1" id="hiddenaddress1"
					value="${dto.address2}" readonly></td>
			</tr>
			<tr>
				<td>상세주소</td>
				<td><input name="hiddenaddress2" id="hiddenaddress2"
					value="${dto.address2}" readonly></td>
			</tr>
			<tr>
				<td>가입일</td>
				<td><fmt:formatDate value="${dto.join_date}"
						pattern="yyyy.MM.dd"></fmt:formatDate></td>
			</tr>
			<tr>
				<th colspan="2">
					<button id="update" type="submit">수정</button>
					<button id="home" type="button">홈</button>
				</th>
			</tr>
		</table>
	</form>

	<script>
		$("#update").on("click", function() {
			updatebtn = $(this);
			homebtn = $(this).next();

			if (updatebtn.html() == "수정") {
				$("input").removeAttr("readonly");
				updatebtn.html("완료");
				homebtn.html("취소");
				return false;

			} else if (updatebtn.html() == "완료") {
				//이름 유효성 체크
				if ($("#hiddenname").val() == "") {
					alert("이름을 입력해주세요.");
					return false;//e.preventDefault();
				} else {
					let regexn = /^[가-힣]{2,5}$/;
					let resultn = regexn.test($("#hiddenname").val());
					if (resultn == false) {
						alert("유효하지 않은 이름입니다.");
						return false;
					}
				}

				//전화번호 유효성 체크
				if ($("#hiddenphone").val() != "") {
					let regexp = /01[\d]-?\d{4}-?\d{4}/;
					let resultp = regexp.test($("#hiddenphone").val());
					if (resultp == false) {
						alert("유효하지 않은 번호입니다.");
						return false;
					}
				}

				//이메일 유효성 체크
				if ($("#hiddenemail").val() != "") {
					let regexe = /.+?@.+?\.com/;
					let resulte = regexe.test($("#hiddenemail").val());
					if (resulte == false) {
						alert("유효하지 않은 이메일입니다.");
						return false;
					}
				}
				
				$("input").attr("readonly", "readonly");
			}
		});

		$("#home").on("click", function() {
			updatebtn = $(this).prev();
			homebtn = $(this);

			if (homebtn.html() == "홈") {
				location.href = "/index.jsp";
			} else if (homebtn.html() == "취소") {
				location.href = "/mypage.members";
			}

		})
	</script>
</body>
</html>