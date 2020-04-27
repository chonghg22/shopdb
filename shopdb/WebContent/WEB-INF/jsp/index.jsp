<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>index</h1>
<ol>
<!-- category CRU -->
<li><a href = "${pageContext.request.contextPath}/CategoryList">카테고리 관리</a></li>
<!-- item CRU -->
<li><a href = "${pageContext.request.contextPath}/CategoryList">상품 관리</a></li>
<!-- orders RUD -->
<li><a href = "${pageContext.request.contextPath}/CategoryList">주문 관리</a></li>
</ol>
</body>
</html>