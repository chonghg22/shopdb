<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 목록</h1>
	<a href = "${pageContext.request.contextPath}/InsertItem">상품입력</a>
	<c:if test= "${list == null }">
		상품이 없습니다.
	</c:if>
	<c:if test = "${list !=null }">
		<table border = "1">
			<thead>
				<tr>
					<th>item_id</th>
					<th>category_id</th>
					<th>item_name</th>
					<th>item_price</th>
					<th>item_contents</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${list}">
					<tr>
						<td>${c.itemId}</td>
						<td>${c.categoryId}</td>
						<td>${c.itemName}</td>
						<td>${c.itemPrice}</td>
						<td>${c.itemContents}</td>
					
					</tr>
				</c:forEach>	
			</tbody>	
		</table>
		
	</c:if>
</body>
</html>