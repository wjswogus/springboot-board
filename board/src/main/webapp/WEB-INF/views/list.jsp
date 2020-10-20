<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>

<main>
	<h1>게시글목록</h1>
	<hr />
	<table border="1">
		<tr>
			<td>ID</td>
			<td>TITLE</td>
			<td>CREATEDATE</td>
		</tr>
		<c:forEach var="board" items="${boards.content }">
			<tr>
				<td>${board.id }</td>
				<td><a href="/board/${board.id }">${board.title }</a></td>

				<td>${board.createDate }</td>
			</tr>
		</c:forEach>
	</table>
	<br />

	<p>현재 페이지 : ${boards.pageable.pageNumber }</p>
	<button
		onClick="location.href='/list?page=${boards.pageable.pageNumber-1 }'">PREV</button>
	<button
		onClick="location.href='/list?page=${boards.pageable.pageNumber+1 }'">NEXT</button>
	<br /> <br />

</main>


<%@ include file="layout/footer.jsp"%>