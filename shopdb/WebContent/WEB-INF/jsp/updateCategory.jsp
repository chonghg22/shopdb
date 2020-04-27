<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>카테고리 수정</h1>
	<form method = "post" action = "${pageContext.request.contextPath}/UpdateCateogry">
	<div>
	CategoryId:
	<input type = "text" name = "categoryId" value = "${c.categoryId}" readonly>
	</div>
	<div>
	CategoryName:
	<input type = "text" name = "categoryName" value = "${c.categoryName}">
	</div>
	<div><button type = "submit">전송</button></div>
	</form>
	
	<!-- ${c.categoryId}  update controller에서 request.setAttribute("c", category);에 "(c)"값이랑 동일해야함 -->

</body>
</html>