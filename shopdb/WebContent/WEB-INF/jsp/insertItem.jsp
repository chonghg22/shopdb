<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>아이템 추가</h3>
	<form method = "post" action = "">
		<div>
		Category_name:
		<select name = "categoryId">
			<option value = "">카테고리 선택</option>
			<c:forEach var ="c" items = "${list}">			
				<option value="${c.categoryId}">${c.categoryName }</option>
			</c:forEach>
		</select>
		</div>
		
		<div>
		item_name:
		<input type = "text" name = "itemName">
		</div>
		
		<div>
		item_price:
		<input type = "text" name = "itemPrice">
		</div>
		
		<div>
		item_contents:
		<input type = "text" name = "itemContents">
		</div>
		<div><button type = "submit">전송</button></div>	
	</form>
</body>
</html>