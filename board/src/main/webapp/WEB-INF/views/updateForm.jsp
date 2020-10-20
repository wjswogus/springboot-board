<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>

<main>
	<form>

		<div>
			Title:
			 <input type="text"
				value="${board.title}" placeholder="title"
				id="title">
		</div>

		<div>
			Content:
			<textarea rows="5" id="summernote">${board.content}</textarea>
		</div>

		<button type="button" onclick="updateBoard(${board.id})" >수정하기</button>
	</form>
</main>

<script>
function updateBoard(id){
	// id, title, content
	let title = document.querySelector("#title").value;
	let content = document.querySelector("#summernote").value;
;


	let board = {
		title: title,
		content: content
	};

	fetch("/board/"+id, {
		method: "put",
		headers: {
			'Content-Type': 'application/json; charset=utf-8',
		},
		body: JSON.stringify(board)
	}).then(res=> res.text())
	.then(res=> {
		if(res=="ok"){
			alert("수정완료");
			location.href="/board/"+id;
		}else{
			alert("수정실패");
		}
	});

	console.log(board);
}

  $(document).ready(function() {
      $('#summernote').summernote({
    	  tabsize: 2,
          height: 300
      });
  });
</script>

<%@ include file="layout/footer.jsp"%>


