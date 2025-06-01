<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h1>Insert Page</h1>
<div class="container">
  <form  action="/insert" method="post">
    
    <label for="title" class="mb-2 mr-sm-2">TITLE:</label>
    <input type="text" class="form-control mb-2 mr-sm-2" id="title" placeholder="제목을 입력하세요...." name="title">
    <br/>

    <label for="content" class="mb-2 mr-sm-2">CONTENT:</label>
    <input type="text" class="form-control mb-2 mr-sm-2" id="content"  placeholder="내용을 입력하세요...." name="content">
    <br>
    
    <button type="submit" class="btn btn-primary mb-2"  >저장</button>&nbsp;&nbsp;
    <button type="reset" class="btn btn-info mb-2" >취소</button>
  </form>
</div>

</body>
</html>