<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- uri 주소가 너무 길어서 간단하게 적고싶다 : prefix -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!-- 맵핑작업 -->
<!DOCTYPE html>
<html lang="en">
<head>
<title>ordersList</title>
<meta charset="utf-8">
<link href="/blog/css/listForm.css" rel="stylesheet" media="all">
</head>
<body>
	<div>	
		<jsp:include page="/WEB-INF/views/inc/side.jsp"></jsp:include>
	</div>    	
    <h1>카테고리 목록</h1>   
	<table>
		<thead>
			<tr>
	       		<th>categoryId</th>
	       		<th>categoryName</th>  
	       		<th>수정</th>
	       		<th>추가</th>    
	       	</tr>
		</thead>
       	<tbody>
       	<c:forEach var = "c" items="${list}"> <!-- request.getAttribute("list") -->
       		<tr>
      			<td data-column="categoryId"> ${c.categoryId}</td>
      			<td data-column="categoryName">${c.categoryName}</td>
      			<td data-column="수정">
      				<a href="${pageContext.request.contextPath}/UpdateCategory?categoryId=${c.categoryId}">수정</a>
      			</td>
      			<td data-column="추가">
      				<a href = "${pageContext.request.contextPath}/InsertCategory">추가</a>
      			</td>      			
      	 	</tr>
      	 	</c:forEach>
		</tbody>
	</table>       
</body>
</html>