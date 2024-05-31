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
<style>
* {
	box-sizing: border-box;
}

.container, .title, .contents, .btns{
	border: 1px solid black;
}

.container {
	width: 1000px;
	height: 800px;
	margin: auto;
}

.col {
	display: flex;
	flex-direction: column;
}

.row {
	display: flex;
}

.text {
	display: flex;
	justify-content: center;
	align-items: center;
}

.title {
	flex: 0.5;
	background-color: lightgray;
}

.contents {
	flex: 9;
}

.btns {
	display: flex;
	flex: 0.5;
	justify-content: flex-end;
	/* 오른쪽 정렬 */
	align-items: center;
	padding-right: 10px;
}

.backlist {
	margin-left: 50%;
	/* 왼쪽 여백을 자동으로 설정하여 오른쪽으로 이동 */
}

.commentcontainer {
	padding-top: 20px;
    /* padding-bottom: 20px; */
    width: 1000px;
    height: 70px;
    margin: auto;
    /* margin-top: 20px; */
    margin-bottom: 20px;
	
}

.commenttextdiv {
	flex: 9;
	height: 50px;
}

.comment {
	height: 50px;
	border: 1px solid black;
}

.addcommentbtndiv {
	flex: 1;
}

.addcommentbtn {
	width: 90%;
	height: 90%;
}

.replycontainer {
	border: 1px solid black;
    width: 1000px;
    height: 100px;
    /* margin-top: 20px; */
    margin: auto;
    margin-top: 10px;
    margin-bottom: 10px;
    padding: 10px;
}

.replyupdatebtn{
	float: right;
}

.replydeletebtn{
	float: right;
}

.replydatetext{
	float: right;
}
</style>
</head>

<body>
	<div class="container col">
		<div class="title text" contenteditable="false">${dto.title}</div>
		<div class="contents" contenteditable="false">${dto.contents}</div>
		<div class="btns text">
			<c:choose>
				<c:when test="${loginID eq dto.writer}">
					<button id="updatebtn">수정</button>
					<button id="deletebtn">삭제</button>
				</c:when>
			</c:choose>
			<button class="backlist" type="button"
				onclick="location.href='/list.boards'">목록으로</button>
		</div>
	</div>
	<div class="commentcontainer row">
		<div class="commenttextdiv">
			<div class="comment" contenteditable="true"></div>
		</div>
		<div class="addcommentbtndiv text">
			<button class="addcommentbtn">등록</button>
		</div>
	</div>
	<!-- 댓글 목록을 반복하여 출력 -->
	<c:forEach var="reply" items="${replylist}">
		<c:if test="${reply.parent_seq == dto.seq}">
			<div class="replycontainer col" data-reply-seq="${reply.seq}">
				<div class="col1">${reply.writer} ${reply.write_date} <hr></div>
				<div class="col2" class="replycontents">${reply.contents}</div>
				<c:if test="${loginID eq reply.writer}">
					<div class="col3">
						<button class="replyupdatebtn">수정</button>
						<button class="replydeletebtn">삭제</button>
					</div>
				</c:if>
			</div>
		</c:if>
	</c:forEach>
	<script>
		$(".replyupdatebtn").on("click", function() {
			let replyContainer = $(this).closest('.replycontainer');
			let replySeq = replyContainer.data("reply-seq");
			let replyContents = replyContainer.find('.col2');
			updatebtn = $(this);
			deletebtn = $(this).next();

			if (updatebtn.html() == "수정") {
				replyContents.attr("contenteditable", "true"); //편집 열기
				updatebtn.html("완료");
				deletebtn.html("취소");

			} else if (updatebtn.html() == "완료") {
				replyContents.attr("contenteditable", "false"); //편집 닫기
				updatebtn.html("수정");
				deletebtn.html("삭제");

				// 제목과 내용의 정보를 폼 데이터로 옮겨서 POST 요청을 보냅니다.
				let form = $('<form>', {
					action : '/update.reply',
					method : 'post'
				}); // 동적  form 생성

				// 추가할 폼 데이터를 배열에 담습니다.
				let formData = [ $('<input>', {
						type : 'hidden',
						name : 'replyseq',
						value : replySeq
					}), $('<input>', {
						type : 'hidden',
						name : 'boardseq',
						value : '${dto.seq}'
					}), $('<input>', {
					type : 'hidden',
					name : 'replycontents',
					value : replyContents.html().trim()
				}) ];

				// 여러 개의 폼 데이터를 한꺼번에 추가합니다.
				form.append(formData);

				// 폼을 body에 추가하고 제출합니다.
				form.appendTo('body').submit();
			}

		})

		$(".replydeletebtn").on("click", function() {
			let replyContainer = $(this).closest('.replycontainer');
			let replySeq = replyContainer.data("reply-seq");
			let updatebtn = $(this).prev();
			let deletebtn = $(this);

			if (deletebtn.html() == "삭제") {
				let result = confirm("정말 삭제하시겠습니까?");
				if (result) {
					// 제목과 내용의 정보를 폼 데이터로 옮겨서 POST 요청을 보냅니다.
					let form = $('<form>', {
						action : '/delete.reply',
						method : 'post'
					}); // 동적  form 생성

					// 추가할 폼 데이터를 배열에 담습니다.
					let formData = [ $('<input>', {
						type : 'hidden',
						name : 'replyseq',
						value : replySeq
					}), $('<input>', {
						type : 'hidden',
						name : 'boardseq',
						value : '${dto.seq}'
					})];

					// 여러 개의 폼 데이터를 한꺼번에 추가합니다.
					form.append(formData);

					// 폼을 body에 추가하고 제출합니다.
					form.appendTo('body').submit();
				}
			} else if (deletebtn.html() == "취소") {
				location.href = "/detail.boards?seq=${dto.seq}";
			}

		})

		$(".addcommentbtn").on("click", function() {
			// 댓글 내용을 폼 데이터로 옮겨서 POST 요청을 보냅니다, 동적 form 생성
			let form = $('<form>', {
				action : '/add.reply',
				method : 'post'
			});

			// 추가할 폼 데이터를 배열에 담습니다.
			let formData = [ $('<input>', {
				type : 'hidden',
				name : 'writer',
				value : '${loginID}'
			}), $('<input>', {
				type : 'hidden',
				name : 'contents',
				value : $('.comment').html().trim()
			}), $('<input>', {
				type : 'hidden',
				name : 'parent_seq',
				value : '${dto.seq}'
			}) ];

			// 여러 개의 폼 데이터를 한꺼번에 추가합니다.
			form.append(formData);

			// 폼을 body에 추가하고 제출합니다.
			form.appendTo('body').submit();

		});

		$("#updatebtn").on("click", function() {
			updatebtn = $(this);
			deletebtn = $(this).next();

			if (updatebtn.html() == "수정") {
				$("div[contenteditable]").attr("contenteditable", "true");
				updatebtn.html("완료");
				deletebtn.html("취소");

				$(".title").on("keypress", function(e) {
					if (e.key == "Enter") {
						return false;
					}
				});

				$(".contents").on("keypress", function(e) {
					if (e.key == "Enter") {
						return false;
					}
				});

			} else if (updatebtn.html() == "완료") {
				$("div[contenteditable]").attr("contenteditable", "false");
				// 제목과 내용의 정보를 폼 데이터로 옮겨서 POST 요청을 보냅니다.
				let form = $('<form>', {
					action : '/update.boards',
					method : 'post'
				}); // 동적  form 생성

				// 추가할 폼 데이터를 배열에 담습니다.
				let formData = [ $('<input>', {
					type : 'hidden',
					name : 'seq',
					value : '${dto.seq}'
				}), $('<input>', {
					type : 'hidden',
					name : 'title',
					value : $('.title').html().trim()
				}), $('<input>', {
					type : 'hidden',
					name : 'contents',
					value : $('.contents').html().trim()
				}) ];

				// 여러 개의 폼 데이터를 한꺼번에 추가합니다.
				form.append(formData);

				// 폼을 body에 추가하고 제출합니다.
				form.appendTo('body').submit();
			}
		})

		$("#deletebtn").on("click", function() {
			updatebtn = $(this).prev();
			deletebtn = $(this);

			if (deletebtn.html() == "삭제") {
				let result = confirm("정말 삭제하시겠습니까?");
				if (result) {
					location.href = "/delete.boards?seq=${dto.seq}"
				}
			} else if (deletebtn.html() == "취소") {
				location.href = "/detail.boards?seq=${dto.seq}";
			}

		})
	</script>
</body>

</html>