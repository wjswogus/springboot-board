<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>

<main>
	<button onclick= "location.href = '/updateForm/${board.id}' ">수정</button>
	<button onclick="deleteBoard(${board.id})">삭제</button>

	<br /> <br />
	<h6>
		조회수 : <i>${board.readCount}</i>
	</h6>
	<br />
	제목
	<h3>${board.title}</h3>
	<hr />
	내용
	<h5>${board.content}</h5>

	<hr />

</main>

<script>
	

	function deleteBoard(id){
		fetch("/board/"+id, {
			method: "delete"
		}).then(res=> res.text())
		.then(res=> {
			if(res=="ok"){
				alert("삭제성공");
				location.href = "/list";
			}else{
				alert("삭제실패");
			}
		});
	}
</script>


<%@ include file="layout/footer.jsp"%>