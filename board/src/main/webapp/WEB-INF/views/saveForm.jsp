<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>



<h1>글쓰기 페이지</h1>
<hr />
<form action="/save" method="post">
	제목 : <input id="title" type="text" name="title"><br />
	<textarea id="summernote" name="content"></textarea>
	<button onClick="saveBoard(this.form)">업로드</button>
</form>


<script>
	function saveBoard(frm){
		let title = document.querySelector("#title").value;
//		let content = document.querySelector("#content").value;
		let content = frm.content.value;

		
		let board ={
				title: title,
				content: content,
			};
		
		fetch("/save",{
			method: "post",
			headers: {'Content-Type' : 'application/json; charset=utf-8',
			},
			body : JSON.parse(board),
		}).then(res=> res.text())
		.then(res=> {
			if(res == "ok"){
				alert("등록완료");
				location.reload();
			}
			else{
				alert("등록실패");
			}	
		});

	}

	$(document).ready(function() {
		  $('#summernote').summernote({
	 	    	placeholder: 'content',
		        minHeight: 370,
		        maxHeight: null,
		        focus: true, 
		        lang : 'ko-KR'
		  });
		});
</script>

<%@ include file="layout/footer.jsp"%>
