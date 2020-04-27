<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- uri 주소가 너무 길어서 간단하게 적고싶다 : prefix -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!-- 맵핑작업 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>카테고리 목록</h1>
	<a href = "${pageContext.request.contextPath}/InsertCategory">추가</a>
	
	<table border = "1">
		<tr>
			<th>category_id</th>
			<th>category_name</th>
			<th>수정</th>
			
		</tr>
		
		<c:forEach var = "c" items="${list}"> <!-- request.getAttribute("list") -->
			<tr>
				<td>${c.categoryId}</td>
				<td>${c.categoryName}</td>
				<td><a href="${pageContext.request.contextPath}/UpdateCategory?categoryId=${c.categoryId}">수정</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<c:if test="${3>2}">
		<div>hi</div>
	</c:if>
							<!-- jstl은 else가 없어서 if문은 2번 작성 -->
	<c:if test="${2>2}">
		<div>bye</div>
	</c:if>
</body>
</html>