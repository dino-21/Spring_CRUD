<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<!-- ${list}  -->
	<div class="container">
		<h2>list</h2>
		<button type="button" class="btn btn-info mb-2  float-right"
			onclick="window.location.href='insert'">등록</button>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>TITLE</th>
					<th>CONTENT</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${list}">
					<tr>
						<td>${list.id}</td>
						<td><a href="/read?id=${list.id}">${list.title}</a></td>
						<td>${list.content}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		  <h3>${msg}</h3>
	</div>
</body>
</html>