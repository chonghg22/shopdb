<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/blog/css/listForm.css" rel="stylesheet" media="all">
</head>
<body>
<div>		
	<jsp:include page="/WEB-INF/views/inc/side.jsp"></jsp:include>
	</div>
	<h1>상품 목록</h1>
	<a href = "${pageContext.request.contextPath}/InsertItem">상품입력</a>
	<c:if test= "${list == null }">
		상품이 없습니다.
	</c:if>
	<c:if test = "${list !=null }">
		<table>
			<thead>
				<tr>
					<th>itemId</th>
					<th>categoryId</th>
					<th>itemName</th>
					<th>itemPrice</th>
					<th>itemContents</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${list}">
					<tr>
						<td data-column="itemId">${c.itemId}</td>
						<td data-column="categoryId">${c.categoryId}</td>
						<td data-column="itemName">${c.itemName}</td>
						<td data-column="itemPrice">${c.itemPrice}</td>
						<td data-column="itemContents">${c.itemContents}</td>					
					</tr>
				</c:forEach>	
			</tbody>	
		</table>
		
	</c:if>
</body>
</html>