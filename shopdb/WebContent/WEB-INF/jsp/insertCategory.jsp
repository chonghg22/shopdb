<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Category Form</title>
</head>
<body>

<h3> 카테고리 입력</h3>

	<form method = "post" action = "<%=request.getContextPath()%>/InsertCategory">
		<div>
		 카테고리 이름
		 <input type = "text" name = "categoryName">
		</div>
		<button type = "submit">추가</button>
	</form>

</body>
</html>